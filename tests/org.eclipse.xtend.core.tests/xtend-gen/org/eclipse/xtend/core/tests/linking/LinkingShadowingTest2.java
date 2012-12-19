/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.linking;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.linking.LinkingShadowingTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class LinkingShadowingTest2 extends LinkingShadowingTest {
  protected void assertLinksTo(final String identifier, final EClass type, final XAbstractFeatureCall featureCall, final boolean withIssues) {
    JvmIdentifiableElement _feature = featureCall.getFeature();
    Assert.assertNotNull("feature is available", _feature);
    final JvmIdentifiableElement linked = featureCall.getFeature();
    boolean _eIsProxy = linked.eIsProxy();
    Assert.assertFalse("is resolved", _eIsProxy);
    String _identifier = linked.getIdentifier();
    Assert.assertEquals(identifier, _identifier);
    boolean _isInstance = type.isInstance(linked);
    Assert.assertTrue(_isInstance);
  }
  
  @Test
  public void testOperation_implicitArgumentOnStatic() throws Exception {
    final XtendClass clazz = this.clazz(
      "import static testdata.LinkingStaticTypeEquallyNamed.*\n                class SomeClass {\n                  def void method(Object it) { \n                    withArgument \n                  }\n                }");
    final XAbstractFeatureCall featureCall = this.getFirstFeatureCall(clazz);
    JvmIdentifiableElement _feature = featureCall.getFeature();
    Assert.assertNotNull("feature is available", _feature);
    final JvmIdentifiableElement linked = featureCall.getFeature();
    boolean _eIsProxy = linked.eIsProxy();
    Assert.assertFalse("is resolved", _eIsProxy);
    boolean _or = false;
    String _identifier = linked.getIdentifier();
    boolean _equals = "testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object)".equals(_identifier);
    if (_equals) {
      _or = true;
    } else {
      String _identifier_1 = linked.getIdentifier();
      boolean _equals_1 = "testdata.LinkingStaticTypeEquallyNamed.withArgument(java.lang.Object,int,int)".equals(_identifier_1);
      _or = (_equals || _equals_1);
    }
    Assert.assertTrue(_or);
  }
}
