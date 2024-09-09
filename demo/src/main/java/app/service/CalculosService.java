package app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Entrada;
import app.entity.Resultado;
import app.repository.CalculosRepository;

@Service
public class CalculosService {
	
	@Autowired
	private CalculosRepository calculosRepository;
	
	
	public List<Resultado> findAll(){
		return this.calculosRepository.findAll();
	}
	
	public Resultado calcular(Entrada entrada) {
		
		Resultado resultado = new Resultado();
		int soma = this.somar(  entrada.getLista() );
		System.out.println("A soma deu "+ soma);
		
		resultado.setSoma(soma);
		
		double media = this.media(entrada.getLista());
		resultado.setMedia(media);
		
		resultado = this.calculosRepository.save(resultado);
		
		return resultado;
		
	}
	
	public int somar(List<Integer> lista) {
		
		int soma = 0;
		
		for(int i=0; i<lista.size(); i++) {
			soma += lista.get(i);
		}
		
		return soma;
		
	}
	
	private double media(List<Integer> lista) {
		return (double) this.somar(lista) / lista.size();
	}
	
	public int maiorNumeroLista(List<Integer> lista) {
	    return lista.stream().max(Integer::compare).orElseThrow(() -> new RuntimeException("Lista vazia"));
	}

	public int menorNumeroLista(List<Integer> lista) {
	    return lista.stream().min(Integer::compare).orElseThrow(() -> new RuntimeException("Lista vazia"));
	}

	public int totalElementosLista(List<Integer> lista) {
	    return lista.size();
	}

	public int multiplicar(List<Integer> lista) {
	    return lista.stream().reduce(1, (a, b) -> a * b);
	}

	public int moda(List<Integer> lista) {
	    return lista.stream()
	        .reduce((a, b) -> lista.stream().filter(num -> num.equals(a)).count() >= lista.stream().filter(num -> num.equals(b)).count() ? a : b)
	        .orElseThrow(() -> new RuntimeException("Lista vazia"));
	}

	public double mediana(List<Integer> lista) {
	    List<Integer> sorted = lista.stream().sorted().collect(Collectors.toList());
	    int middle = sorted.size() / 2;
	    if (sorted.size() % 2 == 0) {
	        return (sorted.get(middle - 1) + sorted.get(middle)) / 2.0;
	    } else {
	        return sorted.get(middle);
	    }
	}

}
