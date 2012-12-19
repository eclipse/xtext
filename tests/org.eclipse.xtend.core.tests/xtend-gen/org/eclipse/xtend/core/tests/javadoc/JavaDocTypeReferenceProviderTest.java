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
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
