:: Get all Certificate

@echo off

setLocal enableDelayedExpansion



:export

echo.>..\temp\accounts.txt

rem [ 2> nul ] is use for not display error info when dir empty ( Otherwise it will show : File not found )

dir ..\_cert /b /a:-d /o:d >> ..\temp\accounts.txt 2> nul



:list-def

echo=

echo 1. def-mihoyo

echo 2. def-bilibili

echo 3. def-hoyoverse



:list

set len=3

for /f %%a in (..\temp\accounts.txt) do (

    set /a len+=1

    set acc=%%a

    set acc=!acc:.reg=!

    echo !len!. !acc!

)



:end

