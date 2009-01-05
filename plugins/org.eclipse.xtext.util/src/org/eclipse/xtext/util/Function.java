/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

/**
 * Strategy to compute a value from a given parameter.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface Function<Param, Result> {

	/**
	 * @param param the input parameter
	 * @return the computed result
	 */
	Result exec(Param param);
	
	public interface WithoutResult<Param> {

		/**
		 * @param param the input parameter
		 */
		void exec(Param param);

	}
	
}
