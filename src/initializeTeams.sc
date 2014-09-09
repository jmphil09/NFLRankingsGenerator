import team._
import getRecord._

import scala.collection.mutable._

object initializeTeams {
  val teamNameMap = Map("sea" -> "Seattle", "den" -> "Denver", "sf" -> "San Francisco", "ne" -> "New England",
    "no" -> "New Orleans", "gb" -> "Green Bay", "ind" -> "Indianapolis", "ari" -> "Arizona", "phi" -> "Philadelphia",
    "cin" -> "Cincinnati", "car" -> "Carolina", "chi" -> "Chicago", "bal" -> "Baltimore", "atl" -> "Atlanta",
    "kc" -> "Kansas City", "sd" -> "San Diego", "pit" -> "Pittsburgh", "stl" -> "St. Louis", "nyg" -> "NY Giants",
    "det" -> "Detroit", "nyj" -> "NY Jets", "dal" -> "Dallas", "tb" -> "Tampa Bay", "mia" -> "Miami",
    "ten" -> "Tennessee", "hou" -> "Houston", "buf" -> "Buffalo", "wsh" -> "Washington", "min" -> "Minnesota",
    "jax" -> "Jacksonville", "oak" -> "Oakland", "cle" -> "Cleveland")
  val opponentMap: Map[String, List[String]] = Map("ari" -> List("sd", "nyg", "sf", "den", "wsh", "oak", "phi", "dal", "stl", "det", "sea", "atl", "kc", "stl", "sea", "sf"),
    "atl" -> List("no", "cin", "tb", "min", "nyg", "chi", "bal", "det", "tb", "car", "cle", "ari", "gb", "pit", "no", "car"),
    "bal" -> List("cin", "pit", "cle", "car", "ind", "tb", "atl", "cin", "pit", "ten", "no", "sd", "mia", "jax", "hou", "cle"),
    "buf" -> List("chi", "mia", "sd", "hou", "det", "ne", "min", "nyj", "kc", "mia", "nyj", "cle", "den", "gb", "oak", "ne"),
    "car" -> List("tb", "det", "pit", "bal", "chi", "cin", "gb", "sea", "no", "phi", "atl", "min", "no", "tb", "cle", "atl"),
    "chi" -> List("buf", "sf", "nyj", "gb", "car", "atl", "mia", "ne", "gb", "min", "tb", "det", "dal", "no", "det", "min"),
    "cin" -> List("bal", "atl", "ten", "ne", "car", "ind", "bal", "jax", "cle", "no", "hou", "tb", "pit", "cle", "den", "pit"),
    "cle" -> List("pit", "no", "bal", "ten", "pit", "jax", "oak", "tb", "cin", "hou", "atl", "buf", "ind", "cin", "car", "bal"),
    "dal" -> List("sf", "ten", "stl", "no", "hou", "sea", "nyg", "wsh", "ari", "jax", "nyg", "phi", "chi", "phi", "ind", "wsh"),
    "den" -> List("ind", "kc", "sea", "ari", "nyj", "sf", "sd", "ne", "oak", "stl", "mia", "kc", "buf", "sd", "cin", "oak"),
    "det" -> List("nyg", "car", "gb", "nyj", "buf", "min", "no", "atl", "mia", "ari", "ne", "chi", "tb", "min", "chi", "gb"),
    "gb" -> List("sea", "nyj", "det", "chi", "min", "mia", "car", "no", "chi", "phi", "min", "ne", "atl", "buf", "tb", "det"),
    "hou" -> List("wsh", "oak", "nyg", "buf", "dal", "ind", "pit", "ten", "phi", "cle", "cin", "ten", "jax", "ind", "bal", "jax"),
    "ind" -> List("den", "phi", "jax", "ten", "bal", "hou", "cin", "pit", "nyg", "ne", "jax", "wsh", "cle", "hou", "dal", "ten"),
    "jax" -> List("phi", "wsh", "ind", "sd", "pit", "ten", "cle", "mia", "cin", "dal", "ind", "nyg", "hou", "bal", "ten", "hou"),
    "kc" -> List("ten", "den", "mia", "ne", "sf", "sd", "stl", "nyj", "buf", "sea", "oak", "den", "ari", "oak", "pit", "sd"),
    "mia" -> List("ne", "buf", "kc", "oak", "gb", "chi", "jax", "sd", "det", "buf", "den", "nyj", "bal", "ne", "min", "nyj"),
    "min" -> List("stl", "ne", "no", "atl", "gb", "det", "buf", "tb", "wsh", "chi", "gb", "car", "nyj", "det", "mia", "chi"),
    "ne" -> List("mia", "min", "oak", "kc", "cin", "buf", "nyj", "chi", "den", "ind", "det", "gb", "sd", "mia", "nyj", "buf"),
    "no" -> List("atl", "cle", "min", "dal", "tb", "det", "gb", "car", "sf", "cin", "bal", "pit", "car", "chi", "atl", "tb"),
    "nyg" -> List("det", "ari", "hou", "wsh", "atl", "phi", "dal", "ind", "sea", "sf", "dal", "jax", "ten", "wsh", "stl", "phi"),
    "nyj" -> List("oak", "gb", "chi", "det", "sd", "den", "ne", "buf", "kc", "pit", "buf", "mia", "min", "ten", "ne", "mia"),
    "oak" -> List("nyj", "hou", "ne", "mia", "sd", "ari", "cle", "sea", "den", "sd", "kc", "stl", "sf", "kc", "buf", "den"),
    "phi" -> List("jax", "ind", "wsh", "sf", "stl", "nyg", "ari", "hou", "car", "gb", "ten", "dal", "sea", "dal", "wsh", "nyg"),
    "pit" -> List("cle", "bal", "car", "tb", "jax", "cle", "hou", "ind", "bal", "nyj", "ten", "no", "cin", "atl", "kc", "cin"),
    "stl" -> List("min", "tb", "dal", "phi", "sf", "sea", "kc", "sf", "ari", "den", "sd", "oak", "wsh", "ari", "nyg", "sea"),
    "sd" -> List("ari", "sea", "buf", "jax", "nyj", "oak", "kc", "den", "mia", "oak", "stl", "bal", "ne", "den", "sf", "kc"),
    "sf" -> List("dal", "chi", "ari", "phi", "kc", "stl", "den", "stl", "no", "nyg", "wsh", "sea", "oak", "sea", "sd", "ari"),
    "sea" -> List("gb", "sd", "den", "wsh", "dal", "stl", "car", "oak", "nyg", "kc", "ari", "sf", "phi", "sf", "ari", "stl"),
    "tb" -> List("car", "stl", "atl", "pit", "no", "bal", "min", "cle", "atl", "wsh", "chi", "cin", "det", "car", "gb", "no"),
    "ten" -> List("kc", "dal", "cin", "ind", "cle", "jax", "wsh", "hou", "bal", "pit", "phi", "hou", "nyg", "nyj", "jax", "ind"),
    "wsh" -> List("hou", "jax", "phi", "nyg", "sea", "ari", "ten", "dal", "min", "tb", "sf", "ind", "stl", "nyg", "phi", "dal"))

