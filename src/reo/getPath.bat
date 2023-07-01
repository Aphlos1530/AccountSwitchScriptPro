:: Get the critical path

@echo off

setlocal enableDelayedExpansion



:pre

set currPath=%cd%

rem To this reo path

cd %~dp0%



:read

call ..\meko\readVar eMode > nul

set eMode=%value%

if %eMode%*==* set eMode=1



:set-path

rem Genshin Impact

if %eMode%==1 (

    set registryPath=HKEY_CURRENT_USER\Software\miHoYo\原神

    set gamePath="..\..\Genshin Impact Game"

    set exePath="..\..\Genshin Impact Game\YuanShen.exe"

    set cfgPath="..\..\Genshin Impact Game\config.ini"

    set sdkPath="..\..\Genshin Impact Game\YuanShen_Data\Plugins\PCGameSDK.dll"

)

rem Star Rail

if %eMode%==2 (

    set registryPath=HKEY_CURRENT_USER\Software\miHoYo\崩坏：星穹铁道

    set gamePath="..\..\Game"

    set exePath="..\..\Game\StarRail.exe"

    set cfgPath="..\..\Game\config.ini"

    set sdkPath="..\..\Game\StarRail_Data\Plugins\PCGameSDK.dll"

)



:shot

set fin=%cfgPath%

set fot="..\..\config.ini"

set lachPath="..\..\launcher.exe"

set mainPath="..\"

set progPath="..\..\"

set mekoPath="..\meko"



:ret

set thePath=!%1!

if %thePath%1==1 set thePath=""

rem Supported for user desktop path

if %1==deskPath (

    call ..\meko\deskPath > nul

    set thePath=!deskPath!
)

rem Trans to absolute path

if %2/==/abso/ (

    call ..\meko\toAbPath !thePath! > nul

    call ..\meko\readVar absoPath

    set thePath=!value!

    if not !thePath!1==1 set thePath=!thePath:?= !

)



:end

cd %currPath%

echo thePath=%thePath%

set thePath=%thePath: =?%

call ..\meko\saveVar thePath %thePath% > nul

