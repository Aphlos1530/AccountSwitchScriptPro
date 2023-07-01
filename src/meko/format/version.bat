:: Supproted from 0.0.0 to 9.9.9 ( OR 0.0 to 99.9 ) ( OR 0 to 999)

@echo off

set char=%1

set char=%char:.=%

set one=%char:~0,1%

set two=%char:~1,1%

set thr=%char:~2,1%

set for=%char:~3,1%

rem echo one=%one%

rem echo two=%two%

rem echo thr=%thr%

rem echo for=%for%


set rel=true

if not %for%*==* set rel=false

if %one%*==* set rel=false

if not %one%*==* echo %one%| findstr "[^0-9]">nul && set rel=false || set nul=nul

if not %two%*==* echo %two%| findstr "[^0-9]">nul && set rel=false || set nul=nul

if not %thr%*==* echo %thr%| findstr "[^0-9]">nul && set rel=false || set nul=nul

rem echo rel=%rel%
