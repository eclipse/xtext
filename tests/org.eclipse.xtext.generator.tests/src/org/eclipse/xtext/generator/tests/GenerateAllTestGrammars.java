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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextConstants;
import org.eclipse.xtext.XtextGrammarTest;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.dummy.DummyLanguage;
import org.eclipse.xtext.grammargen.tests.SimpleTest;
import org.eclipse.xtext.grammargen.tests.SimpleTest2;
import org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest;
import org.eclipse.xtext.parser.XtextASTFactory;
import org.eclipse.xtext.parser.XtextParser;
import org.eclipse.xtext.test.TestLanguage;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class GenerateAllTestGrammars {
	private static final String PATH = "./src-gen";
	private static Log log = LogFactory.getLog(GenerateAllTestGrammars.class);

	private final static Class<?>[] testclasses = new Class[] { 
		SimpleTest.class, SimpleTest2.class, XtextGrammarTest.class,
		MetamodelRefTest.class, DummyLanguage.class, TestLanguage.class};

	public static void main(String[] args) throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());
		
		GeneratorFacade.cleanFolder(PATH);
		for (Class<?> c : testclasses) {
			String filename = c.getName().replace('.', '/') + ".xtext";
			log.info("loading " + filename);
			InputStream resourceAsStream = c.getClassLoader().getResourceAsStream(filename);
			
			//TODO make Xtext2Factory manual so one can overwrite 'getEPackages' in order to support generated epackages
			EPackage.Registry.INSTANCE.put(XtextConstants.XTEXT_NS_URI, XtextPackage.eINSTANCE);
			XtextParser xtext2Parser= new XtextParser();
			Grammar grammarModel = (Grammar) xtext2Parser.parse(resourceAsStream, new XtextASTFactory());
			
			GeneratorFacade.generate(grammarModel,c.getSimpleName(),c.getPackage().getName().replace('.', '/'),PATH);
		}
	}
	
	

}
