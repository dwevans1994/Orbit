
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

import scala.collection.mutable.ListBuffer

object scrapeClubs extends App{
  //var mainBox = Jsoup.connect("http://www.manchesteratnight.com/clubs/").get().select(".boxWide").forEach()

  print(Jsoup.connect("http://www.manchesteratnight.com/clubs/").get().select(".boxWide").forEach(shitBox =>
    println(shitBox.select(".listingLeft>strong>a").attr("href"))

  ))


}

//tourLinks += a.attr("href")