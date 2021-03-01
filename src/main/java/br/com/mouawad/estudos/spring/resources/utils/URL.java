package br.com.mouawad.estudos.spring.resources.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

	public static List<Integer> decodeIntList(String s) {
/*		String[] sAux = s.split(",");
		
		List<Integer> lAux = new ArrayList<>();
		
		for(String i : sAux ) {
			lAux.add(Integer.parseInt(i));
		}
		
		return lAux;*/
		
		return Arrays.asList(s.split(","))
				.stream()
				.map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
	}
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
