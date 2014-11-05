import createHometeamArray._
import createTeamSchedule._
import createRankingsArray._
import espnRankings._
import rankingsGen._
import team._
import getRecord._

object mainfile {
	val year = "2014"                         //> year  : String = 2014
	val week = "10"                           //> week  : String = 10
  val laptopUser = "James"                        //> laptopUser  : String = James
  val pcUser = "fligh_000"                        //> pcUser  : String = fligh_000
  
  //createHomeArrays("2014", laptopUser)
  //createScheduleArrays("2014", laptopUser)

  //rankingsGen.generateRankings(year, week, laptopUser)
  espnRankings.generateRankings(year, week, laptopUser)
  createRankArrays("2014", laptopUser)

  val dummy = "DONE"                              //> dummy  : String = DONE
}
 