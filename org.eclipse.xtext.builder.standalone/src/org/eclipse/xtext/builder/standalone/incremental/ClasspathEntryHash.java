/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

/**
 * Abstract representation of a binary hashed class-path entry.
 * 
 * The hashing strategy in itself is not defined. It is guaranteed though
 * that signature changes lead to changes in the hash that is produced for a 
 * class-path entry. The inverse is not guaranteed though: Different hashes
 * do not necessarily imply that the signatures did in fact change.  
 * 
 * @see CoarseGrainedEntryHash
 * @see FineGrainedEntryHash
 * @see ClasspathEntryHashVisitor
 */
public interface ClasspathEntryHash {
	
	void accept(ClasspathEntryHashVisitor visitor);
	
}