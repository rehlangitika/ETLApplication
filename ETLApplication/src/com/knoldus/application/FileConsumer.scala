/* A singleton object for the file output source */

package com.knoldus.application

import java.io.{BufferedWriter, File, FileWriter}

import com.knoldus.domain.{DataSource, FileSource}

import scala.io.Source


object FileConsumer extends DataConsumer {

  override val dataSource: DataSource = FileSource

  override def writeContents(fileName: String) = {
    val outputFile = new File("demo.txt")
    val bw = new BufferedWriter(new FileWriter(outputFile))
    try {
      for (lines <- Source.fromFile(fileName).getLines()) {
        bw.write(lines.toUpperCase)
        bw.flush()
      }
    }
    catch {
      case ex: Exception => println("File Exception Occurred!")
    }
    finally {
      bw.close()
    }
  }

  override def countWords(sourceName: String) = {
    val outputFile = new File("demoCount.txt")
    val bw = new BufferedWriter(new FileWriter(outputFile))
    try {
      val hMap = Source.fromFile(sourceName).getLines.flatMap(_.split("\\W+")).foldLeft(Map.empty[String, Int]) { (count, word) => count + (word.toLowerCase() -> (count.getOrElse(word.toLowerCase, 0) + 1)) }
      bw.write(hMap.toString())
      bw.flush()
    }
    catch {
      case ex: Exception => println("File Exception Occurred!")
    }
    finally {
      bw.close()
    }
  }
}
