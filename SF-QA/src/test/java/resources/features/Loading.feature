# language: pt

	
	Funcionalidade: Tela Loading
	
	Fundo:
		Dado que o usuario esta na tela inicial preparate
		#E que o usuario esta na tela de vendedor
		#E insiro codigo do vendedor"A01"
		#E seleciono agencia do vendedor"18 de julio"
		#E clicar no botao continuar
		E que o usuario esta na tela preparate
		E clicar no botao continuar
		E que o usuario esta na tela tipo de cedula
		E seleciona tipo de documento sem chip
		E seleciona continuar
		E que o usuario esta na tela frente documento
		E inseri numero frente documento "00000000" 
		E seleciona continuar
		E que o usuario esta na tela para inserir documento sem chip
		E inseri serie "K"
		E inseri numero de folio "999999"
		E seleciona continuar
		E apresenta tela como te contactamos
		E que o usuario esta na tela de contacto
		E inseri numero de celular "099887687"
		E inseri e-mail "andres@itau.com.uy"
		E seleciona continuar
		E apresenta tela estado civil
		E seleciono opcao casado
    E clico em avanzar
    E insiro numero de cedula "11111111"
    E clico em avanzar
    E seleciono outra atividade laboral
    E digito atividade laboral "sistemas"
    E clico em avanzar labora
    E apresenta tela de loading
		
		
	Cenario: Loading selecionando carrocel valido
		Dado que estou na tela de loading
		#E seleciono primeira bolinha do carrocel
		#E seleciono segunda bolinha do carrocel
		#E seleciono terceira bolinha do carrocel
		
		@ignore
	Cenario: Loading selecionando terceiro opção carrocel valido
		Dado que estou na tela de loading
		E seleciono terceira bolinha do carrocel
		
		@ignore
	Cenario: Loading aguardar carrocel valido
		Dado que estou na tela de loading
		E aguardo carrocel percorrer mensagens