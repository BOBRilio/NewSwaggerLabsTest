Feature: Корзина на Swag Labs

  Scenario: Добавление первого товара в корзину
    Given пользователь залогинен как "standard_user" с паролем "secret_sauce"
    When он добавляет первый товар в корзину
    Then он видит счётчик корзины "1"
    And название первого товара "Sauce Labs Backpack"