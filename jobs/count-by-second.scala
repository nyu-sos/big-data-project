val dataFile = "sos-311.csv";
val df = spark.read.format("com.databricks.spark.csv").option("header", "true").load(dataFile);

df.groupBy("Created Date").count()
    .withColumnRenamed("count", "n")
    .write.format("csv")
    .save(s"project/count-by-second.csv")

System.exit(0)