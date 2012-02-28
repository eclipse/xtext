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
      XExpression _expression = this.expression("return s.toUpperCase", false);
      final XExpression expression = _expression;
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmTypeReference _typeForName = JvmModelGeneratorTest.this.references.getTypeForName(String.class, expression);
            final Procedure1<JvmOperation> _function = new Procedure1<JvmOperation>() {
                public void apply(final JvmOperation it) {
                  EList<JvmFormalParameter> _parameters = it.getParameters();
                  JvmTypeReference _typeForName = JvmModelGeneratorTest.this.references.getTypeForName(String.class, expression);
                  JvmFormalParameter _parameter = JvmModelGeneratorTest.this.builder.toParameter(expression, "s", _typeForName);
                  _parameters.add(_parameter);
                  JvmModelGeneratorTest.this.builder.setBody(it, expression);
                }
              };
            JvmOperation _method = JvmModelGeneratorTest.this.builder.toMethod(expression, "doStuff", _typeForName, _function);
            _members.add(_method);
          }
        };
      JvmGenericType _class = this.builder.toClass(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _class;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiledClass = _compile;
      Object _newInstance = compiledClass.newInstance();
      final Object instance = _newInstance;
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
      XExpression _expression = this.expression("null", false);
      final XExpression expression = _expression;
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            EList<JvmTypeReference> _superTypes = it.getSuperTypes();
            JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, Iterable.class, String.class);
            _superTypes.add(_typeRef);
          }
        };
      JvmGenericType _class = this.builder.toClass(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _class;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiled = _compile;
      boolean _isAssignableFrom = Iterable.class.isAssignableFrom(compiled);
      Assert.assertTrue(_isAssignableFrom);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testExtends() {
    try {
      XExpression _expression = this.expression("null", false);
      final XExpression expression = _expression;
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            it.setAbstract(true);
            EList<JvmTypeReference> _superTypes = it.getSuperTypes();
            JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, AbstractList.class, String.class);
            _superTypes.add(_typeRef);
          }
        };
      JvmGenericType _class = this.builder.toClass(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _class;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiled = _compile;
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
      XExpression _expression = this.expression("null", false);
      final XExpression expression = _expression;
      final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          public void apply(final JvmGenericType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmTypeReference _typeRef = JvmModelGeneratorTest.this.typeRef(expression, String.class);
            JvmField _field = JvmModelGeneratorTest.this.builder.toField(expression, "x", _typeRef);
            _members.add(_field);
            EList<JvmMember> _members_1 = it.getMembers();
            JvmTypeReference _typeRef_1 = JvmModelGeneratorTest.this.typeRef(expression, String.class);
            JvmOperation _getter = JvmModelGeneratorTest.this.builder.toGetter(expression, "x", _typeRef_1);
            _members_1.add(_getter);
            EList<JvmMember> _members_2 = it.getMembers();
            JvmTypeReference _typeRef_2 = JvmModelGeneratorTest.this.typeRef(expression, String.class);
            JvmOperation _setter = JvmModelGeneratorTest.this.builder.toSetter(expression, "x", _typeRef_2);
            _members_2.add(_setter);
          }
        };
      JvmGenericType _class = this.builder.toClass(expression, "my.test.Foo", _function);
      final JvmGenericType clazz = _class;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, clazz);
      final Class<?> compiled = _compile;
      Object _newInstance = compiled.newInstance();
      final Object inst = _newInstance;
      Method _method = compiled.getMethod("getX");
      final Method getter = _method;
      Method _method_1 = compiled.getMethod("setX", String.class);
      final Method setter = _method_1;
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
      XExpression _expression = this.expression("null", false);
      final XExpression expression = _expression;
      final Procedure1<JvmEnumerationType> _function = new Procedure1<JvmEnumerationType>() {
          public void apply(final JvmEnumerationType it) {
            EList<JvmMember> _members = it.getMembers();
            JvmEnumerationLiteral _enumerationLiteral = JvmModelGeneratorTest.this.builder.toEnumerationLiteral(expression, "BAR");
            _members.add(_enumerationLiteral);
            EList<JvmMember> _members_1 = it.getMembers();
            JvmEnumerationLiteral _enumerationLiteral_1 = JvmModelGeneratorTest.this.builder.toEnumerationLiteral(expression, "BAZ");
            _members_1.add(_enumerationLiteral_1);
          }
        };
      JvmEnumerationType _enumerationType = this.builder.toEnumerationType(expression, "my.test.Foo", _function);
      final JvmEnumerationType enumeration = _enumerationType;
      Resource _eResource = expression.eResource();
      Class<?> _compile = this.compile(_eResource, enumeration);
      final Class<?> compiled = _compile;
      Method _method = compiled.getMethod("values");
      final Method valuesMethod = _method;
      Object _invoke = valuesMethod.invoke(null);
      final Object[] values = ((Object[]) _invoke);
      final Object[] _typeConverted_values = (Object[])values;
      Object _get = ((List<Object>)Conversions.doWrapArray(_typeConverted_values)).get(0);
      String _string = _get.toString();
      Assert.assertEquals("BAR", _string);
      final Object[] _typeConverted_values_1 = (Object[])values;
      Object _get_1 = ((List<Object>)Conversions.doWrapArray(_typeConverted_values_1)).get(1);
      String _string_1 = _get_1.toString();
      Assert.assertEquals("BAZ", _string_1);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz) {
    JvmTypeReference _typeForName = this.references.getTypeForName(clazz, ctx);
    return _typeForName;
  }
  
  public JvmTypeReference typeRef(final EObject ctx, final Class<?> clazz, final Class<?> param) {
    JvmTypeReference _typeRef = this.typeRef(ctx, param);
    JvmTypeReference _typeForName = this.references.getTypeForName(clazz, ctx, _typeRef);
    return _typeForName;
  }
  
  public Class<?> compile(final Resource res, final JvmDeclaredType type) {
    res.eSetDeliver(false);
    EList<EObject> _contents = res.getContents();
    _contents.add(type);
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
    String _string = _get.toString();
    final String code = _string;
    String _identifier_1 = type.getIdentifier();
    Class<? extends Object> _compileToClass = this.javaCompiler.compileToClass(_identifier_1, code);
    final Class<? extends Object> compiledClass = _compileToClass;
    EList<EObject> _contents_1 = res.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents_1);
    this.helper.assertNoErrors(_head);
    return compiledClass;
  }
}
