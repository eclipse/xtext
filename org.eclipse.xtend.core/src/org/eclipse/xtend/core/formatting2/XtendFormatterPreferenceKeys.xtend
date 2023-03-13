/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.formatting2

import com.google.inject.Singleton
import org.eclipse.xtext.preferences.BooleanKey
import org.eclipse.xtext.xbase.formatting2.BlankLineKey
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Singleton
class XtendFormatterPreferenceKeys extends XbaseFormatterPreferenceKeys {
	public static val blankLinesAfterPackageDecl = new BlankLineKey("blank.lines.after.packagedecl", 1)
	public static val blankLinesBetweenClasses = new BlankLineKey("blank.lines.between.classes", 1)
	public static val blankLinesBeforeFirstMember = new BlankLineKey("blank.lines.before.first.member", 0)
	public static val blankLinesAfterLastMember = new BlankLineKey("blank.lines.after.last.member", 0)
	public static val blankLinesBetweenFields = new BlankLineKey("blank.lines.between.fields", 0)
	public static val blankLinesBetweenFieldsAndMethods = new BlankLineKey("blank.lines.between.fields.and.methods", 1)
	public static val blankLinesBetweenMethods = new BlankLineKey("blank.lines.between.methods", 1)
	public static val blankLinesBetweenEnumLiterals = new BlankLineKey("blank.lines.between.enum.literals", 0)
	public static val keepOneLineMethods = new BooleanKey("keep.one.line.methods", true)
}
