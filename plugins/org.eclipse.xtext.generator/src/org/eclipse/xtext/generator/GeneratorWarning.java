/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

/**
 * Generator fragments may throw non-fatal warnings to signal problems that will
 * not cause the workflow to fail.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.6
 */
public class GeneratorWarning extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GeneratorWarning(String warning) {
		super(warning);
	}
	
}
