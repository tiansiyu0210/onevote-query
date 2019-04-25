# onevote-query


1. stop and reomve all docker container(skip this if this is your first run):
   -- docker ps -a
   -- docker stop $(docker ps -aq)
   -- docker rm $(docker ps -aq)
3. mvn -U clean install
5. docker-compose up (make sure you did step 1-4 for command repo as well)


swagger:
http://localhost:8085/swagger-ui.html
