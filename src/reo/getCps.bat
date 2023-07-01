:: Auto get current server cps

@echo off



:set-path

rem set cfgPath="..\..\Genshin Impact Game\config.ini"

call ..\meko\readPath cfgPath > nul

set cfgPath=%value%



:read

set cps=unknown

for /f "delims=" %%a in ('findstr /b /c:"channel=" %cfgPath%') do (

    if "%%a"=="channel=1" (

        for /f "delims=" %%b in ('findstr /b /c:"sub_channel=" %cfgPath%') do (

            if "%%b"=="sub_channel=1" set cps=mihoyo

            if "%%b"=="sub_channel=0" set cps=hoyoverse

        )

    )

    if "%%a"=="channel=14" set cps=bilibili

)

echo=

echo Current Cps : %cps%



:end

rem For some unknown reason, this variable cannot get directly in another bat

call ..\meko\saveVar cps %cps%

