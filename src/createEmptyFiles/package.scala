import fileWriter._

package object createEmptyFiles {
  def createDummyRankings(year: String, week: String, user: String) = {
    val dummyTeamMap = Map("Seahawks" -> 0, "Broncos" -> 0, "49ers" -> 0, "Patriots" -> 0,
      "Saints" -> 0, "Packers" -> 0, "Colts" -> 0, "Cardinals" -> 0, "Eagles" -> 0,
      "Bengals" -> 0, "Panthers" -> 0, "Bears" -> 0, "Ravens" -> 0, "Falcons" -> 0,
      "Chiefs" -> 0, "Chargers" -> 0, "Steelers" -> 0, "Rams" -> 0, "Giants" -> 0,
      "Lions" -> 0, "Jets" -> 0, "Cowboys" -> 0, "Buccaneers" -> 0, "Dolphins" -> 0,
      "Titans" -> 0, "Texans" -> 0, "Bills" -> 0, "Redskins" -> 0, "Vikings" -> 0,
      "Jaguars" -> 0, "Raiders" -> 0, "Browns" -> 0)

    var dummyStrResult = new String
    for (line <- dummyTeamMap.toSeq.sortBy(_._2)) {
      dummyStrResult += line.toString.drop(1).dropRight(1) + "\n"
    }

    fileWriter(year + "Week" + week, dummyStrResult, user)

  }
}