package org.eclipse.xtext.java.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.java.tests.JavaInjectorProvider;
import org.eclipse.xtext.naming.QualifiedName;
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
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = _qualifiedName.toString();
      Assert.assertEquals("MyTest", _string);
      Iterable<IEObjectDescription> _exportedObjects_1 = it.getExportedObjects();
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
      EObject _eObjectOrProxy = _head_1.getEObjectOrProxy();
      boolean _isInterface = ((JvmGenericType) _eObjectOrProxy).isInterface();
      Assert.assertFalse(_isInterface);
      Iterable<IEObjectDescription> _exportedObjects_2 = it.getExportedObjects();
      int _size = IterableExtensions.size(_exportedObjects_2);
      Assert.assertEquals(1, _size);
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
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = _qualifiedName.toString();
      Assert.assertEquals("MyTest", _string);
      Iterable<IEObjectDescription> _exportedObjects_1 = it.getExportedObjects();
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
      EObject _eObjectOrProxy = _head_1.getEObjectOrProxy();
      boolean _isInterface = ((JvmGenericType) _eObjectOrProxy).isInterface();
      Assert.assertTrue(_isInterface);
      Iterable<IEObjectDescription> _exportedObjects_2 = it.getExportedObjects();
      int _size = IterableExtensions.size(_exportedObjects_2);
      Assert.assertEquals(1, _size);
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
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = _qualifiedName.toString();
      Assert.assertEquals("MyTest", _string);
      Iterable<IEObjectDescription> _exportedObjects_1 = it.getExportedObjects();
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
      EObject _eObjectOrProxy = _head_1.getEObjectOrProxy();
      Assert.assertTrue((_eObjectOrProxy instanceof JvmEnumerationType));
      Iterable<IEObjectDescription> _exportedObjects_2 = it.getExportedObjects();
      int _size = IterableExtensions.size(_exportedObjects_2);
      Assert.assertEquals(1, _size);
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
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = _qualifiedName.toString();
      Assert.assertEquals("MyTest", _string);
      Iterable<IEObjectDescription> _exportedObjects_1 = it.getExportedObjects();
      IEObjectDescription _head_1 = IterableExtensions.<IEObjectDescription>head(_exportedObjects_1);
      EObject _eObjectOrProxy = _head_1.getEObjectOrProxy();
      Assert.assertTrue((_eObjectOrProxy instanceof JvmAnnotationType));
      Iterable<IEObjectDescription> _exportedObjects_2 = it.getExportedObjects();
      int _size = IterableExtensions.size(_exportedObjects_2);
      Assert.assertEquals(1, _size);
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
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = _qualifiedName.toString();
      Assert.assertEquals("my.pack.MyTest", _string);
      Iterable<IEObjectDescription> _exportedObjects_1 = it.getExportedObjects();
      int _size = IterableExtensions.size(_exportedObjects_1);
      Assert.assertEquals(1, _size);
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
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
      QualifiedName _qualifiedName = _head.getQualifiedName();
      String _string = _qualifiedName.toString();
      Assert.assertEquals("my.pack.MyTest", _string);
      Iterable<IEObjectDescription> _exportedObjects_1 = it.getExportedObjects();
      int _size = IterableExtensions.size(_exportedObjects_1);
      Assert.assertEquals(5, _size);
      Iterable<IEObjectDescription> _exportedObjects_2 = it.getExportedObjects();
      IEObjectDescription _get = ((IEObjectDescription[])Conversions.unwrapArray(_exportedObjects_2, IEObjectDescription.class))[1];
      final Procedure1<IEObjectDescription> _function_1 = (IEObjectDescription it_1) -> {
        QualifiedName _qualifiedName_1 = it_1.getQualifiedName();
        String _string_1 = _qualifiedName_1.toString();
        Assert.assertEquals("my.pack.MyTest.InnerClass", _string_1);
        EObject _eObjectOrProxy = it_1.getEObjectOrProxy();
        Assert.assertTrue((_eObjectOrProxy instanceof JvmGenericType));
      };
      ObjectExtensions.<IEObjectDescription>operator_doubleArrow(_get, _function_1);
      Iterable<IEObjectDescription> _exportedObjects_3 = it.getExportedObjects();
      IEObjectDescription _get_1 = ((IEObjectDescription[])Conversions.unwrapArray(_exportedObjects_3, IEObjectDescription.class))[2];
      final Procedure1<IEObjectDescription> _function_2 = (IEObjectDescription it_1) -> {
        QualifiedName _qualifiedName_1 = it_1.getQualifiedName();
        String _string_1 = _qualifiedName_1.toString();
        Assert.assertEquals("my.pack.MyTest.InnerInterface", _string_1);
        EObject _eObjectOrProxy = it_1.getEObjectOrProxy();
        Assert.assertTrue((_eObjectOrProxy instanceof JvmGenericType));
      };
      ObjectExtensions.<IEObjectDescription>operator_doubleArrow(_get_1, _function_2);
      Iterable<IEObjectDescription> _exportedObjects_4 = it.getExportedObjects();
      IEObjectDescription _get_2 = ((IEObjectDescription[])Conversions.unwrapArray(_exportedObjects_4, IEObjectDescription.class))[3];
      final Procedure1<IEObjectDescription> _function_3 = (IEObjectDescription it_1) -> {
        QualifiedName _qualifiedName_1 = it_1.getQualifiedName();
        String _string_1 = _qualifiedName_1.toString();
        Assert.assertEquals("my.pack.MyTest.InnerEnum", _string_1);
        EObject _eObjectOrProxy = it_1.getEObjectOrProxy();
        Assert.assertTrue((_eObjectOrProxy instanceof JvmEnumerationType));
      };
      ObjectExtensions.<IEObjectDescription>operator_doubleArrow(_get_2, _function_3);
      Iterable<IEObjectDescription> _exportedObjects_5 = it.getExportedObjects();
      IEObjectDescription _get_3 = ((IEObjectDescription[])Conversions.unwrapArray(_exportedObjects_5, IEObjectDescription.class))[4];
      final Procedure1<IEObjectDescription> _function_4 = (IEObjectDescription it_1) -> {
        QualifiedName _qualifiedName_1 = it_1.getQualifiedName();
        String _string_1 = _qualifiedName_1.toString();
        Assert.assertEquals("my.pack.MyTest.InnerAnnotation", _string_1);
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
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      final IEObjectDescription mytest = IterableExtensions.<IEObjectDescription>head(_exportedObjects);
      QualifiedName _qualifiedName = mytest.getQualifiedName();
      String _string = _qualifiedName.toString();
      Assert.assertEquals("my.pack.MyTest", _string);
      String _userData = mytest.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS);
      Assert.assertEquals("<T>", _userData);
      Iterable<IEObjectDescription> _exportedObjects_1 = it.getExportedObjects();
      final IEObjectDescription innerinterface = ((IEObjectDescription[])Conversions.unwrapArray(_exportedObjects_1, IEObjectDescription.class))[1];
      QualifiedName _qualifiedName_1 = innerinterface.getQualifiedName();
      String _string_1 = _qualifiedName_1.toString();
      Assert.assertEquals("my.pack.MyTest.InnerInterface", _string_1);
      String _userData_1 = innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS);
      Assert.assertEquals("<A,B>", _userData_1);
      String _string_2 = Boolean.TRUE.toString();
      String _userData_2 = innerinterface.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE);
      Assert.assertEquals(_string_2, _userData_2);
      Iterable<IEObjectDescription> _exportedObjects_2 = it.getExportedObjects();
      final IEObjectDescription deepNested = ((IEObjectDescription[])Conversions.unwrapArray(_exportedObjects_2, IEObjectDescription.class))[2];
      QualifiedName _qualifiedName_2 = deepNested.getQualifiedName();
      String _string_3 = _qualifiedName_2.toString();
      Assert.assertEquals("my.pack.MyTest.InnerInterface.DeepNested", _string_3);
      String _userData_3 = deepNested.getUserData(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS);
      Assert.assertEquals("<X>", _userData_3);
    };
    this.resultsIn(_builder, _function);
  }
  
  @Test
  public void testEmptyFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//package my.pack;");
    _builder.newLine();
    final Procedure1<IResourceDescription> _function = (IResourceDescription it) -> {
      Iterable<IEObjectDescription> _exportedObjects = it.getExportedObjects();
      boolean _isEmpty = IterableExtensions.isEmpty(_exportedObjects);
      Assert.assertTrue(_isEmpty);
    };
    this.resultsIn(_builder, _function);
  }
  
  protected void resultsIn(final CharSequence javaCode, final Procedure1<? super IResourceDescription> assertion) {
    String _string = javaCode.toString();
    Pair<String, String> _mappedTo = Pair.<String, String>of("SomeJava.java", _string);
    final XtextResourceSet resourceSet = this.resourceSet(_mappedTo);
    this.compilerPhases.setIndexing(resourceSet, true);
    EList<Resource> _resources = resourceSet.getResources();
    final Resource resource = IterableExtensions.<Resource>head(_resources);
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
    URIConverter _uRIConverter = result.getURIConverter();
    EList<URIHandler> _uRIHandlers = _uRIConverter.getURIHandlers();
    _uRIHandlers.clear();
    final InMemoryURIHandler uriHandler = new InMemoryURIHandler();
    final Function1<Pair<String, String>, URI> _function = (Pair<String, String> it) -> {
      try {
        String _key = it.getKey();
        String _plus = ((InMemoryURIHandler.SCHEME + ":/") + _key);
        final URI uri = URI.createURI(_plus);
        Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
        final OutputStream out = uriHandler.createOutputStream(uri, _emptyMap);
        String _value = it.getValue();
        byte[] _bytes = _value.getBytes();
        out.write(_bytes);
        out.close();
        return uri;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final List<URI> uris = ListExtensions.<Pair<String, String>, URI>map(((List<Pair<String, String>>)Conversions.doWrapArray(files)), _function);
    URIConverter _uRIConverter_1 = result.getURIConverter();
    EList<URIHandler> _uRIHandlers_1 = _uRIConverter_1.getURIHandlers();
    _uRIHandlers_1.add(uriHandler);
    for (final URI uri : uris) {
      result.getResource(uri, true);
    }
    return result;
  }
}
