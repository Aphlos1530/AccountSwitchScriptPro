 :: Rename the Certificate

@echo off

setLocal enableDelayedExpansion



:pre

call selCert rename

rem  Cannot get variable sel directly

call ..\meko\readVar sel

set sel=%value%

rem echo sel=%sel%



:filter

if %sel%*==* goto end

if %sel:~0,3%==def (

    echo=

    echo Default cert cannot rename ^^!

    goto end

)



:sln

rem Format : mihoyo-name

set lastName=%sel:.reg=%



:cps

for /f "tokens=1,* delims=-" %%i in ("%lastName%") do set cps=%%i

echo=

echo CPS=[%cps%]



:input

:: Sentence [ set name= ] is used to clear the previous input when press Enter directly

echo=

set name=

set /p name="Please enter a new name : %cps%-"



:dis

:: Check whether it is empty

if %name%*==* (

    echo=

    rem set name=

    echo Input empty ^^! Operation cancelled.

    goto end

)

:: Check whether the same name

set name=%cps%-%name%

if %name%==%lastName% (

    echo=

    rem set name=

    echo No changed.

    goto end

)

:: Check whether file exist

if exist ..\_cert\%name%.reg (

    echo=

    set name=

    set /p name="Name duplicate ^! Please input again : "

    goto dis

)



:then

echo=

rem Cannot use rename but move

move ..\_cert\%lastName%.reg ..\_cert\%name%.reg > nul

echo Change successfully.

echo=

echo %name%.reg



:sync

rem Synchronize the current account name

call ..\meko\readVar currentAccount > nul

if %lastName%.reg==%value% (

    call ..\meko\saveVar currentAccount %name%.reg > nul

)


:end

