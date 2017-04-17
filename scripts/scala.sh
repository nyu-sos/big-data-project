#!/bin/bash

spark2-shell \
 --jars /opt/cloudera/parcels/CDH/jars/commons-lang3-3.1.jar \
 --conf spark.driver.extraJavaOptions="-Dscala.color" \
 --conf spark.yarn.user.classpath.first=true\
 -i $1
