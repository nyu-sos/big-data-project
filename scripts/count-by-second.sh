#!/bin/bash

./scripts/spark.sh jobs/count-by-second.scala
hfs -getmerge project/count-by-second.csv data/count-by-second.csv
