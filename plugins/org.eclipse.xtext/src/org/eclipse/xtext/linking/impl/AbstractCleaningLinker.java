/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

/**
 * @author Sebastian Zarnekow
 */
public abstract class AbstractCleaningLinker extends AbstractLinker {

	private static final Logger log = Logger.getLogger(AbstractCleaningLinker.class);
	
	@Override
	public void linkModel(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		StoppedTask task = Stopwatches.forTask("installing proxies (AbstractCleaningLinker.linkModel)");
		task.start();
		boolean debug = log.isDebugEnabled();
		long time = System.currentTimeMillis();
		beforeModelLinked(model, diagnosticsConsumer);
		if (debug) {
			long now = System.currentTimeMillis();
			log.debug("beforeModelLinked took: " + (now - time) + "ms");
			time = now;
		}
		doLinkModel(model, diagnosticsConsumer);
		if (debug) {
			long now = System.currentTimeMillis();
			log.debug("doLinkModel took: " + (now - time) + "ms");
			time = now;
		}
		afterModelLinked(model, diagnosticsConsumer);
		if (debug) {
			long now = System.currentTimeMillis();
			log.debug("afterModelLinked took: " + (now - time) + "ms");
			time = now;
		}
		task.stop();
	}

	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		// clients may override
	}

	protected abstract void doLinkModel(EObject model, IDiagnosticConsumer diagnosticsConsumer);

	protected void beforeModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		Resource resource = model.eResource();
		if (resource instanceof LazyLinkingResource) {
			((LazyLinkingResource) resource).clearLazyProxyInformation();
		}
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(resource);
		if (adapter!=null)
			adapter.clear();
	}
	
	/**
	 * @since 2.7
	 */
	protected boolean isClearAllReferencesRequired(Resource resource) {
		return true;
	}

	/**
	 * @deprecated no longer called, override {@link #clearReferences(EObject)} instead
	 */
	@Deprecated
	protected void clearAllReferences(EObject model) {
		final Iterator<EObject> iter = getAllLinkableContents(model);
		while (iter.hasNext())
			clearReferences(iter.next());
	}

	/**
	 * @since 2.7
	 */
	@SuppressWarnings("serial")
	protected TreeIterator<EObject> getAllLinkableContents(EObject model) {
		return new AbstractTreeIterator<EObject>(model) {
			@Override
			public Iterator<EObject> getChildren(Object object) {
				return ((EObject) object).eContents().iterator();
			}
		};
	}

	protected void clearReferences(EObject obj) {
		for (EReference ref : obj.eClass().getEAllReferences())
			clearReference(obj, ref);
	}

	protected void clearReference(EObject obj, EReference ref) {
		if (!ref.isContainment() && !ref.isContainer() && !ref.isDerived() && ref.isChangeable() && !ref.isTransient())
			obj.eUnset(ref);
	}

	/**
	 * @return true, if the parent node could contain cross references to the same semantic element as the given node.
	 */
	protected boolean shouldCheckParentNode(INode node) {
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement instanceof AbstractElement) {
			ICompositeNode parent = node.getParent();
			if (parent != null) {
				if (!parent.hasDirectSemanticElement()) {
					Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
					return assignment == null;
				}
				if (grammarElement instanceof Action) {
					ParserRule rule = (ParserRule) GrammarUtil.containingRule(grammarElement);
					if (rule.isFragment()) {
						return parent.getGrammarElement() instanceof RuleCall;
					}
				}
			}
		}
		return false;
	}

}
