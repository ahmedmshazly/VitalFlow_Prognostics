#! /usr/bin/env bash

password=$1

hash=$(echo -n "$password" | openssl dgst -sha256 -binary | openssl base64 -A)

echo "$hash"