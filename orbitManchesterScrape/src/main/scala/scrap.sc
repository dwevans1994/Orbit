val testAddress = "2 Bootle Street Manchester M2 5GU"
var splitAddress = testAddress.split(" ")
splitAddress.splitAt(splitAddress.length-2)._2.mkString("")
