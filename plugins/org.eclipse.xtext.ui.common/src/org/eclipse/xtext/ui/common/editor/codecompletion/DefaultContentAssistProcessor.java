package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Dennis Hübner - Initial contribution and API
 * @author Heiko Behrens
 */
public class DefaultContentAssistProcessor implements IContentAssistProcessor {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	@Inject
	private IProposalProvider proposalProvider;

	private final Map<String, Method> methodLookupMap = new HashMap<String, Method>();

	/**
	 * computes the possible grammar elements following the one at the given
	 * offset and calls the respective methods on the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, final int offset) {
		
		ICompletionProposal[] completionProposals = null;
		
		if (proposalProvider != null) {

			IDocument document = viewer.getDocument();
			
			if (document instanceof XtextDocument) {
				
				List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();
				
				XtextDocument xtextDocument = (XtextDocument) document;

				CompositeNode rootNode = xtextDocument.readOnly(new UnitOfWork<CompositeNode>() {
					public CompositeNode exec(XtextResource resource) throws Exception {
						IParseResult parseResult = resource.getParseResult();
						Assert.isNotNull(parseResult);
						return parseResult.getRootNode();
					}
				});
				
				Assert.isNotNull(rootNode);

				AbstractNode lastCompleteNode = ParseTreeUtil.getLastCompleteNodeByOffset(rootNode, offset);

				LeafNode currentLeafNode = ParseTreeUtil.getCurrentNodeByOffset(rootNode, offset);

				String prefix = null==currentLeafNode ? "" : currentLeafNode.getText();

				Set<AbstractElement> nextValidElementSet = ParseTreeUtil.getElementSetValidFromOffset(rootNode,lastCompleteNode, offset);
				/**
				 * in the case of a non linked crossreference we delegate to proposalProvider (again)  
				 */
				if (lastCompleteNode.getGrammarElement() instanceof CrossReference && !isLinked(lastCompleteNode) ) {
					nextValidElementSet.add((AbstractElement) lastCompleteNode.getGrammarElement().eContainer());
				}
				
				for (List<EObject> resolvedElementOrRuleList : new ProposalCandidateResolverSwitch(nextValidElementSet)) {

					List<ICompletionProposal> collectedCompletionProposalList = collectCompletionProposalList(resolvedElementOrRuleList,  xtextDocument,
							lastCompleteNode, prefix, offset);
					
					completionProposalList.addAll(collectedCompletionProposalList);
				}

