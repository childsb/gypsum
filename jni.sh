#!/bin/sh
# javac posix/Process.java
javah -jni -classpath $CLASSPATH:src/main/java  -d src/main/c posix.Process
