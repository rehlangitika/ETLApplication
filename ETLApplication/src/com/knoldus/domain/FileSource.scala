/* A singleton object for file input source */

package com.knoldus.domain

import java.io.File

import scala.io.Source

object FileSource extends DataSource {

  //function to get file listing from the source directory
  override def getFiles(sourceDirectory: String): List[File] = {
    val dir = new File(sourceDirectory)
    if (dir.exists && dir.isDirectory) {
      dir.listFiles.filter(_.isFile).toList
    }
    else {
      List[File]()
    }
  }

  //function to read the contents from a file
  override def readContents(sourceName: String) = {
    try {
      for (lines <- Source.fromFile(sourceName).getLines()) {
        println(lines.toUpperCase)
      }
    }
    catch {
      case ex: Exception => println("File Exception Occurred!")
    }
  }
}
