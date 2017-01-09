package com.marvell.ciutils

class MtsUtils{
  def env
  def steps
  MtsUtils(env, steps){
    this.env = env
    this.steps = steps
    }
  
 /**
 * This task started the MTS build process from Linux station
 * This task is running with 3 parameters:
 * 1. BOX_NAME
 * 2. BOX_BRANCH
 * 3. BUILD_TYPE (box or core)
 */
  def startBuild(){
    steps.echo """
             box_name is ${env.BOX_NAME}
             box_branch is ${env.BOX_BRANCH}
             build_type is ${env.BUILD_TYPE}
      """
    //send to the .pl these three vars {filePath} $BOX_NAME $BOX_BRANCH $BUILD_TYPE
    def pearlFileWindows = "//fileril103/dev/TOOLS/cc1tools/utils/auto_compile_git/Start_Build_Bx.pl"
    def pearlFileLinux = "/swdev/fileril103/TOOLS/cc1tools/utils/auto_compile_git/Start_Build_Bx.pl"
    steps.echo new File(pearlFileWindows).text
  }
  
 /**
 * COMP process for MTS on Linux
 * This task is running with 6 parameters:
 * 1. BOX_NAME
 * 2. BOX_BRANCH
 * 3. CORE_BRANCH
 * 4. MTS_BUILD_SYSTEM_BRANCH
 * 5. REST_API_BRANCH (if not needed the valiew is NA)
 * The parameters are getting from the specjfic build task
 * 6. BUILD_TYPE (box or core)
 */
  def compilationProcess(){
    steps.echo """
            box_name is: ${env.BOX_NAME}
            box_branch is: ${env.BOX_BRANCH}
            core_branch is: ${env.CORE_BRANCH}
            mts_build_system_branch is: ${env.MTS_BUILD_SYSTEM_BRANCH}
            rest_api_branch is: ${env.REST_API_BRANCH}
            build_type is: ${env.BUILD_TYPE}
            webs_are_separated is: ${env.Webs_are_separated}
            tests_are_needed is: ${env.Tests_Are_Needed}
      """
    //send to the .pl these three vars
    // ${env.BOX_NAME} ${env.BOX_BRANCH} ${env.CORE_BRANCH} ${env.MTS_BUILD_SYSTEM_BRANCH} ${env.REST_API_BRANCH} ${env.BUILD_TYPE} ${env.Webs_are_separated} ${env.INTERNAL} ${env.SNA_WEB_BRANCH} ${env.SNA_GUI_BRANCH} ${env.WEB_CORE_GUI_BRANCH} ${env.BX_WEB_NAME} ${env.BX_WEB_BRANCH} > /swdev/fileril103/TOOLS/CC_SUPPORT/logs/MTS_COMPILATION/COMP_"${env.BUILD_TYPE}"_"${env.BOX_BRANCH}"_`date +\%Y\%m\%d\%H\%M`.log"
    def pearlFileWindows = "//fileril103/dev/TOOLS/cc1tools/utils/auto_compile_git/ros_compilation_git_no_webs.pl"
    def pearlFileLinux = "/swdev/fileril103/TOOLS/cc1tools/utils/auto_compile_git/ros_compilation_git_no_webs.pl"
    steps.echo new File(pearlFileWindows).text
  }
  
 /**
 * Creating BL process for MTS on vxworks
 * This task is running with 5 parameters:
 * 1. BOX_NAME
 * 2. BOX_BRANCH
 * 3. CORE_BRANCH
 * 4. MTS_BUILD_SYSTEM_BRANCH
 * 5. BUILD_TYPE (box or core)
 */
  def buildProcess(){
    steps.echo """
            box_name is: ${env.BOX_NAME}
            box_branch is: ${env.BOX_BRANCH}
            core_branch is: ${env.CORE_BRANCH}
            mts_build_system_branch is: ${env.MTS_BUILD_SYSTEM_BRANCH}
            rest_api_branch is: ${env.REST_API_BRANCH}
            build_type is: ${env.BUILD_TYPE}
            webs_are_separated is: ${env.Webs_are_separated}
      """
/**set HOME=c:\Users\yedidiaf
*set PERLBIN=\\fileril103\dev\TOOLS\cc1tools\perl\bin
*set SCRIPTDIR=\\fileril103\dev\TOOLS\cc1tools\utils\auto_compile_git\
*For /f "tokens=2-4 delims=/ " %%a in ('date /t') do (set mydate=%%c%%a%%b)
*For /f "tokens=1-2 delims=/:" %%a in ('time /t') do (set mytime=%%a%%b)
*set STAMP=%mydate%%mytime%.log
*echo STAMP is %STAMP%
*
*IF EXIST ..\baseline.txt del ..\baseline.txt
*copy /Y \\fileril103\dev\Objects_Git\%BOX_NAME%\%BOX_BRANCH%\next_BL_done.txt ..\baseline.txt
*::copy /Y \\fileril103\dev\Objects_Git\cisco_tesla_bx\cisco_tesla_bx_v2.3\next_BL_done.txt ..\baseline.txt
*set /p BL=<..\baseline.txt
*
*::%PERLBIN%\perl.exe %SCRIPTDIR%\ros_compilation_git_BL_NO_WEB.pl %BOX_NAME% %BOX_BRANCH% %CORE_BRANCH% %MTS_BUILD_SYSTEM_BRANCH% %BUILD_TYPE% > ::\\fileril103\dev\TOOLS\CC_SUPPORT\logs\MTS_COMPILATION\BL_%BUILD_TYPE%_%BOX_BRANCH%_%STAMP%.log 2>&1
*
*
*%PERLBIN%\perl.exe %SCRIPTDIR%\ros_compilation_git_BL_no_webs.pl %BOX_NAME% %BOX_BRANCH% %CORE_BRANCH% %MTS_BUILD_SYSTEM_BRANCH% %BUILD_TYPE% %Webs_are_separated% %SNA_WEB_BRANCH% %SNA_GUI_BRANCH% %WEB_CORE_GUI_BRANCH% %BX_WEB_NAME% %BX_WEB_BRANCH%  %Webs_are_separated%  > \\fileril103\dev\TOOLS\CC_SUPPORT\logs\MTS_COMPILATION\BL_%BUILD_TYPE%_%BOX_BRANCH%_%STAMP%.log 2>&1
*/





  }
  
}
