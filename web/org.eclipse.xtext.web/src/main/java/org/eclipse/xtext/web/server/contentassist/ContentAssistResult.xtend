/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.contentassist

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.web.server.IServiceResult
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@Accessors
@ToString(skipNulls = true)
class ContentAssistResult implements IServiceResult {
	
	String stateId
	
	val entries = new ArrayList<Entry>
	
	@Accessors
	@FinalFieldsConstructor
	@ToString(skipNulls = true)
	static class Entry {
		val String type
		val String prefix
		String proposal
		String name
		String description
		/** Available styles: 'default', 'emphasis', 'noemphasis', 'hr' */
		String style
		val textReplacements = new ArrayList<TextReplacement>
		val editPositions = new ArrayList<EditPosition>
	}
	
	@Data
	static class TextReplacement {
		String text
		int offset
		int length
	}
	
	@Data
	static class EditPosition {
		int offset
		int length
	}
	
}
