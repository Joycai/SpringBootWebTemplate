FROM gradle:8.1.1-jdk17
WORKDIR /home/gradle/project
ENTRYPOINT ["gradle","--no-daemon", "--no-build-cache", "clean", "build"]