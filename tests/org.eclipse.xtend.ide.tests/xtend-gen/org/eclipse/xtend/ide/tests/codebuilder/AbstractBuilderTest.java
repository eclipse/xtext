package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Assert;

@SuppressWarnings("all")
public class AbstractBuilderTest extends AbstractXtendUITestCase {
  protected final static String DEFAULT_BODY = "throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")";
  
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
  
  private JvmDeclaredType xtendClass;
  
  private JvmDeclaredType javaClass;
  
  protected JvmDeclaredType getXtendClass() {
    try {
      JvmDeclaredType _xblockexpression = null;
      {
        boolean _equals = Objects.equal(this.xtendClass, null);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("class Foo {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Foo", _builder.toString());
          EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
          XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
          JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
          this.xtendClass = _inferredType;
        }
        _xblockexpression = this.xtendClass;
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
        boolean _equals = Objects.equal(this.javaClass, null);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public class Bar {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          this._workbenchTestHelper.createFile("Bar.java", _builder.toString());
          IResourcesSetupUtil.waitForAutoBuild();
          JvmDeclaredType _xtendClass = this.getXtendClass();
          JvmTypeReference _typeForName = this._typeReferences.getTypeForName("Bar", _xtendClass);
          JvmType _type = _typeForName.getType();
          this.javaClass = ((JvmDeclaredType) _type);
        }
        _xblockexpression = this.javaClass;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected LightweightTypeReference createTypeRef(final JvmType type) {
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, type);
    return new ParameterizedTypeReference(_standardTypeReferenceOwner, type);
  }
  
  protected LightweightTypeReference createTypeRef(final Class<?> clazz, final EObject context) {
    StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, context);
    JvmType _findDeclaredType = this._typeReferences.findDeclaredType(clazz, context);
    return new ParameterizedTypeReference(_standardTypeReferenceOwner, _findDeclaredType);
  }
  
  protected void assertBuilds(final ICodeBuilder builder, final String expectedCode) {
    boolean _isValid = builder.isValid();
    Assert.assertTrue(_isValid);
    final StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
    builder.build(appendable);
    String _string = appendable.toString();
    Assert.assertEquals(expectedCode, _string);
  }
}