				if (completionProposalList != null) {
					List<? extends ICompletionProposal> sortAndFilter = proposalProvider.sortAndFilter(completionProposalList,currentLeafNode,prefix);
					completionProposals =  sortAndFilter.toArray(new ICompletionProposal[] {});
				}
			}
		}
		
		return completionProposals;
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

	private List<ICompletionProposal> collectCompletionProposalList(List<EObject> resolvedElementOrRuleList, IDocument document, AbstractNode currentLeafNode,
			String prefix, final int offset) {

		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();
		
		for (Iterator<EObject> elementOrRuleIterator = resolvedElementOrRuleList.iterator(); elementOrRuleIterator
				.hasNext();) {
			EObject abstractElement = elementOrRuleIterator.next();

			if (abstractElement instanceof Keyword) {
				completionProposalList.addAll(proposalProvider.completeKeyword((Keyword) abstractElement,
						currentLeafNode, prefix, document, offset));
			}
			else if (abstractElement instanceof Assignment) {

				Assignment assignment = (Assignment) abstractElement;

				ParserRule parserRule = GrammarUtil.containingParserRule(assignment);

				EObject model = null == ((CompositeNode) currentLeafNode.eContainer()).getElement() ? currentLeafNode
						.eContainer() : ((CompositeNode) currentLeafNode.eContainer()).getElement();

				Method method = findMethod(proposalProvider.getClass(), "complete"
						+ firstLetterCapitalized(parserRule.getName())
						+ firstLetterCapitalized(assignment.getFeature()), Assignment.class, model.getClass(),
						String.class, document.getClass(), int.class);

				Collection<? extends ICompletionProposal> assignmentProposalList = null == method ? null
						: invokeMethod(method, proposalProvider, assignment, model, prefix, document, offset);

				if (null != assignmentProposalList) {
					completionProposalList.addAll(assignmentProposalList);
				}

			}
			else if (abstractElement instanceof RuleCall) {

				EObject model = null == ((CompositeNode) currentLeafNode.eContainer()).getElement() ? currentLeafNode
						.eContainer() : ((CompositeNode) currentLeafNode.eContainer()).getElement();

				List<? extends ICompletionProposal> ruleCallProposalList = this.proposalProvider.completeRuleCall(
						(RuleCall) abstractElement, model, prefix, document, offset);

				if (null != ruleCallProposalList) {
					completionProposalList.addAll(ruleCallProposalList);
				}

				AbstractRule calledRule = GrammarUtil.calledRule((RuleCall) abstractElement);

				if (calledRule.getType() != null) {

					TypeRef typeRef = calledRule.getType();

					Method method = findMethod(proposalProvider.getClass(), "complete"
							+ firstLetterCapitalized(typeRef.getAlias()) + firstLetterCapitalized(typeRef.getName()),
							RuleCall.class, model.getClass(), String.class, document.getClass(), int.class);

					Collection<? extends ICompletionProposal> proposalList = null == method ? null : invokeMethod(
							method, proposalProvider, abstractElement, model, prefix, document, offset);

					if (null != proposalList) {
						completionProposalList.addAll(proposalList);
					}

				}
			}
		}
		
		return completionProposalList;
	}

	private final Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
		Assert.isNotNull(clazz, "Class must not be null");
		Assert.isNotNull(name, "Method name must not be null");
		Method result = methodLookupMap.get(name);
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null && null == result) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (name.equals(method.getName())
						&& (paramTypes == null || equalOrAssignableTypes(method.getParameterTypes(), paramTypes))) {
					if (result == null
							|| equalOrAssignableTypes(result.getParameterTypes(), method.getParameterTypes())) {
						result = method;
						methodLookupMap.put(name, method);
					}
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

	private void handleReflectionException(Exception ex) {
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

	private void handleUnexpectedException(Throwable ex) {
		IllegalStateException isex = new IllegalStateException("Unexpected exception thrown");
		isex.initCause(ex);
		throw isex;
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

	private boolean equalOrAssignableTypes(Class<?>[] a, Class<?>[] a2) {
		if (a == a2) {
			return true;
		}

		if (a == null || a2 == null) {
			return false;
		}

		int length = a.length;

		if (a2.length != length) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			Class<?> o1 = a[i];
			Class<?> o2 = a2[i];

			if (!(o1 == null ? o2 == null : o1.equals(o2) || o1.isAssignableFrom(o2))) {
				return false;
			}
		}
		return true;
	}
	
	private final String firstLetterCapitalized(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	@SuppressWarnings("unchecked")
	private boolean isLinked(AbstractNode lastCompleteNode) {
		
		EObject semanticModel = NodeUtil.getNearestSemanticObject(lastCompleteNode);
				
		EReference eReference = getReference((CrossReference) lastCompleteNode.getGrammarElement(), semanticModel.eClass());
		
		if (eReference.getUpperBound() == 1 ) {
		
			if (null!=semanticModel.eGet(eReference)) {
				return true;
			}
		}
		else { 
			
			EcoreEList<EObject> ecoreEList = (EcoreEList<EObject>) semanticModel.eGet(eReference);
			
			for (Iterator<EObject> iterator = ecoreEList.iterator(); iterator.hasNext();) {
				
				EObject object = iterator.next();
				
				if (EcoreUtil2.getURIFragment(object).equalsIgnoreCase(((LeafNode)lastCompleteNode).getText())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private EReference getReference(CrossReference ref, EClass class1) {
		
		EList<EReference> references = class1.getEAllReferences();
		
		String feature = GrammarUtil.containingAssignment(ref).getFeature();
		
		for (EReference reference : references) {
			if (!reference.isContainment() && reference.getName().equals(feature))
				return reference;
		}
		return null;
	}


}
