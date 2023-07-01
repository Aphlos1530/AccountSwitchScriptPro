:: Separate the path from the final file

@echo off

setlocal enableDelayedExpansion

chcp 65001 > nul



:var

set destPath=

set destFile=

set str=%1



:test

set str1=G:\Program-Files\Genshin-Impact\AccountSwitchScript\meko\seperaPtah.bat

set str2="G:/Program Files/Genshin Impact/AccountSwitchScript/meko/seperaPtah.bat"

set str3=..\..\AccountSwitchScript\seperaPtah.bat

set str4=seperaPtah.bat

rem set str=%str2%



:pre

rem Convert slashes to backslashes

set str=%str:/=\%



:dis

rem Check whether the string contains double quotes (")

set ifQtr=false

echo %str% | findstr /c:"\" >nul

rem Check whether the exit code of the previous command is  greater than or equal to 1 ( 0: find  1: not find  2: error)

if not errorlevel 1 set ifQtr=true

rem Check whether the string contains backslash (\)

set ifDrc=false

echo %str% | findstr /c:\ >nul

rem Check whether the exit code of the previous command is  greater than or equal to 1 ( 0: find  1: not find  2: error)

if not errorlevel 1 set ifDrc=true



:dirct

if %ifDrc%==false (

    set destFile=%str%

    goto end

)



:quotes

rem Transform : Quotation marks and Spaces processing

if %ifQtr%==true (

    rem Remove the double quotes and replace the Spaces

    set str=!str: =?!

    set str=!str:~1,-1!

)



:split

rem Core code : split filepath and filename

for /f "tokens=1,* delims=\" %%i in ("%str%") do (

    if not %%j*==* (

        set destPath=!destPath!\%%i

        set destFile=%%j

    )

    set str=%%j

)

if not %str%*==* goto split



:tax

rem Remove the first backslash

set destPath=%destPath:~1%



:re-quotes

rem Inverse transform : Quotation marks and Spaces processing

if %ifQtr%==true (

    rem Add back the double quotes and replace the Spaces

    set destPath="!destPath!"

    rem set destPath=!destPath:?= !

)



:end

call saveVar destPath %destPath%

call saveVar destFile %destFile%

set destPath=%destPath: =?%

echo destPath = %destPath%

echo destFile = %destFile%


