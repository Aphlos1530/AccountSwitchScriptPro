@echo off

set currPath=%cd%

cd ..\..\

set progPath=%cd%

cd %currPath%



:next

echo=

echo progPath=%progPath%

rem Do not use mycall here !

rem call saveVar progPath "%progPath%"

