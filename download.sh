#!/bin/bash

mkdir -p data

wget https://data.cityofnewyork.us/api/views/3rfa-3xsf/rows.csv?accessType=DOWNLOAD -O data/311.2009.csv
wget https://data.cityofnewyork.us/api/views/erm2-nwe9/rows.csv?accessType=DOWNLOAD -O data/311.2010-2016.csv
