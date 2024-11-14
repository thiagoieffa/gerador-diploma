RM87796 Thiago Michelle de Oliveira Ieffa
RM93617 Rafael Gomes de Almeida Vaz Privitera





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
