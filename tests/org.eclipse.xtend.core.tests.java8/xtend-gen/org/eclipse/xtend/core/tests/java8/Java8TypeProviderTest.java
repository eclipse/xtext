/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.java8;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.java8.JavaInterface;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
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
    String _canonicalName = JavaInterface.class.getCanonicalName();
    JvmType _findTypeByName = typeProvider.findTypeByName(_canonicalName);
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
      Resource _eResource = file.eResource();
      EList<EObject> _contents = _eResource.getContents();
      EObject _last = IterableExtensions.<EObject>last(_contents);
      final JvmGenericType intf = ((JvmGenericType) _last);
      this.doTestMethods(intf);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void doTestMethods(final JvmGenericType intf) {
    EList<JvmMember> _members = intf.getMembers();
    Iterable<JvmOperation> _filter = Iterables.<JvmOperation>filter(_members, JvmOperation.class);
    final Function1<JvmOperation, Boolean> _function = (JvmOperation it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "staticMethod"));
    };
    Iterable<JvmOperation> _filter_1 = IterableExtensions.<JvmOperation>filter(_filter, _function);
    final JvmOperation staticMethod = IterableExtensions.<JvmOperation>head(_filter_1);
    Assert.assertNotNull(staticMethod);
    boolean _isAbstract = staticMethod.isAbstract();
    Assert.assertFalse(_isAbstract);
    boolean _isStatic = staticMethod.isStatic();
    Assert.assertTrue(_isStatic);
    boolean _isDefault = staticMethod.isDefault();
    Assert.assertFalse(_isDefault);
    EList<JvmMember> _members_1 = intf.getMembers();
    Iterable<JvmOperation> _filter_2 = Iterables.<JvmOperation>filter(_members_1, JvmOperation.class);
    final Function1<JvmOperation, Boolean> _function_1 = (JvmOperation it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "defaultMethod"));
    };
    Iterable<JvmOperation> _filter_3 = IterableExtensions.<JvmOperation>filter(_filter_2, _function_1);
    final JvmOperation defaultMethod = IterableExtensions.<JvmOperation>head(_filter_3);
    Assert.assertNotNull(defaultMethod);
    boolean _isAbstract_1 = defaultMethod.isAbstract();
    Assert.assertFalse(_isAbstract_1);
    boolean _isStatic_1 = defaultMethod.isStatic();
    Assert.assertFalse(_isStatic_1);
    boolean _isDefault_1 = defaultMethod.isDefault();
    Assert.assertTrue(_isDefault_1);
  }
}
