#! /usr/bin/env bash

email=$1
Path=$2

password=$(grep -E ",${email}," "$Path" | cut -d ',' -f 4)

echo "$password"