package org.eclipse.xtext.parser.antlr;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.NodeModelPrinter;
import org.eclipse.xtext.idea.tests.parsing.XtextResourceAsserts;
import org.eclipse.xtext.parser.antlr.IdeaBug378967TestDelegate;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug378967Test extends AbstractLanguageParsingTestCase {
  private IdeaBug378967TestDelegate delegate;
  
  public IdeaBug378967Test() {
    super(Bug378967TestLanguageFileType.INSTANCE);
    IdeaBug378967TestDelegate _ideaBug378967TestDelegate = new IdeaBug378967TestDelegate(this);
    this.delegate = _ideaBug378967TestDelegate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug378967";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    XtextResourceAsserts _xtextResourceAsserts = this.getXtextResourceAsserts();
    NodeModelPrinter _nodeModelPrinter = _xtextResourceAsserts.getNodeModelPrinter();
    _nodeModelPrinter.setIgnoreSyntaxErrors(true);
    this.delegate.setUp();
  }
  
  public void test1() throws Exception {
    delegate.test1();
  }
  
  public void test2() throws Exception {
    delegate.test2();
  }
  
  public void test3() throws Exception {
    delegate.test3();
  }
  
  public void test4() throws Exception {
    delegate.test4();
  }
}
