  :: Check whether cps is legitimate

@echo off

rem setlocal enabledelayedexpansion


call ..\meko\readVar cps > nul

set cps=%value%


set lag=false

if %cps%==mihoyo set lag=true

if %cps%==bilibili set lag=true

if %cps%==hoyoverse set lag=true


echo=

echo Legal : %lag%

