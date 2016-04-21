import team._
import getRecord._
import fileWriter._
import teamData._

import scala.collection.mutable._

package object rankingsGen {
  def generateRankings(year: String, week: String, user: String): Unit = {
    println("generateRankings has been called.")
    val teamRecordMap = getRecordMap(year, week)
    
    def updateRecords(teams: Map[String, team]): Map[String, team] = {
      println("updateRecords has been called.")
      val keys = teams.keys
      for (k <- keys) {
        val team = teamMap(k)
        val name = team.name
        val teamRecordPair = teamRecordMap(name)
        val wins = teamRecordPair._1
        val losses = teamRecordPair._2
        val opponents = team.opponents
        teamMap(k) = new team(name, wins, losses, opponents)
      }
      println("Finished updateRecords")
      teamMap
    }

    def getRank(team: team): Double = {
      def getOppWins(teams: List[String], wins: Int): Int = {
        if (teams.isEmpty) wins
        else getOppWins(teams.tail, wins + teamRecordMap(teams.head)._1)
      }
      def getOppLosses(teams: List[String], losses: Int): Int = {
        if (teams.isEmpty) losses
        else getOppLosses(teams.tail, losses + teamRecordMap(teams.head)._2)
      }
      val wins = team.wins + 0.0
      val losses = team.losses + 0.0
      val oppWins = getOppWins(team.opponents.take(week.toInt-1), 0) + 0.0
      val oppLosses = getOppLosses(team.opponents.take(week.toInt-1), 0) + 0.0
      (wins) / (wins + losses) + ((oppWins) / (oppWins + oppLosses)) * (0.5)
    }

    var teamRankings = Map(" " -> 0.0)
    val keys = teamNameMap.keys

    for (k <- keys) {
      teamRankings = teamRankings + (teamNameMap(k) -> getRank(updateRecords(teamMap)(k)))
    }
    teamRankings -= " "

    var strResult = new String 
    for (line <- teamRankings.toSeq.sortBy(_._2)) {
      strResult += line.toString.drop(1).dropRight(1) + "\n"
    }
   
    fileWriter(year + "Week" + week + "Custom" + "Raw", strResult, user)
    
    var rankResult = new String 
    var counter = 1
    for (line <- teamRankings.toSeq.sortBy(_._2).reverse) {
      rankResult += line._1 + "," + counter + "\n" 
      counter = counter + 1
    }
    
    fileWriter(year + "Week" + week + "Custom", rankResult, user)
    
  }
}