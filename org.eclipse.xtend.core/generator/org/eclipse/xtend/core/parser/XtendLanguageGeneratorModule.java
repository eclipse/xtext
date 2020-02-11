/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.parser;

import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrContentAssistGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenerator;

import com.google.inject.AbstractModule;

public class XtendLanguageGeneratorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(AntlrGrammarGenerator.class).to(XtendAntlrGrammarGenerator.class);
		bind(AntlrContentAssistGrammarGenerator.class).to(XtendContentAssistAntlrGrammarGenerator.class);
	}
}
