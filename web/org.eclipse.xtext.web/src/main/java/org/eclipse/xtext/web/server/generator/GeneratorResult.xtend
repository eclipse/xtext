/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.generator

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.web.server.IServiceResult

/**
 * Result object returned by the generator service. If the result contains exactly one entry,
 * the content of that entry should be sent as response to the client instead of wrapping
 * it in a result object. This allows to conveniently view generator results by pointing a
 * web browser to the generator service URL.
 */
@Accessors
@ToString(skipNulls = true)
class GeneratorResult implements IServiceResult {
	
	val List<GeneratedDocument> entries = newArrayList
	
	@Data
	static class GeneratedDocument {
		String name
		String contentType
		String content
	}
	
}