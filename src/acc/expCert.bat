:: Export the cretificate

@echo off

setLocal enableDelayedExpansion

chcp 65001 > nul



:export

call expReg



:cps

rem Cannot call directely when need get or input cps

call ..\meko\mycall ..\reo\getCps > nul

call ..\meko\readVar cps > nul

set cps=%value%

echo=

echo CPS=[%cps%]



:input

:: Sentence [ set name= ] is used to clear the previous input when press Enter directly

echo=

set name=

set /p name="Please enter a name of this proof : %cps%-"



:dis

:: Check whether it is empty

if %name%*==* (

    echo=

    echo You have not named yet, please rename later.

    set name=%cps%-unnamed

    goto then

)

:: Check whether file exist

set name=%cps%-%name%

if exist ..\_cert\%name%.reg (

    echo=

    set name=

    set /p name="Name duplicate ^! Please input again : "

    goto dis

)



:then

echo=

rem Keep the original file

copy ..\temp\temp.reg ..\_cert\%name%.reg > nul

del ..\temp\temp.reg

echo Add successfully.

echo=

echo %name%.reg



:end

