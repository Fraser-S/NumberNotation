
class Notation {
    val useShort = true
    val useLong = false

    def getNotation(useShort: Boolean):List[String]={
      if(useShort) {
        List(" thousand ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
      } else {
        List(" thousand ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " trilliard ")
      }
    }

    def numberNotation(number :BigInt, useShortNotation: Boolean): String ={
      def iter(numberString: String, notation :List[String]): String = numberString.length match{
        case hundred if numberString.length <= 3 => numberString //end of generation
        case 4 => numberString.take(1) + notation(0) + iter(numberString.tail, notation)
        case 7 => numberString.take(1) + notation(1) + iter(numberString.tail, notation)
        case 10 => numberString.take(1) + notation(2) + iter(numberString.tail, notation)
        case 13 => numberString.take(1) + notation(3) + iter(numberString.tail, notation)
        case 16 => numberString.take(1) + notation(4) + iter(numberString.tail, notation)
        case 19 => numberString.take(1) + notation(5) + iter(numberString.tail, notation)
        case 22 => numberString.take(1) + notation(6) + iter(numberString.tail, notation)
        case _ =>  numberString.take(1) + iter(numberString.tail, notation)
      }
      iter(number.toString(), getNotation(useShortNotation))
    }

    def displayNotation(number :Long): Unit ={
      println("Short Notation:\n" + numberNotation(number, useShort))
      println("Long Notation:\n" + numberNotation(number, useLong))
    }
}
