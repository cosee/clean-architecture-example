#!/usr/bin/env bash

cd "$(dirname "$(readlink -f "$0")")"

java -cp ~/.m2/repository/com/h2database/h2/1.4.200/h2*.jar \
    org.h2.tools.Server \
    -baseDir . \
    -ifNotExists \
    "$@"
