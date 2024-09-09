package app.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculosService;

@SpringBootTest //Contexto do Spring nos testes
public class CalculosServiceTest {
	
	@Autowired
	private CalculosService calculosService;
	
	
	
	@Test //JUNIT - indicação de método de teste
	@DisplayName("Teste unitário - cenário de soma = 10")
	void cenario01() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(4);
		lista.add(2);
		
		int soma = calculosService.somar(lista);
		
		Assertions.assertEquals(10, soma); //JUNIT - verificações - teste em si
		
	}
	
	
	
	@Test //JUNIT - indicação de método de teste
	@DisplayName("Teste unitário - cenário de erro")
	void cenario02() {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(4);
		lista.add(null);
		
		Assertions.assertThrows(Exception.class, () -> {
			int soma = calculosService.somar(lista);
		} );
		
	}
	
	@Test
	@DisplayName("Teste unitário - maior número da lista")
	void maiorNumeroCenario() {
	    List<Integer> lista = List.of(1, 2, 3, 4, 5);
	    int maior = calculosService.maiorNumeroLista(lista);
	    Assertions.assertEquals(5, maior);
	}

	@Test
	@DisplayName("Teste unitário - menor número da lista")
	void menorNumeroCenario() {
	    List<Integer> lista = List.of(1, 2, 3, 4, 5);
	    int menor = calculosService.menorNumeroLista(lista);
	    Assertions.assertEquals(1, menor);
	}

	@Test
	@DisplayName("Teste unitário - total de elementos da lista")
	void totalElementosCenario() {
	    List<Integer> lista = List.of(1, 2, 3, 4, 5);
	    int total = calculosService.totalElementosLista(lista);
	    Assertions.assertEquals(5, total);
	}

	@Test
	@DisplayName("Teste unitário - multiplicação dos elementos da lista")
	void multiplicarCenario() {
	    List<Integer> lista = List.of(1, 2, 3);
	    int produto = calculosService.multiplicar(lista);
	    Assertions.assertEquals(6, produto);
	}

	@Test
	@DisplayName("Teste unitário - moda da lista")
	void modaCenario() {
	    List<Integer> lista = List.of(1, 2, 2, 3, 4);
	    int moda = calculosService.moda(lista);
	    Assertions.assertEquals(2, moda);
	}

	@Test
	@DisplayName("Teste unitário - mediana da lista")
	void medianaCenario() {
	    List<Integer> lista = List.of(1, 2, 3, 4, 5);
	    double mediana = calculosService.mediana(lista);
	    Assertions.assertEquals(3.0, mediana);
	}
}
