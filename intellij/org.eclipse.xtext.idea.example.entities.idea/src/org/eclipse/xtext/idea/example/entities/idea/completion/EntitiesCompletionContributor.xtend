package org.eclipse.xtext.idea.example.entities.idea.completion

import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionSorter
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementWeigher
import com.intellij.openapi.application.ApplicationManager
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.TextRegion
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext

class EntitiesCompletionContributor extends CompletionContributor {
	@Inject Provider<ContentAssistContextFactory> delegates
	ExecutorService pool = Executors.newFixedThreadPool(3)

	new() {
		EntitiesLanguage.INSTANCE.injectMembers(this)
	}

	@Override override void fillCompletionVariants(CompletionParameters parameters, CompletionResultSet result) {
		val sortedResult = getSortedResult(parameters, result)
		sortedResult.runRemainingContributors(parameters)[sortedResult.addElement(lookupElement)]

		val text = parameters.readOnly[originalFile.text]
		var region = parameters.readOnly [
			if (originalPosition == null) {
				new TextRegion(position.textRange.startOffset, 0)
			} else {
				val textRange = originalPosition.textRange
				new TextRegion(textRange.startOffset, textRange.length)
			}
		]
		val resource = parameters.readOnly[(originalFile as BaseXtextFile).resource as XtextResource]

		val delegate = delegates.get => [it.pool = pool]
		val contexts = delegate.create(text, region, parameters.offset, resource)
		contexts.forEach[c|c.firstSetGrammarElements.forEach[e|createProposal(e, c, sortedResult)]]
	}

	def private getSortedResult(CompletionParameters parameters, CompletionResultSet result) {
		val xtextSorter = CompletionSorter.defaultSorter(parameters, result.prefixMatcher).weighBefore("liftShorter",
			new LookupElementWeigher("xtext") {
				@Override override Comparable<?> weigh(LookupElement element) {
					if (element instanceof KeywordLookupElement) {
						return 1
					} else {
						return -1
					}
				}
			})
		result.withRelevanceSorter(xtextSorter)
	}

	def private <T> readOnly(CompletionParameters parameters, (CompletionParameters)=>T reader) {
		ApplicationManager.application.<T>runReadAction[reader.apply(parameters)]
	}

	def private dispatch createProposal(AbstractElement grammarElement, ContentAssistContext context,
		CompletionResultSet result) {
	}

	def private dispatch createProposal(Keyword keyword, ContentAssistContext context, CompletionResultSet result) {
		result.addElement(new KeywordLookupElement(keyword))
	}

	@Data
	static class KeywordLookupElement extends LookupElement {
		Keyword keyword

		@Override override getLookupString() {
			keyword.value
		}
	}
}
