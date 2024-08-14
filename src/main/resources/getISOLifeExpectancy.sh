#! /usr/bin/env bash

CSV_FILE="$2"

ISO_CODE="$1"

life_expectancy=$(grep -E ",$ISO_CODE," "$CSV_FILE" | awk -F',' '{print $NF}')

echo "$life_expectancy"
