/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.ILateInitialization;
import org.eclipse.xtext.util.INotificationDispatcher;
import org.eclipse.xtext.util.Notifications;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@Singleton
public class JvmModelAssociator implements IJvmModelAssociations, IJvmModelAssociator, INotificationDispatcher.INotificationListener {
	
	private final static Logger LOG = Logger.getLogger(JvmModelAssociator.class);
	
	@Inject
	private Notifications notifications;
	
	@Inject
	private ILateInitialization initialization;
	
	@Inject
	private INotificationDispatcher dispatcher;
	
	static class Adapter extends AdapterImpl {
		public ListMultimap<EObject, EObject> sourceToTargetMap = LinkedListMultimap.create();
		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}
	}
	
	protected Adapter getOrInstall(Resource resource) {
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resource.eAdapters(), Adapter.class);
		if (adapter == null) {
			adapter = new Adapter();
			resource.eAdapters().add(adapter);
			dispatcher.addListener(resource, this);
		}
		return adapter;
	}

	protected ListMultimap<EObject, EObject> sourceToTargetMap(Resource res) {
		if (res == null)
			throw new NullPointerException("resource");
		return getOrInstall(res).sourceToTargetMap;
	}

	protected Resource getResource(Notifier ctx) {
		Resource res = null;
		if (ctx instanceof EObject) {
			res = ((EObject) ctx).eResource();
		} else if (ctx instanceof Resource) {
			res = (Resource) ctx;
		} 
		if (res == null) {
			throw new IllegalArgumentException("Argument must either be an EObject (cotained in a resource) or a resource. But was "+ctx);
		}
		return res;
	}
	
	public void associate(EObject sourceElement, EObject jvmElement) {
		ListMultimap<EObject, EObject> map = sourceToTargetMap(sourceElement.eResource());
		map.put(sourceElement, jvmElement);
	}

	public void associatePrimary(EObject sourceElement, EObject jvmElement) {
		ListMultimap<EObject, EObject> map = sourceToTargetMap(sourceElement.eResource());
		if (map.containsKey(sourceElement)) {
			map.get(sourceElement).add(0, jvmElement);
		} else {
			map.put(sourceElement, jvmElement);
		}
	}

	public Set<EObject> getJvmElements(EObject sourceElement) {
		final ListMultimap<EObject, EObject> sourceToTargetMap = sourceToTargetMap(sourceElement.eResource());
		final List<EObject> elements = sourceToTargetMap.get(sourceElement);
		return newLinkedHashSet(elements);
	}

	public Set<EObject> getSourceElements(EObject jvmElement) {
		//If this turns out to be too slow we should improve the internal data structure :-)
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmElement.eResource());
		Set<EObject> sourceElements = newLinkedHashSet();
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmElement)
				sourceElements.add(entry.getKey());
		}
		return sourceElements;
	}

	public EObject getPrimarySourceElement(EObject jvmElement) {
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmElement.eResource());
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmElement)
				return entry.getKey();
		}
		return null;
	}

	//TODO get rid of this method
	public Set<EObject> getAssociatedElements(EObject jvmOrSourceElement) {
		ListMultimap<EObject,EObject> map = sourceToTargetMap(jvmOrSourceElement.eResource());
		Set<EObject> sourceElements = newLinkedHashSet();
		for (Map.Entry<EObject, EObject> entry : map.entries()) {
			if (entry.getValue() == jvmOrSourceElement) {
				sourceElements.add(entry.getKey());
			} else if (entry.getKey() == jvmOrSourceElement) {
				sourceElements.add(entry.getValue());
			}
		}
		return sourceElements;
	}

	private ThreadLocal<Boolean> isHandlingNotification = new ThreadLocal<Boolean>();
	
	public void notifyChanged(Notification notification) {
		if (notification.isTouch() || notifications.isDiagnosticChange(notification))
			return;
		if (isHandlingNotification.get() != null && isHandlingNotification.get().booleanValue())
			return;
		isHandlingNotification.set(Boolean.TRUE);
		try {
			if (LOG.isInfoEnabled()) {
				LOG.info("dicarding and updating inferred JvmModel");
			}
			Object notifier = notification.getNotifier();
			if (notifier instanceof Notifier) {
				Resource resource = getResource((Notifier) notifier);
				sourceToTargetMap(resource).clear();
				initialization.discardLateInitialization(resource.getContents());
				initialization.doLateInitialization(resource.getContents());
			}
		} finally {
			isHandlingNotification.set(Boolean.FALSE);
		}
	}

}

