/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * A cache implementation that stores its values in the scope of a resource.
 * The values will be discarded as soon as the contents of the resource changes semantically.
 * Clients may override this behavior for certain transactions by means of {@link #execWithoutCacheClear(Resource, IUnitOfWork)}
 * or {@link #execWithTemporaryCaching(Resource, IUnitOfWork)}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Singleton
public class OnChangeEvictingCache implements IResourceScopeCache {
	
	private static final Logger log = Logger.getLogger(OnChangeEvictingCache.class);
	
	/**
	 * A simple cache listener. It will be notified if the cache is cleared. 
	 * The notification will only occur once. Listeners that are interested in subsequent notifications 
	 * have to re-add themselves.  
	 */
	public static interface Listener {
		void onEvict(CacheAdapter cache);
	}
	
	/**
	 * Clears the cache of the given resource. 
	 */
	@Override
	public void clear(Resource resource) {
		getOrCreate(resource).clearValues();
	}
	
	/**
	 * Try to obtain the value that is cached for the given key in the given resource.
	 * If no value is cached, the provider is used to compute it and store it afterwards.
	 * @param resource the resource. If it is <code>null</code>, the provider will be used to compute the value.
	 * @param key the cache key. May not be <code>null</code>.
	 * @param provider the strategy to compute the value if necessary. May not be <code>null</code>.
	 */
	@Override
	public <T> T get(Object key, Resource resource, Provider<T> provider) {
		if(resource == null) {
			return provider.get();
		}
		CacheAdapter adapter = getOrCreate(resource);
		T element = adapter.<T>internalGet(key);
		if (element==null) {
			element = provider.get();
			cacheMiss(adapter);
			adapter.set(key, element);
		} else {
			cacheHit(adapter);
		}
		if (element == CacheAdapter.NULL) {
			return null;
		}
		return element;
	}
	
	/**
	 * Announce a cache miss for the internal statistics of the adapter.
	 * @since 2.1
	 */
	protected void cacheMiss(CacheAdapter adapter) {
		adapter.cacheMiss();
	}
	
	/**
	 * Announce a cache hit for the internal statistics of the adapter.
	 * @since 2.1
	 */
	protected void cacheHit(CacheAdapter adapter) {
		adapter.cacheHit();
	}
	
	/**
	 * Returns the cache adapter that is associated with the resource. The lifecycle of the cache
	 * is strongly connected to the resource and its change notifications. Will not return <code>null</code>.
	 * @param resource the resource. May not be <code>null</code>.
	 * @return the cache adapter for the given resource. Never <code>null</code>.
	 */
	public CacheAdapter getOrCreate(Resource resource) {
		// ask for the list of adapters twice in order to avoid the usage of a
		//  potentially stale list because of a race of several involved threads
		resource.eAdapters();
		final List<Adapter> adapters = resource.eAdapters();
		
		CacheAdapter adapter;
		synchronized (adapters) {			
			adapter = (CacheAdapter) EcoreUtil.getAdapter(adapters, CacheAdapter.class);
			if (adapter == null) {
				adapter = new CacheAdapter();
				adapters.add(adapter);
				adapter.setResource(resource);
			}
		}
		return adapter;
	}
	
	/**
	 * The transaction will be executed. While it is running, any semantic state change
	 * in the given resource will be ignored and the cache will not be cleared.
	 */
	public <Result, Param extends Resource> Result execWithoutCacheClear(Param resource, IUnitOfWork<Result, Param> transaction) throws WrappedException {
		CacheAdapter cacheAdapter = getOrCreate(resource);
		try {
			cacheAdapter.ignoreNotifications();
			return transaction.exec(resource);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			cacheAdapter.listenToNotifications();
		}
	}
	
	/**
	 * The transaction will be executed with caching enabled. However, all newly cached values will be discarded as soon
	 * as the transaction is over.
	 * @since 2.1
	 */
	public <Result, Param extends Resource> Result execWithTemporaryCaching(Param resource, IUnitOfWork<Result, Param> transaction) throws WrappedException {
		CacheAdapter cacheAdapter = getOrCreate(resource);
		IgnoreValuesMemento memento = cacheAdapter.ignoreNewValues();
		try {
			return transaction.exec(resource);
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			memento.done();
		}
	}
	
	private static class IgnoreValuesMemento {
		private final List<Object> keys = Lists.newArrayList();
		private final IgnoreValuesMemento previous;
		private final CacheAdapter adapter;
		
		private IgnoreValuesMemento(IgnoreValuesMemento previous, CacheAdapter adapter) {
			this.previous = previous;
			this.adapter = adapter;
			this.adapter.ignoreValuesMemento = this;
		}
		
		private void done() {
			if (log.isDebugEnabled()) {
				log.debug(String.format("Discarding %d temporary cache entries", keys.size()));
			}
			adapter.values.keySet().removeAll(keys);
			adapter.ignoreValuesMemento = previous;
		}

		private void storeKey(Object name) {
			this.keys.add(name);
		}
	}

	public static class CacheAdapter extends EContentAdapter {
		
		private static final Object NULL = new Object();
		
		private final Map<Object, Object> values = new ConcurrentHashMap<Object, Object>(500);

		private final Collection<Listener> listeners = Sets.newLinkedHashSet();
		
		@Deprecated
		private volatile boolean ignoreNotifications = false;
		
		private final AtomicInteger ignoreNotificationCounter = new AtomicInteger(0);
		
		private volatile boolean empty = true;
		
		private volatile IgnoreValuesMemento ignoreValuesMemento = null;
		
		private Resource resource;
		
		private int misses = 0;
		private int hits = 0;

		public void set(Object name, Object value) {
			empty = false;
			if (value != null)
				this.values.put(name, value);
			else
				this.values.put(name, NULL);
			IgnoreValuesMemento ignoreValuesMemento = this.ignoreValuesMemento;
			if (ignoreValuesMemento != null) {
				ignoreValuesMemento.storeKey(name);
			}
		}

		/**
		 * @since 2.1
		 */
		public void listenToNotifications() {
			if (ignoreNotificationCounter.decrementAndGet() < 0) {
				throw new IllegalStateException("ignoreNotificationCounter may not be less than zero");
			}
		}

		/**
		 * @since 2.1
		 */
		public void ignoreNotifications() {
			ignoreNotificationCounter.incrementAndGet();
		}

		/**
		 * @since 2.1
		 */
		protected void cacheMiss() {
			misses++;
		}
		
		/**
		 * @since 2.1
		 */
		protected void cacheHit() {
			hits++;
		}
		
		@SuppressWarnings("unchecked")
		private <T> T internalGet(Object name) {
			if (empty)
				return null;
			return (T) this.values.get(name);
			
		}
		
		public <T> T get(Object name) {
			T result = internalGet(name);
			if (result != NULL)
				return result;
			return null;
		}
		
		public void addCacheListener(Listener listener) {
			this.listeners.add(listener);
		}

		public void removeCacheListener(Listener listener) {
			this.listeners.remove(listener);
		}
		
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (ignoreNotificationCounter.get() == 0 && !ignoreNotifications && isSemanticStateChange(notification)) {
				clearValues();
				Iterator<Listener> iter = listeners.iterator();
				while(iter.hasNext()) {
					Listener next = iter.next();
					iter.remove();
					next.onEvict(this);
				}
			}
		}

		public void clearValues() {
			if (!empty) {
				if (log.isDebugEnabled()) {
					String lastSegment = resource != null && resource.getURI() != null ? resource.getURI().lastSegment() : "null";
					log.debug(String.format("Clear %d cache entries for resource %s after %d hits and %d misses (quota: %d%%)", 
							values.size(), lastSegment, hits, misses, hits + misses != 0 ? hits * 100 / (hits + misses) : 0));
				}
				values.clear();
				empty = true;
				misses = 0;
				hits = 0;
			}
		}

		private boolean isSemanticStateChange(Notification notification) {
			return !notification.isTouch() && !(notification.getNewValue() instanceof Diagnostic) && !(notification.getOldValue() instanceof Diagnostic);
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == getClass();
		}
		
		/**
		 * @deprecated use {@link #ignoreNotifications()} and {@link #listenToNotifications()} instead.
		 */
		@Deprecated
		public void setIgnoreNotifications(boolean ignoreNotifications) {
			this.ignoreNotifications = ignoreNotifications;
		}

		public boolean isIgnoreNotifications() {
			return ignoreNotificationCounter.get() > 0 || ignoreNotifications;
		}
		
		private IgnoreValuesMemento ignoreNewValues() {
			return new IgnoreValuesMemento(ignoreValuesMemento, this);
		}
		
		@Override
		protected boolean resolve() {
			return false;
		}

		/**
		 * @since 2.1
		 */
		protected Resource getResource() {
			return resource;
		}

		/**
		 * @since 2.1
		 */
		protected void setResource(Resource resource) {
			this.resource = resource;
		}
	}

}
