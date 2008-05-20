package org.eclipse.xtext.reference;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.XtextParser;

/**
 * Run this class in order to generate the Reference grammar.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese
 */
public class ReferenceGrammar {
	private static final String PATH = "./src-gen";
	
	public void generate() throws IOException {
		XtextStandaloneSetup.doSetup();
		
		GeneratorFacade.cleanFolder(PATH);

		String filename = this.getClass().getName().replace('.', '/') + ".xtext";

		System.out.println("loading " + filename);
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		
		XtextParser xtext2Parser= new XtextParser();
		Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream);
		
		GeneratorFacade.generate(grammarModel, this.getClass().getSimpleName(),this.getClass().getPackage().getName().replace('.', '/'), PATH);
		System.out.println("Done.");
	}

	public static void main(String[] args) throws IOException {
		ReferenceGrammar generator = new ReferenceGrammar();
		generator.generate();
	}

}
