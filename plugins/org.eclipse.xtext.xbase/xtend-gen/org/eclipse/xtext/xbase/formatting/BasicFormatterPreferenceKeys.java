package org.eclipse.xtext.xbase.formatting;

import org.eclipse.xtext.xbase.formatting.IntegerKey;
import org.eclipse.xtext.xbase.formatting.StringKey;

@SuppressWarnings("all")
public class BasicFormatterPreferenceKeys {
  public final static StringKey lineSeparator = new StringKey("line.separator", System.getProperty("line.separator"));
  
  public final static StringKey indentation = new StringKey("indentation", "\t");
  
  public final static IntegerKey indentationLength = new IntegerKey("indentation.length", Integer.valueOf(4));
  
  public final static IntegerKey maxLineWidth = new IntegerKey("line.width.max", Integer.valueOf(120));
}
