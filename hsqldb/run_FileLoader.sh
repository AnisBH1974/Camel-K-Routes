#!/bin/bash


camel run SimpleCSVReader.camel.xml \
     --dep org.hsqldb:hsqldb:2.6.1,org.apache.camel:camel-jdbc:3.11.1,com.zaxxer:HikariCP:4.0.3,org.apache.camel:camel-csv:3.11.1

