#!/bin/bash

projectDir="project/"
. ./scripts/setup-env.sh
hfs -put ./data/311.csv sos-311.csv
./scripts/split.sh
lines=$(hfs -ls -d $projectDir/Agency-*.csv | awk '{print $8}')
for file in $lines; do
    hfs -getmerge $file data/$file
done
mv data/$projectDir/Agency-*.csv data/Agency/
rm -r data/$projectDir

# Deal with non categorial attrs
module load python/gnu/3.4.4
export PYSPARK_PYTHON=/share/apps/python/3.4.4/bin/python
export PYTHONHASHSEED=0
export SPARK_YARN_USER_ENV=PYTHONHASHSEED=0
spark2-submit --jars /opt/cloudera/parcels/CDH/jars/commons-lang3-3.1.jar  jobs/cleaning_non_cate.py
# get all merged non cat results to local
hfs -getmerge non0 0.txt
hfs -getmerge non1 1.txt
hfs -getmerge non2 2.txt
hfs -getmerge non4 4.txt
hfs -getmerge non9 9.txt
hfs -getmerge non10 10.txt
hfs -getmerge non11 11.txt
hfs -getmerge non12 12.txt
hfs -getmerge non13 13.txt
hfs -getmerge non14 14.txt
hfs -getmerge non20 20.txt
hfs -getmerge non24 24.txt
hfs -getmerge non25 25.txt
hfs -getmerge non29 29.txt
hfs -getmerge non30 30.txt
hfs -getmerge non32 32.txt
hfs -getmerge non33 33.txt
hfs -getmerge non37 37.txt
hfs -getmerge non37 37.txt
hfs -getmerge non38 38.txt
hfs -getmerge non41 41.txt
hfs -getmerge non45 45.txt
hfs -getmerge non49 49.txt
hfs -getmerge non50 50.txt
hfs -getmerge non51 51.txt
hfs -getmerge non51 51.txt
