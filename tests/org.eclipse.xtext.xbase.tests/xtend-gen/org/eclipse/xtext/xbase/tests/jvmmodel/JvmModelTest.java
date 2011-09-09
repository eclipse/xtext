package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

@SuppressWarnings("all")
public class JvmModelTest extends AbstractXbaseTestCase {
  
  @Inject
  private JvmTypesBuilder builder;
  
  @Inject
  private TypeReferences references;
  
  @Inject
  private ValidationTestHelper helper;
  
  public void testSimple() throws Exception {
    {
      XExpression _expression = this.expression("return s.toUpperCase", false);
      final XExpression expression = _expression;
      Resource _eResource = expression.eResource();
      final Resource resource = _eResource;
      resource.eSetDeliver(false);
      final Function1<JvmGenericType,Void> _function = new Function1<JvmGenericType,Void>() {
          public Void apply(final JvmGenericType it) {
            Void _xblockexpression = null;
            {
              EList<JvmMember> _members = it.getMembers();
              JvmTypeReference _typeForName = JvmModelTest.this.references.getTypeForName(java.lang.String.class, expression);
              final Function1<JvmOperation,Void> _function_1 = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it_1) {
                    {
                      EList<JvmFormalParameter> _parameters = it_1.getParameters();
                      JvmTypeReference _typeForName_1 = JvmModelTest.this.references.getTypeForName(java.lang.String.class, expression);
                      JvmFormalParameter _parameter = JvmModelTest.this.builder.toParameter(expression, "s", _typeForName_1);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      JvmModelTest.this.builder.associate(expression, it_1);
                    }
                    return null;
                  }
                };
              JvmOperation _method = JvmModelTest.this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
              CollectionExtensions.<JvmMember>operator_add(_members, _method);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this.builder.toClazz(expression, "Foo", _function);
      final JvmGenericType clazz = _clazz;
      EList<EObject> _contents = resource.getContents();
      CollectionExtensions.<EObject>operator_add(_contents, clazz);
      resource.eSetDeliver(true);
      this.helper.assertNoErrors(expression);
    }
  }
}