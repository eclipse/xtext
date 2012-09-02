package org.eclipse.xtend.ide.formatting;

import java.util.List;
import org.eclipse.xtend.ide.formatting.SettingsData.Category;
import org.eclipse.xtend.ide.formatting.SettingsData.WidgetType;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class FormatterSetting {
  private final Category _category;
  
  public Category getCategory() {
    return this._category;
  }
  
  private final String _name;
  
  public String getName() {
    return this._name;
  }
  
  private final String _label;
  
  public String getLabel() {
    return this._label;
  }
  
  private final WidgetType _type;
  
  public WidgetType getType() {
    return this._type;
  }
  
  private final List<String> _posibleValues;
  
  public List<String> getPosibleValues() {
    return this._posibleValues;
  }
  
  public List<String> getPosibleValuesLabels() {
    List<String> _posibleValues = this.getPosibleValues();
    final Function1<String,String> _function = new Function1<String,String>() {
        public String apply(final String it) {
          String _firstUpper = StringExtensions.toFirstUpper(it);
          return _firstUpper;
        }
      };
    List<String> _map = _posibleValues==null?(List<String>)null:ListExtensions.<String, String>map(_posibleValues, _function);
    List<String> _emptyList = CollectionLiterals.<String>emptyList();
    return ObjectExtensions.<List<String>>operator_elvis(_map, _emptyList);
  }
  
  public FormatterSetting(final Category category, final String name, final String label, final WidgetType type, final List<String> posibleValues) {
    super();
    this._category = category;
    this._name = name;
    this._label = label;
    this._type = type;
    this._posibleValues = posibleValues;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_category== null) ? 0 : _category.hashCode());
    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
    result = prime * result + ((_label== null) ? 0 : _label.hashCode());
    result = prime * result + ((_type== null) ? 0 : _type.hashCode());
    result = prime * result + ((_posibleValues== null) ? 0 : _posibleValues.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FormatterSetting other = (FormatterSetting) obj;
    if (_category == null) {
      if (other._category != null)
        return false;
    } else if (!_category.equals(other._category))
      return false;
    if (_name == null) {
      if (other._name != null)
        return false;
    } else if (!_name.equals(other._name))
      return false;
    if (_label == null) {
      if (other._label != null)
        return false;
    } else if (!_label.equals(other._label))
      return false;
    if (_type == null) {
      if (other._type != null)
        return false;
    } else if (!_type.equals(other._type))
      return false;
    if (_posibleValues == null) {
      if (other._posibleValues != null)
        return false;
    } else if (!_posibleValues.equals(other._posibleValues))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
