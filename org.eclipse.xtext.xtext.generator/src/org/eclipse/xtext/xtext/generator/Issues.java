/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator;

/**
 * Use this to report configuration problems during the {@link IXtextGeneratorFragment#checkConfiguration(Issues)} phase.
 */
public interface Issues {
	
	void addError(String message);
	
	void addError(String message, Object source);
	
	void addWarning(String message);
	
	void addWarning(String message, Object source);
	
}
