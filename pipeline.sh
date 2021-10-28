# # Este arquivo é apenas uma demonstração de uma "pipeline" escrita com shell script, apenas para efeitos didáticos.
# # Este exemplo pode (e deve) ser enriquecido com mais detalhes, porém não fazem parte do escopo da disciplina. 

# # 1. Limpar o ambiente
mvn clean

# # 2. Instalar as dependencias
 mvn install -DskipTests


# # 3. Rodar os testes automatizados
 mvn test

# 4. Rodar a analise do dependency track
MVN_GROUPID="$(mvn -q -Dexec.executable=echo -Dexec.args='${project.groupId}' exec:exec)"
MVN_ARTIFACTID="$(mvn -q -Dexec.executable=echo -Dexec.args='${project.artifactId}' exec:exec)"
MVN_VERSION="$(mvn -q -Dexec.executable=echo -Dexec.args='${project.version}' exec:exec)"
curl -X "POST" "https://8081-lavender-spoonbill-5f1p2o0b.ws-us18.gitpod.io/api/v1/bom" \
      -H 'Content-Type: multipart/form-data' \
      -H 'X-API-Key: 8kgEYuHFBySWoibLVhFpmyuipooGQiCb ' \
      -F "autoCreate=true" \
      -F "projectName=$MVN_GROUPID:$MVN_ARTIFACTID" \
      -F "projectVersion=$MVN_VERSION" \
      -F "bom=@target/bom.xml"


# # 5. Rodar a analise do sonarqube
# startStep sonarqube
# docker run \
#   --rm \
#   -e SONAR_HOST_URL="$SONAR_URL" \
#   -e SONAR_LOGIN="$SONAR_TOKEN" \
#   -v "$(pwd)/src:/usr/src" \
#   sonarsource/sonar-scanner-cli \
#   -Dsonar.projectKey="$MVN_GROUPID:$MVN_ARTIFACTID" \
#   -Dsonar.projectName="$MVN_GROUPID:$MVN_ARTIFACTID" \
#   -Dsonar.projectVersion="$MVN_VERSION" \
#   -Dsonar.sourceEncoding="UTF-8"

# 6. Empacotar o projeto
mvn package -DskipTests
