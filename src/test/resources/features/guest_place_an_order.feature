Feature: place an order
  Scenario: using default payment option
    Given I'm a guest customer
    And my billing details are
      |firstname|lastname|country           |address_line1  |city |state|zip  |email           |
      |demo     |user    |United States (US)|6300Spring crek|Plane|Texas|75024|askdch@gmail.com|
    And I have a product in the cart
    And I'm on the checkout page
    When I provide billing details

    And I place an order
    Then Order should be placed successfully