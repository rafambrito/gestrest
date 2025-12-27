# Etapa 1: Build do projeto com Maven
FROM maven:3.9.11-eclipse-temurin-25-alpine AS builder

WORKDIR /app

ENV MAVEN_OPTS="-Djava.io.tmpdir=/tmp"

# Copiar o arquivo de configuração do Maven e baixar dependências antes (otimiza cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar o restante do código e construir o jar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final (leve)
FROM eclipse-temurin:25-jre-jammy

WORKDIR /app

# Copiar o artefato compilado da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expor a porta padrão do Spring Boot (ajuste se necessário)
EXPOSE 8080

# Variável de ambiente (opcional)
ENV JAVA_OPTS=""

# Comando final para rodar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]