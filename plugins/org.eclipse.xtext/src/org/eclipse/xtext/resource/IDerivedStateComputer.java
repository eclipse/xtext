/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;


/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public interface IDerivedStateComputer {
	
	/**
	 * callback to do modifications when and before getContents is called the first time on a resource.
	 */
	void installDerivedState(DerivedStateAwareResource resource);
	
	/**
	 * is called when the resource is updated. Clients should revert all the changes they did during {@link #installDerivedState(DerivedStateSupportingResource)}
	 */
	void discardDerivedState(DerivedStateAwareResource resource);
}
