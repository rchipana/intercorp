# intercorp
# Backend Java Developer

_Reto Tech - Intercorp Retail_

## Microservicio desarrollado en Java Spring boot y Desplegado en AWS Elastic Beanstalk
### Enviromment Intercorp Bucket S3 , EIP , Security Group , EC2 T2 Micro Java 8, CloudWatch , RDS mysql T2 Micro , Load Balancing Auto Scaling

### API Rest documentada en Swagger
* [Link Swagger-ui](http://intercorp-env.eba-vuqsptuc.us-east-1.elasticbeanstalk.com/swagger-ui.html#)


	
### Deployado en AWS(EC2 - RDS Mysql)

    CREATE TABLE `api`.`cliente` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `nombre` varchar(255) DEFAULT NULL,
    `apellido` varchar(255) DEFAULT NULL, 				
    `edad`  bigint(20) DEFAULT NULL,
    `fecha_nacimiento` datetime DEFAULT NULL,
    PRIMARY KEY (`id`));
    insert into api.cliente values(null, 'PEDRO','PINO',39,'1981-03-06');


	
### Endpoint de Entrada POST /creacliente:

    http://intercorp-env.eba-vuqsptuc.us-east-1.elasticbeanstalk.com/v0/api/clients
    {
      "nombre" : "PEDRO"
      "apellido": "TAPIA",
      "edad": 30,
      "fecha_nacimiento": "04/10/1980",
    }

### Endpoint de Salida GET /kpideclientes:
* [Link /kpideclientes](http://intercorp-env.eba-vuqsptuc.us-east-1.elasticbeanstalk.com/v0/api/kpideclientes)

### Endpoint de Salida GET /listclientes:
* [Link /listclientes](http://intercorp-env.eba-vuqsptuc.us-east-1.elasticbeanstalk.com/v0/api/clients)

