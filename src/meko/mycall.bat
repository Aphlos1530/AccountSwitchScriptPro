:: Customized call command with path switch ( Usage: call mycall ... )( For example: call ..\meko\mycall ..\acc\expCert )

@echo off

setlocal enableDelayedExpansion

chcp 65001 > nul



:save-cur

set cur=%cd%

rem echo cd=%cd%



:dest-path

rem To this meko path

cd %~dp0%

rem echo cd=%cd%

rem Split filepath and filename

call seperaPath %1 > nul

rem Read filepath and filename

call readVar destPath

set destPath=%value%

call readVar destFile

set destFile=%value%

if not %destPath%*==* set destPath=%destPath:?= %

rem echo destPath = %destPath%

rem echo destFile = %destFile%



:call

rem Support to same level call

if not %destPath%*==* cd %destPath%

if %2/==/start/ (

    start %destFile% %3 %4 %5 %6

) else (

    call %destFile% %2 %3 %4 %5

)



:reback

cd %cur%

rem echo cd=%cd%

