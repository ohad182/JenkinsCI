package com.marvell.ciutils

class MtsUtils{
  def steps
  
  MtsUtils(steps){
    this.steps = steps
    }
  
  def startBuild(){
    steps.echo '''
      box_name is $BOX_NAME
      box branch is $BOX_BRANCH
      build_type is $BUILD_TYPE
      '''
      
      steps.echo new File('//fileril103/dev/TOOLS/cc1tools/utils/auto_compile_git/Start_Build_Bx.pl').text
  }
}
