package org.eclipse.xtext.java.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
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
    final Function1<Resource, Boolean> _function = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("MySuperClass.java"));
    };
    final Resource superResource = IterableExtensions.<Resource>findFirst(rs.getResources(), _function);
    EObject _head = IterableExtensions.<EObject>head(superResource.getContents());
    final JvmDeclaredType nestedType = IterableExtensions.<JvmDeclaredType>head(((JvmGenericType) _head).getAllNestedTypes());
    final Function1<Resource, Boolean> _function_1 = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("MySubClass.java"));
    };
    final Resource resource = IterableExtensions.<Resource>findFirst(rs.getResources(), _function_1);
    EObject _head_1 = IterableExtensions.<EObject>head(resource.getContents());
    final JvmGenericType clazz = ((JvmGenericType) _head_1);
    final JvmTypeReference returnType = IterableExtensions.<JvmOperation>head(clazz.getDeclaredOperations()).getReturnType();
    final JvmType referenced = returnType.getType();
    Assert.assertSame(nestedType, referenced);
  }
  
  @Test
  public void testPackageInfo() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package a;");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("a/package-info.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package a;");
    _builder_1.newLine();
    _builder_1.append("public class MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("a/MyClass.java", _builder_1.toString());
    final XtextResourceSet rs = this.resourceSet(_mappedTo, _mappedTo_1);
    final Function1<Resource, Boolean> _function = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("package-info.java"));
    };
    final Resource r1 = IterableExtensions.<Resource>findFirst(rs.getResources(), _function);
    Assert.assertEquals(0, r1.getContents().size());
    final Function1<Resource, Boolean> _function_1 = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("MyClass.java"));
    };
    final Resource r2 = IterableExtensions.<Resource>findFirst(rs.getResources(), _function_1);
    Assert.assertEquals(1, r2.getContents().size());
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
    final Function1<Resource, Boolean> _function = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("MySubClass.java"));
    };
    final Resource resource = IterableExtensions.<Resource>findFirst(rs.getResources(), _function);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final JvmGenericType clazz = ((JvmGenericType) _head);
    final JvmTypeReference referenced = IterableExtensions.<JvmOperation>head(clazz.getDeclaredOperations()).getReturnType();
    Assert.assertNotNull(IterableExtensions.<JvmTypeReference>head(((JvmParameterizedTypeReference) referenced).getArguments()));
  }
  
  @Test
  public void testAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public @interface MyAnnotation {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("String value();");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Class<?>[] imported() default {};");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean statementExpression() default false;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("boolean constantExpression() default false;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("MyAnnotation.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@MyAnnotation(value=\"foo\", constantExpression = true)");
    _builder_1.newLine();
    _builder_1.append("public interface MyClass {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("MyClass.java", _builder_1.toString());
    final XtextResourceSet rs = this.resourceSet(_mappedTo, _mappedTo_1);
    final Function1<Resource, Boolean> _function = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("MyAnnotation.java"));
    };
    final EObject annotation = IterableExtensions.<EObject>head(IterableExtensions.<Resource>findFirst(rs.getResources(), _function).getContents());
    final Function1<Resource, Boolean> _function_1 = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("MyClass.java"));
    };
    final Resource resource = IterableExtensions.<Resource>findFirst(rs.getResources(), _function_1);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    final JvmGenericType clazz = ((JvmGenericType) _head);
    final JvmAnnotationReference annotationRef = IterableExtensions.<JvmAnnotationReference>head(clazz.getAnnotations());
    final Function1<JvmAnnotationValue, Boolean> _function_2 = (JvmAnnotationValue it) -> {
      String _simpleName = it.getOperation().getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "constantExpression"));
    };
    final JvmAnnotationValue value = IterableExtensions.<JvmAnnotationValue>findFirst(annotationRef.getValues(), _function_2);
    Assert.assertTrue((IterableExtensions.<Boolean>head(((JvmBooleanAnnotationValue) value).getValues())).booleanValue());
    final Function1<JvmAnnotationValue, Boolean> _function_3 = (JvmAnnotationValue it) -> {
      String _simpleName = it.getOperation().getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "statementExpression"));
    };
    final JvmAnnotationValue value2 = IterableExtensions.<JvmAnnotationValue>findFirst(annotationRef.getValues(), _function_3);
    Assert.assertFalse((IterableExtensions.<Boolean>head(((JvmBooleanAnnotationValue) value2).getValues())).booleanValue());
    Assert.assertSame(annotation, annotationRef.getAnnotation());
  }
  
  @Test
  public void testClassShadowing() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtext.java.tests;");
    _builder.newLine();
    _builder.append("public class MySuperClass2 {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void doSomething() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    Pair<String, String> _mappedTo = Pair.<String, String>of("org/eclipse/xtext/java/tests/MySuperClass2.java", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.eclipse.xtext.java.tests;");
    _builder_1.newLine();
    _builder_1.append("public class MySubClass2 extends MySuperClass2 {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("org/eclipse/xtext/java/tests/MySubClass2.java", _builder_1.toString());
    final XtextResourceSet rs = this.resourceSet(_mappedTo, _mappedTo_1);
    final Function1<Resource, Boolean> _function = (Resource it) -> {
      return Boolean.valueOf(it.getURI().toString().endsWith("MySuperClass2.java"));
    };
    final Resource superResource = IterableExtensions.<Resource>findFirst(rs.getResources(), _function);
    EObject _head = IterableExtensions.<EObject>head(superResource.getContents());
    final JvmGenericType clazz = ((JvmGenericType) _head);
    Assert.assertNotNull(IterableExtensions.<JvmOperation>head(clazz.getDeclaredOperations()));
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
    result.setClasspathURIContext(this.getClass().getClassLoader());
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
