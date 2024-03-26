@tag
Feature: Basal metabolic rate
    @tag1
    Scenario Outline: the parameters are correct
        Given the height as <h>, weight as <w>, age as <a> and gender as <g> are correct
        When i press the calculate button
        Then the result as <result> is returned

            Examples:
                | h | g | w | a | result |
                | 47 | 'm' | 20.125 | 100 | 0 |
                | 47 | 'w' | 36.725 | 100 | 0 |
    @tag2
    Scenario: the gender is not correct
        Given the gender is not correct
        When i press the calculate button
        Then an error message indicates the gender is not correct

    @tag3
    Scenario: the result is negative
        Given the parameters height as <h>, weight as <w>, age as <a> and gender as <g>
        And the result is negative
        When i press the calculate button
        Then an error message indicates the parameters are not correct

                Examples:
            | h | g | w | a |
            | 40 | 'm' | 20.125 | 100 |