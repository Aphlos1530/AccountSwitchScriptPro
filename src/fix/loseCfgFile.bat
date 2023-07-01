:: Check whether the configuration file is lost

@echo off



:set-path

rem set fin="..\..\Genshin Impact Game\config.ini"

call ..\meko\readPath fin > nul

set fin=%value%

set fot="..\..\config.ini"



:copy

set finbak=..\revolve\config-mihoyo.ini

set fotbak=..\revolve\config-launcher.ini

if not exist %fin% (

    echo=

    echo Copying game config file ...

    copy %finbak% %fin% > nul

)

if not exist %fot% (

    echo=

    echo Copying launcher config file ...

    copy %fotbak% %fot% > nul

)



:end

echo=

echo Done.

