Feature: Adding Dashboard

  Scenario: Add Dashboard with list
    Given Open Dashboard page
    When Add Dashboard
      | Dashboard List | Dashboard List description | shareFlag true |
    Then Dashboard is added

#  Scenario: Add Dashboard with Custom Object
#    Given Open Dashboard page
#    When Add Dashboard with object
#      | name             | description                  | shareFlag       |
#      | Dashboard Object | Dashboard Object description | shareFlag true |
#    Then Dashboard is added

  Scenario Outline: Add Dashboard with Data Table
    Given Open Dashboard page
    When Add Dashboard with <name>, <description>, <shareFlag>
    Then Dashboard is added

    Examples:
      | name                | description                     | shareFlag |
      | Dashboard dataTable | Dashboard dataTable description | true     |

