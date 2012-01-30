package bootstrap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.BooleanExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xdoc.xdoc.Anchor;
import org.eclipse.xtext.xdoc.xdoc.Code;
import org.eclipse.xtext.xdoc.xdoc.CodeBlock;
import org.eclipse.xtext.xdoc.xdoc.CodeRef;
import org.eclipse.xtext.xdoc.xdoc.Emphasize;
import org.eclipse.xtext.xdoc.xdoc.Identifiable;
import org.eclipse.xtext.xdoc.xdoc.Item;
import org.eclipse.xtext.xdoc.xdoc.LangDef;
import org.eclipse.xtext.xdoc.xdoc.Link;
import org.eclipse.xtext.xdoc.xdoc.OrderedList;
import org.eclipse.xtext.xdoc.xdoc.Ref;
import org.eclipse.xtext.xdoc.xdoc.Table;
import org.eclipse.xtext.xdoc.xdoc.TableData;
import org.eclipse.xtext.xdoc.xdoc.TableRow;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;
import org.eclipse.xtext.xdoc.xdoc.TextPart;
import org.eclipse.xtext.xdoc.xdoc.Todo;
import org.eclipse.xtext.xdoc.xdoc.UnorderedList;

@SuppressWarnings("all")
public class HtmlExtensions {
  private Map<Identifiable,String> artificialHrefs = new Function0<Map<Identifiable,String>>() {
    public Map<Identifiable,String> apply() {
      HashMap<Identifiable,String> _newHashMap = CollectionLiterals.<Identifiable, String>newHashMap();
      return _newHashMap;
    }
  }.apply();
  
