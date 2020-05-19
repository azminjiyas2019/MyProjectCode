   #Feature file to validate  test cases for  API:


   #Scenario1
   #API Reference -
   #Testcase1:
   #API :
   #Invoke GET method and validate Status Code '200'
   # Testcase2:
   # API :
   #Invoke POST method and validate Status Code '201'
   #Testcase3:
   #API :
   #Invoke GET method and validate Status Code '401' for not authorised user
   # Testcase4:
   # API :
   #Invoke POST method and validate Status Code '401' for not authorise user

   @API
   Feature:
     Scenario Outline:
       Given Base URI is up and running
       When I invoke endpoint "<endpoint>"
       Then I get response status code for addresses "401"
       Examples:
         |endpoint|
         |        |
     Scenario Outline:
       When
       Then I get response status code for carts"401"

       Examples:
         ||
         ||