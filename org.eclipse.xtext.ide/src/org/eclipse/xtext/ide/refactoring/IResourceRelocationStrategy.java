/*******************************************************************************
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.refactoring;

/**
 * Allows a language to execute side-effects when the URI of a resource changes.
 * 
 * Such changes can be move, rename and copy operations, e.g. triggered by the 
 * user in a file browser. An example for a language in which such side-effects 
 * would make sense is Java, where the package name and the name of the first 
 * public top-level class must match the resource's path.
 * 
 * Clients usually call {@link ResourceRelocationContext#addModification} to 
 * register their side effects. This way it is ensured that the resource is 
 * properly loaded and watched for changes.
 * 
 * In Eclipse, {@link IResourceRelocationStrategy} are registered to an extension 
 * point.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public interface IResourceRelocationStrategy {

	void applyChange(ResourceRelocationContext context);

	/**
	 * By overriding this method client implementations may explicitly demand for relying
	 * on the persisted index during a refactoring. 
	 * 
	 * Refactoring operations usually rely on a lively created resource index. However,
	 * in case of refactorings affecting a large amounts of files live resource indexing
	 * may lead to heap pollution and resultant performance decreases.
	 * 
	 * If a persisted index is supported by the runtime environment and if at least one of the
	 * registered implementations of {@link IResourceRelocationStrategy} demands for relying
	 * on the persisted index and if, furthermore, required preconditions are satisfied,
	 * like no open editor is dirty and the persisted index is up-to-date, the refactoring
	 * operation will rely entirely on the persisted index for, e.g., determining incoming
	 * references of affected objects, and skip the creation of a live resource index.
	 * 
	 * If some of the additional required preconditions are not met the runtime may execute
	 * actions to make the conditions satisfied or reject the refactoring.
	 * 
	 * @since 2.18
	 */
	default boolean requiresUsageOfPersistedIndex(ResourceRelocationContext context) {
		return false;
	}
}


