val dataFile = "sos-311.csv";

val df = spark.read.format("csv").option("header", "true").load(dataFile);

val colName = "Agency Name"
df.select(colName).map(row => s"$row DATETIME $colName VALID").write.format("csv").option("header", "true").save(s"project/label-$colName.csv")



System.exit(0)
