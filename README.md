# awsmvpdemo

The project is intended to create a sandbox environment for hands-on work with AWS cloud infrastructure.
The infrastructure is described in cloudFormation templates.
The services are written in Java + Spring.

The following diagram shows the main infrastructure of the project
![image](https://github.com/SergeyVorobevepam/awsmvpdemo/assets/134205710/da1f59d3-07e4-49fb-9c4b-185071ffc593)


## The major characteristics of the project
- Services are packed in containers and located in ECR repository.
- 2 availability zones with 1 public and private subnet in each AZ. The instances are evenly distributed between the AZ and private subnets.
- Container management is performed with the usage of ECS cluster.
- Containers have access to the internet via nat gateways.
- Application load balancer distributes the load between services. Simple type - round robin.
- Services can interact asynchronously with SQS queues.
- Dynamo DB is used as an example of a NoSql database

## Constraints
- To provide access to SQS and Dynamo, you will need to create users in your account and use their access and sercet key for access. **Warning!** Do not store you credentials inside services, use can use **AWS System manager** for this purpose.
