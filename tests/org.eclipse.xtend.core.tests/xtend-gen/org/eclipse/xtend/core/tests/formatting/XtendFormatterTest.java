package org.eclipse.xtend.core.tests.formatting;

import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtend.core.formatting.XtendFormatter2;
import org.eclipse.xtend.core.tests.compiler.batch.XtendInjectorProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = XtendInjectorProvider.class)
@SuppressWarnings("all")
public class XtendFormatterTest {
  @Inject
  private ParseHelper<XtendFile> _parseHelper;
  
  @Inject
  private XtendFormatter2 formatter;
  
  public void assertFormatted(final CharSequence toBeFormatted) {
    this.assertFormatted(toBeFormatted, toBeFormatted);
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
      final ArrayList<Triple<Integer,Integer,String>> edits = CollectionLiterals.<Triple<Integer,Integer,String>>newArrayList();
      int _length = oldDocument.length();
      final Procedure3<Integer,Integer,String> _function = new Procedure3<Integer,Integer,String>() {
          public void apply(final Integer offset, final Integer length, final String replacement) {
            Triple<Integer,Integer,String> _create = Tuples.<Integer, Integer, String>create(Integer.valueOf(offset), Integer.valueOf(length), replacement);
            edits.add(_create);
          }
        };
      this.formatter.format(root, 0, _length, _function);
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder newDocument = _stringBuilder;
      StringBuilder _stringBuilder_1 = new StringBuilder();
      final StringBuilder debugTrace = _stringBuilder_1;
      for (final Triple<Integer,Integer,String> edit : edits) {
        {
          Integer _first = edit.getFirst();
          final String text = oldDocument.substring(lastOffset, (_first).intValue());
          newDocument.append(text);
          String _third = edit.getThird();
          newDocument.append(_third);
          debugTrace.append(text);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("[");
          Integer _first_1 = edit.getFirst();
          Integer _first_2 = edit.getFirst();
          String _substring = oldDocument.substring((_first_1).intValue(), (_first_2).intValue());
          _builder.append(_substring, "");
          _builder.append("|");
          String _third_1 = edit.getThird();
          _builder.append(_third_1, "");
          _builder.append("]");
          debugTrace.append(_builder.toString());
          Integer _first_3 = edit.getFirst();
          Integer _second = edit.getSecond();
          int _plus = ((_first_3).intValue() + (_second).intValue());
          lastOffset = _plus;
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
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void format1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo class bar{}");
    _builder_1.newLine();
    this.assertFormatted(_builder, _builder_1);
  }
}
