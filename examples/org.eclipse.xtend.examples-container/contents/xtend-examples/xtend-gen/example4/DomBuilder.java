/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package example4;

import example4.A;
import example4.B;
import example4.Body;
import example4.Contents;
import example4.H1;
import example4.H2;
import example4.Head;
import example4.Html;
import example4.Node;
import example4.P;
import example4.Title;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DomBuilder {
  public boolean $(final Node it, final CharSequence contents) {
    boolean _xblockexpression = false;
    {
      final Contents text = new Contents(contents);
      ArrayList<Node> _contents = it.getContents();
      _xblockexpression = _contents.add(text);
    }
    return _xblockexpression;
  }
  
  public void head(final Html it, final Procedure1<? super Head> init) {
    Head _head = new Head();
    this.<Head>addAndApply(it, _head, init);
  }
  
  public void title(final Head it, final Procedure1<? super Title> init) {
    Title _title = new Title();
    this.<Title>addAndApply(it, _title, init);
  }
  
  public void body(final Html it, final Procedure1<? super Body> init) {
    Body _body = new Body();
    this.<Body>addAndApply(it, _body, init);
  }
  
  public void b(final Node it, final Procedure1<? super B> init) {
    B _b = new B();
    this.<B>addAndApply(it, _b, init);
  }
  
  public void p(final Node it, final Procedure1<? super P> init) {
    P _p = new P();
    this.<P>addAndApply(it, _p, init);
  }
  
  public void a(final Node it, final String href, final Procedure1<? super A> init) {
    final A a = new A(href);
    this.<A>addAndApply(it, a, init);
  }
  
  public void h1(final Node it, final Procedure1<? super H1> init) {
    H1 _h1 = new H1();
    this.<H1>addAndApply(it, _h1, init);
  }
  
  public void h2(final Node it, final Procedure1<? super H2> init) {
    H2 _h2 = new H2();
    this.<H2>addAndApply(it, _h2, init);
  }
  
  private <T extends Node> void addAndApply(final Node parent, final T t, final Procedure1<? super T> init) {
    ArrayList<Node> _contents = parent.getContents();
    _contents.add(t);
    init.apply(t);
  }
}
