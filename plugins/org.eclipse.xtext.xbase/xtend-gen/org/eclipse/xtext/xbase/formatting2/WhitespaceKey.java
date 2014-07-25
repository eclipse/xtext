package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.IFormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class WhitespaceKey extends BooleanKey implements Procedure1<IHiddenRegionFormatting> {
  public WhitespaceKey(final String name, final Boolean defaultValue) {
    super(name, defaultValue);
  }
  
  public void apply(final IHiddenRegionFormatting it) {
    IFormatterRequest _request = it.getRequest();
    ITypedPreferenceValues _preferences = _request.getPreferences();
    final Boolean space = _preferences.<Boolean>getPreference(this);
    String _xifexpression = null;
    if ((space).booleanValue()) {
      _xifexpression = " ";
    } else {
      _xifexpression = "";
    }
    it.setSpace(_xifexpression);
  }
}
