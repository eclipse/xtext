package org.eclipse.xtext.xbase.tests.compiler;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JvmModelGeneratorTest extends AbstractXbaseTestCase {
  @Inject
  private JvmTypesBuilder builder;
  
  @Inject
  private TypeReferences references;
  
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private JvmModelGenerator generator;
  
  @Inject
  private EclipseRuntimeDependentJavaCompiler javaCompiler;
  
  public void setUp() {
    try {
      super.setUp();
      Injector _injector = this.getInjector();
      _injector.injectMembers(this);
      this.javaCompiler.clearClassPath();
      Class<? extends Object> _class = this.getClass();
      this.javaCompiler.addClassPathOfClass(_class);
      this.javaCompiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class);
      this.javaCompiler.addClassPathOfClass(Functions.class);
      this.javaCompiler.addClassPathOfClass(Provider.class);
      this.javaCompiler.addClassPathOfClass(Supplier.class);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimple() {
    try {
      final XExpression expression = this.expression("return s.toUpperCase", false);
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmTypeReference _typeForName = JvmModelGeneratorTest.this.references.getTypeForName(String.class, expression);
            final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  EList<JvmFormalParameter> _parameters = it.getParameters();
                  JvmTypeReference _typeForName = JvmModelGeneratorTest.this.references.getTypeForName(String.class, expression);
                  JvmFormalParameter _parameter = JvmModelGeneratorTest.this.builder.toParameter(expression, "s", _typeForName);
                  JvmModelGeneratorTest.this.builder.<JvmFormalParameter>operator_add(_parameters, _parameter);
                  JvmModelGeneratorTest.this.builder.setBody(it, expression);
                }
              };
            JvmOperation _method = JvmModelGeneratorTest.this.builder.toMethod(expression, "doStuff", _typeForName, _function);
            JvmModelGeneratorTest.this.builder.<JvmOperation>operator_add(_members, _method);
          }
        };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiledClass = this.compile(_eResource, clazz);
      final Object instance = compiledClass.newInstance();
      Method _method = compiledClass.getMethod("doStuff", String.class);
      Object _invoke = _method.invoke(instance, "foo");
      Assert.assertEquals("FOO", _invoke);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testImplements() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            EList<JvmTypeReference> _superTypes = it.getSuperTypes();
            JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, Iterable.class, String.class);
            JvmModelGeneratorTest.this.builder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
          }
        };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      boolean _isAssignableFrom = Iterable.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExtends() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            EList<JvmTypeReference> _superTypes = it.getSuperTypes();
            JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, AbstractList.class, String.class);
            JvmModelGeneratorTest.this.builder.<JvmTypeReference>operator_add(_superTypes, _typeRef);
          }
        };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      boolean _isAssignableFrom = Iterable.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom);
      boolean _isAssignableFrom_1 = AbstractList.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCompilationStrategy() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, String.class);
            JvmField _field = JvmModelGeneratorTest.this.builder.toField(expression, "x", _typeRef);
            JvmModelGeneratorTest.this.builder.<JvmField>operator_add(_members, _field);
            EList<JvmMember> _members_1 = it.getMembers();
            JvmTypeReference _typeRef_1 = JvmModelGeneratorTest.this.typeRef(expression, String.class);
            JvmOperation _getter = JvmModelGeneratorTest.this.builder.toGetter(expression, "x", _typeRef_1);
            JvmModelGeneratorTest.this.builder.<JvmOperation>operator_add(_members_1, _getter);
            EList<JvmMember> _members_2 = it.getMembers();
            JvmTypeReference _typeRef_2 = JvmModelGeneratorTest.this.typeRef(expression, String.class);
            JvmOperation _setter = JvmModelGeneratorTest.this.builder.toSetter(expression, "x", _typeRef_2);
            JvmModelGeneratorTest.this.builder.<JvmOperation>operator_add(_members_2, _setter);
          }
        };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, clazz);
      final Object inst = compiled.newInstance();
      final Method getter = compiled.getMethod("getX");
      final Method setter = compiled.getMethod("setX", String.class);
      setter.invoke(inst, "FOO");
      Object _invoke = getter.invoke(inst);
      Assert.assertEquals("FOO", _invoke);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumeration() {
    try {
      final XExpression expression = this.expression("null", false);
      final Procedure1<JvmEnumerationType> _function = new Procedure1<JvmEnumerationType>() {
          public void apply(final JvmEnumerationType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmEnumerationLiteral _enumerationLiteral = JvmModelGeneratorTest.this.builder.toEnumerationLiteral(expression, "BAR");
            JvmModelGeneratorTest.this.builder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
            EList<JvmMember> _members_1 = it.getMembers();
            JvmEnumerationLiteral _enumerationLiteral_1 = JvmModelGeneratorTest.this.builder.toEnumerationLiteral(expression, "BAZ");
            JvmModelGeneratorTest.this.builder.<JvmEnumerationLiteral>operator_add(_members_1, _enumerationLiteral_1);
          }
        };
      final JvmEnumerationType enumeration = this.builder.toEnumerationType(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      final Class<?> compiled = this.compile(_eResource, enumeration);
      final Method valuesMethod = compiled.getMethod("values");
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      Object _get = ((List<Object>)Conversions.doWrapArray(values)).get(0);
      String _string = _get.toString();
      Assert.assertEquals("BAR", _string);
      Object _get_1 = ((List<Object>)Conversions.doWrapArray(values)).get(1);
      String _string_1 = _get_1.toString();
      Assert.assertEquals("BAZ", _string_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBug377925No_Nullpointer() {
    try {
      final XExpression expression = this.expression("[Object o| null]");
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmTypeReference _typeForName = JvmModelGeneratorTest.this.references.getTypeForName("java.lang.Object", expression);
            final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  JvmModelGeneratorTest.this.builder.setBody(it, expression);
                }
              };
            JvmOperation _method = JvmModelGeneratorTest.this.builder.toMethod(expression, "doStuff", _typeForName, _function);
            JvmModelGeneratorTest.this.builder.<JvmOperation>operator_add(_members, _method);
          }
        };
      final JvmGenericType clazz = this.builder.toClass(expression, "my.test.Foo", _function);
      Resource _eResource = expression.eResource();
      this.compile(_eResource, clazz);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz) {
    return this.references.getTypeForName(clazz, ctx);
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz, final Class<?> param) {
    JvmTypeReference _typeRef = this.typeRef(ctx, param);
    return this.references.getTypeForName(clazz, ctx, _typeRef);
  }
  
  public Class<?> compile(final Resource res, final JvmDeclaredType type) {
    res.eSetDeliver(false);
    EList<EObject> _contents = res.getContents();
    this.builder.<JvmDeclaredType>operator_add(_contents, type);
    res.eSetDeliver(true);
    InMemoryFileSystemAccess _inMemoryFileSystemAccess = new InMemoryFileSystemAccess();
    final InMemoryFileSystemAccess fsa = _inMemoryFileSystemAccess;
    this.generator.doGenerate(res, fsa);
    Map<String,CharSequence> _files = fsa.getFiles();
    String _identifier = type.getIdentifier();
    String _replace = _identifier.replace(".", "/");
    String _plus = (IFileSystemAccess.DEFAULT_OUTPUT + _replace);
    String _plus_1 = (_plus + ".java");
    CharSequence _get = _files.get(_plus_1);
    final String code = _get.toString();
    String _identifier_1 = type.getIdentifier();
    final Class<? extends Object> compiledClass = this.javaCompiler.compileToClass(_identifier_1, code);
    EList<EObject> _contents_1 = res.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents_1);
    this.helper.assertNoErrors(_head);
    return compiledClass;
  }
}
