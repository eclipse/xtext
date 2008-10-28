package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Dennis Hübner - Initial contribution and API
 */
public class DefaultContentAssistProcessor implements IContentAssistProcessor {

	@Inject
	private IProposalProvider proposalProvider;

	private final Map<String, Method> methodLookupMap = new HashMap<String, Method>();

	/**
	 * computes the possible grammar elements following the one at the given
	 * offset and calls the respective methods on the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, final int offset) {
		if (proposalProvider != null) {
			IDocument document = viewer.getDocument();
			if (document instanceof XtextDocument) {

				XtextDocument xtextDocument = (XtextDocument) document;

				CompositeNode rootNode = xtextDocument.readOnly(new UnitOfWork<CompositeNode>() {
					public CompositeNode exec(XtextResource resource) throws Exception {
						IParseResult parseResult = resource.getParseResult();
						Assert.isNotNull(parseResult);
						return parseResult.getRootNode();
					}
				});
				Assert.isNotNull(rootNode);

				// last COMPLETE node element with associated grammar element
				AbstractNode lastCompleteNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, offset);
				// node at CURRENT cursor pos. with or without grammar element
				LeafNode currentLeafNode = (LeafNode) ParseTreeUtil.getCurrentNodeByOffset(rootNode, offset);
				// get associated grammar element
				AbstractElement grammarElement = ParseTreeUtil.getGrammarElementFromNode(lastCompleteNode);

				String prefix = viewer.getTextWidget().getText(currentLeafNode.getOffset(), offset);

				List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

				for (Iterator<AbstractElement> iterator = calculatePossibleElementSet(lastCompleteNode, grammarElement)
						.iterator(); iterator.hasNext();) {
					AbstractElement nextElement = iterator.next();

					List<EObject> resolvedElementOrRuleList = resolveElement(nextElement);

					collectCompletionProposalList(resolvedElementOrRuleList, completionProposalList, xtextDocument,
							currentLeafNode, prefix, offset);
				}

				if (completionProposalList != null) {
					List<? extends ICompletionProposal> sortAndFilter = proposalProvider.sortAndFilter(completionProposalList);
					return (ICompletionProposal[]) sortAndFilter.toArray(new ICompletionProposal[] {});

				}
			}
		}
		return null;
	}

	private void collectCompletionProposalList(List<EObject> resolvedElementOrRuleList,
			List<ICompletionProposal> completionProposalList, XtextDocument xtextDocument, LeafNode currentLeafNode,
			String prefix, final int offset) {
		for (Iterator<EObject> elementOrRuleIterator = resolvedElementOrRuleList.iterator(); elementOrRuleIterator
				.hasNext();) {
			EObject abstractElement = elementOrRuleIterator.next();

			if (abstractElement instanceof Keyword) {
				completionProposalList.addAll(proposalProvider.completeKeyword((Keyword) abstractElement,
						currentLeafNode, prefix, xtextDocument, offset));
			}
			else if (abstractElement instanceof Assignment) {

				Assignment assignment = (Assignment) abstractElement;

				ParserRule lexerRule = GrammarUtil.containingParserRule(assignment);

				Method method = findMethod(proposalProvider.getClass(),
						"complete" + firstLetterCapitalized(lexerRule.getName())
								+ firstLetterCapitalized(assignment.getFeature()), Assignment.class, EObject.class,
						String.class, IDocument.class, int.class);

				Collection<? extends ICompletionProposal> assignmentProposalList = invokeMethod(method, proposalProvider,
						assignment, currentLeafNode, prefix, xtextDocument, offset);

				if (null != assignmentProposalList) {
					completionProposalList.addAll(assignmentProposalList);
				}

			}
			else if (abstractElement instanceof RuleCall) {

				List<? extends ICompletionProposal> ruleCallProposalList = this.proposalProvider.completeRuleCall(
						(RuleCall) abstractElement, currentLeafNode, prefix, xtextDocument,offset);

				if (null != ruleCallProposalList) {
					completionProposalList.addAll(ruleCallProposalList);
				}
			}
		}
	}

	protected final List<EObject> resolveElement(AbstractElement abstractElement) {

		List<EObject> elementList = new ArrayList<EObject>();

		if (abstractElement instanceof Alternatives) {
			for (AbstractElement alternativeElement : ((Alternatives) abstractElement).getGroups()) {
				elementList.addAll(resolveElement(alternativeElement));
			}
		}
		else if (abstractElement instanceof Group) {
			boolean includeNext = true;
			for (Iterator<AbstractElement> iterator = ((Group) abstractElement).getAbstractTokens().iterator(); iterator
					.hasNext()
					&& includeNext;) {
				AbstractElement groupElement = iterator.next();
				elementList.addAll(resolveElement(groupElement));
				includeNext = GrammarUtil.isOptionalCardinality(groupElement);
			}

		}
		else if (abstractElement instanceof Assignment) {

			Assignment assignment = (Assignment) abstractElement;

			if (assignment.getTerminal() instanceof RuleCall) {
				elementList.addAll(resolveElement(assignment.getTerminal()));
			}
			else if (assignment.getTerminal() instanceof Alternatives) {
				elementList.addAll(resolveElement(assignment.getTerminal()));
			}

			elementList.add(assignment);

		}
		else if (abstractElement instanceof RuleCall) {

			elementList.add(abstractElement);

			AbstractRule abstractRule = GrammarUtil.calledRule((RuleCall) abstractElement);

			if (abstractRule instanceof ParserRule) {
				elementList.addAll(resolveElement(((ParserRule) abstractRule).getAlternatives()));
			}
		}
		else {
			elementList.add(abstractElement);
		}
		return elementList;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public IContextInformationValidator getContextInformationValidator() {
		return new ContextInformationValidator(this);
	}

	protected void handleReflectionException(Exception ex) {
		if (ex instanceof NoSuchMethodException) {
			throw new IllegalStateException("Method not found: " + ex.getMessage());
		}
		if (ex instanceof IllegalAccessException) {
			throw new IllegalStateException("Could not access method: " + ex.getMessage());
		}
		if (ex instanceof InvocationTargetException) {
			rethrowRuntimeException(((InvocationTargetException) ex).getTargetException());
		}
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		handleUnexpectedException(ex);
	}

	private final void rethrowRuntimeException(Throwable ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		handleUnexpectedException(ex);
	}

	protected void handleUnexpectedException(Throwable ex) {
		IllegalStateException isex = new IllegalStateException("Unexpected exception thrown");
		isex.initCause(ex);
		throw isex;
	}

	protected final Set<AbstractElement> calculatePossibleElementSet(AbstractNode contextNode,
			AbstractElement grammarElement) {

		Assert.isNotNull(contextNode, "parameter 'contextNode' must not be null");
		Assert.isNotNull(grammarElement, "parameter 'grammarElement' must not be null");

		Set<AbstractElement> elementSet = new LinkedHashSet<AbstractElement>();

		if (grammarElement.eContainer() instanceof ParserRule) {

			/**
			 * we have completed the rule of the current context.continue at the
			 * parent context
			 */
			boolean hasLeafNodes = false;

