@echo off

set char=%1

set first=%char:~0,1%

set last=%char:~-1,1%

set rel=false

if %first%-%last%==[-] set rel=true
