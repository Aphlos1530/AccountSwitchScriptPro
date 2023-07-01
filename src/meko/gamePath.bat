:: Auto get game_install_path

@echo off


rem set gamePath="..\..\Genshin Impact Game"

call ..\meko\readPath gamePath > nul

set gamePath=%vaule%

for /f "delims== tokens=1,2" %%a in (..\..\config.ini) do (

    if %%a==game_install_path (

        if %%b*==*  goto next

        set gamePath=%%b

        goto next

    )

)


:next

set gamePath=%gamePath:/=\%

set gamePath="%gamePath%"

echo=

echo GamePath=%gamePath%

call saveVar gamePath %gamePath%

