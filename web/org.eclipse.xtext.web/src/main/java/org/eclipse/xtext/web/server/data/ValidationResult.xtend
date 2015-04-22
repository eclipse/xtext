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
// TODO move to validation package
class ValidationResult extends JsonObject {
	
	val entries = new ArrayList<Entry>
	
	@Data
	static class Entry {
		String description
		String severity 
		Integer line
		Integer startOffset
		Integer endOffset
	}
	
}