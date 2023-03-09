/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collection;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractResolvedFeatures {

	private final LightweightTypeReference type;
	private final OverrideTester overrideTester;

	protected AbstractResolvedFeatures(LightweightTypeReference type, OverrideTester overrideTester) {
		this.type = type;
		this.overrideTester = overrideTester;
	}
	
	protected boolean isOverridden(JvmOperation operation, Collection<AbstractResolvedOperation> processedOperations) {
		for(AbstractResolvedOperation processed: processedOperations) {
			if (overrideTester.isSubsignature(processed, operation, false).isOverridingOrImplementing()) {
				return true;
			}
		}
		return false;
	}
	
	protected BottomResolvedOperation createResolvedOperation(JvmOperation operation) {
		return new BottomResolvedOperation(operation, type, overrideTester);
	}
	
	protected ConflictingDefaultOperation createConflictingOperation(JvmOperation operation,
			IResolvedOperation... conflictingOperations) {
		return new ConflictingDefaultOperation(operation, type, overrideTester, conflictingOperations);
	}
	
	protected BottomResolvedOperation createResolvedOperation(JvmOperation operation, LightweightTypeReference context) {
		return new BottomResolvedOperation(operation, context, overrideTester);
	}

	public LightweightTypeReference getType() {
		return type;
	}
	
	protected JvmType getRawType() {
		return type.getType();
	}

}
