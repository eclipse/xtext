/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ToJvmTypeReference implements Function<LightweightTypeReference, JvmTypeReference>{

	public static final ToJvmTypeReference INSTANCE = new ToJvmTypeReference();
	
	public JvmTypeReference apply(LightweightTypeReference input) {
		if (input != null) {
			return input.toTypeReference();
		}
		return null;
	}
	
}
