package org.eclipse.xtext.xbase.tests.linking;

import com.google.inject.Inject;
import junit.framework.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

@SuppressWarnings("all")
public class JvmModelBasedLinkingTest extends AbstractXbaseTestCase {
  
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TypeReferences refs;
  
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  public void testLinkToParameter() throws Exception {
    {
      XExpression _expression = this.expression("x", false);
      final XExpression expr = _expression;
      Resource _eResource = expr.eResource();
      final Resource resource = _eResource;
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
              final Function1<JvmOperation,Void> _function = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it) {
                    Void _xblockexpression = null;
                    {
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
                      JvmFormalParameter _parameter = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toParameter(expr, "x", _stringType);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      JvmModelBasedLinkingTest.this._jvmTypesBuilder.associate(expr, it);
                      _xblockexpression = (((Void) null));
                    }
                    return _xblockexpression;
                  }
                };
              JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType, _function);
              CollectionExtensions.<JvmOperation>operator_add(_members, _method);
              _xblockexpression = (((Void) null));
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this._jvmTypesBuilder.toClazz(expr, "Foo", _function);
      CollectionExtensions.<JvmGenericType>operator_add(_contents, _clazz);
      this._validationTestHelper.assertNoErrors(expr);
    }
  }
  
  public void testLinkToParameter_1() throws Exception {
    {
      XExpression _expression = this.expression("x", false);
      final XFeatureCall expr = ((XFeatureCall) _expression);
      Resource _eResource = expr.eResource();
      final Resource resource = _eResource;
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
              JvmField _field = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toField(expr, "x", _stringType);
              CollectionExtensions.<JvmField>operator_add(_members, _field);
              EList<JvmMember> _members_1 = it.getMembers();
              JvmTypeReference _stringType_1 = JvmModelBasedLinkingTest.this.stringType(expr);
              final Function1<JvmOperation,Void> _function = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it) {
                    Void _xblockexpression = null;
                    {
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
                      JvmFormalParameter _parameter = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toParameter(expr, "x", _stringType);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      JvmModelBasedLinkingTest.this._jvmTypesBuilder.<JvmOperation>associate(expr, it);
                      _xblockexpression = (((Void) null));
                    }
                    return _xblockexpression;
                  }
                };
              JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType_1, _function);
              CollectionExtensions.<JvmOperation>operator_add(_members_1, _method);
              _xblockexpression = (((Void) null));
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this._jvmTypesBuilder.toClazz(expr, "Foo", _function);
      CollectionExtensions.<JvmGenericType>operator_add(_contents, _clazz);
      this._validationTestHelper.assertNoErrors(expr);
      JvmIdentifiableElement _feature = expr.getFeature();
      Assert.assertTrue((_feature instanceof JvmFormalParameter));
    }
  }
  
  public void testLinkToField() throws Exception {
    {
      XExpression _expression = this.expression("x", false);
      final XFeatureCall expr = ((XFeatureCall) _expression);
      Resource _eResource = expr.eResource();
      final Resource resource = _eResource;
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
              JvmField _field = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toField(expr, "x", _stringType);
              CollectionExtensions.<JvmField>operator_add(_members, _field);
              EList<JvmMember> _members_1 = it.getMembers();
              JvmTypeReference _stringType_1 = JvmModelBasedLinkingTest.this.stringType(expr);
              final Function1<JvmOperation,Void> _function = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it) {
                    Void _xblockexpression = null;
                    {
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
                      JvmFormalParameter _parameter = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toParameter(expr, "y", _stringType);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      JvmModelBasedLinkingTest.this._jvmTypesBuilder.<JvmOperation>associate(expr, it);
                      _xblockexpression = (((Void) null));
                    }
                    return _xblockexpression;
                  }
                };
              JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType_1, _function);
              CollectionExtensions.<JvmOperation>operator_add(_members_1, _method);
              _xblockexpression = (((Void) null));
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this._jvmTypesBuilder.toClazz(expr, "Foo", _function);
      CollectionExtensions.<JvmGenericType>operator_add(_contents, _clazz);
      this._validationTestHelper.assertNoErrors(expr);
      JvmIdentifiableElement _feature = expr.getFeature();
      Assert.assertTrue((_feature instanceof JvmField));
    }
  }
  
  public void testLinkToField_1() throws Exception {
    {
      XExpression _expression = this.expression("x", false);
      final XFeatureCall expr = ((XFeatureCall) _expression);
      Resource _eResource = expr.eResource();
      final Resource resource = _eResource;
      resource.eSetDeliver(false);
      EList<EObject> _contents = resource.getContents();
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
              JvmField _field = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toField(expr, "x", _stringType);
              CollectionExtensions.<JvmField>operator_add(_members, _field);
              EList<JvmMember> _members_1 = it.getMembers();
              JvmTypeReference _stringType_1 = JvmModelBasedLinkingTest.this.stringType(expr);
              final Function1<JvmOperation,Void> _function = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it) {
                    Void _xblockexpression = null;
                    {
                      JvmModelBasedLinkingTest.this._jvmTypesBuilder.<JvmOperation>associate(expr, it);
                      _xblockexpression = (((Void) null));
                    }
                    return _xblockexpression;
                  }
                };
              JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "getX", _stringType_1, _function);
              CollectionExtensions.<JvmOperation>operator_add(_members_1, _method);
              _xblockexpression = (((Void) null));
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this._jvmTypesBuilder.toClazz(expr, "Foo", _function);
      CollectionExtensions.<JvmGenericType>operator_add(_contents, _clazz);
      this._validationTestHelper.assertNoErrors(expr);
      JvmIdentifiableElement _feature = expr.getFeature();
      Assert.assertTrue((_feature instanceof JvmField));
    }
  }
  
  public JvmTypeReference stringType(final EObject ctx) {
    JvmTypeReference _typeForName = this.refs.getTypeForName(java.lang.String.class, ctx);
    return _typeForName;
  }
}