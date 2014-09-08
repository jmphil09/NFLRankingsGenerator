import java.io._

package object fileWriter {
	def fileWriter(filename: String, rankStr: String) = {
      val writer = new PrintWriter(new File("C:/Users/James/Desktop/git-workspace/NFLRankingsGenerator/data/" + filename + ".txt" ))
      //val writer = new PrintWriter(new File("C:/Users/fligh_000/Desktop/git-workspace/NFLRankingsGenerator/data/" + filename + ".txt"))
      writer.write(rankStr)
      writer.close()
    }
}