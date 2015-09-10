/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea;

import com.google.inject.Binder;
import com.google.inject.name.Names;
import com.intellij.facet.FacetTypeId;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import org.eclipse.xtend.core.idea.facet.XtendFacetConfiguration;
import org.eclipse.xtend.core.idea.facet.XtendFacetType;
import org.eclipse.xtend.core.idea.lang.XtendElementTypeProvider;
import org.eclipse.xtend.core.idea.lang.parser.XtendParserDefinition;
import org.eclipse.xtend.core.idea.lang.parser.XtendPsiParser;
import org.eclipse.xtend.core.idea.lang.parser.XtendTokenTypeProvider;
import org.eclipse.xtend.core.idea.lang.parser.antlr.XtendAntlrTokenFileProvider;
import org.eclipse.xtend.core.idea.parser.antlr.internal.PsiInternalXtendLexer;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.idea.DefaultIdeaModule;
import org.eclipse.xtext.idea.common.types.DerivedMemberAwarePsiModelAssociations;
import org.eclipse.xtext.idea.common.types.StubBasedTypeScopeProvider;
import org.eclipse.xtext.idea.facet.AbstractFacetConfiguration;
import org.eclipse.xtext.idea.findusages.IReferenceSearcher;
import org.eclipse.xtext.idea.findusages.JvmElementAwareReferenceSearcher;
import org.eclipse.xtext.idea.formatting.BlockFactory;
import org.eclipse.xtext.idea.formatting.ChildAttributesProvider;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.service.LanguageSpecific;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.xbase.idea.bracketmatching.XbaseBracePairProvider;
import org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory;
import org.eclipse.xtext.xbase.idea.formatting.XbaseChildAttributesProvider;
import org.eclipse.xtext.xbase.idea.highlighting.XbaseHighlightingConfiguration;
import org.eclipse.xtext.xbase.typesystem.internal.IFeatureScopeTracker;
import org.eclipse.xtext.xbase.typesystem.internal.OptimizingFeatureScopeTrackerProvider;

/**
 * Manual modifications go to {@link XtendIdeaModule}.
 */
@SuppressWarnings("all")
public abstract class AbstractXtendIdeaModule extends DefaultIdeaModule {
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return XtendAntlrTokenFileProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends Lexer> bindLexer() {
		return PsiInternalXtendLexer.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public void configureRuntimeLexer(Binder binder) {
		binder.bind(Lexer.class)
			.annotatedWith(Names.named(LexerBindings.RUNTIME))
			.to(PsiInternalXtendLexer.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends PsiParser> bindPsiParser() {
		return XtendPsiParser.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends TokenTypeProvider> bindTokenTypeProvider() {
		return XtendTokenTypeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends ParserDefinition> bindParserDefinition() {
		return XtendParserDefinition.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	@SingletonBinding
	public Class<? extends IElementTypeProvider> bindIElementTypeProvider() {
		return XtendElementTypeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends AbstractFacetConfiguration> bindAbstractFacetConfiguration() {
		return XtendFacetConfiguration.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public FacetTypeId bindFacetTypeIdToInstance() {
		return XtendFacetType.TYPEID;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return StubBasedTypeScopeProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends IFeatureScopeTracker.Provider> bindIFeatureScopeTracker$Provider() {
		return OptimizingFeatureScopeTrackerProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public void configureLanguageSpecificPsiModelAssociations(Binder binder) {
		binder.bind(IPsiModelAssociations.class)
			.annotatedWith(LanguageSpecific.class)
			.to(DerivedMemberAwarePsiModelAssociations.class);
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return XbaseHighlightingConfiguration.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends BlockFactory> bindBlockFactory() {
		return XbaseBlockFactory.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends ChildAttributesProvider> bindChildAttributesProvider() {
		return XbaseChildAttributesProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends IBracePairProvider> bindIBracePairProvider() {
		return XbaseBracePairProvider.class;
	}
	
	// contributed by org.eclipse.xtext.xtext.generator.idea.IdeaPluginGenerator
	public Class<? extends IReferenceSearcher> bindIReferenceSearcher() {
		return JvmElementAwareReferenceSearcher.class;
	}
	
}
