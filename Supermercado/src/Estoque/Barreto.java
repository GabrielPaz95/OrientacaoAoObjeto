package Estoque;

public class Barreto {
	
	
	gap semantico: falha na compreensão de requisitos. não é possivel nunca mais ter, mas é possivel reduzir.
			classe: 
	é a descrição de um modelo conceitual
	no ponto de vista conceitual : conceitual(transformação do mundo real e abtraiu informações para o mundo computacional.
		ponto de vista computacional : tipo
	modelar conceituamente algo que foi visualizado o mundo real
	epresentação da classe:
	2 propriedades, atributos e ações(metodos)
	toda classe modela conmceitualmente um objeto no mundo real
	, existem classe, que tem apenas metodos ou paenas atributos, e tb o dois juntos.

	representação de objetos
	conceito de objeto: um objeto possui um estado, exibe um comportamento bem-definido e possui uma identidade unica.

	objetos tem estado, comportamento e identidade diferente.

	Qualificadores de acesso a Classes
	encapsulamento

	publico: Indica que o conteúdo público da classe pode ser utilizado livremente por outras classes do mesmo ou de outro pacote.
		menos restritivos, tem acesso livre.
	package: Indica que o conteúdo público da classe pode ser utilizado livremente por outras classes pertencentes ao mesmo pacote.
		porem, apenas a msm classe.

	private: Indica que apenas manipulações internas podem haver dentro da classe, não permitindo acesso nem mesmo por suas instâncias.
		fica restrito a classe.

	protected:Indica que existe proteção e os detalhes da execução da classe não são apresentados.
		eclipse não completa.

	atributos: propriedades de um classe, representa caracteristca da classe, cada uma te
	são propriedades ou caracteristicas de uma classe.
	eles podem ser de tipos primitivos, ou personalizados.

	metodos: ações que estão associadas a classe.
	Enquanto os atributos permitem armazenar dados associados aos objetos, ou seja, valores que descrevem a aparência ou estado de um certo objeto, os métodos (methods) são capazes de realizar operações sobre os atributos de uma classe ou capazes de especificar ações ou transformações possíveis para um objeto.

	Isso significa que os métodos conferem um caráter dinâmico aos objetos pois permitem que os objetos exibam um comportamento que, em muitos casos, pode mimetizar (imitar) o comportamento de um objeto real.

	é uma caracteriscas da classe: atributos: inf
	metodos:ações

	metoodos, permite que podemoos dar ações aos atributos

	tipos primitivos, inteiros, flutuantes, caracter e booleano. <- 4 padrões***** se perguntar é esses.
	no java: inteiros(byte 8bits -128 +127, short 16bits -32.768 +32.167, int -2.147.483.648 +2.147.483.647, long -9.233.372.036.854.775.808 + 9.233.372.036.854.775.807)
	flutuante(float 32bits, double 64bits)
	caracter(char)
	logico(booleano)

	operadores:
	aritméticos (9): + - * / % -(negativo) +(positivo) ++ --
	Operadores Relacionais (6): == != > >= < <=
	Operadores Lógicos (3): &&(E Logico) ||(OU logico) !(negacao)
	Operadores de atribuição: =

	estruturas de controle
	repetição simples: for.(inicialização, condição, incremento/decremento)
	for(int i = 0; i<lista.size();i++){
	}

	for(String valor : lista){
	sysout(valor);
	}

	lista.forEach(i -> sysout(i);



	desvio de fluxo: if e switch.
	repetição condicionais: while e do while.

	ternario interrogação: a > 2018 ? "novo" : "Usado";

	vetores

	Conceito de estático computacionalmente falando
	static - não vai ser herdado, via ser usado diretamente da classe.
	é usado para criar atributos e métodos que irão existir independentemente de quaisquer instâncias criadas para a classe.
	static sempre é public
	é atributo ou metodo estatico que so exite dentro da propria classe, não é herdado pelas instancias.
	tudo que for static só exite dentro da classe.

	se o metodo é estatico, só pode chamar atributos estaticos.
	metodo n estatico, pode chamar estatico.

	construtores.
	metodos especiais que são executados quando objeto é criado

	existe 4 razões para que construtor seja consideado espeical
	1 - o metodo construtor tem o mesmo nome que a classe.
	2 - não possuem retorno (implicito que o retorno dele é o bjeto criado)
	3 - ele é executado por uma palavra reservada NEW (unica forma de chamar ele).
	4 - para poder construir um objeto de nivel de encapsulamento tem que ser publico. 

	por meio dos construtores conseguimos instanciar.

	qdo vc n cria, o java cria um sozinho, com valores default

	sobrecarga de metodos
	é um conceito, que permite instroduzir o polimorfismo
	permite que tenha metodos com o msm nome, porem com assinaturas diferentes.

	3 regras para diferencias as assinaturas
	1 - tipos do argumentos
	2 - numero de argumentos
	3 - ordem dos argumentos

	um desses tem que ser diferente.");

	)
}
