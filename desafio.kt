enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val login: String, var formacaoMatriculada: Formacao? = null, val matricula: Int, val nivel: Nivel)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val inscritos: MutableList<Usuario> = mutableListOf()) {

    var qtdInscritos: Int = 0

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        usuario.formacaoMatriculada = this
        qtdInscritos++
    }
}

fun matricularUsuario(usuario: Usuario, iniciante: Formacao, kotlin: Formacao, dados: Formacao) {
    when (usuario.nivel) {
        Nivel.BASICO -> iniciante.matricular(usuario)
        Nivel.INTERMEDIARIO -> kotlin.matricular(usuario)
        Nivel.AVANCADO -> dados.matricular(usuario)
    }
}

fun main() {
    val poo = ConteudoEducacional("POO", 20)
    val logica = ConteudoEducacional("Lógica", 15)
    val estrutura = ConteudoEducacional("Estrutura de Dados", 10)
    val cienciaDados = ConteudoEducacional("Ciência de Dados", 40)

    val iniciante = Formacao("Iniciante", listOf(logica, poo))
    val kotlin = Formacao("Kotlin", listOf(poo, logica, estrutura))
    val dados = Formacao("Ciencia de Dados", listOf(poo, logica, estrutura, cienciaDados))

    val user1 = Usuario("Carlos", "Carlos@gmail.com", matricula = 1, nivel = Nivel.BASICO)
    val user2 = Usuario("Joana", "Joana@gmail.com", matricula = 2, nivel = Nivel.INTERMEDIARIO)
    val user3 = Usuario("Felipe", "Felipe@gmail.com", matricula = 3, nivel = Nivel.AVANCADO)
    val user4 = Usuario("Maria", "Maria@gmail.com", matricula = 4, nivel = Nivel.BASICO)

    matricularUsuario(user1, iniciante, kotlin, dados)
    matricularUsuario(user2, iniciante, kotlin, dados)
    matricularUsuario(user3, iniciante, kotlin, dados)
    matricularUsuario(user4, iniciante, kotlin, dados)

    // Exemplo de como acessar informações após a matrícula
    println("${user1.nome} está matriculado na formação ${user1.formacaoMatriculada?.nome}")
    println("${user2.nome} está matriculado na formação ${user2.formacaoMatriculada?.nome}")
    println("${user3.nome} está matriculado na formação ${user3.formacaoMatriculada?.nome}")
    println("${user4.nome} está matriculado na formação ${user4.formacaoMatriculada?.nome}")

    println("Os inscritos na formação Ciencia de Dados são ${iniciante.inscritos.map { it.nome }}")
	println("Os inscritos na formação Kotlin são ${kotlin.inscritos.map { it.nome }}")
    println("Os inscritos na formação Ciencia de Dados são ${dados.inscritos.map { it.nome }}")
    println("A quantidade de alunos inscritos na formação Iniciante ${iniciante.inscritos.size}}")
    println("A quantidade de alunos inscritos na formação Kotlin ${kotlin.inscritos.size}}")
    println("A quantidade de alunos inscritos na formação Dados ${dados.inscritos.size}}")
    
}
