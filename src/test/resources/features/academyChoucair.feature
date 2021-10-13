#Autor: Felipe Navas

Feature: Utest
  As a user I want to use Utest I want to use the registration form

  @scenario1
  Scenario Outline: Complete the step in the form

    Given Felipe wanted to use the registration form in Utest

    When Felipe completes the fields in the form
      | strFirstName   | strLastName   | strEmail   | strBirthMonth   | strBirthDay   | strBirthYear   | strLanguages   | strCity   | strPostalCode   | strCountry   |
      | <strFirstName> | <strLastName> | <strEmail> | <strBirthMonth> | <strBirthDay> | <strBirthYear> | <strLanguages> | <strCity> | <strPostalCode> | <strCountry> |


    Then Felipe complete the form
      |password   |confirmPassword   |
      |<password> |<confirmPassword> |



    Examples:
      | strFirstName | strLastName | strEmail                    | strBirthMonth | strBirthDay | strBirthYear | strLanguages | strCity   | strPostalCode   | strCountry   |password    |confirmPassword |
      | Felipe       | Navas       | luisfelipenavas@hotmail.com | April         | 30          | 1996         | Spanish      | Medellin  | 050024          | Colombia     |Chaguala123 |Chaguala123     |