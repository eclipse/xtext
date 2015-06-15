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
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.java.tests.JavaInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.InMemoryURIHandler;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.XtextResourceSet;
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
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
      @Override
      public void apply(final JvmGenericType it) {
        String _qualifiedName = it.getQualifiedName();
        Assert.assertEquals("MyTest", _qualifiedName);
        boolean _isInterface = it.isInterface();
        Assert.assertFalse(_isInterface);
        EList<JvmMember> _members = it.getMembers();
        int _size = _members.size();
        Assert.assertEquals(0, _size);
      }
    };
    this.<JvmGenericType>resultsIn(_builder, _function);
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
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
      @Override
      public void apply(final JvmGenericType it) {
        String _qualifiedName = it.getQualifiedName();
        Assert.assertEquals("MyTest", _qualifiedName);
        boolean _isInterface = it.isInterface();
        Assert.assertTrue(_isInterface);
        EList<JvmMember> _members = it.getMembers();
        int _size = _members.size();
        Assert.assertEquals(0, _size);
      }
    };
    this.<JvmGenericType>resultsIn(_builder, _function);
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
    final Procedure1<JvmDeclaredType> _function = new Procedure1<JvmDeclaredType>() {
      @Override
      public void apply(final JvmDeclaredType it) {
        String _qualifiedName = it.getQualifiedName();
        Assert.assertEquals("MyTest", _qualifiedName);
        Assert.assertTrue((it instanceof JvmEnumerationType));
        EList<JvmMember> _members = it.getMembers();
        int _size = _members.size();
        Assert.assertEquals(0, _size);
      }
    };
    this.<JvmDeclaredType>resultsIn(_builder, _function);
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
    final Procedure1<JvmDeclaredType> _function = new Procedure1<JvmDeclaredType>() {
      @Override
      public void apply(final JvmDeclaredType it) {
        String _qualifiedName = it.getQualifiedName();
        Assert.assertEquals("MyTest", _qualifiedName);
        Assert.assertTrue((it instanceof JvmAnnotationType));
        EList<JvmMember> _members = it.getMembers();
        int _size = _members.size();
        Assert.assertEquals(0, _size);
      }
    };
    this.<JvmDeclaredType>resultsIn(_builder, _function);
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
    final Procedure1<JvmDeclaredType> _function = new Procedure1<JvmDeclaredType>() {
      @Override
      public void apply(final JvmDeclaredType it) {
        String _qualifiedName = it.getQualifiedName();
        Assert.assertEquals("my.pack.MyTest", _qualifiedName);
        EList<JvmMember> _members = it.getMembers();
        int _size = _members.size();
        Assert.assertEquals(0, _size);
      }
    };
    this.<JvmDeclaredType>resultsIn(_builder, _function);
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
    final Procedure1<JvmDeclaredType> _function = new Procedure1<JvmDeclaredType>() {
      @Override
      public void apply(final JvmDeclaredType it) {
        String _qualifiedName = it.getQualifiedName();
        Assert.assertEquals("my.pack.MyTest", _qualifiedName);
        EList<JvmMember> _members = it.getMembers();
        int _size = _members.size();
        Assert.assertEquals(4, _size);
        EList<JvmMember> _members_1 = it.getMembers();
        JvmMember _get = _members_1.get(0);
        final Procedure1<JvmMember> _function = new Procedure1<JvmMember>() {
          @Override
          public void apply(final JvmMember it) {
            String _qualifiedName = it.getQualifiedName();
            Assert.assertEquals("my.pack.MyTest$InnerClass", _qualifiedName);
            Assert.assertTrue((it instanceof JvmGenericType));
          }
        };
        ObjectExtensions.<JvmMember>operator_doubleArrow(_get, _function);
        EList<JvmMember> _members_2 = it.getMembers();
        JvmMember _get_1 = _members_2.get(1);
        final Procedure1<JvmMember> _function_1 = new Procedure1<JvmMember>() {
          @Override
          public void apply(final JvmMember it) {
            String _qualifiedName = it.getQualifiedName();
            Assert.assertEquals("my.pack.MyTest$InnerInterface", _qualifiedName);
            Assert.assertTrue((it instanceof JvmGenericType));
          }
        };
        ObjectExtensions.<JvmMember>operator_doubleArrow(_get_1, _function_1);
        EList<JvmMember> _members_3 = it.getMembers();
        JvmMember _get_2 = _members_3.get(2);
        final Procedure1<JvmMember> _function_2 = new Procedure1<JvmMember>() {
          @Override
          public void apply(final JvmMember it) {
            String _qualifiedName = it.getQualifiedName();
            Assert.assertEquals("my.pack.MyTest$InnerEnum", _qualifiedName);
            Assert.assertTrue((it instanceof JvmEnumerationType));
          }
        };
        ObjectExtensions.<JvmMember>operator_doubleArrow(_get_2, _function_2);
        EList<JvmMember> _members_4 = it.getMembers();
        JvmMember _get_3 = _members_4.get(3);
        final Procedure1<JvmMember> _function_3 = new Procedure1<JvmMember>() {
          @Override
          public void apply(final JvmMember it) {
            String _qualifiedName = it.getQualifiedName();
            Assert.assertEquals("my.pack.MyTest$InnerAnnotation", _qualifiedName);
            Assert.assertTrue((it instanceof JvmAnnotationType));
          }
        };
        ObjectExtensions.<JvmMember>operator_doubleArrow(_get_3, _function_3);
      }
    };
    this.<JvmDeclaredType>resultsIn(_builder, _function);
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
    final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
      @Override
      public void apply(final JvmGenericType it) {
        String _qualifiedName = it.getQualifiedName();
        Assert.assertEquals("my.pack.MyTest", _qualifiedName);
        EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
        int _size = _typeParameters.size();
        Assert.assertEquals(1, _size);
        EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
        JvmTypeParameter _head = IterableExtensions.<JvmTypeParameter>head(_typeParameters_1);
        String _name = _head.getName();
        Assert.assertEquals("T", _name);
        EList<JvmMember> _members = it.getMembers();
        JvmMember _head_1 = IterableExtensions.<JvmMember>head(_members);
        final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
          @Override
          public void apply(final JvmGenericType it) {
            String _qualifiedName = it.getQualifiedName();
            Assert.assertEquals("my.pack.MyTest$InnerInterface", _qualifiedName);
            EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
            int _size = _typeParameters.size();
            Assert.assertEquals(2, _size);
            EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
            JvmTypeParameter _head = IterableExtensions.<JvmTypeParameter>head(_typeParameters_1);
            String _name = _head.getName();
            Assert.assertEquals("A", _name);
            EList<JvmMember> _members = it.getMembers();
            JvmMember _head_1 = IterableExtensions.<JvmMember>head(_members);
            final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
              @Override
              public void apply(final JvmGenericType it) {
                String _qualifiedName = it.getQualifiedName();
                Assert.assertEquals("my.pack.MyTest$InnerInterface$DeepNested", _qualifiedName);
                EList<JvmTypeParameter> _typeParameters = it.getTypeParameters();
                int _size = _typeParameters.size();
                Assert.assertEquals(1, _size);
                EList<JvmTypeParameter> _typeParameters_1 = it.getTypeParameters();
                JvmTypeParameter _head = IterableExtensions.<JvmTypeParameter>head(_typeParameters_1);
                String _name = _head.getName();
                Assert.assertEquals("X", _name);
              }
            };
            ObjectExtensions.<JvmGenericType>operator_doubleArrow(
              ((JvmGenericType) _head_1), _function);
          }
        };
        ObjectExtensions.<JvmGenericType>operator_doubleArrow(
          ((JvmGenericType) _head_1), _function);
      }
    };
    this.<JvmGenericType>resultsIn(_builder, _function);
  }
  
  protected <T extends JvmDeclaredType> void resultsIn(final CharSequence javaCode, final Procedure1<? super T> assertion) {
    String _string = javaCode.toString();
    Pair<String, String> _mappedTo = Pair.<String, String>of("SomeJava.java", _string);
    final XtextResourceSet resourceSet = this.resourceSet(_mappedTo);
    this.compilerPhases.setIndexing(resourceSet, true);
    EList<Resource> _resources = resourceSet.getResources();
    final Resource resource = IterableExtensions.<Resource>head(_resources);
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final T type = ((T) _head);
    assertion.apply(type);
  }
  
  @Inject
  private CompilerPhases compilerPhases;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  protected XtextResourceSet resourceSet(final Pair<String, String>... files) {
    final XtextResourceSet result = this.resourceSetProvider.get();
    URIConverter _uRIConverter = result.getURIConverter();
    EList<URIHandler> _uRIHandlers = _uRIConverter.getURIHandlers();
    _uRIHandlers.clear();
    final InMemoryURIHandler uriHandler = new InMemoryURIHandler();
    final Function1<Pair<String, String>, URI> _function = new Function1<Pair<String, String>, URI>() {
      @Override
      public URI apply(final Pair<String, String> it) {
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
