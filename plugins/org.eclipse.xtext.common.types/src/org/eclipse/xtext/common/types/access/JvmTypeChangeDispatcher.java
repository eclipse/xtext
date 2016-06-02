/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JvmTypeChangeDispatcher extends AdapterImpl {

	private static final Logger LOG = Logger.getLogger(JvmTypeChangeDispatcher.class);

	public static JvmTypeChangeDispatcher findResourceChangeDispatcher(Notifier notifier) {
		JvmTypeChangeDispatcher result = (JvmTypeChangeDispatcher) EcoreUtil.getAdapter(notifier.eAdapters(),
				JvmTypeChangeDispatcher.class);
		if (result == null) {
			result = new JvmTypeChangeDispatcher();
			notifier.eAdapters().add(result);
		}
		return result;
	}

	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	protected class NotificationDispatcher extends EContentAdapter {

		private Notifier notifier;

		public NotificationDispatcher(Notifier notifier) {
			this.notifier = notifier;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return NotificationDispatcher.class.equals(type);
		}

		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.isTouch() && !isRemoveThis(notification))
				return;
			Map<Notifier, List<Runnable>> localListeners = null;
			synchronized (listenerLock) {
				localListeners = listeners;
				if (localListeners.isEmpty()) {
					return;
				}
				listeners = Maps.newLinkedHashMap();
			}
			Iterator<Runnable> iterator = IterableExtensions.flatten(localListeners.values()).iterator();
			while (iterator.hasNext()) {
				Runnable runnable = iterator.next();
				if (runnable != null) {
					try {
						runnable.run();
					} catch (Exception e) {
						LOG.error(e.getMessage(), e);
					}
				}
			}
		}

		@Override
		protected void addAdapter(Notifier notifier) {
			if (notifier instanceof TypeResource) {
				IMirror mirror = ((TypeResource) notifier).getMirror();
				if (mirror instanceof IMirrorExtension) {
					if (((IMirrorExtension) mirror).isSealed())
						return;
				}
			}
			notifier.eAdapters().add(this);
		}

		protected boolean isRemoveThis(Notification notification) {
			return notification.getEventType() == Notification.REMOVING_ADAPTER && notification.getOldValue() == this
					&& notification.getNotifier() == notifier;
		}

		@Override
		protected boolean resolve() {
			return false;
		}

	}

	private Map<Notifier, List<Runnable>> listeners;

	private final Object listenerLock = new Object();

	public JvmTypeChangeDispatcher() {
		listeners = Maps.newLinkedHashMap();
	}

	public void requestNotificationOnChange(Notifier notifier, Runnable runnable) {
		NotificationDispatcher result = (NotificationDispatcher) EcoreUtil.getAdapter(notifier.eAdapters(), NotificationDispatcher.class);
		if (result == null) {
			result = new NotificationDispatcher(notifier);
			notifier.eAdapters().add(result);
		}

		synchronized (listeners) {
			if(!listeners.containsKey(notifier)) {
				listeners.put(notifier, Lists.<Runnable>newLinkedList());
			}
			listeners.get(notifier).add(runnable);
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return JvmTypeChangeDispatcher.class.equals(type);
	}

	public void removeListenersFromResource(Resource resource) {
		URI toBeRemovedURI = resource.getURI();
		if (toBeRemovedURI != null) {
			synchronized (listeners) {
				Iterator<Entry<Notifier, List<Runnable>>> iter = listeners.entrySet().iterator();
				while (iter.hasNext()) {
					Entry<Notifier, List<Runnable>> entry = iter.next();
					if (toBeRemovedURI.equals(getNotifierURI(entry.getKey()))) {
						iter.remove();
					}
				}
				
			}
		}
	}
	
	private URI getNotifierURI(Notifier notifier) {
		if (notifier instanceof EObject) {
			return ((EObject) notifier).eResource().getURI();
		} else if (notifier instanceof Resource) {
			return ((Resource) notifier).getURI();
		}
		return null;
	}

}
