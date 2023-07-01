:: Print some common questions

@echo off

chcp 65001 > nul


echo=

echo=

echo    已为您开启中文阅读模式

echo=

echo=

echo 1. 提示[游戏账号缓存信息错误]，显示官服登录界面

echo=

echo    出现原因： 登录哔服时 PCGameSDK.dll 文件缺失（官服启动器启动时会自动删除这个文件）

echo=

echo    解决方法：从切换器启动即可

echo=

echo=

echo 2. 明明已经更新好了，却依然提示[更新]

echo=

echo    出现原因：游戏版本未设置成最新版

echo=

echo    解决方法：运行 version correct 修改 game_version 并重启启动器

echo=

echo=

echo 3. 提示[获取游戏]

echo=

echo    出现原因：game_version 为空或不存在，或整个 config.ini 文件丢失

echo=

echo    解决方法：同上

echo=

echo=

echo 4. 进入游戏后提示[发现新版本]，但是检查游戏更新却提示[当前已是最新版本]

echo=

echo    出现原因：游戏没有更新完就强制拉升版本

echo=

echo    解决方法：降级回更新前的版本（version correct），点击检查游戏更新，重新下载

echo=

echo=

echo 5. 提示[二级地址解析失败] Not match region（3.7已不存在该问题）

echo=

echo    出现原因：原问题1

echo=

echo    解决方法：登录 def-bilibili

echo=

echo=

echo 6. 数据异常 31-4302（3.7已不存在该问题）

echo=

echo    出现原因：游戏安装目录（Genshin Impact Game）下有文件缺损或多余（如国际服未删除的 GenshinImpact.exe）

echo=

echo    解决方法：检查下 ASS 文件是不是放错位置，之前是否有放置其他文件

echo=

echo=

echo 7. 重装系统后原神打不开了

echo=

echo    出现原因：系统用户的 SID 发生了变化导致文件归属错误

echo=

echo    解决方法：更改文件持有者为自己。右键  Genshin Impact 依次点击 属性-安全-高级 输入用户名 检查 确定 勾选替换 确定 确定

echo=

echo=

echo 8. 配置文件（config.ini）无法打开，或修改后无法保存，提示没有没有权限

echo=

echo    出现原因：权限不足

echo=

echo    解决方法：右键 属性-安全-编辑 点击 Users (没有则选择Everyone) 勾选完全控制 确定 确定

echo=

