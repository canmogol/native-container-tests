# Native Server Containerized Load Tests

Here are the results of `ab` load testing. 

- Response percentage vs response time in milliseconds.

| Percentage / ms | SpBoVT 3.2 Native | JavaSrvVT Native | GO Srv | Dart Shelf | Dart Frog | KTor Native | Deno |
| --------------- | ----------------- | ---------------- | ------ | ---------- | --------- | ----------- | ---- |
| 50              | 299               | 101              | 99     | 200        | 203       | 198         | 98   |
| 66              | 310               | 105              | 101    | 201        | 205       | 602         | 100  |
| 75              | 398               | 109              | 103    | 202        | 207       | 700         | 101  |
| 80              | 401               | 187              | 105    | 203        | 212       | 707         | 102  |
| 90              | 495               | 195              | 191    | 210        | 289       | 890         | 105  |
| 95              | 505               | 197              | 196    | 289        | 291       | 910         | 184  |
| 98              | 598               | 199              | 200    | 294        | 293       | 1007        | 195  |
| 99              | 602               | 202              | 203    | 297        | 294       | 1101        | 249  |
| 100             | 806               | 304              | 394    | 393        | 312       | 1688        | 399  |

[Response Times](docs/percent-response-time.png)


- Average Memory Usage in MegaBytes.

|            | SpBoVT 3.2 Native | JavaSrvVT Native | GO Srv | Dart Shelf | Dart Frog | KTor Native | Deno |
| ---------- | ----------------- | ---------------- | ------ | ---------- | --------- | ----------- | ---- |
| Memory(MB) | 52                | 19.3             | 8.6    | 7.5        | 5.8       | 23.6        | 26.9 |

[Memory Usage](docs/memory-usage.png)


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
docker build -f Dockerfile.graal21 -t graal21 .
docker build -t vt-native .
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



# DART FROG SERVER (dart_frog_server)

* Build
```
docker build -t dart-frog-server .
```

* Run
```
docker run --rm -it -p 8080:8080 --cpus=0.2 --memory=64m --name dart-frog docker.io/library/dart-frog-server
```

* Load Test (Average Memory Usage ~5.8MB)
```
ab -c 100 -n 10000 http://localhost:8080/
Complete requests:      10000
Failed requests:        0
Percentage of the requests served within a certain time (ms)
  50%    203
  66%    205
  75%    207
  80%    212
  90%    289
  95%    291
  98%    293
  99%    294
 100%    312 (longest request)
```



# KTOR Native (ktor-server)

* Build
```
docker build -t ktor-native .
```

* Run
```
docker run --rm -it -p 8080:8080 --cpus=0.2 --memory=64m --name ktor-native docker.io/library/ktor-native
```

* Load Test (Average Memory Usage ~23.6MB)
```
ab -c 100 -n 10000 http://localhost:8080/
Complete requests:      10000
Failed requests:        0
Percentage of the requests served within a certain time (ms)
  50%    198
  66%    602
  75%    700
  80%    707
  90%    890
  95%    910
  98%   1007
  99%   1101
 100%   1688 (longest request)
```



# Deno Http Server (deno-server)

* Build
```
docker build -t deno-server .
```

* Run
```
docker run --rm -it -p 8080:8080 --cpus=0.2 --memory=64m --name deno-server deno-server:latest
```

* Load Test (Average Memory Usage ~26.9MB)
```
ab -c 100 -n 10000 http://localhost:8080/
Complete requests:      10000
Failed requests:        0
Percentage of the requests served within a certain time (ms)
  50%     98
  66%    100
  75%    101
  80%    102
  90%    105
  95%    184
  98%    195
  99%    249
 100%    399 (longest request)
```
