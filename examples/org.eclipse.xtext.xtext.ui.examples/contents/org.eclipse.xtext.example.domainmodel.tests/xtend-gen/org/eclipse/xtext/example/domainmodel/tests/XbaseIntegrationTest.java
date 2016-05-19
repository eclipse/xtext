package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.example.domainmodel.DomainmodelInjectorProvider;
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler2;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
        Resource _eResource = parse.eResource();
        this.generator.doGenerate(_eResource, fsa);
        Map<String, CharSequence> _textFiles = fsa.getTextFiles();
        Collection<CharSequence> _values = _textFiles.values();
        Iterator<CharSequence> _iterator = _values.iterator();
        final CharSequence concatenation = _iterator.next();
        String _string = concatenation.toString();
        final Class<?> clazz = this.javaCompiler.compileToClass("Foo", _string);
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
