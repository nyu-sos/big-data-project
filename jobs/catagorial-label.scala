val dataFile = "sos-311.csv";

val df = spark.read.format("csv").option("header", "true").load(dataFile);

val colName = "Agency"
df.select(colName).map(row => s"$row TEXT $colName VALID").write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Agency Name"
df.select(colName).map(row => s"$row TEXT $colName VALID").write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Ferry Terminal Name"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Ferry Direction"
df.select(colName).map(row => s"$row TEXT $colName VALID").write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Garage Lot Name"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Road Ramp"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Bridge Highway Name"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Bridge Highway Direction"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Taxi Company Borough"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Vehicle Type"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Bridge Highway Name"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "School Zip"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "School State"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "School City"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "School Code"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "School Name"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Bridge Highway Name"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Park Borough"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Park Facility Name"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Borough"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Community Board"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Status"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Facility Type"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Landmark"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "City"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Address Type"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Incident Zip"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Location Type"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Descriptor"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")

val colName = "Complaint Type"
df.select(colName).map(row => {
	val state = "VALID"
	if row == ""{
		state = "NULL"
	}
	return s"$row TEXT $colName $state"
}).write.format("csv").option("header", "true").save(s"project/label-$colName.csv")


System.exit(0)
