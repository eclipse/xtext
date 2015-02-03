/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Interface to be implemented by EMF {@link Resource}s that support lazy initialization of JvmMembers.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.8
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @noreference This interface is not intended to be referenced by clients.
 */
public interface JvmMemberInitializableResource {

	/**
	 * Executes any {@link Runnable}s added through {@link #addRunnableForJvmMembersInitialization(Runnable)}
	 */
	public void ensureJvmMembersInitialized();
	
	/**
	 * register {@link Runnable}s to be executed on JvmMemberInitialization
	 */
	public void addRunnableForJvmMembersInitialization(Runnable runnable);
	
	/**
	 * @return whether lazy JvmMember initialization is activated for this resource.
	 */
	public boolean isLazyJvmMemberInitialization();
}
