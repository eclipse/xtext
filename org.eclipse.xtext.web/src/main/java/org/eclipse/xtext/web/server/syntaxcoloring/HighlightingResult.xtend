/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.server.syntaxcoloring

import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.web.server.IServiceResult

/**
 * Result object returned by the highlighting service.
 */
@Data
class HighlightingResult implements IServiceResult {
	
	val List<Region> regions = newArrayList
	
	@Data
	@ToString(singleLine=true)
	static class Region {
		int offset
		int length
		String[] styleClasses
	}
	
}