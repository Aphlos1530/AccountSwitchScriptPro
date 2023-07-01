:: Get all the keys in registry of Genshin

@echo off

chcp 65001 > nul



:: Set the path to saved

set textPath=..\temp\allKey.txt

:: Clear text

cd.>%textPath%



:: Add emode supported

call ..\meko\readVar eMode > nul

set emode=%value%

if %emode%*==* set emode=1

if %emode%==1 set registryPath=HKEY_CURRENT_USER\Software\miHoYo\原神

if %emode%==2 set registryPath=HKEY_CURRENT_USER\Software\miHoYo\崩坏：星穹铁道



:: Query each key-value and save the key to text

echo=

echo Please wait for few seconds ...


for /f "skip=2 tokens=1" %%i in ('reg query %registryPath%') do (

    if %%i neq Screenmanager (

        echo.%%i>>%textPath%
    )

)



:: Special key processing

if %emode%==1 (

    echo.Screenmanager Is Fullscreen mode_h3981298716>>%textPath%

    echo.Screenmanager Resolution Height_h2627697771>>%textPath%

    echo.Screenmanager Resolution Width_h182942802>>%textPath%

)

if %emode%==2 (

    echo.Screenmanager Fullscreen mode Default_h401710285>>%textPath%

    echo.Screenmanager Fullscreen mode_h3630240806>>%textPath%

    echo.Screenmanager Resolution Height Default_h1380706816>>%textPath%

    echo.Screenmanager Resolution Height_h2627697771>>%textPath%

    echo.Screenmanager Resolution Use Native Default_h1405981789>>%textPath%

    echo.Screenmanager Resolution Use Native_h1405027254>>%textPath%

    echo.Screenmanager Resolution Width Default_h680557497>>%textPath%

    echo.Screenmanager Resolution Width_h182942802>>%textPath%

    echo.Screenmanager Stereo 3D_h1665754519>>%textPath%

)



:: End

echo=

echo Exported in %textPath%.

