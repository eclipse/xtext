/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeDelegatingScopeProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 */
public class DefaultLinkingService extends AbstractLinkingService {

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IValueConverterService valueConverter;

	@Inject
	private Provider<ImportedNamesAdapter> importedNamesAdapterProvider;

	protected IScope getScope(EObject context, EReference reference) {
		if (getScopeProvider() == null)
			throw new IllegalStateException("scopeProvider must not be null.");
		try {
			registerImportedNamesAdapter(context);
			return getScopeProvider().getScope(context, reference);
		} finally {
			unRegisterImportedNamesAdapter();
		}
	}

	private void unRegisterImportedNamesAdapter() {
		unRegisterImportedNamesAdapter(getScopeProvider());
	}
	
	private void unRegisterImportedNamesAdapter(IScopeProvider scopeProvider) {
		if (scopeProvider instanceof AbstractGlobalScopeDelegatingScopeProvider) {
			AbstractGlobalScopeDelegatingScopeProvider provider = (AbstractGlobalScopeDelegatingScopeProvider) scopeProvider;
			provider.setWrapper(null);
		} else if (scopeProvider instanceof AbstractDeclarativeScopeProvider) {
			AbstractDeclarativeScopeProvider declarativeScopeProvider = (AbstractDeclarativeScopeProvider) scopeProvider;
			unRegisterImportedNamesAdapter(declarativeScopeProvider.getDelegate());
		}
	}

	private void registerImportedNamesAdapter(EObject context) {
		registerImportedNamesAdapter(getScopeProvider(), context);
	}
	
	private void registerImportedNamesAdapter(IScopeProvider scopeProvider, EObject context) {
		if (scopeProvider instanceof AbstractGlobalScopeDelegatingScopeProvider) {
			AbstractGlobalScopeDelegatingScopeProvider provider = (AbstractGlobalScopeDelegatingScopeProvider) scopeProvider;
			ImportedNamesAdapter adapter = getImportedNamesAdapter(context);
			provider.setWrapper(adapter);
		} else if (scopeProvider instanceof AbstractDeclarativeScopeProvider) {
			AbstractDeclarativeScopeProvider declarativeScopeProvider = (AbstractDeclarativeScopeProvider) scopeProvider;
			registerImportedNamesAdapter(declarativeScopeProvider.getDelegate(), context);
		}
	}

	private ImportedNamesAdapter getImportedNamesAdapter(EObject context) {
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(context.eResource());
		if (adapter!=null)
			return adapter;
		ImportedNamesAdapter importedNamesAdapter = importedNamesAdapterProvider.get();
		context.eResource().eAdapters().add(importedNamesAdapter);
		return importedNamesAdapter;
	}

	/**
	 * @return the first element returned from the injected {@link IScopeProvider} which matches the text of the passed
	 *         {@link LeafNode}
	 */
	public List<EObject> getLinkedObjects(EObject context, EReference ref, AbstractNode node)
			throws IllegalNodeException {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final IScope scope = getScope(context, ref);
		final String s = getCrossRefNodeAsString(node);
		if (s != null) {
			IEObjectDescription eObjectDescription = scope.getContentByName(s);
			if (eObjectDescription != null)
				return Collections.singletonList(eObjectDescription.getEObjectOrProxy());
		}
		return Collections.emptyList();
	}

	public String getCrossRefNodeAsString(AbstractNode node) throws IllegalNodeException {
		return getCrossRefNodeAsString(node, true);
	}

