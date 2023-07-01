:: Convert relative path to absolute path

@echo off

setlocal enableDelayedExpansion

chcp 65001 > nul



set currPath=%cd%

cd %1

set absoPath=%cd%

cd %currPath%



:next

set absoPath="%absoPath%"

echo=

echo absoPath=%absoPath%

set absoPath=%absoPath: =?%

call ..\meko\saveVar absoPath %absoPath%



:get

rem call readVar absoPath

rem set absoPath=%value%

rem if not %absoPath%1==1 set absoPath=%absoPath:?= %

