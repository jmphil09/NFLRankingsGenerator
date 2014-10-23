import scala.io.Source
import java.io._

//import fileWriter.fileWriter._

object apitest {
/*
  def fileWriter(filename: String, rankStr: String) = {
    val writer = new PrintWriter(new File("C:/Users/James/Desktop/git-workspace/NFLRankingsFetcher/NFLRankingsFetcher/data/" + filename + ".txt" ))
    //val writer = new PrintWriter(new File("C:/Users/fligh_000/Desktop/git-workspace/NFLRankingsFetcher/NFLRankingsFetcher/data/" + filename + ".txt"))
    writer.write(rankStr)
    writer.close()
  }

  def createWeekRankings(year: String, week: String) = {
    val site = "http://espn.go.com/nfl/powerrankings/_/year/" + year + "/" + "week/" + week
    val teamStr = Source.fromURL(site, "UTF-8").mkString

    def getTeams(str: String): List[String] = {

      val teamBeginOdd = """<tr class="oddrow" align=left><td class="pr-rank">"""
      val teamBeginEven = """<tr class="evenrow" align=left><td class="pr-rank">"""
      val teamEnd = """</td></tr>"""
      val beginLengthOdd = teamBeginOdd.length
      val beginLengthEven = teamBeginEven.length
      val endLength = teamEnd.length

      def findStrEnd(str: String): Int = {
        for (i <- 0 to str.length - 1) {
          if (str.drop(i).take(endLength) == teamEnd) return i + endLength
        }
        0
      }

      def helper(str: String, list: List[String]): List[String] = {
        if (list.length == 32) list
        else if (str.take(beginLengthOdd) == teamBeginOdd || str.take(beginLengthEven) == teamBeginEven) {
          val endIndex = findStrEnd(str)
          val strResult = str.take(endIndex)
          helper(str.drop(endLength), list ++ List(strResult))
        } else helper(str.drop(1), list)
      }

      helper(str, List())
    }

    val allTeams = getTeams(teamStr)

    def getTeamRank(str: String): Int = {
      def helper(str: String, counter: Int): String = {
        if (counter == 2) str.take(2)
        else if (str(0) == '>') helper(str.drop(1), counter + 1)
        else helper(str.drop(1), counter)
      }
      val rank = helper(str, 0)

      if (rank.drop(1) == "<") rank.take(1).toInt
      else rank.toInt
    }

    def getTeamName(str: String): String = {

      val teamMap = Map("Seah" -> "Seahawks", "Bron" -> "Broncos", "49er" -> "49ers", "Patr" -> "Patriots",
        "Sain" -> "Saints", "Pack" -> "Packers", "Colt" -> "Colts", "Card" -> "Cardinals", "Eagl" -> "Eagles",
        "Beng" -> "Bengals", "Pant" -> "Panthers", "Bear" -> "Bears", "Rave" -> "Ravens", "Falc" -> "Falcons",
        "Chie" -> "Chiefs", "Char" -> "Chargers", "Stee" -> "Steelers", "Rams" -> "Rams", "Gian" -> "Giants",
        "Lion" -> "Lions", "Jets" -> "Jets", "Cowb" -> "Cowboys", "Bucc" -> "Buccaneers", "Dolp" -> "Dolphins",
        "Tita" -> "Titans", "Texa" -> "Texans", "Bill" -> "Bills", "Reds" -> "Redskins", "Viki" -> "Vikings",
        "Jagu" -> "Jaguars", "Raid" -> "Raiders", "Brow" -> "Browns")

      def helper(str: String, counter: Int): String = {
        if (counter == 10) str.take(4)
        else if (str(0) == '>') helper(str.drop(1), counter + 1)
        else helper(str.drop(1), counter)
      }

      teamMap(helper(str, 0))
    }

    var teamRankings = Map(" " -> 0)

    for (team <- allTeams) {
      teamRankings = teamRankings + (getTeamName(team) -> getTeamRank(team))
    }

    teamRankings -= " "

    var strResult = new String
    for (line <- teamRankings.toSeq.sortBy(_._2)) {
      strResult += line.toString.drop(1).dropRight(1) + "\n"
    }

    fileWriter(year + "Week" + week, strResult)

  }

  def createDummyRankings(year: String, week: String) = {
    val dummyTeamMap = Map("Seahawks" -> 0, "Broncos" -> 0, "49ers" -> 0, "Patriots" -> 0,
      "Saints" -> 0, "Packers" -> 0, "Colts" -> 0, "Cardinals" -> 0, "Eagles" -> 0,
      "Bengals" -> 0, "Panthers" -> 0, "Bears" -> 0, "Ravens" -> 0, "Falcons" -> 0,
      "Chiefs" -> 0, "Chargers" -> 0, "Steelers" -> 0, "Rams" -> 0, "Giants" -> 0,
      "Lions" -> 0, "Jets" -> 0, "Cowboys" -> 0, "Buccaneers" -> 0, "Dolphins" -> 0,
      "Titans" -> 0, "Texans" -> 0, "Bills" -> 0, "Redskins" -> 0, "Vikings" -> 0,
      "Jaguars" -> 0, "Raiders" -> 0, "Browns" -> 0)

    var dummyStrResult = new String
    for (line <- dummyTeamMap.toSeq.sortBy(_._2)) {
      dummyStrResult += line.toString.drop(1).dropRight(1) + "\n"
    }

    fileWriter(year + "Week" + week, dummyStrResult)

  }

  //createDummyRankings("2014", "1")
  createWeekRankings("2014", "8")
 */
  val dummy = "DONE"                              //> dummy  : String = DONE
}