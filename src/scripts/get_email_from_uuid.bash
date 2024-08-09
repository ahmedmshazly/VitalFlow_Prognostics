#!/bin/bash
# Check if UUID is provided
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 uuid"
    exit 1
fi

UUID=$1
DATA_FILE="./user-store.txt"

# Check if the data file exists
if [ ! -f "$DATA_FILE" ]; then
    echo "Data file not found."
    exit 2
fi

# Search for the UUID and get the corresponding email
grep "^$UUID," "$DATA_FILE" | cut -d ',' -f 2
