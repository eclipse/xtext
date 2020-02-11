/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.formatting2;

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
    if ((this.first == null)) {
      this.first = newObject;
    } else {
      newObject.next = this.first.getLeadingSeparator();
      SeparatorEntry<T, R> _leadingSeparator = this.first.getLeadingSeparator();
      _leadingSeparator.next = newObject;
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
    if ((this.first == null)) {
      this.first = newObject;
    } else {
      newObject.next = this.first.getLeadingSeparator();
      SeparatorEntry<T, R> _leadingSeparator = this.first.getLeadingSeparator();
      _leadingSeparator.previous = newObject;
      this.first = newObject;
    }
  }
  
  public void appendWithTrailingSeparator(final T object, final R separator) {
    final ObjectEntry<T, R> newObject = new ObjectEntry<T, R>(this);
    newObject.setObject(object);
    if ((separator != null)) {
      final SeparatorEntry<T, R> newSeparator = new SeparatorEntry<T, R>();
      newSeparator.setSeparator(separator);
      newObject.next = newSeparator;
      newSeparator.previous = newObject;
    }
    if ((this.first == null)) {
      this.first = newObject;
    } else {
      final SeparatorEntry<T, R> last = IterableExtensions.<SeparatorEntry<T, R>>last(this.separators());
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
          if ((this.next == null)) {
            return this.endOfData();
          }
          final ObjectEntry<T, R> current = this.next;
          this.next = this.next.getTrailingObject();
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
              if ((this.next == null)) {
                return this.endOfData();
              }
              final SeparatorEntry<T, R> current = this.next;
              this.next = this.next.getTrailingSeparator();
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
    if ((this.first != null)) {
      String _xblockexpression = null;
      {
        final ArrayList<String> list = CollectionLiterals.<String>newArrayList();
        Entry<T, R> current = this.first.getLeadingSeparator();
        while ((current != null)) {
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
