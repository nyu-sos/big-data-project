val dataFile = "sos-311.csv";

//val spark = SparkSession.builder().appName("SOS - 311 - Split").getOrCreate();

val df = spark.read.format("com.databricks.spark.csv").option("header", "true").load(dataFile);
val all_cate: Array[String] = Array("Agency", "Agency Name", "Complaint Type", "Descriptor", "Location Type", "Incident Zip", "Address Type", "City", "Landmark", "Facility Type", "Status", "Community Board", "Borough", "Park Facility Name", "Park Borough", "School Name", "School Code", "School City", "School State", "School Zip", "Vehicle Type", "Taxi Company Borough", "Bridge Highway Name", "Bridge Highway Direction", "Road Ramp", "Garage Lot Name", "Ferry Direction", "Ferry Terminal Name")
// df.printSchema()

all_cate.map(cateName => df.groupBy(cateName).count().sort("count").show(99999))

System.exit(0)
