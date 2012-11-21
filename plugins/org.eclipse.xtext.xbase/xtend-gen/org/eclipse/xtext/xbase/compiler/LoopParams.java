/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class LoopParams {
  private Function1<? super ITreeAppendable,? extends ITreeAppendable> prefix;
  
  private Function1<? super ITreeAppendable,? extends ITreeAppendable> separator;
  
  private Function1<? super ITreeAppendable,? extends ITreeAppendable> suffix;
  
  public Function1<? super ITreeAppendable,? extends ITreeAppendable> setPrefix(final Function1<? super ITreeAppendable,? extends ITreeAppendable> prefix) {
    Function1<? super ITreeAppendable,? extends ITreeAppendable> _prefix = this.prefix = prefix;
    return _prefix;
  }
  
  public Function1<? super ITreeAppendable,? extends ITreeAppendable> setSeparator(final Function1<? super ITreeAppendable,? extends ITreeAppendable> separator) {
    Function1<? super ITreeAppendable,? extends ITreeAppendable> _separator = this.separator = separator;
    return _separator;
  }
  
  public Function1<? super ITreeAppendable,? extends ITreeAppendable> setSuffix(final Function1<? super ITreeAppendable,? extends ITreeAppendable> suffix) {
    Function1<? super ITreeAppendable,? extends ITreeAppendable> _suffix = this.suffix = suffix;
    return _suffix;
  }
  
  public Function1<? super ITreeAppendable,? extends ITreeAppendable> setPrefix(final String prefix) {
    final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
        public ITreeAppendable apply(final ITreeAppendable it) {
          ITreeAppendable _append = it.append(prefix);
          return _append;
        }
      };
    Function1<? super ITreeAppendable,? extends ITreeAppendable> _prefix = this.prefix = _function;
    return _prefix;
  }
  
  public Function1<? super ITreeAppendable,? extends ITreeAppendable> setSeparator(final String separator) {
    final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
        public ITreeAppendable apply(final ITreeAppendable it) {
          ITreeAppendable _append = it.append(separator);
          return _append;
        }
      };
    Function1<? super ITreeAppendable,? extends ITreeAppendable> _separator = this.separator = _function;
    return _separator;
  }
  
  public Function1<? super ITreeAppendable,? extends ITreeAppendable> setSuffix(final String suffix) {
    final Function1<ITreeAppendable,ITreeAppendable> _function = new Function1<ITreeAppendable,ITreeAppendable>() {
        public ITreeAppendable apply(final ITreeAppendable it) {
          ITreeAppendable _append = it.append(suffix);
          return _append;
        }
      };
    Function1<? super ITreeAppendable,? extends ITreeAppendable> _suffix = this.suffix = _function;
    return _suffix;
  }
  
  public ITreeAppendable appendPrefix(final ITreeAppendable app) {
    ITreeAppendable _xblockexpression = null;
    {
      if (this.prefix!=null) this.prefix.apply(app);
      _xblockexpression = (app);
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable appendSeparator(final ITreeAppendable app) {
    ITreeAppendable _xblockexpression = null;
    {
      if (this.separator!=null) this.separator.apply(app);
      _xblockexpression = (app);
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable appendSuffix(final ITreeAppendable app) {
    ITreeAppendable _xblockexpression = null;
    {
      if (this.suffix!=null) this.suffix.apply(app);
      _xblockexpression = (app);
    }
    return _xblockexpression;
  }
}
