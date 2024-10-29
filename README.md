# DESAFIO: Modelo de domínio e ORM

## Objetivo

Construir um sistema no Spring Boot com Java e banco de dados H2 para gerenciar informações dos participantes em atividades de um evento acadêmico. O sistema deverá implementar o modelo conceitual especificado, com o seeding dos dados conforme o diagrama de objetos fornecido.
## Especificação - Sistema EVENTO

Deseja-se construir um sistema para gerenciar as informações dos participantes das atividades de um evento acadêmico, que podem ser palestras, cursos, oficinas práticas, entre outros.

Cada atividade possui:
- **Nome**: nome da atividade.
- **Descrição**: descrição detalhada da atividade.
- **Preço**: valor da inscrição para a atividade.
- **Blocos de horários**: cada atividade pode ser dividida em vários blocos de horários, e é necessário armazenar o dia e os horários de início e fim de cada bloco.

Para cada participante, deseja-se cadastrar:
- **Nome**: nome completo do participante.
- **Email**: email de contato do participante.

## Tecnologias utilizadas

- Spring Boot
- Java
- Banco de dados H2


### Diagrama de objetos e modelo conceitual

![Captura de tela 2024-10-29 192120](https://github.com/user-attachments/assets/6dfe52a5-5080-4c69-924e-e3222e1351ff)

### Instância dos dados para seeding

![Captura de tela 2024-10-29 192448](https://github.com/user-attachments/assets/22577ddf-170e-404b-be7f-eb10716b81d3)

