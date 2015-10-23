/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.labeling;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Provides labels for a EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class ArithmeticsLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public ArithmeticsLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public String text(final Module ele) {
    return ele.getName();
  }
  
  public String text(final Definition ele) {
    String _name = ele.getName();
    EList<DeclaredParameter> _args = ele.getArgs();
    final Function1<DeclaredParameter, CharSequence> _function = new Function1<DeclaredParameter, CharSequence>() {
      @Override
      public CharSequence apply(final DeclaredParameter it) {
        return it.getName();
      }
    };
    String _join = IterableExtensions.<DeclaredParameter>join(_args, "(", ",", ")", _function);
    return (_name + _join);
  }
  
  public String image(final Module ele) {
    return "home_nav.gif";
  }
}
