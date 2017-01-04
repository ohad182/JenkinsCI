package com.marvell.ciutils

class MtsUtils{
  def steps
  
  MtsUtils(steps){
    this.steps = steps
    }
  
  def startBuild(){
    steps.print '''
             box_name is ${steps.env.BOX_NAME}
             box branch is ${steps.env.BOX_BRANCH}
             build_type is ${steps.env.BUILD_TYPE}
      '''
      
      steps.echo new File('//fileril103/dev/TOOLS/cc1tools/utils/auto_compile_git/Start_Build_Bx.pl').text
  }
}
