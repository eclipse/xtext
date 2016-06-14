/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.formatting2;

import com.google.common.base.Objects;
import com.google.common.collect.AbstractIterator;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.xbase.formatting2.Entry;
import org.eclipse.xtext.xbase.formatting2.ObjectEntry;
import org.eclipse.xtext.xbase.formatting2.SeparatorEntry;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class SeparatorRegions<T extends Object, R extends ITextSegment> implements Iterable<ObjectEntry<T, R>> {
  @Accessors
  private final ITextSegment root;
  
  private ObjectEntry<T, R> first;
  
  public void prepend(final T object) {
    final ObjectEntry<T, R> newObject = new ObjectEntry<T, R>(this);
    newObject.setObject(object);
    boolean _equals = Objects.equal(this.first, null);
    if (_equals) {
      this.first = newObject;
    } else {
      SeparatorEntry<T, R> _leadingSeparator = this.first.getLeadingSeparator();
      newObject.next = _leadingSeparator;
      SeparatorEntry<T, R> _leadingSeparator_1 = this.first.getLeadingSeparator();
      _leadingSeparator_1.next = newObject;
      this.first = newObject;
    }
  }
  
  public void prependWithLeadingSeparator(final T object, final R separator) {
    final ObjectEntry<T, R> newObject = new ObjectEntry<T, R>(this);
    final SeparatorEntry<T, R> newSeparator = new SeparatorEntry<T, R>();
    newObject.setObject(object);
    newSeparator.setSeparator(separator);
    newObject.previous = newSeparator;
    newSeparator.next = newObject;
    boolean _equals = Objects.equal(this.first, null);
    if (_equals) {
      this.first = newObject;
    } else {
      SeparatorEntry<T, R> _leadingSeparator = this.first.getLeadingSeparator();
      newObject.next = _leadingSeparator;
      SeparatorEntry<T, R> _leadingSeparator_1 = this.first.getLeadingSeparator();
      _leadingSeparator_1.previous = newObject;
      this.first = newObject;
    }
  }
  
  public void appendWithTrailingSeparator(final T object, final R separator) {
    final ObjectEntry<T, R> newObject = new ObjectEntry<T, R>(this);
    newObject.setObject(object);
    boolean _notEquals = (!Objects.equal(separator, null));
    if (_notEquals) {
      final SeparatorEntry<T, R> newSeparator = new SeparatorEntry<T, R>();
      newSeparator.setSeparator(separator);
      newObject.next = newSeparator;
      newSeparator.previous = newObject;
    }
    boolean _equals = Objects.equal(this.first, null);
    if (_equals) {
      this.first = newObject;
    } else {
      Iterable<SeparatorEntry<T, R>> _separators = this.separators();
      final SeparatorEntry<T, R> last = IterableExtensions.<SeparatorEntry<T, R>>last(_separators);
      newObject.previous = last;
      last.next = newObject;
    }
  }
  
  @Override
  public Iterator<ObjectEntry<T, R>> iterator() {
    abstract class __SeparatorRegions_1 extends AbstractIterator<ObjectEntry<T, R>> {
      ObjectEntry<T, R> next;
    }
    
    return new __SeparatorRegions_1() {
      {
        next = SeparatorRegions.this.first;
      }
      @Override
      protected ObjectEntry<T, R> computeNext() {
        ObjectEntry<T, R> _xblockexpression = null;
        {
          boolean _equals = Objects.equal(this.next, null);
          if (_equals) {
            return this.endOfData();
          }
          final ObjectEntry<T, R> current = this.next;
          ObjectEntry<T, R> _trailingObject = this.next.getTrailingObject();
          this.next = _trailingObject;
          _xblockexpression = current;
        }
        return _xblockexpression;
      }
    };
  }
  
  public Iterable<SeparatorEntry<T, R>> separators() {
    return new Iterable<SeparatorEntry<T, R>>() {
      @Override
      public Iterator<SeparatorEntry<T, R>> iterator() {
        abstract class ____SeparatorRegions_1 extends AbstractIterator<SeparatorEntry<T, R>> {
          SeparatorEntry<T, R> next;
        }
        
        return new ____SeparatorRegions_1() {
          {
            next = SeparatorRegions.this.first.getTrailingSeparator();
          }
          @Override
          protected SeparatorEntry<T, R> computeNext() {
            SeparatorEntry<T, R> _xblockexpression = null;
            {
              boolean _equals = Objects.equal(this.next, null);
              if (_equals) {
                return this.endOfData();
              }
              final SeparatorEntry<T, R> current = this.next;
              SeparatorEntry<T, R> _trailingSeparator = this.next.getTrailingSeparator();
              this.next = _trailingSeparator;
              _xblockexpression = current;
            }
            return _xblockexpression;
          }
        };
      }
    };
  }
  
  @Override
  public String toString() {
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(this.first, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        final ArrayList<String> list = CollectionLiterals.<String>newArrayList();
        Entry<T, R> current = this.first.getLeadingSeparator();
        while ((!Objects.equal(current, null))) {
          {
            String _string = current.toString();
            list.add(_string);
            current = current.next;
          }
        }
        _xblockexpression = IterableExtensions.join(list, "\n");
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = "empty";
    }
    return _xifexpression;
  }
  
  public SeparatorRegions(final ITextSegment root) {
    super();
    this.root = root;
  }
  
  @Pure
  public ITextSegment getRoot() {
    return this.root;
  }
}
