# Kair project: Air quality for Mexico
## What is this? Why?
This can be called a personal project by [@Drewermerc](https://github.com/Drewermerc/) with the original intention of learning AWS Lambdas and Alexa skill, and at the same time help people to know about air quality when they require. If you would like to learn about how this project is design, please check our [high level design document](https://github.com/Drewermerc/kair/wiki/High-Level-System-Design) first.

## Project status
**This project is in DEVELOPMENT**. Currently, undergoing test. If you would like to learn more about this, please head to our [Wiki on Github](https://github.com/Drewermerc/kair/wiki)

## Instructions
Got project root which is and ASK CLI project, here you will need the following requirements.

- Need an AWS account with permissions to deploy AWS Lambda function and Alexa Skill.
- Have AWS CLI installed and configuration already set locally for ask deploy.
- Set the following environment variable:
```
TOKEN -> WAQI API token
``` 
- Will need S3 bucket to hold skill logo.
- This is a maven project, make sure to have java and maven cli installed to build the project

sample setup:
```
# From lambda/
# This package the lambda function
mvn clean install

# From /project-roo
ask deploy
```

## Contributions
Should you like to provide any feedback, please open up an Issue, I appreciate feedback and comments, although please keep in mind this project is incomplete, and I am doing my best to keep it up to date.

Currently, the project is NOT ACCEPTING CODE CONTRIBUTIONS(pull request, or else). However, as this is in its early stage, you are welcome to leave feedback on its current design.
