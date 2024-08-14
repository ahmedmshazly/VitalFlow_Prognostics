#!/bin/env bash

email=$1

user_store=$2

if grep -q "$email" "$user_store"; then
    echo -n "true"
else
    echo -n "false"
fi

