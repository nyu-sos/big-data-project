#!/bin/bash

alias hfs='/usr/bin/hadoop fs '
spark2 (){
  if [[ $# = 0 ]]
  then
    spark2-shell --jars /opt/cloudera/parcels/CDH/jars/commons-lang3-3.3.2.jar --conf spark.driver.extraJavaOptions="-Dscala.color" --conf spark.yarn.user.classpath.first=true
  else
    spark2-shell --jars /opt/cloudera/parcels/CDH/jars/commons-lang3-3.3.2.jar --conf spark.driver.extraJavaOptions="-Dscala.color" --conf spark.yarn.user.classpath.first=true --conf spark.ui.port=$1
  fi
}
