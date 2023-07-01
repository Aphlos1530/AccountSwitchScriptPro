:: Alter the content of the configuration file

@echo off

setLocal enableDelayedExpansion


set cps=%2

set channel=%3

set sub_channel=%4



:cfg-in

if %1==inner (

    rem set filePath="..\..\Genshin Impact Game\config.ini"

    call ..\meko\readPath fin > nul

    set filePath=!value!

    set tempPath=..\temp\config-inner.ini

    set backPath=..\revolve\config-!cps!.ini

)



:cfg-out

if %1==outer (

    set filePath="..\..\config.ini"

    set tempPath=..\temp\config-outer.ini

    set backPath=..\revolve\config-launcher.ini

)



:miss

if not exist %filePath% (

    copy %backPath% %filePath% > nul

    echo=

    rem echo The %1 config not exist, auto generated.

    echo Copying %1 config file ...

)



:alter

echo=

echo Changing %1 config ...

cd.>%tempPath%

for /f "delims== tokens=1,2" %%a in ('type %filePath%') do (

    set key=%%a

    set value=%%b

    rem key=value

    if !key!==cps set value=!cps!

    if !key!==channel set value=!channel!

    if !key!==sub_channel set value=!sub_channel!

    set line=!key!=!value!

    rem [...]

    call ../meko/format/bracket !key!

    if !rel!==true set line=!key!

    rem write

    echo.!line!>>%tempPath%

)

copy %tempPath% %filePath% > nul



:end

echo=

echo Altered.

