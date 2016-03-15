#! /bin/bash

sbt 'testOnly test.LocalSuite' | tee sbt-output.txt
if grep 'TEST FAILED' sbt-output.txt
then exit 1
fi