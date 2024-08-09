#! /usr/bin/env bash

if ! test -f ./user-store.txt; then
    touch ./user-store.txt
    # plainpassword is helloworld
    echo "Admin1@gmail.com, UUID1, Admin, k2oYXKqiZrucvpgengXLeM1zKwsygOuURBK7b4+PB68=" >> ./user-store.txt
fi
# Prompt the user for a password
read -s -p "Enter a password: " password

# Hash the password using OpenSSL
hash=$(echo -n "$password" | openssl dgst -sha256 -binary | openssl base64 -A)

# Display the hashed password
echo -e "\nHashed password: $hash"