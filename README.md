1- Creamos el proyecto como ya sabemos

2- Nos vamos a la base de datos JavaDB, botón derecho -> Create new Data Base y ponemos los datos

3- Metemos el esquema de la base de datos y los datos a través de las consultas.

4- Ahora nos vamos al ejb del proyecto -> botón de derecho -> connection Pool -> le damos el nombre que queramos -> -> seleccionamos la base de datos que queramos (la previamente creada) -> pulsamos next -> -> En Resouce Type seleccionamos la opción javax.sql.ConnectionPoolDataSource -> -> y ahora siguiente siguiente.... 5- Pasamos el fichero glassfish-resouce.xml a la carpeta Server Resources.

6- Botón derecho en el ejb -> new -> other -> glassfish -> JDBC Resources -> -> Seleccionamos el connetion Pool y le ponemos en el JNDI el nombre que queramos Normalmente jdcb/nombre -> siguiente siguiente. 7- Y ahora ya generamos los entity y lo ejb

8- Y nos ponemos a trabajar