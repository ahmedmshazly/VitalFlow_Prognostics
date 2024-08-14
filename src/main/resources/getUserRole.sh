#! /usr/bin/env bash

email=$1
Path=$2

role=$(grep -E ",${email}," "$Path" | cut -d ',' -f 3)

echo "$role"
