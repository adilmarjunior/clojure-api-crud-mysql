## Start server
 `lein run`

## MYSQL Docker config

  ### Up mysql image
  `sudo docker run -p 3306:3306 --name=MySQLTest -d mysql/mysql-server:latest`

  ### Get password created
  `docker logs MySQLTest`
  log ex: [Entrypoint] GENERATED ROOT PASSWORD: +F%BhcY%=a?J0sr?A%/8QWt9F8001yh1

  ### Update mysql root password
    - Connect to container
    `docker exec -it MySQLTest bash`
    - Connect to mysql cli
    `mysql`
    - Change password
    `ALTER USER 'root'@'localhost' IDENTIFIED BY 'NewPassword';`
  
  ### Issues to connect
  
  #### Host '172.17.0.1' is not allowed to connect to this MySQL server.
    - Connect to mysql in container
    - change the host to blank: `update mysql.user set host = ' '    where user = 'root';
    flush privileges;`
  
  #### Public Key Retrieval is not allowed
    - In your client set allowPublicKeyRetrieval=true and useSSL=false