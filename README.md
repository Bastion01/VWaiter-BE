#Create application container: podman build -f Dockerfile -t menu-management-service-image

#Start database and application: sudo docker compose  -f postgres-compose.yaml  up -d