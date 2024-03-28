/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;

/**
 * @since 2.35
 */
public class ArrayReference {

	private final EObject[] array;
	
	public ArrayReference(EObject[] array) {
		this.array = array;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof ArrayReference && Arrays.equals(array, ((ArrayReference) obj).array);
	}
	
	@Override
	public int hashCode() {
		return Arrays.hashCode(array);
	}

	public EObject[] getArray() {
		return array;
	}
	
}
