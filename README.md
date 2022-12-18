# scala-web-sbt-spring-thyme-orientdb-nosql

## Description
A thyme springboot scala sbt build,
that connects to orientdb database.

Creates a new database `animal` and adds
document `dog`.

## Tech stack
- springboot
  - thymeleaf
- sbt
  - orientdb drivers
  - lombok
  - PostConstruct annotation
- bootstrap
- jquery
- dataTable

## Docker stack
- orientdb:latest
- hseeberger/scala-sbt:11.0.2-oraclelinux7_1.3.5_2.12.10

## To run
`sudo ./install.sh -u`
- [OrientDB studio](http://localhost:2480/studio/index.html)
  - user: admin
  - password: admin

## To stop (optional)
`sudo ./install.sh -d`

## For help
`sudo ./install.sh -h`

## Credit
- [Source based](https://www.alibabacloud.com/blog/building-a-spring-boot-api-with-a-multi-model-database-orientdb-on-alibaba-cloud_594216)
- [Create init database](https://orientdb.com/docs/last/scala/Document-API-Database.html)
- [Default logins](https://orientdb.com/docs/last/scala/Document-API-Database.html)
