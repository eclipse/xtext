/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.CompositeGeneratorException;
import org.eclipse.xtext.xtext.generator.IXtextGeneratorFragment;
import org.eclipse.xtext.xtext.generator.Issues;

/**
 * A generator fragment that delegates to a list of contained fragments. This can be
 * useful for extracting parts of a language configuration to a separate mwe2 file,
 * for example.
 */
@SuppressWarnings("all")
public class CompositeGeneratorFragment2 implements IXtextGeneratorFragment {
  @Accessors(AccessorType.PROTECTED_GETTER)
  private final List<IXtextGeneratorFragment> fragments = CollectionLiterals.<IXtextGeneratorFragment>newArrayList();
  
  public void addFragment(final IXtextGeneratorFragment fragment) {
    if ((fragment == this)) {
      throw new IllegalArgumentException();
    }
    this.fragments.add(fragment);
  }
  
  @Override
  public void checkConfiguration(final Issues issues) {
    for (final IXtextGeneratorFragment fragment : this.fragments) {
      fragment.checkConfiguration(issues);
    }
  }
  
  @Override
  public void generate() {
    final CompositeGeneratorException composite = new CompositeGeneratorException();
    for (final IXtextGeneratorFragment fragment : this.fragments) {
      try {
        fragment.generate();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          composite.addException(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    boolean _hasExceptions = composite.hasExceptions();
    if (_hasExceptions) {
      throw composite;
    }
  }
  
  @Override
  public void initialize(final Injector injector) {
    for (final IXtextGeneratorFragment fragment : this.fragments) {
      fragment.initialize(injector);
    }
  }
  
  @Pure
  protected List<IXtextGeneratorFragment> getFragments() {
    return this.fragments;
  }
}
