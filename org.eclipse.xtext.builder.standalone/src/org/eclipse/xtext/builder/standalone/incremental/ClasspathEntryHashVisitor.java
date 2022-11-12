/*******************************************************************************
 * Copyright (c) 2022 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import org.eclipse.core.runtime.IPath;

import com.google.common.annotations.Beta;
import com.google.common.hash.HashCode;

/**
 * Visitor over entry hashes. It is assumed that a {@link CoarseGrainedEntryHash} was made
 * for an archive and directories are hashed {@link FineGrainedEntryHash on a per class basis}.
 */
@Beta
public interface ClasspathEntryHashVisitor {
	default void visitArchive(HashCode archiveHash) {}

	default void visitClassFile(IPath fqn, HashCode classHash) {}
}