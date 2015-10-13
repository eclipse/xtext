/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

import com.google.inject.Inject
import org.eclipse.xtext.Grammar

class AntlrDebugGrammarGenerator extends AbstractAntlrGrammarGenerator {

	@Inject DebugGrammarNaming naming

	override protected getGrammarNaming() {
		naming
	}

	override protected getInternalParserSuperClass() {
		null
	}

	override protected compileParserOptions(Grammar it, AntlrOptions options) {
		""
	}

	override protected compileParserHeader(Grammar it, AntlrOptions options) {
		""
	}

	override protected compileLexerHeader(Grammar it, AntlrOptions options) {
		""
	}

}