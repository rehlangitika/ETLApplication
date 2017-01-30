package com.knoldus.domain

abstract class DataSource {

  //function to get the listing from a particular input source(can be a directory or SQL Database, etc )
  def getFiles(source: String): List[Any]


  //function to read out the contents from the input source (can be a file or SQL Table, etc)
  def readContents(sourceName: String)

}
