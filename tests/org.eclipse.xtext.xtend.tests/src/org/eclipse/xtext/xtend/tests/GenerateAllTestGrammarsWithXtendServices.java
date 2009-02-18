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
package org.eclipse.xtext.xtend.tests;

import org.eclipse.xtext.AbstractTestGrammarGenerator;
import org.eclipse.xtext.GenerateAllTestGrammars;
import org.eclipse.xtext.XtextGrammarTestLanguage;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguage;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguage;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage;
import org.eclipse.xtext.testlanguages.TreeTestLanguage;

/**
 * Generates all required testgrammars with xtend services for this test
 * project.
 * 
 * This code was copied from class
 * <code>org.eclipse.xtext.ui.common.GenerateAllTestGrammarsWithUiConfig</code>
 * within project 'org.eclipse.xtext.ui.common.tests'. <p/>
 * 
 * The duplication of this class was required because we need a language setup
 * with xtend services. services.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Jan Koehnlein
 */
public class GenerateAllTestGrammarsWithXtendServices extends AbstractTestGrammarGenerator {
	
	public GenerateAllTestGrammarsWithXtendServices(String[] args) {
		super(args);
	}

	public static void main(String... args) throws Exception {
		new GenerateAllTestGrammarsWithXtendServices(args).generateAll();
	}
	
	@Override
	protected String getUiProject() {
		return getRuntimeProject();
	}
	
	@Override
	public Class<?>[] getTestGrammarClasses() {
		return new Class[] { ReferenceGrammarTestLanguage.class,
				TreeTestLanguage.class, XtextGrammarTestLanguage.class, ContentAssistTestLanguage.class,
				KeywordsTestLanguage.class };
	}

	@Override
	protected String getWorkflow() {
		return "org/eclipse/xtext/xtend/tests/testLanguage.mwe";
	}

}
