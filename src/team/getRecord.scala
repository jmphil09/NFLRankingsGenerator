package team

import scala.io.Source

object getRecord {
  def getRecordMap(year: String): Map[String, (Int, Int)] = {
    val teamMap = Map("sea" -> "Seattle", "den" -> "Denver", "sf" -> "San Francisco", "ne" -> "New England",
      "no" -> "New Orleans", "gb" -> "Green Bay", "ind" -> "Indianapolis", "ari" -> "Arizona", "phi" -> "Philadelphia",
      "cin" -> "Cincinnati", "car" -> "Carolina", "chi" -> "Chicago", "bal" -> "Baltimore", "atl" -> "Atlanta",
      "kc" -> "Kansas City", "sd" -> "San Diego", "pit" -> "Pittsburgh", "stl" -> "St. Louis", "nyg" -> "NY Giants",
      "det" -> "Detroit", "nyj" -> "NY Jets", "dal" -> "Dallas", "tb" -> "Tampa Bay", "mia" -> "Miami",
      "ten" -> "Tennessee", "hou" -> "Houston", "buf" -> "Buffalo", "wsh" -> "Washington", "min" -> "Minnesota",
      "jax" -> "Jacksonville", "oak" -> "Oakland", "cle" -> "Cleveland")

    def trimWebStr(team: String): String = {
      val site = "http://espn.go.com/nfl/team/_/name/" + team + "/year/" + year
      val str = Source.fromURL(site).mkString
      val cityName = teamMap(team)
      val begin = """</div></a><div class="record"><h6>""" + cityName + """</h6><br>"""

      def helper(webStr: String): String = {
        if (webStr.take(begin.length) == begin) webStr.take(begin.length + 7).drop(begin.length + 1)
        else helper(webStr.drop(1))
      }

      helper(str)
    }

    def getWins(str: String): Int = {
      if (str.drop(1).take(1).equals("-")) str.take(1).toInt
      else str.take(2).toInt
    }

    def getLosses(str: String): Int = {
      if (!str.take(1).equals("-")) getLosses(str.drop(1))
      else if (str.take(3).drop(2).equals(")")) str.take(2).drop(1).toInt
      else str.take(3).drop(1).toInt
    }

    var recordMap = Map("" -> (0, 0))

    for (key <- teamMap.keys) {
      val recordStr = trimWebStr(key)
      val wins = getWins(recordStr)
      val losses = getLosses(recordStr)
      recordMap = recordMap + (key -> (wins, losses))
    }

    recordMap - ("")

  }
}
