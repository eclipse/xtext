package de.itemis.junit.parameterizedcsv.example;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.itemis.junit.ParameterizedCSV;

@RunWith(ParameterizedCSV.class)
public class MyParamTest {

	@Test
	public List<String> stringAdd(List<String> line) {
		line.set(2, line.get(0) + line.get(1));
		return line;
	}
}
