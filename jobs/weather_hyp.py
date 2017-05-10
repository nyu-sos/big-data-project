import sys
from operator import add
from pyspark import SparkContext
from csv import reader
import datetime
try:
    import pandas as pd
    import numpy as np
except:
    pass

# nyc avg temperture, data credit to http://www.usclimatedata.com/climate/new-york/united-states/3202
nyc_avg_temp = [ [38, 42, 50, 61, 71, 79, 84, 83, 75, 64, 54, 43, 62,],
        [27, 29, 35, 45, 54, 64, 69, 68, 61, 50, 42, 32, 48,], ]

if __name__ == "__main__":
    sc = SparkContext()
    rdd = sc.textFile("sos-311.csv")
    rdd = rdd.mapPartitions(lambda x: reader(x))
    def remove_header(itr_index, itr):
        return iter(list(itr)[1:]) if itr_index == 0 else itr
    rdd.mapPartitionsWithIndex(remove_header)
    rdd.map(lambda x: x[1]).groupByKey()
    rdd.collct()

