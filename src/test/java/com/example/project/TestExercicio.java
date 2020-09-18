package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestExercicio {

	private String BREAK = System.lineSeparator();

	@Test
	public void exercicio01() {
		rodarTestarOutput("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK + 
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}
	
	@Test
	public void exercicio02_tudoVazio() {
		CupomFiscal.NOME_LOJA = "";
		CupomFiscal.LOGRADOURO = "";
		CupomFiscal.NUMERO = 0;
		CupomFiscal.COMPLEMENTO = "";
		CupomFiscal.BAIRRO = "";
		CupomFiscal.MUNICIPIO = "";
		CupomFiscal.ESTADO = "";
		CupomFiscal.CEP = "";
		CupomFiscal.TELEFONE = "";
		CupomFiscal.OBSERVACAO = "";
		CupomFiscal.CNPJ = "";
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		
		rodarTestarOutput("" + BREAK + 
				", 0 " + BREAK + 
				" -  - " + BREAK + 
				"CEP: Tel " + BREAK + 
				"" + BREAK + 
				"CNPJ: " + BREAK + 
				"IE: " + BREAK);
	}

	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Smelly Cat";
		CupomFiscal.LOGRADOURO = "Rua Etheria";
		CupomFiscal.NUMERO = 205;
		CupomFiscal.COMPLEMENTO = "Perto da velhinha que mora em uma caverna";
		CupomFiscal.BAIRRO = "Br. Templo do Cristal";
		CupomFiscal.MUNICIPIO = "Beach City";
		CupomFiscal.ESTADO = "BC";
		CupomFiscal.CEP = "78051-604";
		CupomFiscal.TELEFONE = "(66)4002-8922";
		CupomFiscal.OBSERVACAO = "Por Favor ignorar os exército Intergalácticos em guerra tentando dominar o planeta";
		CupomFiscal.CNPJ = "53.409.609/0001-85";
		CupomFiscal.INSCRICAO_ESTADUAL = "512.670.302.653";

		String expected = "Smelly Cat"+ BREAK;
		expected += "Rua Etheria, 205 Perto da velhinha que mora em uma caverna" + BREAK;
		expected += "Br. Templo do Cristal - Beach City - BC" + BREAK;
		expected += "CEP:78051-604 Tel (66)4002-8922" + BREAK;
		expected += "Por Favor ignorar os exército Intergalácticos em guerra tentando dominar o planeta" + BREAK;
		expected +="CNPJ: 53.409.609/0001-85" + BREAK;
		expected += "IE: 512.670.302.653";
		
		//E atualize o texto esperado abaixo
		rodarTestarOutput(expected + BREAK);
	}

	private void rodarTestarOutput(String expected) {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		// action
		CupomFiscal.main(null);

		// assertion
		assertEquals(expected, bos.toString());

		// undo the binding in System
		System.setOut(originalOut);
	}
}
