package bootstrap;

import bootstrap.ArtificialIds;
import bootstrap.CodeRefs;
import bootstrap.ImageDimension;
import bootstrap.ImageExtensions;
import bootstrap.ParagraphState;
import bootstrap.TargetPaths;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xdoc.xdoc.Anchor;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.ChapterRef;
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
import org.eclipse.xtext.xdoc.xdoc.Section;
import org.eclipse.xtext.xdoc.xdoc.Section2;
import org.eclipse.xtext.xdoc.xdoc.Section2Ref;
import org.eclipse.xtext.xdoc.xdoc.SectionRef;
import org.eclipse.xtext.xdoc.xdoc.Table;
import org.eclipse.xtext.xdoc.xdoc.TableData;
import org.eclipse.xtext.xdoc.xdoc.TableRow;
import org.eclipse.xtext.xdoc.xdoc.TextOrMarkup;
import org.eclipse.xtext.xdoc.xdoc.TextPart;
import org.eclipse.xtext.xdoc.xdoc.Todo;
import org.eclipse.xtext.xdoc.xdoc.UnorderedList;
import org.eclipse.xtext.xdoc.xdoc.XdocPackage;

@SuppressWarnings("all")
public class HtmlExtensions {
  @Inject
  @Extension
  private CodeRefs _codeRefs;
  
  @Inject
  @Extension
  private ImageExtensions _imageExtensions;
  
  @Inject
  @Extension
  private TargetPaths _targetPaths;
  
  public String href(final Identifiable it) {
    String _targetPath = this._targetPaths.getTargetPath(it);
    String _plus = (_targetPath + "#");
    String _hrefId = this.hrefId(it);
    String _plus_1 = (_plus + _hrefId);
    return _plus_1;
  }
  
