/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea

import com.google.inject.Binder
import com.google.inject.name.Names
import com.intellij.lang.PairedBraceMatcher
import com.intellij.lang.refactoring.NamesValidator
import com.intellij.lexer.Lexer
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import org.eclipse.xtext.ide.LexerIdeBindings
import org.eclipse.xtext.ide.editor.bracketmatching.DefaultBracePairProvider
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.idea.containers.ResolveScopeBasedContainerManger
import org.eclipse.xtext.idea.highlighting.DefaultPairedBraceMatcher
import org.eclipse.xtext.idea.highlighting.DefaultSyntaxHighlighter
import org.eclipse.xtext.idea.parser.AntlrDelegatingIdeaLexer
import org.eclipse.xtext.idea.refactoring.NullNamesValidator
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.psi.PsiModelAssociations
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.service.AbstractGenericModule
import org.eclipse.xtext.service.SingletonBinding

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultIdeaModule extends AbstractGenericModule {

	def Class<? extends Lexer> bindLexer() {
		AntlrDelegatingIdeaLexer
	}

	def void configureIResourceDescriptions(Binder binder) {
		binder.bind(IResourceDescriptions).to(ProjectScopeBasedResourceDescriptions)
	}

	def Class<? extends IContainer.Manager> bindIContainer$Manager() {
		ResolveScopeBasedContainerManger
	}

	def Class<? extends IPsiModelAssociations> bindIPsiModelAssociations() {
		PsiModelAssociations
	}

	def Class<? extends IPsiModelAssociator> bindIPsiModelAssociator() {
		PsiModelAssociations
	}

	@SingletonBinding
	def Class<? extends ExportedObjectQualifiedNameIndex> bindExportedObjectQualifiedNameIndex() {
		ExportedObjectQualifiedNameIndex
	}

	@SingletonBinding
	def Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		DefaultAntlrTokenToAttributeIdMapper
	}
	
	@SingletonBinding
	def Class<? extends SyntaxHighlighter> bindSyntaxHighlighter() {
		DefaultSyntaxHighlighter
	}

	def void configureHighlightingTokenDefProvider(Binder binder) {
		binder.bind(ITokenDefProvider).annotatedWith(Names.named(LexerIdeBindings.HIGHLIGHTING)).to(AntlrTokenDefProvider)
	}
	
	@SingletonBinding
	def Class<? extends NamesValidator> bindNamesValidator() {
		NullNamesValidator
	}
	
	@SingletonBinding
	def Class<? extends PairedBraceMatcher> bindPairedBraceMatcher() {
		DefaultPairedBraceMatcher
	}
	
	@SingletonBinding
	def Class<? extends IBracePairProvider> bindIBracePairProvider() {
		DefaultBracePairProvider
	}

}
