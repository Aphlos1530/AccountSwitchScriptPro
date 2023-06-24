:: Account management and proof export

@echo off & setlocal enabledelayedexpansion

cd ..\acc

chcp 65001 > nul


:start

echo=
echo  * * * * * * * * * * * * * * * *
echo  *                             *
echo  *       account menu          *
echo  *                             *
echo  *    1. list account          *
echo  *                             *
echo  *    2. export account        *
echo  *                             *
echo  *    3. quick export          *
echo  *                             *
echo  *    4. delete account        *
echo  *                             *
echo  *    5. rename account        *
echo  *                             *
echo  *    0. back                  *
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

if %op%==1 (

    call listCert

    goto end

)

if %op%==2 (

    call expCert

    goto end

)

if %op%==3 (

    call quickExp

    goto end

)

if %op%==4 (

    call delCert

    goto end

)

if %op%==5 (

    call renCert

    goto end

)

if %op%==0 (

    goto ret

)


:else

echo=

set op=

set /p op="Input error, please input again : "

goto dis


:end

echo=

pause

cls

goto start


:ret

