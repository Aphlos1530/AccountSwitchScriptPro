:: Switch to the specified account and cps

@echo off

setlocal enableDelayedExpansion

chcp 65001 > nul



:close

rem The process could not be terminated. Reason: Access is denied.

rem taskkill /f /t /im YuanShen.exe 1> nul 2> nul

rem taskkill /f /t /im StarRail.exe 1> nul 2> nul



:curr

call ..\meko\readVar currentAccount > nul

set curr=%value%

call ..\meko\readVar currentIndex > nul

set indx=%value%

if not !curr!*==* (

    set curr=!curr:.reg=!

    if not !indx!*==* (

        echo=

        echo Current : [!indx!. !curr!]

    ) else (

        echo=

        echo Current : [!curr!]

    )

)



:select

call ..\meko\mycall ..\acc\selCert login

rem  Cannot get variable sel directly

call ..\meko\readVar sel

set select=%value%

if %select%*==* goto end



:cps

set isDef=false

for /f "tokens=1,2 delims=-." %%i in ("%select%") do (

    set cps=%%i

    if %%i==def (

        set cps=%%j

        set isDef=true

        echo=

        echo Default account only use for switch cps.

    )

)

echo=

echo CPS=[%cps%]



:skip

call ..\meko\mycall ..\reo\getCps > nul

call ..\meko\readVar cps > nul

if %cps%==%value% goto reg

echo=

echo Auto switching to the %cps% server for you ...



:switch

call ..\meko\mycall ..\reo\swhCps %cps%

rem Skip no supported cps .

call ..\meko\readVar sta

if %value%==false goto end



:reg

if %isDef%==false (

    rem Command [ > nul ] is not sufficient to mask reg's console information, need to use [ 2> nul ]  instead of [ 1> nul ]

    reg import ..\_cert\%select% 2> nul

)



:next

echo=

echo Switch succeed.

call ..\meko\saveVar currentAccount %select%



:end

