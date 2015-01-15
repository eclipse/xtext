package org.eclipse.xtext.xbase.formatting2;

import org.eclipse.xtext.formatting2.FormatterRequest;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.preferences.BooleanKey;
import org.eclipse.xtext.preferences.ITypedPreferenceValues;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class WhitespaceKey extends BooleanKey implements Procedure1<IHiddenRegionFormatter> {
  public WhitespaceKey(final String name, final Boolean defaultValue) {
    super(name, defaultValue);
  }
  
  @Override
  public void apply(final IHiddenRegionFormatter it) {
    FormatterRequest _request = it.getRequest();
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
