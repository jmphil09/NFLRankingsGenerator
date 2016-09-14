import createHometeamArray._
import createTeamSchedule._
import createRankingsArray._
import espnRankings._
import rankingsGen._
import team._
import getRecord._

object mainfile {
	val year = "2016"                         //> year  : String = 2016
	val week = "1"                            //> week  : String = 1
  val laptopUser = "James"                        //> laptopUser  : String = James
  val pcUser = "fligh_000"                        //> pcUser  : String = fligh_000
   
  //createHomeArrays("2016", pcUser)
  //createScheduleArrays("2016", pcUser)

  //rankingsGen.generateRankings(year, week, laptopUser)

  //espnRankings.generateRankings(year, week, pcUser)
 
  
  createRankArrays(year, laptopUser)

  val dummy = "DONE"                              //> dummy  : String = DONE
}
 