@regressiontest @TEC-1003
  Feature: Validating Title for each page


    @TEC-2004  @ui


      Scenario Outline: Validating titles
      Given User navigates to Etsy apllication
      When User click on "<department>" part
      Then User validates "<title>"  title

Examples:

  |department               |title                            |
  | Jewellery & Accessories | Jewellery & Accessories \| Etsy |
  |Clothing & Shoes         | Clothing & Shoes\|Etsy          |
  |Home & Living            |Home & Living   \| Etsy          |
  |Wedding & Party          |Wedding & Party\|  Etsy          |
  |Toys & Entertainment     |Toys & Entertainment\|Etsy       |
  |Art & Collectibles       |Art & Collectibles\|Etsy         |





