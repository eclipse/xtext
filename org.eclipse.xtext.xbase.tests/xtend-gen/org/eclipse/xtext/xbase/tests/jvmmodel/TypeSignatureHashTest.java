/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.descriptions.JvmDeclaredTypeSignatureHashProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * The remaining tests are in xtend.core.tests, as it is a lot easier to specify JvmModels in Xtend ;-)
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeSignatureHashTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private JvmDeclaredTypeSignatureHashProvider _jvmDeclaredTypeSignatureHashProvider;
  
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  @Extension
  private TypeReferences _typeReferences;
  
  @Test
  public void testSubType() {
    final EObject eObject = EcoreFactory.eINSTANCE.createEObject();
    final JvmGenericType bar = this._jvmTypesBuilder.toClass(eObject, "Bar");
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      EList<JvmMember> _members = it.getMembers();
      this._jvmTypesBuilder.<JvmGenericType>operator_add(_members, bar);
    };
    final JvmGenericType foo = this._jvmTypesBuilder.toClass(eObject, "Foo", _function);
    final String hash = this._jvmDeclaredTypeSignatureHashProvider.getHash(foo);
    EList<JvmMember> _members = bar.getMembers();
    final Procedure1<JvmConstructor> _function_1 = (JvmConstructor it) -> {
    };
    JvmConstructor _constructor = this._jvmTypesBuilder.toConstructor(eObject, _function_1);
    this._jvmTypesBuilder.<JvmConstructor>operator_add(_members, _constructor);
    Assert.assertEquals(hash, this._jvmDeclaredTypeSignatureHashProvider.getHash(foo));
    bar.setSimpleName("Baz");
    Assert.assertFalse("Expected different hashes", Strings.equal(hash, this._jvmDeclaredTypeSignatureHashProvider.getHash(foo)));
  }
  
  @Test
  public void testUnsealedType() {
    final EObject eObject = EcoreFactory.eINSTANCE.createEObject();
    final JvmGenericType bar = this._jvmTypesBuilder.toClass(eObject, "Bar");
    Assert.assertFalse(Strings.equal("Bar", this._jvmDeclaredTypeSignatureHashProvider.getHash(bar)));
  }
  
  @Test
  public void testRecursiveInheritance() {
    final EObject eObject = EcoreFactory.eINSTANCE.createEObject();
    final JvmGenericType bar = this._jvmTypesBuilder.toClass(eObject, "Bar");
    final JvmGenericType foo = this._jvmTypesBuilder.toClass(eObject, "Foo");
    EList<JvmTypeReference> _superTypes = bar.getSuperTypes();
    JvmParameterizedTypeReference _createTypeRef = this._typeReferences.createTypeRef(foo);
    this._jvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes, _createTypeRef);
    EList<JvmTypeReference> _superTypes_1 = foo.getSuperTypes();
    JvmParameterizedTypeReference _createTypeRef_1 = this._typeReferences.createTypeRef(bar);
    this._jvmTypesBuilder.<JvmParameterizedTypeReference>operator_add(_superTypes_1, _createTypeRef_1);
    Assert.assertNotNull(this._jvmDeclaredTypeSignatureHashProvider.getHash(foo));
    Assert.assertFalse(Strings.equal(this._jvmDeclaredTypeSignatureHashProvider.getHash(foo), this._jvmDeclaredTypeSignatureHashProvider.getHash(bar)));
  }
  
  @Test
  public void testSealedType() {
    try {
      final XExpression e = this.expression("null");
      JvmType _findDeclaredType = this._typeReferences.findDeclaredType(String.class, e);
      Assert.assertEquals("java.lang.String", this._jvmDeclaredTypeSignatureHashProvider.getHash(((JvmDeclaredType) _findDeclaredType)));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
