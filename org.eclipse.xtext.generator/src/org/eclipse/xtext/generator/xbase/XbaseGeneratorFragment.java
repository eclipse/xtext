/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragmentExtension4;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.xtext.UsedRulesFinder;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

/**
 * Prepares a host language to embed Xbase. Use with {@link org.eclipse.xtext.generator.types.TypesGeneratorFragment}.
 *
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 * @author Holger Schill
 * @since 2.9
 */
@Deprecated
public class XbaseGeneratorFragment extends AbstractGeneratorFragment implements IGeneratorFragmentExtension4 {
	
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
			if (uses(grammar2, languageID)) {
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
			@Override
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
		return naming.basePackageRuntime(grammar) + ".jvmmodel." + GrammarUtil.getSimpleName(grammar) + "JvmModelInferrer";
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		if (!usesXbaseGrammar(grammar))
			return emptySet();
		BindFactory config = new BindFactory()
						
				// overrides binding from org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
				.addTypeToType(IQualifiedNameProvider.class.getName(),
								"org.eclipse.xtext.xbase.scoping.XbaseQualifiedNameProvider");
				
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
		if (usesXImportSection(grammar)) {
			config = config.addConfiguredBinding(
					IScopeProvider.class.getName() + "Delegate",
					"binder.bind("
							+ IScopeProvider.class.getName()
							+ ".class).annotatedWith(com.google.inject.name.Names.named("
							+ AbstractDeclarativeScopeProvider.class.getName()
							+ ".NAMED_DELEGATE)).to("+ getImportScopeProvider(grammar)+")");
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
		BindFactory bindFactory = new BindFactory();
		if (useInferredJvmModel) {
			// rename refactoring
			bindFactory = bindFactory
				.addTypeToType("org.eclipse.xtext.ui.editor.findrefs.FindReferencesHandler", 
							"org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelFindReferenceHandler")
				.addTypeToType("org.eclipse.xtext.ui.editor.findrefs.ReferenceQueryExecutor", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.findrefs.JvmModelReferenceQueryExecutor")
						
				// overrides binding from org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator")
				// overrides binding from RefactorElementNameFragment
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameRefactoringProvider")
				// overrides binding from RefactorElementNameFragment
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IReferenceUpdater",
						"org.eclipse.xtext.xbase.ui.refactoring.XbaseReferenceUpdater")
				// overrides binding from RefactorElementNameFragment
				.addfinalTypeToType("org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.jdt.CombinedJvmJdtRenameContextFactory")
				// overrides binding from RefactorElementNameFragment
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy", 
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.DefaultJvmModelRenameStrategy")
				
				.addTypeToType("org.eclipse.xtext.common.types.ui.refactoring.participant.JdtRenameParticipant.ContextFactory",
						"org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext.ContextFactory")
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
						"\t\t}");
		} else {
			bindFactory =  bindFactory.addTypeToType("org.eclipse.xtext.ui.refactoring.IRenameStrategy", 
					"org.eclipse.xtext.xbase.ui.refactoring.XbaseRenameStrategy");
		}
		if (usesXImportSection(grammar)) {
			bindFactory
					.addTypeToType("org.eclipse.xtext.xbase.imports.IUnresolvedTypeResolver",
							"org.eclipse.xtext.xbase.ui.imports.InteractiveUnresolvedTypeResolver")
					.addTypeToType("org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider",
							"org.eclipse.xtext.xbase.ui.contentassist.ImportingTypesProposalProvider")
					.addTypeToType(" org.eclipse.xtext.ui.editor.templates.XtextTemplateContextType",
							"org.eclipse.xtext.xbase.ui.templates.XbaseTemplateContextType");
		} else {
			bindFactory.addTypeToType("org.eclipse.xtext.xbase.ui.quickfix.JavaTypeQuickfixes",
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
		return new String[] { "org.eclipse.xtext.xbase.ui", "org.eclipse.jdt.debug.ui"};
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

	@Override
	public String getDefaultRuntimeModuleClassName(Grammar grammar) {
		if (doesUseXbaseWithAnnotations(grammar)) {
			return "org.eclipse.xtext.xbase.annotations.DefaultXbaseWithAnnotationsRuntimeModule";
		} else if (doesUseXbase(grammar)) {
			return "org.eclipse.xtext.xbase.DefaultXbaseRuntimeModule";
		} else {
			return null;
		}
	}

	@Override
	public String getDefaultUiModuleClassName(Grammar grammar) {
		if (doesUseXbaseWithAnnotations(grammar)) {
			return "org.eclipse.xtext.xbase.annotations.ui.DefaultXbaseWithAnnotationsUiModule";
		} else if (doesUseXbase(grammar)) {
			return "org.eclipse.xtext.xbase.ui.DefaultXbaseUiModule";
		} else {
			return null;
		}
	}

}
