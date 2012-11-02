package org.eclipse.xtend.core.tests.formatting;

import java.util.List;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.formatting.IntegerEntry;
import org.eclipse.xtend.core.formatting.TextReplacement;
import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
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
  
  private CharSequence toMember(final CharSequence expression) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(expression, "	");
    _builder.newLineIfNotEmpty();
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
  
  public void assertFormattedMember(final String expectation, final CharSequence toBeFormatted) {
    CharSequence _member = this.toMember(expectation);
    CharSequence _member_1 = this.toMember(toBeFormatted);
    this.assertFormatted(_member, _member_1);
  }
  
  private String flattenWhitespace(final EObject obj) {
    String _xblockexpression = null;
    {
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder result = _stringBuilder;
      Resource _eResource = obj.eResource();
      IParseResult _parseResult = ((XtextResource) _eResource).getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      Iterable<ILeafNode> _leafNodes = _rootNode.getLeafNodes();
      for (final ILeafNode node : _leafNodes) {
        String _text = node.getText();
        String _trim = _text.trim();
        int _length = _trim.length();
        boolean _greaterThan = (_length > 0);
        if (_greaterThan) {
          result.append("  ");
          String _text_1 = node.getText();
          result.append(_text_1);
        }
      }
      String _string = result.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  public void assertFormatted(final CharSequence expectation, final CharSequence toBeFormatted) {
    try {
      final XtendFile parsed = this._parseHelper.parse(toBeFormatted);
      Resource _eResource = parsed.eResource();
      EList<Diagnostic> _errors = _eResource.getErrors();
      String _join = IterableExtensions.join(_errors, "\n");
      Resource _eResource_1 = parsed.eResource();
      EList<Diagnostic> _errors_1 = _eResource_1.getErrors();
      int _size = _errors_1.size();
      Assert.assertEquals(_join, 0, _size);
      Resource _eResource_2 = parsed.eResource();
      IParseResult _parseResult = ((XtextResource) _eResource_2).getParseResult();
      ICompositeNode _rootNode = _parseResult.getRootNode();
      final String oldDocument = _rootNode.getText();
      XtendFormatterConfig _xtendFormatterConfig = new XtendFormatterConfig();
      final Procedure1<XtendFormatterConfig> _function = new Procedure1<XtendFormatterConfig>() {
          public void apply(final XtendFormatterConfig it) {
            IntegerEntry _maxLineWidth = it.getMaxLineWidth();
            _maxLineWidth.setValue(80);
          }
        };
      final XtendFormatterConfig rc = ObjectExtensions.<XtendFormatterConfig>operator_doubleArrow(_xtendFormatterConfig, _function);
      this.formatter.setAllowIdentityEdits(true);
      Resource _eResource_3 = parsed.eResource();
      int _length = oldDocument.length();
      final List<TextReplacement> edits = this.formatter.format(((XtextResource) _eResource_3), 0, _length, rc);
      final String newDocument = this.applyEdits(oldDocument, edits);
      try {
        String _string = expectation.toString();
        String _string_1 = newDocument.toString();
        Assert.assertEquals(_string, _string_1);
      } catch (final Throwable _t) {
        if (_t instanceof AssertionError) {
          final AssertionError e = (AssertionError)_t;
          String _applyDebugEdits = this.applyDebugEdits(oldDocument, edits);
          InputOutput.<String>println(_applyDebugEdits);
          InputOutput.println();
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final XtendFile parsed2 = this._parseHelper.parse(newDocument);
      Resource _eResource_4 = parsed2.eResource();
      EList<Diagnostic> _errors_2 = _eResource_4.getErrors();
      int _size_1 = _errors_2.size();
      Assert.assertEquals(0, _size_1);
      Resource _eResource_5 = parsed2.eResource();
      int _length_1 = newDocument.length();
      final List<TextReplacement> edits2 = this.formatter.format(((XtextResource) _eResource_5), 0, _length_1, rc);
      final String newDocument2 = this.applyEdits(newDocument, edits2);
      try {
        String _string_2 = newDocument.toString();
        String _string_3 = newDocument2.toString();
        Assert.assertEquals(_string_2, _string_3);
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof AssertionError) {
          final AssertionError e_1 = (AssertionError)_t_1;
          String _applyDebugEdits_1 = this.applyDebugEdits(newDocument, edits2);
          InputOutput.<String>println(_applyDebugEdits_1);
          InputOutput.println();
          throw e_1;
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String applyEdits(final String oldDocument, final List<TextReplacement> edits) {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder newDocument = _stringBuilder;
      final Function1<TextReplacement,Integer> _function = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            int _offset = it.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          int _offset = edit.getOffset();
          String _substring = oldDocument.substring(lastOffset, _offset);
          newDocument.append(_substring);
          String _text = edit.getText();
          newDocument.append(_text);
          int _offset_1 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_1 + _length);
          lastOffset = _plus;
        }
      }
      int _length = oldDocument.length();
      String _substring = oldDocument.substring(lastOffset, _length);
      newDocument.append(_substring);
      String _string = newDocument.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected String applyDebugEdits(final String oldDocument, final List<TextReplacement> edits) {
    String _xblockexpression = null;
    {
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder debugTrace = _stringBuilder;
      final Function1<TextReplacement,Integer> _function = new Function1<TextReplacement,Integer>() {
          public Integer apply(final TextReplacement it) {
            int _offset = it.getOffset();
            return Integer.valueOf(_offset);
          }
        };
      List<TextReplacement> _sortBy = IterableExtensions.<TextReplacement, Integer>sortBy(edits, _function);
      for (final TextReplacement edit : _sortBy) {
        {
          int _offset = edit.getOffset();
          String _substring = oldDocument.substring(lastOffset, _offset);
          debugTrace.append(_substring);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          int _offset_1 = edit.getOffset();
          int _offset_2 = edit.getOffset();
          int _length = edit.getLength();
          int _plus = (_offset_2 + _length);
          String _substring_1 = oldDocument.substring(_offset_1, _plus);
          _builder.append(_substring_1, "");
          _builder.append("|");
          String _text = edit.getText();
          _builder.append(_text, "");
          _builder.append("]");
          debugTrace.append(_builder.toString());
          int _offset_3 = edit.getOffset();
          int _length_1 = edit.getLength();
          int _plus_1 = (_offset_3 + _length_1);
          lastOffset = _plus_1;
        }
      }
      int _length = oldDocument.length();
      String _substring = oldDocument.substring(lastOffset, _length);
      debugTrace.append(_substring);
      String _string = debugTrace.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
}
