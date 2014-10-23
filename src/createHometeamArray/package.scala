import fileWriter._
import scala.io.Source
import java.io._

package object createHometeamArray {
  def createHomeArrays(year: String, user: String) = {

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

    def getTeamHome(str: String): String = {
      val homeString = """<li class="game-status">vs"""
      val visitString = """<li class="game-status">@"""
      val byeString = """BYE WEEK"""

      def helper(str: String, helperResult: String, counter: Int): String = {
        if (counter == 17) helperResult
        else if (str.take(homeString.length).equals(homeString)) helper(str.drop(homeString.length), helperResult + ", true", counter + 1)
        else if (str.take(visitString.length).equals(visitString) || str.take(byeString.length).equals(byeString)) helper(str.drop(byeString.length), helperResult + ", false", counter + 1)
        else helper(str.drop(1), helperResult, counter)
      }

      helper(str, "false", 0)
    }

    var homeString = new String
    homeString += "bool HCardinals []= {" + getTeamHome(trimWebStr("ari")) + "};\n"
    homeString += "bool HFalcons []= {" + getTeamHome(trimWebStr("atl")) + "};\n"
    homeString += "bool HRavens []= {" + getTeamHome(trimWebStr("bal")) + "};\n"
    homeString += "bool HBills []= {" + getTeamHome(trimWebStr("buf")) + "};\n"
    homeString += "bool HPanthers []= {" + getTeamHome(trimWebStr("car")) + "};\n"
    homeString += "bool HBears []= {" + getTeamHome(trimWebStr("chi")) + "};\n"
    homeString += "bool HBengals []= {" + getTeamHome(trimWebStr("cin")) + "};\n"
    homeString += "bool HBrowns []= {" + getTeamHome(trimWebStr("cle")) + "};\n"
    homeString += "bool HCowboys []= {" + getTeamHome(trimWebStr("dal")) + "};\n"
    homeString += "bool HBroncos []= {" + getTeamHome(trimWebStr("den")) + "};\n"
    homeString += "bool HLions []= {" + getTeamHome(trimWebStr("det")) + "};\n"
    homeString += "bool HPackers []= {" + getTeamHome(trimWebStr("gb")) + "};\n"
    homeString += "bool HTexans []= {" + getTeamHome(trimWebStr("hou")) + "};\n"
    homeString += "bool HColts []= {" + getTeamHome(trimWebStr("ind")) + "};\n"
    homeString += "bool HJaguars []= {" + getTeamHome(trimWebStr("jax")) + "};\n"
    homeString += "bool HChiefs []= {" + getTeamHome(trimWebStr("kc")) + "};\n"
    homeString += "bool HDolphins []= {" + getTeamHome(trimWebStr("mia")) + "};\n"
    homeString += "bool HVikings []= {" + getTeamHome(trimWebStr("min")) + "};\n"
    homeString += "bool HPatriots []= {" + getTeamHome(trimWebStr("ne")) + "};\n"
    homeString += "bool HSaints []= {" + getTeamHome(trimWebStr("no")) + "};\n"
    homeString += "bool HGiants []= {" + getTeamHome(trimWebStr("nyg")) + "};\n"
    homeString += "bool HJets []= {" + getTeamHome(trimWebStr("nyj")) + "};\n"
    homeString += "bool HRaiders []= {" + getTeamHome(trimWebStr("oak")) + "};\n"
    homeString += "bool HEagles []= {" + getTeamHome(trimWebStr("phi")) + "};\n"
    homeString += "bool HSteelers []= {" + getTeamHome(trimWebStr("pit")) + "};\n"
    homeString += "bool HRams []= {" + getTeamHome(trimWebStr("stl")) + "};\n"
    homeString += "bool HChargers []= {" + getTeamHome(trimWebStr("sd")) + "};\n"
    homeString += "bool HFortyNiners []= {" + getTeamHome(trimWebStr("sf")) + "};\n"
    homeString += "bool HSeahawks []= {" + getTeamHome(trimWebStr("sea")) + "};\n"
    homeString += "bool HBuccaneers []= {" + getTeamHome(trimWebStr("tb")) + "};\n"
    homeString += "bool HTitans []= {" + getTeamHome(trimWebStr("ten")) + "};\n"
    homeString += "bool HRedskins []= {" + getTeamHome(trimWebStr("wsh")) + "};\n"

    fileWriter(year + "TeamHome", homeString, user)
  }
}