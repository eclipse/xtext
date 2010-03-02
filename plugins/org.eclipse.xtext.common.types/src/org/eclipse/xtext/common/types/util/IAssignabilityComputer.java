/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author svenefftinge - Initial contribution and API
 */
public interface IAssignabilityComputer {
	/**
	 * returns whether the type reference on the right can be assigned to the type reference on the left.
	 * Example:
	 * 
	 *   List<?> left = (List<? extends String>) right;
	 * 
	 */
	public boolean isAssignableFrom(JvmTypeReference left, JvmTypeReference right);
}
