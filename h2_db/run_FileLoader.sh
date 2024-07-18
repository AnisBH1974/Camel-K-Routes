#!/bin/bash


camel run ./FileLoader.camel.xml --dep com.h2database:h2:2.2.224,com.zaxxer:HikariCP:5.1.0,org.apache.camel:camel-jdbc

