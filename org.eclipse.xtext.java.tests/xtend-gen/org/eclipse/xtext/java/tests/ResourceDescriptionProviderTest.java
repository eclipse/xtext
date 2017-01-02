package org.eclipse.xtext.java.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.OutputStream;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.java.tests.JavaInjectorProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(JavaInjectorProvider.class)
@SuppressWarnings("all")
public class ResourceDescriptionProviderTest {
  @Test
  public void testStubGeneration_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String helloWorld() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"Hello\";");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Assert.assertEquals("MyTest", IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getQualifiedName().toString());
      EObject _eObjectOrProxy = IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getEObjectOrProxy();
      Assert.assertFalse(((JvmGenericType) _eObjectOrProxy).isInterface());
      Assert.assertEquals(1, IterableExtensions.size(it.getExportedObjects()));
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testStubGeneration_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public interface MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public String helloWorld();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Assert.assertEquals("MyTest", IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getQualifiedName().toString());
      EObject _eObjectOrProxy = IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getEObjectOrProxy();
      Assert.assertTrue(((JvmGenericType) _eObjectOrProxy).isInterface());
      Assert.assertEquals(1, IterableExtensions.size(it.getExportedObjects()));
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testStubGeneration_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public enum MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("FOO, BAR");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Assert.assertEquals("MyTest", IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getQualifiedName().toString());
      EObject _eObjectOrProxy = IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getEObjectOrProxy();
      Assert.assertTrue((_eObjectOrProxy instanceof JvmEnumerationType));
      Assert.assertEquals(1, IterableExtensions.size(it.getExportedObjects()));
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testStubGeneration_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public @interface MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String value();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Assert.assertEquals("MyTest", IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getQualifiedName().toString());
      EObject _eObjectOrProxy = IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getEObjectOrProxy();
      Assert.assertTrue((_eObjectOrProxy instanceof JvmAnnotationType));
      Assert.assertEquals(1, IterableExtensions.size(it.getExportedObjects()));
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testStubGeneration_05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package my.pack;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public abstract class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("abstract String value();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Assert.assertEquals("my.pack.MyTest", IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getQualifiedName().toString());
      Assert.assertEquals(1, IterableExtensions.size(it.getExportedObjects()));
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testStubGenerationWithNestedTypes_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package my.pack;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("class InnerClass {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface InnerInterface {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("enum InnerEnum {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@interface InnerAnnotation {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Assert.assertEquals("my.pack.MyTest", IterableExtensions.<IEObjectDescription>head(it.getExportedObjects()).getQualifiedName().toString());
      Assert.assertEquals(5, IterableExtensions.size(it.getExportedObjects()));
      IEObjectDescription _get = ((IEObjectDescription[])Conversions.unwrapArray(it.getExportedObjects(), IEObjectDescription.class))[1];
      final Procedure1<IEObjectDescription> _function_1 = (IEObjectDescription it_1) -> {
        Assert.assertEquals("my.pack.MyTest.InnerClass", it_1.getQualifiedName().toString());
        EObject _eObjectOrProxy = it_1.getEObjectOrProxy();
        Assert.assertTrue((_eObjectOrProxy instanceof JvmGenericType));
      };
      ObjectExtensions.<IEObjectDescription>operator_doubleArrow(_get, _function_1);
      IEObjectDescription _get_1 = ((IEObjectDescription[])Conversions.unwrapArray(it.getExportedObjects(), IEObjectDescription.class))[2];
      final Procedure1<IEObjectDescription> _function_2 = (IEObjectDescription it_1) -> {
        Assert.assertEquals("my.pack.MyTest.InnerInterface", it_1.getQualifiedName().toString());
        EObject _eObjectOrProxy = it_1.getEObjectOrProxy();
        Assert.assertTrue((_eObjectOrProxy instanceof JvmGenericType));
      };
      ObjectExtensions.<IEObjectDescription>operator_doubleArrow(_get_1, _function_2);
      IEObjectDescription _get_2 = ((IEObjectDescription[])Conversions.unwrapArray(it.getExportedObjects(), IEObjectDescription.class))[3];
      final Procedure1<IEObjectDescription> _function_3 = (IEObjectDescription it_1) -> {
        Assert.assertEquals("my.pack.MyTest.InnerEnum", it_1.getQualifiedName().toString());
        EObject _eObjectOrProxy = it_1.getEObjectOrProxy();
        Assert.assertTrue((_eObjectOrProxy instanceof JvmEnumerationType));
      };
      ObjectExtensions.<IEObjectDescription>operator_doubleArrow(_get_2, _function_3);
      IEObjectDescription _get_3 = ((IEObjectDescription[])Conversions.unwrapArray(it.getExportedObjects(), IEObjectDescription.class))[4];
      final Procedure1<IEObjectDescription> _function_4 = (IEObjectDescription it_1) -> {
        Assert.assertEquals("my.pack.MyTest.InnerAnnotation", it_1.getQualifiedName().toString());
        EObject _eObjectOrProxy = it_1.getEObjectOrProxy();
        Assert.assertTrue((_eObjectOrProxy instanceof JvmAnnotationType));
      };
      ObjectExtensions.<IEObjectDescription>operator_doubleArrow(_get_3, _function_4);
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testStubGenerationWithTypeParamers_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package my.pack;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class MyTest<T extends CharSequence> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("interface InnerInterface<A,B> {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("static class DeepNested<X> {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      final IEObjectDescription mytest = IterableExtensions.<IEObjectDescription>head(it.getExportedObjects());
      Assert.assertEquals("my.pack.MyTest", mytest.getQualifiedName().toString());
      Assert.assertEquals("<T>", mytest.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS));
      final IEObjectDescription innerinterface = ((IEObjectDescription[])Conversions.unwrapArray(it.getExportedObjects(), IEObjectDescription.class))[1];
      Assert.assertEquals("my.pack.MyTest.InnerInterface", innerinterface.getQualifiedName().toString());
      Assert.assertEquals("<A,B>", innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS));
      Assert.assertEquals(Boolean.TRUE.toString(), innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE));
      final IEObjectDescription deepNested = ((IEObjectDescription[])Conversions.unwrapArray(it.getExportedObjects(), IEObjectDescription.class))[2];
      Assert.assertEquals("my.pack.MyTest.InnerInterface.DeepNested", deepNested.getQualifiedName().toString());
      Assert.assertEquals("<X>", deepNested.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS));
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testEmptyFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//package my.pack;");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Assert.assertTrue(IterableExtensions.isEmpty(it.getExportedObjects()));
    };
    this.resultsIn(_builder, _function);
  }
  
  protected void resultsIn(final CharSequence javaCode, final Procedure1<? super IResourceDescription> assertion) {
    String _string = javaCode.toString();
    Pair<String, String> _mappedTo = Pair.<String, String>of("SomeJava.java", _string);
    final XtextResourceSet resourceSet = this.resourceSet(_mappedTo);
    this.compilerPhases.setIndexing(resourceSet, true);
    final Resource resource = IterableExtensions.<Resource>head(resourceSet.getResources());
    final IResourceDescription description = this.resourceDesriptionManager.getResourceDescription(resource);
    assertion.apply(description);
  }
  
  @Inject
  private CompilerPhases compilerPhases;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private IResourceDescription.Manager resourceDesriptionManager;
  
  protected XtextResourceSet resourceSet(final Pair<String, String>... files) {
    final XtextResourceSet result = this.resourceSetProvider.get();
    result.getURIConverter().getURIHandlers().clear();
    final InMemoryURIHandler uriHandler = new InMemoryURIHandler();
    final Function1<Pair<String, String>, URI> _function = (Pair<String, String> it) -> {
      try {
        String _key = it.getKey();
        String _plus = ((InMemoryURIHandler.SCHEME + ":/") + _key);
        final URI uri = URI.createURI(_plus);
        final OutputStream out = uriHandler.createOutputStream(uri, CollectionLiterals.<Object, Object>emptyMap());
        out.write(it.getValue().getBytes());
        out.close();
        return uri;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final List<URI> uris = ListExtensions.<Pair<String, String>, URI>map(((List<Pair<String, String>>)Conversions.doWrapArray(files)), _function);
    result.getURIConverter().getURIHandlers().add(uriHandler);
    for (final URI uri : uris) {
      result.getResource(uri, true);
    }
    return result;
  }
}
