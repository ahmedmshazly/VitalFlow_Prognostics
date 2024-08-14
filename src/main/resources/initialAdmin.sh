#! /usr/bin/env bash

user_store=$1

if ! test -f "$1"; then
    touch "$1"
    echo "UUID,email,userRole,passwordHash,firstName,lastName,dob,hivStatus,diagnosisDate,onART,artStartDate,country" >> "$1"
    # plainpassword is helloworld
    echo "123e4567-e89b-12d3-a456-426614174000,Admin1@gmail.com,Admin,k2oYXKqiZrucvpgengXLeM1zKwsygOuURBK7b4+PB68=,null,null,null,null,null,null,null,null" >> "$1"
fi