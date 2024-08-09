#!/bin/bash

DATA_FILE="./user-store.txt"
TEMP_FILE="./temp_user-store.txt"

add_full_details() {
    local uuid=$1
    local email=$2
    local firstName=$3
    local lastName=$4
    local dob=$5
    local hivStatus=$6
    local diagnosisDate=$7
    local onART=$8
    local artStartDate=$9
    local country=${10}
    local hashedPassword=${11}

    awk -F "," -v uuid="$uuid" -v email="$email" -v firstName="$firstName" -v lastName="$lastName" -v dob="$dob" -v hivStatus="$hivStatus" -v diagnosisDate="$diagnosisDate" -v onART="$onART" -v artStartDate="$artStartDate" -v country="$country" -v hashedPassword="$hashedPassword" '
    BEGIN { updated = 0; OFS = "," }
    {
        if ($2 == uuid && $3 == "Patient") {
            $4 = email; $5 = firstName; $6 = lastName; $7 = dob;
            $8 = hivStatus; $9 = diagnosisDate; $10 = onART; $11 = artStartDate;
            $12 = country; $13 = hashedPassword;
            updated = 1;
        }
        print;
    }
    END {
        if (updated == 0) {
            print "No initial data found for UUID " uuid > "/dev/stderr";
            exit 1;
        }
    }' "$DATA_FILE" > "$TEMP_FILE"

    if [ $? -eq 0 ]; then
        mv "$TEMP_FILE" "$DATA_FILE"
        echo "Details added for UUID $uuid."
    else
        rm "$TEMP_FILE"
        echo "Failed to update details for UUID $uuid."
    fi
}



add_full_details "$1" "$2" "$3" "$4" "$5" "$6" "$7" "$8" "$9" "${10}" "${11}"
