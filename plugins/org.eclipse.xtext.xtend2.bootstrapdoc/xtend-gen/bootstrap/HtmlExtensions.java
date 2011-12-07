package bootstrap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xdoc.xdoc.Anchor;
import org.eclipse.xtext.xdoc.xdoc.Emphasize;
import org.eclipse.xtext.xdoc.xdoc.Identifiable;
import org.eclipse.xtext.xdoc.xdoc.Item;
import org.eclipse.xtext.xdoc.xdoc.OrderedList;
import org.eclipse.xtext.xdoc.xdoc.Ref;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;
import org.eclipse.xtext.xdoc.xdoc.TextPart;

@SuppressWarnings("all")
public class HtmlExtensions {
  protected CharSequence _toHtml(final TextOrMarkup it) {
    EList<EObject> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    return _html;
  }
  
  protected CharSequence _toHtml(final List<TextOrMarkup> it) {
    final Function1<TextOrMarkup,CharSequence> _function = new Function1<TextOrMarkup,CharSequence>() {
        public CharSequence apply(final TextOrMarkup it) {
          CharSequence _html = HtmlExtensions.this.toHtml(it);
          return _html;
        }
      };
    List<CharSequence> _map = ListExtensions.<TextOrMarkup, CharSequence>map(it, _function);
    String _join = IterableExtensions.join(_map);
    return _join;
  }
  
  protected CharSequence _toHtml(final TextPart it) {
    String _text = it.getText();
    return _text;
  }
  
  protected CharSequence _toHtml(final Emphasize it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<strong>");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    _builder.append(_html, "");
    _builder.append("</strong>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Anchor it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a name=\"");
    String _name = it.getName();
    _builder.append(_name, "");
    _builder.append("\"/>\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Ref it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a href=\"");
    Identifiable _ref = it.getRef();
    String _href = this.href(_ref);
    _builder.append(_href, "");
    _builder.append("\">");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents);
    _builder.append(_html, "");
    _builder.append("</a>");
    _builder.newLineIfNotEmpty();
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
  
  /**
   * Emphasize |
   * Anchor |
   * Ref |
   * OrderedList |
   * UnorderedList |
   * CodeBlock |
   * CodeRef |
   * Link |
   * ImageRef |
   * Table |
   * Todo;
   */
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
          int _size = this.artificialHrefs.size();
          String _operator_plus = StringExtensions.operator_plus(_name_2, Integer.valueOf(_size));
          final String newHref = _operator_plus;
          this.artificialHrefs.put(it, newHref);
          _xblockexpression = (newHref);
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public CharSequence toHtml(final Object it) {
    if (it instanceof Anchor) {
      return _toHtml((Anchor)it);
    } else if (it instanceof Emphasize) {
      return _toHtml((Emphasize)it);
    } else if (it instanceof OrderedList) {
      return _toHtml((OrderedList)it);
    } else if (it instanceof Ref) {
      return _toHtml((Ref)it);
    } else if (it instanceof List) {
      return _toHtml((List<TextOrMarkup>)it);
    } else if (it instanceof Item) {
      return _toHtml((Item)it);
    } else if (it instanceof TextOrMarkup) {
      return _toHtml((TextOrMarkup)it);
    } else if (it instanceof TextPart) {
      return _toHtml((TextPart)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