	protected String getCrossRefNodeAsString(AbstractNode node, boolean convert) {
		String convertMe = null;
		if (node instanceof LeafNode)
			convertMe = ((LeafNode) node).getText();
		else {
			StringBuilder builder = new StringBuilder(node.getLength());
			boolean hiddenSeen = false;
			for (LeafNode leaf : node.getLeafNodes()) {
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

		if (!convert)
			return convertMe;

		try {
			String ruleName = getRuleNameFrom(node.getGrammarElement());
			if (ruleName == null)
				return convertMe;
			Object result = getValueConverter().toValue(convertMe, ruleName, node);
			return result != null ? result.toString() : null;
		} catch (ValueConverterException ex) {
			throw new IllegalNodeException(node, ex);
		}
	}

	/**
	 * @param grammarElement
	 *            may be any crossreferencable element, i.e. a keyword or a rulecall
	 */
	protected String getRuleNameFrom(EObject grammarElement) {
		if (!(grammarElement instanceof Keyword || grammarElement instanceof RuleCall || grammarElement instanceof CrossReference))
			throw new IllegalArgumentException("grammarElement is of type: '" + grammarElement.eClass().getName() + "'");
		AbstractRule rule = null;
		EObject elementToUse = grammarElement;
		if (grammarElement instanceof CrossReference)
			elementToUse = ((CrossReference) grammarElement).getTerminal();
		if (elementToUse instanceof RuleCall)
			rule = ((RuleCall) elementToUse).getRule();
		return rule != null ? rule.getName() : null;
	}

	/**
	 * @return the name of the first {@link IScopedElement} returned from the injected {@link IScopeProvider} for the
	 *         passed object {@link EObject}
	 */
	public String getLinkText(EObject object, EReference reference, EObject context) {
		AbstractNode node = getCrossReferenceNode(object, reference, context);
		if (node != null) {
			List<EObject> objects = getLinkedObjects(context, reference, node);
			if (!objects.isEmpty() && EcoreUtil.getURI(object).equals(EcoreUtil.getURI(objects.get(0)))) {
				return getCrossRefNodeAsString(node, false);
			}
		}
		String unconverted = getUnconvertedLinkText(object, reference, context);
		if (unconverted != null)
			return getConvertedValue(unconverted, object, reference, context);
		if (node != null) {
			return getCrossRefNodeAsString(node, false);
		}
		return null;
	}

	private AbstractNode getCrossReferenceNode(EObject object, EReference reference, EObject context) {
		List<AbstractNode> nodes = NodeUtil.findNodesForFeature(context, reference);
		if (!nodes.isEmpty()) {
			if (reference.isMany()) {
				int index = ((List<?>) context.eGet(reference, false)).indexOf(object);
				if (index >= 0 && index < nodes.size())
					return nodes.get(index);
			} else {
				return nodes.get(0);
			}
		}
		return null;
	}

	protected String getUnconvertedLinkText(EObject object, EReference reference, EObject context) {
		IScope scope = scopeProvider.getScope(context, reference);
		if (scope == null)
			return null;
		IEObjectDescription eObjectDescription = getScopedElement(scope, object);
		if (eObjectDescription != null) {
			return eObjectDescription.getName();
		}
		return null;
	}

	protected IEObjectDescription getScopedElement(IScope scope, EObject element) {
		Iterable<IEObjectDescription> allContents = scope.getAllContents();
		URI left = EcoreUtil.getURI(element);
		for (IEObjectDescription eObjectDescription : allContents) {
			URI right = EcoreUtil.getURI(eObjectDescription.getEObjectOrProxy());
			if (left.equals(right))
				return eObjectDescription;
		}
		return null;
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
			for (CrossReference xref : xreferences) {
				EClass type = (EClass) xref.getType().getClassifier();
				if (EcoreUtil2.isAssignableFrom(type,object.eClass())) {
					Assignment assignment = GrammarUtil.containingAssignment(xref);
					if (assignment != null && assignment.getFeature().equals(reference.getName())) {
						AbstractElement xrefTerminal = xref.getTerminal();
						if (xrefTerminal instanceof RuleCall)
							return ((RuleCall) xrefTerminal).getRule().getName();
					}
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected String getNodeModelLinkText(EObject object, EReference reference, EObject context) {
		List<AbstractNode> nodes = NodeUtil.findNodesForFeature(context, reference);
		if (!nodes.isEmpty()) {
			if (reference.isMany()) {
				int index = ((List<? extends EObject>) context.eGet(reference, false)).indexOf(object);
				if (index >= 0 && index < nodes.size())
					return getCrossRefNodeAsString(nodes.get(index), false);
			} else {
				return getCrossRefNodeAsString(nodes.get(0), false);
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
