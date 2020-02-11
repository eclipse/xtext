/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.common.types.xtext.JvmMemberInitializableResource;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.IDerivedStateComputer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.util.Maps2;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 * 
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noreference This class is not intended to be referenced by clients.
 * 
 * @since 2.7
 */
@Singleton
public class JvmModelAssociator implements IJvmModelAssociations, IJvmModelAssociator, ILogicalContainerProvider, IDerivedStateComputer {

	private final static Logger LOG = Logger.getLogger(JvmModelAssociator.class);

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	private JvmElementsProxifyingUnloader unloader;

	@Inject
	private Provider<IJvmModelInferrer> inferrerProvider;

	@Inject
	private JvmModelCompleter completer;
	
	@Inject
	private OperationCanceledManager operationCanceledManager;

	public void setCompleter(JvmModelCompleter completer) {
		this.completer = completer;
	}

	/**
	 * @since 2.8
	 * @noreference This method is not intended to be referenced by clients
	 */
	public void setInferrerProvider(Provider<IJvmModelInferrer> inferrerProvider) {
		this.inferrerProvider = inferrerProvider;
	}

	/**
	 * @noreference 
	 * @noextend This class is not intended to be subclassed by clients.
	 * @since 2.8
	 */
	public static class Adapter extends AdapterImpl {
		public Map<EObject, Set<EObject>> sourceToTargetMap = Maps2.newLinkedHashMapWithExpectedSize(40);
		public Map<EObject, Set<EObject>> targetToSourceMap = Maps2.newLinkedHashMapWithExpectedSize(40);
		public Map<EObject, JvmIdentifiableElement> logicalContainerMap = Maps2.newLinkedHashMapWithExpectedSize(40);

		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}
	}

	protected Adapter getOrInstall(Resource resource) {
		if (!(resource instanceof XtextResource)) {
			return new Adapter();
		}
		if (resource instanceof JvmMemberInitializableResource) {
			((JvmMemberInitializableResource) resource).ensureJvmMembersInitialized();
		}
		String resourceLanguageName = ((XtextResource) resource).getLanguageName();
		if (!languageName.equals(resourceLanguageName)){
			return new Adapter();
		}
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

	@Override
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

	@Override
	public JvmIdentifiableElement getLogicalContainer(XExpression context) {
		return getLogicalContainer(context, false);
	}

	@Override
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

	@Override
	public void associateLogicalContainer(XExpression logicalChild, JvmIdentifiableElement element) {
		if (logicalChild == null)
			return;
		final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(logicalChild.eResource());
		mapping.put(logicalChild, element);
	}

	@Override
	public void removeLogicalChildAssociation(JvmIdentifiableElement container) {
		if (container == null)
			return;
		final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(container.eResource());
		if (!mapping.isEmpty()) {
			Iterator<Entry<EObject, JvmIdentifiableElement>> iterator = mapping.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<EObject, JvmIdentifiableElement> next = iterator.next();
				if (next.getValue() == container) {
					iterator.remove();
				}
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

	@Override
	public void associate(EObject sourceElement, EObject jvmElement) {
		if (sourceElement != null) {
			checkLanguageResource(sourceElement.eResource());
			if (jvmElement != null && jvmElement.eResource() != null) {
				checkLanguageResource(jvmElement.eResource());
				checkSameResource(sourceElement.eResource(), jvmElement.eResource());
			}
			Resource resource = sourceElement.eResource();
			Map<EObject, Set<EObject>> sourceToTargetMap = sourceToTargetMap(resource);
			putIntoSmallSetMap(sourceElement, jvmElement, sourceToTargetMap);
			Map<EObject, Set<EObject>> targetToSourceMap = targetToSourceMap(resource);
			putIntoSmallSetMap(jvmElement, sourceElement, targetToSourceMap);
		}
	}

	protected void checkLanguageResource(Resource eResource) {
		if (!LOG.isDebugEnabled())
			return;
		if (eResource instanceof XtextResource) {
			String resourceLanguageName = ((XtextResource) eResource).getLanguageName();
			if (!resourceLanguageName.equals(languageName)) {
				IllegalArgumentException e = new IllegalArgumentException("Expected language "+languageName+", but was "+resourceLanguageName);
				LOG.error(e.getMessage(), e);
			}
		} else if (eResource == null) {
			IllegalArgumentException e = new IllegalArgumentException("You tried to associate an element to a source element, that was not contained in a resource.");
			LOG.error(e.getMessage(), e);
		} else {
			IllegalArgumentException e = new IllegalArgumentException("Expected instanceof XtextResource, but was "+eResource);
			LOG.error(e.getMessage(), e);
		}
	}
	
	protected void checkSameResource(Resource eResource, Resource eResource2) {
		if (!LOG.isDebugEnabled())
			return;
		if (eResource != eResource2 && eResource2 != null) {
			IllegalArgumentException e = new IllegalArgumentException("Cross resource associations are not supported (resources were "+eResource.getURI()+" and "+eResource2.getURI());
			LOG.debug(e.getMessage(), e);
		}
	}

	@Override
	public void associatePrimary(EObject sourceElement, EObject jvmElement) {
		if (sourceElement != null) {
			checkLanguageResource(sourceElement.eResource());
			if (jvmElement != null && jvmElement.eResource() != null) {
				checkLanguageResource(jvmElement.eResource());
				checkSameResource(sourceElement.eResource(), jvmElement.eResource());
			}
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

	@Override
	public Set<EObject> getJvmElements(EObject sourceElement) {
		if (sourceElement == null)
			return Collections.emptySet();
		Map<EObject, Set<EObject>> map = sourceToTargetMap(sourceElement.eResource());
		Set<EObject> result = map.get(sourceElement);
		if (result != null)
			return result;
		return Collections.emptySet();
	}

	@Override
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

	@Override
	public EObject getPrimarySourceElement(EObject jvmElement) {
		if (jvmElement == null)
			return null;
		Map<EObject, Set<EObject>> map = targetToSourceMap(jvmElement.eResource());
		Set<EObject> result = map.get(jvmElement);
		if (result != null)
			return result.iterator().next();
		return null;
	}

	@Override
	public void installDerivedState(final DerivedStateAwareResource resource, boolean preIndexingPhase) {
		if (resource.getContents().isEmpty())
			return;
		EObject eObject = resource.getContents().get(0);
		

		StoppedTask task = Stopwatches.forTask("JVM Model inference (JvmModelAssociator.installDerivedState)");
		task.start();
		JvmDeclaredTypeAcceptor acceptor = new JvmDeclaredTypeAcceptor(resource);
		try {
			IJvmModelInferrer inferrer = inferrerProvider.get();
			if (inferrer instanceof AbstractModelInferrer) {
				((AbstractModelInferrer) inferrer).setContext(resource);
			}
			inferrer.infer(eObject, acceptor, preIndexingPhase);
		} catch (RuntimeException e) {
			operationCanceledManager.propagateAsErrorIfCancelException(e);
			LOG.error("Error calling inferrer", e);
		}
		boolean lateJvmMemberInit = false;
		if (resource instanceof JvmMemberInitializableResource) {
			lateJvmMemberInit = ((JvmMemberInitializableResource) resource).hasJvmMemberInitializers();
		}
		if (!preIndexingPhase) {
			for (final Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>> initializer : acceptor.later) {
				Runnable initialization = new Runnable() {
					@Override
					public void run() {
						try {
							initializer.getValue().apply(initializer.getKey());
						} catch (RuntimeException e) {
							operationCanceledManager.propagateAsErrorIfCancelException(e);
							LOG.error("Error calling inferrer", e);
						}
					}
				};
				if (lateJvmMemberInit) {
					((JvmMemberInitializableResource) resource).addJvmMemberInitializer(initialization);
				} else {
					initialization.run();
				}
			}
		}
		task.stop();

		if (!preIndexingPhase) {
			Runnable completingRunnable = new Runnable() {
				@Override
				public void run() {
					for (EObject object : resource.getContents()) {
						if (object instanceof JvmIdentifiableElement) {
							JvmIdentifiableElement element = (JvmIdentifiableElement) object;
							completer.complete(element);
						}
					}
				}
			};
			if (lateJvmMemberInit) {
				((JvmMemberInitializableResource) resource).addJvmMemberInitializer(completingRunnable);
			} else {
				completingRunnable.run();
			}
		}
	}

	@Override
	public void discardDerivedState(DerivedStateAwareResource resource) {
		cleanAssociationState(resource);
	}

	public void cleanAssociationState(Resource resource) {
		checkLanguageResource(resource);
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

	@Override
	public void removeAssociation(EObject sourceElement, EObject jvmElement) {
		Preconditions.checkArgument(sourceElement != null, "source element cannot be null");
		Preconditions.checkArgument(jvmElement != null, "jvm element cannot be null");
		
		Resource resource = jvmElement.eResource();
		Preconditions.checkArgument(resource != null, "jvm element cannot be dangling");
		Preconditions.checkArgument(resource == sourceElement.eResource(), "source and jvm elements should belong to the same resource");
		checkLanguageResource(sourceElement.eResource());
		checkLanguageResource(jvmElement.eResource());
		checkSameResource(sourceElement.eResource(), jvmElement.eResource());
		
		Set<EObject> sources = targetToSourceMap(resource).get(jvmElement);
		if (sources != null && sources.remove(sourceElement)) {
			Set<EObject> targets = sourceToTargetMap(resource).get(sourceElement);
			targets.remove(jvmElement);
		}
	}

	@Override
	public void removeAllAssociation(EObject jvmElement) {
		Preconditions.checkArgument(jvmElement != null, "jvm element cannot be null");
		
		Resource resource = jvmElement.eResource();
		Preconditions.checkArgument(resource != null, "jvm element cannot be dangling");
		
		checkLanguageResource(resource);
		
		Set<EObject> sources = targetToSourceMap(resource).remove(jvmElement);
		if (sources == null || sources.isEmpty()) {
			return;
		}
		Map<EObject, Set<EObject>> sourceToTargetMap = sourceToTargetMap(resource);
		for (EObject sourceElement : sources) {
			Set<EObject> targets = sourceToTargetMap.get(sourceElement);
			targets.remove(jvmElement);
		}
		if (jvmElement instanceof JvmIdentifiableElement)
			removeLogicalChildAssociation((JvmIdentifiableElement) jvmElement);
	}

	@SuppressWarnings("deprecation")
	public static class JvmDeclaredTypeAcceptor implements IJvmDeclaredTypeAcceptor {
		public List<Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>>> later = Lists.newArrayList();
		private DerivedStateAwareResource resource;

		public JvmDeclaredTypeAcceptor(DerivedStateAwareResource resource) {
			this.resource = resource;
		}

		@Override
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

			@Override
			public void initializeLater(Procedure1<? super JvmDeclaredType> lateInitialization) {
				if (lateInitialization != null && type != null) {
					later.add(new Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>>(type, lateInitialization));
				}
			}

		}

		@Override
		@SuppressWarnings("unchecked")
		public <T extends JvmDeclaredType> void accept(T type, Procedure1<? super T> lateInitialization) {
			if (type != null && type.eContainer() == null)
				resource.getContents().add(type);
			if (lateInitialization != null && type != null) {
				later.add(new Pair<JvmDeclaredType, Procedure1<? super JvmDeclaredType>>(type, (Procedure1<? super JvmDeclaredType>) lateInitialization));
			}
		}

	}

	@Override
	public EObject getPrimaryJvmElement(EObject sourceElement) {
		Iterator<EObject> iterator = getJvmElements(sourceElement).iterator();
		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	@Override
	public boolean isPrimaryJvmElement(EObject jvmElement) {
		Set<EObject> sourceElements = getSourceElements(jvmElement);
		if (!sourceElements.isEmpty()) {
			EObject primaryJvmElement = getPrimaryJvmElement(sourceElements.iterator().next());
			return jvmElement.equals(primaryJvmElement);
		}
		return false;
	}

}
