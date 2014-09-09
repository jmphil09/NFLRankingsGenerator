import team._
import getRecord._
import fileWriter._
import teamData._

import scala.collection.mutable._

package object rankingsGen {
  def generateRankings(year: String, week: String): Unit = {
    val teamRecordMap = getRecordMap(year)
    
    def updateRecords(teams: Map[String, team]): Map[String, team] = {
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
      teams
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
      (team.wins + 0.0) / (team.wins + team.losses) + (getOppWins(team.opponents, 0) + 0.0) / (getOppWins(team.opponents, 0) + getOppLosses(team.opponents, 0)) * (0.5)
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
   
    fileWriter(year + "Week" + week, strResult)
  }
}