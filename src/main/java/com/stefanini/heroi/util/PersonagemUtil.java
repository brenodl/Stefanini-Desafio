package com.stefanini.heroi.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.stefanini.heroi.dto.PersonagemDto;

public class PersonagemUtil {
	
	//Variáveis final
	final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("com/stefanini/heroi/controller/charcters_stats.csv");
	
	public PersonagemUtil(){
		
	}
	
	public List<PersonagemDto> carregaCSV() throws IOException{
		List<PersonagemDto> personagemDtos = new ArrayList<PersonagemDto>();
		Reader reader = new InputStreamReader(inputStream);
		CSVReader leitor = new CSVReaderBuilder(reader).withSkipLines(1).build();
		List<String[]> csv = leitor.readAll();
		Integer count = 0;
		
		for (String[] linhas : csv){
			PersonagemDto personagemDto = new PersonagemDto();
	        for (String coluna : linhas){
	        	if(count == 0)
	        		personagemDto.setNome(coluna);
	        	if(count == 1)
	        		personagemDto.setAlinhamento(coluna);
	        	if(count == 2)
	        		personagemDto.setInteligencia(Integer.valueOf(coluna));
	        	if(count == 3)
	        		personagemDto.setForca(Integer.valueOf(coluna));
	        	if(count == 4)
	        		personagemDto.setDestreza(Integer.valueOf(coluna));
	        	if(count == 5)
	        		personagemDto.setDefesa(Integer.valueOf(coluna));
	        	if(count == 6)
	        		personagemDto.setPoder(Integer.valueOf(coluna));
	        	if(count == 7)
	        		personagemDto.setCombate(Integer.valueOf(coluna));
	        	
	        	count++;
	        	
	        	if(count == 8){
	        		personagemDtos.add(personagemDto);
	        		personagemDto = null;
	        		count = 0;
	        	}
	        }
		}
		
		leitor.close();
		
		return personagemDtos;
	}
}