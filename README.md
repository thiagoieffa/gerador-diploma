RM87796 Thiago Michelle de Oliveira Ieffa
RM93617 Rafael Gomes de Almeida Vaz Privitera

Abrir o Docker Desktop
Abrir o terminal e rodar "docker compose up"

Acessar o MinIO
Digitar no url do navegador "localhost:9001"
Inserir login e senha
minioadmin - Login
minioadmin - Senha

Para rodar no POSTMAN - (*Preferencialmente este método*)
URL - localhost:8080/api/diploma
Mudar GET para POST
Logo abaixo selecionar a opção "Body"
Em seguida "raw" e mudar "Text" para "JSON"
E inserir o seguinte texto:

{
    "nome": "Rafa",
    "nacionalidade": "Brasileiro",
    "estado": "São Paulo",
    "dataDeNascimento": "05-08-1968",
    "rg": "383058505",
    "dataDeConclusao": "02-12-2022",
    "curso": "Sistemas de Informação",
    "nivelDeEspecializacao": "Bacharelado",
    "cargaHorariaEmHoras": "4080"
  }



Para rodar em WSL

curl --location --request POST
'localhost:8080/api/diploma' \
--header 'Content-Type: aplication/
json' \
--data raw '{
  "nome": "Thiago",
  "nacionalidade": "brasileiro",
  "estado": "São Paulo",
  "dataDeNascimento": "09-09-2002"
  "rg": "383058704",
  "dataDeConclusao": "02-12-2022",
  "curso": "Tecnologia da Informação",
  "nivelDeEspecializacao": "Barachaledo",
  "cargaHorariaEmHoras": "4080"
}'

Dessa forma o diploma sera gerado no MinIO e estará disponivel para visualização.
