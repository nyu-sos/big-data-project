#!/bin/bash

projectDir="project/"
. ./scripts/setup-env.sh
/usr/bin/hadoop fs -put ./data/311.csv sos-311.csv
./scripts/split.sh
lines=$(/usr/bin/hadoop fs -ls -d $projectDir/Agency-*.csv | awk '{print $8}')
for file in $lines; do
    /usr/bin/hadoop fs -getmerge $file data/$file
done
mv data/$projectDir/Agency-*.csv data/Agency/
rm -r data/$projectDir
