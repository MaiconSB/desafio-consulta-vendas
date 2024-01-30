# Desafio Consulta Vendas - Projeto Backend Java

Este projeto faz parte da Formação Desenvolvedor Moderno, no módulo de Back end, específico para JPA, consultas SQL e JPQL. O desafio consiste em implementar consultas em um sistema de vendas e vendedores utilizando Java com Spring Boot.

## Informações do Projeto

- **Projeto Base:** [Desafio Consulta Vendas](https://github.com/devsuperior/desafio-consulta-vendas)
- **Autor:** Nelio Alves 
- **Contato:** contato@devsuperior.com

## Descrição do Projeto

Trata-se de um sistema de vendas com duas entidades principais: `Sale` e `Seller`. Cada venda pertence a um vendedor, e um vendedor pode ter várias vendas.

### Entidades

#### Sale
- id: Long
- visited: Integer
- deals: Integer
- amount: Double
- date: LocalDate

#### Seller
- id: Long
- name: String
- email: String
- phone: String

## Consultas a Serem Implementadas

### 1. Relatório de Vendas

1. **[IN]** O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.
2. **[OUT]** O sistema retorna uma listagem paginada contendo id, data, quantia vendida e nome do vendedor das vendas que se enquadram nos dados informados.

**Informações Complementares:**
- Se a data final não for informada, considerar a data atual do sistema.
- Se a data inicial não for informada, considerar a data de 1 ano antes da data final.

### 2. Sumário de Vendas por Vendedor

1. **[IN]** O usuário informa, opcionalmente, data inicial, data final.
2. **[OUT]** O sistema retorna uma listagem contendo nome do vendedor e soma de vendas deste vendedor no período informado.

**Informações Complementares:**
- Mesmas informações do caso de uso "Relatório de Vendas"

## Como Executar o Projeto

1. Clone este repositório para o seu ambiente de desenvolvimento.
   ```bash
   git clone https://github.com/seu-usuario/desafio-consulta-vendas.git

## Testes Manuais no Postman
Certifique-se de que o projeto está em execução e faça os testes manuais utilizando o Postman. As requisições já estão preparadas na Coleção Postman. As seguintes requisições devem funcionar corretamente:

#### 2.1 Sumário de Vendas por Vendedor (Teste 1)
bash
Copy code
GET /sales/summary?minDate=2022-01-01&maxDate=2022-06-30
Deverá retornar o sumário de vendas por vendedor no período informado.

#### 2.2 Sumário de Vendas por Vendedor (Teste 2)
 ``` bash
GET /sales/summary
```
Deverá retornar o sumário de vendas por vendedor dos últimos 12 meses.

#### 2.3 Relatório de Vendas (Teste 1)
``` bash
GET /sales/report
```
Deverá retornar o relatório de vendas dos últimos 12 meses.

#### 2.4 Relatório de Vendas (Teste 2)
``` bash
GET /sales/report?minDate=2022-05-01&maxDate=2022-05-31&name=odinson
```
Deverá retornar o relatório de vendas do período/vendedor informados.

# 

*Este é um projeto desenvolvido como parte do curso de Formação Desenvolvedor Moderno oferecido pela [DevSuperior](https://devsuperior.com.br).* 






