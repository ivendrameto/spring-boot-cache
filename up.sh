#!/bin/bash

NETWORK_NAME=network_apps

printf "Verificando existencia da rede: ${NETWORK_NAME}"
echo -e " "
if [ -z $(docker network ls --filter name=^${NETWORK_NAME}$ --format="{{ .Name }}") ] ; then 
    printf "Criando ${NETWORK_NAME}"
    docker network create --driver bridge ${NETWORK_NAME} > /dev/null; 
else
    printf "Rede ${NETWORK_NAME} já existe."
fi

docker-compose  \
    --compatibility \
    -f docker-compose.yaml \
    up -d --remove --build "$@" >> .run.log 2>&1 &