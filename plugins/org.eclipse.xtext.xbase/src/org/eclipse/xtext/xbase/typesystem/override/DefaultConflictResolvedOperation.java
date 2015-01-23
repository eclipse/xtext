/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A resolved representation of a {@link JvmOperation} with a conflict between two independent declarations
 * of default interface implementations (Java 8) with equal raw signature.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
public class DefaultConflictResolvedOperation extends BottomResolvedOperation {

	private final IResolvedOperation conflictingOperation;
	
	public DefaultConflictResolvedOperation(JvmOperation declaration, LightweightTypeReference contextType,
			OverrideTester overrideTester, IResolvedOperation conflictingOperation) {
		super(declaration, contextType, overrideTester);
		this.conflictingOperation = conflictingOperation;
	}
	
	public IResolvedOperation getConflictingOperation() {
		return conflictingOperation;
	}

}
