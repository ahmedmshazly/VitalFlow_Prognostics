#! /usr/bin/env bash

email=$1
user_store=$2

grep "$email" "$user_store"