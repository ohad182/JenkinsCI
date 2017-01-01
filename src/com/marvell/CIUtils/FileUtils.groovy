package com.marvell.utils

import  java.nio.file.*

class FileUtils{

    def deleteIfExists(filePath){
        File file = new File(filePath)
        return Files.deleteIfExists(file.toPath())
    }

    def createOrUpdate(directory, fileName, extension, infoList) {
        if(directory == null)  directory = System.getProperty("user.dir")
        new File("$directory/$fileName$extension").withWriter { out ->
        out.println infoList
        }
    }
}
