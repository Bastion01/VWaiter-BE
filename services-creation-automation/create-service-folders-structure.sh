#!/bin/bash
SERVICE_NAME="notification-service" #example menu-management-service
SERVICE_NAME_CAMEL_CASE="NotificationService" #example MenuManagementService

echo "$SERVICE_NAME folders structure creation started!"
mkdir -p "$SERVICE_NAME"
touch $SERVICE_NAME/Dockerfile
sed 's/menu-management-service/'$SERVICE_NAME'/g' templates/Dockerfile > $SERVICE_NAME/Dockerfile 
touch $SERVICE_NAME/pom.xml
sed 's/menu-management-service/'$SERVICE_NAME'/g' templates/root-pom.xml > $SERVICE_NAME/pom.xml 
sed -i 's/MenuManagementService/'$SERVICE_NAME_CAMEL_CASE'/g' $SERVICE_NAME/pom.xml 

mkdir -p "$SERVICE_NAME/$SERVICE_NAME-api/src/main/java/com/vwaiter/controllers/rest"
mkdir -p "$SERVICE_NAME/$SERVICE_NAME-api/src/main/resources"
touch $SERVICE_NAME/$SERVICE_NAME-api/pom.xml
sed 's/menu-management-service/'$SERVICE_NAME'/g' templates/api-pom.xml > $SERVICE_NAME/$SERVICE_NAME-api/pom.xml

mkdir -p "$SERVICE_NAME/$SERVICE_NAME-application/src/main/java/com/vwaiter"
touch $SERVICE_NAME/$SERVICE_NAME-application/pom.xml
sed 's/menu-management-service/'$SERVICE_NAME'/g' templates/application-pom.xml > $SERVICE_NAME/$SERVICE_NAME-application/pom.xml
sed -i 's/MenuManagementService/'$SERVICE_NAME_CAMEL_CASE'/g' $SERVICE_NAME/$SERVICE_NAME-application/pom.xml
touch $SERVICE_NAME/$SERVICE_NAME-application/src/main/java/com/vwaiter/$SERVICE_NAME_CAMEL_CASE""Application.java
sed 's/MenuManagementService/'$SERVICE_NAME_CAMEL_CASE'/g' templates/MenuManagementServiceApplication.java > $SERVICE_NAME/$SERVICE_NAME-application/src/main/java/com/vwaiter/$SERVICE_NAME_CAMEL_CASE""Application.java
mkdir -p "$SERVICE_NAME/$SERVICE_NAME-application/src/main/resources"
touch $SERVICE_NAME/$SERVICE_NAME-application/src/main/resources/application.properties
sed 's/menu-management-service/'$SERVICE_NAME'/g' templates/application.properties > $SERVICE_NAME/$SERVICE_NAME-application/src/main/resources/application.properties

mkdir -p "$SERVICE_NAME/$SERVICE_NAME-database/src/main/java/com/vwaiter/repository"
touch $SERVICE_NAME/$SERVICE_NAME-database/pom.xml
sed 's/menu-management-service/'$SERVICE_NAME'/g' templates/database-pom.xml > $SERVICE_NAME/$SERVICE_NAME-database/pom.xml
mkdir -p "$SERVICE_NAME/$SERVICE_NAME-database/src/main/java/com/vwaiter/service"
mkdir -p "$SERVICE_NAME/$SERVICE_NAME-database/src/main/resources"
touch $SERVICE_NAME/$SERVICE_NAME-database/src/main/resources/database.properties
cat templates/database.properties > $SERVICE_NAME/$SERVICE_NAME-database/src/main/resources/database.properties

mkdir -p "$SERVICE_NAME/$SERVICE_NAME-model/src/main/java/com/vwaiter"
mkdir -p "$SERVICE_NAME/$SERVICE_NAME-model/src/main/resources"
touch $SERVICE_NAME/$SERVICE_NAME-model/pom.xml
sed 's/menu-management-service/'$SERVICE_NAME'/g' templates/model-pom.xml > $SERVICE_NAME/$SERVICE_NAME-model/pom.xml

echo "$SERVICE_NAME folders structure creation finished successfully"