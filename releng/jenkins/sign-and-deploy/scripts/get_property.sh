#/bin/bash

# $1 path to .properties file
# $2 property name

if [ ! -f "$1" ]; then
    echo "File not found: $1" >&2
    exit 1
fi
VALUE=$(grep "^$2" $1 |awk -F= '{print $2}')
if [ -z "$VALUE" ]; then
    echo "Could not get property value" >&2
    exit 1
fi
echo $VALUE
