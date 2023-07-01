:: Correct the incorrect configuration file

@echo off & setlocal enabledelayedexpansion



:set-path

rem set fin="..\..\Genshin Impact Game\config.ini"

call ..\meko\readPath fin > nul

set fin=%value%

set fot="..\..\config.ini"



:fin

set lag=false

for /f "delims== tokens=1,2" %%a in ('type %fin%') do (

    if %%a==game_version (

        set lag=true

        goto fin-next

    )

)

:fin-next

if %lag%==false del %fin%



: fot

set lag=false

for /f "delims== tokens=1,2" %%a in ('type %fot%') do (

    if %%a==game_install_path (

        set lag=true

        goto fot-next

    )

)

:fot-next

if %lag%==false del %fot%



:end

rem Regenerate the configuration file

call loseCfgFile

