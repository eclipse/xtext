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

/**
 * @noreference
 */
@Accessors
@ToString(skipNulls = true)
@EqualsHashCode
class ContentAssistEntry {
	
	/**
	 * The prefix that should be replaced with this proposal.
	 */
	String prefix
	
	/**
	 * The proposed text to be inserted.
	 */
	String proposal
	
	/**
	 * The text seen by the user in the list of proposals.
	 */
	String label
	
	/**
	 * Additional description to include in the list of proposals.
	 * <p>This property may not be supported by all editor frameworks.</p>
	 */
	String description
	
	/**
	 * The absolute cursor position to apply after the proposal has been inserted.
	 * If omitted, the cursor it set to the end of the inserted proposal.
	 * <p>This property may not be supported by all editor frameworks.</p>
	 */
	Integer escapePosition
	
	/**
	 * Additional text replacements to apply when this proposal is selected.
	 * <p>This property may not be supported by all editor frameworks.</p>
	 */
	val textReplacements = new ArrayList<ReplaceRegion>
	
	/**
	 * Regions to be edited by the user after the proposal has been inserted.
	 * Usually the <em>tab</em> key navigates through the edit positions, and <em>enter</em>
	 * jumps to the {@code escapePosition}.
	 * <p>This property may not be supported by all editor frameworks.</p>
	 */
	val editPositions = new ArrayList<TextRegion>
	
	/**
	 * The EObject or IEObjectDescription for which this entry has been created, if any.
	 * This field is <em>not</em> serialized when the entry is sent over a communication channel.
	 */
	transient Object source
	
}