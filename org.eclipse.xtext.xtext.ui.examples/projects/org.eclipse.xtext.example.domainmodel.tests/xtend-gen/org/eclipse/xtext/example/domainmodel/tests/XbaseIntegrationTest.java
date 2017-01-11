package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import java.lang.reflect.Method;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.example.domainmodel.tests.DomainmodelInjectorProvider;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.testing.OnTheFlyJavaCompiler2;
import org.eclipse.xtext.xbase.testing.evaluation.AbstractXbaseEvaluationTest;
import org.junit.runner.RunWith;

/**
 * Xbase integration test.
 * 
 * runs all Xbase tests from {@link AbstractXbaseEvaluationTest} in the context of an
 * entity operation.
 * 
 * Unsupported features can be disabled by overriding the respective test method.
 * 
 * @author Sven Efftinge
 */
@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {
  @Inject
  private OnTheFlyJavaCompiler2 javaCompiler;
  
  @Inject
  private ParseHelper<DomainModel> parseHelper;
  
  @Inject
  private ValidationTestHelper validationHelper;
  
  @Inject
  private JvmModelGenerator generator;
  
  @Override
  protected Object invokeXbaseExpression(final String expression) {
    try {
      Object _xblockexpression = null;
      {
        final DomainModel parse = this.parseHelper.parse((("entity Foo { op doStuff() : Object { " + expression) + " } } "));
        this.validationHelper.assertNoErrors(parse);
        final InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
        this.generator.doGenerate(parse.eResource(), fsa);
        final CharSequence concatenation = fsa.getTextFiles().values().iterator().next();
        final Class<?> clazz = this.javaCompiler.compileToClass("Foo", concatenation.toString());
        final Object foo = clazz.newInstance();
        final Method method = clazz.getDeclaredMethod("doStuff");
        _xblockexpression = method.invoke(foo);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
