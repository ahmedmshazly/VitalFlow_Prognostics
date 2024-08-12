#! /usr/bin/env bash

if ! test -f ./user-store.txt; then
    touch ./user-store.txt
    echo "UUID, email, userRole, passwordHash, firstName, lastName, dob, hivStatus, diagnosisDate, onART, artStartDate, country" >> ./user-store.txt
    # plainpassword is helloworld
    echo "123e4567-e89b-12d3-a456-426614174000, Admin1@gmail.com, Admin, k2oYXKqiZrucvpgengXLeM1zKwsygOuURBK7b4+PB68=" >> ./user-store.txt
fi