:: Create Shortcut

@echo off


echo=

echo Creating Shortcut ...


:: Namesake variable

rem set StartPath=%1

rem set SourcePath=%2

rem set LinkPath=%3

rem set IconPath=%4


rem echo StartPath=%StartPath%

rem echo SourcePath=%SourcePath%

rem echo LinkPath=%LinkPath%

rem echo IconPath=%IconPath%


:: Set temporary VBScript file_path

set SCRIPT="%TEMP%\%RANDOM%-%RANDOM%-%RANDOM%-%RANDOM%.VBS"

rem echo ScriptPath=%SCRIPT%

rem echo=


:: CreateShort

echo Set oWS=WScript.CreateObject("WScript.Shell") >> %SCRIPT%

echo Set oLink=oWS.CreateShortcut(%LinkPath%) >> %SCRIPT%


:: Set attributes

goto set

:: Arguments        目标程序参数
:: Description      快捷方式备注
:: FullName         返回快捷方式完整路径
:: Hotkey           快捷方式快捷键
:: IconLocation     快捷方式图标
:: TargetPath       目标路径
:: WindowStyle      窗口启动状态
:: WorkingDirectory 起始位置

:set

echo oLink.TargetPath=%SourcePath% >> %SCRIPT%

echo oLink.WorkingDirectory=%StartPath% >> %SCRIPT%

echo oLink.IconLocation=%IconPath% >> %SCRIPT%

rem The custom icon seems not very clear, so not set here


:: Save the shortcut

echo oLink.Save >> %SCRIPT%


:: Execute the vbs cscript file

cscript /nologo %SCRIPT%

:: Delete temporary script file

del %SCRIPT%


:end

echo=

echo Created successfully .

