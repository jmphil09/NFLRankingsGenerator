import team._
import fileWriter._

object test {
  //basic idea: rank = record*(record factor) + opponent's record*(opponents record factor)
  //this will require some trial and error: my first try will be record factor=1, opponent's record factor=0.5
  var team1 = new team("team1",2,0, List())       //> team1  : team.team = team.team@78c53bd9
  var team2 = new team("team2",0,2, List())       //> team2  : team.team = team.team@7330f1a2
  var team3 = new team("team3",1,1, List())       //> team3  : team.team = team.team@1247fdc3
  var team4 = new team("team4",2,0, List())       //> team4  : team.team = team.team@34651695
  var team5 = new team("team5",1,1, List())       //> team5  : team.team = team.team@58adab12
  var team6 = new team("team6",1,1, List())       //> team6  : team.team = team.team@71ba5839
	
	
	team1.rank                                //> res0: Double = 1.0
	
	
	team1 = new team("team1",2,0, List(team2, team3))
	team2 = new team("team2",0,2, List(team1, team4))
	team3 = new team("team3",1,1, List(team5, team6))
	team4 = new team("team4",2,0, List(team2, team5))
	team5 = new team("team5",1,1, List(team3, team6))
	team6 = new team("team6",1,1, List(team3, team5))
	
	
  team1.rank                                      //> res1: Double = 1.125
  team2.rank                                      //> res2: Double = 0.5
  team3.rank                                      //> res3: Double = 0.75
  team4.rank                                      //> res4: Double = 1.125
  team5.rank                                      //> res5: Double = 0.75
  team6.rank                                      //> res6: Double = 0.75
	
	fileWriter("test", "hopefully this will work")
}