  public String hrefId(final Identifiable id) {
    String _xblockexpression = null;
    {
      Identifiable _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (id instanceof ChapterRef) {
          _matched=true;
          Chapter _chapter = ((ChapterRef)id).getChapter();
          _switchResult = _chapter;
        }
      }
      if (!_matched) {
        if (id instanceof SectionRef) {
          _matched=true;
          Section _section = ((SectionRef)id).getSection();
          _switchResult = _section;
        }
      }
      if (!_matched) {
        if (id instanceof Section2Ref) {
          _matched=true;
          Section2 _section2 = ((Section2Ref)id).getSection2();
          _switchResult = _section2;
        }
      }
      if (!_matched) {
        _switchResult = id;
      }
      final Identifiable it = _switchResult;
      String _xifexpression = null;
      String _name = it.getName();
      boolean _notEquals = (!Objects.equal(_name, null));
      if (_notEquals) {
        String _name_1 = it.getName();
        _xifexpression = _name_1;
      } else {
        String _xifexpression_1 = null;
        Map<Identifiable,String> _artificialHrefIds = this.artificialHrefIds(it);
        boolean _containsKey = _artificialHrefIds.containsKey(it);
        if (_containsKey) {
          Map<Identifiable,String> _artificialHrefIds_1 = this.artificialHrefIds(it);
          String _get = _artificialHrefIds_1.get(it);
          _xifexpression_1 = _get;
        } else {
          String _xblockexpression_1 = null;
          {
            Map<Identifiable,String> _artificialHrefIds_2 = this.artificialHrefIds(it);
            int _size = _artificialHrefIds_2.size();
            final String newHref = ("_" + Integer.valueOf(_size));
            Map<Identifiable,String> _artificialHrefIds_3 = this.artificialHrefIds(it);
            _artificialHrefIds_3.put(it, newHref);
            _xblockexpression_1 = (newHref);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected Map<Identifiable,String> artificialHrefIds(final Identifiable id) {
    Resource _eResource = id.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final EList<Adapter> adapters = _resourceSet.eAdapters();
    ArtificialIds _elvis = null;
    Iterable<ArtificialIds> _filter = Iterables.<ArtificialIds>filter(adapters, ArtificialIds.class);
    ArtificialIds _head = IterableExtensions.<ArtificialIds>head(_filter);
    if (_head != null) {
      _elvis = _head;
    } else {
      ArtificialIds _artificialIds = new ArtificialIds();
      final Procedure1<ArtificialIds> _function = new Procedure1<ArtificialIds>() {
        public void apply(final ArtificialIds it) {
          adapters.add(it);
        }
      };
      ArtificialIds _doubleArrow = ObjectExtensions.<ArtificialIds>operator_doubleArrow(_artificialIds, _function);
      _elvis = ObjectExtensions.<ArtificialIds>operator_elvis(_head, _doubleArrow);
    }
    final ArtificialIds adapter = _elvis;
    return adapter.artificialHrefs;
  }
  
  protected CharSequence _toHtml(final TextOrMarkup it, final ParagraphState state) {
    String _xblockexpression = null;
    {
      ParagraphState _xifexpression = null;
      boolean _equals = Objects.equal(state, ParagraphState.NONE);
      if (_equals) {
        _xifexpression = ParagraphState.IN_PARAGRAPH;
      } else {
        _xifexpression = state;
      }
      final ParagraphState innerState = _xifexpression;
      EList<EObject> _contents = it.getContents();
      CharSequence _html = this.toHtml(_contents, innerState);
      String _string = _html.toString();
      final String contentsToHtml = _string.trim();
      String _xifexpression_1 = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(contentsToHtml);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        String _xifexpression_2 = null;
        boolean _equals_1 = Objects.equal(state, ParagraphState.NONE);
        if (_equals_1) {
          String _xblockexpression_1 = null;
          {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("<p>");
            _builder.newLine();
            _builder.append("\t");
            _builder.append(contentsToHtml, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("</p>");
            _builder.newLine();
            final String result = _builder.toString();
            _xblockexpression_1 = (result);
          }
          _xifexpression_2 = _xblockexpression_1;
        } else {
          _xifexpression_2 = contentsToHtml;
        }
        _xifexpression_1 = _xifexpression_2;
      } else {
        _xifexpression_1 = "";
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
  
  public CharSequence toHtmlText(final Object element) {
    CharSequence _html = this.toHtml(element, ParagraphState.IN_PARAGRAPH);
    return _html;
  }
  
  public CharSequence toHtmlParagraph(final Object element) {
    CharSequence _html = this.toHtml(element, ParagraphState.NONE);
    return _html;
  }
  
  protected CharSequence _toHtml(final List<EObject> it, final ParagraphState state) {
    final Function1<EObject,CharSequence> _function = new Function1<EObject,CharSequence>() {
      public CharSequence apply(final EObject it) {
        CharSequence _html = HtmlExtensions.this.toHtml(it, state);
        return _html;
      }
    };
    List<CharSequence> _map = ListExtensions.<EObject, CharSequence>map(it, _function);
    String _join = IterableExtensions.join(_map);
    return _join;
  }
  
  protected CharSequence _toHtml(final TextPart it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    String _text = it.getText();
    String _quote = this.quote(_text);
    _builder.append(_quote, "");
    return _builder;
  }
  
  protected CharSequence _toHtml(final Emphasize it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<strong>");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents, state);
    _builder.append(_html, "");
    _builder.append("</strong>");
    return _builder;
  }
  
  protected CharSequence _toHtml(final Anchor it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a name=\"");
    String _name = it.getName();
    String _quote = this.quote(_name);
    _builder.append(_quote, "");
    _builder.append("\"></a>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final Ref it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a href=\"");
    Identifiable _ref = it.getRef();
    String _href = this.href(_ref);
    _builder.append(_href, "");
    _builder.append("\">");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents, state);
    _builder.append(_html, "");
    _builder.append("</a>");
    return _builder;
  }
  
  protected CharSequence _toHtml(final OrderedList it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ol>");
    _builder.newLine();
    {
      EList<Item> _items = it.getItems();
      for(final Item item : _items) {
        _builder.append("\t");
        CharSequence _html = this.toHtml(item, state);
        _builder.append(_html, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</ol>");
    _builder.newLine();
    CharSequence _insert = this.insert(_builder, state);
    return _insert;
  }
  
  protected CharSequence _toHtml(final Item it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<li>");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents, ParagraphState.IN_LISTITEM);
    _builder.append(_html, "");
    _builder.append("</li>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final UnorderedList it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ul>");
    _builder.newLine();
    {
      EList<Item> _items = it.getItems();
      for(final Item item : _items) {
        _builder.append("\t");
        CharSequence _html = this.toHtml(item, state);
        _builder.append(_html, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</ul>");
    _builder.newLine();
    CharSequence _insert = this.insert(_builder, state);
    return _insert;
  }
  
  protected CharSequence _toHtml(final ImageRef it, final ParagraphState state) {
    CharSequence _xblockexpression = null;
    {
      final ImageDimension dimension = this._imageExtensions.getDimension(it);
      String _caption = it.getCaption();
      String _trim = null;
      if (_caption!=null) {
        _trim=_caption.trim();
      }
      final String caption = _trim;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"thumbnail\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<img src=\"");
      String _path = it.getPath();
      _builder.append(_path, "\t");
      _builder.append("\" alt=\"");
      _builder.append(caption, "\t");
      _builder.append("\" ");
      {
        boolean _notEquals = (!Objects.equal(dimension, null));
        if (_notEquals) {
          _builder.append("width=\"");
          int _width = dimension.getWidth();
          _builder.append(_width, "\t");
          _builder.append("\" height=\"");
          int _height = dimension.getHeight();
          _builder.append(_height, "\t");
          _builder.append("\"");
        }
      }
      _builder.append(">");
      _builder.newLineIfNotEmpty();
      _builder.append("</div>");
      _builder.newLine();
      CharSequence _insert = this.insert(_builder, state);
      _xblockexpression = (_insert);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _toHtml(final Todo it, final ParagraphState state) {
    String _text = it.getText();
    String _plus = ("TODO: " + _text);
    InputOutput.<String>println(_plus);
    return "";
  }
  
  protected CharSequence _toHtml(final CodeRef it, final ParagraphState state) {
    CharSequence _xblockexpression = null;
    {
      String _sourceCodeURI = null;
      JvmDeclaredType _element = it.getElement();
      if (_element!=null) {
        _sourceCodeURI=this._codeRefs.getSourceCodeURI(_element);
      }
      final String sourceCodeURI = _sourceCodeURI;
      String _javaDocURI = null;
      JvmDeclaredType _element_1 = it.getElement();
      if (_element_1!=null) {
        _javaDocURI=this._codeRefs.getJavaDocURI(_element_1);
      }
      final String javaDocURI = _javaDocURI;
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _notEquals = (!Objects.equal(javaDocURI, null));
        if (_notEquals) {
          _builder.append("<a href=\"");
          _builder.append(javaDocURI, "");
          _builder.append("\">");
        }
      }
      {
        TextOrMarkup _altText = it.getAltText();
        boolean _notEquals_1 = (!Objects.equal(_altText, null));
        if (_notEquals_1) {
          TextOrMarkup _altText_1 = it.getAltText();
          CharSequence _html = this.toHtml(_altText_1, state);
          _builder.append(_html, "");
        } else {
          _builder.append("<abbr title=\"");
          JvmDeclaredType _element_2 = it.getElement();
          String _identifier = null;
          if (_element_2!=null) {
            _identifier=_element_2.getIdentifier();
          }
          _builder.append(_identifier, "");
          _builder.append("\">");
          {
            JvmDeclaredType _element_3 = it.getElement();
            if ((_element_3 instanceof JvmAnnotationType)) {
              _builder.append("@");
            }
          }
          JvmDeclaredType _element_4 = it.getElement();
          String _simpleName = null;
          if (_element_4!=null) {
            _simpleName=_element_4.getSimpleName();
          }
          String _trim = null;
          if (_simpleName!=null) {
            _trim=_simpleName.trim();
          }
          _builder.append(_trim, "");
          _builder.append("</abbr>");
        }
      }
      {
        boolean _notEquals_2 = (!Objects.equal(javaDocURI, null));
        if (_notEquals_2) {
          _builder.append("</a>");
        }
      }
      {
        boolean _notEquals_3 = (!Objects.equal(sourceCodeURI, null));
        if (_notEquals_3) {
          _builder.append(" <a href=\"");
          _builder.append(sourceCodeURI, "");
          _builder.append("\">(src)</a>");
        }
      }
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _toHtml(final Code it, final ParagraphState state) {
    String _contents = it.getContents();
    String _quote = this.quote(_contents);
    return _quote;
  }
  
  protected CharSequence _toHtml(final CodeBlock it, final ParagraphState state) {
    CharSequence _xblockexpression = null;
    {
      EList<EObject> _contents = it.getContents();
      CharSequence _html = this.toHtml(_contents, state);
      final String code = _html.toString();
      CharSequence _xifexpression = null;
      boolean _or = false;
      boolean _contains = code.contains("\n");
      if (_contains) {
        _or = true;
      } else {
        boolean _and = false;
        EObject _eContainer = it.eContainer();
        EStructuralFeature _eContainingFeature = null;
        if (_eContainer!=null) {
          _eContainingFeature=_eContainer.eContainingFeature();
        }
        boolean _equals = Objects.equal(_eContainingFeature, XdocPackage.Literals.ABSTRACT_SECTION__CONTENTS);
        if (!_equals) {
          _and = false;
        } else {
          boolean _switchResult = false;
          EObject _eContainer_1 = it.eContainer();
          final EObject x = _eContainer_1;
          boolean _matched = false;
          if (!_matched) {
            if (x instanceof TextOrMarkup) {
              _matched=true;
              EList<EObject> _contents_1 = ((TextOrMarkup)x).getContents();
              int _size = _contents_1.size();
              boolean _equals_1 = (_size == 1);
              _switchResult = _equals_1;
            }
          }
          if (!_matched) {
            _switchResult = false;
          }
          _and = (_equals && _switchResult);
        }
        _or = (_contains || _and);
      }
      if (_or) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<pre class=\"prettyprint lang-");
        String _elvis = null;
        LangDef _language = it.getLanguage();
        String _name = null;
        if (_language!=null) {
          _name=_language.getName();
        }
        String _lowerCase = null;
        if (_name!=null) {
          _lowerCase=_name.toLowerCase();
        }
        if (_lowerCase != null) {
          _elvis = _lowerCase;
        } else {
          _elvis = ObjectExtensions.<String>operator_elvis(_lowerCase, "xtend");
        }
        _builder.append(_elvis, "");
        _builder.append(" linenums\">");
        String _markCodeBegin = this.markCodeBegin();
        _builder.append(_markCodeBegin, "");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        String _trimCode = this.trimCode(code);
        _builder.append(_trimCode, "\t\t\t");
        String _markCodeEnd = this.markCodeEnd();
        _builder.append(_markCodeEnd, "\t\t\t");
        _builder.append("</pre>");
        CharSequence _insert = this.insert(_builder, state);
        _xifexpression = _insert;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<code class=\"prettyprint lang-");
        String _elvis_1 = null;
        LangDef _language_1 = it.getLanguage();
        String _name_1 = null;
        if (_language_1!=null) {
          _name_1=_language_1.getName();
        }
        String _lowerCase_1 = null;
        if (_name_1!=null) {
          _lowerCase_1=_name_1.toLowerCase();
        }
        if (_lowerCase_1 != null) {
          _elvis_1 = _lowerCase_1;
        } else {
          _elvis_1 = ObjectExtensions.<String>operator_elvis(_lowerCase_1, "xtend");
        }
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
  
  protected CharSequence _toHtml(final Link it, final ParagraphState state) {
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
  
  protected CharSequence _toHtml(final Table it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<table class=\"table table-bordered table-condensed\">");
    _builder.newLine();
    {
      EList<TableRow> _rows = it.getRows();
      for(final TableRow row : _rows) {
        CharSequence _html = this.toHtml(row, state);
        _builder.append(_html, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</table>");
    _builder.newLine();
    CharSequence _insert = this.insert(_builder, state);
    return _insert;
  }
  
  protected CharSequence _toHtml(final TableRow it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<tr>");
    EList<TableData> _data = it.getData();
    CharSequence _html = this.toHtml(_data, state);
    _builder.append(_html, "");
    _builder.append("</tr>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final TableData it, final ParagraphState state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<td>");
    EList<TextOrMarkup> _contents = it.getContents();
    CharSequence _html = this.toHtml(_contents, state);
    _builder.append(_html, "");
    _builder.append("</td>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toHtml(final EObject it, final ParagraphState state) {
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
  
  protected CharSequence insert(final CharSequence content, final ParagraphState state) {
    CharSequence _xifexpression = null;
    boolean _equals = Objects.equal(state, ParagraphState.IN_PARAGRAPH);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("</p>");
      _builder.newLine();
      _builder.append(content, "");
      _builder.newLineIfNotEmpty();
      _builder.append("<p>");
      _builder.newLine();
      _xifexpression = _builder;
    } else {
      _xifexpression = content;
    }
    return _xifexpression;
  }
  
  protected String trimCode(final String it) {
    String _xblockexpression = null;
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(it);
      if (_isNullOrEmpty) {
        return "";
      }
      int start = 0;
      boolean _and = false;
      int _length = it.length();
      int _minus = (_length - 1);
      boolean _lessThan = (start < _minus);
      if (!_lessThan) {
        _and = false;
      } else {
        boolean _or = false;
        String _substring = it.substring(start, (start + 1));
        boolean _equals = Objects.equal(_substring, " ");
        if (_equals) {
          _or = true;
        } else {
          String _substring_1 = it.substring(start, (start + 1));
          boolean _equals_1 = Objects.equal(_substring_1, "\t");
          _or = (_equals || _equals_1);
        }
        _and = (_lessThan && _or);
      }
      boolean _while = _and;
      while (_while) {
        start = (start + 1);
        boolean _and_1 = false;
        int _length_1 = it.length();
        int _minus_1 = (_length_1 - 1);
        boolean _lessThan_1 = (start < _minus_1);
        if (!_lessThan_1) {
          _and_1 = false;
        } else {
          boolean _or_1 = false;
          String _substring_2 = it.substring(start, (start + 1));
          boolean _equals_2 = Objects.equal(_substring_2, " ");
          if (_equals_2) {
            _or_1 = true;
          } else {
            String _substring_3 = it.substring(start, (start + 1));
            boolean _equals_3 = Objects.equal(_substring_3, "\t");
            _or_1 = (_equals_2 || _equals_3);
          }
          _and_1 = (_lessThan_1 && _or_1);
        }
        _while = _and_1;
      }
      String _substring_2 = it.substring(start, (start + 1));
      boolean _equals_2 = Objects.equal(_substring_2, "\n");
      if (_equals_2) {
        start = (start + 1);
      }
      int _length_1 = it.length();
      int end = (_length_1 - 1);
      boolean _and_1 = false;
      if (!(end > 0)) {
        _and_1 = false;
      } else {
        char _charAt = it.charAt(end);
        boolean _isWhitespace = Character.isWhitespace(_charAt);
        _and_1 = ((end > 0) && _isWhitespace);
      }
      boolean _while_1 = _and_1;
      while (_while_1) {
        end = (end - 1);
        boolean _and_2 = false;
        if (!(end > 0)) {
          _and_2 = false;
        } else {
          char _charAt_1 = it.charAt(end);
          boolean _isWhitespace_1 = Character.isWhitespace(_charAt_1);
          _and_2 = ((end > 0) && _isWhitespace_1);
        }
        _while_1 = _and_2;
      }
      String _substring_3 = it.substring(start, (end + 1));
      _xblockexpression = (_substring_3);
    }
    return _xblockexpression;
  }
  
  protected String quote(final CharSequence it) {
    String _string = it.toString();
    String _replace = _string.replace("&", "&amp;");
    String _replace_1 = _replace.replace("<", "&lt;");
    String _replace_2 = _replace_1.replace(">", "&gt;");
    String _replace_3 = _replace_2.replace("«", "&laquo;");
    String _replace_4 = _replace_3.replace("»", "&raquo;");
    String _replace_5 = _replace_4.replace("\\[", "[");
    String _replace_6 = _replace_5.replace("\\]", "]");
    String _replace_7 = _replace_6.replace("´", "\'");
    String _replace_8 = _replace_7.replace("`", "\'");
    return _replace_8;
  }
  
  protected CharSequence toHtml(final Object it, final ParagraphState state) {
    if (it instanceof Anchor) {
      return _toHtml((Anchor)it, state);
    } else if (it instanceof CodeBlock) {
      return _toHtml((CodeBlock)it, state);
    } else if (it instanceof CodeRef) {
      return _toHtml((CodeRef)it, state);
    } else if (it instanceof Emphasize) {
      return _toHtml((Emphasize)it, state);
    } else if (it instanceof ImageRef) {
      return _toHtml((ImageRef)it, state);
    } else if (it instanceof Link) {
      return _toHtml((Link)it, state);
    } else if (it instanceof OrderedList) {
      return _toHtml((OrderedList)it, state);
    } else if (it instanceof Ref) {
      return _toHtml((Ref)it, state);
    } else if (it instanceof Table) {
      return _toHtml((Table)it, state);
    } else if (it instanceof Todo) {
      return _toHtml((Todo)it, state);
    } else if (it instanceof UnorderedList) {
      return _toHtml((UnorderedList)it, state);
    } else if (it instanceof List) {
      return _toHtml((List<EObject>)it, state);
    } else if (it instanceof Code) {
      return _toHtml((Code)it, state);
    } else if (it instanceof Item) {
      return _toHtml((Item)it, state);
    } else if (it instanceof TableData) {
      return _toHtml((TableData)it, state);
    } else if (it instanceof TableRow) {
      return _toHtml((TableRow)it, state);
    } else if (it instanceof TextOrMarkup) {
      return _toHtml((TextOrMarkup)it, state);
    } else if (it instanceof TextPart) {
      return _toHtml((TextPart)it, state);
    } else if (it instanceof EObject) {
      return _toHtml((EObject)it, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, state).toString());
    }
  }
}
