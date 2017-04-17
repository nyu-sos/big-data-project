#coding=utf-8
#import sys
#reload(sys)
#sys.setdefaultencoding('utf-8')
#from __future__ import print_function

import sys
from operator import add
from pyspark import SparkContext
from csv import reader
import datetime

def cleaner_factory(f_null, f_invalid, T, D):
    def f(x):
        x = str(x)
        res = ''
        try:
            if f_null(x):
                res = "NULL"
            elif f_invalid(x):
                res = "INVALID"
            else:
                res = "VALID"
        except:
            res = "INVALID"
        return x + ' ' + T + ' ' + D + ' ' + res
    return f

def is_null(x):
    return len(x)==0

def is_date_valid(s):
    d = datetime.strptime(s, '%m/%d/%Y %h:%M:%S %p')
    try:
        time.strptime(this_date, '%m/%d/%Y')
    except:
        return False
    else:
        if datetime.date(year=2010,month=1,day=1) <= d < datetime.date(year=1017,month=1,day=1):
            return True
        else:
            return False

if __name__ == "__main__":
    sc = SparkContext()
    rdd = sc.textFile("sos-311.csv")
    rdd = rdd.mapPartitions(lambda x: reader(x))
    def remove_header(itr_index, itr):
        return iter(list(itr)[1:]) if itr_index == 0 else itr
    rdd.mapPartitionsWithIndex(remove_header)

    # Created Date
    i = 1
    cleaner = cleaner_factory(is_null, is_date_valid, "DATETIME", "Created Date")
    rdd1 = rdd.map(lambda x:cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    sc.stop()
