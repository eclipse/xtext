/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDocs
 */
public final class UnboundTypeReferences {
	
	private UnboundTypeReferences() {
		throw new UnsupportedOperationException();
	}
	
	public static JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		for(Map.Entry<JvmTypeParameter, LightweightMergedBoundTypeArgument> entry: mapping.entrySet()) {
			LightweightTypeReference reference = entry.getValue().getTypeReference();
			JvmType type = null;
			if (reference instanceof UnboundTypeReference) {
				type = ((UnboundTypeReference) reference).getTypeParameter();
			} else {
				type = reference.getType();
			}
			if (parameter == type) {
				if (visited.add(entry.getKey()))
					return entry.getKey();
				return null;
			}
		}
		return null;
	}

}
