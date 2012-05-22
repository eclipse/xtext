package lesson4;

import java.util.ArrayList;
import lesson4.A;
import lesson4.B;
import lesson4.Body;
import lesson4.Contents;
import lesson4.H1;
import lesson4.H2;
import lesson4.Head;
import lesson4.Html;
import lesson4.Node;
import lesson4.P;
import lesson4.Title;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class DomBuilder {
  public boolean $(final Node it, final CharSequence contents) {
    boolean _xblockexpression = false;
    {
      Contents _contents = new Contents(contents);
      final Contents text = _contents;
      ArrayList<Node> _contents_1 = it.getContents();
      boolean _add = _contents_1.add(text);
      _xblockexpression = (_add);
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
    A _a = new A(href);
    final A a = _a;
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