  val teamMap = Map("sea" -> new team("sea", 0, 0, opponentMap("sea")), "den" -> new team("den", 0, 0, opponentMap("den")), "sf" -> new team("sf", 0, 0, opponentMap("sf")),
    "ne" -> new team("ne", 0, 0, opponentMap("ne")), "no" -> new team("no", 0, 0, opponentMap("no")), "gb" -> new team("gb", 0, 0, opponentMap("gb")),
    "ind" -> new team("ind", 0, 0, opponentMap("ind")), "ari" -> new team("ari", 0, 0, opponentMap("ari")), "phi" -> new team("phi", 0, 0, opponentMap("phi")),
    "cin" -> new team("cin", 0, 0, opponentMap()), "car" -> new team("car", 0, 0, opponentMap()), "chi" -> new team("chi", 0, 0, opponentMap()),
    "bal" -> new team("bal", 0, 0, opponentMap()), "atl" -> new team("atl", 0, 0, opponentMap()), "kc" -> new team("kc", 0, 0, opponentMap()), "sd" -> new team("sd", 0, 0, opponentMap()),
    "pit" -> new team("pit", 0, 0, opponentMap()), "stl" -> new team("stl", 0, 0, opponentMap()), "nyg" -> new team("nyg", 0, 0, opponentMap()),
    "det" -> new team("det", 0, 0, opponentMap()), "nyj" -> new team("nyj", 0, 0, opponentMap()), "dal" -> new team("dal", 0, 0, opponentMap()),
    "tb" -> new team("tb", 0, 0, opponentMap()), "mia" -> new team("mia", 0, 0, opponentMap()), "ten" -> new team("ten", 0, 0, opponentMap()),
    "hou" -> new team("hou", 0, 0, opponentMap()), "buf" -> new team("buf", 0, 0, opponentMap()), "wsh" -> new team("wsh", 0, 0, opponentMap()),
    "min" -> new team("min", 0, 0, opponentMap()), "jax" -> new team("jax", 0, 0, opponentMap()), "oak" -> new team("oak", 0, 0, opponentMap()), "cle" -> new team("cle", 0, 0, opponentMap()))


  val teamRecordMap = getRecordMap("2014")

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

  getRank(updateRecords(teamMap)("oak"))

