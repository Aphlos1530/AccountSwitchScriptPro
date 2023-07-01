:: Save variable to file

@echo off


set key=%1

set value=%2

if %key%1==1 goto end

echo.%value%>..\temp\var\%key%


:end

