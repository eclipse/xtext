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
import example4.DomBuilder;
import example4.DomSerializer;
import example4.H1;
import example4.Head;
import example4.Html;
import example4.P;
import example4.Title;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * This examples shows
 *  - the usage and declaration of a builder API.
 *  - usage of @Data annotation
 *  - non-static extension methods
 */
@SuppressWarnings("all")
public class DomExample {
  @Extension
  private DomBuilder db = new DomBuilder();
  
  @Extension
  private DomSerializer ds = new DomSerializer();
  
  @Test
  public void processDom() {
    final Html dom = this.buildDom();
    CharSequence _text = this.ds.toText(dom);
    InputOutput.<CharSequence>println(_text);
  }
  
  public Html buildDom() {
    Html _html = new Html();
    final Procedure1<Html> _function = new Procedure1<Html>() {
      @Override
      public void apply(final Html it) {
        final Procedure1<Head> _function = new Procedure1<Head>() {
          @Override
          public void apply(final Head it) {
            final Procedure1<Title> _function = new Procedure1<Title>() {
              @Override
              public void apply(final Title it) {
                DomExample.this.db.$(it, "HTML with Xtend");
              }
            };
            DomExample.this.db.title(it, _function);
          }
        };
        DomExample.this.db.head(it, _function);
        final Procedure1<Body> _function_1 = new Procedure1<Body>() {
          @Override
          public void apply(final Body it) {
            final Procedure1<H1> _function = new Procedure1<H1>() {
              @Override
              public void apply(final H1 it) {
                DomExample.this.db.$(it, "HTML with Xtend");
              }
            };
            DomExample.this.db.h1(it, _function);
            final Procedure1<P> _function_1 = new Procedure1<P>() {
              @Override
              public void apply(final P it) {
                DomExample.this.db.$(it, "this format can be used as an alternative to templates.");
              }
            };
            DomExample.this.db.p(it, _function_1);
            final Procedure1<A> _function_2 = new Procedure1<A>() {
              @Override
              public void apply(final A it) {
                DomExample.this.db.$(it, "Xtend");
              }
            };
            DomExample.this.db.a(it, "http://www.xtend-lang.org", _function_2);
            final Procedure1<P> _function_3 = new Procedure1<P>() {
              @Override
              public void apply(final P it) {
                DomExample.this.db.$(it, "This is some ");
                final Procedure1<B> _function = new Procedure1<B>() {
                  @Override
                  public void apply(final B it) {
                    DomExample.this.db.$(it, "mixed");
                  }
                };
                DomExample.this.db.b(it, _function);
                DomExample.this.db.$(it, " text. For more see the ");
                final Procedure1<A> _function_1 = new Procedure1<A>() {
                  @Override
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
              @Override
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
    return ObjectExtensions.<Html>operator_doubleArrow(_html, _function);
  }
}
