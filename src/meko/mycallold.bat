:: Customized call command with path switch ( Usage: call mycall ... )( For example: call ..\meko\mycall ..\acc\expCert )

@echo off

setlocal enableDelayedExpansion


:: Explain: The strings passed in are full path, both contain bat file name and bat path, because of this, we need to separate them.



:save-cur

set cur=%cd%

rem echo cd=%cd%



:pre

set str=%1

set len=0



:split

for /f "tokens=1,* delims=\" %%i in ("%str%") do (

    set /a len+=1

    set str!len!=%%i

    set str=%%j

)

if not %str%*==* goto split



:dest-file

:: Separate bat file

set destFile=!str%len%!

rem echo destFile=%destFile%



:comp

set /a len-=1

set destPath=

for /l %%i in (1,1,!len!) do (

    set destPath=!destPath!\!str%%i!

)



:dest-path

:: Separate bat path

rem Remove the first \

set destPath=%destPath:~1%

rem echo destPath=%destPath%



:call

rem Support to same level call

if not %destPath%*==* cd %destPath%

call %destFile% %2 %3 %4 %5



:reback

cd %cur%

rem echo cd=%cd%

