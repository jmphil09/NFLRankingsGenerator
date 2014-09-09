package team

class team(n: String, w: Int, l: Int, o: List[String]) {
	/*def getOppWins(opponents: List[team]): Int = {
	  if(opponents.isEmpty) 0
	  else opponents.head.wins + getOppWins(opponents.tail)
	}
	
	def getOppLosses(opponents: List[team]): Int = {
	  if(opponents.isEmpty) 0
	  else opponents.head.losses + getOppLosses(opponents.tail)
	}
	
	def getRank(opponents: List[team]) = {
	  if (opponents.isEmpty) (wins+0.0)/(wins+losses)
	  else (wins+0.0)/(wins+losses) + (oppWins+0.0)/(oppWins+oppLosses)*(0.5)
	}
	*/
	var name = n
	var wins = w
	var losses = l
	var opponents = o
	//var oppWins = getOppWins(opponents)
	//var oppLosses = getOppLosses(opponents)
	//var rank = getRank(opponents)
}