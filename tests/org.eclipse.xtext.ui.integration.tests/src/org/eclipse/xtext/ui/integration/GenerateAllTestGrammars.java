/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.integration;

import org.eclipse.xtext.AbstractTestGrammarGenerator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenerateAllTestGrammars extends AbstractTestGrammarGenerator {

	public GenerateAllTestGrammars(String[] args) {
		super(args);
	}

	public static void main(String... args) {
		new GenerateAllTestGrammars(args).generateAll();
	}
	
	@Override
	public Class<?>[] getTestGrammarClasses() {
		return new Class[] { TestLanguage.class };
	}

	@Override
	protected String getWorkflow() {
		return "org/eclipse/xtext/ui/integration/testLanguage.mwe";
	}

	@Override
	protected String getUiProject() {
		return getRuntimeProject();
	}
}
