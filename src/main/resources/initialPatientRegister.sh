#! /usr/bin/env bash

user_store="./user-store.txt"

UUID=$1
email=$2

echo "$UUID, $email" >> "$user_store"
