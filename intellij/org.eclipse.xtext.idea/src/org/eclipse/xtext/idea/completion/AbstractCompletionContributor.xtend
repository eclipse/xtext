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
import com.intellij.openapi.util.Computable
import com.intellij.util.ProcessingContext
import java.util.Map
import java.util.Set
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.IGrammarAccess
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ide.editor.contentassist.IFollowElementAcceptor
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElementComputer
import org.eclipse.xtext.ide.editor.contentassist.antlr.IContentAssistParser
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.util.TextRegion

abstract class AbstractCompletionContributor extends CompletionContributor {

	@Inject(optional=true) Provider<ContentAssistContextFactory> delegates
	@Inject protected extension CompletionExtensions
	@Inject protected IGrammarAccess grammarAccess
	
	@Inject IContentAssistParser contentAssistParser
	@Inject FollowElementComputer followElementComputer
	
	ExecutorService pool = Executors.newFixedThreadPool(3)
	Map<CompletionType, Multimap<AbstractElement, CompletionProvider<CompletionParameters>>> myContributors = newHashMap

	new(AbstractXtextLanguage lang) {
		lang.injectMembers(this)
	}
	
	protected def extend(CompletionType type, EStructuralFeature feature, CompletionProvider<CompletionParameters> contrib) {
		collectElements(grammarAccess.grammar, feature) [
			extend(type, it, contrib)
		]
	}
	
	private def void collectElements(Grammar grammar, EStructuralFeature feature, IFollowElementAcceptor followElementAcceptor) {
		for (superGrammar : grammar.usedGrammars) {
			collectElements(superGrammar, feature, followElementAcceptor)
		}
		val declarator = feature.getEContainingClass
		for (rule : GrammarUtil.allParserRules(grammar)) {
			for (assignment : GrammarUtil.containedAssignments(rule).filter[it.feature == feature.name]) {
				val classifier = GrammarUtil.findCurrentType(assignment)
				val compType = EcoreUtil2.getCompatibleType(declarator, classifier)
				if (compType == declarator) {
					followElementAcceptor.accept(assignment)
				}
			}
		}
	}
	
	protected def extend(CompletionType type, AbstractElement followElement, CompletionProvider<CompletionParameters> contrib) {
		if (!myContributors.containsKey(type)) {
			myContributors.put(type, ArrayListMultimap.create)
		}
		val map = myContributors.get(type)
		map.put(followElement, contrib)
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
		createFollowElementBasedProposals(parameters, filteredResult)
		createParserBasedProposals(parameters, filteredResult)
		result.stopHere
	}

	protected def void createFollowElementBasedProposals(CompletionParameters parameters, CompletionResultSet result) {
		if (myContributors.isEmpty || !myContributors.containsKey(parameters.completionType))
			return;
		val followElements = computeFollowElements(parameters)
		val element2provider = myContributors.get(parameters.getCompletionType())
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
		val followElements = contentAssistParser.getFollowElements(parameters.editor.document.text.substring(0, parameters.position.node.startOffset), false)
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
		val delegate = parserBasedDelegate
		if (delegate == null)
			return;
		val contexts = delegate.create(parameters.text, parameters.selection, parameters.offset, parameters.resource)
		contexts.forEach[c|c.firstSetGrammarElements.forEach[e|createProposal(e, c, parameters, result)]]
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
