/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr

import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Module
import java.util.List
import org.eclipse.xpand2.XpandExecutionContext
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.Xtend2ExecutionContext
import org.eclipse.xtext.generator.Xtend2GeneratorFragment

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@Deprecated
abstract class AbstractAntlrXtendGeneratorFragment extends AbstractAntlrGeneratorFragment {

	protected def Module createModule(Grammar grammar) {
		[ binder |
			binder.bind(Grammar).toInstance(grammar);
			binder.bind(Naming).toInstance(naming);
			binder.bind(IGrammarAccess).toInstance(new Xtend2GeneratorFragment.GenericGrammarAccess(grammar));
			addLocalBindings(binder);
		]
	}

	protected def void addLocalBindings (Binder binder) {
	}
	
	override generate(Grammar grammar, XpandExecutionContext ctx) {
		checkGrammar(grammar)
		Guice.createInjector(createModule(grammar)).injectMembers(this)
		generate(grammar, grammar.parameters, new Xtend2ExecutionContext(ctx))
	}
	
	abstract protected def void generate(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx)
	
	override addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlRt(grammar, grammar.parameters, new Xtend2ExecutionContext(ctx))
	}
	
	abstract protected def void addToPluginXmlRt(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx)
	
	override addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlUi(grammar, grammar.parameters, new Xtend2ExecutionContext(ctx))
	}
	
	abstract protected def void addToPluginXmlUi(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx)
	
	override addToPluginXmlTests(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlTests(grammar, grammar.parameters, new Xtend2ExecutionContext(ctx))
	}
	
	abstract protected def void addToPluginXmlTests(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx)
	
	override addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		addToStandaloneSetup(grammar, grammar.parameters, new Xtend2ExecutionContext(ctx))
	}
	
	abstract protected def void addToStandaloneSetup(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx)

}
	