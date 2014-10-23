import fileWriter._
import scala.io.Source
import java.io._

package object createTeamSchedule {
	def createScheduleArrays(year: String, user: String) = {

    def trimWebStr(team: String): String = {
      val site = "http://espn.go.com/nfl/team/schedule/_/name/" + team + "/year/" + year
      val str = Source.fromURL(site, "UTF-8").mkString
      val begin = year + " Regular Season Schedule"

      def helper(webStr: String): String = {
        if (webStr.take(begin.length) == begin) webStr
        else helper(webStr.drop(1))
      }

      helper(str)
    }

    def getOpponent(str: String): String = {
      val teamStr = """http://espn.go.com/nfl/team/_/name/"""

      def trimStr(s: String): String = {
        if (s.take(teamStr.length).equals(teamStr)) s
        else trimStr(s.drop(1))
      }

      val teamMap = Map("sea" -> "CSeahawks", "den" -> "CBroncos", "sf/" -> "CFortyNiners", "ne/" -> "CPatriots",
        "no/" -> "CSaints", "gb/" -> "CPackers", "ind" -> "CColts", "ari" -> "CCardinals", "phi" -> "CEagles",
        "cin" -> "CBengals", "car" -> "CPanthers", "chi" -> "CBears", "bal" -> "CRavens", "atl" -> "CFalcons",
        "kc/" -> "CChiefs", "sd/" -> "CChargers", "pit" -> "CSteelers", "stl" -> "CRams", "nyg" -> "CGiants",
        "det" -> "CLions", "nyj" -> "CJets", "dal" -> "CCowboys", "tb/" -> "CBuccaneers", "mia" -> "CDolphins",
        "ten" -> "CTitans", "hou" -> "CTexans", "buf" -> "CBills", "wsh" -> "CRedskins", "min" -> "CVikings",
        "jax" -> "CJaguars", "oak" -> "CRaiders", "cle" -> "CBrowns")

      val trimmedStr = trimStr(str)
      val team = trimmedStr.drop(teamStr.length).take(3)
      teamMap(team)
    }

    def getTeamSchedule(str: String): String = {
      val homeString = """<li class="game-status">vs"""
      val visitString = """<li class="game-status">@"""
      val byeString = """BYE WEEK"""

      def helper(str: String, helperResult: String, counter: Int): String = {
        if (counter == 17) helperResult
        else if (str.take(homeString.length).equals(homeString)) helper(str.drop(homeString.length), helperResult + ", " + getOpponent(str.drop(homeString.length)), counter + 1)
        else if (str.take(visitString.length).equals(visitString)) helper(str.drop(visitString.length), helperResult + ", " + getOpponent(str.drop(visitString.length)), counter + 1)
        else if (str.take(byeString.length).equals(byeString)) helper(str.drop(byeString.length), helperResult + ", 0", counter + 1)
        else helper(str.drop(1), helperResult, counter)
      }

      helper(str, "0", 0)
    }

    var scheduleString = new String
    scheduleString += "int OCardinals []= {" + getTeamSchedule(trimWebStr("ari")) + "};\n"
    scheduleString += "int OFalcons []= {" + getTeamSchedule(trimWebStr("atl")) + "};\n"
    scheduleString += "int ORavens []= {" + getTeamSchedule(trimWebStr("bal")) + "};\n"
    scheduleString += "int OBills []= {" + getTeamSchedule(trimWebStr("buf")) + "};\n"
    scheduleString += "int OPanthers []= {" + getTeamSchedule(trimWebStr("car")) + "};\n"
    scheduleString += "int OBears []= {" + getTeamSchedule(trimWebStr("chi")) + "};\n"
    scheduleString += "int OBengals []= {" + getTeamSchedule(trimWebStr("cin")) + "};\n"
    scheduleString += "int OBrowns []= {" + getTeamSchedule(trimWebStr("cle")) + "};\n"
    scheduleString += "int OCowboys []= {" + getTeamSchedule(trimWebStr("dal")) + "};\n"
    scheduleString += "int OBroncos []= {" + getTeamSchedule(trimWebStr("den")) + "};\n"
    scheduleString += "int OLions []= {" + getTeamSchedule(trimWebStr("det")) + "};\n"
    scheduleString += "int OPackers []= {" + getTeamSchedule(trimWebStr("gb")) + "};\n"
    scheduleString += "int OTexans []= {" + getTeamSchedule(trimWebStr("hou")) + "};\n"
    scheduleString += "int OColts []= {" + getTeamSchedule(trimWebStr("ind")) + "};\n"
    scheduleString += "int OJaguars []= {" + getTeamSchedule(trimWebStr("jax")) + "};\n"
    scheduleString += "int OChiefs []= {" + getTeamSchedule(trimWebStr("kc")) + "};\n"
    scheduleString += "int ODolphins []= {" + getTeamSchedule(trimWebStr("mia")) + "};\n"
    scheduleString += "int OVikings []= {" + getTeamSchedule(trimWebStr("min")) + "};\n"
    scheduleString += "int OPatriots []= {" + getTeamSchedule(trimWebStr("ne")) + "};\n"
    scheduleString += "int OSaints []= {" + getTeamSchedule(trimWebStr("no")) + "};\n"
    scheduleString += "int OGiants []= {" + getTeamSchedule(trimWebStr("nyg")) + "};\n"
    scheduleString += "int OJets []= {" + getTeamSchedule(trimWebStr("nyj")) + "};\n"
    scheduleString += "int ORaiders []= {" + getTeamSchedule(trimWebStr("oak")) + "};\n"
    scheduleString += "int OEagles []= {" + getTeamSchedule(trimWebStr("phi")) + "};\n"
    scheduleString += "int OSteelers []= {" + getTeamSchedule(trimWebStr("pit")) + "};\n"
    scheduleString += "int ORams []= {" + getTeamSchedule(trimWebStr("stl")) + "};\n"
    scheduleString += "int OChargers []= {" + getTeamSchedule(trimWebStr("sd")) + "};\n"
    scheduleString += "int OFortyNiners []= {" + getTeamSchedule(trimWebStr("sf")) + "};\n"
    scheduleString += "int OSeahawks []= {" + getTeamSchedule(trimWebStr("sea")) + "};\n"
    scheduleString += "int OBuccaneers []= {" + getTeamSchedule(trimWebStr("tb")) + "};\n"
    scheduleString += "int OTitans []= {" + getTeamSchedule(trimWebStr("ten")) + "};\n"
    scheduleString += "int ORedskins []= {" + getTeamSchedule(trimWebStr("wsh")) + "};\n"

    fileWriter(year + "TeamSchedules", scheduleString, user)
  }                                               //> createScheduleArrays: (year: String)Unit
}
