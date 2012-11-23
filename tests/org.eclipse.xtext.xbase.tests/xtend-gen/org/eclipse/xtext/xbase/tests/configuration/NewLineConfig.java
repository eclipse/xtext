package org.eclipse.xtext.xbase.tests.configuration;

import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.configuration.AbstractConfigurationKey;
import org.eclipse.xtext.xbase.configuration.IConfigurationKeyWithStorage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.tests.configuration.NewLineConfigValue;

@SuppressWarnings("all")
public class NewLineConfig extends AbstractConfigurationKey<NewLineConfigValue> implements IConfigurationKeyWithStorage<NewLineConfigValue> {
  private final String _minName;
  
  public String getMinName() {
    return this._minName;
  }
  
  private final String _maxName;
  
  public String getMaxName() {
    return this._maxName;
  }
  
  public NewLineConfig(final String name, final int minNewLines, final int maxNewLines) {
    super(name, new Function0<NewLineConfigValue>() {
      public NewLineConfigValue apply() {
        NewLineConfigValue _newLineConfigValue = new NewLineConfigValue(minNewLines, maxNewLines);
        return _newLineConfigValue;
      }
    }.apply());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(name, "");
    _builder.append(".minNewLines");
    this._minName = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(name, "");
    _builder_1.append(".maxNewLines");
    this._maxName = _builder_1.toString();
  }
  
  public Collection<String> getStorageNames() {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(this._minName, this._maxName);
    return _newArrayList;
  }
  
  protected Integer parseInt(final String value, final Integer defaultValue) {
    Integer _xblockexpression = null;
    {
      try {
        boolean _notEquals = ObjectExtensions.operator_notEquals(value, null);
        if (_notEquals) {
          return Integer.valueOf(Integer.parseInt(value));
        }
      } catch (final Throwable _t) {
        if (_t instanceof NumberFormatException) {
          final NumberFormatException e = (NumberFormatException)_t;
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = (defaultValue);
    }
    return _xblockexpression;
  }
  
  public NewLineConfigValue load(final Function<String,String> storage) {
    NewLineConfigValue _xblockexpression = null;
    {
      String _apply = storage.apply(this._minName);
      NewLineConfigValue _defaultValue = this.getDefaultValue();
      int _minNewLines = _defaultValue.getMinNewLines();
      final Integer minimum = this.parseInt(_apply, Integer.valueOf(_minNewLines));
      String _apply_1 = storage.apply(this._maxName);
      NewLineConfigValue _defaultValue_1 = this.getDefaultValue();
      int _maxNewLines = _defaultValue_1.getMaxNewLines();
      final Integer maximum = this.parseInt(_apply_1, Integer.valueOf(_maxNewLines));
      NewLineConfigValue _newLineConfigValue = new NewLineConfigValue((minimum).intValue(), (maximum).intValue());
      _xblockexpression = (_newLineConfigValue);
    }
    return _xblockexpression;
  }
  
  public void store(final NewLineConfigValue value, final IAcceptor<Pair<String,String>> storage) {
    int _minNewLines = value.getMinNewLines();
    String _valueOf = String.valueOf(_minNewLines);
    Pair<String,String> _create = Tuples.<String, String>create(this._minName, _valueOf);
    storage.accept(_create);
    int _maxNewLines = value.getMaxNewLines();
    String _valueOf_1 = String.valueOf(_maxNewLines);
    Pair<String,String> _create_1 = Tuples.<String, String>create(this._maxName, _valueOf_1);
    storage.accept(_create_1);
  }
}
