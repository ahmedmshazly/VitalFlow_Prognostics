#! /usr/bin/env bash

user_store=$3

UUID=$1
email=$2

echo "$UUID,$email,Patient" >> "$user_store"