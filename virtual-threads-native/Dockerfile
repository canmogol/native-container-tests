FROM graal21:latest as builder
WORKDIR /
ADD . /
RUN ["/bin/bash", "-c", "cd / \
&& source /root/.sdkman/bin/sdkman-init.sh \
&& sdk use java 21-graal \
&& ./mvnw clean install \
&& native-image --version \
&& native-image --no-fallback -H:+ReportExceptionStackTraces -jar target/VirtualThreadApplication.jar \
"]

FROM ubuntu:23.10
COPY --from=builder /VirtualThreadApplication /VirtualThreadApplication
EXPOSE 8080
CMD ["/VirtualThreadApplication"]
