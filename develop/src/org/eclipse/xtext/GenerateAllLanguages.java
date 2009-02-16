/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import org.apache.log4j.Logger;

/**
 * Generates all test and example languages.
 *
 * @author Jan Köhnlein - Initial contribution and API
 */
public class GenerateAllLanguages {

	private static Logger logger = Logger.getLogger(GenerateAllLanguages.class);

	public static void main(String[] args) {
		try {
			logger.info("Generating all test and example languages.");

			org.eclipse.xtext.GenerateAllTestGrammars.main("../org.eclipse.xtext.generator.tests/");
			org.eclipse.xtext.ui.common.GenerateAllTestGrammarsWithUiConfig.main("../org.eclipse.xtext.ui.common.tests/");
			org.eclipse.xtext.ui.integration.GenerateAllTestGrammars.main("../org.eclipse.xtext.ui.integration.tests");
			// MWE DI is currently not in our workspace 
			//org.eclipse.emf.mwe.di.mwe.main("../org.eclipse.emf.mwe.di");
			xtext.example.GenerateGrammar.main("../org.eclipse.xtext.example.domainmodel");
			org.eclipse.xtext.example.FowlerDsl.main("../org.eclipse.xtext.example.fowlerdsl");
			org.eclipse.xtext.reference.ReferenceGrammar.main("../org.eclipse.xtext.reference");
			org.eclipse.xtext.example.EcoreDsl.main("../org.eclipse.xtext.example.ecoredsl");
			org.eclipse.xtext.xtend.tests.GenerateAllTestGrammarsWithXtendServices.main("../org.eclipse.xtext.xtend.tests");

			logger.info("DONE.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
