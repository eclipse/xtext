package org.eclipse.xtend.core.formatting;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class Anchors {
  private Map<Object,Integer> anchors = new Function0<Map<Object,Integer>>() {
    public Map<Object,Integer> apply() {
      HashMap<Object,Integer> _newHashMap = CollectionLiterals.<Object, Integer>newHashMap();
      return _newHashMap;
    }
  }.apply();
  
  public Anchors() {
  }
  
  public Anchors(final Anchors other) {
    Set<Entry<Object,Integer>> _entrySet = other.anchors.entrySet();
    final Procedure1<Entry<Object,Integer>> _function = new Procedure1<Entry<Object,Integer>>() {
        public void apply(final Entry<Object,Integer> it) {
          Object _key = it.getKey();
          Integer _value = it.getValue();
          Anchors.this.set(_key, (_value).intValue());
        }
      };
    IterableExtensions.<Entry<Object,Integer>>forEach(_entrySet, _function);
  }
  
  public Integer get(final Object anchor) {
    Integer _get = this.anchors.get(anchor);
    return _get;
  }
  
  public Integer set(final Object anchor, final int column) {
    Integer _xblockexpression = null;
    {
      final Integer old = this.anchors.get(anchor);
      Integer _xifexpression = null;
      boolean _or = false;
      boolean _equals = Objects.equal(old, null);
      if (_equals) {
        _or = true;
      } else {
        boolean _lessThan = ((old).intValue() < column);
        _or = (_equals || _lessThan);
      }
      if (_or) {
        Integer _put = this.anchors.put(anchor, Integer.valueOf(column));
        _xifexpression = _put;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
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
      boolean _equals_1 = Objects.equal(this.anchors, ((Anchors) obj).anchors);
      _and = (_and_1 && _equals_1);
    }
    return _and;
  }
  
  public int hashCode() {
    int _hashCode = this.anchors.hashCode();
    return _hashCode;
  }
}
