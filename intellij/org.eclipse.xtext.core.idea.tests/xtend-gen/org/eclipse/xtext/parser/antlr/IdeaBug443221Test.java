package org.eclipse.xtext.parser.antlr;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.antlr.Bug443221Test;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaBug443221Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delgate extends Bug443221Test {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = Bug443221TestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
      this.setInjector(_instance);
    }
    
    @Override
    protected XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
      InputStreamReader _inputStreamReader = new InputStreamReader(in);
      String _string = CharStreams.toString(_inputStreamReader);
      return this.modelChecker.checkResource(_string, false);
    }
    
    @Override
    protected boolean shouldTestSerializer(final XtextResource resource) {
      return false;
    }
    
    public Delgate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaBug443221Test.Delgate delegate;
  
  public IdeaBug443221Test() {
    super(Bug443221TestLanguageFileType.INSTANCE);
    IdeaBug443221Test.Delgate _delgate = new IdeaBug443221Test.Delgate(this);
    this.delegate = _delgate;
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/antlr/bug443221";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testParse() throws Exception {
    delegate.testParse();
  }
}
