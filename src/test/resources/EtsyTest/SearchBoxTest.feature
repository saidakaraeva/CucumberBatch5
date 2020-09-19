@smoketest @regressiontest @ui @TEC-1005
  Feature: Validating search box
    @TEC-2008
    Scenario: Validating search box is giving right output
      Given User navigates to Etsy application
      When User searches for "carpet"
      Then User validates the result contains
      |carpet|
      |rug   |
      |area rugs|

      @TEC-2009
      Scenario: Validating search result with selecting price range
        Given User navigates to Etsy application
        When User searches for "carpet"
        And User selects over $1000 option
        Then User validates that all prices over 1000

