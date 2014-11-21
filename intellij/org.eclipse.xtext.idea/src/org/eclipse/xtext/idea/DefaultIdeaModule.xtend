package org.eclipse.xtext.idea

import com.google.inject.Binder
import com.google.inject.name.Names
import com.intellij.lexer.Lexer
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import org.eclipse.xtext.ide.LexerUIBindings
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper
import org.eclipse.xtext.idea.containers.ResolveScopeBasedContainerManger
import org.eclipse.xtext.idea.parser.AntlrDelegatingIdeaLexer
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions
import org.eclipse.xtext.idea.syntaxcoloring.DefaultSyntaxHighlighter
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
		binder.bind(ITokenDefProvider).annotatedWith(Names.named(LexerUIBindings.HIGHLIGHTING)).to(AntlrTokenDefProvider)
	}

}
