#!/bin/bash

rsync -uav jobs scripts main.sh dumbo:$1
