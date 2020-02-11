/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

/**
 * Generator fragments may throw non-fatal warnings to signal problems that will
 * not cause the workflow to fail.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.6
 */
@Deprecated
public class GeneratorWarning extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeneratorWarning(String warning) {
		super(warning);
	}
	
}
