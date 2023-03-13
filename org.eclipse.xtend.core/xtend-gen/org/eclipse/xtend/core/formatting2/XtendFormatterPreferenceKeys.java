/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.formatting2;

import com.google.inject.Singleton;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.xbase.formatting2.BlankLineKey;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;

/**
 * @author Moritz Eysholdt - Initial implementation and API
 */
@Singleton
@SuppressWarnings("all")
public class XtendFormatterPreferenceKeys extends XbaseFormatterPreferenceKeys {
  public static final BlankLineKey blankLinesAfterPackageDecl = new BlankLineKey("blank.lines.after.packagedecl", Integer.valueOf(1));

  public static final BlankLineKey blankLinesBetweenClasses = new BlankLineKey("blank.lines.between.classes", Integer.valueOf(1));

  public static final BlankLineKey blankLinesBeforeFirstMember = new BlankLineKey("blank.lines.before.first.member", Integer.valueOf(0));

  public static final BlankLineKey blankLinesAfterLastMember = new BlankLineKey("blank.lines.after.last.member", Integer.valueOf(0));

  public static final BlankLineKey blankLinesBetweenFields = new BlankLineKey("blank.lines.between.fields", Integer.valueOf(0));

  public static final BlankLineKey blankLinesBetweenFieldsAndMethods = new BlankLineKey("blank.lines.between.fields.and.methods", Integer.valueOf(1));

  public static final BlankLineKey blankLinesBetweenMethods = new BlankLineKey("blank.lines.between.methods", Integer.valueOf(1));

  public static final BlankLineKey blankLinesBetweenEnumLiterals = new BlankLineKey("blank.lines.between.enum.literals", Integer.valueOf(0));

  public static final BooleanKey keepOneLineMethods = new BooleanKey("keep.one.line.methods", Boolean.valueOf(true));
}
