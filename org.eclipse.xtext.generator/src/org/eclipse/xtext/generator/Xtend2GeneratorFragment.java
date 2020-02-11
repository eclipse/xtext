/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.List;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.0
 */
@Deprecated
public class Xtend2GeneratorFragment extends DefaultGeneratorFragment implements NamingAware {

	/**
	 * @since 2.3
	 */
	public static class GenericGrammarAccess extends AbstractGrammarElementFinder {

		public GenericGrammarAccess(Grammar grammar) {
			super();
			this.grammar = grammar;
		}

		private Grammar grammar;

		@Override
		public Grammar getGrammar() {
			return grammar;
		}
	}

	private Naming naming;

	protected Module createModule(final Grammar grammar) {
		return new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(Grammar.class).toInstance(grammar);
				binder.bind(Naming.class).toInstance(naming);
				binder.bind(IGrammarAccess.class).toInstance(new GenericGrammarAccess(grammar));
				addLocalBindings(binder);
			}
		};
	}
	
	/**
	 * @since 2.4
	 */
	protected void addLocalBindings(Binder binder) {
	}

	@Override
	final public void generate(Grammar grammar, XpandExecutionContext ctx) {
		Guice.createInjector(createModule(grammar)).injectMembers(this);
		generate(grammar, new Xtend2ExecutionContext(ctx));
	}

	/**
	 * @since 2.1
	 */
	public void generate(Grammar grammar, Xtend2ExecutionContext ctx) {
		generate(ctx);
	}

	public void generate(Xtend2ExecutionContext ctx) {
	}

	@Override
	public void registerNaming(Naming n) {
		naming = n;
	}

	/**
	 * @since 2.1
	 */
	public Naming getNaming() {
		return naming;
	}

	/**
	 * @since 2.0
	 */
	protected List<String> getExportedPackagesRtList(Grammar grammar) {
		return null; // workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=345955
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		List<String> list = getExportedPackagesRtList(grammar);
		return list == null ? null : list.toArray(new String[list.size()]);
	}

	/**
	 * @since 2.4
	 */
	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlRt(new Xtend2ExecutionContext(ctx));
	}

	/**
	 * @since 2.4
	 */
	public void addToPluginXmlRt(Xtend2ExecutionContext xtend2ExecutionContext) {
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		addToPluginXmlUi(new Xtend2ExecutionContext(ctx));
	}

	/**
	 * @since 2.4
	 */
	public void addToPluginXmlUi(Xtend2ExecutionContext xtend2ExecutionContext) {
	}
}
