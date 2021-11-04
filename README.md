#  Larambla Project
LaRambla project is a project to help build k8s-based microservices.
Each service runs on docker container.

### Containerization
You should build Dockerizing and push to ECR.
```
$ aws configure
$ aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin xxxxxxx.dkr.ecr.ap-northeast-2.amazonaws.com
$ docker build -t xxxxxxx.dkr.ecr.ap-northeast-2.amazonaws.com/larambla:v1 -t xxxxxxx.dkr.ecr.ap-northeast-2.amazonaws.com/larambla:latest .
$ docker push xxxxxxx.dkr.ecr.ap-northeast-2.amazonaws.com/larambla
```

