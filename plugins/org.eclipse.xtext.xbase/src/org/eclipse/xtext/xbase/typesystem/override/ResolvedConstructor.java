/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ResolvedConstructor extends AbstractResolvedExecutable implements IResolvedConstructor {

	private final JvmConstructor constructor;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;

	public ResolvedConstructor(JvmConstructor constructor, LightweightTypeReference contextType) {
		super(contextType);
		this.constructor = constructor;
	}
	
	public JvmConstructor getDeclaration() {
		return constructor;
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

}
