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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractConstructorCallTypeTest;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractOldAPIConstructorCallTypeTest extends AbstractConstructorCallTypeTest {
  public void resolvesConstructorCallsTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XConstructorCall> featureCalls = this.findConstructorCalls(expressionWithQualifiedNames);
    final Procedure2<XConstructorCall, Integer> _function = new Procedure2<XConstructorCall, Integer>() {
      public void apply(final XConstructorCall featureCall, final Integer index) {
        ITypeProvider _typeProvider = AbstractOldAPIConstructorCallTypeTest.this.getTypeProvider();
        final JvmTypeReference type = _typeProvider.getType(featureCall);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("failed for constructor call at ");
        _builder.append(index, "");
        Object _get = types[(index).intValue()];
        String _simpleName = type.getSimpleName();
        Assert.assertEquals(_builder.toString(), _get, _simpleName);
      }
    };
    IterableExtensions.<XConstructorCall>forEach(featureCalls, _function);
  }
  
  protected abstract ITypeProvider getTypeProvider();
}
