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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JvmTypeChangeDispatcher extends AdapterImpl {

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
			if (listeners.isEmpty() || (notification.isTouch() && !isRemoveThis(notification))) 
				return;
			Iterator<Runnable> iterator = listeners.iterator();
			while(iterator.hasNext()) {
				iterator.next().run();
				iterator.remove();
			}
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
		listeners.add(runnable);
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return JvmTypeChangeDispatcher.class.equals(type);
	}
	
}
