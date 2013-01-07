/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmOperation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractOverrideCheckResult implements IOverrideCheckResult {

	protected static EnumSet<OverrideCheckDetails> overridingIfAnyOf = EnumSet.of(
			OverrideCheckDetails.CURRENT,
			OverrideCheckDetails.OVERRIDE,
			OverrideCheckDetails.IMPLEMENTATION,
			OverrideCheckDetails.REDECLARATION,
			OverrideCheckDetails.REPEATED);
	
	private IResolvedOperation thisOperation;
	private JvmOperation givenOperation;
	
	public AbstractOverrideCheckResult(IResolvedOperation thisOperation, JvmOperation givenOperation) {
		this.thisOperation = thisOperation;
		this.givenOperation = givenOperation;
	}
	
	public IResolvedOperation getThisOperation() {
		return thisOperation;
	}

	public JvmOperation getGivenOperation() {
		return givenOperation;
	}

	
}
