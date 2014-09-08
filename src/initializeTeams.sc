import team._
import getRecord._

object initializeTeams {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val teamMap = Map("sea" -> "Seattle", "den" -> "Denver", "sf" -> "San Francisco", "ne" -> "New England",
    "no" -> "New Orleans", "gb" -> "Green Bay", "ind" -> "Indianapolis", "ari" -> "Arizona", "phi" -> "Philadelphia",
    "cin" -> "Cincinnati", "car" -> "Carolina", "chi" -> "Chicago", "bal" -> "Baltimore", "atl" -> "Atlanta",
    "kc" -> "Kansas City", "sd" -> "San Diego", "pit" -> "Pittsburgh", "stl" -> "St. Louis", "nyg" -> "NY Giants",
    "det" -> "Detroit", "nyj" -> "NY Jets", "dal" -> "Dallas", "tb" -> "Tampa Bay", "mia" -> "Miami",
    "ten" -> "Tennessee", "hou" -> "Houston", "buf" -> "Buffalo", "wsh" -> "Washington", "min" -> "Minnesota",
    "jax" -> "Jacksonville", "oak" -> "Oakland", "cle" -> "Cleveland")
                                                  //> teamMap  : scala.collection.immutable.Map[String,String] = Map(stl -> St. Lo
                                                  //| uis, hou -> Houston, det -> Detroit, mia -> Miami, sea -> Seattle, wsh -> Wa
                                                  //| shington, bal -> Baltimore, dal -> Dallas, sf -> San Francisco, min -> Minne
                                                  //| sota, car -> Carolina, buf -> Buffalo, ari -> Arizona, nyj -> NY Jets, kc ->
                                                  //|  Kansas City, jax -> Jacksonville, oak -> Oakland, cin -> Cincinnati, chi ->
                                                  //|  Chicago, den -> Denver, ten -> Tennessee, nyg -> NY Giants, atl -> Atlanta,
                                                  //|  phi -> Philadelphia, pit -> Pittsburgh, sd -> San Diego, tb -> Tampa Bay, i
                                                  //| nd -> Indianapolis, ne -> New England, gb -> Green Bay, no -> New Orleans, c
                                                  //| le -> Cleveland)

  var sea = new team("sea", 0, 0, List())         //> sea  : team.team = team.team@6e551f11
  var den = new team("den", 0, 0, List())         //> den  : team.team = team.team@166acdae
  var sf = new team("sf", 0, 0, List())           //> sf  : team.team = team.team@3de56601
  var ne = new team("ne", 0, 0, List())           //> ne  : team.team = team.team@1f8beb66
  var no = new team("no", 0, 0, List())           //> no  : team.team = team.team@1b0b85b8
  var gb = new team("gb", 0, 0, List())           //> gb  : team.team = team.team@117800e7
  var ind = new team("ind", 0, 0, List())         //> ind  : team.team = team.team@5d8346a6
  var ari = new team("ari", 0, 0, List())         //> ari  : team.team = team.team@55936c40
  var phi = new team("phi", 0, 0, List())         //> phi  : team.team = team.team@41a809a4
  var cin = new team("cin", 0, 0, List())         //> cin  : team.team = team.team@7f110fa8
  var car = new team("car", 0, 0, List())         //> car  : team.team = team.team@391b1fc4
  var chi = new team("chi", 0, 0, List())         //> chi  : team.team = team.team@23c29a26
  var bal = new team("bal", 0, 0, List())         //> bal  : team.team = team.team@3d164721
  var atl = new team("atl", 0, 0, List())         //> atl  : team.team = team.team@197e6dc
  var kc = new team("kc", 0, 0, List())           //> kc  : team.team = team.team@1bb57655
  var sd = new team("sd", 0, 0, List())           //> sd  : team.team = team.team@266bd4a9
  var pit = new team("pit", 0, 0, List())         //> pit  : team.team = team.team@7156b6f3
  var stl = new team("stl", 0, 0, List())         //> stl  : team.team = team.team@740545a6
  var nyg = new team("nyg", 0, 0, List())         //> nyg  : team.team = team.team@61fd0cc
  var det = new team("det", 0, 0, List())         //> det  : team.team = team.team@12c50438
  var nyj = new team("nyj", 0, 0, List())         //> nyj  : team.team = team.team@44980228
  var dal = new team("dal", 0, 0, List())         //> dal  : team.team = team.team@57b5b346
  var tb = new team("tb", 0, 0, List())           //> tb  : team.team = team.team@5a0ce5a6
  var mia = new team("mia", 0, 0, List())         //> mia  : team.team = team.team@4b9237a
  var ten = new team("ten", 0, 0, List())         //> ten  : team.team = team.team@16c82102
  var hou = new team("hou", 0, 0, List())         //> hou  : team.team = team.team@2cef15fd
  var buf = new team("buf", 0, 0, List())         //> buf  : team.team = team.team@48cac17
  var wsh = new team("wsh", 0, 0, List())         //> wsh  : team.team = team.team@2f761c56
  var min = new team("min", 0, 0, List())         //> min  : team.team = team.team@733e6a71
  var jax = new team("jax", 0, 0, List())         //> jax  : team.team = team.team@6be5bd3
  var oak = new team("oak", 0, 0, List())         //> oak  : team.team = team.team@3b7e7d1a
  var cle = new team("cle", 0, 0, List())         //> cle  : team.team = team.team@6d475479
	
