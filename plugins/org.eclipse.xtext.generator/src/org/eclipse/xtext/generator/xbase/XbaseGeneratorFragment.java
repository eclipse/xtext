/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.xbase;

import static java.util.Collections.*;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * Prepares a host language to embed Xbase. Use with {@link org.eclipse.xtext.generator.types.TypesGeneratorFragment}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class XbaseGeneratorFragment extends DefaultGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return emptySet();
		return new BindFactory()
				.addTypeToType("org.eclipse.xtext.xbase.interpreter.IEvaluationContext",
						"org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext")
				.addTypeToType("org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter",
						"org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter")
				.addTypeToType(IQualifiedNameConverter.class.getName(),
						"org.eclipse.xtext.xbase.XbaseQualifiedNameConverter")
				.addTypeToType("org.eclipse.xtext.xbase.typing.ITypeProvider",
						"org.eclipse.xtext.xbase.typing.XbaseTypeProvider")
				.addTypeToType(IValueConverterService.class.getName(),
						"org.eclipse.xtext.xbase.conversion.XbaseValueConverterService")
				.addConfiguredBinding(
						"LinkingIScopeProvider" ,
						"binder.bind(" + IScopeProvider.class.getName() + ".class).annotatedWith("
								+ LinkingScopeProviderBinding.class.getName()
								+ ".class).to(org.eclipse.xtext.xbase.linking.XbaseLinkingScopeProvider.class)")
				.addConfiguredBinding(
						IScopeProvider.class.getName() + "Delegate",
						"binder.bind("
								+ IScopeProvider.class.getName()
								+ ".class).annotatedWith(Names.named("
								+ AbstractDeclarativeScopeProvider.class.getName()
								+ ".NAMED_DELEGATE)).to(org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider.class)")
								
				// obsolete convenience bindings
				.addTypeToType("org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider",
						"org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider").getBindings();
	}

	protected boolean usesXbaseGrammar(Grammar grammar) {
		if (grammar.getName().equals("org.eclipse.xtext.xbase.Xbase"))
			return true;
		EList<Grammar> usedGrammars = grammar.getUsedGrammars();
		for (Grammar grammar2 : usedGrammars) {
			if (usesXbaseGrammar(grammar2)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return emptySet();
		return new BindFactory().addTypeToType(
				"org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper",
				"org.eclipse.xtext.xbase.ui.syntaxcoloring.XbaseTokenToAttributeIdMapper").getBindings();
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase" };
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase.ui" };
	}

}
