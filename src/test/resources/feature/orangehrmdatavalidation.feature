Feature: dashboard validation

Scenario: quick launch font validation

Given I load the url "https://opensource-demo.orangehrmlive.com/"
Then I enter username as "Admin"
Then I enter password as "admin123"
When I click the login button
Then I should land on the dashboard page
#Then I validate the style part of quic launch "font-weight"
Then I validate the style part of the element
|styleattribute|locator|
|font-weight|(//span[@class='quickLinkText'])[1]|
|font-weight|(//span[@class='quickLinkText'])[2]|
|font-weight|(//span[@class='quickLinkText'])[3]|
|font-weight|(//span[@class='quickLinkText'])[4]|
|font-weight|//b[text()='Admin']|




