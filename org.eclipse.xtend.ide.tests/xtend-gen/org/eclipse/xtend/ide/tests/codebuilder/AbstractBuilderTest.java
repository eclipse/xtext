/**
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.AfterClass;
import org.junit.Assert;

@SuppressWarnings("all")
public abstract class AbstractBuilderTest extends AbstractXtendUITestCase {
  protected static final String DEFAULT_BODY = "throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")";

  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;

  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;

  @Inject
  @Extension
  private TypeReferences _typeReferences;

  @Inject
  private CommonTypeComputationServices services;

  private static JvmDeclaredType xtendClass;

  private static JvmDeclaredType javaClass;

  @AfterClass
  public static void cleanUpTestData() {
    AbstractBuilderTest.xtendClass = null;
    AbstractBuilderTest.javaClass = null;
  }

  protected JvmDeclaredType getXtendClass() {
    try {
      JvmDeclaredType _xblockexpression = null;
      {
        if ((AbstractBuilderTest.xtendClass == null)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("class Foo {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(this._workbenchTestHelper.xtendFile("Foo", _builder.toString()).getXtendTypes());
          AbstractBuilderTest.xtendClass = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
        }
        _xblockexpression = AbstractBuilderTest.xtendClass;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected JvmDeclaredType getJavaClass() {
    try {
      JvmDeclaredType _xblockexpression = null;
      {
        if ((AbstractBuilderTest.javaClass == null)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public class Bar {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          this._workbenchTestHelper.createFile("Bar.java", _builder.toString());
          IResourcesSetupUtil.waitForBuild();
          JvmType _type = this._typeReferences.getTypeForName("Bar", this.getXtendClass()).getType();
          AbstractBuilderTest.javaClass = ((JvmDeclaredType) _type);
        }
        _xblockexpression = AbstractBuilderTest.javaClass;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected LightweightTypeReference createTypeRef(final JvmType type) {
    ParameterizedTypeReference _xblockexpression = null;
    {
      final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, type);
      _xblockexpression = owner.newParameterizedTypeReference(type);
    }
    return _xblockexpression;
  }

  protected LightweightTypeReference createTypeRef(final Class<?> clazz, final EObject context) {
    LightweightTypeReference _xblockexpression = null;
    {
      final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, context);
      _xblockexpression = owner.newReferenceTo(clazz);
    }
    return _xblockexpression;
  }

  protected void assertBuilds(final ICodeBuilder builder, final String expectedCode) {
    Assert.assertTrue(builder.isValid());
    final StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
    builder.build(appendable);
    Assert.assertEquals(Strings.toUnixLineSeparator(expectedCode), appendable.toString());
  }
}
