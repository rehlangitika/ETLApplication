import com.knoldus.application.FileConsumer
import com.knoldus.domain.FileSource

object ETLApplication {
  def main(args: Array[String]): Unit = {
    val fileList = FileSource.getFiles("C:\\Users\\dell\\IdeaProjects\\ETLApplication\\directory-files")
    println(fileList)
    FileSource.readContents("C:\\Users\\dell\\IdeaProjects\\ETLApplication\\directory-files\\demo.txt")
    FileConsumer.writeContents("C:\\Users\\dell\\IdeaProjects\\ETLApplication\\directory-files\\demo.txt")
    FileConsumer.countWords("C:\\Users\\dell\\IdeaProjects\\ETLApplication\\directory-files\\demoCount.txt")
  }
}
