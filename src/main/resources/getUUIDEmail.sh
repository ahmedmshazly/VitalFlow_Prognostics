#! /usr/bin/env bash

UUID=$1
Path=$2

email=$(grep -E "^${UUID}," "$Path" | cut -d ',' -f 2)

echo "$email"