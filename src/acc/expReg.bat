:: Export the account reg file

@echo off

setLocal enableDelayedExpansion

chcp 65001 > nul



rem set key1=GENERAL_DATA_h2389025596

rem set key2=MIHOYOSDK_ADL_PROD_CN_h3123967166

rem set key3=taptapsdk_accesstoken_h155459673

rem set key4=taptapsdk_profile_h1680418541



echo=

echo Please wait a few seconds ...



:set-path

rem set mainPath=G:\Program Files\Genshin Impact\AccountSwitchScript

call ..\meko\readPath mainPath /noqo > nul

set mainPath=%value%

rem set registryPath=HKEY_CURRENT_USER\Software\miHoYo\原神

call ..\meko\readPath registryPath > nul

set registryPath=%value%

set beforePath="%mainPath%\temp\current.reg"

set afterPath="%mainPath%\temp\temp.reg"

rem echo mainPath=%mainPath%

rem echo registryPath=%registryPath%

rem echo beforePath=%beforePath%

rem echo afterPath=%afterPath%



:reg-export

if exist %beforePath% del %beforePath%

reg export %registryPath% %beforePath% > nul



:pre-text

cd.>%afterPath%

echo.Windows Registry Editor Version 5.00>>%afterPath%

echo.>>%afterPath%

echo.[%registryPath%]>>%afterPath%



:key-value

set dq="

set read=false

for /f "skip=2" %%a in ('type %beforePath%') do (

    set ch=%%a

    set fc=!ch:~0,1!

    if !fc!==!dq! (

        set read=false

        set key=!ch:~1,24!

        if !key!==GENERAL_DATA_h2389025596 set read=true

        if !key!==MIHOYOSDK_ADL_PROD_CN_h3 set read=true

        if !key!==taptapsdk_accesstoken_h1 set read=true

        if !key!==taptapsdk_profile_h16804 set read=true

        if !read!==true (

            echo.>>%afterPath%

            echo.%%a>>%afterPath%

        )

    ) else (

        if !read!==true (

            echo.  %%a>>%afterPath%

        )

   )

)



:last

del %beforePath%

rem Keep the identifiable encoding (Removing this step will result in garbled registry characters after import !)

call ..\meko\convert %afterPath% %afterPath%



:end

echo=

echo Export successfully ^^!

