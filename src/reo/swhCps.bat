:: Switch to bilibili server

@echo off

setLocal enableDelayedExpansion



:stata

set sta=false



:dis

if %1==hoyoverse (

    echo=

    echo Function has not developed yet, please looking forward to ^^!

    goto end

)

if %1==bilibili (

    call alterCfg inner bilibili 14 0

    call alterCfg outer bilibili 14 0

    goto sdk

)

if %1==mihoyo (

    call alterCfg inner mihoyo 1 1

    call alterCfg outer mihoyo 1 1

    goto ok

)

echo=

echo Unkown channel.

goto end



:sdk

echo=

echo Checking if missing the dynamic link library files ...

rem set sdkPath="..\..\Genshin Impact Game\YuanShen_Data\Plugins\PCGameSDK.dll"

call ..\meko\readPath sdkPath > nul

set sdkPath=%value%

if not exist %sdkPath% (

    copy ..\revolve\PCGameSDK.dll %sdkPath% > nul

    echo=

    echo SDK Copyed .

)



:ok

set sta=true



:end

rem For some unknown reason, this variable cannot get directly in another bat

call ..\meko\saveVar sta %sta%

