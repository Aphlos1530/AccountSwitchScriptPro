:: Read variable from file

@echo off



call ..\reo\getPath %1 %2 > nul

call ..\meko\readVar thePath



:space

rem Supported for path with spaces

if not %value%1==1 set value=%value:?= %



:quota

rem When in noqo mode, remove double quotes on both sides (Only one /noqo)

echo %value% | findstr /c:"\" >nul

if not errorlevel 1 if %2/==/noqo/ set value=%value:~1,-1%

if not errorlevel 1 if %3/==/noqo/ set value=%value:~1,-1%



:end

rem echo=

rem echo thePath=%value%

