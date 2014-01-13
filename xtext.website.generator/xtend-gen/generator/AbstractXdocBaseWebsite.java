package generator;

import com.google.common.base.Objects;
import generator.AbstractWebsite;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.LangDef;

@SuppressWarnings("all")
public abstract class AbstractXdocBaseWebsite extends AbstractWebsite {
  protected abstract Document getDocument();
  
  public CharSequence javaScriptAtTheEnd() {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _javaScriptAtTheEnd = super.javaScriptAtTheEnd();
    _builder.append(_javaScriptAtTheEnd, "");
    _builder.newLineIfNotEmpty();
    String _prettify = this.prettify();
    _builder.append(_prettify, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected boolean isPrettyPrint() {
    return true;
  }
  
  public String prettify() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<script type=\"text/javascript\" src=\"google-code-prettify/lang-common.js\"></script>");
    String result = _builder.toString();
    Document _document = this.getDocument();
    boolean _notEquals = (!Objects.equal(_document, null));
    if (_notEquals) {
      Document _document_1 = this.getDocument();
      final EList<LangDef> languages = _document_1.getLangDefs();
      int _size = languages.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("<script type=\"text/javascript\">");
        _builder_1.newLine();
        {
          for(final LangDef lang : languages) {
            {
              boolean _or = false;
              boolean _or_1 = false;
              String _name = lang.getName();
              boolean _equalsIgnoreCase = _name.equalsIgnoreCase("java");
              if (_equalsIgnoreCase) {
                _or_1 = true;
              } else {
                String _name_1 = lang.getName();
                boolean _equalsIgnoreCase_1 = _name_1.equalsIgnoreCase("xml");
                _or_1 = _equalsIgnoreCase_1;
              }
              if (_or_1) {
                _or = true;
              } else {
                String _name_2 = lang.getName();
                boolean _equalsIgnoreCase_2 = _name_2.equalsIgnoreCase("xtend");
                _or = _equalsIgnoreCase_2;
              }
              boolean _not = (!_or);
              if (_not) {
                _builder_1.append("\t");
                _builder_1.append("registerLanguage(\'");
                {
                  EList<String> _keywords = lang.getKeywords();
                  boolean _hasElements = false;
                  for(final String keyword : _keywords) {
                    if (!_hasElements) {
                      _hasElements = true;
                    } else {
                      _builder_1.appendImmediate("|", "\t");
                    }
                    _builder_1.append(keyword, "\t");
                  }
                }
                _builder_1.append("\', \'");
                String _name_3 = lang.getName();
                String _lowerCase = _name_3.toLowerCase();
                _builder_1.append(_lowerCase, "\t");
                _builder_1.append("\');");
                _builder_1.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder_1.append("</script>");
        _builder_1.newLine();
        String _plus = (result + _builder_1);
        result = _plus;
      }
    }
    return result;
  }
}
