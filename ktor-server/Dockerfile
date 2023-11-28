FROM graal21:latest as builder
WORKDIR /
ADD . /
RUN ["/bin/bash", "-c", "cd / \
&& source /root/.sdkman/bin/sdkman-init.sh \
&& sdk use java 21-graal \
&& ./gradlew nativeCompile \
"]

FROM ubuntu:23.10
COPY --from=builder /build/native/nativeCompile/graalvm-server /graalvm-server
EXPOSE 8080
CMD ["/graalvm-server"]

