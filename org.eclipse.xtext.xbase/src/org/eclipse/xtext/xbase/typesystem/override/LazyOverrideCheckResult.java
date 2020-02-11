/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmOperation;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LazyOverrideCheckResult implements IOverrideCheckResult {

	private final AbstractResolvedOperation thisOperation;
	private final JvmOperation givenOperation;
	private final OverrideCheckDetails primaryDetail;
	private EnumSet<OverrideCheckDetails> details;
	
	protected static final EnumSet<OverrideCheckDetails> overridingIfAnyOf = EnumSet.of(
			OverrideCheckDetails.OVERRIDE,
			OverrideCheckDetails.IMPLEMENTATION,
			OverrideCheckDetails.REDECLARATION,
			OverrideCheckDetails.REPEATED,
			OverrideCheckDetails.SHADOWED);
	
	protected static final EnumSet<OverrideCheckDetails> problemIfAnyOf = EnumSet.of(
			OverrideCheckDetails.ARITY_MISMATCH,
			OverrideCheckDetails.EXCEPTION_MISMATCH,
			OverrideCheckDetails.IS_FINAL,
			OverrideCheckDetails.NAME_MISMATCH,
			OverrideCheckDetails.NO_INHERITANCE,
			OverrideCheckDetails.NOT_VISIBLE,
			OverrideCheckDetails.PARAMETER_TYPE_MISMATCH,
			OverrideCheckDetails.REDUCED_VISIBILITY,
			OverrideCheckDetails.RETURN_MISMATCH,
			OverrideCheckDetails.SAME_ERASURE,
			OverrideCheckDetails.STATIC_MISMATCH,
			OverrideCheckDetails.SYNCHRONIZED_MISMATCH,
			OverrideCheckDetails.TYPE_PARAMETER_MISMATCH,
			OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED,
			OverrideCheckDetails.VAR_ARG_MISMATCH);
	
	public LazyOverrideCheckResult(AbstractResolvedOperation thisOperation, JvmOperation givenOperation, OverrideCheckDetails detail) {
		this.thisOperation = thisOperation;
		this.givenOperation = givenOperation;
		this.primaryDetail = detail;
	}

	@Override
	public boolean isOverridingOrImplementing() {
		return overridingIfAnyOf.contains(primaryDetail);
	}

	@Override
	public boolean hasProblems() {
		if (!isOverridingOrImplementing()) {
			return true;
		}
		EnumSet<OverrideCheckDetails> details = getDetails();
		return !Sets.intersection(problemIfAnyOf, details).isEmpty();
	}

	@Override
	public EnumSet<OverrideCheckDetails> getDetails() {
		if (details != null) {
			return details;
		}
		return details = getComputedDetails();
	}

	protected EnumSet<OverrideCheckDetails> getComputedDetails() {
		return thisOperation.getOverrideTester().getAllDetails(thisOperation, givenOperation, primaryDetail);
	}
	
	@Override
	public IResolvedOperation getThisOperation() {
		return thisOperation;
	}

	@Override
	public JvmOperation getGivenOperation() {
		return givenOperation;
	}
	
}
