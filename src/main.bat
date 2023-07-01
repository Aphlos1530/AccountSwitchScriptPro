:: The main menu

@echo off & setlocal enabledelayedexpansion

cd asc

chcp 65001 > nul


:start

echo=
echo  * * * * * * * * * * * * * * * *
echo  *                             *
echo  *           menu              *
echo  *                             *
echo  *    1. switch account        *
echo  *                             *
echo  *    2. account management    *
echo  *                             *
echo  *    3. initialize            *
echo  *                             *
echo  *    4. fix errors            *
echo  *                             *
echo  *    5. start launcher        *
echo  *                             *
echo  *    6. help                  *
echo  *                             *
echo  *    -1. exit                 *
echo  *                             *
echo  * * * * * * * * * * * * * * * *
echo=


:pre-dis

set op=

set /p op="Please enter options and press enter : "


:dis

if %op%'==' (

    cls

    goto start

)

if %op%==0 (

    cls

    goto start

)


if %op%==1 (

    call swh

    goto end

)

if %op%==2 (

    cls

    call acc

    goto quik-end

)

if %op%==3 (

    echo=

    call init

    goto end

)

if %op%==4 (

    cls

    call fix

    goto quik-end

)

if %op%==5 (

    call srt 1

    goto end

)

if %op%==6 (

    cls

    call help

    goto quik-end

)

if %op%==9 (

    echo=

    echo Function not yet developed .

    goto end

)

if %op%==-1 (

    goto exit

)


:colegg

if %op%==666 (

    echo Fuck you dos ^^! Who like who write ^^!

    goto end

)

if %op%==888 (

    echo Fuck it ^^! I quit ^^!

    goto end

)


:else

echo=

set op=

set /p op="Input error ^! please input again : "

goto dis



:end

echo=

pause

cls

goto start



:quik-end

cls

goto start



:exit

