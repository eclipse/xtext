package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;
import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage.IModificationListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtend.ide.formatting.FormatterPreferenceInfra;
import org.eclipse.xtend.ide.formatting.FormatterSetting;
import org.eclipse.xtend.ide.formatting.SettingsData.Category;
import org.eclipse.xtend.ide.formatting.preferences.AbstractModifyDialogTab;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class GenericTab extends AbstractModifyDialogTab {
  private FormatterPreferenceInfra _formatterPreferenceInfra = new Function0<FormatterPreferenceInfra>() {
    public FormatterPreferenceInfra apply() {
      FormatterPreferenceInfra _formatterPreferenceInfra = new FormatterPreferenceInfra();
      return _formatterPreferenceInfra;
    }
  }.apply();
  
  private String previewContent;
  
  private Category category;
  
  public GenericTab(final IModificationListener modifyListener, final Map<String,String> workingValues, final Category category) {
    super(modifyListener, workingValues);
    this.category = category;
    CharSequence _previewText = this._formatterPreferenceInfra.previewText(category);
    String _string = _previewText.toString();
    this.previewContent = _string;
  }
  
  public void doCreatePreferences(final Composite composite, final int numColumns) {
    final Group generalGroup = this.createGroup(numColumns, composite, AbstractModifyDialogTab.GENERAL_SETTINGS);
    Iterable<FormatterSetting> _settingsByCategory = this._formatterPreferenceInfra.settingsByCategory(this.category);
    for (final FormatterSetting prefData : _settingsByCategory) {
      this.createPref(prefData, generalGroup, numColumns);
    }
  }
  
  protected String previewText() {
    return this.previewContent;
  }
}
