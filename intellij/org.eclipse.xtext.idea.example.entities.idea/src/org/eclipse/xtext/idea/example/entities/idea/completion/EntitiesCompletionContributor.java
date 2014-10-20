package org.eclipse.xtext.idea.example.entities.idea.completion;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.FollowElementCalculator;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResult;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionSorter;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementWeigher;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.Computable;
import com.intellij.util.Consumer;

public class EntitiesCompletionContributor extends CompletionContributor {

	@Inject
	private IContentAssistParser parser;	
	
	public EntitiesCompletionContributor() {
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}
	
	@Override
	public void fillCompletionVariants(final CompletionParameters parameters, CompletionResultSet result) {
		final CompletionResultSet sortedResult = getSortedResult(parameters, result);
		sortedResult.runRemainingContributors(parameters, new Consumer<CompletionResult>() {
			public void consume(CompletionResult t) {
				sortedResult.addElement(t.getLookupElement());
			}
		});
		String prefix = ApplicationManager.getApplication().runReadAction(new Computable<String>() {
			public String compute() {
				return parameters.getOriginalFile().getText().substring(0, parameters.getOffset());
			}});
		Collection<FollowElement> followElements = parser.getFollowElements(prefix, false);
		List<AbstractElement> grammarElements = Lists.newArrayList();
		computeFollowElements(followElements, grammarElements);
		for (AbstractElement grammarElement : grammarElements) {
			createProposal(grammarElement, sortedResult);
		}
	}

	private CompletionResultSet getSortedResult(final CompletionParameters parameters, CompletionResultSet result) {
		CompletionSorter xtextSorter = CompletionSorter.defaultSorter(parameters, result.getPrefixMatcher())
			.weighBefore("liftShorter", new LookupElementWeigher("xtext") {
				@Override
				public Comparable<?> weigh(LookupElement element) {
					if (element instanceof KeywordLookupElement) {
						return 1;
					} else {
						return -1;
					}
				}
			});
		return result.withRelevanceSorter(xtextSorter);
	}
	
	private void createProposal(AbstractElement grammarElement, CompletionResultSet result) {
		if (grammarElement instanceof Keyword) {
			addKeyWordProposal(result, (Keyword) grammarElement);
		}
	}
	
	private void addKeyWordProposal(CompletionResultSet result, Keyword keyword) {
		LookupElement lookupElement = new KeywordLookupElement(keyword);
		result.addElement(lookupElement);
	}
	
	public static class KeywordLookupElement extends LookupElement {
		private Keyword keyword;
		
		public KeywordLookupElement(Keyword keyword) {
			this.keyword = keyword;
		}

		@Override
		public String getLookupString() {
			return keyword.getValue();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((keyword == null) ? 0 : keyword.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			KeywordLookupElement other = (KeywordLookupElement) obj;
			if (keyword == null) {
				if (other.keyword != null)
					return false;
			} else if (!keyword.equals(other.keyword))
				return false;
			return true;
		}
		
	}
	
	//copied from ParserBasedContentAssistContextFactory

	protected void computeFollowElements(Collection<FollowElement> followElements, final Collection<AbstractElement> result) {
		IdeaFollowElementCalculator calculator = new IdeaFollowElementCalculator(
			new IFollowElementAcceptor(){
				public void accept(AbstractElement element) {
					ParserRule rule = GrammarUtil.containingParserRule(element);
					if (rule == null || !GrammarUtil.isDatatypeRule(rule))
						result.add(element);
				}
			});
		for(FollowElement element: followElements) {
			computeFollowElements(calculator, element);
		}
	}

	protected void computeFollowElements(FollowElementCalculator calculator, FollowElement element) {
		Multimap<Integer, List<AbstractElement>> visited = HashMultimap.create();
		computeFollowElements(calculator, element, visited);
	}
	
	protected void computeFollowElements(FollowElementCalculator calculator, FollowElement element, Multimap<Integer, List<AbstractElement>> visited) {
		List<AbstractElement> currentState = Lists.newArrayList(element.getLocalTrace());
		currentState.add(element.getGrammarElement());
		if (!visited.put(element.getLookAhead(), currentState))
			return;
		if (element.getLookAhead() <= 1) {
			for(AbstractElement abstractElement: currentState) {
				Assignment ass = EcoreUtil2.getContainerOfType(abstractElement, Assignment.class);
				if (ass != null)
					calculator.doSwitch(ass);
				else {
					if (abstractElement instanceof UnorderedGroup && abstractElement == element.getGrammarElement()) {
						calculator.doSwitch((UnorderedGroup) abstractElement, element.getHandledUnorderedGroupElements());
					} else {
						calculator.doSwitch(abstractElement);
						if (GrammarUtil.isOptionalCardinality(abstractElement)) {
							EObject container = abstractElement.eContainer();
							if (container instanceof Group) {
								Group group = (Group) container;
								int idx = group.getElements().indexOf(abstractElement);
								if (idx == group.getElements().size() - 1) {
									if (!currentState.contains(group) && GrammarUtil.isMultipleCardinality(group)) {
										calculator.doSwitch(group);
									}
								} else if (idx < group.getElements().size() - 1 && "?".equals(abstractElement.getCardinality())) { // loops are fine
									AbstractElement nextElement = group.getElements().get(idx + 1);
									if (!currentState.contains(nextElement)) {
										calculator.doSwitch(nextElement);
									}
								}
							}
						} else if (isAlternativeWithEmptyPath(abstractElement)) {
							EObject container = abstractElement.eContainer();
							if (container instanceof Group) {
								Group group = (Group) container;
								int idx = group.getElements().indexOf(abstractElement);
								if (!currentState.contains(group) && idx != group.getElements().size() - 1) {
									AbstractElement next = group.getElements().get(idx + 1);
									if (!currentState.contains(next)) {
										calculator.doSwitch(next);
									}
								}
							}
						}
					}
				}
			}
			// special case: entry rule, first abstract element
			// we need a synthetic rule call
			if (element.getTrace().equals(element.getLocalTrace())) {
				ParserRule parserRule = GrammarUtil.containingParserRule(element.getGrammarElement());
				if (parserRule != null) {
					RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
					ruleCall.setRule(parserRule);
					calculator.doSwitch(ruleCall);
				}
			}
			return;
		}
		Collection<FollowElement> followElements = parser.getFollowElements(element);
		for(FollowElement newElement: followElements) {
			if (newElement.getLookAhead() != element.getLookAhead() || newElement.getGrammarElement() != element.getGrammarElement()) {
				if (newElement.getLookAhead() == element.getLookAhead()) {
					int originalTraceSize = element.getLocalTrace().size();
					List<AbstractElement> newTrace = newElement.getLocalTrace();
					if (newTrace.size() > originalTraceSize) {
						if (Collections.indexOfSubList(element.getLocalTrace(), newTrace.subList(originalTraceSize, newTrace.size())) != -1) {
							continue;
						}
					}
				}
				computeFollowElements(calculator, newElement, visited);
			}
		}
	}
	
	private boolean isAlternativeWithEmptyPath(AbstractElement abstractElement) {
		if (abstractElement instanceof Alternatives) {
			Alternatives alternatives = (Alternatives) abstractElement;
			for(AbstractElement path: alternatives.getElements()) {
				if (GrammarUtil.isOptionalCardinality(path))
					return true;
			}
		}
		return false;
	}
	
	public static class IdeaFollowElementCalculator extends FollowElementCalculator {
		public IdeaFollowElementCalculator(IFollowElementAcceptor acceptor) {
			this.acceptor = acceptor;
		}
	}
}
