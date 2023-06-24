:: Start launcher or game

@echo off

setlocal enableDelayedExpansion

chcp 65001 > nul



rem smode 1 for launcher 2 for YuanShen

set smode=%1

if %smode%1==1 set smode=1



:launcher

if %smode%==1 (

    start ..\..\launcher.exe

    rem delay 3 seconds prevents sdk files be deleted by mihoyo launcher

    ping 127.0.0.1 -n 2 > nul

    ping 127.0.0.1 -n 2 > nul

    ping 127.0.0.1 -n 2 > nul

)



:sdk

call ..\meko\mycall ..\reo\getCps > nul

call ..\meko\readVar cps > nul

if not %value%==bilibili goto next

rem Checking if missing the dynamic link library files ...

rem set sdkPath="..\..\Genshin Impact Game\YuanShen_Data\Plugins\PCGameSDK.dll"

call ..\meko\readPath sdkPath > nul

set sdkPath=%value%

if not exist %sdkPath% (

    copy ..\revolve\PCGameSDK.dll %sdkPath% > nul

    echo=

    echo SDK Copyed .

)



:next

rem There is nothing here



:game

if %smode%==2 (

    call ..\meko\readPath exePath > nul

    rem Can not start drictly ...

    call ..\meko\mycall /start !value!

)



:end

echo=

echo Started.

