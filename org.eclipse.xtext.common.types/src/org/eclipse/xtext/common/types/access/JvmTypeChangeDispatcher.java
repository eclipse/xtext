/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.NonRecursiveEContentAdapter;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JvmTypeChangeDispatcher extends AdapterImpl {

	private static final Logger LOG = Logger.getLogger(JvmTypeChangeDispatcher.class);
	
	public static JvmTypeChangeDispatcher findResourceChangeDispatcher(Notifier notifier) {
		JvmTypeChangeDispatcher result = (JvmTypeChangeDispatcher) EcoreUtil.getAdapter(
				notifier.eAdapters(), JvmTypeChangeDispatcher.class);
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
	protected class NotificationDispatcher extends NonRecursiveEContentAdapter {
		
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
			List<Runnable> localListeners = null;
			synchronized (listenerLock) {
				localListeners = listeners;
				if (localListeners.isEmpty()) {
					return;
				}
				listeners = Lists.newLinkedList();
			}
			Iterator<Runnable> iterator = localListeners.iterator();
			while(iterator.hasNext()) {
				Runnable runnable = iterator.next();
				if (runnable != null) {
					try {
						runnable.run();
					} catch(Exception e) {
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
			return notification.getEventType() == Notification.REMOVING_ADAPTER 
					&& notification.getOldValue() == this
					&& notification.getNotifier() == notifier;
		}
		
		@Override
		protected boolean resolve() {
			return false;
		}
		
	}
	
	private List<Runnable> listeners;
	
	private final Object listenerLock = new Object();
	
	public JvmTypeChangeDispatcher() {
		listeners = Lists.newLinkedList();
	}
	
	public void requestNotificationOnChange(Notifier notifier, Runnable runnable) {
		NotificationDispatcher result = (NotificationDispatcher) EcoreUtil.getAdapter(
				notifier.eAdapters(), NotificationDispatcher.class);
		if (result == null) {
			result = new NotificationDispatcher(notifier);
			notifier.eAdapters().add(result);
		}
		synchronized (listeners) {
			listeners.add(runnable);
		}
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return JvmTypeChangeDispatcher.class.equals(type);
	}
	
}
