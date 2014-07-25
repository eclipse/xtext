package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.preferences.IntegerKey;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatterPreferenceKeys;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class BlankLineKey extends IntegerKey implements Procedure1<IHiddenRegionFormatting> {
  public BlankLineKey(final String name, final Integer defaultValue) {
    super(name, defaultValue);
  }
  
  public void apply(final IHiddenRegionFormatting it) {
    IFormatterRequest _request = it.getRequest();
    final ITypedPreferenceValues preferences = _request.getPreferences();
    final Integer blankline = preferences.<Integer>getPreference(this);
    final Integer preserve = preferences.<Integer>getPreference(XbaseFormatterPreferenceKeys.preserveBlankLines);
    final int min = ((blankline).intValue() + 1);
    final int max = Math.max(((preserve).intValue() + 1), min);
    it.setNewLines(min, min, max);
  }
}
