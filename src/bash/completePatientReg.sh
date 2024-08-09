#! /usr/bin/env bash

user_store="./user-store.txt"

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

additional_info="Patient, $hashedPassword, $firstName, $lastName, $dob, $hivStatus, $diagnosisDate, $onART, $artStartDate, $country"

temp_file=$(mktemp)

while IFS= read -r line
do
    if [[ "$line" == *"$uuid"* ]]; then
        # Append additional information to the line containing the UUID
        echo "$line, $additional_info" >> "$temp_file"
    else
        # Copy other lines unchanged
        echo "$line" >> "$temp_file"
    fi
done < "$user_store"

# Replace the original file with the updated file
mv "$temp_file" "$user_store"
echo "User details for UUID $uuid have been updated."