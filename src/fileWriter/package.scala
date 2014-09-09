import java.io._

package object fileWriter {
	def fileWriter(filename: String, rankStr: String) = {
      //val writer = new PrintWriter(new File("C:/Users/James/Desktop/git-workspace/NFLRankingsGenerator/data/" + filename + ".txt" )) //FOR LAPTOP
      val writer = new PrintWriter(new File("C:/Users/fligh_000/Desktop/git-workspace/NFLRankingsGenerator/data/" + filename + ".txt")) //FOR PC
      writer.write(rankStr)
      writer.close()
    }
}