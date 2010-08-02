/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.OnChangeEvictingCache;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ModifyableCache extends OnChangeEvictingCache {

	@Override
	public ModifyableCacheAdapter getOrCreate(Notifier notifier) {
		ModifyableCacheAdapter adapter = (ModifyableCacheAdapter) EcoreUtil.getAdapter(notifier.eAdapters(), ModifyableCacheAdapter.class);
		if (adapter == null) {
			adapter = new ModifyableCacheAdapter();
			notifier.eAdapters().add(adapter);
		}
		return adapter;
	}
	
	public static class ModifyableCacheAdapter extends CacheAdapter {
		
		private boolean ignoreNotifications = false;

		public void setIgnoreNotifications(boolean ignoreNotifications) {
			this.ignoreNotifications = ignoreNotifications;
		}

		public boolean isIgnoreNotifications() {
			return ignoreNotifications;
		}
		
		@Override
		public void notifyChanged(Notification notification) {
			if (ignoreNotifications)
				return;
			super.notifyChanged(notification);
		}
		
	}
}
