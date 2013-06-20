package org.eclipse.xtend.core.tests.macro;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.macro.AbstractReusableActiveAnnotationTests;
import org.eclipse.xtend.core.tests.macro.DelegatingClassloader;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class ActiveAnnotationsRuntimeTest extends AbstractReusableActiveAnnotationTests {
  @Inject
  private CompilationTestHelper compiler;
  
  @Inject
  private Provider<CompilationUnitImpl> compilationUnitProvider;
  
  @Inject
  private ProcessorInstanceForJvmTypeProvider processorProvider;
  
  @Inject
  private ValidationTestHelper validationTestHelper;
  
  @Before
  public void setUp() {
    this.compiler.setJavaCompilerClassPath(MutableTypeDeclaration.class, IterableExtensions.class, Lists.class);
  }
  
  public void assertProcessing(final Pair<String,String> macroFile, final Pair<String,String> clientFile, final Procedure1<? super CompilationUnitImpl> expectations) {
    try {
      ResourceSet _unLoadedResourceSet = this.compiler.unLoadedResourceSet(macroFile);
      final XtextResourceSet macroResourceSet = ((XtextResourceSet) _unLoadedResourceSet);
      Class<? extends ActiveAnnotationsRuntimeTest> _class = this.getClass();
      ClassLoader _classLoader = _class.getClassLoader();
      macroResourceSet.setClasspathURIContext(_classLoader);
      ResourceSet _unLoadedResourceSet_1 = this.compiler.unLoadedResourceSet(clientFile);
      final XtextResourceSet resourceSet = ((XtextResourceSet) _unLoadedResourceSet_1);
      final IAcceptor<Result> _function = new IAcceptor<Result>() {
          public void accept(final Result result) {
            Class<? extends ActiveAnnotationsRuntimeTest> _class = ActiveAnnotationsRuntimeTest.this.getClass();
            ClassLoader _classLoader = _class.getClassLoader();
            final Function1<String,Class<? extends Object>> _function = new Function1<String,Class<? extends Object>>() {
                public Class<? extends Object> apply(final String it) {
                  Class<? extends Object> _compiledClass = result.getCompiledClass(it);
                  return _compiledClass;
                }
              };
            DelegatingClassloader _delegatingClassloader = new DelegatingClassloader(_classLoader, _function);
            final DelegatingClassloader classLoader = _delegatingClassloader;
            resourceSet.setClasspathURIContext(classLoader);
            ActiveAnnotationsRuntimeTest.this.processorProvider.setClassLoader(classLoader);
          }
        };
      this.compiler.compile(macroResourceSet, _function);
      EList<Resource> _resources = resourceSet.getResources();
      final Resource singleResource = IterableExtensions.<Resource>head(_resources);
      final IAcceptor<Result> _function_1 = new IAcceptor<Result>() {
          public void accept(final Result it) {
            final CompilationUnitImpl unit = ActiveAnnotationsRuntimeTest.this.compilationUnitProvider.get();
            EList<EObject> _contents = singleResource.getContents();
            Iterable<XtendFile> _filter = Iterables.<XtendFile>filter(_contents, XtendFile.class);
            final XtendFile xtendFile = IterableExtensions.<XtendFile>head(_filter);
            ActiveAnnotationsRuntimeTest.this.validationTestHelper.assertNoErrors(xtendFile);
            unit.setXtendFile(xtendFile);
            expectations.apply(unit);
            EList<Diagnostic> _errors = singleResource.getErrors();
            boolean _isEmpty = _errors.isEmpty();
            Assert.assertTrue(_isEmpty);
          }
        };
      this.compiler.compile(resourceSet, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSimpleModification() {
    super.testSimpleModification();
  }
}
