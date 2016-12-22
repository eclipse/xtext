package org.eclipse.xtext.java.tests;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.java.tests.JavaInjectorProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(JavaInjectorProvider.class)
@SuppressWarnings("all")
public class JavaSourceLanguageTest {
  @Test
  public void testNestedTypes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class MySuperClass {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("interface InnerType {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("MySuperClass.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public class MySubClass extends MySuperClass {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public InnerType doStuff(InnerType some) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return some;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("MySubClass.java", _builder_1.toString());
    final XtextResourceSet rs = this.resourceSet(_mappedTo, _mappedTo_1);
    EList<Resource> _resources = rs.getResources();
    final Function1<Resource, Boolean> _function = (Resource it) -> {
      URI _uRI = it.getURI();
      String _string = _uRI.toString();
      return Boolean.valueOf(_string.endsWith("MySuperClass.java"));
    };
    final Resource superResource = IterableExtensions.<Resource>findFirst(_resources, _function);
    EList<EObject> _contents = superResource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    Iterable<JvmDeclaredType> _allNestedTypes = ((JvmGenericType) _head).getAllNestedTypes();
    final JvmDeclaredType nestedType = IterableExtensions.<JvmDeclaredType>head(_allNestedTypes);
    EList<Resource> _resources_1 = rs.getResources();
    final Function1<Resource, Boolean> _function_1 = (Resource it) -> {
      URI _uRI = it.getURI();
      String _string = _uRI.toString();
      return Boolean.valueOf(_string.endsWith("MySubClass.java"));
    };
    final Resource resource = IterableExtensions.<Resource>findFirst(_resources_1, _function_1);
    EList<EObject> _contents_1 = resource.getContents();
    EObject _head_1 = IterableExtensions.<EObject>head(_contents_1);
    final JvmGenericType clazz = ((JvmGenericType) _head_1);
    Iterable<JvmOperation> _declaredOperations = clazz.getDeclaredOperations();
    JvmOperation _head_2 = IterableExtensions.<JvmOperation>head(_declaredOperations);
    JvmTypeReference _returnType = _head_2.getReturnType();
    final JvmType referenced = _returnType.getType();
    Assert.assertSame(nestedType, referenced);
  }
  
  @Test
  public void testOverridenInterfaceMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public interface MySuperClass {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public java.util.Collection<? extends CharSequence> getThem();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("MySuperClass.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("public interface MySubClass extends MySuperClass {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public java.util.List<? extends String> getThem();");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("MySubClass.java", _builder_1.toString());
    final XtextResourceSet rs = this.resourceSet(_mappedTo, _mappedTo_1);
    EList<Resource> _resources = rs.getResources();
    final Function1<Resource, Boolean> _function = (Resource it) -> {
      URI _uRI = it.getURI();
      String _string = _uRI.toString();
      return Boolean.valueOf(_string.endsWith("MySuperClass.java"));
    };
    final Resource superResource = IterableExtensions.<Resource>findFirst(_resources, _function);
    EList<Resource> _resources_1 = rs.getResources();
    final Function1<Resource, Boolean> _function_1 = (Resource it) -> {
      URI _uRI = it.getURI();
      String _string = _uRI.toString();
      return Boolean.valueOf(_string.endsWith("MySubClass.java"));
    };
    final Resource resource = IterableExtensions.<Resource>findFirst(_resources_1, _function_1);
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final JvmGenericType clazz = ((JvmGenericType) _head);
    Iterable<JvmOperation> _declaredOperations = clazz.getDeclaredOperations();
    JvmOperation _head_1 = IterableExtensions.<JvmOperation>head(_declaredOperations);
    final JvmTypeReference referenced = _head_1.getReturnType();
    EList<JvmTypeReference> _arguments = ((JvmParameterizedTypeReference) referenced).getArguments();
    JvmTypeReference _head_2 = IterableExtensions.<JvmTypeReference>head(_arguments);
    Assert.assertNotNull(_head_2);
  }
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private IResourceDescription.Manager resourceDesriptionManager;
  
  @Inject
  private IJvmTypeProvider.Factory typeProviderFactory;
  
  protected XtextResourceSet resourceSet(final Pair<String, String>... files) {
    final XtextResourceSet result = this.resourceSetProvider.get();
    this.typeProviderFactory.createTypeProvider(result);
    Class<? extends JavaSourceLanguageTest> _class = this.getClass();
    ClassLoader _classLoader = _class.getClassLoader();
    result.setClasspathURIContext(_classLoader);
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
    final List<IResourceDescription> descriptions = CollectionLiterals.<IResourceDescription>newArrayList();
    for (final URI uri : uris) {
      {
        final Resource resource = result.getResource(uri, true);
        IResourceDescription _resourceDescription = this.resourceDesriptionManager.getResourceDescription(resource);
        descriptions.add(_resourceDescription);
      }
    }
    ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(descriptions);
    Pair<String, ResourceDescriptionsData> _mappedTo = Pair.<String, ResourceDescriptionsData>of("default", _resourceDescriptionsData);
    final ChunkedResourceDescriptions chunkedResourceDescriptions = new ChunkedResourceDescriptions(
      Collections.<String, ResourceDescriptionsData>unmodifiableMap(CollectionLiterals.<String, ResourceDescriptionsData>newHashMap(_mappedTo)));
    chunkedResourceDescriptions.attachToEmfObject(result);
    return result;
  }
}
