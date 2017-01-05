package com.marvell.ciutils

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes

class FileUtils implements Serializable{
    def steps
    
    FileUtils(steps){
        this.steps = steps
    }
    
    def deleteIfExists(filePath){
        def returnVal = false;
        try{
        File file = new File(filePath)
        def returnStr = "${filePath} " + Files.deleteIfExists(file.toPath()) ? "was deleted" : "does not exist"
        returnVal = "${filePath} " + Files.deleteIfExists(file.toPath()) ? "was deleted" : "does not exist"
        }
        catch(all){
            returnVal = "error: " + all.getMessage()
            steps.print  "all exception properties: ${all.getProperties.toString()}"
        }
        finally{
            return returnVal
        }
    }

   def printInfo(){
       def userDir = System.getProperty("user.dir")
       def userName = System.getProperty("user.name")
       
       steps.print "user dir: ${userDir}"
       steps.print "user name: ${userName}"
       steps.print "env.home.branch= ${steps.env.BRANCH_NAME}"
       steps.print "env.nodename= ${steps.env.NODE_NAME}"
       steps.print  "steps methods: ${steps.metaClass.methods*.name.sort().unique()}"
       steps.print  "steps.env properties: ${steps.env.getProperties.toString()}"
       //demoClass.getProperties().toString()
//       """
//            echo "before"
//       echo "${userDir}"
//       echo "after"
//"""
// BasicFileAttributes attrs = Files.readAttributes(dir, BasicFileAttributes) 
//println """
        //Directory name: ${dir.fileName}
        //Absolute path: ${dir.toAbsolutePath()}
        //
        //The file exists: ${Files.exists(dir)}
        //The file is readable: ${Files.isReadable(dir)}
        //The file is writable: ${Files.isWritable(dir)}
        //The file is executable: ${Files.isExecutable(dir)}
        //The file is a directory: ${Files.isDirectory(dir)}
        //
        //Created: ${attrs.creationTime()}
        //Last modified: ${attrs.lastModifiedTime()}
        //Last accessed: ${attrs.lastAccessTime()}
        //
        //Children:"""
        //
        //
        //dir.eachFile {
        //    println "  - ${it.fileName}"
        //}
    }

    def printSomething(){
        //println steps.metaClass.methods*.name.sort()
    println "wait wait with ln"
    print "wait wait no ln"
    }
    
    def createOrUpdate(directory, fileName, extension, infoList) {
        if(directory == null)  directory = System.getProperty("user.dir")
        new File("$directory/$fileName$extension").withWriter { out ->
        out.println infoList
        }
    }
}
