/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator;

import org.eclipse.xtext.util.CancelIndicator;

/**
 * @since 2.9
 */
public class GeneratorContext implements IGeneratorContext {
	private CancelIndicator cancelIndicator;

	public CancelIndicator getCancelIndicator() {
		return cancelIndicator;
	}

	public void setCancelIndicator(CancelIndicator cancelIndicator) {
		this.cancelIndicator = cancelIndicator;
	}
}
