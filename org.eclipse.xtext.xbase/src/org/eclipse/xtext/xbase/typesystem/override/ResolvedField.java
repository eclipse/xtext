/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResolvedField extends AbstractResolvedFeature<JvmField> implements IResolvedField {

	private LightweightTypeReference resolvedType;

	public ResolvedField(JvmField field, LightweightTypeReference contextType) {
		super(field, contextType);
	}

	@Override
	public String getResolvedSignature() {
		return getDeclaration().getSimpleName();
	}

	@Override
	public String getSimpleSignature() {
		return getDeclaration().getSimpleName();
	}

	@Override
	public String getResolvedErasureSignature() {
		return getDeclaration().getSimpleName();
	}

	@Override
	public LightweightTypeReference getResolvedType() {
		if (resolvedType != null)
			return resolvedType;
		return resolvedType = getResolvedReference(getDeclaration().getType());
	}

}
