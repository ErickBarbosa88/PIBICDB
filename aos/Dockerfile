# Define a imagem base
FROM openjdk:17

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR para o container
COPY /aos/target/aos-0.0.1-SNAPSHOT.jar /app/aos.jar

# Expõe a porta do aplicativo
EXPOSE 8000

# Define o comando para executar o aplicativo quando o container for iniciado
CMD ["java", "-jar", "/app/aos.jar"]