	 val opponentMap: Map[String, List[team]] = Map("ari" -> List(sd, nyg, sf, den, wsh, oak, phi, dal, stl, det, sea, atl, kc, stl, sea, sf),
"atl" -> List(no, cin, tb, min, nyg, chi, bal, det, tb, car, cle, ari, gb, pit, no, car),
"bal" -> List(cin, pit, cle, car, ind, tb, atl, cin, pit, ten, no, sd, mia, jax, hou, cle),
"buf" -> List(chi, mia, sd, hou, det, ne, min, nyj, kc, mia, nyj, cle, den, gb, oak, ne),
"car" -> List(tb, det, pit, bal, chi, cin, gb, sea, no, phi, atl, min, no, tb, cle, atl),
"chi" -> List(buf, sf, nyj, gb, car, atl, mia, ne, gb, min, tb, det, dal, no, det, min),
"cin" -> List(bal, atl, ten, ne, car, ind, bal, jax, cle, no, hou, tb, pit, cle, den, pit),
"cle" -> List(pit, no, bal, ten, pit, jax, oak, tb, cin, hou, atl, buf, ind, cin, car, bal),
"dal" -> List(sf, ten, stl, no, hou, sea, nyg, wsh, ari, jax, nyg, phi, chi, phi, ind, wsh),
"den" -> List(ind, kc, sea, ari, nyj, sf, sd, ne, oak, stl, mia, kc, buf, sd, cin, oak),
"det" -> List(nyg, car, gb, nyj, buf, min, no, atl, mia, ari, ne, chi, tb, min, chi, gb),
"gb" -> List(sea, nyj, det, chi, min, mia, car, no, chi, phi, min, ne, atl, buf, tb, det),
"hou" -> List(wsh, oak, nyg, buf, dal, ind, pit, ten, phi, cle, cin, ten, jax, ind, bal, jax),
"ind" -> List(den, phi, jax, ten, bal, hou, cin, pit, nyg, ne, jax, wsh, cle, hou, dal, ten),
"jax" -> List(phi, wsh, ind, sd, pit, ten, cle, mia, cin, dal, ind, nyg, hou, bal, ten, hou),
"kc" -> List(ten, den, mia, ne, sf, sd, stl, nyj, buf, sea, oak, den, ari, oak, pit, sd),
"mia" -> List(ne, buf, kc, oak, gb, chi, jax, sd, det, buf, den, nyj, bal, ne, min, nyj),
"min" -> List(stl, ne, no, atl, gb, det, buf, tb, wsh, chi, gb, car, nyj, det, mia, chi),
"ne" -> List(mia, min, oak, kc, cin, buf, nyj, chi, den, ind, det, gb, sd, mia, nyj, buf),
"no" -> List(atl, cle, min, dal, tb, det, gb, car, sf, cin, bal, pit, car, chi, atl, tb),
"nyg" -> List(det, ari, hou, wsh, atl, phi, dal, ind, sea, sf, dal, jax, ten, wsh, stl, phi),
"nyj" -> List(oak, gb, chi, det, sd, den, ne, buf, kc, pit, buf, mia, min, ten, ne, mia),
"oak" -> List(nyj, hou, ne, mia, sd, ari, cle, sea, den, sd, kc, stl, sf, kc, buf, den),
"phi" -> List(jax, ind, wsh, sf, stl, nyg, ari, hou, car, gb, ten, dal, sea, dal, wsh, nyg),
"pit" -> List(cle, bal, car, tb, jax, cle, hou, ind, bal, nyj, ten, no, cin, atl, kc, cin),
"stl" -> List(min, tb, dal, phi, sf, sea, kc, sf, ari, den, sd, oak, wsh, ari, nyg, sea),
"sd" -> List(ari, sea, buf, jax, nyj, oak, kc, den, mia, oak, stl, bal, ne, den, sf, kc),
"sf" -> List(dal, chi, ari, phi, kc, stl, den, stl, no, nyg, wsh, sea, oak, sea, sd, ari),
"sea" -> List(gb, sd, den, wsh, dal, stl, car, oak, nyg, kc, ari, sf, phi, sf, ari, stl),
"tb" -> List(car, stl, atl, pit, no, bal, min, cle, atl, wsh, chi, cin, det, car, gb, no),
"ten" -> List(kc, dal, cin, ind, cle, jax, wsh, hou, bal, pit, phi, hou, nyg, nyj, jax, ind),
"wsh" -> List(hou, jax, phi, nyg, sea, ari, ten, dal, min, tb, sf, ind, stl, nyg, phi, dal))
                                                  //> opponentMap  : Map[String,List[team.team]] = Map(stl -> List(team.team@733e
                                                  //| 6a71, team.team@5a0ce5a6, team.team@57b5b346, team.team@41a809a4, team.team
                                                  //| @3de56601, team.team@6e551f11, team.team@1bb57655, team.team@3de56601, team
                                                  //| .team@55936c40, team.team@166acdae, team.team@266bd4a9, team.team@3b7e7d1a,
                                                  //|  team.team@2f761c56, team.team@55936c40, team.team@61fd0cc, team.team@6e551
                                                  //| f11), hou -> List(team.team@2f761c56, team.team@3b7e7d1a, team.team@61fd0cc
                                                  //| , team.team@48cac17, team.team@57b5b346, team.team@5d8346a6, team.team@7156
                                                  //| b6f3, team.team@16c82102, team.team@41a809a4, team.team@6d475479, team.team
                                                  //| @7f110fa8, team.team@16c82102, team.team@6be5bd3, team.team@5d8346a6, team.
                                                  //| team@3d164721, team.team@6be5bd3), det -> List(team.team@61fd0cc, team.team
                                                  //| @391b1fc4, team.team@117800e7, team.team@44980228, team.team@48cac17, team.
                                                  //| team@733e6a71, team.team@1b0b85b8, team.team@197e6dc, team.team@4b9237a, te
                                                  //| am.team@55936c40, team.
                                                  //| Output exceeds cutoff limit.

