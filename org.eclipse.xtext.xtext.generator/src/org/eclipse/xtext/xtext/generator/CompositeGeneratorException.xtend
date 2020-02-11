/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import java.lang.RuntimeException
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

package class CompositeGeneratorException extends RuntimeException {
	@Accessors
	val List<Exception> exceptions = newArrayList

	def addException(Exception exception) {
		exceptions.add(exception)
	}

	def hasExceptions() {
		exceptions.size > 0
	}

}