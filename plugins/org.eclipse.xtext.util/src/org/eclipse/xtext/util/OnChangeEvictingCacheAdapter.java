/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Sets;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class OnChangeEvictingCacheAdapter extends EContentAdapter {
	
	public interface Listener {
		void onEvict(OnChangeEvictingCacheAdapter cache);
	}
	
	public static <T> T get(Object key, Notifier cache, Provider<T> provider) {
		OnChangeEvictingCacheAdapter adapter = OnChangeEvictingCacheAdapter.getOrCreate(cache);
		T element = adapter.<T>get(key);
		if (element==null) {
			element = provider.get();
			adapter.set(key, element);
		}
		return element;
	}
	
	public static OnChangeEvictingCacheAdapter getOrCreate(Notifier notifier) {
		OnChangeEvictingCacheAdapter adapter = (OnChangeEvictingCacheAdapter) EcoreUtil.getAdapter(notifier.eAdapters(), OnChangeEvictingCacheAdapter.class);
		if (adapter == null) {
			adapter = new OnChangeEvictingCacheAdapter();
			notifier.eAdapters().add(adapter);
		}
		return adapter;
	}

	private Map<Object, Object> values = new HashMap<Object, Object>();

	private Collection<Listener> listeners = Sets.newHashSet();
	
	public void set(Object name, Object value) {
		this.values.put(name, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Object name) {
		return (T) this.values.get(name);
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
		if (isSemanticStateChange(notification)) {
			values.clear();
			Iterator<Listener> iter = listeners.iterator();
			while(iter.hasNext()) {
				Listener next = iter.next();
				iter.remove();
				next.onEvict(this);
			}
		}
	}

	private boolean isSemanticStateChange(Notification notification) {
		return !notification.isTouch() && !(notification.getNewValue() instanceof Diagnostic) ;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == getClass();
	}
}
