:: Select the Certificate

@echo off

setLocal enableDelayedExpansion



:list

call listCert



:tip

echo=

if %1*==* (

    set /p choose="Please input the number of the cert you want to choose : "

) else (

    set /p choose="Please input the number of the cert you want to %1 : "

)



:empty

if %choose%*==* (

    echo=

    echo Input empty ^^! Operation cancelled.

    goto end

)



:def

if %choose%==1 set sel=def-mihoyo

if %choose%==2 set sel=def-bilibili

if %choose%==3 set sel=def-hoyoverse

if not %sel%*==* (

    rem Sync when def but not hoyoverse

    if not %choose%==3 if %1==login call ..\meko\saveVar currentIndex %choose%

    goto end

)


:select

set ind=3

set sel=

for /f %%a in (..\temp\accounts.txt) do (

    set /a ind+=1

    if !ind!==!choose! (

        set sel=%%a

        echo=

        echo Selected : !sel:.reg=!

        rem Sync

        if %1==login call ..\meko\saveVar currentIndex !ind!

        if %1==delete call ..\meko\saveVar deleteIndex !ind!

        goto end

    )

)

echo=

echo Input error ^^! Operation cancelled.




:end

rem For some unknown reason, this variable cannot get directly in another bat

call ..\meko\saveVar sel %sel%

