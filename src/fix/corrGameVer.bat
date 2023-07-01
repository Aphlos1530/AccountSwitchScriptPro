:: Set up the game version manually

@echo off & setlocal enabledelayedexpansion



:read

rem set cfgPath="..\..\Genshin Impact Game\config.ini"

call ..\meko\readPath cfgPath > nul

set cfgPath=%value%

for /f "delims== tokens=1,2" %%a in ('type %cfgPath%') do (

    if %%a==game_version (

        set ver=%%b

        goto show

    )

)



:fix

if %ver%*==* (

    echo=

    echo Can not get game version ! Auto fix config file ...

    call corrCfgFile

    goto read

)



:show

echo=

echo Current version : %ver%



:input

echo=

set /p inp="Please input the correct version : "



:dis

if %inp%*==* (

    echo=

    echo Input empty ^^! Operation cancelled.

    goto end

)

call ..\meko\format\version %inp%

if %rel%==true goto next

echo=

set inp=

set /p inp="Input error ^! Please input again : "

goto dis



:next

set ver=%inp%

echo=

echo Version : %ver%



:write

echo=

echo Revising ...

set tempPath=..\temp\config-unknown.ini

cd.>%tempPath%

for /f "delims== tokens=1,2" %%a in ('type %cfgPath%') do (

    set key=%%a

    set value=%%b

    rem key=value

    if !key!==game_version set value=%ver%

    if !key!==plugin_sdk_version set value=%ver%

    set line=!key!=!value!

    rem [...]

    call ../meko/format/bracket !key!

    if !rel!==true set line=!key!

    rem write

    echo.!line!>>%tempPath%

)

copy %tempPath% %cfgPath% > nul

del %tempPath%

echo=

echo Done.



:end

