/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

/**
 * Use this to report configuration problems during the {@link IXtextGeneratorFragment#checkConfiguration(Issues)} phase.
 */
interface Issues {
	
	def void addError(String message)
	
	def void addError(String message, Object source)
	
	def void addWarning(String message)
	
	def void addWarning(String message, Object source)
	
}
