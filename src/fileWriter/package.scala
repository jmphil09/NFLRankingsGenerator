import java.io._

package object fileWriter {
	def fileWriter(filename: String, rankStr: String, user: String) = {
    val writer = new PrintWriter(new File("C:/Users/" + user + "/Desktop/git-workspace/NFLRankingsGenerator/data/" + filename + ".txt" ))
	  //val writer = new PrintWriter(new File("C:/Users/" + user + "/Documents/src/NFLRankingsGenerator/data/" + filename + ".txt" ))  
    //val writer = new PrintWriter(new File("C:/Users/" + user + "/Desktop/git-workspace/NFLRankingsGenerator/data/" + filename + ".txt" ))
      writer.write(rankStr)
      writer.close()
    }
}