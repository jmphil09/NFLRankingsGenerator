import fileWriter._
import scala.io.Source
import java.io._

package object createRankingsArray {
	def createRankArrays(year: String, user: String) = {
  	  
  	var teamMap = Map("Seahawks" -> "", "Broncos" -> "", "49ers" -> "", "Patriots" -> "",
   "Saints" -> "", "Packers" -> "", "Colts" -> "", "Cardinals" -> "", "Eagles" -> "",
   "Bengals" -> "", "Panthers" -> "", "Bears" -> "", "Ravens" -> "", "Falcons" -> "",
   "Chiefs" -> "", "Chargers" -> "", "Steelers" -> "", "Rams" -> "", "Giants" -> "",
   "Lions" -> "", "Jets" -> "", "Cowboys" -> "", "Buccaneers" -> "", "Dolphins" -> "",
   "Titans" -> "", "Texans" -> "", "Bills" -> "", "Redskins" -> "", "Vikings" -> "",
   "Jaguars" -> "", "Raiders" -> "", "Browns" -> "")
   
   	def updateWeek(map: Map[String, String], week: String): Map[String, String] = {
   		val filename = "C:/Users/James/Desktop/git-workspace/NFLRankingsGenerator/data/"+year+week+".txt"
   		//val filename = "C:/Users/fligh_000/Desktop/git-workspace/NFLRankingsFetcher/NFLRankingsFetcher/data/"+year+week+".txt"
   		var weekSet = Source.fromFile(filename).getLines().toSet
   		val weekPairArray = weekSet.map(x => x.split(","))
    	val weekMap = weekPairArray.map(x=> (x(0), x(1))).toMap
    	val updatedMap = teamMap.map(x => (x._1, teamMap(x._1) + weekMap(x._1) + ", "))
   	  updatedMap
   	}
   	
   	for(i <- 1 to 18){
   		teamMap = updateWeek(teamMap, "week"+i.toString)
   	}
   	
   	var teamString = new String
	teamString += "int RCardinals [19]= {0, "+ teamMap.get("Cardinals").get.dropRight(2) +"};\n"
	teamString += "int RFalcons [19]= {0, "+ teamMap.get("Falcons").get.dropRight(2) +"};\n"
	teamString += "int RRavens [19]= {0, "+ teamMap.get("Ravens").get.dropRight(2) +"};\n"
	teamString += "int RBills [19]= {0, "+ teamMap.get("Bills").get.dropRight(2) +"};\n"
	teamString += "int RPanthers [19]= {0, "+ teamMap.get("Panthers").get.dropRight(2) +"};\n"
	teamString += "int RBears [19]= {0, "+ teamMap.get("Bears").get.dropRight(2) +"};\n"
	teamString += "int RBengals [19]= {0, "+ teamMap.get("Bengals").get.dropRight(2) +"};\n"
	teamString += "int RBrowns [19]= {0, "+ teamMap.get("Browns").get.dropRight(2) +"};\n"
	teamString += "int RCowboys [19]= {0, "+ teamMap.get("Cowboys").get.dropRight(2) +"};\n"
	teamString += "int RBroncos [19]= {0, "+ teamMap.get("Broncos").get.dropRight(2) +"};\n"
	teamString += "int RLions [19]= {0, "+ teamMap.get("Lions").get.dropRight(2) +"};\n"
	teamString += "int RPackers [19]= {0, "+ teamMap.get("Packers").get.dropRight(2) +"};\n"
	teamString += "int RTexans [19]= {0, "+ teamMap.get("Texans").get.dropRight(2) +"};\n"
	teamString += "int RColts [19]= {0, "+ teamMap.get("Colts").get.dropRight(2) +"};\n"
	teamString += "int RJaguars [19]= {0, "+ teamMap.get("Jaguars").get.dropRight(2) +"};\n"
	teamString += "int RChiefs [19]= {0, "+ teamMap.get("Chiefs").get.dropRight(2) +"};\n"
	teamString += "int RDolphins [19]= {0, "+ teamMap.get("Dolphins").get.dropRight(2) +"};\n"
	teamString += "int RVikings [19]= {0, "+ teamMap.get("Vikings").get.dropRight(2) +"};\n"
	teamString += "int RPatriots [19]= {0, "+ teamMap.get("Patriots").get.dropRight(2) +"};\n"
	teamString += "int RSaints [19]= {0, "+ teamMap.get("Saints").get.dropRight(2) +"};\n"
	teamString += "int RGiants [19]= {0, "+ teamMap.get("Giants").get.dropRight(2) +"};\n"
	teamString += "int RJets [19]= {0, "+ teamMap.get("Jets").get.dropRight(2) +"};\n"
	teamString += "int RRaiders [19]= {0, "+ teamMap.get("Raiders").get.dropRight(2) +"};\n"
	teamString += "int REagles [19]= {0, "+ teamMap.get("Eagles").get.dropRight(2) +"};\n"
	teamString += "int RSteelers [19]= {0, "+ teamMap.get("Steelers").get.dropRight(2) +"};\n"
	teamString += "int RRams [19]= {0, "+ teamMap.get("Rams").get.dropRight(2) +"};\n"
	teamString += "int RChargers [19]= {0, "+ teamMap.get("Chargers").get.dropRight(2) +"};\n"
	teamString += "int RFortyNiners [19]= {0, "+ teamMap.get("49ers").get.dropRight(2) +"};\n"
	teamString += "int RSeahawks [19]= {0, "+ teamMap.get("Seahawks").get.dropRight(2) +"};\n"
	teamString += "int RBuccaneers [19]= {0, "+ teamMap.get("Buccaneers").get.dropRight(2) +"};\n"
	teamString += "int RTitans [19]= {0, "+ teamMap.get("Titans").get.dropRight(2) +"};\n"
	teamString += "int RRedskins [19]= {0, "+ teamMap.get("Redskins").get.dropRight(2) +"};\n"
  
   fileWriter(year+"TeamRank", teamString, user)
  }                                             
}
