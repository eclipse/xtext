/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package example4;

import example4.A;
import example4.Contents;
import example4.Node;
import java.util.ArrayList;
import java.util.List;
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
        _matched=true;
        CharSequence _text = ((Contents)n).getText();
        _switchResult = _text;
      }
    }
    if (!_matched) {
      if (n instanceof A) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<a href=\"");
        String _href = ((A)n).getHref();
        _builder.append(_href, "");
        _builder.append("\">");
        String _applyContents = this.applyContents(n);
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
      _builder.append(_applyContents, "\t");
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
    String _join = null;
    List<CharSequence> _map = null;
    ArrayList<Node> _contents = n.getContents();
    if (_contents!=null) {
      final Function1<Node,CharSequence> _function = new Function1<Node,CharSequence>() {
        public CharSequence apply(final Node it) {
          CharSequence _text = DomSerializer.this.toText(it);
          return _text;
        }
      };
      _map=ListExtensions.<Node, CharSequence>map(_contents, _function);
    }
    if (_map!=null) {
      _join=IterableExtensions.join(_map);
    }
    return _join;
  }
}
