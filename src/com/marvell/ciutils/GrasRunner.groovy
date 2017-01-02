package com.marvell.ciutils

class GrasRunner{
  def steps
  
  GrasRunner(steps){
    this.steps = steps
  }
  
  
  def runGras(){
    steps.print "start gras"
    steps.bat """
      cd "c:/Program Files (x86)/Marvell/GRAS"

      runas /user:Administrator GRAS.exe ?
    """
  steps.print "end gras"
  }



}
