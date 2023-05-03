// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel) {
    private val conteudos = mutableListOf<ConteudoEducacional>()
    private val inscritos = mutableListOf<Usuario>()

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }

    fun exibirConteudos() {
        conteudos.forEach { println(it.nome) }
    }

    fun inscrever(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun cancelarInscricao(usuario: Usuario) {
        inscritos.remove(usuario)
    }

    fun exibirInscritos() {
        inscritos.forEach { println(it.nome) }
    }
}

fun main() {
    val usuario1 = Usuario("Carlo")
    val usuario2 = Usuario("Isabela")

    val conteudo1 = ConteudoEducacional("Kotlin para iniciantes")
    val conteudo2 = ConteudoEducacional("Kotlin intermediário")
    val conteudo3 = ConteudoEducacional("Kotlin avançado")

    val formacao1 = Formacao("Desenvolvimento Android com Kotlin", Nivel.INTERMEDIARIO)
    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)

    val formacao2 = Formacao("Desenvolvimento Web com Kotlin", Nivel.BASICO)
    formacao2.adicionarConteudo(conteudo1)
    formacao2.adicionarConteudo(conteudo3)

    formacao1.inscrever(usuario1)
    formacao1.inscrever(usuario2)
    formacao2.inscrever(usuario1)

    formacao1.exibirInscritos()
    formacao1.cancelarInscricao(usuario2)
    formacao1.exibirInscritos()

    formacao2.exibirConteudos()
}