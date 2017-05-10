val dataFile = "sos-311.csv";

val df = spark.read.format("com.databricks.spark.csv").option("header", "true").load(dataFile);

df.select($"Created Date", $"Complaint Type", $"Latitude", $"Longitude").write.format("csv").option("header", "true").save(s"project/sos-only.csv")

System.exit(0)
