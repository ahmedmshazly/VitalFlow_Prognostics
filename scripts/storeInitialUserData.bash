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

email="test@example.com"
uuid="123e4567-e89b-12d3-a456-426614174000"

write_initial_data $email $uuid
