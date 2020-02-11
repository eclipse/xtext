/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.server.validation

import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.web.server.IServiceResult

/**
 * Result object returned by the validation service.
 */
@Data
class ValidationResult implements IServiceResult {
	
	val List<Issue> issues = newArrayList
	
	@Data
	@ToString(skipNulls = true)
	static class Issue {
		String description
		String severity
		/**
		 * One based, the first line has the number 1.
		 */ 
		Integer line
		/**
		 * One based, the first column in a line has the number 1.
		 */
		Integer column
		/**
		 * Zero based, the first char in a document has the offset 0.
		 */
		Integer offset
		Integer length
	}
	
}
