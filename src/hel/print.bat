:: Print article text

@echo off

chcp 65001 > nul


if %1*==* (

    echo=

    echo Parameter empty.

    goto end

)


set filePath=

if %1==1 set filePath=..\note\使用方法.txt

if %1==2 set filePath=..\note\快速上手.txt

if %1==3 set filePath=..\note\参考资料.txt

if %1==5 set filePath=..\note\特别鸣谢.txt

if %1==6 set filePath=..\note\下载地址.txt

if %1==7 set filePath=..\note\切换原理.txt

if %1==8 set filePath=..\note\凭证导出.txt

if %1==9 set filePath=..\note\用前说明.txt

if %1==10 set filePath=..\note\关于命令.txt


if %1==4 (

    call info

    goto end

)


if %filePath%*==* (

    echo=

    echo File not exist !

    goto end

)


echo=

type %filePath%


:end

