:: Other information

@echo off & setlocal enabledelayedexpansion

cd ..\hel

chcp 65001 > nul

:start

echo=
echo  * * * * * * * * * * * * * * * *
echo  *                             *
echo  *        help menu            *
echo  *                             *
echo  *       1. useage             *
echo  *                             *
echo  *       2. quick useage       *
echo  *                             *
echo  *       3. reference          *
echo  *                             *
echo  *       4. about              *
echo  *                             *
echo  *       5. thanks             *
echo  *                             *
echo  *       6. download           *
echo  *                             *
echo  *       7. principle-1        *
echo  *                             *
echo  *       8. principle-2        *
echo  *                             *
echo  *       9. before use         *
echo  *                             *
echo  *       0. back               *
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

    goto ret

)

if %op% geq 1 if %op% leq 9 (

    cls

    call print %op%

    goto end

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

