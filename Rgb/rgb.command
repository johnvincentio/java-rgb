#!/bin/sh
#
# script to run java app rgb slider
#
DEV_HOME=/Users/jv/Desktop/MyDevelopment/github/java/Utilities/java-rgb/Rgb
#
cd $DEV_HOME
#
MYCP=$DEV_HOME/classes:$DEV_HOME/Jars/log4j-1.2.13.jar
#
java -cp $MYCP -Xdock:name="RGB Color Helper" io.johnvincent.rgb.App
#
