/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@SuppressWarnings("all")
public class Formatter2Fragment2Test {
  public static class TestableFormatter2Fragment2 extends Formatter2Fragment2 {
    @Override
    public String toVarName(final ENamedElement element, final String... reservedNames) {
      return super.toVarName(element, reservedNames);
    }
  }
  
  private Formatter2Fragment2Test.TestableFormatter2Fragment2 fragment = new Formatter2Fragment2Test.TestableFormatter2Fragment2();
  
  @Test
  public void testVarNameWithEClass() {
    Assert.assertEquals("eClass", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass()));
  }
  
  @Test
  public void testVarNameWithMultiReference() {
    Assert.assertEquals("eOperation", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass_EAllOperations()));
  }
  
  @Test
  public void testVarNameWithSingleReference() {
    Assert.assertEquals("name", this.fragment.toVarName(EcorePackage.eINSTANCE.getENamedElement_Name()));
  }
  
  @Test
  public void testVarNameConflictingWithXtendKeyword() {
    Assert.assertEquals("_abstract", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass_Abstract()));
  }
  
  @Test
  public void testVarNameConflictingWithParam() {
    EAttribute _createEAttribute = EcoreFactory.eINSTANCE.createEAttribute();
    final Procedure1<EAttribute> _function = (EAttribute it) -> {
      it.setName("xxx");
    };
    EAttribute _doubleArrow = ObjectExtensions.<EAttribute>operator_doubleArrow(_createEAttribute, _function);
    Assert.assertEquals("_xxx", this.fragment.toVarName(_doubleArrow), "xxx");
  }
  
  @Test
  public void testVarNameConflictingWithXtendKeywordAndParam() {
    Assert.assertEquals("__abstract", this.fragment.toVarName(EcorePackage.eINSTANCE.getEClass_Abstract(), "_abstract"));
  }
}
