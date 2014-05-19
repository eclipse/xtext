/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

/**
 * Resolved bottom representation of a {@link JvmOperation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BottomResolvedOperation extends AbstractResolvedOperation {
	
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	private OverrideTester overrideTester;
	
	public BottomResolvedOperation(JvmOperation declaration, LightweightTypeReference contextType, OverrideTester overrideTester) {
		super(declaration, contextType);
		this.overrideTester = overrideTester;
	}
	
	public boolean isBottomInContext() {
		return true;
	}

	public IResolvedOperation getAsBottom() {
		return this;
	}

	@Override
	protected BottomResolvedOperation getBottom() {
		return this;
	}

	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getContextTypeParameterMapping() {
		if (typeParameterMapping != null)
			return typeParameterMapping;
		return typeParameterMapping = Collections.unmodifiableMap(computeContextTypeParameterMapping());
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> computeContextTypeParameterMapping() {
		return new DeclaratorTypeArgumentCollector().getTypeParameterMapping(getContextType());
	}
	
	@Override
	protected OverrideTester getOverrideTester() {
		return overrideTester;
	}
	
	public IOverrideCheckResult getOverrideCheckResult() {
		return new LazyOverrideCheckResult(this, getDeclaration(), OverrideCheckDetails.CURRENT) {
			@Override
			public boolean hasProblems() {
				return false;
			}
			@Override
			public EnumSet<OverrideCheckDetails> getDetails() {
				return EnumSet.of(OverrideCheckDetails.CURRENT);
			}
		};
	}
}
