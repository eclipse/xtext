/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.List;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * A resolved representation of a {@link JvmOperation} with a conflict between two or more independent declarations
 * of default interface implementations (Java 8) with equal raw signature.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
public class ConflictingDefaultOperation extends BottomResolvedOperation {

	private final List<IResolvedOperation> conflictingOperations;
	
	public ConflictingDefaultOperation(JvmOperation declaration, LightweightTypeReference contextType,
			OverrideTester overrideTester, IResolvedOperation... conflictingOperations) {
		super(declaration, contextType, overrideTester);
		this.conflictingOperations = Lists.newArrayList(conflictingOperations);
	}
	
	/**
	 * Returns the operations that are in conflict with the receiver. This does not include the receiver itself.
	 * The elements in the returned list are not necessarily in conflict with each other: the receiver is usually
	 * non-abstract, but the conflicting operations can be abstract.
	 */
	public List<IResolvedOperation> getConflictingOperations() {
		return conflictingOperations;
	}

}
