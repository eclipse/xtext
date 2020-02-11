/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class LoopParams {
  private Function1<? super ITreeAppendable, ? extends ITreeAppendable> prefix;
  
  private Function1<? super ITreeAppendable, ? extends ITreeAppendable> separator;
  
  private Function1<? super ITreeAppendable, ? extends ITreeAppendable> suffix;
  
  public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setPrefix(final Function1<? super ITreeAppendable, ? extends ITreeAppendable> prefix) {
    return this.prefix = prefix;
  }
  
  public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSeparator(final Function1<? super ITreeAppendable, ? extends ITreeAppendable> separator) {
    return this.separator = separator;
  }
  
  public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSuffix(final Function1<? super ITreeAppendable, ? extends ITreeAppendable> suffix) {
    return this.suffix = suffix;
  }
  
  public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setPrefix(final String prefix) {
    final Function1<ITreeAppendable, ITreeAppendable> _function = (ITreeAppendable it) -> {
      return it.append(prefix);
    };
    return this.prefix = _function;
  }
  
  public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSeparator(final String separator) {
    final Function1<ITreeAppendable, ITreeAppendable> _function = (ITreeAppendable it) -> {
      return it.append(separator);
    };
    return this.separator = _function;
  }
  
  public Function1<? super ITreeAppendable, ? extends ITreeAppendable> setSuffix(final String suffix) {
    final Function1<ITreeAppendable, ITreeAppendable> _function = (ITreeAppendable it) -> {
      return it.append(suffix);
    };
    return this.suffix = _function;
  }
  
  public ITreeAppendable appendPrefix(final ITreeAppendable app) {
    ITreeAppendable _xblockexpression = null;
    {
      if (this.prefix!=null) {
        this.prefix.apply(app);
      }
      _xblockexpression = app;
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable appendSeparator(final ITreeAppendable app) {
    ITreeAppendable _xblockexpression = null;
    {
      if (this.separator!=null) {
        this.separator.apply(app);
      }
      _xblockexpression = app;
    }
    return _xblockexpression;
  }
  
  public ITreeAppendable appendSuffix(final ITreeAppendable app) {
    ITreeAppendable _xblockexpression = null;
    {
      if (this.suffix!=null) {
        this.suffix.apply(app);
      }
      _xblockexpression = app;
    }
    return _xblockexpression;
  }
}
