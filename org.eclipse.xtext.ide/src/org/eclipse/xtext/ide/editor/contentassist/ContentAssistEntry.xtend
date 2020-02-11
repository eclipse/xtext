/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
     * Documentation for the proposal proposals.
     * <p>This property may not be supported by all editor frameworks.</p>
     */
    String documentation
	
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
	
	/**
	 * The kind of element that is proposed. Could be one of the constants below or something specific a concrete client understands.
	 * Must not be null.
	 */
	String kind = KIND_UNKNOWN
	
	public static val KIND_TEXT = "TEXT"
    public static val KIND_METHOD = "METHOD"
    public static val KIND_FUNCTION = "FUNCTION"
    public static val KIND_CONSTRUCTOR = "CONSTRUCTOR"
    public static val KIND_FIELD = "FIELD"
    public static val KIND_VARIABLE = "VARIABLE"
    public static val KIND_CLASS = "CLASS"
    public static val KIND_INTERFACE = "INTERFACE"
    public static val KIND_MODULE = "MODULE"
    public static val KIND_PROPERTY = "PROPERTY"
    public static val KIND_UNIT = "UNIT"
    public static val KIND_VALUE = "VALUE"
    public static val KIND_ENUM = "ENUM"
    public static val KIND_KEYWORD = "KEYWORD"
    public static val KIND_SNIPPET = "SNIPPET"
    public static val KIND_COLOR = "COLOR"
    public static val KIND_FILE = "FILE"
    public static val KIND_REFERENCE = "REFERENCE"
    public static val KIND_UNKNOWN = "UNKNOWN"
    
}
