package team

import scala.io.Source

object getRecord {
  def getRecordMap(year: String, week: String): Map[String, (Int, Int)] = {
    def countSubstring(str: String, substr: String) = substr.r.findAllMatchIn(str).length
    
    def nthOccurence(str: String, substring: String, index: Int, counter: Int): Int = {
      if(counter==0) index
      else {
        val substrLen = substring.length
        val newStr = str.take(substrLen)
        if(newStr.equals(substring)) nthOccurence(str.drop(substrLen), substring, index + substrLen, counter - 1)
        else nthOccurence(str.drop(1), substring, index + 1, counter)
      }
    }
    
    val dummySite = "http://espn.go.com/nfl/team/_/name/" + "dal" + "/year/" + year
    val dummyStr = Source.fromURL(dummySite).mkString
    val dropSubstr = year + " Regular Season Schedule"
    val dropIndex = nthOccurence(dummyStr, dropSubstr, 0 , 1) - 500

    def getWebStr(team: String): String = {
      val site = "http://espn.go.com/nfl/team/_/name/" + team + "/year/" + year
      val str = Source.fromURL(site).mkString
      val trimmedStr = str.drop(dropIndex)
      
      val endIndex = nthOccurence(trimmedStr, """<li class="game-status">""", 0, week.toInt)
      
      trimmedStr.take(endIndex)
    }

    def calcRecord(teamStr: String): (Int, Int) = {
      val winStr = "game-status win"
      val lossStr = "game-status loss"

      val wins = countSubstring(teamStr, winStr)
      val losses = countSubstring(teamStr, lossStr)
      (wins, losses)
    }

    val teamMap = Map("sea" -> "Seattle", "den" -> "Denver", "sf" -> "San Francisco", "ne" -> "New England",
      "no" -> "New Orleans", "gb" -> "Green Bay", "ind" -> "Indianapolis", "ari" -> "Arizona", "phi" -> "Philadelphia",
      "cin" -> "Cincinnati", "car" -> "Carolina", "chi" -> "Chicago", "bal" -> "Baltimore", "atl" -> "Atlanta",
      "kc" -> "Kansas City", "sd" -> "San Diego", "pit" -> "Pittsburgh", "stl" -> "St. Louis", "nyg" -> "NY Giants",
      "det" -> "Detroit", "nyj" -> "NY Jets", "dal" -> "Dallas", "tb" -> "Tampa Bay", "mia" -> "Miami",
      "ten" -> "Tennessee", "hou" -> "Houston", "buf" -> "Buffalo", "wsh" -> "Washington", "min" -> "Minnesota",
      "jax" -> "Jacksonville", "oak" -> "Oakland", "cle" -> "Cleveland")

    var recordMap = Map("" -> (0, 0))

    for (key <- teamMap.keys) {
      recordMap = recordMap + (key -> calcRecord(getWebStr(key)))
    }

    recordMap - ("")
  }
}
