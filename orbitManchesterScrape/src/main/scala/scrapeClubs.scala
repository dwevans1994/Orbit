
import java.io.{BufferedWriter, FileOutputStream, OutputStreamWriter}

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object scrapeClubs extends App{

  def write2File: (String, List[Tuple5[String,String,Tuple2[String,String], List[String],String]]) => Unit = (fileName, list) => {
    val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("../"+fileName)))
    for (x <- list) {
      writer.write(x + "\n")  // however you want to format it
    }
  }

  def scrapeVenueType: String => ListBuffer[Tuple5[String,String,Tuple2[String,String], List[String],String]] = venueType => {
    var venueList = ListBuffer.empty[Tuple5[String,String,Tuple2[String,String], List[String],String]]
    Jsoup.connect("http://www.manchesteratnight.com/" + venueType + "/").get().select(".boxWide").forEach { venueBox =>
      val sublink = venueBox.select(".listingLeft>strong>a").attr("href")
      venueList += scrapeStats(sublink, venueType)
    }
    venueList
  }

  // (Name, Img, Address, Description, type)
  def scrapeStats: (String, String) => Tuple5[String,String,Tuple2[String, String], List[String], String]
  = (link, venueType) => {
    val baseLink = "http://www.manchesteratnight.com/"
    val indivPage = Jsoup.connect( baseLink+ link).get()
    Tuple5(
      indivPage.select("h1[itemprop=name]").html,
      baseLink + indivPage.select(".placeImage").attr("src"),
      addressClean(indivPage.select("span[itemprop=address]").html),
      descripClean(indivPage.select("span[itemprop=description]").html),
      venueType
    )
  }

  def descripClean: String => List[String] = baseDescript => (baseDescript.split("<br>").toBuffer -= " ").toList
  def addressClean: String => Tuple2[String, String] = baseAddress => {
    val testAddress = "2 Bootle Street Manchester M2 5GU"
    var splitAddress = testAddress.split(" ")
    (splitAddress.splitAt(splitAddress.length-2)._1.mkString(""), splitAddress.splitAt(splitAddress.length-2)._2.mkString(""))
  }

  write2File("cleanScrape.txt", (scrapeVenueType("clubs") ++ scrapeVenueType("bars")).toList)
  println("File Comp == Time to sleep!!!")
  //println(Jsoup.connect("http://www.manchesteratnight.com/clubs/13/42nd_street.html").get())
}

//tourLinks += a.attr("href")

