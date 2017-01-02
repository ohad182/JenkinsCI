package com.marvell.ciutils

class GrasRunner{
  def steps
  
  GrasRunner(steps){
    this.steps = steps
  }
  
  
  def runGras(){
  
  steps.bat """
    cd "c:\Program Files (x86)\Marvell\GRAS"

    GRAS.exe ?
  """
  }



}
