#How to run
- build step : gradle build
- run fat jar 
  - got to directory `/build/libs`
  - `java -jar BlackJack-1.0-SNAPSHOT-standalone.jar <filename>` for example `java -jar BlackJack-1.0-SNAPSHOT-standalone.jar ../../sampleInput.cards`

# Assumption
- Tie-breaker:  When each player finished with drawing card and ended with tie , sam will be winner.
- Card order :  Inside code, last element in the Card list is considered as top. This is against the example. This is so because it is efficient to remove card from the end.
- Input validation: Unit test for validating file or its content may not be sufficient, lots of missing case such character
- **Integration test cases is missing due to lack of time**, ideally would like to write lots of integration tests. 