package lesson4;

import java.util.ArrayList;
import java.util.List;
import lesson4.A;
import lesson4.Contents;
import lesson4.Node;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class DomSerializer {
  public CharSequence toText(final Node n) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (n instanceof Contents) {
        final Contents _contents = (Contents)n;
        _matched=true;
        CharSequence _text = _contents.getText();
        _switchResult = _text;
      }
    }
    if (!_matched) {
      if (n instanceof A) {
        final A _a = (A)n;
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<a href=\"");
        String _href = _a.getHref();
        _builder.append(_href, "");
        _builder.append("\">");
        String _applyContents = this.applyContents(_a);
        _builder.append(_applyContents, "");
        _builder.append("</a>");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<");
      String _tagName = n.tagName();
      _builder.append(_tagName, "");
      _builder.append(">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _applyContents = this.applyContents(n);
      _builder.append(_applyContents, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("</");
      String _tagName_1 = n.tagName();
      _builder.append(_tagName_1, "");
      _builder.append(">");
      _builder.newLineIfNotEmpty();
      _switchResult = _builder;
    }
    return _switchResult;
  }
  
  private String applyContents(final Node n) {
    ArrayList<Node> _contents = n.getContents();
    final Function1<Node,CharSequence> _function = new Function1<Node,CharSequence>() {
        public CharSequence apply(final Node it) {
          CharSequence _text = DomSerializer.this.toText(it);
          return _text;
        }
      };
    List<CharSequence> _map = _contents==null?(List<CharSequence>)null:ListExtensions.<Node, CharSequence>map(_contents, _function);
    String _join = _map==null?(String)null:IterableExtensions.join(_map);
    return _join;
  }
}
