/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.dummy.DummyLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTest;
import org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTest;
import org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTest;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testlanguages.ActionTestLanguage;
import org.eclipse.xtext.testlanguages.LexerLanguage;
import org.eclipse.xtext.testlanguages.LookaheadLanguage;
import org.eclipse.xtext.testlanguages.OptionalEmptyLanguage;
import org.eclipse.xtext.testlanguages.ReferenceGrammar;
import org.eclipse.xtext.testlanguages.SimpleExpressions;
import org.eclipse.xtext.testlanguages.TestLanguage;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenerateAllTestGrammars {
	private static String path = "./src-gen";
	private static Log log = LogFactory.getLog(GenerateAllTestGrammars.class);

	public final static Class<?>[] testclasses = new Class[] { XtextGrammarTest.class, MetamodelRefTest.class,
			DummyLanguage.class, TestLanguage.class, SimpleReconstrTest.class, ComplexReconstrTest.class,
			LexerLanguage.class, SimpleExpressions.class, ActionTestLanguage.class, OptionalEmptyLanguage.class,
			ReferenceGrammar.class, LookaheadLanguage.class };// MultiGenMMTest.
																// class

	public static void main(String[] args) throws Exception {
		XtextStandaloneSetup.doSetup();
		if (args.length > 0) {
			path = args[0] + "/" + path;
		}
		GeneratorFacade.cleanFolder(path);
		for (Class<?> c : testclasses) {
			String filename = "classpath:/" + c.getName().replace('.', '/') + ".xtext";
			log.info("loading " + filename);
			ResourceSetImpl rs = new XtextResourceSet();
			URI uri = URI.createURI(filename);
			Resource resource = rs.createResource(uri);
			resource.load(null);
			Grammar grammarModel = (Grammar) resource.getContents().iterator().next();
			GeneratorFacade.generate(grammarModel, path, null, c.getSimpleName().toLowerCase());
		}
	}

}
