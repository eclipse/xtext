/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.xbase;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Sets.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.debug.IStratumBreakpointSupport;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.LineSeparatorHarmonizer;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xtext.UsedRulesFinder;

import com.google.common.base.Predicate;
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
	private boolean jdtTypeHierarchy = true;
	private boolean jdtCallHierarchy = true;
	private boolean skipExportedPackage = false;
	
	protected boolean usesXbaseGrammar(Grammar grammar) {
		return doesUseXbase(grammar);
	}
	
	public void setSkipExportedPackage(boolean skipExportedPackage) {
		this.skipExportedPackage = skipExportedPackage;
	}
	
	public static boolean doesUseXbase(Grammar grammar) {
		return uses(grammar, "org.eclipse.xtext.xbase.Xbase");
	}
	
	public static boolean doesUseXbaseWithAnnotations(Grammar grammar) {
		return uses(grammar, "org.eclipse.xtext.xbase.annotations.XbaseWithAnnotations");
	}
	
	private static boolean uses(Grammar grammar, String languageID) {
		if (grammar.getName().equals(languageID))
			return true;
		EList<Grammar> usedGrammars = grammar.getUsedGrammars();
		for (Grammar grammar2 : usedGrammars) {
			if (doesUseXbase(grammar2)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @since 2.4
	 */
	public boolean usesXImportSection(Grammar grammar) {
		Set<AbstractRule> usedRules = newHashSet();
		new UsedRulesFinder(usedRules).compute(grammar);
		return any(usedRules, new Predicate<AbstractRule>() {
			public boolean apply(AbstractRule rule) {
				return equal(rule.getName(), "XImportSection") 
						&& equal(GrammarUtil.getGrammar(rule).getName(), "org.eclipse.xtext.xbase.Xtype");
			}
		});
	}
	
	public void setGenerateXtendInferrer(boolean generateXtendInferrer) {
		this.generateXtendInferrer = generateXtendInferrer;
	}
	
	public void setUseInferredJvmModel(boolean useInferredJvmModel) {
		this.useInferredJvmModel = useInferredJvmModel;
	}
	
	public void setJdtTypeHierarchy(boolean jdtTypeHierarchy){
		this.jdtTypeHierarchy = jdtTypeHierarchy;
	}
	
	public void setJdtCallHierachy(boolean jdtCallHierachy){
		this.jdtCallHierarchy = jdtCallHierachy;
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
				.addTypeToType(IValueConverterService.class.getName(),
						"org.eclipse.xtext.xbase.conversion.XbaseValueConverterService")
				.addTypeToType(IScopeProvider.class.getCanonicalName(),
					"org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider")
				.addConfiguredBinding(
						"LinkingIScopeProvider",
						"binder.bind(" + IScopeProvider.class.getName() + ".class).annotatedWith("
								+ LinkingScopeProviderBinding.class.getName()
								+ ".class).to(org.eclipse.xtext.xbase.scoping.batch.IBatchScopeProvider.class)")
				.addConfiguredBinding(
						"SerializerIScopeProvider",
						"binder.bind(" + IScopeProvider.class.getName() + ".class).annotatedWith("
								+ SerializerScopeProviderBinding.class.getName()
								+ ".class).to(org.eclipse.xtext.xbase.serializer.SerializerScopeProvider.class)")
				.addConfiguredBinding(
						IScopeProvider.class.getName() + "Delegate",
						"binder.bind("
								+ IScopeProvider.class.getName()
								+ ".class).annotatedWith(Names.named("
								+ AbstractDeclarativeScopeProvider.class.getName()
								+ ".NAMED_DELEGATE)).to("+ getImportScopeProvider(grammar)+")")
				.addTypeToType(ILinker.class.getCanonicalName(),
						"org.eclipse.xtext.xbase.linking.XbaseLazyLinker")
				.addTypeToType(XtextResource.class.getName(),
						"org.eclipse.xtext.xbase.resource.BatchLinkableResource")
				.addTypeToTypeEagerSingleton("org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator", 
						"org.eclipse.xtext.xbase.validation.JvmTypeReferencesValidator")
				// obsolete convenience bindings
				.addTypeToType("org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider",
					   "org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider")
				.addTypeToType(IDerivedStateComputer.class.getCanonicalName(), "org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator")
				.addTypeToType(IResourceDescription.Manager.class.getCanonicalName(), DerivedStateAwareResourceDescriptionManager.class.getCanonicalName())
				.addTypeToType(IGenerator.class.getCanonicalName(), "org.eclipse.xtext.xbase.compiler.JvmModelGenerator")
				.addTypeToInstance("org.eclipse.xtext.xtype.XtypeFactory", "org.eclipse.xtext.xtype.XtypeFactory.eINSTANCE")
				.addTypeToType(IStratumBreakpointSupport.class.getName(), "org.eclipse.xtext.xbase.debug.XbaseStratumBreakpointSupport")
				.addTypeToType(LineSeparatorHarmonizer.class.getCanonicalName(), "org.eclipse.xtext.xbase.compiler.output.TraceAwarePostProcessor")
				.addTypeToType(IDefaultResourceDescriptionStrategy.class.getCanonicalName(), "org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy")
				.addTypeToType(SeverityConverter.class.getCanonicalName(), "org.eclipse.xtext.xbase.validation.XbaseSeverityConverter")
				.addTypeToType(ConfigurableIssueCodesProvider.class.getCanonicalName(),"org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes")
				.addTypeToType(EObjectAtOffsetHelper.class.getCanonicalName(), "org.eclipse.xtext.xbase.linking.BrokenConstructorCallAwareEObjectAtOffsetHelper")
				.addTypeToType(CancelableDiagnostician.class.getCanonicalName(), "org.eclipse.xtext.xbase.validation.XbaseDiagnostician")
				.addTypeToType("org.eclipse.xtext.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider.ExtensionClassNameProvider",
						"org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypesAdapter")
				;
		if (doesUseXbaseWithAnnotations(grammar)) {
			config = config
					.addTypeToType("org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer",
							"org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer")
					.addTypeToType("org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider",
							"org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider")
					.addTypeToType(ILinkingDiagnosticMessageProvider.class.getCanonicalName(),
							"org.eclipse.xtext.xbase.annotations.validation.UnresolvedAnnotationTypeAwareMessageProducer");
			
		}
		if (useInferredJvmModel) {
			config = config
					.addTypeToType(ILocationInFileProvider.class.getName(),
							"org.eclipse.xtext.xbase.jvmmodel.JvmLocationInFileProvider")
					.addTypeToType(IGlobalScopeProvider.class.getName(),
							"org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider")
					.addTypeToType("org.eclipse.xtext.xbase.validation.FeatureNameValidator",
							"org.eclipse.xtext.xbase.validation.LogicalContainerAwareFeatureNameValidator")
					.addTypeToType("org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver",
							"org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver")
					.addTypeToType("org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver",
							"org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver")
					.addTypeToType(IResourceValidator.class.getCanonicalName(), 
							"org.eclipse.xtext.xbase.annotations.validation.DerivedStateAwareResourceValidator");
			if(generateXtendInferrer) {
				config = config
					.addTypeToType("org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer",
						getJvmModelInferrerName(grammar, getNaming()));
			}
		} else {
			config = config
					.addTypeToType(ILocationInFileProvider.class.getName(),
								"org.eclipse.xtext.xbase.resource.XbaseLocationInFileProvider");

		}
		return config.getBindings();
	}

	/**
	 * @since 2.4
	 */
	protected String getImportScopeProvider(Grammar grammar) {
		return (usesXImportSection(grammar))
			? "org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider.class"
			: "org.eclipse.xtext.xbase.scoping.XbaseImportedNamespaceScopeProvider.class"; 
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
						"org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider")
				.addTypeToType("org.eclipse.xtext.ui.editor.hover.IEObjectHover", 
						"org.eclipse.xtext.xbase.ui.hover.XbaseDispatchingEObjectTextHover")
				.addTypeToType("org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider", 
						"org.eclipse.xtext.xbase.ui.hover.XbaseHoverDocumentationProvider")
				.addTypeToType("org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider.CrossRefResolutionConverter",
						"org.eclipse.xtext.xbase.ui.quickfix.XbaseCrossRefResolutionConverter")
				.addTypeToTypeEagerSingleton("org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator",
						"org.eclipse.xtext.xbase.ui.validation.XbaseUIValidator")
				.addTypeToType("org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper",
					 	"org.eclipse.xtext.xbase.ui.navigation.TypeLiteralAwareHyperlinkHelper")
				.addTypeToType("org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker.Provider",
					 	"org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider");
		if (useInferredJvmModel) {
			// rename refactoring
			bindFactory = bindFactory
				.addTypeToType("org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler", 
							"org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceHandler")
				.addTypeToType("org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceQueryExecutor")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameRefactoringProvider")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IReferenceUpdater",
						"org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater")
				.addfinalTypeToType("org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContextFactory")
				.addTypeToType("org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant.ContextFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext.ContextFactory")
			    .addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy", 
			    		"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy")
				.addTypeToType("org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.outline.JvmOutlineNodeElementOpener")
			    .addTypeToType("org.eclipse.xtext.ui.editor.GlobalURIEditorOpener", 
						"org.eclipse.xtext.common.types.ui.navigation.GlobalDerivedMemberAwareURIEditorOpener")
			    .addTypeToType("org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.occurrence.JvmModelOccurrenceComputer")
				.addTypeToType("org.eclipse.xtext.common.types.ui.query.IJavaSearchParticipation", 
						"org.eclipse.xtext.common.types.ui.query.IJavaSearchParticipation.No")
				// DerivedMemberAwareEditorOpener
				.addConfiguredBinding("LanguageSpecificURIEditorOpener", "if (org.eclipse.ui.PlatformUI.isWorkbenchRunning()) { \n"+
						"\t\t\tbinder.bind(org.eclipse.xtext.ui.editor.IURIEditorOpener.class).annotatedWith(org.eclipse.xtext.ui.LanguageSpecific.class)" +
						".to(org.eclipse.xtext.xbase.ui.jvmmodel.navigation.DerivedMemberAwareEditorOpener.class); \n" +
						"\t\t\tbinder.bind(org.eclipse.xtext.common.types.ui.navigation.IDerivedMemberAwareEditorOpener.class).to(org.eclipse.xtext.xbase.ui.jvmmodel.navigation.DerivedMemberAwareEditorOpener.class); \n"+
						"\t\t}")
				.addTypeToType("org.eclipse.jface.text.hyperlink.IHyperlinkDetector",
							"org.eclipse.xtext.xbase.ui.navigation.XbaseHyperlinkDetector");

		} else {
			bindFactory =  bindFactory.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy", 
					"org.eclipse.xtext.xbase.ui.refactoring.XbaseRenameStrategy");
		}
		if(usesXImportSection(grammar)) {
			bindFactory
				.addTypeToType("org.eclipse.xtext.xbase.imports.IUnresolvedTypeResolver", 
						"org.eclipse.xtext.xbase.ui.imports.InteractiveUnresolvedTypeResolver")
				.addTypeToType("org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider", 
						"org.eclipse.xtext.xbase.ui.contentassist.ImportingTypesProposalProvider");
		} else {
			bindFactory
				.addTypeToType("org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixes", 
						"org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixesNoImportSection");
		}
		return bindFactory.getBindings();
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return new String[0];
		return new String[] { "org.eclipse.xtext.xbase", "org.eclipse.xtext.xbase.lib" };
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
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		if (usesXbaseGrammar(grammar))
			super.addToPluginXmlRt(grammar, ctx);
	}
	
	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		if (usesXbaseGrammar(grammar))
			super.addToPluginXmlUi(grammar, ctx);
	}
	
	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		if (usesXbaseGrammar(grammar))
			super.addToStandaloneSetup(grammar, ctx);
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Lists.<Object>newArrayList(useInferredJvmModel, generateXtendInferrer, jdtTypeHierarchy, jdtCallHierarchy, usesXImportSection(grammar));
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		if(usesXbaseGrammar(grammar) && (generateXtendInferrer || useInferredJvmModel) && !skipExportedPackage) {
			return new String[] { Strings.skipLastToken(getJvmModelInferrerName(grammar, getNaming()), ".") };
		}
		return null;
	}

}
