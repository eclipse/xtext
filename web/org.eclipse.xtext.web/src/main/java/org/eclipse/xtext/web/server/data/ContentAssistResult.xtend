/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.data

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data

@Accessors
class ContentAssistResult extends JsonObject {
	
	val entries = new ArrayList<Entry>
	
	@Data
	static class Entry {
		String proposal
		String name
		String description
		// String prefix
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