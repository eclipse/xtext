/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

import com.google.common.hash.HashCode;

public class FineGrainedEntryHash implements ClasspathEntryHash {
	private final Map<IPath, HashCode> classHashes;

	public FineGrainedEntryHash(Map<IPath, HashCode> classHashes) {
		this.classHashes = classHashes;
	}

	@Override
	public void accept(ClasspathEntryHashVisitor visitor) {
		classHashes.forEach(visitor::visitClassFile);
	}

	/**
	 * The key in the map is a FQN represented as a path, e.g. {@code com/acme/Foo$Bar}.
	 */
	public Map<IPath, HashCode> classHashes() {
		return Collections.unmodifiableMap(classHashes);
	}

}