/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.tests;

import java.io.InputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextEPackageAccess;
import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.grammargen.tests.SimpleTest;
import org.eclipse.xtext.grammargen.tests.SimpleTest2;
import org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest;
import org.eclipse.xtext.parser.XtextFactory;
import org.eclipse.xtext.parser.XtextParser;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class GenerateAllTestGrammars {
	private static final String PATH = "./src-gen";

	private final static Class<?>[] testclasses = new Class[] { 
		SimpleTest.class, SimpleTest2.class, XtextGrammarTest.class,
		MetamodelRefTest.class};

	public static void main(String[] args) throws Exception {
		for (Class<?> c : testclasses) {
			String filename = c.getName().replace('.', '/') + ".xtext";
			System.out.println("loading " + filename);
			InputStream resourceAsStream = c.getClassLoader().getResourceAsStream(filename);
			
			//TODO make Xtext2Factory manual so one can overwrite 'getEPackages' in order to support generated epackages
			EPackage.Registry.INSTANCE.put(XtextEPackageAccess.XTEXT_NS_URI, XtextPackage.eINSTANCE);
			XtextParser xtext2Parser= new XtextParser();
			Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream, new XtextFactory());
			
			GeneratorFacade.generate(grammarModel,c.getSimpleName(),c.getPackage().getName().replace('.', '/'),PATH);
		}
	}
	
	

}
