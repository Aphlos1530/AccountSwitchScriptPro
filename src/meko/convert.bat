:: Convert UTF-8 file to UTF-16 LE file.

@echo off

setlocal


set input_file=%1

set output_file=%2

rem Using PowerShell script to convert file encoding

powershell -Command "$input = Get-Content -Path '%input_file%' -Encoding UTF8; Set-Content -Path '%output_file%' -Value $input -Encoding Unicode"

rem echo Converted.


endlocal

