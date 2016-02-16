#!/bin/bash

for i in $(seq -f "%06g" 1 $1)
do
v=$(awk -v "seed=$[(RANDOM & 32767) + 32768 * (RANDOM & 32767)]" 'BEGIN { srand(seed); printf("%.5f\n", rand() * 10.0 - 5.0) }')
m=$[($RANDOM + 15000)]
m2=$[($RANDOM % 100)]
echo "1$i,$m.$m2,$v"
done

