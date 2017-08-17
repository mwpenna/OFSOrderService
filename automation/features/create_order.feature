@service
Feature: Order is created when order endpoint is called

  Scenario: A request to create an order is received by a SYSTEM_ADMIN
    Given A SYSTEM_ADMIN user exists with inventory items
    When A request to create an order is received
    Then the response should have a status of 201
    And I should see the location header populated

  Scenario: A request to create an order is received by a ADMIN
    Given A ADMIN user exists with inventory items
    When A request to create an order is received
    Then the response should have a status of 201
    And I should see the location header populated

  Scenario: A request to create an order is received by a ACCOUNT_MANAGER
    Given A ACCOUNT_MANAGER user exists with inventory items
    When A request to create an order is received
    Then the response should have a status of 201
    And I should see the location header populated

  Scenario: A request to create an order is received by a WAREHOUSE
    Given A WAREHOUSE user exists with inventory items
    When A request to create an order is received
    Then the response should have a status of 400

  Scenario: A request to create an order is received by a CUSTOMER
    Given A CUSTOMER user exists with inventory items
    When A request to create an order is received
    Then the response should have a status of 400

  Scenario: A request to create an order is received by a ADMIN
    Given A ADMIN user exists with inventory items
    When A request to create an order is received
    Then the response should have a status of 201
    And I should see the order was created

  Scenario: A request to create an order is received by a user that does not exists
    Given A ADMIN user does not exists for a company
    When A request to create an order is received for a user that does not exists
    Then the response should have a status of 403

  Scenario: A request to create an order is received with invalid order field href
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid order field href
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid order field createdOn
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid order field createdOn
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid order field id
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid order field id
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid order field updatedOn
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid order field updatedOn
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid order field priceSubTotal
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid order field priceSubTotal
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid order field totalPrice
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid order field updatedOn
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid shipment field id
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid shipment field id
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid shipment field href
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid shipment field href
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid shipment field createdOn
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid shipment field createdOn
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid shipment field updatedOn
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid shipment field updatedOn
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid inventory field name
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid inventory field name
    Then the response should have a status of 400

  Scenario: A request to create an order is received with invalid customer field href
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid customer field href
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing order field items
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing order field items
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing order field customer
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing order field customer
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing order field taxPercent
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing order field taxPercent
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing customer field id
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing customer field id
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing shipment field itemsInShipment
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing shipment field itemsInShipment
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing shipment field carrier
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing shipment field carrier
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing shipment field trackingId
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing shipment field trackingId
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing inventory field id
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing inventory field id
    Then the response should have a status of 400

  Scenario: A request to create an order is received with missing inventory field quantity
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing inventory field quantity
    Then the response should have a status of 400

  Scenario: An order status is defaulted to quote when create order request is received without status
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with missing order field status
    Then the response should have a status of 201
    And I should see the order status is QUOTE

  Scenario: An order is received with invalid status
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with invalid status
    Then the response should have a status of 400

  Scenario: An order is received with status of APPROVED
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with status of APPROVED
    Then the response should have a status of 400

  Scenario: An order is received with status of ON_HOLD
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with status of ON_HOLD
    Then the response should have a status of 400

  Scenario: An order is received with status of IN_BACKORDER
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with status of IN_BACKORDER
    Then the response should have a status of 400

  Scenario: An order is received with status of IN_PROGRESS
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with status of IN_PROGRESS
    Then the response should have a status of 400

  Scenario: An order is received with status of SHIPPED
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with status of SHIPPED
    Then the response should have a status of 400

  Scenario: An order is received with status of DELIVERED
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with status of DELIVERED
    Then the response should have a status of 400

  Scenario: An order is received with status of CLOSED
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with status of CLOSED
    Then the response should have a status of 400

  Scenario: A request to create an order is received with valid customer id
    Given A ADMIN user and customer exists with inventory items
    When A request to create an order is received with valid customer id
    Then the response should have a status of 201
    And I should see the order was created

  Scenario: A request to create an order with a customer id from a different company is received
    Given A ADMIN user and customer exists for different companies with inventory items
    When A request to create an order is received with valid customer id
    Then the response should have a status of 400

  Scenario: A request to create an order with an invalid customer id is received
    When A request to create an order is received with invalid customer id
    Then the response should have a status of 400

  Scenario: A request to create an order with an invalid inventory id is received
    Given A ADMIN user and customer exists with inventory items
    When A request to create an order is received with invalid inventory id
    Then the response should have a status of 400

  Scenario: A request to create an order is received with valid inventory list. Inventory href, name get defaulted
    Given A ADMIN user and customer exists with inventory items
    When A request to create an order is received with valid inventory id
    Then the response should have a status of 201
    And I should see the inventory name and href get defaulted to the inventory item

  Scenario: A request to create an order is received with valid inventory list. Inventory price gets defaulted.
    Given A ADMIN user and customer exists with inventory items
    When A request to create an order is received without inventory price
    Then the response should have a status of 201
    And I should see the inventory price get defaulted to the inventory item

  Scenario: A request to create an order is received with shipment info containing valid itemsInShipment list
    Given A ADMIN user and customer exists with inventory items
    When A request to create an order is received with valid shipment info containing valid itemsInShipment list
    Then the response should have a status of 201
    And I should see the order was created

  Scenario: A request to create an order is received with shipment info containing invalid itemsInShipment list
    Given A ADMIN user and customer exists with inventory items
    When A request to create an order is received with valid shipment info containing invalid inventory item in itemsInShipment list
    Then the response should have a status of 400

  Scenario: A request to create an order is received by SYSTEM_ADMIN with companyId in the request
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with a companyId
    Then the response should have a status of 201
    And I should see the companyId matches the request companyId

  Scenario: A request to create an order is received by SYSTEM_ADMIN without companyId in the request
    Given A ADMIN user exists with inventory items
    When A request to create an order is received without companyId
    Then the response should have a status of 201
    And I should see the companyId matches the user companyId

  Scenario: A request to create an order is received by ADMIN with a different companyId
    Given A ADMIN user exists with inventory items
    When A request to create an order is received with a different companyId
    Then the response should have a status of 201
    And I should see the companyId matches the user companyId

  Scenario: A request to create an order is received by ADMIN without companyId
    Given A ADMIN user exists with inventory items
    When A request to create an order is received without companyId
    Then the response should have a status of 201
    And I should see the companyId matches the user companyId