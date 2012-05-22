package lesson4;

import lesson4.A;
import lesson4.B;
import lesson4.Body;
import lesson4.DomBuilder;
import lesson4.DomSerializer;
import lesson4.H1;
import lesson4.Head;
import lesson4.Html;
import lesson4.P;
import lesson4.Title;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * This examples shows
 *  - the usage and declaration of a builder API.
 *  - usage of @Data annotation
 *  - non-static extenions methods
 */
@SuppressWarnings("all")
public class DomExample {
  private DomBuilder db = new Function0<DomBuilder>() {
    public DomBuilder apply() {
      DomBuilder _domBuilder = new DomBuilder();
      return _domBuilder;
    }
  }.apply();
  
  private DomSerializer ds = new Function0<DomSerializer>() {
    public DomSerializer apply() {
      DomSerializer _domSerializer = new DomSerializer();
      return _domSerializer;
    }
  }.apply();
  
  @Test
  public void processDom() {
    final Html dom = this.buildDom();
    CharSequence _text = this.ds.toText(dom);
    InputOutput.<CharSequence>println(_text);
  }
  
  public Html buildDom() {
    Html _html = new Html();
    final Procedure1<Html> _function = new Procedure1<Html>() {
        public void apply(final Html it) {
          final Procedure1<Head> _function = new Procedure1<Head>() {
              public void apply(final Head it) {
                final Procedure1<Title> _function = new Procedure1<Title>() {
                    public void apply(final Title it) {
                      DomExample.this.db.$(it, "HTML with Xtend");
                    }
                  };
                DomExample.this.db.title(it, _function);
              }
            };
          DomExample.this.db.head(it, _function);
          final Procedure1<Body> _function_1 = new Procedure1<Body>() {
              public void apply(final Body it) {
                final Procedure1<H1> _function = new Procedure1<H1>() {
                    public void apply(final H1 it) {
                      DomExample.this.db.$(it, "HTML with Xtend");
                    }
                  };
                DomExample.this.db.h1(it, _function);
                final Procedure1<P> _function_1 = new Procedure1<P>() {
                    public void apply(final P it) {
                      DomExample.this.db.$(it, "this format can be used as an alternative to templates.");
                    }
                  };
                DomExample.this.db.p(it, _function_1);
                final Procedure1<A> _function_2 = new Procedure1<A>() {
                    public void apply(final A it) {
                      DomExample.this.db.$(it, "Xtend");
                    }
                  };
                DomExample.this.db.a(it, "http://www.xtend-lang.org", _function_2);
                final Procedure1<P> _function_3 = new Procedure1<P>() {
                    public void apply(final P it) {
                      DomExample.this.db.$(it, "This is some ");
                      final Procedure1<B> _function = new Procedure1<B>() {
                          public void apply(final B it) {
                            DomExample.this.db.$(it, "mixed");
                          }
                        };
                      DomExample.this.db.b(it, _function);
                      DomExample.this.db.$(it, " text. For more see the ");
                      final Procedure1<A> _function_1 = new Procedure1<A>() {
                          public void apply(final A it) {
                            DomExample.this.db.$(it, "Xtend");
                          }
                        };
                      DomExample.this.db.a(it, "http://www.xtend-lang.org", _function_1);
                      DomExample.this.db.$(it, " project");
                    }
                  };
                DomExample.this.db.p(it, _function_3);
                final Procedure1<P> _function_4 = new Procedure1<P>() {
                    public void apply(final P it) {
                      DomExample.this.db.$(it, "More text.");
                    }
                  };
                DomExample.this.db.p(it, _function_4);
              }
            };
          DomExample.this.db.body(it, _function_1);
        }
      };
    Html _doubleArrow = ObjectExtensions.<Html>operator_doubleArrow(_html, _function);
    return _doubleArrow;
  }
}
