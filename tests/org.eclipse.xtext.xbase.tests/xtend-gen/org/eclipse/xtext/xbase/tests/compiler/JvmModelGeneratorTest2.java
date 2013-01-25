package org.eclipse.xtext.xbase.tests.compiler;

import com.google.inject.Inject;
import java.lang.reflect.Method;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelCompleter;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.compiler.JvmModelGeneratorTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseWithLogicalContainerInjectorProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseWithLogicalContainerInjectorProvider.class)
@SuppressWarnings("all")
public class JvmModelGeneratorTest2 extends JvmModelGeneratorTest {
  @Inject
  private JvmModelCompleter completer;
  
  @Inject
  private JvmTypesBuilder builder;
  
  @Test
  public void testEnumerationWithCompleter() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmEnumerationType> _function = new Procedure1<JvmEnumerationType>() {
          public void apply(final JvmEnumerationType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmEnumerationLiteral _enumerationLiteral = JvmModelGeneratorTest2.this.builder.toEnumerationLiteral(expression, "BAR");
            JvmModelGeneratorTest2.this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
            EList<JvmMember> _members_1 = it.getMembers();
            JvmEnumerationLiteral _enumerationLiteral_1 = JvmModelGeneratorTest2.this.builder.toEnumerationLiteral(expression, "BAZ");
            JvmModelGeneratorTest2.this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
          }
        };
      final JvmEnumerationType enumeration = this.builder.toEnumerationType(expression, "my.test.Foo", _function);
      this.completer.complete(enumeration);
      Resource _eResource = expression.eResource();
      final Class<? extends Object> compiled = this.compile(_eResource, enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Object _get = ((List<Object>)Conversions.doWrapArray(values)).get(0);
      String _string = _get.toString();
      Assert.assertEquals("BAR", _string);
      Object _get_1 = ((List<Object>)Conversions.doWrapArray(values)).get(1);
      String _string_1 = _get_1.toString();
      Assert.assertEquals("BAZ", _string_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
