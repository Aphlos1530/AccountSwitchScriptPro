:: Read variable from file

@echo off


set key=%1

set value=

if %key%1==1 goto end


if not exist ..\temp\var\%key% (

    echo=

    echo Variable no found ^!

    goto end

)


for /f %%i in (..\temp\var\%key%) do (

    set value=%%i

    goto end

)


:end

set readVar=%value%

