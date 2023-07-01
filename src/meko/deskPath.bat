:: Get current user desktop path

set deskPath = ""

set rep="HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Explorer\Shell Folders"

for /f "tokens=2,*" %%i in ('reg query %rep% /v "Desktop"') do (

    set deskPath=%%j

)

echo=

echo deskPath=%deskPath%

