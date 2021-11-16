Execute Docker Compose
```shell
$ docker-compose up -d -f docker-compose.yml

$ docker ps -a
CONTAINER ID   IMAGE                    COMMAND                  CREATED          STATUS                     PORTS                                                                   NAMES
115b7c1b7a7c   wurstmeister/zookeeper   "/bin/sh -c '/usr/sb…"   56 minutes ago   Up 56 minutes              22/tcp, 2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp, :::2181->2181/tcp   zookeeper
0c951512cdf1   wurstmeister/kafka       "start-kafka.sh"         56 minutes ago   Up 56 minutes              0.0.0.0:9092->9092/tcp, :::9092->9092/tcp                               Kafka
62f0781a2813   mysql:latest             "docker-entrypoint.s…"   6 hours ago      Up 5 hours                 0.0.0.0:3306->3306/tcp, :::3306->3306/tcp, 33060/tcp                    larambla-mysql
```

Download Kafka Binary
```shell
$ wget https://archive.apache.org/dist/kafka/2.3.0/kafka_2.12-2.3.0.tgz
```

Producer Test

```shell
$ bin/kafka-console-producer.sh --topic larambla-member --broker-list localhost:9092
> {"id":"1234"}
```

Consumer Test
```shell
$ bin/kafka-console-consumer.sh --topic larambla-member --bootstrap-server localhost:9092 --from-beginning
{"id":"1234"}
```
