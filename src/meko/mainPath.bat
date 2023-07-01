@echo off

set currPath=%cd%

cd ..

set mainPath=%cd%

cd %currPath%



:next

echo=

echo mainPath=%mainPath%

rem Do not use mycall here !

rem call saveVar mainPath "%mainPath%"

