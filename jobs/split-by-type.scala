/* SimpleApp.scala */
//import org.apache.spark.SparkContext
//import org.apache.spark.SparkContext._
//import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object sosSplit {
  def main(args: Array[String]) {
    val dataFile = "sos-311.csv";

    val spark = SparkSession
        .builder()
        .appName("SOS - 311 - Split")
        .getOrCreate();

    val df = spark.read
        .format("com.databricks.spark.csv")
        .option("header", "true") 
        .load(dataFile);

    // df.printSchema()
    
    val agencies = df.select("Agency")
        .distinct.collect.flatMap(_.toSeq);

    val byAgencyDFs = agencies.map(
      agency => ( agency ->
          df.where($"Agency" <=> agency)
            .write.format("csv").save(s"project/Agency-$agency.csv")
        )
    ).toMap;

  }
}