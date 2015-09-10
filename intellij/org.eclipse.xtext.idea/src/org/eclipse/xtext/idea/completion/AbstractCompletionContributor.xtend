/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.completion

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import com.google.inject.Provider
import com.intellij.codeInsight.completion.CompletionContext
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionInitializationContext
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResult
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionService
import com.intellij.codeInsight.completion.CompletionSorter
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.completion.LegacyCompletionContributor
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementWeigher
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.util.Computable
import com.intellij.openapi.util.TextRange
import com.intellij.psi.tree.TokenSet
import com.intellij.util.ProcessingContext
import java.util.Map
import java.util.Set
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElementComputer
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
import org.eclipse.xtext.idea.editorActions.TokenSetProvider
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.util.TextRegion

abstract class AbstractCompletionContributor extends CompletionContributor {

	@Inject(optional=true) Provider<ContentAssistContextFactory> delegates
	@Inject protected extension CompletionExtensions
	@Inject protected IGrammarAccess grammarAccess
	@Inject protected extension TokenSetProvider
	
	@Inject(optional=true) IContentAssistParser contentAssistParser
	@Inject(optional=true) FollowElementComputer followElementComputer
	
	ExecutorService pool = Executors.newFixedThreadPool(3)
	
	val Map<CompletionType, Multimap<TokenSet, CompletionProvider<CompletionParameters>>> myContributors = newHashMap
	
	val Map<CompletionType, Map<TokenSet, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>>> myFollowElementBasedContributors = newHashMap

	new(AbstractXtextLanguage lang) {
		lang.injectMembers(this)
	}
	
