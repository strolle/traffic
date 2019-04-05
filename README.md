# Traffic
Checks SL's API to find the bus lines with most bus stops.

## Requirements
- Gradle for building the project
- Java 8 or later (Built with java 11, but does not use any new things)

## Build
`./gradlew jar`

## Run
`java -jar build/libs/traffic-1.0.jar`

## Comments
### Outstanding issues
There are a lot of outstanding issues.
- There are no error handling
- Storing the API keys like this is really, really bad practice.
- No tests. Sorry about that.

### Other comments
- The service could have been all static for now, but it can't really be that when its time to do tests
- No point in adding for example spring boot and dependency injection for this use case.

