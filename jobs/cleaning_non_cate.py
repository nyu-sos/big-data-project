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
    x = x.strip()
    if len(x)==0:
        return True
    if x[:2] == 'NA' or x=='N/A' or x == "NULL" or x == "null":
        return True
    if x == "0 Unspecified" or x == "Unspecified" or x == 'Other':
        return True
    return False

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

def is_latitude_valid(l):
    try:
        l = float(l)
        return -75< l < -73
    except:
        return False

def is_longitude_valid(l):
    try:
        l = float(l)
        return 40< l < 42
    except:
        return False

if __name__ == "__main__":
    sc = SparkContext()
    rdd = sc.textFile("sos-311.csv")
    rdd = rdd.mapPartitions(lambda x: reader(x))
    def remove_header(itr_index, itr):
        return iter(list(itr)[1:]) if itr_index == 0 else itr
    rdd.mapPartitionsWithIndex(remove_header)

    # Unique Key
    i = 0
    cleaner = cleaner_factory(is_null, lambda x: return True, "INT", "Unique Key")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    # Created Date
    i = 1
    cleaner = cleaner_factory(is_null, is_date_valid, "DATETIME", "Created Date")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    # Closed Date
    i = 2
    cleaner = cleaner_factory(is_null, is_date_valid, "DATETIME", "Closed Date")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    # Agency Name
    i = 4
    cleaner = cleaner_factory(is_null, lambda x: return True, "TEXT", "Agency Name")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 9
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Incident Address")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 10
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Street Name")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 11
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Cross Street 1")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 12
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Cross Street 2")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 13
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Intersection Street 1")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 14
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Intersection Street 2")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 20
    cleaner = cleaner_factory(is_null, is_date_valid, "DATETIME", "Resolution Action Updated Date")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 24
    cleaner = cleaner_factory(is_null, lambda x : return True, "CORDINATE", "X Coordinate")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 25
    cleaner = cleaner_factory(is_null, lambda x : return True, "CORDINATE", "Y Coordinate")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 29
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "School Number")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 30
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "School Region")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 32
    cleaner = cleaner_factory(is_null, lambda x : return True, "PHONE", "School Phone Number")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 33
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "School Address")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 37
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "School Not Found")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 38
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "School Or Citywide Complaint")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 41
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Taxi Pickup Location")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 45
    cleaner = cleaner_factory(is_null, lambda x : return True, "TEXT", "Bridge Highway Segment")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 49
    cleaner = cleaner_factory(is_null, is_latitude_valid, "CORDINATE", "Latitude")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 50
    cleaner = cleaner_factory(is_null, is_longitude_valid, "CORDINATE", "Longtitude")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    i = 51
    cleaner = cleaner_factory(is_null, lambda x : return True, "CORDINATES", "Location")
    rdd1 = rdd.map(lambda x: cleaner(x[i]))
    rdd1.saveAsTextFile('non'+str(i))

    sc.stop()
