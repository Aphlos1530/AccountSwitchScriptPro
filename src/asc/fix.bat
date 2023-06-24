:: Common error fix

@echo off & setlocal enabledelayedexpansion

cd ..\fix

chcp 65001 > nul


:start

echo=
echo  * * * * * * * * * * * * * * * *
echo  *                             *
echo  *         fix menu            *
echo  *                             *
echo  *    1. config file lose      *
echo  *                             *
echo  *    2. config file error     *
echo  *                             *
echo  *    3. config info error     *
echo  *                             *
echo  *    4. version correct       *
echo  *                             *
echo  *    5. clear login state     *
echo  *                             *
echo  *    9. FAQ                   *
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

    call loseCfgFile

    goto end

)

if %op%==2 (

    call corrCfgFile

    goto end

)

if %op%==3 (

    call corrCfgInfo

    goto end

)

if %op%==4 (

    call corrGameVer

    goto end

)


if %op%==5 (

    call clearCurrAcc

    goto end

)

if %op%==9 (

    cls

    call quest

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



:quik-end

cls

goto start



:ret

