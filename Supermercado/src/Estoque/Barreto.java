package Estoque;

public class Barreto {
	
	
	gap semantico: falha na compreens�o de requisitos. n�o � possivel nunca mais ter, mas � possivel reduzir.
			classe: 
	� a descri��o de um modelo conceitual
	no ponto de vista conceitual : conceitual(transforma��o do mundo real e abtraiu informa��es para o mundo computacional.
		ponto de vista computacional : tipo
	modelar conceituamente algo que foi visualizado o mundo real
	epresenta��o da classe:
	2 propriedades, atributos e a��es(metodos)
	toda classe modela conmceitualmente um objeto no mundo real
	, existem classe, que tem apenas metodos ou paenas atributos, e tb o dois juntos.

	representa��o de objetos
	conceito de objeto: um objeto possui um estado, exibe um comportamento bem-definido e possui uma identidade unica.

	objetos tem estado, comportamento e identidade diferente.

	Qualificadores de acesso a Classes
	encapsulamento

	publico: Indica que o conte�do p�blico da classe pode ser utilizado livremente por outras classes do mesmo ou de outro pacote.
		menos restritivos, tem acesso livre.
	package: Indica que o conte�do p�blico da classe pode ser utilizado livremente por outras classes pertencentes ao mesmo pacote.
		porem, apenas a msm classe.

	private: Indica que apenas manipula��es internas podem haver dentro da classe, n�o permitindo acesso nem mesmo por suas inst�ncias.
		fica restrito a classe.

	protected:Indica que existe prote��o e os detalhes da execu��o da classe n�o s�o apresentados.
		eclipse n�o completa.

	atributos: propriedades de um classe, representa caracteristca da classe, cada uma te
	s�o propriedades ou caracteristicas de uma classe.
	eles podem ser de tipos primitivos, ou personalizados.

	metodos: a��es que est�o associadas a classe.
	Enquanto os atributos permitem armazenar dados associados aos objetos, ou seja, valores que descrevem a apar�ncia ou estado de um certo objeto, os m�todos (methods) s�o capazes de realizar opera��es sobre os atributos de uma classe ou capazes de especificar a��es ou transforma��es poss�veis para um objeto.

	Isso significa que os m�todos conferem um car�ter din�mico aos objetos pois permitem que os objetos exibam um comportamento que, em muitos casos, pode mimetizar (imitar) o comportamento de um objeto real.

	� uma caracteriscas da classe: atributos: inf
	metodos:a��es

	metoodos, permite que podemoos dar a��es aos atributos

	tipos primitivos, inteiros, flutuantes, caracter e booleano. <- 4 padr�es***** se perguntar � esses.
	no java: inteiros(byte 8bits -128 +127, short 16bits -32.768 +32.167, int -2.147.483.648 +2.147.483.647, long -9.233.372.036.854.775.808 + 9.233.372.036.854.775.807)
	flutuante(float 32bits, double 64bits)
	caracter(char)
	logico(booleano)

	operadores:
	aritm�ticos (9): + - * / % -(negativo) +(positivo) ++ --
	Operadores Relacionais (6): == != > >= < <=
	Operadores L�gicos (3): &&(E Logico) ||(OU logico) !(negacao)
	Operadores de atribui��o: =

	estruturas de controle
	repeti��o simples: for.(inicializa��o, condi��o, incremento/decremento)
	for(int i = 0; i<lista.size();i++){
	}

	for(String valor : lista){
	sysout(valor);
	}

	lista.forEach(i -> sysout(i);



	desvio de fluxo: if e switch.
	repeti��o condicionais: while e do while.

	ternario interroga��o: a > 2018 ? "novo" : "Usado";

	vetores

	Conceito de est�tico computacionalmente falando
	static - n�o vai ser herdado, via ser usado diretamente da classe.
	� usado para criar atributos e m�todos que ir�o existir independentemente de quaisquer inst�ncias criadas para a classe.
	static sempre � public
	� atributo ou metodo estatico que so exite dentro da propria classe, n�o � herdado pelas instancias.
	tudo que for static s� exite dentro da classe.

	se o metodo � estatico, s� pode chamar atributos estaticos.
	metodo n estatico, pode chamar estatico.

	construtores.
	metodos especiais que s�o executados quando objeto � criado

	existe 4 raz�es para que construtor seja consideado espeical
	1 - o metodo construtor tem o mesmo nome que a classe.
	2 - n�o possuem retorno (implicito que o retorno dele � o bjeto criado)
	3 - ele � executado por uma palavra reservada NEW (unica forma de chamar ele).
	4 - para poder construir um objeto de nivel de encapsulamento tem que ser publico. 

	por meio dos construtores conseguimos instanciar.

	qdo vc n cria, o java cria um sozinho, com valores default

	sobrecarga de metodos
	� um conceito, que permite instroduzir o polimorfismo
	permite que tenha metodos com o msm nome, porem com assinaturas diferentes.

	3 regras para diferencias as assinaturas
	1 - tipos do argumentos
	2 - numero de argumentos
	3 - ordem dos argumentos

	um desses tem que ser diferente.");

	)
}
