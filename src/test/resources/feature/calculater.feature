@tag
Feature: Calculator

  Scenario: add two numbers
    Given Two input values, 1 and 2
    When I add the two values
    Then I expect the result 3


  Scenario Outline: add two numbers
    Given Two input values, <first> and <second>
    When I add the two values
    Then I expect the result <result>

    Examples:
      | first | second | result |
      | 1     | 12     | 13     |
      | -1    | 6      | 5      |
      | 2     | 2      | 4      |

  Scenario Outline: opt on one number
    Given One input value and opt, <number> <opt>
    When I evaluate
    Then I expect the result to be <result>

    Examples:
      | number | result   | opt |
      | 1      | 1.0      | sqr |
      | -1     | NaN      | sqr |
      | 9      | 3        | sqr |
      | 4      | 2        | sqr |
      | -4     | Nan      | sqr |
      | 0      | 0        | sqr |
      | 2      | 1.414213 | sqr |
      | 1      | 1.0      | rvs |
      | -1     | -1.0     | rvs |
      | 2      | 0.5      | rvs |
      | 4      | 0.25     | rvs |
      | -4     | -0.25    | rvs |
      | 0      | NaN      | rvs |
