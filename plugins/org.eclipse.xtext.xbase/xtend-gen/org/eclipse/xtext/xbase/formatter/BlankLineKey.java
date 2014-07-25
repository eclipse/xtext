package org.eclipse.xtext.xbase.formatter;

import org.eclipse.xtext.formatter.IFormatter;
import org.eclipse.xtext.formatter.IGapFormatting;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.IntegerKey;
import org.eclipse.xtext.xbase.formatter.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class BlankLineKey extends IntegerKey implements Procedure1<IGapFormatting> {
  public BlankLineKey(final String name, final Integer defaultValue) {
    super(name, defaultValue);
  }
  
  public void apply(final IGapFormatting it) {
    IFormatter.Request _request = it.getRequest();
    final ITypedPreferenceValues preferences = _request.getPreferences();
    final Integer blankline = preferences.<Integer>getPreference(this);
    final Integer preserve = preferences.<Integer>getPreference(XbaseFormatterPreferenceKeys.preserveBlankLines);
    final int min = ((blankline).intValue() + 1);
    final int max = Math.max(((preserve).intValue() + 1), min);
    it.setNewLines(min, min, max);
  }
}
