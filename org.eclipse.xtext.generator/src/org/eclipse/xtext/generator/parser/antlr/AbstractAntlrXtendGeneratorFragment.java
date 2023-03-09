/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.parser.antlr;

import java.util.List;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;
import org.eclipse.xtext.generator.Xtend2GeneratorFragment;

import com.google.inject.Binder;
import com.google.inject.Guice;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.8
 */
@Deprecated(forRemoval = true)
public abstract class AbstractAntlrXtendGeneratorFragment extends AbstractAntlrGeneratorFragment {
	protected com.google.inject.Module createModule(Grammar grammar) {
		return new com.google.inject.Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(Grammar.class).toInstance(grammar);
				binder.bind(Naming.class).toInstance(getNaming());
				binder.bind(IGrammarAccess.class).toInstance(new Xtend2GeneratorFragment.GenericGrammarAccess(grammar));
				addLocalBindings(binder);
			}
		};
	}

	protected void addLocalBindings(Binder binder) {
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		checkGrammar(grammar);
		Guice.createInjector(createModule(grammar)).injectMembers(this);
		generate(grammar, getParameters(grammar), new Xtend2ExecutionContext(ctx));
	}

	protected abstract void generate(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx);

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlRt(grammar, getParameters(grammar), new Xtend2ExecutionContext(ctx));
	}

	protected abstract void addToPluginXmlRt(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx);

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlUi(grammar, getParameters(grammar), new Xtend2ExecutionContext(ctx));
	}

	protected abstract void addToPluginXmlUi(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx);

	@Override
	public void addToPluginXmlTests(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlTests(grammar, getParameters(grammar), new Xtend2ExecutionContext(ctx));
	}

	protected abstract void addToPluginXmlTests(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx);

	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		addToStandaloneSetup(grammar, getParameters(grammar), new Xtend2ExecutionContext(ctx));
	}

	protected abstract void addToStandaloneSetup(Grammar grammar, List<Object> parameters, Xtend2ExecutionContext ctx);
}
