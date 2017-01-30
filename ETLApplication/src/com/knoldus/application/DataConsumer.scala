package com.knoldus.application

import com.knoldus.domain.DataSource

abstract class DataConsumer {

  //field to take the desired input source which can be file source or database source etc
  val dataSource: DataSource

  //function to write out the contents from an input source to an output source
  def writeContents(sourceName: String)

  //function to count the words from an input source to an output source
  def countWords(sourceName: String)

}
