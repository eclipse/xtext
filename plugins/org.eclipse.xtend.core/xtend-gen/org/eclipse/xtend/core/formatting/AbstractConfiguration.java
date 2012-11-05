package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.xtend.core.formatting.AbstractEntry;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AbstractConfiguration extends AbstractEntry {
  public AbstractConfiguration(final String key) {
    super(key);
  }
  
  public List<AbstractEntry> getEntries() {
    Class<? extends Object> _class = this.getClass();
    Field[] _declaredFields = _class.getDeclaredFields();
    final Function1<Field,AbstractEntry> _function = new Function1<Field,AbstractEntry>() {
        public AbstractEntry apply(final Field it) {
          AbstractEntry _xifexpression = null;
          Class<? extends Object> _type = it.getType();
          boolean _isAssignableFrom = AbstractEntry.class.isAssignableFrom(_type);
          if (_isAssignableFrom) {
            AbstractEntry _xtrycatchfinallyexpression = null;
            try {
              AbstractEntry _xblockexpression = null;
              {
                it.setAccessible(true);
                Object _get = it.get(AbstractConfiguration.this);
                _xblockexpression = (((AbstractEntry) _get));
              }
              _xtrycatchfinallyexpression = _xblockexpression;
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
                _xtrycatchfinallyexpression = null;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            _xifexpression = _xtrycatchfinallyexpression;
          }
          return _xifexpression;
        }
      };
    List<AbstractEntry> _map = ListExtensions.<Field, AbstractEntry>map(((List<Field>)Conversions.doWrapArray(_declaredFields)), _function);
    Iterable<AbstractEntry> _filterNull = IterableExtensions.<AbstractEntry>filterNull(_map);
    List<AbstractEntry> _list = IterableExtensions.<AbstractEntry>toList(_filterNull);
    return _list;
  }
  
  public Map<String,String> asMap() {
    LinkedHashMap<String,String> _newLinkedHashMap = CollectionLiterals.<String, String>newLinkedHashMap();
    final Procedure1<LinkedHashMap<String,String>> _function = new Procedure1<LinkedHashMap<String,String>>() {
        public void apply(final LinkedHashMap<String,String> it) {
          AbstractConfiguration.this.store(null, it);
        }
      };
    LinkedHashMap<String,String> _doubleArrow = ObjectExtensions.<LinkedHashMap<String,String>>operator_doubleArrow(_newLinkedHashMap, _function);
    return _doubleArrow;
  }
  
  public void load(final String prefix, final Map<String,String> values) {
    List<AbstractEntry> _entries = this.getEntries();
    final Procedure1<AbstractEntry> _function = new Procedure1<AbstractEntry>() {
        public void apply(final AbstractEntry it) {
          String _fullPrefix = AbstractConfiguration.this.fullPrefix(prefix);
          it.load(_fullPrefix, values);
        }
      };
    IterableExtensions.<AbstractEntry>forEach(_entries, _function);
  }
  
  public void store(final String prefix, final Map<String,String> values) {
    List<AbstractEntry> _entries = this.getEntries();
    final Procedure1<AbstractEntry> _function = new Procedure1<AbstractEntry>() {
        public void apply(final AbstractEntry it) {
          String _fullPrefix = AbstractConfiguration.this.fullPrefix(prefix);
          it.store(_fullPrefix, values);
        }
      };
    IterableExtensions.<AbstractEntry>forEach(_entries, _function);
  }
  
  public boolean equals(final Object obj) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(obj, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      Class<? extends Object> _class = obj.getClass();
      Class<? extends Object> _class_1 = this.getClass();
      boolean _equals = Objects.equal(_class, _class_1);
      _and_1 = (_notEquals && _equals);
    }
    if (!_and_1) {
      _and = false;
    } else {
      Map<String,String> _asMap = ((AbstractConfiguration) obj).asMap();
      Map<String,String> _asMap_1 = this.asMap();
      boolean _equals_1 = Objects.equal(_asMap, _asMap_1);
      _and = (_and_1 && _equals_1);
    }
    return _and;
  }
}
