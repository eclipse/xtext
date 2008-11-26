/*******************************************************************************
 * __  ___            _   
 * \ \/ / |_ _____  __ |_
 *  \  /| __/ _ \ \/ / __|
 *  /  \| |_  __/>  <| |_
 * /_/\_\\__\___/_/\_\\__|
 * 
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.GeneratorFacade;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testlanguages.ReferenceGrammar;
import org.eclipse.xtext.testlanguages.TreeTestLanguage;

/**
 * Generates all required testgrammars with UI configuration for this test project.
 * 
 * This code was copied from class <code>GenerateAllTestGrammars</code> within project
 * 'org.eclipse.xtext[.generator.]tests'. 
 * <p/>
 * The duplication of this class was required because tests in this project rely on an existing UIConfig in
 * addition to the standalone RuntimeConfig.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class GenerateAllTestGrammarsWithUiConfig {

	private static final String RUNTIME_PATH = "../org.eclipse.xtext.generator.tests";
	private static final String UI_PATH = ".";

	private static Logger logger = Logger.getLogger(GenerateAllTestGrammarsWithUiConfig.class);

	private final static Class<?>[] testClasses = new Class[] { ReferenceGrammar.class, TreeTestLanguage.class };
	/**
	 * @return the testclasses
	 */
	public static Class<?>[] getTestClasses() {
		return testClasses;
	}

	public static void main(String[] args) throws Exception {
		try {
			XtextStandaloneSetup.doSetup();
			GeneratorFacade.cleanFolder(UI_PATH + "/src-gen");
			for (Class<?> clazz : testClasses) {
				String filename = "classpath:/" + clazz.getName().replace('.', '/')
						+ ".xtext";
				logger.info("loading " + filename);
				ResourceSetImpl rs = new XtextResourceSet();
				URI uri = URI.createURI(filename);
				Resource resource = rs.createResource(uri);
				resource.load(null);
				Grammar grammarModel = (Grammar) resource.getContents()
						.iterator().next();
				GeneratorFacade.generate(grammarModel, RUNTIME_PATH, UI_PATH, clazz
						.getSimpleName().toLowerCase());
			}
		} catch (Exception e) {
			logger.error("Error while generating test grammars",e);
		}
	}

}
