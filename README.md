# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**


```kotlin
TODO("Crie uma solução em Koltin abstraindo esse domínio. O arquivo [desafio.kt] te ajudará 😉")
```
# Sistema de Matrícula de Usuários em Formações

Este é um sistema simples em Kotlin para matricular usuários em diferentes formações educacionais com base em seus níveis de conhecimento.

## Classes

### `Usuario`

A classe `Usuario` representa os usuários do sistema, contendo informações como nome, login, formação matriculada, matrícula e nível.

### `ConteudoEducacional`

A classe `ConteudoEducacional` modela os conteúdos educacionais com nome e duração.

### `Formacao`

A classe `Formacao` representa as formações educacionais, contendo nome, lista de conteúdos, lista de inscritos e a quantidade total de inscritos.

## Funcionalidades

- **Matrícula de Usuários**: A função `matricular` na classe `Formacao` permite matricular usuários em uma formação específica com base em seu nível.

- **Contagem de Inscritos**: A classe `Formacao` mantém um controle do número de inscritos através da propriedade `qtdInscritos`.

## Exemplo de Uso

```kotlin
// Criando instâncias de ConteudoEducacional, Formacao e Usuario

// Matriculando usuários em formações com base no nível
matricularUsuario(user1, iniciante, kotlin, dados)
matricularUsuario(user2, iniciante, kotlin, dados)
// ...

// Exibindo informações após a matrícula
println("${user1.nome} está matriculado na formação ${user1.formacaoMatriculada?.nome}")
println("${user2.nome} está matriculado na formação ${user2.formacaoMatriculada?.nome}")
// ...
