/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

/**
 * Generates all test and example languages.
 *
 * @author Jan Köhnlein - Initial contribution and API
 */
public class GenerateAllLanguages {
	public static void main(String[] args) {
		try {
			org.eclipse.xtext.GenerateAllTestGrammars.main("../org.eclipse.xtext.generator.tests/");
			org.eclipse.xtext.ui.common.GenerateAllTestGrammarsWithUiConfig.main("../org.eclipse.xtext.ui.common.tests/");
			org.eclipse.xtext.ui.core.GenerateAllTestGrammars.main("../org.eclipse.xtext.ui.core.tests");
			org.eclipse.emf.mwe.di.mwe.main("../org.eclipse.emf.mwe.di");
			org.eclipse.xtext.example.FowlerDsl.main("../org.eclipse.xtext.example.fowlerdsl");
			org.eclipse.xtext.reference.ReferenceGrammar.main("../org.eclipse.xtext.reference");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
