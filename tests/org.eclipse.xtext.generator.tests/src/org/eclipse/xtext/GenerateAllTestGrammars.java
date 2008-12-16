/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.crossrefs.ImportUriTestLanguage;
import org.eclipse.xtext.crossrefs.LangATestLanguage;
import org.eclipse.xtext.dummy.DummyTestLanguage;
import org.eclipse.xtext.grammarinheritance.AbstractTestLanguage;
import org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguage;
import org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage;
import org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage;
import org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestLanguage;
import org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage;
import org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testlanguages.ActionTestLanguage;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguage;
import org.eclipse.xtext.testlanguages.FowlerDslTestLanguage;
import org.eclipse.xtext.testlanguages.LexerTestLanguage;
import org.eclipse.xtext.testlanguages.LookaheadTestLanguage;
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguage;
import org.eclipse.xtext.testlanguages.PartialParserTestLanguage;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage;
import org.eclipse.xtext.testlanguages.TestLanguage;
import org.eclipse.xtext.testlanguages.TreeTestLanguage;
import org.eclipse.xtext.valueconverter.Bug250313;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenerateAllTestGrammars {
	private static String path = ".";

	private static Logger log = Logger.getLogger(GenerateAllTestGrammars.class);

	public final static Class<?>[] testclasses = new Class[] { 
			LangATestLanguage.class,
			AbstractTestLanguage.class,
			ConcreteTestLanguage.class,
			XtextGrammarTestLanguage.class, 
			MetamodelRefTestLanguage.class,
			MultiGenMMTestLanguage.class,
			DummyTestLanguage.class,
			TestLanguage.class,
			SimpleReconstrTestLanguage.class, 
			ComplexReconstrTestLanguage.class, 
			LexerTestLanguage.class,
			SimpleExpressionsTestLanguage.class, 
			ActionTestLanguage.class, 
			OptionalEmptyTestLanguage.class, 
			ReferenceGrammarTestLanguage.class,
			LookaheadTestLanguage.class, 
			Bug250313.class, 
			FowlerDslTestLanguage.class, 
			TreeTestLanguage.class, 
			ImportUriTestLanguage.class,
			PartialParserTestLanguage.class, 
			ContentAssistTestLanguage.class, 
			TransientValuesTest.class,
			FormatterTestLanguage.class,
			DatatypeRulesTestLanguage.class
			};

	public static void main(String[] args) throws Exception {
		try {
			XtextStandaloneSetup.doSetup();
			if (args.length > 0) {
				path = args[0];
			}
			GeneratorFacade.cleanFolder(path + "/src-gen");
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
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
