package team

import scala.collection.mutable._

object teamData {
	val teamCityMap = Map("sea" -> "Seattle", "den" -> "Denver", "sf" -> "San Francisco", "ne" -> "New England",
    "no" -> "New Orleans", "gb" -> "Green Bay", "ind" -> "Indianapolis", "ari" -> "Arizona", "phi" -> "Philadelphia",
    "cin" -> "Cincinnati", "car" -> "Carolina", "chi" -> "Chicago", "bal" -> "Baltimore", "atl" -> "Atlanta",
    "kc" -> "Kansas City", "sd" -> "San Diego", "pit" -> "Pittsburgh", "stl" -> "St. Louis", "nyg" -> "NY Giants",
    "det" -> "Detroit", "nyj" -> "NY Jets", "dal" -> "Dallas", "tb" -> "Tampa Bay", "mia" -> "Miami",
    "ten" -> "Tennessee", "hou" -> "Houston", "buf" -> "Buffalo", "wsh" -> "Washington", "min" -> "Minnesota",
    "jax" -> "Jacksonville", "oak" -> "Oakland", "cle" -> "Cleveland")

  val teamNameMap = Map("sea" -> "Seahawks", "den" -> "Broncos", "sf" -> "49ers", "ne" -> "Patriots",
    "no" -> "Saints", "gb" -> "Packers", "ind" -> "Colts", "ari" -> "Cardinals", "phi" -> "Eagles",
    "cin" -> "Bengals", "car" -> "Panthers", "chi" -> "Bears", "bal" -> "Ravens", "atl" -> "Falcons",
    "kc" -> "Chiefs", "sd" -> "Chargers", "pit" -> "Steelers", "stl" -> "Rams", "nyg" -> "Giants",
    "det" -> "Lions", "nyj" -> "Jets", "dal" -> "Cowboys", "tb" -> "Buccaneers", "mia" -> "Dolphins",
    "ten" -> "Titans", "hou" -> "Texans", "buf" -> "Bills", "wsh" -> "Redskins", "min" -> "Vikings",
    "jax" -> "Jaguars", "oak" -> "Raiders", "cle" -> "Browns")

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
    "cin" -> new team("cin", 0, 0, opponentMap("cin")), "car" -> new team("car", 0, 0, opponentMap("car")), "chi" -> new team("chi", 0, 0, opponentMap("chi")),
    "bal" -> new team("bal", 0, 0, opponentMap("bal")), "atl" -> new team("atl", 0, 0, opponentMap("atl")), "kc" -> new team("kc", 0, 0, opponentMap("kc")),
    "sd" -> new team("sd", 0, 0, opponentMap("sd")), "pit" -> new team("pit", 0, 0, opponentMap("pit")), "stl" -> new team("stl", 0, 0, opponentMap("stl")),
    "nyg" -> new team("nyg", 0, 0, opponentMap("nyg")), "det" -> new team("det", 0, 0, opponentMap("det")), "nyj" -> new team("nyj", 0, 0, opponentMap("nyj")),
    "dal" -> new team("dal", 0, 0, opponentMap("dal")), "tb" -> new team("tb", 0, 0, opponentMap("tb")), "mia" -> new team("mia", 0, 0, opponentMap("mia")),
    "ten" -> new team("ten", 0, 0, opponentMap("ten")), "hou" -> new team("hou", 0, 0, opponentMap("hou")), "buf" -> new team("buf", 0, 0, opponentMap("buf")),
    "wsh" -> new team("wsh", 0, 0, opponentMap("wsh")), "min" -> new team("min", 0, 0, opponentMap("min")), "jax" -> new team("jax", 0, 0, opponentMap("jax")),
    "oak" -> new team("oak", 0, 0, opponentMap("oak")), "cle" -> new team("cle", 0, 0, opponentMap("cle")))
}