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
