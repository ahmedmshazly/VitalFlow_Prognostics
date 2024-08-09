#!/bin/bash

DATA_FILE="./user-store.txt"

write_initial_data() {
    local email=$1
    local uuid=$2
    echo "$email,$uuid,Patient,,,,,,,,," >> $DATA_FILE
    if [ $? -eq 0 ]; then
        echo "Initial data written for $email with UUID $uuid."
    else
        echo "Failed to write initial data for $email."
    fi
}


write_initial_data $1 $2
