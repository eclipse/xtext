/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.xtext.common.types.JvmTypeParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StandardTypeParameterSubstitutor extends TypeParameterSubstitutor<Object> {

	public StandardTypeParameterSubstitutor(Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping,
			CommonTypeComputationServices services) {
		super(typeParameterMapping, services);
	}

	@Override
	protected Object createVisiting() {
		return new Object();
	}

}
