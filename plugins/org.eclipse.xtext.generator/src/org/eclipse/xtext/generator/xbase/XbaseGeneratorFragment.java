/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.xbase;

import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * Prepares a host language to embed Xbase. Use with {@link org.eclipse.xtext.generator.types.TypesGeneratorFragment}.
 *
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 * @author Holger Schill
 */
public class XbaseGeneratorFragment extends AbstractGeneratorFragment {
	
	private boolean generateXtendInferrer = true;
	private boolean useInferredJvmModel = true;
	
	protected boolean usesXbaseGrammar(Grammar grammar) {
		return doesUseXbase(grammar);
	}
	
	public static boolean doesUseXbase(Grammar grammar) {
		if (grammar.getName().equals("org.eclipse.xtext.xbase.Xbase"))
			return true;
		EList<Grammar> usedGrammars = grammar.getUsedGrammars();
		for (Grammar grammar2 : usedGrammars) {
			if (doesUseXbase(grammar2)) {
				return true;
			}
		}
		return false;
	}
	
	public void setGenerateXtendInferrer(boolean generateXtendInferrer) {
		this.generateXtendInferrer = generateXtendInferrer;
	}
	
	public void setUseInferredJvmModel(boolean useInferredJvmModel) {
		this.useInferredJvmModel = useInferredJvmModel;
	}

	public static String getJvmModelInferrerName(Grammar grammar, Naming naming) {
		return naming.basePackageRuntime(grammar) + ".jvmmodel." + GrammarUtil.getName(grammar) + "JvmModelInferrer";
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return emptySet();
		BindFactory config = new BindFactory()
				.addTypeToType("org.eclipse.xtext.xbase.interpreter.IEvaluationContext",
						"org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext")
				.addTypeToType("org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter",
						"org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter")
				.addTypeToType(IQualifiedNameConverter.class.getName(),
						"org.eclipse.xtext.xbase.XbaseQualifiedNameConverter")
				.addTypeToType(IQualifiedNameProvider.class.getName(),
								"org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider")
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
				.addTypeToType(IScopeProvider.class.getCanonicalName(),
						"org.eclipse.xtext.xbase.scoping.XbaseScopeProvider")
				.addTypeToType(ILinker.class.getCanonicalName(),
						"org.eclipse.xtext.xbase.linking.XbaseLazyLinker")
				.addTypeToType("org.eclipse.xtext.common.types.util.TypeConformanceComputer",
								"org.eclipse.xtext.xbase.typing.XbaseTypeConformanceComputer")
				.addTypeToType(XtextResource.class.getName(),
						"org.eclipse.xtext.xbase.resource.XbaseResource")
				.addTypeToTypeEagerSingleton("org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator", 
						"org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator")
				// obsolete convenience bindings
				.addTypeToType("org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider",
						"org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider")
				.addTypeToType(IDerivedStateComputer.class.getCanonicalName(), "org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator")
				.addTypeToType(IResourceDescription.Manager.class.getCanonicalName(), DerivedStateAwareResourceDescriptionManager.class.getCanonicalName())
				.addTypeToType(IGenerator.class.getCanonicalName(), "org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
				.addTypeToInstance("org.eclipse.xtext.xtype.XtypeFactory", "org.eclipse.xtext.xtype.XtypeFactory.eINSTANCE")
				.addTypeToType(TypeArgumentContextProvider.class.getCanonicalName(), "org.eclipse.xtext.xbase.typing.XbaseTypeArgumentContextProvider");
		
			
		if (useInferredJvmModel) {
			config = config
				.addTypeToType(ILocationInFileProvider.class.getName(),
						"org.eclipse.xtext.xbase.jvmmodel.JvmLocationInFileProvider")
				.addTypeToType(EObjectAtOffsetHelper.class.getName(),
						"org.eclipse.xtext.xbase.jvmmodel.JvmEObjectAtOffsetHelper")
				.addTypeToType(IGlobalScopeProvider.class.getName(),
						"org.eclipse.xtext.xbase.jvmmodel.JvmGlobalScopeProvider");
			if(generateXtendInferrer) {
				config = config
					.addTypeToType("org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer",
						getJvmModelInferrerName(grammar, getNaming()));
			}
		}
		return config.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return emptySet();
		BindFactory bindFactory = new BindFactory()
				.addTypeToType("org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper",
						"org.eclipse.xtext.xbase.ui.syntaxcoloring.XbaseTokenToAttributeIdMapper")
				.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.ReferenceProposalCreator",
						"org.eclipse.xtext.xbase.ui.contentassist.XbaseReferenceProposalCreator")
				.addTypeToType("org.eclipse.jface.text.contentassist.IContentAssistProcessor", 
						"org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor")
				.addTypeToType("org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator", 
						"org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingCalculator")
				.addTypeToType("org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration", 
						"org.eclipse.xtext.xbase.ui.highlighting.XbaseHighlightingConfiguration")
				.addTypeToType("org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider", 
						"org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider");
		if (useInferredJvmModel) {
			// rename refactoring
			bindFactory = bindFactory
				.addTypeToType("org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceQueryDataFactory")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.impl.RefactoringReferenceQueryDataFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelFindRefsQueryDataFactory")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IReferenceUpdater",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelReferenceUpdater")
				.addfinalTypeToType("org.eclipse.xtext.ui.refactoring.ui.IRenameElementHandler",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelRenameElementHandler")
				.addTypeToType("org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant.ContextFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext.ContextFactory")
			    .addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy", 
			    		"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy");

		}
		return bindFactory.getBindings();
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase", "org.eclipse.xtext.xtend2.lib" };
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase.ui" };
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (usesXbaseGrammar(grammar))
			super.generate(grammar, ctx);
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Lists.<Object>newArrayList(useInferredJvmModel, generateXtendInferrer);
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		if(usesXbaseGrammar(grammar) && (generateXtendInferrer || useInferredJvmModel)) {
			return new String[] { Strings.skipLastToken(getJvmModelInferrerName(grammar, getNaming()), ".") };
		}
		return null;
	}

}
