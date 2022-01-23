## Instruções
- O projeto está bem simples de rodar basta executar os comandos build e bootRun do menu do Gradle na propria IDE.
    OU pelas mesmas tasks do gradle via terminal.
- Os testes são executados como dependência do build.

### Documentação (com a aplicação rodando)
- O swagger para fins de documentação e praticidade de teste está disponível em: http://localhost:8080/swagger-ui.html
- O JSON com a documentação da API está disponível em: http://localhost:8080/v3/api-docs

### Exemplo de chamada para teste
    curl -X 'POST' \
    'http://localhost:8080/validate' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
    "password": "string"
    }'

## Detalhes da Solução
- Decidi utilizar uma arquitetura derivando dos conceitos do _DDD_ que garantiu uma boa organização mesmo para o relativamente pequeno domínio.
- Para o problema principal do domínio decidi implementar o padrão de projeto _Decorator_ (https://refactoring.guru/design-patterns/decorator),
    onde além de atender muito bem a proposta da app proporcionou uma ótima extensibilidade, coesão e baixíssimo acoplamento.
- Utilizei algumas regex por praticidade.
- Os testes foram escritos respeitando os princípios _FIRST_ (a app está coberta por testes de unidade e de integração)