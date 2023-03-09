/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
