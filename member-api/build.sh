#!/bin/sh
aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 320811633077.dkr.ecr.ap-northeast-2.amazonaws.com

docker build -t 320811633077.dkr.ecr.ap-northeast-2.amazonaws.com/larambla:v1 -t 320811633077.dkr.ecr.ap-northeast-2.amazonaws.com/larambla:latest .
docker push 320811633077.dkr.ecr.ap-northeast-2.amazonaws.com/larambla

aws s3 cp Dockerrun.aws.json s3://elasticbeanstalk-ap-northeast-2-320811633077/docker/

aws elasticbeanstalk create-application-version --application-name rocksea-dev-rocksea-api --version-label v1 --source-bundle S3Bucket=elasticbeanstalk-ap-northeast-2-320811633077,S3Key=docker/Dockerrun.aws.json
aws elasticbeanstalk update-environment --application-name rocksea-dev-rocksea-api --environment-name rocksea-dev-rocksea-api --version-label=v1
