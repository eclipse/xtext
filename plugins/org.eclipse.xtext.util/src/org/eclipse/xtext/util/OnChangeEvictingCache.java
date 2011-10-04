/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OnChangeEvictingCache implements IResourceScopeCache {
	
	private static final Logger log = Logger.getLogger(OnChangeEvictingCache.class);
	
	public static interface Listener {
		void onEvict(CacheAdapter cache);
	}
	
	public void clear(Resource resource) {
		getOrCreate(resource).clearValues();
	}
	
	public <T> T get(Object key, Resource resource, Provider<T> provider) {
		if(resource == null) {
			return provider.get();
		}
		CacheAdapter adapter = getOrCreate(resource);
		T element = adapter.<T>get(key);
		if (element==null) {
			element = provider.get();
			cacheMiss(adapter);
			adapter.set(key, element);
		} else {
			cacheHit(adapter);
		}
		return element;
	}
	
	/**
	 * @since 2.1
	 */
	protected void cacheMiss(CacheAdapter adapter) {
		adapter.cacheMiss();
	}
	
	/**
	 * @since 2.1
	 */
	protected void cacheHit(CacheAdapter adapter) {
		adapter.cacheHit();
	}
	
	public CacheAdapter getOrCreate(Resource resource) {
		CacheAdapter adapter = (CacheAdapter) EcoreUtil.getAdapter(resource.eAdapters(), CacheAdapter.class);
		if (adapter == null) {
			adapter = new CacheAdapter();
			resource.eAdapters().add(adapter);
			adapter.setResource(resource);
		}
		return adapter;
	}
	
	public <Result, Param extends Resource> Result execWithoutCacheClear(Param resource, IUnitOfWork<Result, Param> transaction) throws WrappedException {
		CacheAdapter cacheAdapter = getOrCreate(resource);
		boolean wasIgnoreNotifications = cacheAdapter.isIgnoreNotifications();
		try {
			cacheAdapter.setIgnoreNotifications(true);
			return transaction.exec(resource);
		} catch (Exception e) {
			throw new WrappedException(e);
		} finally {
			cacheAdapter.setIgnoreNotifications(wasIgnoreNotifications);
		}
	}

	public static class CacheAdapter extends EContentAdapter {
		
		private static final Object NULL = new Object();
		
		private Map<Object, Object> values = new ConcurrentHashMap<Object, Object>(500);

		private Collection<Listener> listeners = newLinkedHashSet();
		
		private volatile boolean ignoreNotifications = false;
		
		private volatile boolean empty = true;
		
		private Resource resource;
		
		private int misses = 0;
		private int hits = 0;

		public void set(Object name, Object value) {
			empty = false;
			if (value != null)
				this.values.put(name, value);
			else
				this.values.put(name, NULL);
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
		public <T> T get(Object name) {
			if (empty)
				return null;
			T result = (T) this.values.get(name);
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
			if (!ignoreNotifications && isSemanticStateChange(notification)) {
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
					log.debug(String.format("Clear %d cache entries for resource %s after %d hits and %d misses (quota: %d%%)", 
							values.size(), resource.getURI().lastSegment(), hits, misses, hits + misses != 0 ? hits * 100 / (hits + misses) : 0));
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
		
		public void setIgnoreNotifications(boolean ignoreNotifications) {
			this.ignoreNotifications = ignoreNotifications;
		}

		public boolean isIgnoreNotifications() {
			return ignoreNotifications;
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
