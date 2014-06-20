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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
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
		if (isClearAllReferencesRequired(resource))
			clearAllReferences(model);
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

	protected void clearAllReferences(EObject model) {
		clearReferences(model);
		final Iterator<EObject> iter = EcoreUtil2.getAllNonDerivedContents(model, true);
		while (iter.hasNext())
			clearReferences(iter.next());
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
			if (parent != null && !parent.hasDirectSemanticElement()) {
				Assignment assignment = GrammarUtil.containingAssignment(grammarElement);
				return assignment == null;
			}
		}
		return false;
	}

}
