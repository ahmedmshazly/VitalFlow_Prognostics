#! /usr/bin/env bash

user_store=${12}

uuid=$1
firstName=$2
lastName=$3
dob=$4
hivStatus=$5
diagnosisDate=$6
onART=$7
artStartDate=$8
country=$9
hashedPassword=${10}
remainingYears=${11}

additional_info="$hashedPassword,$firstName,$lastName,$dob,$hivStatus,$diagnosisDate,$onART,$artStartDate,$country,$remainingYears"

temp_file=$(mktemp)

while IFS= read -r line
do
    if [[ "$line" == *"$uuid"* ]]; then
        echo "$line,$additional_info" >> "$temp_file"
    else
        echo "$line" >> "$temp_file"
    fi
done < "$user_store"

mv "$temp_file" "$user_store"