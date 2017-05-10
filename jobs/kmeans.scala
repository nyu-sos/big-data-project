val dataFile = "sos-311.csv";
val df = spark.read.format("com.databricks.spark.csv").option("header", "true").load(dataFile);

import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DoubleType

val fmt = "MM/dd/yyyy hh:mm:ss a"
val subdf = df.select($"Unique Key", $"Agency", df("Latitude").cast(DoubleType).as("Latitude"), $"Longitude".cast(DoubleType).as("Longitude"), $"Created Date");

// subdf.select($"Unique Key", $"Latitude", $"Longitude", $"Created Date", unix_timestamp($"Created Date", fmt).as("Unix Time") ).show()

val R = 6378000.0
val geodf = subdf.select($"Unique Key", $"Agency" , $"Latitude", $"Longitude", (cos($"Latitude"/180)*cos($"Longitude"/180)*R).as("X"), (cos($"Latitude"/180)*sin($"Longitude"/180)*R).as("Y"), unix_timestamp($"Created Date", fmt).as("Unix Time") );

// root
//  |-- Unique Key: string (nullable = true)
//  |-- Latitude: double (nullable = true)
//  |-- Longitude: double (nullable = true)
//  |-- X: double (nullable = true)
//  |-- Y: double (nullable = true)
//  |-- Unix Time: long (nullable = true)


import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
// val bcClusters = sc.broadcast(clusters)
// def predict(x: Double, y: Double, t: Double): Int = {
//     bcClusters.value.predict(Vectors.dense(x, y, t))
// }
// sqlContext.udf.register("predict", predict _)

val infoSpeed = 1.4 // in m/s

val assembler = new VectorAssembler().setInputCols(Array("X", "Y", "Info Time")).setOutputCol("features")
val input = assembler.transform( geodf.select($"Unique Key", $"Agency", $"X", $"Y", ($"Unix Time" * infoSpeed).as("Info Time") ) )
val kmeans = new KMeans().setK(2).setSeed(1L)
val model = kmeans.fit(input)
//val predictionResult = model.transform(input)

val WSSSE = model.computeCost(dataset)
println(s"Within Set Sum of Squared Errors = $WSSSE")

println("Cluster Centers: ")
model.clusterCenters.foreach(println)