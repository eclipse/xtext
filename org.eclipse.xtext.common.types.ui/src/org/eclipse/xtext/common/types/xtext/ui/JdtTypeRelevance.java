/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

/**
 * 
 * Computes the relevance of a certain type proposal, based on a given text.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class JdtTypeRelevance {

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public int getRelevance(String typeName, String prefix) {
		int relevance = 0;
		// If the simple name is an exact match
		if (typeName.endsWith("."+prefix))
			relevance += 40;
		// higher precedence for java packages
		if (typeName.startsWith("java.lang")) {
			relevance += 30;
		}
		if (typeName.startsWith("java.util")) {
			relevance += 20;
		}
		if (typeName.startsWith("java")) {
			relevance += 10;
		}
		return relevance;
	}
}
