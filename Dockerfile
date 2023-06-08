# Define a imagem base
FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR para o container
COPY aos/target/aos-0.0.1-SNAPSHOT.jar /app/aos.jar

# Expõe a porta do aplicativo
EXPOSE https://pibicdb-barbosaerick88.b4a.run/

# Define o comando para executar o aplicativo quando o container for iniciado
CMD ["java", "-jar", "aos.jar"]
