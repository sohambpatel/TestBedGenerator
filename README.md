# TestBedGenerator

TestBedGenerator is a framework to generate test beds for testing up different frameworks or tools. TestBedGenerator uses following methods to generate the test beds in a unique way.
- Generate the test beds with the static content which is the unique, robust and innovative test beds generated inhouse and available as a part of this tool
- Using chatgpt, we have exposed the chatgpt API to generate the test beds on the basis of the prompt provided
- Using inhouse LLM, you can install and run the inhouse LLM commands to generate the test cases like OLLAMA
- Using the REST API with inhouse LLM like OLLAMA, exposed generate API of OLLAMA to generate the test beds as per the prompt provided
  
## Contributers and Authors
- Soham Patel
- Kailas Patil (kailas.patil@vupune.ac.in)
- Prawit Chumchu (prawit@eng.src.ku.ac.th)

## Link of the published paper
https://doi.org/10.1016/j.simpa.2024.100687

## Pre-requisite
- Java : you would need java to install on your machine and setup the path https://phoenixnap.com/kb/install-java-windows
- Maven : install maven with the help of https://phoenixnap.com/kb/install-maven-windows
- Git Installation https://www.simplilearn.com/tutorials/git-tutorial/git-installation-on-windows
Rest all the necessary software have been added as a part of maven dependency and will get taken care at runtime or if you are using jar, then all the dependencies are part of jar only.

## Installation

Please clone this repository and checkout main branch which is the latest and updated branch

```bash
https://github.com/sohambpatel/TestBedGenerator.git
```
Follow the following maven commands to download the dependancies and compile the code before running it
```bash
cd TestBedGenerator
mvn clean
mvn dependency:resolve
mvn compile
mvn test
mvn surefire-report:report
```

## Usage
Directly run the java code and use the given options to use them further, before running make sure to update the config.properties with your own credentials do that running the code would be smoother or you can use the code and plug and start using its methods or you can create the jar and import it to your own project and start using the classes/methods from that. You can use the following command to make the jar.
```java
mvn package
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[APACHE](https://www.apache.org/licenses/LICENSE-2.0)