			for (Iterator<LeafNode> iterator = contextNode.getLeafNodes().listIterator(); !hasLeafNodes
					&& iterator.hasNext(); hasLeafNodes = !iterator.next().isHidden()) {
				;
			}

			contextNode = contextNode.getParent();

			while (contextNode != null && contextNode.getGrammarElement() == null) {
				contextNode = contextNode.getParent();
			}

			if (null != contextNode) {

				elementSet.addAll(calculatePossibleElementSet(contextNode, ParseTreeUtil
						.getGrammarElementFromNode(contextNode)));

			}
			else if (grammarElement.eContainer() instanceof ParserRule) {

				if (!hasLeafNodes || GrammarUtil.isMultipleCardinality(grammarElement)) {
					elementSet.add(grammarElement);
				}

			}

		}
		else if (grammarElement.eContainer() instanceof Alternatives) {
			/**
			 * one out of the alternatives is already fullfilled so we can
			 * simply skip and proceed to the parent
			 */

			elementSet.addAll(calculatePossibleElementSet(contextNode, (AbstractElement) grammarElement.eContainer()));

		}
		else if (grammarElement.eContainer() instanceof Group) {

			EList<AbstractElement> contents = ((Group) grammarElement.eContainer()).getAbstractTokens();

			int indexOf = contents.indexOf(grammarElement) + 1;

			int size = contents.size();

			// add the current one if has an oneOrMore cardinality
			if (GrammarUtil.isOneOrMoreCardinality(grammarElement)) {
				elementSet.add(grammarElement);
			}

			/**
			 * start at the current (maybe the last) or at the following one
			 * with optional cardinality and add all following with optional
			 * cardinality
			 */
			AbstractElement last = GrammarUtil.isAnyCardinality(grammarElement) || indexOf == size ? grammarElement
					: contents.get(indexOf++);

			while (GrammarUtil.isOptionalCardinality(last) && indexOf < size) {
				elementSet.add(last);
				last = indexOf < size ? contents.get(indexOf++) : last;
			}

			// always add the following if available or the last one if has an
			// any cardinality
			if (last != grammarElement || GrammarUtil.isAnyCardinality(last)) {
				elementSet.add(last);
			}

			// ask parent groups only if we've completed the whole group
			if (indexOf == size) {

				boolean startedAtlastGrammarElementInGroup = last == grammarElement;

				if (startedAtlastGrammarElementInGroup || GrammarUtil.isOptionalCardinality(last)) {

					elementSet.addAll(calculatePossibleElementSet(contextNode, (AbstractElement) grammarElement
							.eContainer()));
				}

			}

		}
		else {
			elementSet.addAll(calculatePossibleElementSet(contextNode, (AbstractElement) grammarElement.eContainer()));

		}

		return elementSet;
	}

	private final String firstLetterCapitalized(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private final Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
		Assert.isNotNull(clazz, "Class must not be null");
		Assert.isNotNull(name, "Method name must not be null");
		Method result = methodLookupMap.get(name);
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null && null == result) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (int i = 0; i < methods.length && null == result; i++) {
				Method method = methods[i];
				if (name.equals(method.getName())
						&& (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
					result = method;
					methodLookupMap.put(name, method);
				}
			}
			searchType = searchType.getSuperclass();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private final Collection<ICompletionProposal> invokeMethod(Method method, Object target, Object... args) {
		try {
			return (Collection<ICompletionProposal>) method.invoke(target, args);
		}
		catch (Exception ex) {
			handleReflectionException(ex);
		}
		throw new IllegalStateException("huh?");
	}

}
