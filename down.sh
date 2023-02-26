#!/bin/bash

docker-compose  \
    --compatibility \
    -f docker-compose.yaml \
    down --remove-orphans "$@" >> .run.log 2>&1 &