	protected def extend(CompletionType type, CompletionProvider<CompletionParameters> contrib) {
		extend(type, #[defaultTokens], contrib)
	}
	
	protected def extend(CompletionType type, TokenSet[] tokenSets, CompletionProvider<CompletionParameters> contrib) {
		if (!myContributors.containsKey(type)) {
			myContributors.put(type, ArrayListMultimap.create)
		}
		for (tokenSet : tokenSets) {
			myContributors.get(type).put(tokenSet, contrib)
		}
	}
	
	
	protected def extend(CompletionType type, EStructuralFeature feature, CompletionProvider<CompletionParameters> contrib) {
		extend(type, #[defaultTokens], feature, contrib)
	}
	
	protected def extend(CompletionType type, TokenSet[] tokenSets, EStructuralFeature feature, CompletionProvider<CompletionParameters> contrib) {
		if (followElementComputer === null)
			throw new IllegalStateException('followElementComputer is not injected, probably IDE project is missing')		
			
		followElementComputer.collectAbstractElements(grammarAccess.grammar, feature) [
			extend(type, tokenSets, it, contrib)
		]
	}
	
	protected def extend(CompletionType type, AbstractElement followElement, CompletionProvider<CompletionParameters> contrib) {
		extend(type, #[defaultTokens], followElement, contrib)
	}
	
	protected def extend(CompletionType type, TokenSet[] tokenSets, AbstractElement followElement, CompletionProvider<CompletionParameters> contrib) {
		if (!myFollowElementBasedContributors.containsKey(type)) {
			myFollowElementBasedContributors.put(type, newHashMap)
		}
		val map = myFollowElementBasedContributors.get(type)
		for (tokenSet : tokenSets) {
			if (!map.containsKey(tokenSet)) {
				map.put(tokenSet, ArrayListMultimap.create)
			}
			val providers = map.get(tokenSet)
			providers.put(followElement, contrib)
		}
	}

	override void fillCompletionVariants(CompletionParameters parameters, CompletionResultSet result) {
		val sortedResult = result.withRelevanceSorter(getCompletionSorter(parameters, result))
		val filteredConsumer = [ CompletionResult it |
			if (isValidProposal(lookupElement, parameters))
				sortedResult.addElement(lookupElement)
		]
		val filteredResult = CompletionService.completionService.createResultSet(parameters, filteredConsumer, this)
		createMatcherBasedProposals(parameters, filteredResult)
		createReferenceBasedProposals(parameters, filteredResult)
		createTokenSetBasedProposals(parameters, filteredResult)
		createFollowElementBasedProposals(parameters, filteredResult)
		createParserBasedProposals(parameters, filteredResult)
		result.stopHere
	}

	protected def void createTokenSetBasedProposals(CompletionParameters parameters, CompletionResultSet result) {
		if (myContributors.isEmpty || !myContributors.containsKey(parameters.completionType))
			return;
			
		val tokenSet = (parameters.editor as EditorEx).getTokenSet(parameters.offset)
		val providers = myContributors.get(parameters.getCompletionType()).get(tokenSet)
		if (providers == null)
			return;
			
		val calledProviders = newHashSet
		val context = new ProcessingContext
		for (provider : providers) {
			if (calledProviders.add(provider)) {
				provider.addCompletionVariants(parameters, context, result)
				if (result.isStopped()) {
					return;
				}
			}
		}
	}

	protected def void createFollowElementBasedProposals(CompletionParameters parameters, CompletionResultSet result) {
		if (myFollowElementBasedContributors.isEmpty || !myFollowElementBasedContributors.containsKey(parameters.completionType))
			return;
			
		val tokenSet = (parameters.editor as EditorEx).getTokenSet(parameters.offset)
		val element2provider = myFollowElementBasedContributors.get(parameters.getCompletionType()).get(tokenSet)
		if (element2provider == null)
			return;
		
		val followElements = computeFollowElements(parameters)
		val calledProviders = newHashSet
		for (followElement : element2provider.keySet) {
			val context = new ProcessingContext
			if (followElements.contains(followElement)) {
				val providers = element2provider.get(followElement)
				for (provider : providers) {
					if (calledProviders.add(provider)) {
						provider.addCompletionVariants(parameters, context, result)
						if (result.isStopped()) {
							return;
						}
					}
				}
			}
		}
	}
	
	protected def Set<AbstractElement> computeFollowElements(CompletionParameters parameters) {
		val text = parameters.editor.document.getText(new TextRange(0, parameters.position.node.startOffset))
		val followElements = contentAssistParser.getFollowElements(text, false)
		val allElements = newHashSet
		followElementComputer.computeFollowElements(followElements, allElements)
		return allElements
	}

	protected def getCompletionSorter(CompletionParameters parameters, CompletionResultSet result) {
		CompletionSorter.defaultSorter(parameters, result.prefixMatcher).weighBefore("liftShorter", new DispreferKeywordsWeigher)
	}

	protected def isValidProposal(LookupElement proposal, CompletionParameters parameters) {
		true
	}

	protected def createMatcherBasedProposals(CompletionParameters parameters, CompletionResultSet result) {
		super.fillCompletionVariants(parameters, result)
	}

	protected def createReferenceBasedProposals(CompletionParameters parameters, CompletionResultSet result) {
		LegacyCompletionContributor.completeReference(parameters, result)
	}

	protected def createParserBasedProposals(CompletionParameters parameters, CompletionResultSet result) {
		val tokenSet = (parameters.editor as EditorEx).getTokenSet(parameters.offset)
		if (!tokenSet.supportParserBasedProposals)
			return;

		val delegate = parserBasedDelegate
		if (delegate == null)
			return;
		val contexts = delegate.create(parameters.text, parameters.selection, parameters.offset, parameters.resource)
		contexts.forEach[c|c.firstSetGrammarElements.forEach[e|createProposal(e, c, parameters, result)]]
	}
	
	protected def supportParserBasedProposals(TokenSet tokenSet) {
		tokenSet == defaultTokens
	}

	protected def getParserBasedDelegate() {
		if (delegates == null)
			return null
		delegates.get => [it.pool = pool]
	}

	protected def getText(CompletionParameters parameters) {
		runReadAction[parameters.originalFile.text]
	}

	protected def getSelection(CompletionParameters parameters) {
		val offsets = parameters.offsets
		val startOffset = offsets.getOffset(CompletionInitializationContext.START_OFFSET)
		val endOffset = offsets.getOffset(CompletionInitializationContext.SELECTION_END_OFFSET)
		new TextRegion(startOffset, endOffset - startOffset)
	}

	protected def getOffsets(CompletionParameters parameters) {
		runReadAction [
			(parameters.position.getUserData(CompletionContext.COMPLETION_CONTEXT_KEY)).offsetMap
		]
	}

	protected def getResource(CompletionParameters parameters) {
		runReadAction[(parameters.originalFile as BaseXtextFile).resource]
	}

	protected def <T> runReadAction(Computable<T> computable) {
		ApplicationManager.application.<T>runReadAction(computable)
	}

	protected def createProposal(AbstractElement grammarElement, ContentAssistContext context, CompletionParameters parameters, CompletionResultSet result) {
		switch grammarElement {
			Keyword: createKeyWordProposal(grammarElement, context, parameters, result)
		}
	}

	protected def createKeyWordProposal(Keyword keyword, ContentAssistContext context, CompletionParameters parameters, CompletionResultSet result) {
		if (isKeywordWorthyToPropose(keyword)) {
			result += new KeywordLookupElement(keyword)
		}
	}

	protected def isKeywordWorthyToPropose(Keyword keyword) {
		keyword.value.length > 1 && Character.isLetter(keyword.value.charAt(0))
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
