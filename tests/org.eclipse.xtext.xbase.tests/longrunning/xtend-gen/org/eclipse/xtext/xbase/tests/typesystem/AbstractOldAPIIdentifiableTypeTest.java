/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractIdentifiableTypeTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractOldAPIIdentifiableTypeTest extends AbstractIdentifiableTypeTest {
  public void resolvesIdentifiablesTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<JvmIdentifiableElement> identifiables = this.findIdentifiables(expressionWithQualifiedNames);
    final Procedure2<JvmIdentifiableElement, Integer> _function = new Procedure2<JvmIdentifiableElement, Integer>() {
      public void apply(final JvmIdentifiableElement identifiable, final Integer index) {
        ITypeProvider _typeProvider = AbstractOldAPIIdentifiableTypeTest.this.getTypeProvider();
        final JvmTypeReference type = _typeProvider.getTypeForIdentifiable(identifiable);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("failed for identifiable at ");
        _builder.append(index, "");
        Object _get = types[(index).intValue()];
        String _simpleName = type.getSimpleName();
        Assert.assertEquals(_builder.toString(), _get, _simpleName);
      }
    };
    IterableExtensions.<JvmIdentifiableElement>forEach(identifiables, _function);
  }
  
  protected abstract ITypeProvider getTypeProvider();
}
