/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.parsetree.util.ParsetreeSwitch;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Builder;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserBasedContentAssistContextFactory extends AbstractContentAssistContextFactory {

	@Inject
	private Provider<StatefulFactory> statefulFactoryProvider;
	
	public Provider<StatefulFactory> getStatefulFactoryProvider() {
		return statefulFactoryProvider;
	}
	
	public void setStatefulFactoryProvider(Provider<StatefulFactory> statefulFactoryProvider) {
		this.statefulFactoryProvider = statefulFactoryProvider;
	}
	
	public static class StatefulFactory implements Function<ContentAssistContext.Builder, ContentAssistContext> {
		
		@Inject
		private IContentAssistParser parser;
		
		@Inject
		private Provider<ContentAssistContext.Builder> contentAssistContextProvider;
		
		@Inject
		private PrefixMatcher matcher;
		
		private ITextViewer viewer;

		private XtextResource resource;

		private CompositeNode rootNode;

		private AbstractNode lastCompleteNode;

		private AbstractNode currentNode;

		private AbstractNode lastVisibleNode;

		private EObject currentModel;

		private List<ContentAssistContext.Builder> contextBuilders;

		private IParseResult parseResult;

		private AbstractNode datatypeNode;

		private int completionOffset;

		private ITextSelection selection;

		public ContentAssistContext apply(Builder from) {
			return from.toContext();
		}
		
		public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource)
				throws BadLocationException {
			this.viewer = viewer;
			this.resource = resource;
			this.parseResult = resource.getParseResult();
			if (parseResult == null)
				throw new NullPointerException("parseResult is null");
			return doCreateContexts(offset);
		}

		protected ContentAssistContext[] doCreateContexts(int offset) throws BadLocationException {
			initializeFromViewerAndResource(offset);
			
			if (datatypeNode != lastCompleteNode) {
				handleLastCompleteNodeAsPartOfDatatypeNode();
			}

			// 2nd context: we assume, that the current token is incomplete and try to calculate
			// any valid grammar element by removing the current token and using it as prefix
			if (datatypeNode == lastCompleteNode && completionOffset != lastCompleteNode.getOffset()) {
				handleLastCompleteNodeIsAtEndOfDatatypeNode();
			}

			// 4th context: we assume, that the current position is perfectly ok to insert a new token, if the previous one was valid
			if (!(lastCompleteNode instanceof LeafNode) || lastCompleteNode.getGrammarElement() != null) {
				handleLastCompleteNodeIsPartOfLookahead();
			}
			return Lists.transform(contextBuilders, this).toArray(new ContentAssistContext[contextBuilders.size()]);
		}

		protected void initializeFromViewerAndResource(int offset) {
			initializeAndAdjustCompletionOffset(offset);
			initializeNodeAndModelData();
			contextBuilders = Lists.newArrayList();
		}

		protected void initializeNodeAndModelData() {
			rootNode = parseResult.getRootNode();
			lastCompleteNode = new LeafNodeFinder(completionOffset, true).doSwitch(rootNode);
			if (lastCompleteNode == null)
				lastCompleteNode = rootNode;
			currentNode = new LeafNodeFinder(completionOffset, false).doSwitch(rootNode);
			if (currentNode == null)
				currentNode = lastCompleteNode;
			lastVisibleNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, completionOffset);
			datatypeNode = getContainingDatatypeRuleNode(lastCompleteNode);
			currentModel = NodeUtil.getNearestSemanticObject(lastVisibleNode);
		}

		protected void initializeAndAdjustCompletionOffset(int offset) {
			selection = (ITextSelection) viewer.getSelectionProvider().getSelection();
			completionOffset = offset;
			if (selection.getOffset() + selection.getLength() == offset)
				completionOffset = selection.getOffset();
		}

		protected void handleLastCompleteNodeIsPartOfLookahead() throws BadLocationException {
			// do not calculate twice for the same input
			if (!(lastCompleteNode instanceof LeafNode && ((LeafNode) lastCompleteNode).isHidden())) {
				createContextsForLastCompleteNode(currentModel);
			}
		}

		protected void handleLastCompleteNodeIsAtEndOfDatatypeNode() throws BadLocationException {
			String prefix = getPrefix(lastCompleteNode);
			String completeInput = viewer.getDocument().get(0, lastCompleteNode.getOffset());
			AbstractNode previousNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, lastCompleteNode.getOffset());
			EObject previousModel = NodeUtil.getNearestSemanticObject(previousNode);
			AbstractNode currentDatatypeNode = getContainingDatatypeRuleNode(currentNode);
			Collection<FollowElement> followElements = parser.getFollowElements(completeInput);
			int prevSize = contextBuilders.size();
			doCreateContexts(previousNode, currentDatatypeNode, prefix, previousModel, followElements);
			
			if (lastCompleteNode instanceof LeafNode && lastCompleteNode.getGrammarElement() == null && contextBuilders.size() != prevSize) {
				handleLastCompleteNodeHasNoGrammarElement(contextBuilders.subList(prevSize, contextBuilders.size()), previousModel);
			}
		}

		protected void handleLastCompleteNodeHasNoGrammarElement(List<Builder> contextBuilderToCheck, EObject previousModel) throws BadLocationException {
			List<ContentAssistContext> newContexts = Lists.transform(contextBuilderToCheck, this);
			boolean wasValid = isLikelyToBeValidProposal(lastCompleteNode, newContexts);
			if (wasValid && !(lastCompleteNode instanceof LeafNode && ((LeafNode) lastCompleteNode).isHidden())) {
				createContextsForLastCompleteNode(previousModel);
			}
		}

		protected void handleLastCompleteNodeAsPartOfDatatypeNode() throws BadLocationException {
			String prefix = getPrefix(datatypeNode);
			String completeInput = viewer.getDocument().get(0, datatypeNode.getOffset());
			Collection<FollowElement> followElements = parser.getFollowElements(completeInput);
			AbstractNode lastCompleteNodeBeforeDatatype = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, datatypeNode.getTotalOffset());
			doCreateContexts(lastCompleteNodeBeforeDatatype, datatypeNode, prefix, currentModel, followElements);
		}
		
		protected boolean isLikelyToBeValidProposal(AbstractNode lastCompleteNode, Iterable<ContentAssistContext> contexts) {
			for(ContentAssistContext context: contexts) {
				for (AbstractElement element: context.getFirstSetGrammarElements()) {
					if (element instanceof Keyword) {
						String keywordValue = ((Keyword) element).getValue();
						String lastText = ((LeafNode) lastCompleteNode).getText();
						if (keywordValue.equals(lastText)) 
							return true;
					}
				}
			}
			return false;
		}

		protected void createContextsForLastCompleteNode(EObject previousModel) throws BadLocationException {
			String prefix = "";
			String completeInput = viewer.getDocument().get(0, completionOffset);
			Collection<FollowElement> followElements = parser.getFollowElements(completeInput);
			doCreateContexts(lastCompleteNode, currentNode, prefix, previousModel, followElements);
		}

		protected void doCreateContexts(
				AbstractNode lastCompleteNode, AbstractNode currentNode,
				String prefix, EObject previousModel, 
				Collection<FollowElement> followElements) {
			Set<AbstractElement> followElementAsAbstractElements = Sets.newLinkedHashSet();
			computeFollowElements(followElements, followElementAsAbstractElements);
			Multimap<EObject, AbstractElement> contextMap = computeCurrentModel(previousModel, lastCompleteNode, followElementAsAbstractElements);
			currentNode = getContainingDatatypeRuleNode(currentNode);
			for (Entry<EObject, Collection<AbstractElement>> entry : contextMap.asMap().entrySet()) {
				ContentAssistContext.Builder contextBuilder = doCreateContext(lastCompleteNode, entry.getKey(), previousModel, currentNode, prefix);
				for(AbstractElement element: entry.getValue()) {
					contextBuilder.accept(element);
				}
				contextBuilders.add(contextBuilder);
			}
		}

		protected Multimap<EObject, AbstractElement> computeCurrentModel(EObject currentModel, AbstractNode lastCompleteNode,
				Collection<AbstractElement> followElements) {
			Multimap<EObject, AbstractElement> result = LinkedHashMultimap.create();
			NodeAdapter adapter = NodeUtil.getNodeAdapter(currentModel);
			if (adapter == null || adapter.getParserNode() == null) {
				result.putAll(currentModel, followElements);
				return result;
			}
			CompositeNode currentParserNode = adapter.getParserNode();
			EObject currentGrammarElement = currentParserNode.getGrammarElement();
			AbstractRule currentRule = getRule(currentGrammarElement);
			for (AbstractElement grammarElement : followElements) {
				EObject loopGrammarElement = currentGrammarElement;
				AbstractRule rule = currentRule;
				CompositeNode loopParserNode = currentParserNode;
				EObject loopLastGrammarElement = lastCompleteNode.getGrammarElement();
				while (!canBeCalledAfter(rule, loopLastGrammarElement, grammarElement) && loopParserNode.getParent() != null) {
					loopLastGrammarElement = loopParserNode.getGrammarElement();
					loopParserNode = loopParserNode.getParent();
					while (loopParserNode.getGrammarElement() == null && loopParserNode.getParent() != null)
						loopParserNode = loopParserNode.getParent();
					loopGrammarElement = loopParserNode.getGrammarElement();
					rule = getRule(loopGrammarElement);
				}
				EObject context = NodeUtil.getNearestSemanticObject(loopParserNode);
				result.put(context, grammarElement);
			}
			return result;
		}
		
		protected void computeFollowElements(Collection<FollowElement> followElements, final Collection<AbstractElement> result) {
			FollowElementCalculator calculator = new FollowElementCalculator();
			calculator.acceptor = new IFollowElementAcceptor(){
				public void accept(AbstractElement element) {
					ParserRule rule = GrammarUtil.containingParserRule(element);
					if (rule == null || !GrammarUtil.isDatatypeRule(rule))
						result.add(element);
				}
			};
			for(FollowElement element: followElements) {
				computeFollowElements(calculator, element);
			}
		}

		protected void computeFollowElements(FollowElementCalculator calculator, FollowElement element) {
			computeFollowElements(calculator, element, Sets.<Pair<Integer, AbstractElement>>newHashSet());
		}
		
		protected void computeFollowElements(FollowElementCalculator calculator, FollowElement element, Set<Pair<Integer, AbstractElement>> handled) {
			if (!handled.add(Tuples.create(element.getLookAhead(), element.getGrammarElement())))
				return;
			if (element.getLookAhead() <= 1) {
				Iterable<AbstractElement> currentState = Iterables.concat(
						element.getLocalTrace(), 
						Collections.singleton(element.getGrammarElement()));
				for(AbstractElement abstractElement: currentState) {
					Assignment ass = EcoreUtil2.getContainerOfType(abstractElement, Assignment.class);
					if (ass != null)
						calculator.doSwitch(ass);
					else {
						if (abstractElement instanceof UnorderedGroup && abstractElement == element.getGrammarElement()) {
							calculator.doSwitch((UnorderedGroup) abstractElement, element.getHandledUnorderedGroupElements());
						} else {
							calculator.doSwitch(abstractElement);
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
				if (newElement.getLookAhead() != element.getLookAhead() || newElement.getGrammarElement() != element.getGrammarElement())
					computeFollowElements(calculator, newElement, handled);
			}
		}

		public AbstractNode getContainingDatatypeRuleNode(AbstractNode node) {
			AbstractNode result = node;
			EObject grammarElement = result.getGrammarElement();
			if (grammarElement != null) {
				ParserRule parserRule = GrammarUtil.containingParserRule(grammarElement);
				while (parserRule != null && GrammarUtil.isDatatypeRule(parserRule)) {
					result = result.getParent();
					grammarElement = result.getGrammarElement();
					parserRule = GrammarUtil.containingParserRule(grammarElement);
				}
			}
			return result;
		}

		public ContentAssistContext.Builder doCreateContext(
				AbstractNode lastCompleteNode, 
				EObject currentModel, EObject previousModel,
				AbstractNode currentNode, String prefix) {
			ContentAssistContext.Builder context = contentAssistContextProvider.get();

			context.setRootNode(rootNode);
			context.setLastCompleteNode(lastCompleteNode);
			context.setCurrentNode(currentNode);

			context.setRootModel(parseResult.getRootASTElement());
			context.setCurrentModel(currentModel);
			context.setPreviousModel(previousModel);
			context.setOffset(completionOffset);
			context.setViewer(viewer);
			context.setPrefix(prefix);
			int regionLength = prefix.length();
			if (selection.getLength() > 0)
				regionLength = regionLength + selection.getLength();
			Region region = new Region(completionOffset - prefix.length(), regionLength);
			context.setReplaceRegion(region);
			context.setSelectedText(selection.getText());
			context.setMatcher(matcher);
			context.setResource(resource);
			return context;
		}

		public String getPrefix(AbstractNode prefixNode) {
			if (prefixNode instanceof LeafNode) {
				if (((LeafNode) prefixNode).isHidden() && prefixNode.getGrammarElement() != null)
					return "";
				return getNodeTextUpToCompletionOffset(prefixNode);
			}
			StringBuilder result = new StringBuilder(prefixNode.getTotalLength());
			doComputePrefix((CompositeNode) prefixNode, result);
			return result.toString();
		}

		public String getNodeTextUpToCompletionOffset(AbstractNode currentNode) {
			int startOffset = currentNode.getOffset();
			String text = ((LeafNode) currentNode).getText();
			int length = completionOffset - startOffset;
			String result = length > text.length() ? text : text.substring(0, length);
			return result;
		}

		public boolean doComputePrefix(CompositeNode node, StringBuilder result) {
			List<LeafNode> hiddens = new ArrayList<LeafNode>(2);
			for (AbstractNode child : node.getChildren()) {
				if (child instanceof CompositeNode) {
					if (!doComputePrefix((CompositeNode) child, result))
						return false;
				}
				else {
					LeafNode leaf = (LeafNode) child;
					if (leaf.getOffset() > completionOffset)
						return false;
					if (leaf.isHidden()) {
						if (result.length() != 0)
							hiddens.add((LeafNode) child);
					}
					else {
						Iterator<LeafNode> iter = hiddens.iterator();
						while (iter.hasNext()) {
							result.append(iter.next().getText());
						}
						hiddens.clear();
						result.append(getNodeTextUpToCompletionOffset(leaf));
						if (leaf.getOffset() + leaf.getLength() > completionOffset)
							return false;
					}
				}
			}
			return true;
		}
		
		public void setParser(IContentAssistParser parser) {
			this.parser = parser;
		}

		public IContentAssistParser getParser() {
			return parser;
		}

		protected boolean canBeCalledAfter(AbstractRule rule, final EObject previousGrammarElement, final EObject nextGrammarElement) {
			return createCallHierachyHelper(previousGrammarElement, nextGrammarElement).doSwitch(rule);
		}

		protected ParserBasedContentAssistContextFactory.CallHierarchyHelper createCallHierachyHelper(final EObject previousGrammarElement,
				final EObject nextGrammarElement) {
			return new ParserBasedContentAssistContextFactory.CallHierarchyHelper(nextGrammarElement, previousGrammarElement);
		}

		protected AbstractRule getRule(EObject currentGrammarElement) {
			AbstractRule rule = null;
			if (currentGrammarElement instanceof RuleCall)
				rule = ((RuleCall) currentGrammarElement).getRule();
			if (currentGrammarElement instanceof AbstractRule)
				rule = (AbstractRule) currentGrammarElement;
			if (currentGrammarElement instanceof Action)
				rule = EcoreUtil2.getContainerOfType(currentGrammarElement, AbstractRule.class);
			if (rule == null)
				throw new IllegalStateException();
			return rule;
		}
	}

	public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource) {
		try { 
			return statefulFactoryProvider.get().create(viewer, offset, resource);
		}
		catch (BadLocationException e) {
			throw new RuntimeException(e);
		}
	}

	public static class LeafNodeFinder extends ParsetreeSwitch<LeafNode> {
		private final int offset;
		private final boolean leading;
		
		public LeafNodeFinder(int offset, boolean leading) {
			this.offset = offset;
			this.leading = leading;
		}
		
		@Override
		public LeafNode caseCompositeNode(CompositeNode object) {
			if (leading) {
				if (object.getTotalOffset() < offset && object.getTotalLength() + object.getTotalOffset() >= offset) {
					for (AbstractNode node: object.getChildren()) {
						LeafNode result = doSwitch(node);
						if (result != null)
							return result;
					}
				}
			} else {
				if (object.getTotalOffset() <= offset && object.getTotalLength() + object.getTotalOffset() > offset) {
					for (AbstractNode node: object.getChildren()) {
						LeafNode result = doSwitch(node);
						if (result != null)
							return result;
					}
				}
			}
			return null;
		}
		
		@Override
		public LeafNode caseLeafNode(LeafNode object) {
			if (leading) {
				if (object.getTotalOffset() < offset && object.getTotalLength() + object.getTotalOffset() >= offset)
					return object;
			} else {
				if (object.getTotalOffset() <= offset && object.getTotalLength() + object.getTotalOffset() > offset)
					return object;
			}
			return null;
		}
	}

	public static class FollowElementCalculator extends XtextSwitch<Boolean> {
		
		protected IFollowElementAcceptor acceptor;
		
		private List<AbstractElement> handledAlternatives;

		private UnorderedGroup group;
		
		private Collection<RuleCall> visitedRuleCalls = Sets.newHashSet();
		
		public void doSwitch(UnorderedGroup group, List<AbstractElement> handledAlternatives) {
			this.group = group;
			this.handledAlternatives = handledAlternatives;
			try {
				doSwitch(group);
			} finally {
				this.handledAlternatives = null;
				this.group = null;
			}
		}
		
		@Override
		public Boolean caseAlternatives(Alternatives object) {
			boolean more = false;
			for(AbstractElement element: object.getElements()) {
				more = doSwitch(element) || more;
			}
			return more || isOptional(object);
		}
		
		@Override
		public Boolean caseUnorderedGroup(UnorderedGroup object) {
			if (object == this.group) {
				boolean more = true;
				for(AbstractElement element: object.getElements()) {
					if (handledAlternatives == null || !handledAlternatives.contains(element)) {
						this.group = null;
						more = doSwitch(element) && more;
						this.group = object;
					}
				}
				if (more && GrammarUtil.isMultipleCardinality(object)) {
					handledAlternatives = null;
					this.group = null;
					return caseUnorderedGroup(object);
				}
				return more || isOptional(object);
			} else {
				boolean more = true;
				for(AbstractElement element: object.getElements()) {
					more = doSwitch(element) && more;
				}
				return more || isOptional(object);
			}
		}
		
		@Override
		public Boolean caseGroup(Group object) {
			boolean more = true;
			for(AbstractElement element: object.getElements()) {
				more = more && doSwitch(element);
			}
			return more || isOptional(object);
		}
		
		@Override
		public Boolean caseAction(Action object) {
			return true;
		}
		
		@Override
		public Boolean caseAssignment(Assignment object) {
			acceptor.accept(object);
			return doSwitch(object.getTerminal()) || isOptional(object);
		}
		
		@Override
		public Boolean caseCrossReference(CrossReference object) {
			return Boolean.FALSE;
		}
		
		@Override
		public Boolean caseParserRule(ParserRule object) {
			if (GrammarUtil.isDatatypeRule(object))
				return Boolean.FALSE;
			return doSwitch(object.getAlternatives());
		}
		
		@Override
		public Boolean caseEnumRule(EnumRule object) {
			return doSwitch(object.getAlternatives());
		}
		
		@Override
		public Boolean caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
			return doSwitch(object.getLiteral());
		}
		
		@Override
		public Boolean caseRuleCall(RuleCall object) {
			if (!visitedRuleCalls.add(object))
				return isOptional(object);
			acceptor.accept(object);
			Boolean result = doSwitch(object.getRule()) || isOptional(object);
			visitedRuleCalls.remove(object);
			return result;
		}
		
		@Override
		public Boolean caseTerminalRule(TerminalRule object) {
			return Boolean.FALSE;
		}
		
		@Override
		public Boolean caseKeyword(Keyword object) {
			acceptor.accept(object);
			return isOptional(object);
		}
		
		public boolean isOptional(AbstractElement element) {
			return GrammarUtil.isOptionalCardinality(element);
		}
	}

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	public static class CallHierarchyHelper extends XtextSwitch<Boolean> {
		private final EObject nextGrammarElement;
		private Set<AbstractRule> visiting = new HashSet<AbstractRule>();
		private Map<AbstractRule, Boolean> visited = Maps.newHashMapWithExpectedSize(4);
		private EObject grammarElement;
		private EObject queuedGrammarElement;
		private Boolean result = Boolean.FALSE;
	
		public CallHierarchyHelper(EObject nextGrammarElement, EObject previousGrammarElement) {
			this.nextGrammarElement = nextGrammarElement;
			grammarElement = previousGrammarElement;
			queuedGrammarElement = nextGrammarElement;
		}
	
		@Override
		public Boolean caseAbstractRule(AbstractRule object) {
			if (!checkFurther(object))
				return result;
			if (!visiting.add(object))
				return Boolean.FALSE;
			if (visited.containsKey(object)) {
				visiting.remove(object);
				return visited.get(object);
			}
			EObject wasGrammarElement = grammarElement;
			Boolean result = doSwitch(object.getAlternatives());
			visiting.remove(object);
			if (wasGrammarElement == grammarElement) // we store the result per grammarElement for performance reasons
				visited.put(object, result);
			return result;
		}
	
		private boolean checkFurther(EObject object) {
			if (object == grammarElement) {
				if (queuedGrammarElement != null) {
					grammarElement = queuedGrammarElement;
					queuedGrammarElement = null;
					visited.clear();
					visiting.clear();
					return true;
				}
				result = Boolean.TRUE;
				return false;
			}
			return true;
		}
	
		@Override
		public Boolean caseTerminalRule(TerminalRule object) {
			checkFurther(object);
			return result;
		}
	
		@Override
		public Boolean caseGroup(Group object) {
			if (!checkFurther(object))
				return result;
			for (AbstractElement token : object.getElements())
				if (doSwitch(token))
					return true;
			if (GrammarUtil.isMultipleCardinality(object)) {
				if (!checkFurther(object))
					return result;
				for (AbstractElement token : object.getElements())
					if (doSwitch(token))
						return true;
			}
			return false;
		}
	
		@Override
		public Boolean caseUnorderedGroup(UnorderedGroup object) {
			if (!checkFurther(object))
				return result;
			// elements may occur in any order - treat them as looped alternatives
			if (caseAlternatives(object.getElements()))
				return true;
			if (!checkFurther(object))
				return result;
			return caseAlternatives(object.getElements());
		}
	
		@Override
		public Boolean caseAlternatives(Alternatives object) {
			if (!checkFurther(object))
				return result;
			if (caseAlternatives(object.getElements()))
				return true;
			if (GrammarUtil.isMultipleCardinality(object)) {
				if (!checkFurther(object))
					return result;
				return caseAlternatives(object.getElements());
			}
			return Boolean.FALSE;
		}
	
		public Boolean caseAlternatives(List<AbstractElement> elements) {
			EObject wasGrammarElement = this.grammarElement;
			Set<AbstractRule> visiting = Sets.newHashSet(this.visiting);
			boolean foundSomething = false;
			for (AbstractElement group : elements) {
				this.grammarElement = wasGrammarElement;
				this.visiting = Sets.newHashSet(visiting);
				if (doSwitch(group))
					return true;
				if (wasGrammarElement != this.grammarElement) {
					foundSomething = true;
				}
			}
			if (foundSomething) {
				this.grammarElement = nextGrammarElement;
				this.visiting.clear();
			}
			return Boolean.FALSE;
		}
	
		@Override
		public Boolean caseAbstractElement(AbstractElement object) {
			if (!checkFurther(object))
				return result;
			if (GrammarUtil.isMultipleCardinality(object)) {
				if (!checkFurther(object))
					return result;
			}
			return Boolean.FALSE;
		}
	
		@Override
		public Boolean caseAssignment(Assignment object) {
			if (!checkFurther(object))
				return result;
			if (doSwitch(object.getTerminal()))
				return true;
			if (GrammarUtil.isMultipleCardinality(object)) {
				if (!checkFurther(object))
					return result;
				if (doSwitch(object.getTerminal()))
					return true;
			}
			return Boolean.FALSE;
		}
	
		@Override
		public Boolean caseCrossReference(CrossReference object) {
			if (!checkFurther(object))
				return result;
			if (doSwitch(object.getTerminal()))
				return true;
			if (GrammarUtil.isMultipleCardinality(object)) {
				if (!checkFurther(object))
					return result;
				if (doSwitch(object.getTerminal()))
					return true;
			}
			return Boolean.FALSE;
		}
	
		@Override
		public Boolean caseRuleCall(RuleCall object) {
			if (!checkFurther(object))
				return result;
			if (doSwitch(object.getRule()))
				return true;
			if (GrammarUtil.isMultipleCardinality(object)) {
				if (!checkFurther(object))
					return result;
				if (doSwitch(object.getRule()))
					return true;
			}
			return Boolean.FALSE;
		}
	
		@Override
		public Boolean caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
			if (!checkFurther(object))
				return result;
			Boolean result = doSwitch(object.getLiteral());
			return result;
		}
	}
}
