/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractClosureTypeTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractOldAPIClosureTypeTest extends AbstractClosureTypeTest {
  public List<Object> resolvesClosuresTo(final String expression, final String... types) {
    final List<XClosure> closures = this.findClosures(expression);
    final ArrayList<Object> result = CollectionLiterals.<Object>newArrayList();
    final Procedure2<XClosure, Integer> _function = new Procedure2<XClosure, Integer>() {
      public void apply(final XClosure closure, final Integer index) {
        ITypeProvider _typeProvider = AbstractOldAPIClosureTypeTest.this.getTypeProvider();
        final JvmTypeReference closureType = _typeProvider.getType(closure);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("failed for closure at ");
        _builder.append(index, "");
        _builder.append(": ");
        _builder.append(closureType, "");
        Assert.assertTrue(_builder.toString(), (closureType instanceof XFunctionTypeRef));
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("failed for closure at ");
        _builder_1.append(index, "");
        Object _get = types[(index).intValue()];
        String _simpleName = closureType.getSimpleName();
        Assert.assertEquals(_builder_1.toString(), _get, _simpleName);
        result.add(closureType);
      }
    };
    IterableExtensions.<XClosure>forEach(closures, _function);
    return result;
  }
  
  public void withEquivalents(final List<Object> references, final String... types) {
    final Procedure2<Object, Integer> _function = new Procedure2<Object, Integer>() {
      public void apply(final Object reference, final Integer index) {
        Assert.assertTrue((reference instanceof XFunctionTypeRef));
        Object _get = types[(index).intValue()];
        JvmTypeReference _equivalent = ((XFunctionTypeRef) reference).getEquivalent();
        String _simpleName = _equivalent.getSimpleName();
        Assert.assertEquals(_get, _simpleName);
      }
    };
    IterableExtensions.<Object>forEach(references, _function);
  }
  
  protected abstract ITypeProvider getTypeProvider();
}
