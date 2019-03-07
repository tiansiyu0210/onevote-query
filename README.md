# onevote-query


1. stop and reomve all docker container(skip this if this is your first run)
   docker stop $(docker ps -aq)
   docker rm $(docker ps -aq)
2. remove docker image
  docker rmi conumer
3. mvn -U clean -Dkiptests
4. docker build -t comsumer:latest .
5. docker-compose up (make sure you did step 1-4 for command repo as well)
