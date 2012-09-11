package org.eclipse.xtend.core.tests.formatting;

import com.google.common.base.Objects;
import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.formatting.RendererConfiguration;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XtendInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractFormatterTest {
  @Inject
  private ParseHelper<XtendFile> _parseHelper;
  
  @Inject
  private XtendFormatter formatter;
  
  public void assertFormatted(final CharSequence toBeFormatted) {
    try {
      XtendFile _parse = this._parseHelper.parse(toBeFormatted);
      String _flattenWhitespace = this.flattenWhitespace(_parse);
      this.assertFormatted(toBeFormatted, _flattenWhitespace);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private CharSequence toFile(final CharSequence expression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(expression, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public void assertFormattedExpression(final CharSequence toBeFormatted) {
    try {
      CharSequence _file = this.toFile(toBeFormatted);
      CharSequence _file_1 = this.toFile(toBeFormatted);
      XtendFile _parse = this._parseHelper.parse(_file_1);
      String _flattenWhitespace = this.flattenWhitespace(_parse);
      this.assertFormatted(_file, _flattenWhitespace);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertFormattedExpression(final String expectation, final CharSequence toBeFormatted) {
    CharSequence _file = this.toFile(expectation);
    CharSequence _file_1 = this.toFile(toBeFormatted);
    this.assertFormatted(_file, _file_1);
  }
  
  private String flattenWhitespace(final EObject obj) {
    StringBuilder _stringBuilder = new StringBuilder();
    final StringBuilder result = _stringBuilder;
    Resource _eResource = obj.eResource();
    IParseResult _parseResult = ((XtextResource) _eResource).getParseResult();
    ICompositeNode _rootNode = _parseResult.getRootNode();
    Iterable<ILeafNode> _leafNodes = _rootNode.getLeafNodes();
    for (final ILeafNode node : _leafNodes) {
      boolean _and = false;
      boolean _isHidden = node.isHidden();
      if (!_isHidden) {
        _and = false;
      } else {
        String _text = node.getText();
        String _trim = _text.trim();
        boolean _equals = Objects.equal(_trim, "");
        _and = (_isHidden && _equals);
      }
      if (_and) {
        result.append(" ");
      } else {
        String _text_1 = node.getText();
        result.append(_text_1);
      }
    }
    return result.toString();
  }
  
  public void assertFormatted(final CharSequence expectation, final CharSequence toBeFormatted) {
    try {
      final XtendFile parsed = this._parseHelper.parse(toBeFormatted);
      Resource _eResource = parsed.eResource();
      EList<Diagnostic> _errors = _eResource.getErrors();
      int _size = _errors.size();
      Assert.assertEquals(0, _size);
      Resource _eResource_1 = parsed.eResource();
      IParseResult _parseResult = ((XtextResource) _eResource_1).getParseResult();
      final ICompositeNode root = _parseResult.getRootNode();
      final String oldDocument = root.getText();
      RendererConfiguration _rendererConfiguration = new RendererConfiguration();
      final Procedure1<RendererConfiguration> _function = new Procedure1<RendererConfiguration>() {
          public void apply(final RendererConfiguration it) {
            it.setMaxLineWidth(80);
          }
        };
      final RendererConfiguration rc = ObjectExtensions.<RendererConfiguration>operator_doubleArrow(_rendererConfiguration, _function);
      this.formatter.setAllowIdentityEdits(true);
      Resource _eResource_2 = parsed.eResource();
      int _length = oldDocument.length();
      final List<TextReplacement> edits = this.formatter.format(((XtextResource) _eResource_2), 0, _length, rc);
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder newDocument = _stringBuilder;
      StringBuilder _stringBuilder_1 = new StringBuilder();
      final StringBuilder debugTrace = _stringBuilder_1;
      final Function1<TextReplacement,Integer> _function_1 = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            int _offset = it.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function_1);
      for (final TextReplacement edit : _sortBy) {
        {
          int _offset = edit.getOffset();
          final String text = oldDocument.substring(lastOffset, _offset);
          newDocument.append(text);
          String _text = edit.getText();
          newDocument.append(_text);
          debugTrace.append(text);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          int _offset_1 = edit.getOffset();
          int _offset_2 = edit.getOffset();
          int _length_1 = edit.getLength();
          int _plus = (_offset_2 + _length_1);
          String _substring = oldDocument.substring(_offset_1, _plus);
          _builder.append(_substring, "");
          _builder.append("|");
          String _text_1 = edit.getText();
          _builder.append(_text_1, "");
          _builder.append("]");
          debugTrace.append(_builder.toString());
          int _offset_3 = edit.getOffset();
          int _length_2 = edit.getLength();
          int _plus_1 = (_offset_3 + _length_2);
          lastOffset = _plus_1;
        }
      }
      int _length_1 = oldDocument.length();
      final String text = oldDocument.substring(lastOffset, _length_1);
      newDocument.append(text);
      debugTrace.append(text);
      try {
        String _string = expectation.toString();
        String _string_1 = newDocument.toString();
        Assert.assertEquals(_string, _string_1);
      } catch (final Throwable _t) {
        if (_t instanceof AssertionError) {
          final AssertionError e = (AssertionError)_t;
          InputOutput.<StringBuilder>println(debugTrace);
          InputOutput.println();
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
