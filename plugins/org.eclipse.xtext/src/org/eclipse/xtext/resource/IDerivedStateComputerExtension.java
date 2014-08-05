/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.7
 */
public interface IDerivedStateComputerExtension {

	/**
	 * This method is called to check whether this implementation of {@link IDerivedStateComputer} is capable of
	 * reconciling state derived during indexing. If this extension interface is not implemeted or this method returns false, all state will 
	 * be discarded during indexing {@link IDerivedStateComputer#discardDerivedState(DerivedStateAwareResource)} and recomputed afterwards.
	 * 
	 * @return whether this implementation supports reconcilation of state
	 */
	public boolean canReconcileState();
	
}
