#coding=utf-8
#import sys
#reload(sys)
#sys.setdefaultencoding('utf-8')
#from __future__ import print_function

import sys
from operator import add
from pyspark import SparkContext
from csv import reader

all_cate = [3,4,5,6,7,8,15,16,17,18,19,22,23,26,27,28,31,34,35,36,39,40,42,
            43,44,46,47,48,]

def make_unicode(input):
        if type(input) != unicode:
            input =  input.decode('utf-8', 'ignore')
            return input
        else:
            return input


if __name__ == "__main__":
    sc = SparkContext()
    rdd = sc.textFile("sos-311.csv")
    rdd = rdd.mapPartitions(lambda x: reader(x))
    for i in all_cate:
        print "NOW DOING:", i
        rdd1 = rdd.map(lambda x:(x[i].encode('utf-8'), 1))
        rdd1 = rdd1.reduceByKey(add)
        rdd1 = rdd1.map(lambda x: x.encode('ascii',"ignore"))
        rdd1.saveAsTextFile("cate_"+str(i)+".txt")
        print "==============================="
        print "==============================="
        print "==============================="
        print "==============================="
        print "==============================="
    sc.stop()
