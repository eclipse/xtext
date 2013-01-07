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
public class StandardOverrideCheckResult implements IOverrideCheckResult {

	private static EnumSet<OverrideCheckDetails> validIfAnyOf = EnumSet.of(
			OverrideCheckDetails.CURRENT,
			OverrideCheckDetails.OVERRIDE,
			OverrideCheckDetails.IMPLEMENTATION,
			OverrideCheckDetails.REDECLARATION,
			OverrideCheckDetails.REPEATED);
	
	private IResolvedOperation thisOperation;
	private JvmOperation givenOperation;
	private EnumSet<OverrideCheckDetails> details;
	private EnumSet<OverrideCheckDetails> problems;

	public StandardOverrideCheckResult(IResolvedOperation thisOperation, JvmOperation givenOperation, OverrideCheckDetails detail, OverrideCheckDetails... details) {
		this.thisOperation = thisOperation;
		this.givenOperation = givenOperation;
		this.details = EnumSet.of(detail, details);
		this.problems = EnumSet.copyOf(this.details);
		this.problems.removeAll(validIfAnyOf);
		this.problems.remove(OverrideCheckDetails.COVARIANT_RETURN);
	}
	
	public boolean isOverridingOrImplementing() {
		return problems.isEmpty();
	}

	public boolean hasProblems() {
		return !problems.isEmpty();
	}

	public EnumSet<OverrideCheckDetails> getDetails() {
		return details;
	}

	public IResolvedOperation getThisOperation() {
		return thisOperation;
	}

	public JvmOperation getGivenOperation() {
		return givenOperation;
	}

}
