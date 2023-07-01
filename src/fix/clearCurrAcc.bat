:: Clear current account login state

@echo off & setlocal enabledelayedexpansion



:inp

echo=

set confim=

set /p confim="Are you sure to clear ? y or n : "



:dis

echo=

:: Check whether it is empty

if %confim%*==* (

    echo Input empty, auto cancelled.

    goto end

)

:: Check whether it is y

if %confim%==y (

    rem Command [ > nul ] is not sufficient to mask reg's console information, need to use [ 2> nul ]  instead of [ 1> nul ]

    reg import ..\revolve\clear.reg 2> nul

    echo Cleared .

    rem Clear last select account info

    call ..\meko\saveVar currentAccount

    call ..\meko\saveVar currentIndex

) else (

    echo You have cancelled .

)



:end

