/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
@ImplementedBy(OnChangeEvictingCache.class)
public interface INotificationDispatcher {
	
	void addListener(Resource resource, INotificationListener listener);
	void removeListener(Resource resource, INotificationListener listener);

	static interface INotificationListener {
		
		/**
		 * Notifies that a change to some feature has occurred.
		 * @param notification a description of the change.
		 */
		void notifyChanged(Notification notification);
	}
}
