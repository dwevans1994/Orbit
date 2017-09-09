
import java.io.{BufferedWriter, FileOutputStream, OutputStreamWriter}

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object scrapeClubs extends App{
  //var mainBox = Jsoup.connect("http://www.manchesteratnight.com/clubs/").get().select(".boxWide").forEach()
  val clubLinks = ArrayBuffer.empty[Tuple4[String, String, String, String]]
  Jsoup.connect("http://www.manchesteratnight.com/clubs/").get().select(".boxWide").forEach { venueBox =>
    val sublink = venueBox.select(".listingLeft>strong>a").attr("href")
    clubLinks += scrapeStats(sublink)
  }

  val barLinks = ArrayBuffer.empty[Tuple4[String, String, String, String]]
  Jsoup.connect("http://www.manchesteratnight.com/bars/").get().select(".boxWide").forEach { venueBox =>
    val sublink = venueBox.select(".listingLeft>strong>a").attr("href")
    barLinks += scrapeStats(sublink)
  }

  val totLinks = clubLinks ++ barLinks

  val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../info.txt")))
  for (x <- totLinks) {
    writer.write(x + "\n")  // however you want to format it
  }


  // (Name, Img, Address, Description)
  def scrapeStats: (String) => Tuple4[String,String, String, String]
  = (link) => {
    val baseLink = "http://www.manchesteratnight.com"
    val indivPage = Jsoup.connect( baseLink + "/" + link).get()
    Tuple4(
      indivPage.select("h1[itemprop=name]").html,
      baseLink + indivPage.select(".placeImage").attr("src"),
      indivPage.select("span[itemprop=address]").html,
      indivPage.select("span[itemprop=description]").html
    )
  }

  println(barLinks.toList)
  //println(Jsoup.connect("http://www.manchesteratnight.com/clubs/13/42nd_street.html").get())
}

//tourLinks += a.attr("href")

