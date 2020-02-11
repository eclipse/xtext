/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.diagnostics;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public enum Severity {

	ERROR,
	WARNING,
	
	/**
	 * Severity INFO is not supported for resource diagnostics.
	 */
	INFO,
	/**
	 * @since 2.4
	 */
	IGNORE
	
}