 sea = new team("sea", 0, 0, opponentMap("sea"))
  /*var den = new team("den", 0, 0, List())
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
  var cle = new team("cle", 0, 0, List())*/
  
  sea                                             //> res0: team.team = team.team@5fa6e5d5
  sea.wins                                        //> res1: Int = 0
  sea.losses                                      //> res2: Int = 0
  sea.rank                                        //> res3: Double = NaN
  sea.opponents                                   //> res4: List[team.team] = List(team.team@117800e7, team.team@266bd4a9, team.t
                                                  //| eam@166acdae, team.team@2f761c56, team.team@57b5b346, team.team@740545a6, t
                                                  //| eam.team@391b1fc4, team.team@3b7e7d1a, team.team@61fd0cc, team.team@1bb5765
                                                  //| 5, team.team@55936c40, team.team@3de56601, team.team@41a809a4, team.team@3d
                                                  //| e56601, team.team@55936c40, team.team@740545a6)

	val teams = List(sea, den, sf, ne, no, gb, ind, ari, phi, cin, car, chi, bal, atl, kc, sd, pit,
	stl, nyg, det, nyj, dal, tb, mia, ten, hou, buf, wsh, min, jax, oak, cle)
                                                  //> teams  : List[team.team] = List(team.team@5fa6e5d5, team.team@166acdae, tea
                                                  //| m.team@3de56601, team.team@1f8beb66, team.team@1b0b85b8, team.team@117800e7
                                                  //| , team.team@5d8346a6, team.team@55936c40, team.team@41a809a4, team.team@7f1
                                                  //| 10fa8, team.team@391b1fc4, team.team@23c29a26, team.team@3d164721, team.tea
                                                  //| m@197e6dc, team.team@1bb57655, team.team@266bd4a9, team.team@7156b6f3, team
                                                  //| .team@740545a6, team.team@61fd0cc, team.team@12c50438, team.team@44980228, 
                                                  //| team.team@57b5b346, team.team@5a0ce5a6, team.team@4b9237a, team.team@16c821
                                                  //| 02, team.team@2cef15fd, team.team@48cac17, team.team@2f761c56, team.team@73
                                                  //| 3e6a71, team.team@6be5bd3, team.team@3b7e7d1a, team.team@6d475479)
	

	
	val teamRecordMap = getRecordMap("2014")  //> teamRecordMap  : Map[String,(Int, Int)] = Map(stl -> (1,0), hou -> (1,0), d
                                                  //| et -> (1,0), mia -> (1,0), sea -> (1,0), wsh -> (1,0), bal -> (1,0), dal ->
                                                  //|  (1,0), sf -> (1,0), min -> (1,0), car -> (1,0), buf -> (1,0), ari -> (1,0)
                                                  //| , nyj -> (1,0), kc -> (1,0), jax -> (1,0), oak -> (1,0), cin -> (1,0), chi 
                                                  //| -> (1,0), den -> (1,0), ten -> (1,0), nyg -> (1,0), atl -> (1,0), phi -> (1
                                                  //| ,0), pit -> (1,0), sd -> (1,0), tb -> (1,0), ind -> (1,0), ne -> (1,0), gb 
                                                  //| -> (1,0), no -> (1,0), cle -> (1,0))
	
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
	}                                         //> updateRecords: (teams: List[team.team])List[team.team]
	
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
		
	}                                         //> updateTeams: (teams: List[team.team])List[team.team]
	
  def createRankMap(teams: List[team]): List[(String, Double)] = {
  	if(teams.isEmpty) List()
  	else List((teams.head.name, teams.head.rank)) ++ createRankMap(teams.tail)
  }                                               //> createRankMap: (teams: List[team.team])List[(String, Double)]
  
  createRankMap(updateTeams(updateRecords(teams)))//> res5: List[(String, Double)] = List((sea,NaN), (den,1.0), (sf,1.0), (ne,1.0
                                                  //| ), (no,1.0), (gb,1.0), (ind,1.0), (ari,1.0), (phi,1.0), (cin,1.0), (car,1.0
                                                  //| ), (chi,1.0), (bal,1.0), (atl,1.0), (kc,1.0), (sd,1.0), (pit,1.0), (stl,1.0
                                                  //| ), (nyg,1.0), (det,1.0), (nyj,1.0), (dal,1.0), (tb,1.0), (mia,1.0), (ten,1.
                                                  //| 0), (hou,1.0), (buf,1.0), (wsh,1.0), (min,1.0), (jax,1.0), (oak,1.0), (cle,
                                                  //| 1.0))
  createRankMap(updateRecords(teams))             //> res6: List[(String, Double)] = List((sea,NaN), (den,1.0), (sf,1.0), (ne,1.0
                                                  //| ), (no,1.0), (gb,1.0), (ind,1.0), (ari,1.0), (phi,1.0), (cin,1.0), (car,1.0
                                                  //| ), (chi,1.0), (bal,1.0), (atl,1.0), (kc,1.0), (sd,1.0), (pit,1.0), (stl,1.0
                                                  //| ), (nyg,1.0), (det,1.0), (nyj,1.0), (dal,1.0), (tb,1.0), (mia,1.0), (ten,1.
                                                  //| 0), (hou,1.0), (buf,1.0), (wsh,1.0), (min,1.0), (jax,1.0), (oak,1.0), (cle,
                                                  //| 1.0))
  val t =updateTeams(updateRecords(teams)).head   //> t  : team.team = team.team@49ab1c60
  t.name                                          //> res7: String = sea
  t.wins                                          //> res8: Int = 1
  t.losses                                        //> res9: Int = 0
  t.oppWins                                       //> res10: Int = 0
  t.oppLosses                                     //> res11: Int = 0
  
	opponentMap("sea").head                   //> res12: team.team = team.team@117800e7
	
	sea.oppWins                               //> res13: Int = 0
}