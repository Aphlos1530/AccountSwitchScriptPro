:: Regenerates configuration parameters

@echo off & setlocal enabledelayedexpansion



:set-path

rem set cfgPath="..\..\Genshin Impact Game\config.ini"

call ..\meko\readPath cfgPath > nul

set cfgPath=%value%

set tempPath=..\temp\config-unknown.ini

cd.>%tempPath%



:write

for /f "delims== tokens=1,2" %%a in ('type %cfgPath%') do (

    set key=%%a

    set value=%%b

    rem key=value

    if !key!==cps set value=unknown

    if !key!==channel set value=0

    if !key!==sub_channel set value=0

    set line=!key!=!value!

    rem [...]

    call ../meko/format/bracket !key!

    if !rel!==true set line=!key!

    rem write

    echo.!line!>>%tempPath%

)

copy %tempPath% %cfgPath% > nul

del %tempPath%



:end

echo=

echo Done. Please switch account later.

