/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public class LoopExtensions {
  /**
   * Iterates elements and execute the procedure.
   * A prefix, a separator and a suffix can be initialized with the loopInitializer lambda.
   */
  public <T extends Object> void forEach(final ITreeAppendable appendable, final Iterable<T> elements, final Procedure1<? super LoopParams> loopInitializer, final Procedure1<? super T> procedure) {
    boolean _isEmpty = IterableExtensions.isEmpty(elements);
    if (_isEmpty) {
      return;
    }
    LoopParams _loopParams = new LoopParams();
    final LoopParams params = ObjectExtensions.<LoopParams>operator_doubleArrow(_loopParams, loopInitializer);
    params.appendPrefix(appendable);
    T _head = IterableExtensions.<T>head(elements);
    ObjectExtensions.<T>operator_doubleArrow(_head, procedure);
    Iterable<T> _tail = IterableExtensions.<T>tail(elements);
    final Procedure1<T> _function = new Procedure1<T>() {
      public void apply(final T it) {
        params.appendSeparator(appendable);
        ObjectExtensions.<T>operator_doubleArrow(it, procedure);
      }
    };
    IterableExtensions.<T>forEach(_tail, _function);
    params.appendSuffix(appendable);
  }
  
  /**
   * Uses curly braces and comma as delimiters. Doesn't use them for single valued iterables.
   */
  public <T extends Object> void forEachWithShortcut(final ITreeAppendable appendable, final Iterable<T> elements, final Procedure1<? super T> procedure) {
    int _size = IterableExtensions.size(elements);
    boolean _equals = (_size == 1);
    if (_equals) {
      T _head = IterableExtensions.<T>head(elements);
      ObjectExtensions.<T>operator_doubleArrow(_head, procedure);
    } else {
      appendable.append("{");
      final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
        public void apply(final LoopParams it) {
          it.setSeparator(", ");
        }
      };
      this.<T>forEach(appendable, elements, _function, procedure);
      appendable.append("}");
    }
  }
}
