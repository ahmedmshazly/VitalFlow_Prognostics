#!/bin/env bash

# UUID to check
uuid=$1

# Path to the user store file
user_store=$2

# Check if the UUID exists in the file
if grep -q "$uuid" "$user_store"; then
    echo -n "true"
else
    echo -n "false"
fi
