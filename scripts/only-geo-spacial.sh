#!/bin/bash

./scripts/spark.sh jobs/only-geo-spacial.scala
hfs -getmerge project/sos-only.csv data/sos-only.csv