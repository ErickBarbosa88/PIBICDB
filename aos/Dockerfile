# Define a imagem base
FROM khipu/openjdk17-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR para o container
COPY target/aos-0.0.1-SNAPSHOT.jar /app/aos.jar

# Expõe a porta do aplicativo
EXPOSE 8080

# Define o comando para executar o aplicativo quando o container for iniciado
CMD ["java", "-jar", "aos.jar"]
