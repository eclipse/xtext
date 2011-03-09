/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.xbase;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * Prepares a host language to embed Xbase. Use with {@link org.eclipse.xtext.generator.types.TypesGeneratorFragment}.
 *
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
public class XbaseGeneratorFragment extends AbstractGeneratorFragment {
	
	private boolean generateInferrer = true;
	
	public void setGenerateInferrer(boolean generateInferrer) {
		this.generateInferrer = generateInferrer;
	}

	public static String getJvmModelInferrerName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".jvmmodel." + GrammarUtil.getName(grammar) + "JvmModelInferrer";
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (!XbaseUtil.usesXbaseGrammar(grammar))
			return emptySet();
		BindFactory config = new BindFactory()
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
						"LinkingIScopeProvider",
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
				.addTypeToType("org.eclipse.xtext.common.types.util.TypeConformanceComputer",
						"org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer")

				.addTypeToType(ILocationInFileProvider.class.getName(),
						"org.eclipse.xtext.xbase.jvmmodel.JvmLocationInFileProvider")
				.addTypeToType(EObjectAtOffsetHelper.class.getName(),
						"org.eclipse.xtext.xbase.jvmmodel.JvmEObjectAtOffsetHelper")
				.addTypeToType(ILinker.class.getName(), "org.eclipse.xtext.xbase.jvmmodel.JvmModelXbaseLazyLinker")
				.addTypeToType("org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations",
						"org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator")
				.addTypeToType("org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociator",
						"org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator")
				.addTypeToType(IGlobalScopeProvider.class.getName(),
						"org.eclipse.xtext.xbase.jvmmodel.JvmGlobalScopeProvider")
				// obsolete convenience bindings
				.addTypeToType("org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider",
						"org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider");
		if (generateInferrer) {
			config = config
			.addTypeToType("org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer",
							getJvmModelInferrerName(grammar, getNaming()));
		}
		return config.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (!XbaseUtil.usesXbaseGrammar(grammar))
			return emptySet();
		return new BindFactory()
				.addTypeToType("org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper",
						"org.eclipse.xtext.xbase.ui.syntaxcoloring.XbaseTokenToAttributeIdMapper")
				.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator",
						"org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator")
				.addTypeToType("org.eclipse.jface.text.contentassist.IContentAssistProcessor", 
						"org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor")
				.addTypeToType("org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceQueryDataFactory")
				.getBindings();
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		if (!XbaseUtil.usesXbaseGrammar(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase", "org.eclipse.xtext.xtend2.lib" };
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		if (!XbaseUtil.usesXbaseGrammar(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase.ui" };
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (XbaseUtil.usesXbaseGrammar(grammar))
			super.generate(grammar, ctx);
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return newArrayList((Object)generateInferrer);
	}

}