  public String href(final Identifiable it) {
    String _xifexpression = null;
    String _name = it.getName();
    boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_name, null);
    if (_operator_notEquals) {
      String _name_1 = it.getName();
      _xifexpression = _name_1;
    } else {
      String _xifexpression_1 = null;
      boolean _containsKey = this.artificialHrefs.containsKey(it);
      if (_containsKey) {
        String _get = this.artificialHrefs.get(it);
        _xifexpression_1 = _get;
      } else {
        String _xblockexpression = null;
        {
          EClass _eClass = it.eClass();
          String _name_2 = _eClass.getName();
          String _operator_plus = StringExtensions.operator_plus(_name_2, "_");
          int _size = this.artificialHrefs.size();
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, Integer.valueOf(_size));
          final String newHref = _operator_plus_1;
          this.artificialHrefs.put(it, newHref);
          _xblockexpression = (newHref);
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected CharSequence _toHtml(final TextOrMarkup it) {
    EList<EObject> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    return _html;
  }
  
  protected CharSequence _toHtml(final List<EObject> it) {
    final Function1<EObject,CharSequence> _function = new Function1<EObject,CharSequence>() {
        public CharSequence apply(final EObject it) {
          CharSequence _html = HtmlExtensions.this.toHtml(it);
          return _html;
        }
      };
    List<CharSequence> _map = ListExtensions.<EObject, CharSequence>map(it, _function);
    String _join = IterableExtensions.join(_map);
    return _join;
  }
  
  protected CharSequence _toHtml(final TextPart it) {
    String _text = it.getText();
    String _quote = this.quote(_text);
    return _quote;
  }
  
  protected CharSequence _toHtml(final Emphasize it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<strong>");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    _builder.append(_html, "");
    _builder.append("</strong>");
    return _builder;
  }
  
  protected CharSequence _toHtml(final Anchor it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a name=\"");
    String _name = it.getName();
    String _quote = this.quote(_name);
    _builder.append(_quote, "");
    _builder.append("\"/>\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Ref it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a href=\"#");
    Identifiable _ref = it.getRef();
    String _href = this.href(_ref);
    _builder.append(_href, "");
    _builder.append("\">");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    _builder.append(_html, "");
    _builder.append("</a>");
    return _builder;
  }
  
  protected CharSequence _toHtml(final OrderedList it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ol>");
    _builder.newLine();
    {
      EList<Item> _items = it.getItems();
      for(final Item item : _items) {
        _builder.append("\t");
        CharSequence _html = this.toHtml(item);
        _builder.append(_html, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</ol>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Item it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<li>");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    _builder.append(_html, "");
    _builder.append("</li>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final UnorderedList it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ul>");
    _builder.newLine();
    {
      EList<Item> _items = it.getItems();
      for(final Item item : _items) {
        _builder.append("\t");
        CharSequence _html = this.toHtml(item);
        _builder.append(_html, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</ul>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Todo it) {
    String _xblockexpression = null;
    {
      String _text = it.getText();
      String _operator_plus = StringExtensions.operator_plus("TODO: ", _text);
      InputOutput.<String>println(_operator_plus);
      _xblockexpression = ("");
    }
    return _xblockexpression;
  }
  
  protected CharSequence _toHtml(final CodeRef it) {
    CharSequence _xblockexpression = null;
    {
      JvmDeclaredType _element = it.getElement();
      String _identifier = _element.getIdentifier();
      String _operator_plus = StringExtensions.operator_plus("TODO CodeRef to: ", _identifier);
      InputOutput.<String>println(_operator_plus);
      CharSequence _xifexpression = null;
      TextOrMarkup _altText = it.getAltText();
      boolean _operator_notEquals = ObjectExtensions.operator_notEquals(_altText, null);
      if (_operator_notEquals) {
        TextOrMarkup _altText_1 = it.getAltText();
        CharSequence _html = this.toHtml(_altText_1);
        _xifexpression = _html;
      } else {
        JvmDeclaredType _element_1 = it.getElement();
        String _identifier_1 = _element_1.getIdentifier();
        String _operator_plus_1 = StringExtensions.operator_plus("<code class=\"prettyprint lang-java\">", _identifier_1);
        String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, "</code>");
        _xifexpression = _operator_plus_2;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _toHtml(final Code it) {
    String _contents = it.getContents();
    String _quote = this.quote(_contents);
    return _quote;
  }
  
  protected CharSequence _toHtml(final CodeBlock it) {
    CharSequence _internalToHtml = this.internalToHtml(it, false);
    return _internalToHtml;
  }
  
  protected CharSequence _toHtml(final Link it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a href=\"");
    String _url = it.getUrl();
    _builder.append(_url, "");
    _builder.append("\">");
    String _text = it.getText();
    _builder.append(_text, "");
    _builder.append("</a>");
    return _builder;
  }
  
  protected CharSequence _toHtml(final Table it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<table class=\"bordered-table zebra-striped\">");
    _builder.newLine();
    {
      EList<TableRow> _rows = it.getRows();
      for(final TableRow row : _rows) {
        CharSequence _html = this.toHtml(row);
        _builder.append(_html, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</table>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toHtml(final TableRow it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<tr>");
    EList<TableData> _data = it.getData();
    CharSequence _html = this.toHtml(_data);
    _builder.append(_html, "");
    _builder.append("</tr>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final TableData it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<td>");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    _builder.append(_html, "");
    _builder.append("</td>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final EObject it) {
    String _xblockexpression = null;
    {
      EClass _eClass = it.eClass();
      String _name = _eClass.getName();
      String _operator_plus = StringExtensions.operator_plus("Missing toHtml for ", _name);
      InputOutput.<String>println(_operator_plus);
      _xblockexpression = ("");
    }
    return _xblockexpression;
  }
  
  public String markCodeBegin() {
    return "###xdoc code begin###";
  }
  
  public String markCodeEnd() {
    return "###xdoc code end###";
  }
  
  protected CharSequence internalToHtml(final CodeBlock it, final boolean isParagraph) {
    CharSequence _xblockexpression = null;
    {
      EList<EObject> _contents = it.getContents();
      CharSequence _html = this.toHtml(_contents);
      String _string = _html.toString();
      final String code = _string;
      String _xifexpression = null;
      LangDef _language = it.getLanguage();
      String _name = _language==null?(String)null:_language.getName();
      boolean _operator_equals = ObjectExtensions.operator_equals(_name, null);
      if (_operator_equals) {
        _xifexpression = "xtend";
      } else {
        LangDef _language_1 = it.getLanguage();
        String _name_1 = _language_1.getName();
        _xifexpression = _name_1;
      }
      final String languageName = _xifexpression;
      CharSequence _xifexpression_1 = null;
      boolean _operator_or = false;
      boolean _contains = code.contains("\n");
      if (_contains) {
        _operator_or = true;
      } else {
        boolean _contains_1 = code.contains("\r");
        _operator_or = BooleanExtensions.operator_or(_contains, _contains_1);
      }
      if (_operator_or) {
        StringConcatenation _builder = new StringConcatenation();
        {
          if (isParagraph) {
            _builder.append("</p>");
          }
        }
        _builder.append("<pre class=\"prettyprint lang-");
        String _lowerCase = languageName.toLowerCase();
        _builder.append(_lowerCase, "");
        _builder.append("\">");
        String _markCodeBegin = this.markCodeBegin();
        _builder.append(_markCodeBegin, "");
        _builder.newLineIfNotEmpty();
        String _trimCode = this.trimCode(code);
        _builder.append(_trimCode, "");
        String _markCodeEnd = this.markCodeEnd();
        _builder.append(_markCodeEnd, "");
        _builder.append("</pre>");
        {
          if (isParagraph) {
            _builder.append("<p>");
          }
        }
        _builder.newLineIfNotEmpty();
        _xifexpression_1 = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<code class=\"prettyprint lang-");
        String _lowerCase_1 = languageName.toLowerCase();
        _builder_1.append(_lowerCase_1, "");
        _builder_1.append("\">");
        String _trimCode_1 = this.trimCode(code);
        _builder_1.append(_trimCode_1, "");
        _builder_1.append("</code>");
        _xifexpression_1 = _builder_1;
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
  
  protected String trimCode(final String it) {
    String _xblockexpression = null;
    {
      int start = 0;
      boolean _operator_and = false;
      int _length = it.length();
      int _operator_minus = IntegerExtensions.operator_minus(_length, 1);
      boolean _operator_lessThan = IntegerExtensions.operator_lessThan(start, _operator_minus);
      if (!_operator_lessThan) {
        _operator_and = false;
      } else {
        boolean _operator_or = false;
        String _substring = it.substring(start, 1);
        boolean _operator_equals = ObjectExtensions.operator_equals(_substring, " ");
        if (_operator_equals) {
          _operator_or = true;
        } else {
          String _substring_1 = it.substring(start, 1);
          boolean _operator_equals_1 = ObjectExtensions.operator_equals(_substring_1, "\t");
          _operator_or = BooleanExtensions.operator_or(_operator_equals, _operator_equals_1);
        }
        _operator_and = BooleanExtensions.operator_and(_operator_lessThan, _operator_or);
      }
      boolean _while = _operator_and;
      while (_while) {
        int _operator_plus = IntegerExtensions.operator_plus(start, 1);
        start = _operator_plus;
        boolean _operator_and_1 = false;
        int _length_1 = it.length();
        int _operator_minus_1 = IntegerExtensions.operator_minus(_length_1, 1);
        boolean _operator_lessThan_1 = IntegerExtensions.operator_lessThan(start, _operator_minus_1);
        if (!_operator_lessThan_1) {
          _operator_and_1 = false;
        } else {
          boolean _operator_or_1 = false;
          String _substring_2 = it.substring(start, 1);
          boolean _operator_equals_2 = ObjectExtensions.operator_equals(_substring_2, " ");
          if (_operator_equals_2) {
            _operator_or_1 = true;
          } else {
            String _substring_3 = it.substring(start, 1);
            boolean _operator_equals_3 = ObjectExtensions.operator_equals(_substring_3, "\t");
            _operator_or_1 = BooleanExtensions.operator_or(_operator_equals_2, _operator_equals_3);
          }
          _operator_and_1 = BooleanExtensions.operator_and(_operator_lessThan_1, _operator_or_1);
        }
        _while = _operator_and_1;
      }
      String _substring_2 = it.substring(start, 1);
      boolean _operator_equals_2 = ObjectExtensions.operator_equals(_substring_2, "\n");
      if (_operator_equals_2) {
        int _operator_plus = IntegerExtensions.operator_plus(start, 1);
        start = _operator_plus;
      }
      int _length_1 = it.length();
      int _operator_minus_1 = IntegerExtensions.operator_minus(_length_1, 1);
      int end = _operator_minus_1;
      boolean _operator_and_1 = false;
      boolean _operator_greaterThan = IntegerExtensions.operator_greaterThan(end, 0);
      if (!_operator_greaterThan) {
        _operator_and_1 = false;
      } else {
        char _charAt = it.charAt(end);
        boolean _isWhitespace = Character.isWhitespace(_charAt);
        _operator_and_1 = BooleanExtensions.operator_and(_operator_greaterThan, _isWhitespace);
      }
      boolean _while_1 = _operator_and_1;
      while (_while_1) {
        int _operator_minus_2 = IntegerExtensions.operator_minus(end, 1);
        end = _operator_minus_2;
        boolean _operator_and_2 = false;
        boolean _operator_greaterThan_1 = IntegerExtensions.operator_greaterThan(end, 0);
        if (!_operator_greaterThan_1) {
          _operator_and_2 = false;
        } else {
          char _charAt_1 = it.charAt(end);
          boolean _isWhitespace_1 = Character.isWhitespace(_charAt_1);
          _operator_and_2 = BooleanExtensions.operator_and(_operator_greaterThan_1, _isWhitespace_1);
        }
        _while_1 = _operator_and_2;
      }
      int _operator_plus_1 = IntegerExtensions.operator_plus(end, 1);
      String _substring_3 = it.substring(start, _operator_plus_1);
      _xblockexpression = (_substring_3);
    }
    return _xblockexpression;
  }
  
  protected String quote(final CharSequence it) {
    String _string = it.toString();
    String _replace = _string.replace("<", "&lt;");
    String _replace_1 = _replace.replace(">", "&gt;");
    String _replace_2 = _replace_1.replace("\u00AB", "&laquo;");
    String _replace_3 = _replace_2.replace("\u00BB", "&raquo;");
    String _replace_4 = _replace_3.replace("\\[", "[");
    String _replace_5 = _replace_4.replace("\\]", "]");
    String _replace_6 = _replace_5.replace("\'", "&apos;");
    String _replace_7 = _replace_6.replace("\u00B4", "&apos;");
    String _replace_8 = _replace_7.replace("`", "&apos;");
    return _replace_8;
  }
  
  public CharSequence toHtmlParagraph(final List<? extends EObject> it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<p>");
    _builder.newLine();
    CharSequence _internalToHtmlParagraph = this.internalToHtmlParagraph(it);
    _builder.append(_internalToHtmlParagraph, "");
    _builder.newLineIfNotEmpty();
    _builder.append("</p>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence internalToHtmlParagraph(final Object it) {
    CharSequence _switchResult = null;
    boolean matched = false;
    if (!matched) {
      if (it instanceof TextOrMarkup) {
        final TextOrMarkup _textOrMarkup = (TextOrMarkup)it;
        matched=true;
        EList<EObject> _contents = _textOrMarkup.getContents();
        CharSequence _internalToHtmlParagraph = this.internalToHtmlParagraph(_contents);
        _switchResult = _internalToHtmlParagraph;
      }
    }
    if (!matched) {
      if (it instanceof List) {
        final List<EObject> _list = (List<EObject>)it;
        matched=true;
        final Function1<EObject,CharSequence> _function = new Function1<EObject,CharSequence>() {
            public CharSequence apply(final EObject it) {
              CharSequence _internalToHtmlParagraph = HtmlExtensions.this.internalToHtmlParagraph(it);
              return _internalToHtmlParagraph;
            }
          };
        List<CharSequence> _map = ListExtensions.<EObject, CharSequence>map(_list, _function);
        String _join = IterableExtensions.join(_map);
        _switchResult = _join;
      }
    }
    if (!matched) {
      if (it instanceof TextPart) {
        final TextPart _textPart = (TextPart)it;
        matched=true;
        String _xblockexpression = null;
        {
          String _text = _textPart.getText();
          String _quote = this.quote(_text);
          String[] _split = _quote.split("^\\s*$");
          final String[] paragraphs = _split;
          final String[] _typeConverted_paragraphs = (String[])paragraphs;
          final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
              public Boolean apply(final String it) {
                boolean _isEmpty = it.isEmpty();
                boolean _operator_not = BooleanExtensions.operator_not(_isEmpty);
                return Boolean.valueOf(_operator_not);
              }
            };
          Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_typeConverted_paragraphs)), _function);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("</p>");
          _builder.newLine();
          _builder.append("<p>");
          _builder.newLine();
          String _join = IterableExtensions.join(_filter, _builder);
          _xblockexpression = (_join);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!matched) {
      if (it instanceof CodeBlock) {
        final CodeBlock _codeBlock = (CodeBlock)it;
        matched=true;
        CharSequence _internalToHtml = this.internalToHtml(_codeBlock, true);
        _switchResult = _internalToHtml;
      }
    }
    if (!matched) {
      CharSequence _html = this.toHtml(it);
      _switchResult = _html;
    }
    return _switchResult;
  }
  
  public CharSequence toHtml(final Object it) {
    if (it instanceof Anchor) {
      return _toHtml((Anchor)it);
    } else if (it instanceof CodeBlock) {
      return _toHtml((CodeBlock)it);
    } else if (it instanceof CodeRef) {
      return _toHtml((CodeRef)it);
    } else if (it instanceof Emphasize) {
      return _toHtml((Emphasize)it);
    } else if (it instanceof Link) {
      return _toHtml((Link)it);
    } else if (it instanceof OrderedList) {
      return _toHtml((OrderedList)it);
    } else if (it instanceof Ref) {
      return _toHtml((Ref)it);
    } else if (it instanceof Table) {
      return _toHtml((Table)it);
    } else if (it instanceof Todo) {
      return _toHtml((Todo)it);
    } else if (it instanceof UnorderedList) {
      return _toHtml((UnorderedList)it);
    } else if (it instanceof List) {
      return _toHtml((List<EObject>)it);
    } else if (it instanceof Code) {
      return _toHtml((Code)it);
    } else if (it instanceof Item) {
      return _toHtml((Item)it);
    } else if (it instanceof TableData) {
      return _toHtml((TableData)it);
    } else if (it instanceof TableRow) {
      return _toHtml((TableRow)it);
    } else if (it instanceof TextOrMarkup) {
      return _toHtml((TextOrMarkup)it);
    } else if (it instanceof TextPart) {
      return _toHtml((TextPart)it);
    } else if (it instanceof EObject) {
      return _toHtml((EObject)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
