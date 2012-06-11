package bootstrap;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xdoc.xdoc.Anchor;
import org.eclipse.xtext.xdoc.xdoc.Code;
import org.eclipse.xtext.xdoc.xdoc.CodeBlock;
import org.eclipse.xtext.xdoc.xdoc.CodeRef;
import org.eclipse.xtext.xdoc.xdoc.Emphasize;
import org.eclipse.xtext.xdoc.xdoc.Identifiable;
import org.eclipse.xtext.xdoc.xdoc.ImageRef;
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
import org.eclipse.xtext.xdoc.xdoc.XdocPackage.Literals;

@SuppressWarnings("all")
public class HtmlExtensions {
  private final static String JAVADOC_ROOT = "http://xtend-lang.org/api/2.3.0/";
  
  private Map<Identifiable,String> artificialHrefs = new Function0<Map<Identifiable,String>>() {
    public Map<Identifiable,String> apply() {
      HashMap<Identifiable,String> _newHashMap = CollectionLiterals.<Identifiable, String>newHashMap();
      return _newHashMap;
    }
  }.apply();
  
  public String href(final Identifiable it) {
    String _xifexpression = null;
    String _name = it.getName();
    boolean _notEquals = (!Objects.equal(_name, null));
    if (_notEquals) {
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
          String _plus = (_name_2 + "_");
          int _size = this.artificialHrefs.size();
          final String newHref = (_plus + Integer.valueOf(_size));
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
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isParagraph = this.isParagraph(it);
      if (_isParagraph) {
        _builder.append("<p>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    EList<EObject> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    _builder.append(_html, "	");
    _builder.newLineIfNotEmpty();
    {
      boolean _isParagraph_1 = this.isParagraph(it);
      if (_isParagraph_1) {
        _builder.append("</p>");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private boolean isParagraph(final TextOrMarkup it) {
    boolean _switchResult = false;
    EStructuralFeature _eContainingFeature = it.eContainingFeature();
    final EStructuralFeature eContainingFeature = _eContainingFeature;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(eContainingFeature,Literals.ABSTRACT_SECTION__CONTENTS)) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
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
    StringConcatenation _builder = new StringConcatenation();
    String _text = it.getText();
    String _quote = this.quote(_text);
    _builder.append(_quote, "");
    _builder.newLineIfNotEmpty();
    return _builder;
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
    _builder.append("\"/>");
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
  
  protected CharSequence _toHtml(final ImageRef it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div class=\"thumbnail\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<img src=\"");
    String _path = it.getPath();
    _builder.append(_path, "	");
    _builder.append("\" alt=\"");
    String _name = it.getName();
    _builder.append(_name, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Todo it) {
    String _text = it.getText();
    String _plus = ("TODO: " + _text);
    InputOutput.<String>println(_plus);
    return "";
  }
  
  protected CharSequence _toHtml(final CodeRef it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a href=\"");
    _builder.append(HtmlExtensions.JAVADOC_ROOT, "");
    JvmDeclaredType _element = it.getElement();
    String _qualifiedName = _element.getQualifiedName();
    String _replace = _qualifiedName.replace(".", "/");
    _builder.append(_replace, "");
    _builder.append(".html\">");
    {
      TextOrMarkup _altText = it.getAltText();
      boolean _notEquals = (!Objects.equal(_altText, null));
      if (_notEquals) {
        TextOrMarkup _altText_1 = it.getAltText();
        _builder.append(_altText_1, "");
      } else {
        _builder.append("<abbr title=\"");
        JvmDeclaredType _element_1 = it.getElement();
        String _qualifiedName_1 = _element_1.getQualifiedName();
        _builder.append(_qualifiedName_1, "");
        _builder.append("\">");
        JvmDeclaredType _element_2 = it.getElement();
        String _simpleName = _element_2.getSimpleName();
        String _trim = _simpleName.trim();
        _builder.append(_trim, "");
        _builder.append("</abbr>");
      }
    }
    _builder.append("</a>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Code it) {
    String _contents = it.getContents();
    String _quote = this.quote(_contents);
    return _quote;
  }
  
  protected CharSequence _toHtml(final CodeBlock it) {
    CharSequence _xblockexpression = null;
    {
      EList<EObject> _contents = it.getContents();
      CharSequence _html = this.toHtml(_contents);
      final String code = _html.toString();
      CharSequence _xifexpression = null;
      boolean _and = false;
      boolean _contains = code.contains("\n");
      if (!_contains) {
        _and = false;
      } else {
        boolean _contains_1 = code.contains("\r");
        boolean _not = (!_contains_1);
        _and = (_contains && _not);
      }
      if (_and) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<pre class=\"prettyprint lang-");
        LangDef _language = it.getLanguage();
        String _name = _language==null?(String)null:_language.getName();
        String _lowerCase = _name==null?(String)null:_name.toLowerCase();
        String _elvis = ObjectExtensions.<String>operator_elvis(_lowerCase, "xtend");
        _builder.append(_elvis, "");
        _builder.append(" linenums\">");
        String _markCodeBegin = this.markCodeBegin();
        _builder.append(_markCodeBegin, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        String _trimCode = this.trimCode(code);
        _builder.append(_trimCode, "			");
        String _markCodeEnd = this.markCodeEnd();
        _builder.append(_markCodeEnd, "			");
        _builder.append("</pre>");
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<code class=\"prettyprint lang-");
        LangDef _language_1 = it.getLanguage();
        String _name_1 = _language_1==null?(String)null:_language_1.getName();
        String _lowerCase_1 = _name_1==null?(String)null:_name_1.toLowerCase();
        String _elvis_1 = ObjectExtensions.<String>operator_elvis(_lowerCase_1, "xtend");
        _builder_1.append(_elvis_1, "");
        _builder_1.append("\">");
        String _trimCode_1 = this.trimCode(code);
        _builder_1.append(_trimCode_1, "");
        _builder_1.append("</code>");
        _xifexpression = _builder_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
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
    _builder.append("<table class=\"table table-bordered table-condensed\">");
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
      String _plus = ("Missing toHtml for " + _name);
      InputOutput.<String>println(_plus);
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
  
  protected String trimCode(final String it) {
    String _xblockexpression = null;
    {
      int start = 0;
      boolean _and = false;
      int _length = it.length();
      int _minus = (_length - 1);
      boolean _lessThan = (start < _minus);
      if (!_lessThan) {
        _and = false;
      } else {
        boolean _or = false;
        int _plus = (start + 1);
        String _substring = it.substring(start, _plus);
        boolean _equals = Objects.equal(_substring, " ");
        if (_equals) {
          _or = true;
        } else {
          int _plus_1 = (start + 1);
          String _substring_1 = it.substring(start, _plus_1);
          boolean _equals_1 = Objects.equal(_substring_1, "\t");
          _or = (_equals || _equals_1);
        }
        _and = (_lessThan && _or);
      }
      boolean _while = _and;
      while (_while) {
        int _plus_2 = (start + 1);
        start = _plus_2;
        boolean _and_1 = false;
        int _length_1 = it.length();
        int _minus_1 = (_length_1 - 1);
        boolean _lessThan_1 = (start < _minus_1);
        if (!_lessThan_1) {
          _and_1 = false;
        } else {
          boolean _or_1 = false;
          int _plus_3 = (start + 1);
          String _substring_2 = it.substring(start, _plus_3);
          boolean _equals_2 = Objects.equal(_substring_2, " ");
          if (_equals_2) {
            _or_1 = true;
          } else {
            int _plus_4 = (start + 1);
            String _substring_3 = it.substring(start, _plus_4);
            boolean _equals_3 = Objects.equal(_substring_3, "\t");
            _or_1 = (_equals_2 || _equals_3);
          }
          _and_1 = (_lessThan_1 && _or_1);
        }
        _while = _and_1;
      }
      int _plus_2 = (start + 1);
      String _substring_2 = it.substring(start, _plus_2);
      boolean _equals_2 = Objects.equal(_substring_2, "\n");
      if (_equals_2) {
        int _plus_3 = (start + 1);
        start = _plus_3;
      }
      int _length_1 = it.length();
      int end = (_length_1 - 1);
      boolean _and_1 = false;
      boolean _greaterThan = (end > 0);
      if (!_greaterThan) {
        _and_1 = false;
      } else {
        char _charAt = it.charAt(end);
        boolean _isWhitespace = Character.isWhitespace(_charAt);
        _and_1 = (_greaterThan && _isWhitespace);
      }
      boolean _while_1 = _and_1;
      while (_while_1) {
        int _minus_1 = (end - 1);
        end = _minus_1;
        boolean _and_2 = false;
        boolean _greaterThan_1 = (end > 0);
        if (!_greaterThan_1) {
          _and_2 = false;
        } else {
          char _charAt_1 = it.charAt(end);
          boolean _isWhitespace_1 = Character.isWhitespace(_charAt_1);
          _and_2 = (_greaterThan_1 && _isWhitespace_1);
        }
        _while_1 = _and_2;
      }
      int _plus_4 = (end + 1);
      String _substring_3 = it.substring(start, _plus_4);
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
  
  public CharSequence toHtml(final Object it) {
    if (it instanceof Anchor) {
      return _toHtml((Anchor)it);
    } else if (it instanceof CodeBlock) {
      return _toHtml((CodeBlock)it);
    } else if (it instanceof CodeRef) {
      return _toHtml((CodeRef)it);
    } else if (it instanceof Emphasize) {
      return _toHtml((Emphasize)it);
    } else if (it instanceof ImageRef) {
      return _toHtml((ImageRef)it);
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
