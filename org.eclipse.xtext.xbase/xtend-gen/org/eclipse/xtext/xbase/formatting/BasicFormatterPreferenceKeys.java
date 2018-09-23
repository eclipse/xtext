package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.xbase.formatting.IntegerKey;
import org.eclipse.xtext.xbase.formatting.StringKey;

/**
 * @deprecated use {@link FormatterPreferenceKeys}
 */
@Deprecated
@SuppressWarnings("all")
public class BasicFormatterPreferenceKeys {
  public static final StringKey lineSeparator = new StringKey("line.separator", System.getProperty("line.separator"));
  
  public static final StringKey indentation = new StringKey("indentation", "\t");
  
  public static final IntegerKey indentationLength = new IntegerKey("indentation.length", Integer.valueOf(4));
  
  public static final IntegerKey maxLineWidth = new IntegerKey("line.width.max", Integer.valueOf(120));
}
