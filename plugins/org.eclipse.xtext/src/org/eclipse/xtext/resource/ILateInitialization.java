/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public interface ILateInitialization {
	
	/**
	 * callback to do modifications when and before getContents is called the first time on a resource.
	 * {@link org.eclipse.emf.ecore.resource.Resource#eDeliver()} will be set to <code>false</code> during initialization,
	 * such that modifications on the list don't fire any {@link org.eclipse.emf.common.notify.Notification}s.
	 */
	void doLateInitialization(EList<EObject> resourcesContentsList);
	
	/**
	 * is called when the resource is updated. Clients should revert all the changes they did during {@link #doLateInitialization(EList)}
	 */
	void discardLateInitialization(EList<EObject> resourcesContentsList);
}
