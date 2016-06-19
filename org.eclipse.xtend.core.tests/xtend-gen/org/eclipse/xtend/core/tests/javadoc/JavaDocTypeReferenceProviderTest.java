package org.eclipse.xtend.core.tests.javadoc;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JavaDocTypeReferenceProviderTest extends AbstractXtendTestCase {
  @Inject
  private IJavaDocTypeReferenceProvider javaDocTypeReferenceProvider;
  
  @Test
  public void testComputation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link List}");
      _builder.newLine();
      _builder.append("* {@link String}");
      _builder.newLine();
      _builder.append("* {@link Integer");
      _builder.newLine();
      _builder.append("* {@link ArrayList}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(3, _size);
      ReplaceRegion _head = IterableExtensions.<ReplaceRegion>head(regions);
      String _text = _head.getText();
      Assert.assertEquals("List", _text);
      int _indexOf = input.indexOf("List");
      ReplaceRegion _head_1 = IterableExtensions.<ReplaceRegion>head(regions);
      int _offset = _head_1.getOffset();
      Assert.assertEquals(_indexOf, _offset);
      int _length = "List".length();
      ReplaceRegion _head_2 = IterableExtensions.<ReplaceRegion>head(regions);
      int _length_1 = _head_2.getLength();
      Assert.assertEquals(_length, _length_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link java.util.ArrayList @see Integer}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(1, _size);
      ReplaceRegion _head = IterableExtensions.<ReplaceRegion>head(regions);
      String _text = _head.getText();
      Assert.assertEquals("java.util.ArrayList", _text);
      int _indexOf = input.indexOf("java.util.ArrayList");
      ReplaceRegion _head_1 = IterableExtensions.<ReplaceRegion>head(regions);
      int _offset = _head_1.getOffset();
      Assert.assertEquals(_indexOf, _offset);
      int _length = "java.util.ArrayList".length();
      ReplaceRegion _head_2 = IterableExtensions.<ReplaceRegion>head(regions);
      int _length_1 = _head_2.getLength();
      Assert.assertEquals(_length, _length_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link java.util.ArrayList");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link java.util.ArrayList");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_5() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @param string - a fancy string");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @param anotherString-even more fancy");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("* @param zonk");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def bar(String string, String anotherString, Integer zonk){}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeParameterTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(3, _size);
      ReplaceRegion _head = IterableExtensions.<ReplaceRegion>head(regions);
      String _text = _head.getText();
      Assert.assertEquals("string", _text);
      int _indexOf = input.indexOf("string");
      ReplaceRegion _head_1 = IterableExtensions.<ReplaceRegion>head(regions);
      int _offset = _head_1.getOffset();
      Assert.assertEquals(_indexOf, _offset);
      int _length = "string".length();
      ReplaceRegion _head_2 = IterableExtensions.<ReplaceRegion>head(regions);
      int _length_1 = _head_2.getLength();
      Assert.assertEquals(_length, _length_1);
      ReplaceRegion _get = regions.get(1);
      String _text_1 = _get.getText();
      Assert.assertEquals("anotherString", _text_1);
      int _indexOf_1 = input.indexOf("anotherString");
      ReplaceRegion _get_1 = regions.get(1);
      int _offset_1 = _get_1.getOffset();
      Assert.assertEquals(_indexOf_1, _offset_1);
      int _length_2 = "anotherString".length();
      ReplaceRegion _get_2 = regions.get(1);
      int _length_3 = _get_2.getLength();
      Assert.assertEquals(_length_2, _length_3);
      ReplaceRegion _get_3 = regions.get(2);
      String _text_2 = _get_3.getText();
      Assert.assertEquals("zonk", _text_2);
      int _indexOf_2 = input.indexOf("zonk");
      ReplaceRegion _get_4 = regions.get(2);
      int _offset_2 = _get_4.getOffset();
      Assert.assertEquals(_indexOf_2, _offset_2);
      int _length_4 = "zonk".length();
      ReplaceRegion _get_5 = regions.get(2);
      int _length_5 = _get_5.getLength();
      Assert.assertEquals(_length_4, _length_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_6() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link }");
      _builder.newLine();
      _builder.append("* @see");
      _builder.newLine();
      _builder.append("* @see");
      _builder.newLine();
      _builder.append("* {@link}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(0, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_7() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link    String}");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(1, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_8() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* @see    String");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(1, _size);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testComputation_9() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append("* {@link    String #length()  }");
      _builder.newLine();
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String input = _builder.toString();
      XtendClass _clazz = this.clazz(input);
      Resource _eResource = _clazz.eResource();
      final XtextResource resource = ((XtextResource) _eResource);
      IParseResult _parseResult = resource.getParseResult();
      final ICompositeNode rootNode = _parseResult.getRootNode();
      final List<ReplaceRegion> regions = this.javaDocTypeReferenceProvider.computeTypeRefRegions(rootNode);
      int _size = regions.size();
      Assert.assertEquals(1, _size);
      ReplaceRegion _head = IterableExtensions.<ReplaceRegion>head(regions);
      String _text = _head.getText();
      Assert.assertEquals("String", _text);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
