docker exec -it kafka1 bash

#Create Topic
kafka-topics --bootstrap-server kafka1:19092 \
             --create \
             --topic test-topic \
             --replication-factor 1 --partitions 1

#List topics
docker exec --interactive --tty kafka1  kafka-topics --bootstrap-server kafka1:19092 --list


#Create producer after exiting from container
docker exec --interactive --tty kafka1 kafka-console-producer --bootstrap-server kafka1:19092 --topic test-topic

#Consumer
docker exec --interactive --tty kafka1 kafka-console-consumer --bootstrap-server kafka1:19092 --topic test-topic --from-beginning

#produce with keys
docker exec --interactive --tty kafka1 kafka-console-producer --bootstrap-server kafka1:19092 --topic test-topic --property "key.separator=-" --property "parse.key=true"

#consume with keys
docker exec --interactive --tty kafka1 kafka-console-consumer --bootstrap-server kafka1:19092 --topic test-topic --from-beginning --property "key.separator= - " --property "print.key=true"