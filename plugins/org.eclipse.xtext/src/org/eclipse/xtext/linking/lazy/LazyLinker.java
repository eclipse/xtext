/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.util.EcoreUtil;
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

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Knut Wannheden
 */
public class LazyLinker extends AbstractCleaningLinker {

	@Inject
	private LazyURIEncoder encoder;

	@Inject
	private Registry registry;

	@Override
	protected void doLinkModel(EObject model, IDiagnosticConsumer consumer) {
		Multimap<EStructuralFeature.Setting, AbstractNode> settingsToLink = Multimaps.newArrayListMultimap();
		LinkingDiagnosticProducer producer = new LinkingDiagnosticProducer(consumer);
		installProxies(model, producer, settingsToLink);
		TreeIterator<EObject> iterator = model.eAllContents();
		while (iterator.hasNext()) {
			EObject eObject = iterator.next();
			installProxies(eObject, producer, settingsToLink);
		}
		installQueuedLinks(settingsToLink);
		settingsToLink = null;
	}

	protected void installProxies(EObject obj, IDiagnosticProducer producer, Multimap<EStructuralFeature.Setting, AbstractNode> settingsToLink) {
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
				if (!eRef.isResolveProxies() || eRef.getEOpposite() != null) {
					final EStructuralFeature.Setting setting = ((InternalEObject) obj).eSetting(eRef);
					settingsToLink.put(new SettingDelegate(setting), abstractNode);
				}
				else {
					createAndSetProxy(obj, abstractNode, eRef);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void installQueuedLinks(Multimap<EStructuralFeature.Setting, AbstractNode> settingsToLink) {
		for (EStructuralFeature.Setting setting : settingsToLink.keySet()) {
			final EObject eObject = setting.getEObject();
			final EReference eRef = (EReference) setting.getEStructuralFeature();
			final Collection<AbstractNode> nodes = settingsToLink.get(setting);
			if (setting.getEStructuralFeature().isMany()) {
				EList<EObject> list = (EList<EObject>) setting.get(false);
				for (AbstractNode node : nodes) {
					final EObject proxy = createProxy(eObject, node, eRef);
					list.add(EcoreUtil.resolve(proxy, eObject));
				}
			}
			else {
				final AbstractNode node = nodes.iterator().next();
				final EObject proxy = createProxy(eObject, node, eRef);
				setting.set(EcoreUtil.resolve(proxy, eObject));
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void createAndSetProxy(EObject obj, AbstractNode abstractNode, EReference eRef) {
		final EObject proxy = createProxy(obj, abstractNode, eRef);
		if (eRef.isMany()) {
			((BasicEList<EObject>) obj.eGet(eRef, false)).addUnique(proxy);
		}
		else {
			obj.eSet(eRef, proxy);
		}
	}

	protected EObject createProxy(EObject obj, AbstractNode abstractNode, EReference eRef) {
		final URI uri = obj.eResource().getURI();
		final URI encodedLink = uri.appendFragment(encoder.encode(obj, eRef, abstractNode));
		EClass eType = eRef.getEReferenceType();
		eType = findInstantiableCompatible(eType);
		final EObject proxy = EcoreUtil.create(eType);
		((InternalEObject) proxy).eSetProxyURI(encodedLink);
		return proxy;
	}

	private EClass findInstantiableCompatible(EClass eType) {
		if (!isInstantiatableSubType(eType, eType)) {
			// check local Package
			EPackage ePackage = eType.getEPackage();
			EClass eClass = findSubTypeInEPackage(ePackage, eType);
			if (eClass != null)
				return eClass;
			// check registry
			for (String nsURI : getRegistry().keySet()) {
				if (nsURI.equals(ePackage.getNsURI())) // avoid double check of local EPackage
					continue;
				EClass class1 = findSubTypeInEPackage(getRegistry().getEPackage(nsURI), eType);
				if (class1 != null)
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
