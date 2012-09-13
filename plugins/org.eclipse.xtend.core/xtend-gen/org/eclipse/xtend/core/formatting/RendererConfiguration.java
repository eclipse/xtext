package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import com.google.inject.name.Named;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.xtend.core.formatting.NewLineConfiguration;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class RendererConfiguration {
  @Named(value = "line.separator")
  private String _lineSeparator;
  
  public String getLineSeparator() {
    return this._lineSeparator;
  }
  
  public void setLineSeparator(final String lineSeparator) {
    this._lineSeparator = lineSeparator;
  }
  
  @Named(value = "line.width.max")
  private int _maxLineWidth = 120;
  
  public int getMaxLineWidth() {
    return this._maxLineWidth;
  }
  
  public void setMaxLineWidth(final int maxLineWidth) {
    this._maxLineWidth = maxLineWidth;
  }
  
  @Named(value = "indentation")
  private String _indentation;
  
  public void setIndentation(final String indentation) {
    this._indentation = indentation;
  }
  
  @Named(value = "indentation.length")
  private int _indentationLength = 4;
  
  public int getIndentationLength() {
    return this._indentationLength;
  }
  
  public void setIndentationLength(final int indentationLength) {
    this._indentationLength = indentationLength;
  }
  
  @Named(value = "newlines.after.packagename")
  private NewLineConfiguration _newLinesAfterPackageName = new Function0<NewLineConfiguration>() {
    public NewLineConfiguration apply() {
      NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(2, 2);
      return _newLineConfiguration;
    }
  }.apply();
  
  public NewLineConfiguration getNewLinesAfterPackageName() {
    return this._newLinesAfterPackageName;
  }
  
  public void setNewLinesAfterPackageName(final NewLineConfiguration newLinesAfterPackageName) {
    this._newLinesAfterPackageName = newLinesAfterPackageName;
  }
  
  @Named(value = "newlines.between.imports")
  private NewLineConfiguration _newLinesBetweenImports = new Function0<NewLineConfiguration>() {
    public NewLineConfiguration apply() {
      NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(1, 2);
      return _newLineConfiguration;
    }
  }.apply();
  
  public NewLineConfiguration getNewLinesBetweenImports() {
    return this._newLinesBetweenImports;
  }
  
  public void setNewLinesBetweenImports(final NewLineConfiguration newLinesBetweenImports) {
    this._newLinesBetweenImports = newLinesBetweenImports;
  }
  
  @Named(value = "newlines.after.importsection")
  private NewLineConfiguration _newLinesAfterImportSection = new Function0<NewLineConfiguration>() {
    public NewLineConfiguration apply() {
      NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(2, 3);
      return _newLineConfiguration;
    }
  }.apply();
  
  public NewLineConfiguration getNewLinesAfterImportSection() {
    return this._newLinesAfterImportSection;
  }
  
  public void setNewLinesAfterImportSection(final NewLineConfiguration newLinesAfterImportSection) {
    this._newLinesAfterImportSection = newLinesAfterImportSection;
  }
  
  @Named(value = "newlines.between.fields")
  private NewLineConfiguration _newLinesBetweenFields = new Function0<NewLineConfiguration>() {
    public NewLineConfiguration apply() {
      NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(1, 2);
      return _newLineConfiguration;
    }
  }.apply();
  
  public NewLineConfiguration getNewLinesBetweenFields() {
    return this._newLinesBetweenFields;
  }
  
  public void setNewLinesBetweenFields(final NewLineConfiguration newLinesBetweenFields) {
    this._newLinesBetweenFields = newLinesBetweenFields;
  }
  
  @Named(value = "newlines.between.fields.and.methods")
  private NewLineConfiguration _newLinesBetweenFieldsAndMethods = new Function0<NewLineConfiguration>() {
    public NewLineConfiguration apply() {
      NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(2, 2);
      return _newLineConfiguration;
    }
  }.apply();
  
  public NewLineConfiguration getNewLinesBetweenFieldsAndMethods() {
    return this._newLinesBetweenFieldsAndMethods;
  }
  
  public void setNewLinesBetweenFieldsAndMethods(final NewLineConfiguration newLinesBetweenFieldsAndMethods) {
    this._newLinesBetweenFieldsAndMethods = newLinesBetweenFieldsAndMethods;
  }
  
  @Named(value = "newlines.between.methods")
  private NewLineConfiguration _newLinesBetweenMethods = new Function0<NewLineConfiguration>() {
    public NewLineConfiguration apply() {
      NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(2, 2);
      return _newLineConfiguration;
    }
  }.apply();
  
  public NewLineConfiguration getNewLinesBetweenMethods() {
    return this._newLinesBetweenMethods;
  }
  
  public void setNewLinesBetweenMethods(final NewLineConfiguration newLinesBetweenMethods) {
    this._newLinesBetweenMethods = newLinesBetweenMethods;
  }
  
  @Named(value = "newlines.between.classes")
  private NewLineConfiguration _newLinesBetweenClasses = new Function0<NewLineConfiguration>() {
    public NewLineConfiguration apply() {
      NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(2, 3);
      return _newLineConfiguration;
    }
  }.apply();
  
  public NewLineConfiguration getNewLinesBetweenClasses() {
    return this._newLinesBetweenClasses;
  }
  
  public void setNewLinesBetweenClasses(final NewLineConfiguration newLinesBetweenClasses) {
    this._newLinesBetweenClasses = newLinesBetweenClasses;
  }
  
  public RendererConfiguration() {
  }
  
  public RendererConfiguration(final Map<String,String> properties) {
    try {
      Map<String,Field> _namedProperties = this.getNamedProperties();
      Set<Entry<String,Field>> _entrySet = _namedProperties.entrySet();
      for (final Entry<String,Field> property : _entrySet) {
        {
          String _key = property.getKey();
          final String str = properties.get(_key);
          boolean _notEquals = (!Objects.equal(str, null));
          if (_notEquals) {
            Object _switchResult = null;
            Field _value = property.getValue();
            Class<? extends Object> _type = _value.getType();
            final Class<? extends Object> _switchValue = _type;
            boolean _matched = false;
            if (!_matched) {
              if (Objects.equal(_switchValue,int.class)) {
                _matched=true;
                int _parseInt = Integer.parseInt(str);
                _switchResult = _parseInt;
              }
            }
            if (!_matched) {
              if (Objects.equal(_switchValue,String.class)) {
                _matched=true;
                _switchResult = str;
              }
            }
            if (!_matched) {
              if (Objects.equal(_switchValue,NewLineConfiguration.class)) {
                _matched=true;
                NewLineConfiguration _newLineConfiguration = new NewLineConfiguration(str);
                _switchResult = _newLineConfiguration;
              }
            }
            final Object value = _switchResult;
            Field _value_1 = property.getValue();
            _value_1.set(this, value);
          }
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Map<String,String> asMap() {
    Map<String,Field> _namedProperties = this.getNamedProperties();
    final Function1<Field,String> _function = new Function1<Field,String>() {
        public String apply(final Field it) {
          String _xtrycatchfinallyexpression = null;
          try {
            Object _get = it.get(RendererConfiguration.this);
            String _string = _get==null?(String)null:_get.toString();
            String _elvis = ObjectExtensions.<String>operator_elvis(_string, "");
            _xtrycatchfinallyexpression = _elvis;
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception e = (Exception)_t;
              _xtrycatchfinallyexpression = null;
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          return _xtrycatchfinallyexpression;
        }
      };
    Map<String,String> _mapValues = MapExtensions.<String, Field, String>mapValues(_namedProperties, _function);
    return _mapValues;
  }
  
  protected Map<String,Field> getNamedProperties() {
    Class<? extends Object> _class = this.getClass();
    Field[] _declaredFields = _class.getDeclaredFields();
    final Function1<Field,Boolean> _function = new Function1<Field,Boolean>() {
        public Boolean apply(final Field it) {
          Named _annotation = it.<Named>getAnnotation(Named.class);
          boolean _notEquals = (!Objects.equal(_annotation, null));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<Field> _filter = IterableExtensions.<Field>filter(((Iterable<Field>)Conversions.doWrapArray(_declaredFields)), _function);
    final Function1<Field,String> _function_1 = new Function1<Field,String>() {
        public String apply(final Field it) {
          Named _annotation = it.<Named>getAnnotation(Named.class);
          String _value = _annotation.value();
          return _value;
        }
      };
    Map<String,Field> _map = IterableExtensions.<String, Field>toMap(_filter, _function_1);
    return _map;
  }
  
  public String getIndentation(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            return RendererConfiguration.this._indentation;
          }
        };
      Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
  
  public int getIndentationLenght(final int levels) {
    int _indentationLength = this.getIndentationLength();
    int _multiply = (levels * _indentationLength);
    return _multiply;
  }
  
  public String getWrap(final int levels) {
    String _xifexpression = null;
    boolean _greaterThan = (levels > 0);
    if (_greaterThan) {
      int _minus = (levels - 1);
      IntegerRange _upTo = new IntegerRange(0, _minus);
      final Function1<Integer,String> _function = new Function1<Integer,String>() {
          public String apply(final Integer it) {
            return RendererConfiguration.this._lineSeparator;
          }
        };
      Iterable<String> _map = IterableExtensions.<Integer, String>map(_upTo, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    } else {
      _xifexpression = "";
    }
    return _xifexpression;
  }
}
