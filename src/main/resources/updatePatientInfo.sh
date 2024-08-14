#!/usr/bin/env bash

user_store=${12}
UUID=$1
new_first_name=$2
new_last_name=$3
new_dob=$4
new_status=$5
new_art_status=$7
new_art_start_date=$8
new_country_iso=$9
new_diagnosis_date=$6
new_expentancy=${11}
new_password=${10}

temp_file=$(mktemp)

while IFS= read -r line; do
    current_uuid=$(echo "$line" | cut -d ',' -f 1)
    
    if [[ "$current_uuid" == "$UUID" ]]; then
        current_email=$(echo "$line" | cut -d ',' -f 2)
        echo "$UUID,$current_email,$new_password,$new_first_name,$new_last_name,$new_dob,$new_status,$new_diagnosis_date,$new_art_status,$new_art_start_date,$new_country_iso,$new_expentancy" >> "$temp_file"
    else
        echo "$line" >> "$temp_file"
    fi
done < "$user_store"

mv "$temp_file" "$user_store"

