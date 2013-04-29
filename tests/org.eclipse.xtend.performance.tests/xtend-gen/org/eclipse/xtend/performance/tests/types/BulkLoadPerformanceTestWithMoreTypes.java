/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.performance.tests.types;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.eclipse.xtend.performance.tests.types.BulkLoadPerformanceTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.scoping.batch.ImplicitlyImportedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class BulkLoadPerformanceTestWithMoreTypes extends BulkLoadPerformanceTest {
  protected List<Class<? extends Object>> getTypesToLoad() {
    try {
      final List<Class<?>> result = CollectionLiterals.<Class<? extends Object>>newArrayList();
      ImplicitlyImportedTypes _implicitlyImportedTypes = new ImplicitlyImportedTypes();
      Object _invoke = this._reflectExtensions.invoke(_implicitlyImportedTypes, "getExtensionClasses");
      Iterables.<Class<? extends Object>>addAll(result, ((List<Class<?>>) _invoke));
      List<? extends Class<? extends Object>> _xlistliteral = null;
      Builder<Class<? extends Object>> _builder = ImmutableList.builder();
      _builder.add(List.class);
      _builder.add(Collection.class);
      _builder.add(Set.class);
      _builder.add(StringBuilder.class);
      _builder.add(StringBuffer.class);
      _builder.add(CharSequence.class);
      _builder.add(String.class);
      _builder.add(Class.class);
      _builder.add(Multimaps.class);
      _builder.add(Iterators.class);
      _builder.add(Lists.class);
      _builder.add(Collections.class);
      _builder.add(Collections2.class);
      _builder.add(JButton.class);
      _builder.add(JTextField.class);
      _xlistliteral = _builder.build();
      Iterables.<Class<? extends Object>>addAll(result, _xlistliteral);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
