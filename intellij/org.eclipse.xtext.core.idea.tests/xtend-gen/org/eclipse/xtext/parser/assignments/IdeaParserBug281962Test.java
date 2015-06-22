package org.eclipse.xtext.parser.assignments;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.assignments.ParserBug281962Test;
import org.eclipse.xtext.parser.assignments.idea.AssignmentsTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserBug281962Test extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends ParserBug281962Test {
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
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaParserBug281962Test.Delegate delegate;
  
  public IdeaParserBug281962Test() {
    super(AssignmentsTestLanguageFileType.INSTANCE);
    IdeaParserBug281962Test.Delegate _delegate = new IdeaParserBug281962Test.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new AssignmentsTestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/assignments/parserBug281962";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testComplexMultiDatatype_01() throws Exception {
    delegate.testComplexMultiDatatype_01();
  }
  
  public void testComplexMultiDatatype_02() throws Exception {
    delegate.testComplexMultiDatatype_02();
  }
  
  public void testComplexMultiDatatype_03() throws Exception {
    delegate.testComplexMultiDatatype_03();
  }
  
  public void testComplexMultiDatatype_04() throws Exception {
    delegate.testComplexMultiDatatype_04();
  }
  
  public void testComplexMultiDatatype_05() throws Exception {
    delegate.testComplexMultiDatatype_05();
  }
  
  public void testComplexMultiDatatype_06() throws Exception {
    delegate.testComplexMultiDatatype_06();
  }
  
  public void testComplexMulti_01() throws Exception {
    delegate.testComplexMulti_01();
  }
  
  public void testComplexMulti_02() throws Exception {
    delegate.testComplexMulti_02();
  }
  
  public void testComplexMulti_03() throws Exception {
    delegate.testComplexMulti_03();
  }
  
  public void testComplexMulti_04() throws Exception {
    delegate.testComplexMulti_04();
  }
  
  public void testComplexMulti_05() throws Exception {
    delegate.testComplexMulti_05();
  }
  
  public void testComplexMulti_06() throws Exception {
    delegate.testComplexMulti_06();
  }
  
  public void testComplexSingleDatatype_01() throws Exception {
    delegate.testComplexSingleDatatype_01();
  }
  
  public void testComplexSingleDatatype_02() throws Exception {
    delegate.testComplexSingleDatatype_02();
  }
  
  public void testComplexSingleDatatype_03() throws Exception {
    delegate.testComplexSingleDatatype_03();
  }
  
  public void testComplexSingleDatatype_04() throws Exception {
    delegate.testComplexSingleDatatype_04();
  }
  
  public void testComplexSingleDatatype_05() throws Exception {
    delegate.testComplexSingleDatatype_05();
  }
  
  public void testComplexSingleDatatype_06() throws Exception {
    delegate.testComplexSingleDatatype_06();
  }
  
  public void testComplexSingle_01() throws Exception {
    delegate.testComplexSingle_01();
  }
  
  public void testComplexSingle_02() throws Exception {
    delegate.testComplexSingle_02();
  }
  
  public void testComplexSingle_03() throws Exception {
    delegate.testComplexSingle_03();
  }
  
  public void testComplexSingle_04() throws Exception {
    delegate.testComplexSingle_04();
  }
  
  public void testComplexSingle_05() throws Exception {
    delegate.testComplexSingle_05();
  }
  
  public void testComplexSingle_06() throws Exception {
    delegate.testComplexSingle_06();
  }
  
  public void testSimpleMultiDatatype_01() throws Exception {
    delegate.testSimpleMultiDatatype_01();
  }
  
  public void testSimpleMultiDatatype_02() throws Exception {
    delegate.testSimpleMultiDatatype_02();
  }
  
  public void testSimpleMultiDatatype_03() throws Exception {
    delegate.testSimpleMultiDatatype_03();
  }
  
  public void testSimpleMultiDatatype_04() throws Exception {
    delegate.testSimpleMultiDatatype_04();
  }
  
  public void testSimpleMultiDatatype_05() throws Exception {
    delegate.testSimpleMultiDatatype_05();
  }
  
  public void testSimpleMultiDatatype_06() throws Exception {
    delegate.testSimpleMultiDatatype_06();
  }
  
  public void testSimpleMulti_01() throws Exception {
    delegate.testSimpleMulti_01();
  }
  
  public void testSimpleMulti_02() throws Exception {
    delegate.testSimpleMulti_02();
  }
  
  public void testSimpleMulti_03() throws Exception {
    delegate.testSimpleMulti_03();
  }
  
  public void testSimpleMulti_04() throws Exception {
    delegate.testSimpleMulti_04();
  }
  
  public void testSimpleMulti_05() throws Exception {
    delegate.testSimpleMulti_05();
  }
  
  public void testSimpleMulti_06() throws Exception {
    delegate.testSimpleMulti_06();
  }
  
  public void testSimpleSingleDatatype_01() throws Exception {
    delegate.testSimpleSingleDatatype_01();
  }
  
  public void testSimpleSingleDatatype_02() throws Exception {
    delegate.testSimpleSingleDatatype_02();
  }
  
  public void testSimpleSingleDatatype_03() throws Exception {
    delegate.testSimpleSingleDatatype_03();
  }
  
  public void testSimpleSingleDatatype_04() throws Exception {
    delegate.testSimpleSingleDatatype_04();
  }
  
  public void testSimpleSingleDatatype_05() throws Exception {
    delegate.testSimpleSingleDatatype_05();
  }
  
  public void testSimpleSingleDatatype_06() throws Exception {
    delegate.testSimpleSingleDatatype_06();
  }
  
  public void testSimpleSingle_01() throws Exception {
    delegate.testSimpleSingle_01();
  }
  
  public void testSimpleSingle_02() throws Exception {
    delegate.testSimpleSingle_02();
  }
  
  public void testSimpleSingle_03() throws Exception {
    delegate.testSimpleSingle_03();
  }
  
  public void testSimpleSingle_04() throws Exception {
    delegate.testSimpleSingle_04();
  }
  
  public void testSimpleSingle_05() throws Exception {
    delegate.testSimpleSingle_05();
  }
  
  public void testSimpleSingle_06() throws Exception {
    delegate.testSimpleSingle_06();
  }
}
