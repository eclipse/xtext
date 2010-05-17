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
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext;
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

	@Inject
	private ILinkingDiagnosticMessageProvider.Extended diagnosticMessageProvider;

	public void ensureLinked(EObject obj, IDiagnosticProducer producer) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(obj);
		if (nodeAdapter == null)
			return;
		final CompositeNode node = nodeAdapter.getParserNode();
		Set<EReference> handledReferences = new HashSet<EReference>();
		ensureLinked(obj, producer, node, handledReferences);
		producer.setNode(node);
		setDefaultValues(obj, handledReferences, producer);
	}

	private void ensureLinked(EObject obj, IDiagnosticProducer producer, CompositeNode node,
			Set<EReference> handledReferences) {
		EList<AbstractNode> children = node.getChildren();
		for (AbstractNode abstractNode : children) {
			if (abstractNode.getGrammarElement() instanceof CrossReference) {
				CrossReference ref = (CrossReference) abstractNode.getGrammarElement();
				producer.setNode(abstractNode);
				ensureIsLinked(obj, abstractNode, ref, handledReferences, producer);
			}
		}
		if (shouldCheckParentNode(node)) {
			ensureLinked(obj, producer, node.getParent(), handledReferences);
		}
	}

	protected IDiagnosticProducer createDiagnosticProducer(IDiagnosticConsumer consumer) {
		return new LinkingDiagnosticProducer(consumer);
	}

	private void setDefaultValues(EObject obj, Set<EReference> references, IDiagnosticProducer producer) {
		for (EReference ref : obj.eClass().getEAllReferences())
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void ensureIsLinked(EObject obj, AbstractNode node, CrossReference ref,
			Set<EReference> handledReferences, IDiagnosticProducer producer) {
		final EReference eRef = GrammarUtil.getReference(ref, obj.eClass());
		if (eRef == null) {
			ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context = createDiagnosticContext(obj, eRef,
					node);
			DiagnosticMessage message = diagnosticMessageProvider.getIllegalCrossReferenceMessage(context, ref);
			producer.addDiagnostic(message);
			return;
		}
		handledReferences.add(eRef);
		beforeEnsureIsLinked(obj, eRef, producer);
		producer.setTarget(obj, eRef);
		try {
			final List<EObject> links = getLinkedObject(obj, eRef, node);
			if (links == null || links.isEmpty()) {
				if (!isNullValidResult(obj, eRef, node)) {
					ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context = createDiagnosticContext(obj,
							eRef, node);
					DiagnosticMessage message = diagnosticMessageProvider.getUnresolvedProxyMessage(context);
					producer.addDiagnostic(message);
				}
				return;
			}

			if (eRef.getUpperBound() >= 0 && links.size() > eRef.getUpperBound()) {
				ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context = createDiagnosticContext(obj,
						eRef, node);
				DiagnosticMessage message = diagnosticMessageProvider.getViolatedBoundsConstraintMessage(context,
						links.size());
				producer.addDiagnostic(message);
				return;
			}

			if (eRef.getUpperBound() == 1) {
				obj.eSet(eRef, links.get(0));
			} else { // eRef.getUpperBound() == -1 ||
						// eRef.getUpperBound() < links.size
						// TODO extract and check weather equals or identity is used by list
				final List<EObject> list = (List<EObject>) obj.eGet(eRef);
				if (links.size() > 1 && eRef.isUnique() && (list instanceof BasicEList)) {
					final Set<EObject> addUs = new LinkedHashSet<EObject>(links);
					//addUs.removeAll(list); // removeAll calls most likely list.contains() which is rather slow
					for (int i = 0; i < list.size(); i++)
						addUs.remove(list.get(i));
					if (!((BasicEList) list).addAllUnique(addUs)) {
						ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context = createDiagnosticContext(
								obj, eRef, node);
						DiagnosticMessage message = diagnosticMessageProvider.getViolatedBoundsConstraintMessage(
								context, links.size());
						producer.addDiagnostic(message);
					}
				} else if (!list.addAll(links)) {
					ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context = createDiagnosticContext(obj,
							eRef, node);
					DiagnosticMessage message = diagnosticMessageProvider.getViolatedBoundsConstraintMessage(context,
							links.size());
					producer.addDiagnostic(message);
				}
			}
		} catch (IllegalNodeException e) {
			ILinkingDiagnosticMessageProvider.ILinkingDiagnosticContext context = createDiagnosticContext(obj, eRef,
					node);
			DiagnosticMessage message = diagnosticMessageProvider.getIllegalNodeMessage(context, e);
			producer.addDiagnostic(message);
			if (log.isDebugEnabled()) {
				log.debug(e.getMessage(), e);
			}
		}
	}

	protected static class LinkingDiagnosticContext implements ILinkingDiagnosticContext {

		private final EObject obj;
		private final EReference eRef;
		private final AbstractNode node;

		protected LinkingDiagnosticContext(EObject obj, EReference eRef, AbstractNode node) {
			this.obj = obj;
			this.eRef = eRef;
			this.node = node;
		}

		public EObject getContext() {
			return obj;
		}

		public EReference getReference() {
			return eRef;
		}

		public String getLinkText() {
			String serialize = node.serialize();
			if (serialize != null)
				return serialize.trim();
			return null;
		}

	}

	protected ILinkingDiagnosticContext createDiagnosticContext(EObject obj, EReference eRef, AbstractNode node) {
		return new LinkingDiagnosticContext(obj, eRef, node);
	}

	protected List<EObject> getLinkedObject(EObject obj, EReference eRef, AbstractNode node)
			throws IllegalNodeException {
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

	public void setDiagnosticMessageProvider(ILinkingDiagnosticMessageProvider.Extended diagnosticMessageProvider) {
		this.diagnosticMessageProvider = diagnosticMessageProvider;
	}

	public ILinkingDiagnosticMessageProvider.Extended getDiagnosticMessageProvider() {
		return diagnosticMessageProvider;
	}

}
