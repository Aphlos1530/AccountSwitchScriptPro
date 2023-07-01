:: Quikly export current account certtificate

@echo off

rem Changes the active console code page

chcp 65001 > nul



:date-time

rem format: date[周五 2023/05/26] time[13:01:54.81]

set no=%Date:~5,2%%Date:~8,2%%Date:~11,2%%Time:~0,2%%Time:~3,2%%Time:~6,2%

set no=%no: =%



:cps

call ..\meko\mycall ..\reo\getCps

call ..\meko\readVar cps > nul

set cps=%value%

rem echo CPS=[%cps%]



:export

set name=%cps%-%no%

call ..\meko\readPath registryPath > nul

reg export %value% ..\_cert\%name%.reg > nul

echo=

echo Export Completed .

echo=

echo %name%.reg

