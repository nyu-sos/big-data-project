import sys
from operator import add
from pyspark import SparkContext
from csv import reader

import datetime
import time
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

if __name__ == "__main__":
    start_time = time.time()
    rdd = spark.read.csv("311.csv", header=True, mode="DROPMALFORMED", schema=schema)
    print("Read time:", time.time()-start_time)
    print(rdd['Agency'].value_counts())
