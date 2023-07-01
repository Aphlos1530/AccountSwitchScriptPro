:: Remove the Certificate

@echo off

setLocal enableDelayedExpansion

chcp 65001 > nul



:pre

call selCert delete

rem  Cannot get variable sel directly

call ..\meko\readVar sel

set sel=%value%

rem echo sel=%sel%



:filter

if %sel%*==* goto end

if %sel:~0,3%==def (

    echo=

    echo Default cert cannot delete ^^!

    goto end

)



:next

echo=

set confim=

set /p confim="Are you sure to delete ? y or n : "


echo=

:: Check whether it is empty

if %confim%*==* (

    echo Input empty, auto cancelled.

    goto end

)

:: Check whether it is y

if %confim%==y (

    del ..\_cert\%sel%

    echo Removed .

) else (

    echo You have cancelled .

    goto end

)



:sync

rem Synchronize the current account name

call ..\meko\readVar currentIndex > nul

set cid=%value%

call ..\meko\readVar deleteIndex > nul

set eid=%value%

if /%cid%/==/%eid%/ (

    call ..\meko\saveVar currentAccount > nul

    call ..\meko\saveVar currentIndex > nul

) else (

    rem Need to modify when less than curr

    if %eid% lss %cid% set /a cid-=1

    call ..\meko\saveVar currentIndex !cid! > nul

)



:end

