
CS542 Design Patterns
Fall 2014
PROJECT <4> README FILE

Grace Period Used This Project: <0> Days
Grace Period Remaining: <0> Days
Author(s): <GANESH BHARAT WANI>
e-mail(s): <gwani1@binghamton.edu> 


PURPOSE:

[
 Design and implement Dynamic proxy pattern and Strategy pattern
]

PERCENT COMPLETE:

[
 100%
]

PARTS THAT ARE NOT COMPLETE:

[
 
]

BUGS:

[
  None.
]

FILES:

[
├── README.txt
├── build.xml
├── checkPointFile.xml
└── src
    └── genericCheckpointing
        ├── driver
        │   └── Driver.java
        ├── server
        │   ├── RestoreI.java
        │   ├── StoreI.java
        │   └── StoreRestoreI.java
        ├── util
        │   ├── DeserializationStrategy.java
        │   ├── DeserializeTypes.java
        │   ├── FileProcessor.java
        │   ├── FileWriter.java
        │   ├── MyAllTypesFirst.java
        │   ├── MyAllTypesSecond.java
        │   ├── ProxyCreator.java
        │   ├── SerializableObject.java
        │   ├── SerializationStrategy.java
        │   ├── SerializeTypes.java
        │   ├── XMLDeserializationStrategy.java
        │   └── XMLSerializationStrategy.java
        └── xmlStoreRestore
            └── StoreRestoreHandler.java
]

SAMPLE OUTPUT:

[
		[java] Number of records mis-matched are : 2
]

TO COMPILE:

[
  Just extract the files and then do “ant compile”.
]

TO RUN:

[
  Here is a sample:

  Please run as:
  ant run -Ddebug_value=<FILENAME> -Dno-of-objects=<NO_OF_OOBJECTS> -Dmode=<ser|deser|serdeser>

  For example:  ant run -Dfilename=checkPointFile.xml -Dno-of-objects=4 -Dmode=deser 
]

Explanation regarding arguments:
[
		It takes n number of arguments, and creates 2*n number of objects.
		And it will check for validity with 2*n number of objects only.
		E.g. If no-of-objects=2, then it will create total 4 number of objects,
		2 for MyAllTypesFirst and 2 for MyAllTypesSecond
]

EXTRA CREDIT:

[
 "N/A"
]

DEBUG VALUE:
[
]


BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<GANESH WANI>

[
  http://docs.oracle.com/javase/7/docs/api/
]

ACKNOWLEDGEMENT:

[
 None
]
