
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object scrapeClubs extends App{
  //var mainBox = Jsoup.connect("http://www.manchesteratnight.com/clubs/").get().select(".boxWide").forEach()
  val clubLinks = ArrayBuffer.empty[String]
  Jsoup.connect("http://www.manchesteratnight.com/clubs/").get().select(".boxWide").forEach(shitBox =>
    clubLinks += shitBox.select(".listingLeft>strong>a").attr("href")
  )
  val clubSubLink = clubLinks.toList.head

  // (Name, Img, Address, Description)
  val scrapeStats: (String) => Tuple4[String,String, String, String]
  = (link) => {
    val indivPage = Jsoup.connect("http://www.manchesteratnight.com/" + link).get()
    println(indivPage.select("span[itemprop=address").html)
    Tuple4(
      indivPage.select("h1[itemprop=name]").html,
      indivPage.select(".placeImage").attr("src"),
      "",
      indivPage.select("span[itemprop=description").html
    )
  }
  println()
  //println(scrapeStats(clubSubLink))
  println(Jsoup.connect("http://www.manchesteratnight.com/clubs/13/42nd_street.html").get())
}

//tourLinks += a.attr("href")

