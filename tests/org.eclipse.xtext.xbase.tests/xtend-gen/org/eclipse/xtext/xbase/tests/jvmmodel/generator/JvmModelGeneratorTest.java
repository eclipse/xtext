package org.eclipse.xtext.xbase.tests.jvmmodel.generator;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.generator.XbaseGenerator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

@SuppressWarnings("all")
public class JvmModelGeneratorTest extends AbstractXbaseTestCase {
  
  @Inject
  private JvmTypesBuilder builder;
  
  @Inject
  private TypeReferences references;
  
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private XbaseGenerator generator;
  
  public void testSimple() throws Exception, UnsupportedOperationException {
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
              JvmTypeReference _typeForName = JvmModelGeneratorTest.this.references.getTypeForName(java.lang.String.class, expression);
              final Function1<JvmOperation,Void> _function_1 = new Function1<JvmOperation,Void>() {
                  public Void apply(final JvmOperation it_1) {
                    {
                      EList<JvmFormalParameter> _parameters = it_1.getParameters();
                      JvmTypeReference _typeForName_1 = JvmModelGeneratorTest.this.references.getTypeForName(java.lang.String.class, expression);
                      JvmFormalParameter _parameter = JvmModelGeneratorTest.this.builder.toParameter(expression, "s", _typeForName_1);
                      CollectionExtensions.<JvmFormalParameter>operator_add(_parameters, _parameter);
                      JvmModelGeneratorTest.this.builder.associate(expression, it_1);
                    }
                    return null;
                  }
                };
              JvmOperation _method = JvmModelGeneratorTest.this.builder.toMethod(expression, "doStuff", _typeForName, _function_1);
              CollectionExtensions.<JvmMember>operator_add(_members, _method);
              _xblockexpression = (null);
            }
            return _xblockexpression;
          }
        };
      JvmGenericType _clazz = this.builder.toClazz(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _clazz;
      EList<EObject> _contents = resource.getContents();
      CollectionExtensions.<EObject>operator_add(_contents, clazz);
      resource.eSetDeliver(true);
      this.helper.assertNoErrors(expression);
      InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
      final InMemoryFileSystemAccess fsa = _inMemoryFileSystemAccess;
      this.generator.doGenerate(resource, fsa);
      Map<String,CharSequence> _files = fsa.getFiles();
      Collection<CharSequence> _values = _files.values();
      CharSequence _head = IterableExtensions.<CharSequence>head(_values);
      InputOutput.<CharSequence>println(_head);
    }
  }
}