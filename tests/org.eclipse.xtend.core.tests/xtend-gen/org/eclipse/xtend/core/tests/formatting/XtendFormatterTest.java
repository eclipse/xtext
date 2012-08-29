package org.eclipse.xtend.core.tests.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
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
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  public CharSequence toFile(final CharSequence expression) {
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
  
  public String flattenWhitespace(final EObject obj) {
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
      final ArrayList<Triple<Integer,Integer,String>> edits = CollectionLiterals.<Triple<Integer,Integer,String>>newArrayList();
      Resource _eResource_2 = parsed.eResource();
      int _length = oldDocument.length();
      final Procedure3<Integer,Integer,String> _function = new Procedure3<Integer,Integer,String>() {
          public void apply(final Integer offset, final Integer length, final String replacement) {
            boolean _lessThan = (offset < 0);
            if (_lessThan) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Offset to small. Offset: ");
              _builder.append(offset, "");
              IllegalStateException _illegalStateException = new IllegalStateException(_builder.toString());
              throw _illegalStateException;
            }
            boolean _lessThan_1 = (length < 0);
            if (_lessThan_1) {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("Length to small. Length: ");
              _builder_1.append(length, "");
              IllegalStateException _illegalStateException_1 = new IllegalStateException(_builder_1.toString());
              throw _illegalStateException_1;
            }
            int _plus = (offset + length);
            int _length = oldDocument.length();
            boolean _greaterThan = (_plus > _length);
            if (_greaterThan) {
              StringConcatenation _builder_2 = new StringConcatenation();
              _builder_2.append("Range exceeds document. Offset: ");
              _builder_2.append(offset, "");
              _builder_2.append(" Length: ");
              _builder_2.append(length, "");
              _builder_2.append(" DocumentLenght: ");
              int _length_1 = oldDocument.length();
              _builder_2.append(_length_1, "");
              IllegalStateException _illegalStateException_2 = new IllegalStateException(_builder_2.toString());
              throw _illegalStateException_2;
            }
            final Function1<Triple<Integer,Integer,String>,Boolean> _function = new Function1<Triple<Integer,Integer,String>,Boolean>() {
                public Boolean apply(final Triple<Integer,Integer,String> it) {
                  boolean _and = false;
                  Integer _first = it.getFirst();
                  boolean _greaterEqualsThan = (offset >= (_first).intValue());
                  if (!_greaterEqualsThan) {
                    _and = false;
                  } else {
                    Integer _first_1 = it.getFirst();
                    Integer _second = it.getSecond();
                    int _plus = ((_first_1).intValue() + (_second).intValue());
                    boolean _lessEqualsThan = (offset <= _plus);
                    _and = (_greaterEqualsThan && _lessEqualsThan);
                  }
                  return Boolean.valueOf(_and);
                }
              };
            boolean _exists = IterableExtensions.<Triple<Integer,Integer,String>>exists(edits, _function);
            if (_exists) {
              StringConcatenation _builder_3 = new StringConcatenation();
              _builder_3.append("Offset inside existing edit. Offset: ");
              _builder_3.append(offset, "");
              _builder_3.append(" Length: ");
              _builder_3.append(length, "");
              IllegalStateException _illegalStateException_3 = new IllegalStateException(_builder_3.toString());
              throw _illegalStateException_3;
            }
            final Function1<Triple<Integer,Integer,String>,Boolean> _function_1 = new Function1<Triple<Integer,Integer,String>,Boolean>() {
                public Boolean apply(final Triple<Integer,Integer,String> it) {
                  boolean _and = false;
                  int _plus = (offset + length);
                  Integer _first = it.getFirst();
                  boolean _greaterEqualsThan = (_plus >= (_first).intValue());
                  if (!_greaterEqualsThan) {
                    _and = false;
                  } else {
                    int _plus_1 = (offset + length);
                    Integer _first_1 = it.getFirst();
                    Integer _second = it.getSecond();
                    int _plus_2 = ((_first_1).intValue() + (_second).intValue());
                    boolean _lessEqualsThan = (_plus_1 <= _plus_2);
                    _and = (_greaterEqualsThan && _lessEqualsThan);
                  }
                  return Boolean.valueOf(_and);
                }
              };
            boolean _exists_1 = IterableExtensions.<Triple<Integer,Integer,String>>exists(edits, _function_1);
            if (_exists_1) {
              StringConcatenation _builder_4 = new StringConcatenation();
              _builder_4.append("Offset+Lenght inside existing edit. Offset: ");
              _builder_4.append(offset, "");
              _builder_4.append(" Length: ");
              _builder_4.append(length, "");
              IllegalStateException _illegalStateException_4 = new IllegalStateException(_builder_4.toString());
              throw _illegalStateException_4;
            }
            Triple<Integer,Integer,String> _create = Tuples.<Integer, Integer, String>create(Integer.valueOf(offset), Integer.valueOf(length), replacement);
            edits.add(_create);
          }
        };
      this.formatter.format(((XtextResource) _eResource_2), 0, _length, _function);
      int lastOffset = 0;
      StringBuilder _stringBuilder = new StringBuilder();
      final StringBuilder newDocument = _stringBuilder;
      StringBuilder _stringBuilder_1 = new StringBuilder();
      final StringBuilder debugTrace = _stringBuilder_1;
      final Function1<Triple<Integer,Integer,String>,Integer> _function_1 = new Function1<Triple<Integer,Integer,String>,Integer>() {
          public Integer apply(final Triple<Integer,Integer,String> it) {
            Integer _first = it.getFirst();
            return _first;
          }
        };
      List<Triple<Integer,Integer,String>> _sortBy = IterableExtensions.<Triple<Integer,Integer,String>, Integer>sortBy(edits, _function_1);
      for (final Triple<Integer,Integer,String> edit : _sortBy) {
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
          Integer _second = edit.getSecond();
          int _plus = ((_first_2).intValue() + (_second).intValue());
          String _substring = oldDocument.substring((_first_1).intValue(), _plus);
          _builder.append(_substring, "");
          _builder.append("|");
          String _third_1 = edit.getThird();
          _builder.append(_third_1, "");
          _builder.append("]");
          debugTrace.append(_builder.toString());
          Integer _first_3 = edit.getFirst();
          Integer _second_1 = edit.getSecond();
          int _plus_1 = ((_first_3).intValue() + (_second_1).intValue());
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
  
  @Test
  public void formatClass() {
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
  
  @Test
  public void formatClassAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatImports() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.Map");
    _builder.newLine();
    _builder.append("import java.util.Set");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethod() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethod1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethod2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def baz(String x, String y) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatMethodAnnotation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated def baz() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormatted(_builder);
  }
  
  @Test
  public void formatGenerics() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = <Pair<String, String>>newArrayList()");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatBlockExpression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\");");
    _builder.newLine();
    _builder.append("val y = \'foo\';");
    _builder.newLine();
    _builder.append("x.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") ; val y = \'foo\' ; x.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosures() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[ toUpperCase == it ]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatClosuresEmpty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter[   ] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresParam() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[ z | z.toUpperCase == z ]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatClosuresMultiLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter [");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val z = it");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("z.toUpperCase == z");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter [");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val z = it z.toUpperCase == z ");
    _builder_1.newLine();
    _builder_1.append("] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatClosuresParamMultiLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = newArrayList(\"A\", \"b\")");
    _builder.newLine();
    _builder.append("val y = x.filter[ z |");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val w = z");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("w.toUpperCase == w");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    _builder.append("y.join");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = newArrayList(\"A\", \"b\") val y = x.filter[ z |");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("val w = z w.toUpperCase == w");
    _builder_1.newLine();
    _builder_1.append("] y.join");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1SL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true) println(\"foo\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)println(\"foo\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1ML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1MLSemicolon1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\");");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\");");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf1MLSemicolon2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\");");
    _builder.newLine();
    _builder.append("println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\");");
    _builder_1.newLine();
    _builder_1.append("println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIf2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatIfElse1SL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true) println(\"foo\") else println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)println(\"foo\")else  println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIfElse1ML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("else");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("if(true)");
    _builder_1.newLine();
    _builder_1.append("println(\"foo\")");
    _builder_1.newLine();
    _builder_1.append("else");
    _builder_1.newLine();
    _builder_1.append("println(\"bar\")");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatIfElse2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if(true) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatFor1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(i:1..2)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatFor2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for(i:1..2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(i)");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void formatSwitchSL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' { case \'x\': println(\'x\') case \'y\': println(\'y\') }");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  {   case \'x\':   println(\'x\')   case   \'y\':    println(\'y\')    }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchCaseSL() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': println(\'y\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  {   ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \'x\':   println(\'x\')   case   \'y\':    println(\'y\')");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\':");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\':");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'y\')");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  {   ");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("case \'x\':   ");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("println(\'x\')   case   \'y\':    println(\'y\')");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatSwitchMLBlock() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("switch \'x\' {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'x\': {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'x\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("case \'y\': {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\'y\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("switch \'x\'  { case \'x\': { println(\'x\') }  case   \'y\':  {  println(\'y\') } }");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatFeatureCall1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
  
  @Test
  public void formatFeatureCall2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120),");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val ML2 = newArrayList(newArrayList(1, 2, 3, 4), newArrayList(5, 6, 7, 8, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120), newArrayList(9, 10, 11, 12), newArrayList(13, 14, 15, 16))");
    _builder_1.newLine();
    this.assertFormattedExpression(_builder.toString(), _builder_1);
  }
}
