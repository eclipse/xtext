/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Linker extends AbstractCleaningLinker {

	private static Logger log = Logger.getLogger(Linker.class);

	@Inject
	private ILinkingService linkingService;

	public void ensureLinked(EObject obj, IDiagnosticProducer producer) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(obj);
		if (nodeAdapter == null)
			return;
		final CompositeNode node = nodeAdapter.getParserNode();
		EList<AbstractNode> children = node.getChildren();
		Set<EReference> handledReferences = new HashSet<EReference>();
		for (AbstractNode abstractNode : children) {
			if (abstractNode.getGrammarElement() instanceof CrossReference) {
				CrossReference ref = (CrossReference) abstractNode.getGrammarElement();
				producer.setNode(abstractNode);
				ensureIsLinked(obj, abstractNode, ref, handledReferences, producer);
			}
		}
		producer.setNode(node);
		setDefaultValues(obj, handledReferences, producer);
	}

	protected IDiagnosticProducer createDiagnosticProducer(IDiagnosticConsumer consumer) {
		return new LinkingDiagnosticProducer(consumer);
	}

	private void setDefaultValues(EObject obj, Set<EReference> references, IDiagnosticProducer producer) {
		for(EReference ref: obj.eClass().getEAllReferences())
			if (canSetDefaultValues(ref) && !references.contains(ref) && !obj.eIsSet(ref) && !ref.isDerived()) {
				setDefaultValue(obj, ref, producer);
			}
	}

	protected boolean canSetDefaultValues(EReference ref) {
		return !ref.isContainment() && !ref.isContainer() && ref.isChangeable();
	}

	protected final void setDefaultValue(EObject obj, EReference ref, IDiagnosticProducer producer) {
		producer.setTarget(obj, ref);
		setDefaultValueImpl(obj, ref, producer);
	}

	protected void setDefaultValueImpl(EObject obj, EReference ref, IDiagnosticProducer producer) {
		// may be overridden by clients
	}

	protected void beforeEnsureIsLinked(EObject obj, EReference ref, IDiagnosticProducer producer) {
		// may be overridden by clients
	}

	@SuppressWarnings("unchecked")
	protected void ensureIsLinked(EObject obj, AbstractNode node, CrossReference ref,
			Set<EReference> handledReferences, IDiagnosticProducer producer) {
		final EReference eRef = GrammarUtil.getReference(ref, obj.eClass());
		if (eRef == null) {
			producer.addDiagnostic("Cannot find reference " + ref);
			return;
		}
		handledReferences.add(eRef);
		beforeEnsureIsLinked(obj, eRef, producer);
		producer.setTarget(obj, eRef);
		try {
			final List<EObject> links = getLinkedObject(obj, eRef, node);
			if (links == null || links.isEmpty()) {
				if (!isNullValidResult(obj, eRef, node))
					producer.addDiagnostic("Cannot resolve reference to '" + node.serialize() + "'");
				return;
			}

			if (eRef.getUpperBound() >= 0 && links.size() > eRef.getUpperBound()) {
				producer.addDiagnostic("Too many matches for reference to '"
						+ node.serialize() + "'. Feature " + eRef.getName() + " can only hold " + eRef.getUpperBound()
						+ " reference" + (eRef.getUpperBound() != 1 ? "s" : "") + " but found " + links.size() + " candidates" +
						(links.size()!=1 ? "s" : ""));
				return;
			}

			if (eRef.getUpperBound() == 1) {
				obj.eSet(eRef, links.get(0));
			}
			else { // eRef.getUpperBound() == -1 ||
				// eRef.getUpperBound() < links.size
				// TODO extract and check weather equals or identity is used by list
				final List<EObject> list = (List<EObject>) obj.eGet(eRef);
				if (links.size() > 1 && eRef.isUnique() && (list instanceof BasicEList)) {
					final Set<EObject> addUs = new LinkedHashSet<EObject>(links);
					//addUs.removeAll(list); // removeAll calls most likely list.contains() which is rather slow
					for (int i = 0; i < list.size(); i++)
						addUs.remove(list.get(i));
					if (!((BasicEList) list).addAllUnique(addUs))
						producer.addDiagnostic("Cannot refer to '" + node.serialize() + "' more than once.");
				}
				else
					if (!list.addAll(links))
						producer.addDiagnostic("Cannot refer to '" + node.serialize() + "' more than once.");
			}
		} catch (IllegalNodeException e) {
			producer.addDiagnostic(e.getMessage());
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
		}
	}

	protected List<EObject> getLinkedObject(EObject obj, EReference eRef, AbstractNode node) throws IllegalNodeException {
		return linkingService.getLinkedObjects(obj, eRef, node);
	}

	protected boolean isNullValidResult(EObject obj, EReference eRef, AbstractNode node) {
		return false;
	}

	public ILinkingService getLinkingService() {
		return linkingService;
	}

	public void setLinkingService(ILinkingService linkingService) {
		this.linkingService = linkingService;
	}

	@Override
	protected void doLinkModel(EObject model, IDiagnosticConsumer consumer) {
		final IDiagnosticProducer producer = createDiagnosticProducer(consumer);
		ensureModelLinked(model, producer);
	}

	protected void ensureModelLinked(EObject model, final IDiagnosticProducer producer) {
		ensureLinked(model, producer);
		final Iterator<EObject> allContents = model.eAllContents();
		while (allContents.hasNext())
			ensureLinked(allContents.next(), producer);
	}

}
