# Conserjeria Arquitectura De Sistemas

### Requirements

> IntelIDJ
> 
> Docker Desktop

### Clone Repository

If you want to clone this repository run the next code 

```bash
git@github.com:JuanJr44/Arq_Sis_Conserjeria.git
```

### Docker

The first step to create the Docker you must run the next code line

```bash
cd conserjeria
```

Now you can create the dockers

#### SQLite


```bash
docker-compose up -d
```

#### MariaDB

```bash
docker-compose -f docker-compose-mariadb.yml up -d
```

## SQLite

To check the sistem works this are important notes:
> ports for this sistem is 7070 and you can change it if you want
> 
> this ports you can find in the docker-compose
> 
> you can check this ports, but in the excecute you always see in Javalin the localhost port 7070
>
> next step open the localhost in your browser and continue the link adding /personas , this route will show you all the entities from the database
>
> and the final step is delete the las route "/personas" and add /persona/rut/"{rut_of_persona}" , the {rut_of_persona} is the rut can you check on the personas route



## MarioDB

To check the sistem works this are important notes:
> ports for this sistem is 7071 and you can change it if you want
> 
> this ports you can find in the docker-compose
> 
> you can check this ports, but in the excecute you always see in Javalin the localhost port 7070
> 
> next step open the localhost in your browser and continue the link adding /personas , this route will show you all the entities from the database
>
> and the final step is delete the las route "/personas" and add /persona/rut/"{rut_of_persona}" , the {rut_of_persona} is the rut can you check on the personas route
