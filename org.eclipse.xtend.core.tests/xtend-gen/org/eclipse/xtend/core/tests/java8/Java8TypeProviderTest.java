/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.java8;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author koehnlein - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(Java8RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class Java8TypeProviderTest {
  @Inject
  private IJvmTypeProvider.Factory typeProviderFactory;

  @Inject
  private ParseHelper<XtendFile> parseHelper;

  @Test
  public void testDefaultJavaMethod() {
    final IJvmTypeProvider typeProvider = this.typeProviderFactory.createTypeProvider();
    JvmType _findTypeByName = typeProvider.findTypeByName(JavaInterface.class.getCanonicalName());
    final JvmGenericType intf = ((JvmGenericType) _findTypeByName);
    this.doTestMethods(intf);
  }

  @Test
  public void testDefaultXtendMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface XtendInterface {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void defaultMethod() {} ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static def void staticMethod() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parseHelper.parse(_builder);
      EObject _lastOrNull = IterableExtensions.<EObject>lastOrNull(file.eResource().getContents());
      final JvmGenericType intf = ((JvmGenericType) _lastOrNull);
      this.doTestMethods(intf);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected void doTestMethods(final JvmGenericType intf) {
    final Function1<JvmOperation, Boolean> _function = (JvmOperation it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equals(_simpleName, "staticMethod"));
    };
    final JvmOperation staticMethod = IterableExtensions.<JvmOperation>head(IterableExtensions.<JvmOperation>filter(Iterables.<JvmOperation>filter(intf.getMembers(), JvmOperation.class), _function));
    Assert.assertNotNull(staticMethod);
    Assert.assertFalse(staticMethod.isAbstract());
    Assert.assertTrue(staticMethod.isStatic());
    Assert.assertFalse(staticMethod.isDefault());
    final Function1<JvmOperation, Boolean> _function_1 = (JvmOperation it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equals(_simpleName, "defaultMethod"));
    };
    final JvmOperation defaultMethod = IterableExtensions.<JvmOperation>head(IterableExtensions.<JvmOperation>filter(Iterables.<JvmOperation>filter(intf.getMembers(), JvmOperation.class), _function_1));
    Assert.assertNotNull(defaultMethod);
    Assert.assertFalse(defaultMethod.isAbstract());
    Assert.assertFalse(defaultMethod.isStatic());
    Assert.assertTrue(defaultMethod.isDefault());
  }
}
