Feature: As a user i want to login in ReportPortal

  @smoke
  Scenario: User can login
    Given User opens website
    When User fills valid credentials
    And Clicks "Login"
    Then Page with title "Report Portal" is displayed