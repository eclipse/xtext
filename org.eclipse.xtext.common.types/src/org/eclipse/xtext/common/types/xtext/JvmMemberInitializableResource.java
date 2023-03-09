/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmMember;

/**
 * Interface to be implemented by EMF {@link Resource resources} that support lazy initialization of {@link JvmMember members}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.8
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @noreference This interface is not intended to be referenced by clients.
 */
public interface JvmMemberInitializableResource {

	/**
	 * Executes any {@link Runnable runnables} added through {@link #addJvmMemberInitializer(Runnable)}
	 */
	void ensureJvmMembersInitialized();
	
	/**
	 * Returns {@code true} if this resource is currently initializing a the members of its contained types.
	 */
	boolean isInitializingJvmMembers();
	
	/**
	 * register {@link Runnable runnables} to be executed on {@link #ensureJvmMembersInitialized()}.
	 */
	void addJvmMemberInitializer(Runnable runnable);
	
	/**
	 * @return whether lazy {@link JvmMember} initialization is activated for this resource.
	 */
	boolean hasJvmMemberInitializers();
}
