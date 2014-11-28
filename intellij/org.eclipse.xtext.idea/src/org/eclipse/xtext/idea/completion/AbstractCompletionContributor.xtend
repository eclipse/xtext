package org.eclipse.xtext.idea.completion

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.codeInsight.completion.CompletionContext
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionInitializationContext
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionSorter
import com.intellij.codeInsight.completion.LegacyCompletionContributor
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementWeigher
import com.intellij.openapi.application.ApplicationManager
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.TextRegion

abstract class AbstractCompletionContributor extends CompletionContributor {
	@Inject Provider<ContentAssistContextFactory> delegates
	ExecutorService pool = Executors.newFixedThreadPool(3)

	new(AbstractXtextLanguage lang) {
		lang.injectMembers(this)
	}

	override void fillCompletionVariants(CompletionParameters parameters, CompletionResultSet result) {
		val sortedResult = result.withRelevanceSorter(getCompletionSorter(parameters, result))
		createMatcherBasedProposals(parameters, sortedResult)
		createReferenceBasedProposals(parameters, sortedResult)
		createParserBasedProposals(parameters, sortedResult)
		result.stopHere
	}

	protected def getCompletionSorter(CompletionParameters parameters, CompletionResultSet result) {
		CompletionSorter.defaultSorter(parameters, result.prefixMatcher)
			.weighBefore("liftShorter", new DispreferKeywordsWeigher)
	}

	protected def createMatcherBasedProposals(CompletionParameters parameters, CompletionResultSet sortedResult) {
		super.fillCompletionVariants(parameters, sortedResult)
	}

	protected def createReferenceBasedProposals(CompletionParameters parameters, CompletionResultSet sortedResult) {
		LegacyCompletionContributor.completeReference(parameters, sortedResult)
	}

	protected def createParserBasedProposals(CompletionParameters parameters, CompletionResultSet result) {
		val contexts = newParserBasedFactory.create(parameters.text, parameters.selection, parameters.offset,parameters.resource)
		contexts.forEach[c|c.firstSetGrammarElements.forEach[e|createProposal(e, c, parameters, result)]]
	}

	protected def newParserBasedFactory() {
		delegates.get => [it.pool = pool]
	}

	protected def getText(CompletionParameters parameters) {
		parameters.readOnly[originalFile.text]
	}

	protected def getSelection(CompletionParameters parameters) {
		val offsets = parameters.offsets
		val startOffset = offsets.getOffset(CompletionInitializationContext.START_OFFSET)
		val endOffset = offsets.getOffset(CompletionInitializationContext.SELECTION_END_OFFSET)
		new TextRegion(startOffset, endOffset - startOffset)
	}

	protected def getOffsets(CompletionParameters parameters) {
		parameters.readOnly [
			(parameters.position.getUserData(CompletionContext.COMPLETION_CONTEXT_KEY) as CompletionContext).offsetMap
		]
	}

	protected def getResource(CompletionParameters parameters) {
		parameters.readOnly[(originalFile as BaseXtextFile).resource as XtextResource]
	}

	protected final def <T> readOnly(CompletionParameters parameters, (CompletionParameters)=>T reader) {
		ApplicationManager.application.<T>runReadAction[reader.apply(parameters)]
	}

	protected def createProposal(AbstractElement grammarElement, ContentAssistContext context, CompletionParameters parameters, CompletionResultSet result) {
		switch grammarElement {
			Keyword: createKeyWordProposal(grammarElement, context, parameters, result)
		}
	}

	protected def createKeyWordProposal(Keyword keyword, ContentAssistContext context, CompletionParameters parameters,	CompletionResultSet result) {
		result.addElement(new KeywordLookupElement(keyword))
	}

	@Data
	static class KeywordLookupElement extends LookupElement {
		Keyword keyword

		override getLookupString() {
			keyword.value
		}
	}

	static class DispreferKeywordsWeigher extends LookupElementWeigher {
		new() {
			super("dispreferKeywords")
		}

		override Boolean weigh(LookupElement element) {
			element instanceof KeywordLookupElement
		}
	}
}
