#! /usr/bin/env bash

UUID=$1
user_store=$2

grep "$UUID" "$user_store"