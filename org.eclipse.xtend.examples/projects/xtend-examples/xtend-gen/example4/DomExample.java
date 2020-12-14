/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package example4;

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
    InputOutput.<CharSequence>println(this.ds.toText(dom));
  }
  
  public Html buildDom() {
    Html _html = new Html();
    final Procedure1<Html> _function = (Html it) -> {
      final Procedure1<Head> _function_1 = (Head it_1) -> {
        final Procedure1<Title> _function_2 = (Title it_2) -> {
          this.db.$(it_2, "HTML with Xtend");
        };
        this.db.title(it_1, _function_2);
      };
      this.db.head(it, _function_1);
      final Procedure1<Body> _function_2 = (Body it_1) -> {
        final Procedure1<H1> _function_3 = (H1 it_2) -> {
          this.db.$(it_2, "HTML with Xtend");
        };
        this.db.h1(it_1, _function_3);
        final Procedure1<P> _function_4 = (P it_2) -> {
          this.db.$(it_2, "this format can be used as an alternative to templates.");
        };
        this.db.p(it_1, _function_4);
        final Procedure1<A> _function_5 = (A it_2) -> {
          this.db.$(it_2, "Xtend");
        };
        this.db.a(it_1, "http://www.xtend-lang.org", _function_5);
        final Procedure1<P> _function_6 = (P it_2) -> {
          this.db.$(it_2, "This is some ");
          final Procedure1<B> _function_7 = (B it_3) -> {
            this.db.$(it_3, "mixed");
          };
          this.db.b(it_2, _function_7);
          this.db.$(it_2, " text. For more see the ");
          final Procedure1<A> _function_8 = (A it_3) -> {
            this.db.$(it_3, "Xtend");
          };
          this.db.a(it_2, "http://www.xtend-lang.org", _function_8);
          this.db.$(it_2, " project");
        };
        this.db.p(it_1, _function_6);
        final Procedure1<P> _function_7 = (P it_2) -> {
          this.db.$(it_2, "More text.");
        };
        this.db.p(it_1, _function_7);
      };
      this.db.body(it, _function_2);
    };
    return ObjectExtensions.<Html>operator_doubleArrow(_html, _function);
  }
}
