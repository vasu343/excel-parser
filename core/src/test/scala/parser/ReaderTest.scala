package parser

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.scalatest.{FreeSpec, Matchers}
import parser.io.load

class ReaderTest extends FreeSpec with Matchers {

  val example: XSSFWorkbook = load("example.xlsx")

  "Reader" - {
    "numeric" in {
      Reader.numeric("GasLossFactor").read(example) shouldEqual Right(0.02)
    }
    "numeric range" in {
      Reader.numericRange("OilProd").read(example) shouldEqual Right(List(10.12, 12.34, 8.83, 6.23, 9.18, 12.36, 16.28, 18.25, 20.01))
    }
  }

}
