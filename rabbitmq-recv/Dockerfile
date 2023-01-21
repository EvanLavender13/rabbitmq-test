FROM docker.io/openjdk:11
WORKDIR /app/
COPY ./target/rabbitmq-recv-1.0-SNAPSHOT.jar /app/
CMD ["java", "-jar", "rabbitmq-recv-1.0-SNAPSHOT.jar"]
# CMD ["bash"]