/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.mwe;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.xtext.resource.IResourceDescriptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface ISlotEntry {
	
	/**
	 * implementers can check their configuration and throw {@link IllegalStateException} when problems exists.
	 */
	void preInvoke();

	/**
	 * implementers can modify the ctx (i.e. add new entries based on the configuration)
	 * @param ctx - the workflow context to modify
	 * @param descriptions - the index state
	 * @param resourceSet - the resource set containing the loaded resources
	 */
	void put(WorkflowContext ctx, IResourceDescriptions descriptions, ResourceSet resourceSet);

}
