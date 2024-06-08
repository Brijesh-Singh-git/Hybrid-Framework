Feature:  User Login

  Scenario:  Successfull Login

    Given the user is on the login page
    When the user enters valid credentials (username: "student", password: "Password123")
    And the user clicks on the Login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message

