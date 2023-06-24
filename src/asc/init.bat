:: Initialize the whole script

@echo off

rem setlocal enableDelayedExpansion



:step0

:: Check if misssing cert and temp path

if not exist ..\_cert mkdir ..\_cert

if not exist ..\temp mkdir ..\temp

if not exist ..\temp\var mkdir ..\temp\var



:step1

rem Check whether switcher file is in Correct position

:check

echo=

echo Checking switcher place ...

set lachPath="..\..\launcher.exe"

if not exist %lachPath% (

    echo Please put the file in the correct place ^^!

    goto end

)

echo=

echo OK.



:step2

rem Check whether the current game is Genshin Impact or Star Rail

echo=

echo Checking current game ...

set emode=0

set exePath1="..\..\Genshin Impact Game\YuanShen.exe"

set exePath2="..\..\Game\StarRail.exe"

if exist %exePath1% set emode=1

if exist %exePath2% set emode=2

call ..\meko\saveVar eMode %emode%

if %emode%==0 (

    echo=

    echo Unsupported game !

    goto end

)

echo=

echo OK.



:step3

rem Create switcher shortcut to desktop

echo=

echo Creating switcher link ...

:path

:: Get the real path

call ..\meko\readPath mainPath /abso /noqo > nul

set swch=%value%

call ..\meko\readPath deskPath /noqo > nul

set desk=%value%

:link

set StartPath="%swch%"

set SourcePath="%swch%\main.bat"

if %emode%==1 (

    set LinkPath="%desk%\nahida.lnk"

    set IconPath="%swch%\revolve\nahida64.ico"

)

if %emode%==2 (

    set LinkPath="%desk%\fuxuan.lnk"

    set IconPath="%swch%\revolve\fuxuan64.ico"

)

set CreateLink="..\meko\shortcut.bat"

call %CreateLink% %StartPath% %SourcePath% %LinkPath% %IconPath% > nul

echo=

echo OK.

goto step5



:step4

:: Backup current logined account

echo=

echo Backing cert ...

call ..\meko\mycall ..\acc\expCert

echo=

echo OK.



:step5

:: Check whether the config files lost (migrated to fix)

echo=

echo Checking config files ...

if %emode%==1 set fin="..\..\Genshin Impact Game\config.ini"

if %emode%==2 set fin="..\..\Game\config.ini"

set fot="..\..\config.ini"

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

echo=

echo OK.



:step6

:: Backup current config files

echo=

echo Backing config files ...

if not exist ..\temp\old mkdir ..\temp\old

copy ..\..\config.ini  ..\temp\old\config.ini > nul

if %emode%==1 (

    if not exist "..\temp\old\Genshin Impact Game" mkdir "..\temp\old\Genshin Impact Game"

    copy "..\..\Genshin Impact Game\config.ini" "..\temp\old\Genshin Impact Game\config.ini" > nul

)

if %emode%==2 (

    if not exist "..\temp\old\Game" mkdir "..\temp\old\Game"

    copy "..\..\Game\config.ini" "..\temp\old\Game\config.ini" > nul

)

echo=

echo OK.



:step7

:: There is nothing here



:step8

:: There is nothing here



:end

echo=

echo Completed !

