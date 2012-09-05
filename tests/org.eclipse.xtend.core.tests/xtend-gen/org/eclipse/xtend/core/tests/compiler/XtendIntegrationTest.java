package org.eclipse.xtend.core.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.annotation.Annotation;
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XtendInjectorProvider.class)
@SuppressWarnings("all")
public class XtendIntegrationTest {
  @Inject
  private CompilationTestHelper _compilationTestHelper;
  
  @Test
  public void testAnnotationProcessing() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.lang.annotation.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@MyProcessedAnnotation");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Retention(RetentionPolicy::RUNTIME)");
    _builder.newLine();
    _builder.append("annotation MyProcessedAnnotation {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("do {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'foo\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<Result> _function = new Procedure1<Result>() {
        public void apply(final Result it) {
          final Class<? extends Object> fooClass = it.getCompiledClass("Foo");
          final Class<? extends Object> annotation = it.getCompiledClass("MyProcessedAnnotation");
          Annotation[] _annotations = fooClass.getAnnotations();
          final Function1<Annotation,Boolean> _function = new Function1<Annotation,Boolean>() {
              public Boolean apply(final Annotation it) {
                Class<? extends Annotation> _annotationType = it.annotationType();
                boolean _equals = Objects.equal(_annotationType, annotation);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<Annotation>exists(((Iterable<Annotation>)Conversions.doWrapArray(_annotations)), _function);
          Assert.assertTrue(_exists);
        }
      };
    this._compilationTestHelper.compile(_builder, new IAcceptor<Result>() {
        public void accept(Result t) {
          _function.apply(t);
        }
    });
  }
}
