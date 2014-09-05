package team

class team(name: String, w: Int, l: Int, opponents: List[team]) {
	def getOppWins(opponents: List[team]): Int = {
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
	
	var wins = w
	var losses = l
	//var opponents: List[team] = List()
	var oppWins = getOppWins(opponents)
	var oppLosses = getOppLosses(opponents)
	var rank = getRank(opponents)
}