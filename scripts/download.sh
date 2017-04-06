#!/bin/bash

mkdir -p data

# wget https://data.cityofnewyork.us/api/views/9s88-aed8/rows.csv?accessType=DOWNLOAD -O data/311.2009.csv
# wget https://data.cityofnewyork.us/api/views/wpe2-h2i5/rows.csv?accessType=DOWNLOAD -O data/311.2010-2016.csv
wget https://data.cityofnewyork.us/api/views/p6vy-ufwu/rows.csv?accessType=DOWNLOAD -O data/311.csv
