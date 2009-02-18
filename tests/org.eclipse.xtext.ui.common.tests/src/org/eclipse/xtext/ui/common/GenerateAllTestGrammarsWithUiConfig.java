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

import org.eclipse.xtext.AbstractTestGrammarGenerator;
import org.eclipse.xtext.XtextGrammarTestLanguage;
import org.eclipse.xtext.grammarinheritance.AbstractTestLanguage;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguage;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguage;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage;
import org.eclipse.xtext.testlanguages.TreeTestLanguage;

/**
 * Generates all required test grammars with UI configuration for this test project.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class GenerateAllTestGrammarsWithUiConfig extends AbstractTestGrammarGenerator {

	public GenerateAllTestGrammarsWithUiConfig(String[] args) {
		super(args);
	}

	public static void main(String... args) {
		new GenerateAllTestGrammarsWithUiConfig(args).generateAll();
	}
	
	@Override
	public Class<?>[] getTestGrammarClasses() {
		return new Class[] { 
				AbstractTestLanguage.class,
				ReferenceGrammarTestLanguage.class, 
				TreeTestLanguage.class,
				XtextGrammarTestLanguage.class, 
				ContentAssistTestLanguage.class,
				KeywordsTestLanguage.class 
			};
	}
	
	
	@Override
	protected String getUiProject() {
		return getRuntimeProject();
	}

	@Override
	protected String getWorkflow() {
		return "org/eclipse/xtext/ui/common/testLanguage.mwe";
	}

}
