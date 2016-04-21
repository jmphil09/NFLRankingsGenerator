import createHometeamArray._
import createTeamSchedule._
import createRankingsArray._
import espnRankings._
import rankingsGen._
import team._
import getRecord._

object mainfile {
	val year = "2015"                         //> year  : String = 2015
	val week = "18"                           //> week  : String = 18
  val laptopUser = "James"                        //> laptopUser  : String = James
  val pcUser = "fligh_000"                        //> pcUser  : String = fligh_000
  
  //createHomeArrays("2015", laptopUser)
  //createScheduleArrays("2015", laptopUser)

  //rankingsGen.generateRankings(year, week, laptopUser)

  espnRankings.generateRankings(year, week, laptopUser)
 
  
  createRankArrays(year, laptopUser)

  val dummy = "DONE"                              //> dummy  : String = DONE
}
 