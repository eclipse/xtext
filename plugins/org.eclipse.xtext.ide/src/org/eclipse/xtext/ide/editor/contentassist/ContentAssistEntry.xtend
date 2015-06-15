/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist

import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.util.ReplaceRegion
import org.eclipse.xtext.util.TextRegion

@Accessors
@ToString(skipNulls = true)
@EqualsHashCode
class ContentAssistEntry {
	
	String prefix
	
	String proposal
	
	String label
	
	String description
	
	int escapePosition
	
	val textReplacements = new ArrayList<ReplaceRegion>
	
	val editPositions = new ArrayList<TextRegion>
	
}