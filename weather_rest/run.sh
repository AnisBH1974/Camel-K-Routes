#!/bin/bash

camel run webnews_backend.xml \
      --property locations.properties \
      --dep org.codehaus.groovy:groovy-json:3.0.21,org.apache.camel:camel-http:4.6.0 --console

