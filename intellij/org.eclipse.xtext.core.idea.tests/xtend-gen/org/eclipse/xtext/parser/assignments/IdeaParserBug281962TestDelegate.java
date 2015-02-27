package org.eclipse.xtext.parser.assignments;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.assignments.ParserBug281962Test;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.Ignore;

@Ignore
@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaParserBug281962TestDelegate extends ParserBug281962Test {
  private final ModelChecker modelChecker;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    Injector _instance = AssignmentsTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
    this.setInjector(_instance);
  }
  
  @Override
  protected XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
    InputStreamReader _inputStreamReader = new InputStreamReader(in);
    String _string = CharStreams.toString(_inputStreamReader);
    return this.modelChecker.checkResource(_string, false);
  }
  
  public IdeaParserBug281962TestDelegate(final ModelChecker modelChecker) {
    super();
    this.modelChecker = modelChecker;
  }
}
