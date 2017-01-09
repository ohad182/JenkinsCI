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
startBuild
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
compilationProcess
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
buildProcess
box_name is: ${env.BOX_NAME}
box_branch is: ${env.BOX_BRANCH}
core_branch is: ${env.CORE_BRANCH}
mts_build_system_branch is: ${env.MTS_BUILD_SYSTEM_BRANCH}
rest_api_branch is: ${env.REST_API_BRANCH}
build_type is: ${env.BUILD_TYPE}
webs_are_separated is: ${env.Webs_are_separated}
      """
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
  def installBmImage(){
    steps.echo """
installBmImage
box_name is: ${env.BOX_NAME}
box_branch is: ${env.BOX_BRANCH}
core_branch is: ${env.CORE_BRANCH}
mts_build_system_branch is: ${env.MTS_BUILD_SYSTEM_BRANCH}
rest_api_branch is: ${env.REST_API_BRANCH}
build_type is: ${env.BUILD_TYPE}
webs_are_separated is: ${env.Webs_are_separated}
Tests_Are_Needed is: ${env.Tests_Are_Needed}
      """
  }
  
  def createReport(){
     steps.echo """
createReport
box_name is: ${env.BOX_NAME}
box_branch is: ${env.BOX_BRANCH}
core_branch is: ${env.CORE_BRANCH}
mts_build_system_branch is: ${env.MTS_BUILD_SYSTEM_BRANCH}
rest_api_branch is: ${env.REST_API_BRANCH}
build_type is: ${env.BUILD_TYPE}
webs_are_separated is: ${env.Webs_are_separated}
Tests_Are_Needed is: ${env.Tests_Are_Needed}
      """
  }
  
  def grasTests(){
     steps.echo """
grasTests
box_name is: ${env.BOX_NAME}
box_branch is: ${env.BOX_BRANCH}
core_branch is: ${env.CORE_BRANCH}
mts_build_system_branch is: ${env.MTS_BUILD_SYSTEM_BRANCH}
rest_api_branch is: ${env.REST_API_BRANCH}
build_type is: ${env.BUILD_TYPE}
webs_are_separated is: ${env.Webs_are_separated}
Tests_Are_Needed is: ${env.Tests_Are_Needed}
      """
  }
  
  def finishBuild(){
     steps.echo """
finishBuild
box_name is: ${env.BOX_NAME}
box_branch is: ${env.BOX_BRANCH}
core_branch is: ${env.CORE_BRANCH}
mts_build_system_branch is: ${env.MTS_BUILD_SYSTEM_BRANCH}
rest_api_branch is: ${env.REST_API_BRANCH}
build_type is: ${env.BUILD_TYPE}
webs_are_separated is: ${env.Webs_are_separated}
Tests_Are_Needed is: ${env.Tests_Are_Needed}
      """
  }
}
