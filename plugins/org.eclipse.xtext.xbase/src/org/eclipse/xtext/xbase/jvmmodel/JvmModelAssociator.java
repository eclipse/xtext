/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.IDerivedStateComputerExtension;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class JvmModelAssociator implements IJvmModelAssociations, IJvmModelAssociator, ILogicalContainerProvider, IDerivedStateComputer, IDerivedStateComputerExtension {

	private final static Logger LOG = Logger.getLogger(JvmModelAssociator.class);

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	private JvmElementsProxifyingUnloader unloader;

	@Inject
	private IJvmModelInferrer inferrer;

	@Inject
	private JvmModelCompleter completer;

	public void setCompleter(JvmModelCompleter completer) {
		this.completer = completer;
	}

	public void setInferrer(IJvmModelInferrer inferrer) {
		this.inferrer = inferrer;
	}

	protected static class Adapter extends AdapterImpl {

		public Map<EObject, Set<EObject>> sourceToTargetMap = Maps2.newLinkedHashMapWithExpectedSize(40);
		public Map<EObject, Set<EObject>> targetToSourceMap = Maps2.newLinkedHashMapWithExpectedSize(40);
		public Map<EObject, JvmIdentifiableElement> logicalContainerMap = Maps2.newLinkedHashMapWithExpectedSize(40);

		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}
	}

	protected Adapter getOrInstall(Resource resource) {
		if (!(resource instanceof XtextResource))
			return new Adapter();
		if (!languageName.equals(((XtextResource) resource).getLanguageName()))
			return new Adapter();
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resource.eAdapters(), Adapter.class);
		if (adapter == null) {
			adapter = new Adapter();
			resource.eAdapters().add(adapter);
		}
		return adapter;
	}

	protected Map<EObject, JvmIdentifiableElement> getLogicalContainerMapping(Resource resource) {
		return getOrInstall(resource).logicalContainerMap;
	}

	public XExpression getAssociatedExpression(JvmIdentifiableElement element) {
		if (element == null)
			return null;
		Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(element.eResource());
		for (Map.Entry<EObject, JvmIdentifiableElement> entry : mapping.entrySet()) {
			if (entry.getValue() == element && entry.getKey() instanceof XExpression) {
				return (XExpression) entry.getKey();
			}
		}
		return null;
	}

	public JvmIdentifiableElement getLogicalContainer(EObject context) {
		return getLogicalContainer(context, false);
	}

	public JvmIdentifiableElement getNearestLogicalContainer(EObject context) {
		return getLogicalContainer(context, true);
	}

	protected JvmIdentifiableElement getLogicalContainer(EObject object, boolean considerContainer) {
		if (object == null) {
			return null;
		}
		final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(object.eResource());
		do {
			if (mapping.containsKey(object)) {
				return mapping.get(object);
			}
			EObject container = object.eContainer();
			if (container == null) {
				return null;
			}
			if (!mapping.containsKey(container)) {
				Set<EObject> elements = getJvmElements(container);
				if (!elements.isEmpty()) {
					for (EObject eObject : elements) {
						if (eObject instanceof JvmIdentifiableElement) {
							return (JvmIdentifiableElement) eObject;
						}
					}
				}
			}
			object = container;
		} while (considerContainer);
		return null;
	}

	public void associateLogicalContainer(EObject logicalChild, JvmIdentifiableElement element) {
		if (logicalChild == null)
			return;
		final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(logicalChild.eResource());
		mapping.put(logicalChild, element);
	}

	public void removeLogicalChildAssociation(JvmIdentifiableElement container) {
		if (container == null)
			return;
		final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(container.eResource());
		Iterator<Entry<EObject, JvmIdentifiableElement>> iterator = mapping.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<EObject, JvmIdentifiableElement> next = iterator.next();
			if (next.getValue() == container) {
				iterator.remove();
			}
		}
	}

	protected Map<EObject, Set<EObject>> sourceToTargetMap(Resource res) {
		return getOrInstall(res).sourceToTargetMap;
	}

	protected Map<EObject, Set<EObject>> targetToSourceMap(Resource res) {
		return getOrInstall(res).targetToSourceMap;
	}

	protected Resource getResource(Notifier ctx) {
		Resource res = null;
		if (ctx instanceof EObject) {
			res = ((EObject) ctx).eResource();
		} else if (ctx instanceof Resource) {
			res = (Resource) ctx;
		}
		if (res == null) {
			throw new IllegalArgumentException("Argument must either be an EObject (cotained in a resource) or a resource. But was " + ctx);
		}
		return res;
	}

	public void associate(EObject sourceElement, EObject jvmElement) {
		if (sourceElement != null) {
			Resource resource = sourceElement.eResource();
			Map<EObject, Set<EObject>> sourceToTargetMap = sourceToTargetMap(resource);
			putIntoSmallSetMap(sourceElement, jvmElement, sourceToTargetMap);
			Map<EObject, Set<EObject>> targetToSourceMap = targetToSourceMap(resource);
			putIntoSmallSetMap(jvmElement, sourceElement, targetToSourceMap);
		}
	}

	public void associatePrimary(EObject sourceElement, EObject jvmElement) {
		if (sourceElement != null) {
			Resource resource = sourceElement.eResource();
			Map<EObject, Set<EObject>> sourceToTargetMap = sourceToTargetMap(resource);
			putIntoSmallSetMap(sourceElement, jvmElement, sourceToTargetMap, true);
			Map<EObject, Set<EObject>> targetToSourceMap = targetToSourceMap(resource);
			putIntoSmallSetMap(jvmElement, sourceElement, targetToSourceMap, true);
		}
	}

	public static <K, V> void putIntoSmallSetMap(K key, V value, Map<? super K, Set<V>> map) {
		Set<V> set = map.get(key);
		if (set == null) {
			set = new ListBasedSet<V>();
			map.put(key, set);
		}
		set.add(value);
	}

	public static <K, V> void putIntoSmallSetMap(K key, V value, Map<? super K, Set<V>> map, boolean head) {
		if (head) {
			Set<V> list = map.get(key);
			if (list == null) {
				list = new ListBasedSet<V>();
				map.put(key, list);
			}
			list.remove(value);
			((ListBasedSet<V>) list).elements.addFirst(value);
		} else {
			putIntoSmallSetMap(key, value, map);
		}
	}

	protected static class ListBasedSet<E> extends AbstractSet<E> {

		private LinkedList<E> elements = Lists.newLinkedList();

		@Override
		public boolean add(E e) {
			if (elements.contains(e))
				return false;
			return elements.add(e);
		}

		@Override
		public Iterator<E> iterator() {
			return elements.iterator();
		}

		@Override
		public int size() {
			return elements.size();
		}

	}

	public Set<EObject> getJvmElements(EObject sourceElement) {
		if (sourceElement == null)
			return Collections.emptySet();
		Map<EObject, Set<EObject>> map = sourceToTargetMap(sourceElement.eResource());
		Set<EObject> result = map.get(sourceElement);
		if (result != null)
			return result;
		return Collections.emptySet();
	}

	public Set<EObject> getSourceElements(EObject jvmElement) {
		if (jvmElement == null)
			return Collections.emptySet();
		//If this turns out to be too slow we should improve the internal data structure :-)
		Map<EObject, Set<EObject>> map = targetToSourceMap(jvmElement.eResource());
		Set<EObject> result = map.get(jvmElement);
		if (result != null)
			return result;
		return Collections.emptySet();
	}

	public EObject getPrimarySourceElement(EObject jvmElement) {
		if (jvmElement == null)
			return null;
		Map<EObject, Set<EObject>> map = targetToSourceMap(jvmElement.eResource());
		Set<EObject> result = map.get(jvmElement);
		if (result != null)
			return result.iterator().next();
		return null;
	}
	
	static class AfterIndexingInitialization extends AdapterImpl {
		Runnable init;
		public static void install(Resource resource, final Runnable runnable) {
			if (findAdapter(resource) != null) {
				throw new IllegalStateException("initialization adapter already installed");
			}
			AfterIndexingInitialization adapter = new AfterIndexingInitialization();
			adapter.init = runnable;
			resource.eAdapters().add(adapter);
		}
		
		public static AfterIndexingInitialization findAdapter(Resource resource) {
			for (org.eclipse.emf.common.notify.Adapter a : resource.eAdapters()) {
				if (a instanceof AfterIndexingInitialization) {
					return (AfterIndexingInitialization)a;
				}
			}
			return null;
		}
		
		public static void remove(Resource resource, org.eclipse.emf.common.notify.Adapter adapter) {
			resource.eAdapters().remove(adapter);
		}

	}

	@SuppressWarnings("deprecation")
	public void installDerivedState(final DerivedStateAwareResource resource, boolean preIndexingPhase) {
		if (resource.getContents().isEmpty())
			return;
		EObject eObject = resource.getContents().get(0);

		StoppedTask task = Stopwatches.forTask("primary JVM Model inference (JvmModelAssociator.installDerivedState)");
		task.start();
		AfterIndexingInitialization adapter = AfterIndexingInitialization.findAdapter(resource);
		if (adapter != null) {
			if (preIndexingPhase) {
				throw new IllegalStateException("During preindexing no initialization adapter should be attached to a resource! uri : "+resource.getURI());
			}
			adapter.init.run();
			AfterIndexingInitialization.remove(resource, adapter);
			return;
		}
		final JvmDeclaredTypeAcceptor acceptor = new JvmDeclaredTypeAcceptor(resource);
		try {
			if (inferrer instanceof AbstractModelInferrer) {
				LOG.error("The class "+inferrer.getClass().getName()+" is using old API. It should implement IJvmModelInferrer#infer(EObject, IJvmDeclaredTypeAcceptor). This compatibility support will be removed in the next version.");
				((AbstractModelInferrer)inferrer).infer(eObject, acceptor, preIndexingPhase);
			} else {
				inferrer.infer(eObject, acceptor);
			}
		} catch (RuntimeException e) {
			LOG.error("Error calling inferrer", e);
		}
		Runnable runnable = new Runnable() {

			public void run() {
				for (Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>> initializer : acceptor.later) {
					try {
						initializer.getValue().apply(initializer.getKey());
					} catch (RuntimeException e) {
						LOG.error("Error calling inferrer", e);
					}
				}
				for (Runnable runnable : acceptor.initializers) {
					try {
						runnable.run();
					} catch (RuntimeException e) {
						LOG.error("Error calling inferrer", e);
					}
				}
				for (EObject object : resource.getContents()) {
					if (object instanceof JvmIdentifiableElement) {
						JvmIdentifiableElement element = (JvmIdentifiableElement) object;
						completer.complete(element);
					}
				}
			}};
		if (preIndexingPhase && !(inferrer instanceof AbstractModelInferrer)) {
			AfterIndexingInitialization.install(resource, runnable);
		} else if (!preIndexingPhase) {
			runnable.run();
		}
		task.stop();
	}

	public void discardDerivedState(DerivedStateAwareResource resource) {
		AfterIndexingInitialization adapter = AfterIndexingInitialization.findAdapter(resource);
		if (adapter != null) {
			AfterIndexingInitialization.remove(resource, adapter);
		}
		cleanAssociationState(resource);
	}

	public void cleanAssociationState(Resource resource) {
		List<EObject> derived = Lists.newArrayList();
		EList<EObject> resourcesContentsList = resource.getContents();
		for (int i = 1; i < resourcesContentsList.size(); i++) {
			EObject eObject = resourcesContentsList.get(i);
			unloader.unloadRoot(eObject);
			derived.add(eObject);
		}
		resourcesContentsList.removeAll(derived);
		sourceToTargetMap(resource).clear();
		targetToSourceMap(resource).clear();
		getLogicalContainerMapping(resource).clear();
	}

	public void removeAssociation(EObject sourceElement, EObject jvmElement) {
		Preconditions.checkArgument(sourceElement != null, "source element cannot be null");
		Preconditions.checkArgument(jvmElement != null, "jvm element cannot be null");
		
		Resource resource = jvmElement.eResource();
		Preconditions.checkArgument(resource != null, "jvm element cannot be dangling");
		Preconditions.checkArgument(resource == sourceElement.eResource(), "source and jvm elements should belong to the same resource");
		
		Set<EObject> sources = targetToSourceMap(resource).get(jvmElement);
		if (sources != null && sources.remove(sourceElement)) {
			Set<EObject> targets = sourceToTargetMap(resource).get(sourceElement);
			targets.remove(sourceElement);
		}
	}

	public void removeAllAssociation(EObject jvmElement) {
		Preconditions.checkArgument(jvmElement != null, "jvm element cannot be null");
		
		Resource resource = jvmElement.eResource();
		Preconditions.checkArgument(resource != null, "jvm element cannot be dangling");
		
		Set<EObject> sources = targetToSourceMap(resource).remove(jvmElement);
		if (sources == null || sources.isEmpty()) {
			return;
		}
		Map<EObject, Set<EObject>> sourceToTargetMap = sourceToTargetMap(resource);
		for (EObject sourceElement : sources) {
			Set<EObject> targets = sourceToTargetMap.get(sourceElement);
			targets.remove(jvmElement);
		}
	}

	public static class JvmDeclaredTypeAcceptor implements IJvmDeclaredTypeAcceptor {
		public List<Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>>> later = Lists.newArrayList();
		public List<Runnable> initializers = Lists.newArrayList();
		private DerivedStateAwareResource resource;

		public JvmDeclaredTypeAcceptor(DerivedStateAwareResource resource) {
			this.resource = resource;
		}

		@SuppressWarnings("unchecked")
		public <T extends JvmDeclaredType> IPostIndexingInitializing<T> accept(T type) {
			if (type != null && type.eContainer() == null)
				resource.getContents().add(type);
			return (IPostIndexingInitializing<T>) new JvmPostIndexingInitializing(type);
		}

		private class JvmPostIndexingInitializing implements IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<JvmDeclaredType> {

			private JvmDeclaredType type;

			public JvmPostIndexingInitializing(JvmDeclaredType type) {
				this.type = type;
			}

			public void initializeLater(Procedure1<? super JvmDeclaredType> lateInitialization) {
				if (lateInitialization != null && type != null) {
					later.add(new Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>>(type, lateInitialization));
				}
			}
		}

		public void runAfterIndexing(Runnable runnable) {
			initializers.add(runnable);
		}

	}

	public EObject getPrimaryJvmElement(EObject sourceElement) {
		Iterator<EObject> iterator = getJvmElements(sourceElement).iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	public boolean isPrimaryJvmElement(EObject jvmElement) {
		Set<EObject> sourceElements = getSourceElements(jvmElement);
		if (!sourceElements.isEmpty()) {
			EObject primaryJvmElement = getPrimaryJvmElement(sourceElements.iterator().next());
			return jvmElement.equals(primaryJvmElement);
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public boolean canReconcileState() {
		return !(inferrer instanceof AbstractModelInferrer);
	}

}
