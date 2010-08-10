/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.lazy;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.AbstractEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.impl.AbstractCleaningLinker;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticProducer;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.util.EcoreGenericsUtil;
import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.eclipse.xtext.util.SimpleCache;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Knut Wannheden
 */
public class LazyLinker extends AbstractCleaningLinker {

	private static final Logger log = Logger.getLogger(LazyLinker.class);
	
	private SimpleCache<EClass, EClass> instantiableSubTypes = new SimpleCache<EClass, EClass>(
			new Function<EClass, EClass>() {
				public EClass apply(EClass from) {
					return findInstantiableCompatible(from);
				}
			});

	@Inject
	private LazyURIEncoder encoder;

	@Inject
	private Registry registry;

	@Inject
	private EcoreGenericsUtil ecoreGenericsUtil;
	
	@Inject
	private IGrammarAccess grammarAccess;
	
	@Inject
	private OnChangeEvictingCache cache;

	@Override
	protected void doLinkModel(final EObject model, IDiagnosticConsumer consumer) {
		final Multimap<EStructuralFeature.Setting, AbstractNode> settingsToLink = Multimaps.newArrayListMultimap();
		final LinkingDiagnosticProducer producer = new LinkingDiagnosticProducer(consumer);
		cache.execWithoutCacheClear(model.eResource(), new IUnitOfWork.Void<Resource>() {
			@Override
			public void process(Resource state) throws Exception {
				installProxies(model, producer, settingsToLink);
				TreeIterator<EObject> iterator = model.eAllContents();
				while (iterator.hasNext()) {
					EObject eObject = iterator.next();
					installProxies(eObject, producer, settingsToLink);
				}
			}
		});
		installQueuedLinks(settingsToLink);
	}

	protected void installProxies(EObject obj, IDiagnosticProducer producer,
			Multimap<EStructuralFeature.Setting, AbstractNode> settingsToLink) {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(obj);
		if (nodeAdapter == null)
			return;
		final CompositeNode node = nodeAdapter.getParserNode();
		installProxies(obj, producer, settingsToLink, node);
	}

	private void installProxies(EObject obj, IDiagnosticProducer producer,
			Multimap<EStructuralFeature.Setting, AbstractNode> settingsToLink, CompositeNode node) {
		EList<AbstractNode> children = node.getChildren();
		for (AbstractNode abstractNode : children) {
			if (abstractNode.getGrammarElement() instanceof CrossReference) {
				CrossReference ref = (CrossReference) abstractNode.getGrammarElement();
				producer.setNode(abstractNode);
				final EReference eRef = GrammarUtil.getReference(ref, obj.eClass());
				if (eRef == null) {
					throw new IllegalStateException("Couldn't find EReference for crossreference " + ref);
				}
				if (!eRef.isResolveProxies() /*|| eRef.getEOpposite() != null see https://bugs.eclipse.org/bugs/show_bug.cgi?id=282486*/) {
					final EStructuralFeature.Setting setting = ((InternalEObject) obj).eSetting(eRef);
					settingsToLink.put(new SettingDelegate(setting), abstractNode);
				} else {
					createAndSetProxy(obj, abstractNode, eRef);
				}
			}
		}
		if (shouldCheckParentNode(node)) {
			installProxies(obj, producer, settingsToLink, node.getParent());
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
			} else {
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
			((AbstractEList<EObject>) obj.eGet(eRef, false)).addUnique(proxy);
		} else {
			obj.eSet(eRef, proxy);
		}
	}

	protected EObject createProxy(EObject obj, AbstractNode abstractNode, EReference eRef) {
		if (obj.eResource() == null)
			throw new IllegalStateException("object must be contained in a resource");
		final URI uri = obj.eResource().getURI();
		final URI encodedLink = uri.appendFragment(encoder.encode(obj, eRef, abstractNode));
		EClass referenceType = ecoreGenericsUtil.getReferenceType(eRef, obj.eClass());
		EClass instantiableType = instantiableSubTypes.get(referenceType);
		final EObject proxy = EcoreUtil.create(instantiableType);
		((InternalEObject) proxy).eSetProxyURI(encodedLink);
		return proxy;
	}

	protected EClass findInstantiableCompatible(EClass eType) {
		if (!isInstantiatableSubType(eType, eType)) {
			// check local Package
			EPackage ePackage = eType.getEPackage();
			EClass eClass = findSubTypeInEPackage(ePackage, eType);
			if (eClass != null)
				return eClass;
			return globalFindInstantiableCompatible(eType);
		}
		return eType;
	}

	protected EClass globalFindInstantiableCompatible(EClass eType) {
		Set<String> visitedPackages = Sets.newHashSet(eType.getEPackage().getNsURI());
		for(AbstractMetamodelDeclaration metamodel: GrammarUtil.allMetamodelDeclarations(grammarAccess.getGrammar())) {
			if (visitedPackages.add(metamodel.getEPackage().getNsURI())) {
				EClass result = findSubTypeInEPackage(metamodel.getEPackage(), eType);
				if (result != null)
					return result;
			}
		}
		log.warn("Traversing EPackage registry to find instantiable subtype for '" + eType.getName() + "'");
		log.warn("You may override LazyLinker#globalFindInstantiableCompatible(..) to prevent this.");
		for (String nsURI : getRegisteredNsUris()) {
			if (visitedPackages.add(nsURI)) {
				try {
					EClass result = findSubTypeInEPackage(getRegistry().getEPackage(nsURI), eType);
					if (result != null)
						return result;
				} catch(WrappedException ex) {
					log.error("Error when loading EPackage '" + nsURI + "'");
					log.error("You may override LazyLinker#globalFindInstantiableCompatible(..) to prevent this.");
					log.error("Error when loading EPackage '" + nsURI + "'", ex);
				}
			}
		}
		throw new IllegalStateException(
				"Could not find an instantiable subtype for type: '" + eType.getName() + "' (" + eType.getEPackage().getNsURI() + ").");
	}

	private List<String> getRegisteredNsUris() {
		Set<String> keySet = getRegistry().keySet();
		// copy to avoid ConcurrentModificationException while iterating over the EPackageMap
		List<String> copy = Lists.newArrayList(keySet);
		return copy;
	}

	protected EClass findSubTypeInEPackage(EPackage ePackage, EClass superType) {
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
		return !c.isAbstract() && !c.isInterface() && EcoreUtil2.isAssignableFrom(superType, c);
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

	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	public IGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}

}
