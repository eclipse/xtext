/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

import com.google.inject.Inject;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 */
public class DefaultLinkingService implements ILinkingService {

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IValueConverterService valueConverter;
	
	protected IScope getScope(EObject context, EReference reference) {
		if (scopeProvider == null)
			throw new IllegalStateException("scopeProvider must not be null.");
		return scopeProvider.getScope(context, reference);
	}

	/**
	 * @return the first element returned from the injected {@link IScopeProvider} which matches the text of the passed {@link LeafNode}
	 */
	public List<EObject> getLinkedObjects(EObject context, EReference ref, AbstractNode node) throws IllegalNodeException {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final IScope scope = getScope(context, ref);
		final Iterator<IScopedElement> iterator = scope.getAllContents().iterator();
		final String s = getCrossRefNodeAsString(node);
		if (s != null) {
			while (iterator.hasNext()) {
				final IScopedElement element = iterator.next();
				if (s.equals(element.name()))
					return Collections.singletonList(element.element());
			}
		}
		return Collections.emptyList();
	}

	public String getCrossRefNodeAsString(AbstractNode node) throws IllegalNodeException {
		String convertMe = null;
		if (node instanceof LeafNode)
			convertMe = ((LeafNode) node).getText();
		else {
			StringBuilder builder = new StringBuilder(node.getLength());
			boolean hiddenSeen = false;
			for(LeafNode leaf: node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					if (hiddenSeen && builder.length() > 0)
						builder.append(' ');
					builder.append(leaf.getText());
					hiddenSeen = false;
				} else {
					hiddenSeen = true;
				}
			}
			convertMe = builder.toString();
		}
		try {
			String ruleCall = getRuleCallFrom(node.getGrammarElement());
			if (ruleCall == null)
				return null;
			Object result = valueConverter.toValue(convertMe, ruleCall, node); 
			return result != null ? result.toString() : null;
		} catch(ValueConverterException ex) {
			throw new IllegalNodeException(node, ex);
		}
	}
	
	private String getRuleCallFrom(EObject grammarElement) {
		AbstractRule rule = null;
		if (grammarElement instanceof CrossReference)
			rule = ((CrossReference) grammarElement).getRule();
		else if (grammarElement instanceof RuleCall)
			rule = ((RuleCall) grammarElement).getRule();
		return rule != null ? rule.getName() : null; 
	}
	
	/**
	 * @return the name of the first {@link IScopedElement} returned from the 
	 * injected {@link IScopeProvider} for the passed object {@link EObject}
	 */
	public String getLinkText(EObject object, EReference reference, EObject context) {
		String unconverted = getUnconvertedLinkText(object, reference, context);
		return getConvertedValue(unconverted, object, reference, context);
	}
	
	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		IScope scope = scopeProvider.getScope(context, reference);
		if (scope == null)
			return null;
		IScopedElement scopedElement = scope.getScopedElement(object);
		if (scopedElement == null)
			return null;
		return scopedElement.name();
	}

	protected String getConvertedValue(String name, EObject object, EReference reference, EObject context) {
		String ruleName = getRuleName(object, reference, context);
		if (ruleName == null)
			return name;
		return valueConverter.toString(name, ruleName);
	}

	// TODO find straightforward way to identify the called rule / to find the value param for value converter
	protected String getRuleName(EObject object, EReference reference, EObject context) {
		NodeAdapter adapter = NodeUtil.getNodeAdapter(context);
		if (adapter == null) {
			return null;
		}
		EObject contextGrammarElement = adapter.getParserNode().getGrammarElement();
		AbstractRule rule = null;
		if (contextGrammarElement instanceof AbstractRule)
			rule = (AbstractRule) contextGrammarElement;
		else if (contextGrammarElement instanceof RuleCall)
			rule = ((RuleCall) contextGrammarElement).getRule();
		if (rule != null) {
			List<CrossReference> xreferences = EcoreUtil2.getAllContentsOfType(rule, CrossReference.class);
			for(CrossReference xref: xreferences) {
				if (((EClass)xref.getType().getType()).isSuperTypeOf(object.eClass())) {
					Assignment assignment = GrammarUtil.containingAssignment(xref);
					if (assignment != null && assignment.getFeature().equals(reference.getName())) {
						return xref.getRule().getName();
					}
				}
			}
		}
		return null;
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	public IValueConverterService getValueConverter() {
		return valueConverter;
	}

	public void setValueConverter(IValueConverterService valueConverter) {
		this.valueConverter = valueConverter;
	}

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}
	
}
