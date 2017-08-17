@service
Feature: Order is created when order endpoint is called

  Scenario: A request to create an order is received by a SYSTEM_ADMIN

  Scenario: A request to create an order is received by a ADMIN

  Scenario: A request to create an order is received by a ACCOUNT_MANAGER

  Scenario: A request to create an order is received by a WAREHOUSE

  Scenario: A request to create an order is received by a CUSTOMER

  Scenario: A request to create an order is received by a ADMIN (Data)

  Scenario: A request to create an order is received by a user that does not exists

  Scenario: A request to create an order is received with invalid order field href

  Scenario: A request to create an order is received with invalid order field createdOn

  Scenario: A request to create an order is received with invalid order field id

  Scenario: A request to create an order is received with invalid order field updatedOn

  Scenario: A request to create an order is received with invalid order field priceSubTotal

  Scenario: A request to create an order is received with invalid order field totalPrice

  Scenario: A request to create an order is received with invalid order field companyId

  Scenario: A request to create an order is received with invalid shipment field id

  Scenario: A request to create an order is received with invalid shipment field href

  Scenario: A request to create an order is received with invalid shipment field createdOn

  Scenario: A request to create an order is received with invalid shipment field updatedOn

  Scenario: A request to create an order is received with invalid inventory field name

  Scenario: A request to create an order is received with invalid customer field href

  Scenario: A request to create an order is received with missing order field items

  Scenario: A request to create an order is received with missing order field customer

  Scenario: A request to create an order is received with missing order field taxPercent

  Scenario: A request to create an order is received with missing customer field id

  Scenario: A request to create an order is received with missing shipment field itemsInShipment

  Scenario: A request to create an order is received with missing shipment field carrier

  Scenario: A request to create an order is received with missing shipment field trackingId

  Scenario: A request to create an order is received with missing inventory field id

  Scenario: A request to create an order is received with missing inventory field quantity

  Scenario: An order status is defaulted to quote when create order request is received without status

  Scenario: A request to create an order is received with valid customer id

  Scenario: A request to create an order with a customer id from a different company is received

  Scenario: A request to create an order with an invalid customer id is received

  Scenario: A request to create an order with an invalid inventory id is received

  Scenario: A request to create an order is received with valid inventory list. Inventory href, name get defaulted

  Scenario: A request to create an order is received with valid inventory list. Inventory price gets defaulted.

  Scenario: A request to create an order is received with shipment info containing valid itemsInShipment list

  Scenario: A request to create an order is received with shipment info containing invalid itemsInShipment list