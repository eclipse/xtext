/**
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
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
    public String toVarName(final ENamedElement element) {
      return super.toVarName(element);
    }
  }
  
  private Formatter2Fragment2Test.TestableFormatter2Fragment2 fragment = new Formatter2Fragment2Test.TestableFormatter2Fragment2();
  
  @Test
  public void testVarNameWithEClass() {
    EClass _eClass = EcorePackage.eINSTANCE.getEClass();
    String _varName = this.fragment.toVarName(_eClass);
    Assert.assertEquals("eClass", _varName);
  }
  
  @Test
  public void testVarNameWithMultiReference() {
    EReference _eClass_EAllOperations = EcorePackage.eINSTANCE.getEClass_EAllOperations();
    String _varName = this.fragment.toVarName(_eClass_EAllOperations);
    Assert.assertEquals("eOperation", _varName);
  }
  
  @Test
  public void testVarNameWithSingleReference() {
    EAttribute _eNamedElement_Name = EcorePackage.eINSTANCE.getENamedElement_Name();
    String _varName = this.fragment.toVarName(_eNamedElement_Name);
    Assert.assertEquals("name", _varName);
  }
  
  @Test
  public void testVarNameConflictingWithXtendKeyword() {
    EAttribute _eClass_Abstract = EcorePackage.eINSTANCE.getEClass_Abstract();
    String _varName = this.fragment.toVarName(_eClass_Abstract);
    Assert.assertEquals("_abstract", _varName);
  }
}
