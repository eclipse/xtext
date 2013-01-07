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
public class LazyOverrideCheckResult extends AbstractOverrideCheckResult {

	private OverrideCheckDetails primaryDetail;

	public LazyOverrideCheckResult(IResolvedOperation thisOperation, JvmOperation givenOperation, OverrideCheckDetails detail) {
		super(thisOperation, givenOperation);
		this.primaryDetail = detail;
	}

	public boolean isOverridingOrImplementing() {
		return overridingIfAnyOf.contains(primaryDetail);
	}

	public boolean hasProblems() {
		return !isOverridingOrImplementing();
	}

	public EnumSet<OverrideCheckDetails> getDetails() {
		return null;
	}
	
}
