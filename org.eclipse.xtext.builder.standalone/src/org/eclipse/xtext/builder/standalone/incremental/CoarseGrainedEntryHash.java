/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.hash.HashCode;

public class CoarseGrainedEntryHash implements ClasspathEntryHash {

	private final HashCode hashCode;

	public CoarseGrainedEntryHash(HashCode hashCode) {
		this.hashCode = hashCode;
	}

	@Override
	public void accept(ClasspathEntryHashVisitor visitor) {
		visitor.visitArchive(hashCode);
	}
	
	public byte[] asBytes() {
		return hashCode.asBytes();
	}

}