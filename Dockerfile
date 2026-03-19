FROM mysql/mysql-server:latest

ENV MYSQL_ROOT_PASSWORD=password_root
ENV MYSQL_DATABASE=veterinaria_db
ENV MYSQL_USER=vet_user
ENV MYSQL_PASSWORD=password