
#!/bin/bash
FILENAME="entries.txt" 
for i in $(seq 10000000)
do
    echo "song$i album$i singer$i" >> $FILENAME
done
