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
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

@SuppressWarnings("all")
public class JvmModelBasedLinkingTest extends AbstractXbaseTestCase {
  @Inject
  private JvmTypesBuilder _jvmTypesBuilder;
  
  @Inject
  private TypeReferences refs;
  
  @Inject
  private ValidationTestHelper _validationTestHelper;
  
  public void testLinkToParameter() {
    try {
      {
        XExpression _expression = this.expression("x", false);
        final XExpression expr = _expression;
        Resource _eResource = expr.eResource();
        final Resource resource = _eResource;
        resource.eSetDeliver(false);
        EList<EObject> _contents = resource.getContents();
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
            public void apply(final JvmGenericType it) {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
              final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                  public void apply(final JvmOperation it) {
                    {
                      EList<JvmFormalParameter> _parameters = it.getParameters();
                      JvmTypeReference _stringType_1 = JvmModelBasedLinkingTest.this.stringType(expr);
                      JvmFormalParameter _parameter = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toParameter(expr, "x", _stringType_1);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      JvmModelBasedLinkingTest.this._jvmTypesBuilder.setBody(it, expr);
                    }
                  }
                };
              JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType, _function);
              CollectionExtensions.<JvmOperation>operator_add(_members, _method);
            }
          };
        JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
        CollectionExtensions.<JvmGenericType>operator_add(_contents, _class);
        this._validationTestHelper.assertNoErrors(expr);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testLinkToParameter_1() {
    try {
      {
        XExpression _expression = this.expression("x", false);
        final XFeatureCall expr = ((XFeatureCall) _expression);
        Resource _eResource = expr.eResource();
        final Resource resource = _eResource;
        resource.eSetDeliver(false);
        EList<EObject> _contents = resource.getContents();
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
            public void apply(final JvmGenericType it) {
              {
                EList<JvmMember> _members = it.getMembers();
                JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
                JvmField _field = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toField(expr, "x", _stringType);
                CollectionExtensions.<JvmField>operator_add(_members, _field);
                EList<JvmMember> _members_1 = it.getMembers();
                JvmTypeReference _stringType_1 = JvmModelBasedLinkingTest.this.stringType(expr);
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      {
                        EList<JvmFormalParameter> _parameters = it.getParameters();
                        JvmTypeReference _stringType_2 = JvmModelBasedLinkingTest.this.stringType(expr);
                        JvmFormalParameter _parameter = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toParameter(expr, "x", _stringType_2);
                        CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                        JvmModelBasedLinkingTest.this._jvmTypesBuilder.setBody(it, expr);
                      }
                    }
                  };
                JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType_1, _function);
                CollectionExtensions.<JvmOperation>operator_add(_members_1, _method);
              }
            }
          };
        JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
        CollectionExtensions.<JvmGenericType>operator_add(_contents, _class);
        this._validationTestHelper.assertNoErrors(expr);
        JvmIdentifiableElement _feature = expr.getFeature();
        Assert.assertTrue((_feature instanceof JvmFormalParameter));
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testLinkToField() {
    try {
      {
        XExpression _expression = this.expression("x", false);
        final XFeatureCall expr = ((XFeatureCall) _expression);
        Resource _eResource = expr.eResource();
        final Resource resource = _eResource;
        resource.eSetDeliver(false);
        EList<EObject> _contents = resource.getContents();
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
            public void apply(final JvmGenericType it) {
              {
                EList<JvmMember> _members = it.getMembers();
                JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
                JvmField _field = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toField(expr, "x", _stringType);
                CollectionExtensions.<JvmField>operator_add(_members, _field);
                EList<JvmMember> _members_1 = it.getMembers();
                JvmTypeReference _stringType_1 = JvmModelBasedLinkingTest.this.stringType(expr);
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      {
                        EList<JvmFormalParameter> _parameters = it.getParameters();
                        JvmTypeReference _stringType_2 = JvmModelBasedLinkingTest.this.stringType(expr);
                        JvmFormalParameter _parameter = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toParameter(expr, "y", _stringType_2);
                        CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                        JvmModelBasedLinkingTest.this._jvmTypesBuilder.setBody(it, expr);
                      }
                    }
                  };
                JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "doStuff", _stringType_1, _function);
                CollectionExtensions.<JvmOperation>operator_add(_members_1, _method);
              }
            }
          };
        JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
        CollectionExtensions.<JvmGenericType>operator_add(_contents, _class);
        this._validationTestHelper.assertNoErrors(expr);
        JvmIdentifiableElement _feature = expr.getFeature();
        Assert.assertTrue((_feature instanceof JvmField));
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void testLinkToField_1() {
    try {
      {
        XExpression _expression = this.expression("x", false);
        final XFeatureCall expr = ((XFeatureCall) _expression);
        Resource _eResource = expr.eResource();
        final Resource resource = _eResource;
        resource.eSetDeliver(false);
        EList<EObject> _contents = resource.getContents();
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
            public void apply(final JvmGenericType it) {
              {
                EList<JvmMember> _members = it.getMembers();
                JvmTypeReference _stringType = JvmModelBasedLinkingTest.this.stringType(expr);
                JvmField _field = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toField(expr, "x", _stringType);
                CollectionExtensions.<JvmField>operator_add(_members, _field);
                EList<JvmMember> _members_1 = it.getMembers();
                JvmTypeReference _stringType_1 = JvmModelBasedLinkingTest.this.stringType(expr);
                final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                    public void apply(final JvmOperation it) {
                      JvmModelBasedLinkingTest.this._jvmTypesBuilder.setBody(it, expr);
                    }
                  };
                JvmOperation _method = JvmModelBasedLinkingTest.this._jvmTypesBuilder.toMethod(expr, "getX", _stringType_1, _function);
                CollectionExtensions.<JvmOperation>operator_add(_members_1, _method);
              }
            }
          };
        JvmGenericType _class = this._jvmTypesBuilder.toClass(expr, "Foo", _function);
        CollectionExtensions.<JvmGenericType>operator_add(_contents, _class);
        this._validationTestHelper.assertNoErrors(expr);
        JvmIdentifiableElement _feature = expr.getFeature();
        Assert.assertTrue((_feature instanceof JvmField));
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmTypeReference stringType(final EObject ctx) {
    JvmTypeReference _typeForName = this.refs.getTypeForName(java.lang.String.class, ctx);
    return _typeForName;
  }
}
