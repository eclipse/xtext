package org.eclipse.xtext.reference;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextConstants;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.XtextASTFactory;
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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		GeneratorFacade.cleanFolder(PATH);

		String filename = this.getClass().getName().replace('.', '/') + ".xtext";

		System.out.println("loading " + filename);
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		
		//TODO make Xtext2Factory manual so one can overwrite 'getEPackages' in order to support generated epackages
		EPackage.Registry.INSTANCE.put(XtextConstants.XTEXT_NS_URI, XtextPackage.eINSTANCE);
		XtextParser xtext2Parser= new XtextParser();
		Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream, new XtextASTFactory());
		
		GeneratorFacade.generate(grammarModel, this.getClass().getSimpleName(),this.getClass().getPackage().getName().replace('.', '/'), PATH);
		System.out.println("Done.");
	}

	public static void main(String[] args) throws IOException {
		ReferenceGrammar generator = new ReferenceGrammar();
		generator.generate();
	}

}
