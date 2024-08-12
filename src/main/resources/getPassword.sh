#! /usr/bin/env bash

UUID=$1
Path=$2

password=$(grep -E "^${UUID}," "$Path" | cut -d ',' -f 4)

echo "$password"