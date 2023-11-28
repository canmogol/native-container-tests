# Native Server Containerized Load Tests

# SPRING BOOT 3.2 NATIVE IMAGE (canm-vt)

* Build
```
./mvnw spring-boot:build-image -Pnative
```

* Run
```
docker run --rm -it -p 8080:8080 --cpus=0.2 --memory=64m --name canm-vt docker.io/library/canm:0.0.1-SNAPSHOT
```

* Load Test (Average Memory Usage ~52MB)
```
ab -c 100 -n 10000 http://localhost:8080/
Complete requests:      10000
Failed requests:        0
Percentage of the requests served within a certain time (ms)
  50%    299
  66%    310
  75%    398
  80%    401
  90%    495
  95%    505
  98%    598
  99%    602
 100%    806 (longest request)
```


# VT-NATIVE (virtual-threads-native)

* Build
```
docker build -f Dockerfile.graal21 -t graal21
docker build -t vt-native
```

* Run
```
docker run --rm -it -p 8080:8080 --cpus=0.2 --memory=64m --name vt-native vt-native:latest
```

* Load Test (Average Memory Usage ~19.3MB)
```
ab -c 100 -n 10000 http://localhost:8080/
Complete requests:      10000
Failed requests:        0
Percentage of the requests served within a certain time (ms)
  50%    101
  66%    105
  75%    109
  80%    187
  90%    195
  95%    197
  98%    199
  99%    202
 100%    304 (longest request)
```


# GO SERVER (go-helloworld)

* Build
```
docker build -t go-hello .
```
* Run
```
docker run --rm -it -p 8080:8080 --cpus=0.2 --memory=64m --name go-hello docker.io/library/go-hello
```

* Load Test (Average Memory Usage ~8.6MB)
```
ab -c 100 -n 10000 http://localhost:8080/
Complete requests:      10000
Failed requests:        0
Percentage of the requests served within a certain time (ms)
  50%     99
  66%    101
  75%    103
  80%    105
  90%    191
  95%    196
  98%    200
  99%    203
 100%    394 (longest request)
```


# DART SERVER (dart-shelf-server)

* Build
```
docker build -t dart-shelf .
```

* Run
```
docker run --rm -it -p 8080:8080 --cpus=0.2 --memory=64m --name dart-shelf docker.io/library/dart-shelf
```

* Load Test (Average Memory Usage ~7.5MB)
```
ab -c 100 -n 10000 http://localhost:8080/
Complete requests:      10000
Failed requests:        0
Percentage of the requests served within a certain time (ms)
  50%    200
  66%    201
  75%    202
  80%    203
  90%    210
  95%    289
  98%    294
  99%    297
 100%    393 (longest request)
```

