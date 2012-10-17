package org.eclipse.xtend.macro.lang.tests;

import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class MacroTestExtensions {
  public Pair<String,CharSequence> xtend(final CharSequence code) {
    Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("MyXtendFile.xtend", code);
    return _mappedTo;
  }
  
  public Pair<String,CharSequence> macro(final CharSequence code) {
    Pair<String,CharSequence> _mappedTo = Pair.<String, CharSequence>of("MyMacroFile.macro", code);
    return _mappedTo;
  }
}
