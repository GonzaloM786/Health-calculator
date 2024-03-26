@tag
Feature: Ideal weight
    @tag1
    Scenario Outline: the parameters are correct
        Given the height as <h> is correct
        And the gender as <g> is correct
        When i press the calculate button
        Then the result  as <result> is returned

            Examples:
                | h | g | result |
                | 84 | 'm' | 0.5 |
                | 67 | 'w' | 0.2 |

    @tag2
    Scenario: the gender is not correct
        Given the height as <h> is correct
        And the gender as <g> is not correct
        When i press the calculate button
        Then an error message indicates the gender is not correct

            Examples:
                | h | g |
                | 100 | 'j' |
    @tag3
    Scenario: the height is not correct
        Given the height as <h> is not correct
        And the gender as <g> is correct
        When i press the calculate button
        Then an error message indicates the height is not correct

            Examples:
                | h | g |
                | 83 | 'm' |
                | 66 | 'w' |