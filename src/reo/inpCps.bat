:: Manual input server cps

@echo off


echo=

echo 1. mihoyo

echo 2. bilibili

echo 3. hoyoverse


echo=

set /p ch="Please input the current server (1 to 3) : "



:dis

if %ch% geq 1 if %ch% leq 3 goto next

echo=

set ch=

set /p ch="Input error ! Please input again : "

goto dis



:next

if %ch% == 1 set cps=mihoyo

if %ch% == 2 set cps=bilibili

if %ch% == 3 set cps=hoyoverse

echo=

echo Cps : %cps%



:end

