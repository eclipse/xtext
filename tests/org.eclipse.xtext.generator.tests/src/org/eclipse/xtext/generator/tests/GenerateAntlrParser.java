/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.tests;

import org.antlr.Tool;

public class GenerateAntlrParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tool antlr = new Tool(new String[] { "./src-gen/org/eclipse/xtext/parser/internal/InternalXtextGrammarTest.g"});
		antlr.process();

	}

}
