/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;

/**
 * @deprecated use {@link FormatterPreferenceKeys}
 */
@Deprecated
public class BasicFormatterPreferenceKeys {
  public static final StringKey lineSeparator = new StringKey("line.separator", System.getProperty("line.separator"));
  
  public static final StringKey indentation = new StringKey("indentation", "\t");
  
  public static final IntegerKey indentationLength = new IntegerKey("indentation.length", Integer.valueOf(4));
  
  public static final IntegerKey maxLineWidth = new IntegerKey("line.width.max", Integer.valueOf(120));
}
