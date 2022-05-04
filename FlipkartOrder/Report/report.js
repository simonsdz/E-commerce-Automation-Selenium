$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/OrderSteps.feature");
formatter.feature({
  "name": "Ebay Website Handling",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Ordering a mobile phone",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on Ebay Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.StepDefinitions.i_am_on_Ebay_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I order a product",
  "keyword": "When "
});
formatter.match({
  "location": "steps.StepDefinitions.i_order_a_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "my order is placed successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.StepDefinitions.my_order_is_placed_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});