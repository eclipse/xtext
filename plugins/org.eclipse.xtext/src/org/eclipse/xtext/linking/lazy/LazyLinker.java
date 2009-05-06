/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.impl.AbstractCleaningLinker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticProducer;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LazyLinker extends AbstractCleaningLinker {

	@Inject
	private LazyURIEncoder encoder;
	
	@Inject
	private Registry registry;

	@Override
	protected void doLinkModel(EObject model, IDiagnosticConsumer consumer) {
		LinkingDiagnosticProducer producer = new LinkingDiagnosticProducer(consumer);
		installProxies(model, producer);
		TreeIterator<EObject> iterator = model.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			installProxies(eObject, producer);
		}
	}
	
	protected void installProxies(EObject obj, IDiagnosticProducer producer) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(obj);
		if (nodeAdapter == null)
			return;
		final CompositeNode node = nodeAdapter.getParserNode();
		EList<AbstractNode> children = node.getChildren();
		for (AbstractNode abstractNode : children) {
			if (abstractNode.getGrammarElement() instanceof CrossReference) {
				CrossReference ref = (CrossReference) abstractNode.getGrammarElement();
				producer.setNode(abstractNode);
				final EReference eRef = GrammarUtil.getReference(ref, obj.eClass());
				if (eRef == null) {
					throw new IllegalStateException("Couldn't find EReference for crossreference " + ref);
				}
				createAndSetProxy(obj, abstractNode, eRef);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void createAndSetProxy(EObject obj, AbstractNode abstractNode, EReference eRef) {
		URI uri = obj.eResource().getURI();
		URI encodedLink = uri.appendFragment(getEncoder().encode(obj, eRef, abstractNode));
		EClass eType = eRef.getEReferenceType();
		eType = findInstantiableCompatible(eType);
		EObject proxy = eType.getEPackage().getEFactoryInstance().create(eType);
		((InternalEObject) proxy).eSetProxyURI(encodedLink);
		if (eRef.isMany()) {
			((BasicEList<EObject>) obj.eGet(eRef, false)).addUnique(proxy);
		} else {
			obj.eSet(eRef, proxy);
		}
	}

	private EClass findInstantiableCompatible(EClass eType) {
		if (!isInstantiatableSubType(eType,eType)) {
			// check local Package
			EPackage ePackage = eType.getEPackage();
			EClass eClass = findSubTypeInEPackage(ePackage, eType);
			if (eClass!=null)
				return eClass;
			// check registry
			for (String nsURI : getRegistry().keySet()) {
				if (nsURI.equals(ePackage.getNsURI())) // avoid double check of local EPackage
					continue;
				EClass class1 = findSubTypeInEPackage(getRegistry().getEPackage(nsURI),eType);
				if (class1!=null)
					return class1;
			}
		}
		return eType;
	}

	private EClass findSubTypeInEPackage(EPackage ePackage, EClass superType) {
		EList<EClassifier> classifiers = ePackage.getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			if (eClassifier instanceof EClass) {
				EClass c = (EClass) eClassifier;
				if (isInstantiatableSubType(c, superType))
					return c;
			}
		}
		return null;
	}

	private boolean isInstantiatableSubType(EClass c, EClass superType) {
		return !c.isAbstract() && !c.isInterface() && superType.isSuperTypeOf(c);
	}

	public LazyURIEncoder getEncoder() {
		return encoder;
	}

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	public void setEncoder(LazyURIEncoder encoder) {
		this.encoder = encoder;
	}

}