  /*
	def updateRecords(teams: List[team]): List[team] = {
		if(teams.isEmpty) List()
		else {
			val team = teams.head
			val name = team.name
			val wins = teamRecordMap(name)._1
			val losses = teamRecordMap(name)._2
			val opponents = team.opponents
			
			List(new team(name, wins, losses, opponents)) ++ updateRecords(teams.tail)
		}
	}
	
	def updateTeams(teams: List[team]): List[team] = {
	if(teams.isEmpty) List()
	else{
		val team = teams.head
			val name = team.name
			val wins = teamRecordMap(name)._1
			val losses = teamRecordMap(name)._2
			val opponents = team.opponents
		List(new team(name, wins, losses, opponents)) ++ updateTeams(teams.tail)
	}
	
	}
	
  def createRankMap(teams: List[team]): List[(String, Double)] = {
  	if(teams.isEmpty) List()
  	else List((teams.head.name, teams.head.rank)) ++ createRankMap(teams.tail)
  }
  
  val uTeams = updateRecords(teams)
  val t = uTeams.head
  t.name
  val opp = t.opponents.head
  opp.name
  opp.wins
  opp.rank
  t.wins
  t.losses
  t.rank
  */

  /*
  createRankMap(updateTeams(updateRecords(teams)))
  createRankMap(updateRecords(teams))
  val t =updateTeams(updateRecords(teams)).head
  t.name
  t.wins
  t.losses
  t.oppWins
  t.oppLosses
  
	opponentMap("sea").head
	
	sea.oppWins
	
	var sea = new team("sea", 0, 0, List())
  var den = new team("den", 0, 0, List())
  var sf = new team("sf", 0, 0, List())
  var ne = new team("ne", 0, 0, List())
  var no = new team("no", 0, 0, List())
  var gb = new team("gb", 0, 0, List())
  var ind = new team("ind", 0, 0, List())
  var ari = new team("ari", 0, 0, List())
  var phi = new team("phi", 0, 0, List())
  var cin = new team("cin", 0, 0, List())
  var car = new team("car", 0, 0, List())
  var chi = new team("chi", 0, 0, List())
  var bal = new team("bal", 0, 0, List())
  var atl = new team("atl", 0, 0, List())
  var kc = new team("kc", 0, 0, List())
  var sd = new team("sd", 0, 0, List())
  var pit = new team("pit", 0, 0, List())
  var stl = new team("stl", 0, 0, List())
  var nyg = new team("nyg", 0, 0, List())
  var det = new team("det", 0, 0, List())
  var nyj = new team("nyj", 0, 0, List())
  var dal = new team("dal", 0, 0, List())
  var tb = new team("tb", 0, 0, List())
  var mia = new team("mia", 0, 0, List())
  var ten = new team("ten", 0, 0, List())
  var hou = new team("hou", 0, 0, List())
  var buf = new team("buf", 0, 0, List())
  var wsh = new team("wsh", 0, 0, List())
  var min = new team("min", 0, 0, List())
  var jax = new team("jax", 0, 0, List())
  var oak = new team("oak", 0, 0, List())
  var cle = new team("cle", 0, 0, List())
	*/

  /*sea = new team("sea", 0, 0, opponentMap("sea"))
  var den = new team("den", 0, 0, List())
  var sf = new team("sf", 0, 0, List())
  var ne = new team("ne", 0, 0, List())
  var no = new team("no", 0, 0, List())
  var gb = new team("gb", 0, 0, List())
  var ind = new team("ind", 0, 0, List())
  var ari = new team("ari", 0, 0, List())
  var phi = new team("phi", 0, 0, List())
  var cin = new team("cin", 0, 0, List())
  var car = new team("car", 0, 0, List())
  var chi = new team("chi", 0, 0, List())
  var bal = new team("bal", 0, 0, List())
  var atl = new team("atl", 0, 0, List())
  var kc = new team("kc", 0, 0, List())
  var sd = new team("sd", 0, 0, List())
  var pit = new team("pit", 0, 0, List())
  var stl = new team("stl", 0, 0, List())
  var nyg = new team("nyg", 0, 0, List())
  var det = new team("det", 0, 0, List())
  var nyj = new team("nyj", 0, 0, List())
  var dal = new team("dal", 0, 0, List())
  var tb = new team("tb", 0, 0, List())
  var mia = new team("mia", 0, 0, List())
  var ten = new team("ten", 0, 0, List())
  var hou = new team("hou", 0, 0, List())
  var buf = new team("buf", 0, 0, List())
  var wsh = new team("wsh", 0, 0, List())
  var min = new team("min", 0, 0, List())
  var jax = new team("jax", 0, 0, List())
  var oak = new team("oak", 0, 0, List())
  var cle = new team("cle", 0, 0, List())
  
  sea
  sea.wins
  sea.losses
  sea.rank
  sea.opponents

	val teams = List(sea, den, sf, ne, no, gb, ind, ari, phi, cin, car, chi, bal, atl, kc, sd, pit,
	stl, nyg, det, nyj, dal, tb, mia, ten, hou, buf, wsh, min, jax, oak, cle)
	
*/
}