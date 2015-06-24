package org.eclipse.xtext.parser.unorderedGroups;

import com.google.common.io.CharStreams;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.parser.unorderedGroups.ParserExTest;
import org.eclipse.xtext.parser.unorderedGroups.idea.ExUnorderedGroupsTestLanguageStandaloneSetupIdea;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageFileType;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;
import org.eclipse.xtext.resource.XtextResource;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserExTest extends AbstractLanguageParsingTestCase {
  @FinalFieldsConstructor
  private static class Delegate extends ParserExTest {
    private final ModelChecker modelChecker;
    
    @Override
    public void setUp() throws Exception {
      super.setUp();
      Injector _instance = ExUnorderedGroupsTestLanguageLanguage.INSTANCE.<Injector>getInstance(Injector.class);
      this.setInjector(_instance);
    }
    
    @Override
    protected XtextResource doGetResource(final InputStream in, final URI uri) throws Exception {
      InputStreamReader _inputStreamReader = new InputStreamReader(in);
      String _string = CharStreams.toString(_inputStreamReader);
      EObject _checkModel = this.modelChecker.<EObject>checkModel(_string, false);
      Resource _eResource = _checkModel.eResource();
      return ((XtextResource) _eResource);
    }
    
    @Override
    protected boolean shouldTestSerializer(final XtextResource resource) {
      return false;
    }
    
    public Delegate(final ModelChecker modelChecker) {
      super();
      this.modelChecker = modelChecker;
    }
  }
  
  private IdeaParserExTest.Delegate delegate;
  
  public IdeaParserExTest() {
    super(ExUnorderedGroupsTestLanguageFileType.INSTANCE);
    IdeaParserExTest.Delegate _delegate = new IdeaParserExTest.Delegate(this);
    this.delegate = _delegate;
  }
  
  @Override
  protected ISetup getSetup() {
    return new ExUnorderedGroupsTestLanguageStandaloneSetupIdea();
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing/unorderedGroups/parserExTest";
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    this.delegate.setUp();
  }
  
  public void testDatatype_10() throws Exception {
    delegate.testDatatype_10();
  }
  
  public void testDatatype_10_A() throws Exception {
    delegate.testDatatype_10_A();
  }
  
  public void testDatatype_10_A_B() throws Exception {
    delegate.testDatatype_10_A_B();
  }
  
  public void testDatatype_10_A_B_A() throws Exception {
    delegate.testDatatype_10_A_B_A();
  }
  
  public void testDatatype_10_A_B_A_B() throws Exception {
    delegate.testDatatype_10_A_B_A_B();
  }
  
  public void testDatatype_10_A_B_B() throws Exception {
    delegate.testDatatype_10_A_B_B();
  }
  
  public void testDatatype_10_A_B_B_A() throws Exception {
    delegate.testDatatype_10_A_B_B_A();
  }
  
  public void testDatatype_10_B() throws Exception {
    delegate.testDatatype_10_B();
  }
  
  public void testDatatype_10_B_A() throws Exception {
    delegate.testDatatype_10_B_A();
  }
  
  public void testDatatype_10_B_A_A() throws Exception {
    delegate.testDatatype_10_B_A_A();
  }
  
  public void testDatatype_10_B_A_A_B() throws Exception {
    delegate.testDatatype_10_B_A_A_B();
  }
  
  public void testDatatype_10_B_A_B() throws Exception {
    delegate.testDatatype_10_B_A_B();
  }
  
  public void testDatatype_10_B_A_B_A() throws Exception {
    delegate.testDatatype_10_B_A_B_A();
  }
  
  public void testDatatype_11() throws Exception {
    delegate.testDatatype_11();
  }
  
  public void testDatatype_11_A() throws Exception {
    delegate.testDatatype_11_A();
  }
  
  public void testDatatype_11_A_B() throws Exception {
    delegate.testDatatype_11_A_B();
  }
  
  public void testDatatype_11_A_B_A() throws Exception {
    delegate.testDatatype_11_A_B_A();
  }
  
  public void testDatatype_11_A_B_B() throws Exception {
    delegate.testDatatype_11_A_B_B();
  }
  
  public void testDatatype_11_B() throws Exception {
    delegate.testDatatype_11_B();
  }
  
  public void testDatatype_11_B_A() throws Exception {
    delegate.testDatatype_11_B_A();
  }
  
  public void testDatatype_11_B_A_A() throws Exception {
    delegate.testDatatype_11_B_A_A();
  }
  
  public void testDatatype_11_B_A_B() throws Exception {
    delegate.testDatatype_11_B_A_B();
  }
  
  public void testDatatype_12() throws Exception {
    delegate.testDatatype_12();
  }
  
  public void testDatatype_12_A() throws Exception {
    delegate.testDatatype_12_A();
  }
  
  public void testDatatype_12_A_A() throws Exception {
    delegate.testDatatype_12_A_A();
  }
  
  public void testDatatype_12_A_B() throws Exception {
    delegate.testDatatype_12_A_B();
  }
  
  public void testDatatype_12_A_B_A() throws Exception {
    delegate.testDatatype_12_A_B_A();
  }
  
  public void testDatatype_12_A_B_A_B() throws Exception {
    delegate.testDatatype_12_A_B_A_B();
  }
  
  public void testDatatype_12_A_B_B() throws Exception {
    delegate.testDatatype_12_A_B_B();
  }
  
  public void testDatatype_12_A_B_B_A() throws Exception {
    delegate.testDatatype_12_A_B_B_A();
  }
  
  public void testDatatype_12_B() throws Exception {
    delegate.testDatatype_12_B();
  }
  
  public void testDatatype_12_B_A() throws Exception {
    delegate.testDatatype_12_B_A();
  }
  
  public void testDatatype_12_B_A_A() throws Exception {
    delegate.testDatatype_12_B_A_A();
  }
  
  public void testDatatype_12_B_A_A_B() throws Exception {
    delegate.testDatatype_12_B_A_A_B();
  }
  
  public void testDatatype_12_B_A_B() throws Exception {
    delegate.testDatatype_12_B_A_B();
  }
  
  public void testDatatype_12_B_A_B_A() throws Exception {
    delegate.testDatatype_12_B_A_B_A();
  }
  
  public void testDatatype_12_B_B() throws Exception {
    delegate.testDatatype_12_B_B();
  }
  
  public void testDatatype_13() throws Exception {
    delegate.testDatatype_13();
  }
  
  public void testDatatype_13_A() throws Exception {
    delegate.testDatatype_13_A();
  }
  
  public void testDatatype_13_A_A() throws Exception {
    delegate.testDatatype_13_A_A();
  }
  
  public void testDatatype_13_A_B() throws Exception {
    delegate.testDatatype_13_A_B();
  }
  
  public void testDatatype_13_A_B_A() throws Exception {
    delegate.testDatatype_13_A_B_A();
  }
  
  public void testDatatype_13_A_B_A_B() throws Exception {
    delegate.testDatatype_13_A_B_A_B();
  }
  
  public void testDatatype_13_A_B_B() throws Exception {
    delegate.testDatatype_13_A_B_B();
  }
  
  public void testDatatype_13_A_B_B_A() throws Exception {
    delegate.testDatatype_13_A_B_B_A();
  }
  
  public void testDatatype_13_B() throws Exception {
    delegate.testDatatype_13_B();
  }
  
  public void testDatatype_13_B_A() throws Exception {
    delegate.testDatatype_13_B_A();
  }
  
  public void testDatatype_13_B_A_A() throws Exception {
    delegate.testDatatype_13_B_A_A();
  }
  
  public void testDatatype_13_B_A_A_B() throws Exception {
    delegate.testDatatype_13_B_A_A_B();
  }
  
  public void testDatatype_13_B_A_B() throws Exception {
    delegate.testDatatype_13_B_A_B();
  }
  
  public void testDatatype_13_B_A_B_A() throws Exception {
    delegate.testDatatype_13_B_A_B_A();
  }
  
  public void testDatatype_13_B_B() throws Exception {
    delegate.testDatatype_13_B_B();
  }
  
  public void testDatatype_14_A_B_C_D() throws Exception {
    delegate.testDatatype_14_A_B_C_D();
  }
  
  public void testDatatype_14_A_B_C_D_D_C_B_A() throws Exception {
    delegate.testDatatype_14_A_B_C_D_D_C_B_A();
  }
  
  public void testDatatype_14_A_B_C_D_D_C_B_A_B_A_C_D() throws Exception {
    delegate.testDatatype_14_A_B_C_D_D_C_B_A_B_A_C_D();
  }
  
  public void testDatatype_14_A_B_D_C() throws Exception {
    delegate.testDatatype_14_A_B_D_C();
  }
  
  public void testDatatype_14_B_A_C_D() throws Exception {
    delegate.testDatatype_14_B_A_C_D();
  }
  
  public void testDatatype_14_B_A_D_C() throws Exception {
    delegate.testDatatype_14_B_A_D_C();
  }
  
  public void testDatatype_14_C_D_A_B() throws Exception {
    delegate.testDatatype_14_C_D_A_B();
  }
  
  public void testDatatype_14_C_D_B_A() throws Exception {
    delegate.testDatatype_14_C_D_B_A();
  }
  
  public void testDatatype_14_D_C_A_B() throws Exception {
    delegate.testDatatype_14_D_C_A_B();
  }
  
  public void testDatatype_14_D_C_B_A() throws Exception {
    delegate.testDatatype_14_D_C_B_A();
  }
  
  public void testDatatype_1_A_B() throws Exception {
    delegate.testDatatype_1_A_B();
  }
  
  public void testDatatype_1_B_A() throws Exception {
    delegate.testDatatype_1_B_A();
  }
  
  public void testDatatype_2_A_A_C_B_D() throws Exception {
    delegate.testDatatype_2_A_A_C_B_D();
  }
  
  public void testDatatype_2_A_B_C_D() throws Exception {
    delegate.testDatatype_2_A_B_C_D();
  }
  
  public void testDatatype_2_A_B_D_C() throws Exception {
    delegate.testDatatype_2_A_B_D_C();
  }
  
  public void testDatatype_2_A_C_A_B_D() throws Exception {
    delegate.testDatatype_2_A_C_A_B_D();
  }
  
  public void testDatatype_2_A_C_B_A_D() throws Exception {
    delegate.testDatatype_2_A_C_B_A_D();
  }
  
  public void testDatatype_2_A_C_B_D() throws Exception {
    delegate.testDatatype_2_A_C_B_D();
  }
  
  public void testDatatype_2_A_C_B_D_A() throws Exception {
    delegate.testDatatype_2_A_C_B_D_A();
  }
  
  public void testDatatype_2_A_C_D_B() throws Exception {
    delegate.testDatatype_2_A_C_D_B();
  }
  
  public void testDatatype_2_A_D_B_C() throws Exception {
    delegate.testDatatype_2_A_D_B_C();
  }
  
  public void testDatatype_2_A_D_C_B() throws Exception {
    delegate.testDatatype_2_A_D_C_B();
  }
  
  public void testDatatype_3() throws Exception {
    delegate.testDatatype_3();
  }
  
  public void testDatatype_3_A() throws Exception {
    delegate.testDatatype_3_A();
  }
  
  public void testDatatype_3_A_B() throws Exception {
    delegate.testDatatype_3_A_B();
  }
  
  public void testDatatype_3_B() throws Exception {
    delegate.testDatatype_3_B();
  }
  
  public void testDatatype_3_B_A() throws Exception {
    delegate.testDatatype_3_B_A();
  }
  
  public void testDatatype_4() throws Exception {
    delegate.testDatatype_4();
  }
  
  public void testDatatype_4_A() throws Exception {
    delegate.testDatatype_4_A();
  }
  
  public void testDatatype_4_A_B() throws Exception {
    delegate.testDatatype_4_A_B();
  }
  
  public void testDatatype_4_B() throws Exception {
    delegate.testDatatype_4_B();
  }
  
  public void testDatatype_4_B_A() throws Exception {
    delegate.testDatatype_4_B_A();
  }
  
  public void testDatatype_5() throws Exception {
    delegate.testDatatype_5();
  }
  
  public void testDatatype_5_A() throws Exception {
    delegate.testDatatype_5_A();
  }
  
  public void testDatatype_5_A_B() throws Exception {
    delegate.testDatatype_5_A_B();
  }
  
  public void testDatatype_5_B() throws Exception {
    delegate.testDatatype_5_B();
  }
  
  public void testDatatype_5_B_A() throws Exception {
    delegate.testDatatype_5_B_A();
  }
  
  public void testDatatype_6() throws Exception {
    delegate.testDatatype_6();
  }
  
  public void testDatatype_6_A() throws Exception {
    delegate.testDatatype_6_A();
  }
  
  public void testDatatype_6_A_A() throws Exception {
    delegate.testDatatype_6_A_A();
  }
  
  public void testDatatype_6_A_A_B_B() throws Exception {
    delegate.testDatatype_6_A_A_B_B();
  }
  
  public void testDatatype_6_A_B() throws Exception {
    delegate.testDatatype_6_A_B();
  }
  
  public void testDatatype_6_B() throws Exception {
    delegate.testDatatype_6_B();
  }
  
  public void testDatatype_6_B_A() throws Exception {
    delegate.testDatatype_6_B_A();
  }
  
  public void testDatatype_6_B_B() throws Exception {
    delegate.testDatatype_6_B_B();
  }
  
  public void testDatatype_6_B_B_A_A() throws Exception {
    delegate.testDatatype_6_B_B_A_A();
  }
  
  public void testDatatype_7() throws Exception {
    delegate.testDatatype_7();
  }
  
  public void testDatatype_7_A() throws Exception {
    delegate.testDatatype_7_A();
  }
  
  public void testDatatype_7_A_A() throws Exception {
    delegate.testDatatype_7_A_A();
  }
  
  public void testDatatype_7_A_A_B_B() throws Exception {
    delegate.testDatatype_7_A_A_B_B();
  }
  
  public void testDatatype_7_A_B() throws Exception {
    delegate.testDatatype_7_A_B();
  }
  
  public void testDatatype_7_B() throws Exception {
    delegate.testDatatype_7_B();
  }
  
  public void testDatatype_7_B_A() throws Exception {
    delegate.testDatatype_7_B_A();
  }
  
  public void testDatatype_7_B_B() throws Exception {
    delegate.testDatatype_7_B_B();
  }
  
  public void testDatatype_7_B_B_A_A() throws Exception {
    delegate.testDatatype_7_B_B_A_A();
  }
  
  public void testDatatype_8_A_B_C_A_B_D() throws Exception {
    delegate.testDatatype_8_A_B_C_A_B_D();
  }
  
  public void testDatatype_8_A_B_D_A_B_C() throws Exception {
    delegate.testDatatype_8_A_B_D_A_B_C();
  }
  
  public void testDatatype_9() throws Exception {
    delegate.testDatatype_9();
  }
  
  public void testDatatype_9_A() throws Exception {
    delegate.testDatatype_9_A();
  }
  
  public void testDatatype_9_A_B() throws Exception {
    delegate.testDatatype_9_A_B();
  }
  
  public void testDatatype_9_A_B_A() throws Exception {
    delegate.testDatatype_9_A_B_A();
  }
  
  public void testDatatype_9_A_B_A_B() throws Exception {
    delegate.testDatatype_9_A_B_A_B();
  }
  
  public void testDatatype_9_A_B_B() throws Exception {
    delegate.testDatatype_9_A_B_B();
  }
  
  public void testDatatype_9_A_B_B_A() throws Exception {
    delegate.testDatatype_9_A_B_B_A();
  }
  
  public void testDatatype_9_B() throws Exception {
    delegate.testDatatype_9_B();
  }
  
  public void testDatatype_9_B_A() throws Exception {
    delegate.testDatatype_9_B_A();
  }
  
  public void testDatatype_9_B_A_A() throws Exception {
    delegate.testDatatype_9_B_A_A();
  }
  
  public void testDatatype_9_B_A_A_B() throws Exception {
    delegate.testDatatype_9_B_A_A_B();
  }
  
  public void testDatatype_9_B_A_B() throws Exception {
    delegate.testDatatype_9_B_A_B();
  }
  
  public void testDatatype_9_B_A_B_A() throws Exception {
    delegate.testDatatype_9_B_A_B_A();
  }
  
  public void testNested_A_B() throws Exception {
    delegate.testNested_A_B();
  }
  
  public void testNested_A_B_A_B() throws Exception {
    delegate.testNested_A_B_A_B();
  }
  
  public void testNested_A_B_B_A() throws Exception {
    delegate.testNested_A_B_B_A();
  }
  
  public void testNested_B_A() throws Exception {
    delegate.testNested_B_A();
  }
  
  public void testNested_B_A_A_B() throws Exception {
    delegate.testNested_B_A_A_B();
  }
  
  public void testNested_B_A_B_A() throws Exception {
    delegate.testNested_B_A_B_A();
  }
  
  public void testParse_10() throws Exception {
    delegate.testParse_10();
  }
  
  public void testParse_10_A() throws Exception {
    delegate.testParse_10_A();
  }
  
  public void testParse_10_A_B() throws Exception {
    delegate.testParse_10_A_B();
  }
  
  public void testParse_10_A_B_A() throws Exception {
    delegate.testParse_10_A_B_A();
  }
  
  public void testParse_10_A_B_A_B() throws Exception {
    delegate.testParse_10_A_B_A_B();
  }
  
  public void testParse_10_A_B_B() throws Exception {
    delegate.testParse_10_A_B_B();
  }
  
  public void testParse_10_A_B_B_A() throws Exception {
    delegate.testParse_10_A_B_B_A();
  }
  
  public void testParse_10_B() throws Exception {
    delegate.testParse_10_B();
  }
  
  public void testParse_10_B_A() throws Exception {
    delegate.testParse_10_B_A();
  }
  
  public void testParse_10_B_A_A() throws Exception {
    delegate.testParse_10_B_A_A();
  }
  
  public void testParse_10_B_A_A_B() throws Exception {
    delegate.testParse_10_B_A_A_B();
  }
  
  public void testParse_10_B_A_B() throws Exception {
    delegate.testParse_10_B_A_B();
  }
  
  public void testParse_10_B_A_B_A() throws Exception {
    delegate.testParse_10_B_A_B_A();
  }
  
  public void testParse_11() throws Exception {
    delegate.testParse_11();
  }
  
  public void testParse_11_A() throws Exception {
    delegate.testParse_11_A();
  }
  
  public void testParse_11_A_B() throws Exception {
    delegate.testParse_11_A_B();
  }
  
  public void testParse_11_A_B_A() throws Exception {
    delegate.testParse_11_A_B_A();
  }
  
  public void testParse_11_A_B_B() throws Exception {
    delegate.testParse_11_A_B_B();
  }
  
  public void testParse_11_B() throws Exception {
    delegate.testParse_11_B();
  }
  
  public void testParse_11_B_A() throws Exception {
    delegate.testParse_11_B_A();
  }
  
  public void testParse_11_B_A_A() throws Exception {
    delegate.testParse_11_B_A_A();
  }
  
  public void testParse_11_B_A_B() throws Exception {
    delegate.testParse_11_B_A_B();
  }
  
  public void testParse_12() throws Exception {
    delegate.testParse_12();
  }
  
  public void testParse_12_A() throws Exception {
    delegate.testParse_12_A();
  }
  
  public void testParse_12_A_A() throws Exception {
    delegate.testParse_12_A_A();
  }
  
  public void testParse_12_A_B() throws Exception {
    delegate.testParse_12_A_B();
  }
  
  public void testParse_12_A_B_A() throws Exception {
    delegate.testParse_12_A_B_A();
  }
  
  public void testParse_12_A_B_A_B() throws Exception {
    delegate.testParse_12_A_B_A_B();
  }
  
  public void testParse_12_A_B_B() throws Exception {
    delegate.testParse_12_A_B_B();
  }
  
  public void testParse_12_A_B_B_A() throws Exception {
    delegate.testParse_12_A_B_B_A();
  }
  
  public void testParse_12_B() throws Exception {
    delegate.testParse_12_B();
  }
  
  public void testParse_12_B_A() throws Exception {
    delegate.testParse_12_B_A();
  }
  
  public void testParse_12_B_A_A() throws Exception {
    delegate.testParse_12_B_A_A();
  }
  
  public void testParse_12_B_A_A_B() throws Exception {
    delegate.testParse_12_B_A_A_B();
  }
  
  public void testParse_12_B_A_B() throws Exception {
    delegate.testParse_12_B_A_B();
  }
  
  public void testParse_12_B_A_B_A() throws Exception {
    delegate.testParse_12_B_A_B_A();
  }
  
  public void testParse_12_B_B() throws Exception {
    delegate.testParse_12_B_B();
  }
  
  public void testParse_13() throws Exception {
    delegate.testParse_13();
  }
  
  public void testParse_13_A() throws Exception {
    delegate.testParse_13_A();
  }
  
  public void testParse_13_A_A() throws Exception {
    delegate.testParse_13_A_A();
  }
  
  public void testParse_13_A_B() throws Exception {
    delegate.testParse_13_A_B();
  }
  
  public void testParse_13_A_B_A() throws Exception {
    delegate.testParse_13_A_B_A();
  }
  
  public void testParse_13_A_B_A_B() throws Exception {
    delegate.testParse_13_A_B_A_B();
  }
  
  public void testParse_13_A_B_B() throws Exception {
    delegate.testParse_13_A_B_B();
  }
  
  public void testParse_13_A_B_B_A() throws Exception {
    delegate.testParse_13_A_B_B_A();
  }
  
  public void testParse_13_B() throws Exception {
    delegate.testParse_13_B();
  }
  
  public void testParse_13_B_A() throws Exception {
    delegate.testParse_13_B_A();
  }
  
  public void testParse_13_B_A_A() throws Exception {
    delegate.testParse_13_B_A_A();
  }
  
  public void testParse_13_B_A_A_B() throws Exception {
    delegate.testParse_13_B_A_A_B();
  }
  
  public void testParse_13_B_A_B() throws Exception {
    delegate.testParse_13_B_A_B();
  }
  
  public void testParse_13_B_A_B_A() throws Exception {
    delegate.testParse_13_B_A_B_A();
  }
  
  public void testParse_13_B_B() throws Exception {
    delegate.testParse_13_B_B();
  }
  
  public void testParse_14_A_B_C_D() throws Exception {
    delegate.testParse_14_A_B_C_D();
  }
  
  public void testParse_14_A_B_C_D_D_C_B_A() throws Exception {
    delegate.testParse_14_A_B_C_D_D_C_B_A();
  }
  
  public void testParse_14_A_B_C_D_D_C_B_A_B_A_C_D() throws Exception {
    delegate.testParse_14_A_B_C_D_D_C_B_A_B_A_C_D();
  }
  
  public void testParse_14_A_B_D_C() throws Exception {
    delegate.testParse_14_A_B_D_C();
  }
  
  public void testParse_14_B_A_C_D() throws Exception {
    delegate.testParse_14_B_A_C_D();
  }
  
  public void testParse_14_B_A_D_C() throws Exception {
    delegate.testParse_14_B_A_D_C();
  }
  
  public void testParse_14_C_D_A_B() throws Exception {
    delegate.testParse_14_C_D_A_B();
  }
  
  public void testParse_14_C_D_B_A() throws Exception {
    delegate.testParse_14_C_D_B_A();
  }
  
  public void testParse_14_D_C_A_B() throws Exception {
    delegate.testParse_14_D_C_A_B();
  }
  
  public void testParse_14_D_C_B_A() throws Exception {
    delegate.testParse_14_D_C_B_A();
  }
  
  public void testParse_1_A_B() throws Exception {
    delegate.testParse_1_A_B();
  }
  
  public void testParse_1_B_A() throws Exception {
    delegate.testParse_1_B_A();
  }
  
  public void testParse_2_A_A_C_B_D() throws Exception {
    delegate.testParse_2_A_A_C_B_D();
  }
  
  public void testParse_2_A_B_C_D() throws Exception {
    delegate.testParse_2_A_B_C_D();
  }
  
  public void testParse_2_A_B_D_C() throws Exception {
    delegate.testParse_2_A_B_D_C();
  }
  
  public void testParse_2_A_C_A_B_D() throws Exception {
    delegate.testParse_2_A_C_A_B_D();
  }
  
  public void testParse_2_A_C_B_A_D() throws Exception {
    delegate.testParse_2_A_C_B_A_D();
  }
  
  public void testParse_2_A_C_B_D() throws Exception {
    delegate.testParse_2_A_C_B_D();
  }
  
  public void testParse_2_A_C_B_D_A() throws Exception {
    delegate.testParse_2_A_C_B_D_A();
  }
  
  public void testParse_2_A_C_D_B() throws Exception {
    delegate.testParse_2_A_C_D_B();
  }
  
  public void testParse_2_A_D_B_C() throws Exception {
    delegate.testParse_2_A_D_B_C();
  }
  
  public void testParse_2_A_D_C_B() throws Exception {
    delegate.testParse_2_A_D_C_B();
  }
  
  public void testParse_3() throws Exception {
    delegate.testParse_3();
  }
  
  public void testParse_3_A() throws Exception {
    delegate.testParse_3_A();
  }
  
  public void testParse_3_A_B() throws Exception {
    delegate.testParse_3_A_B();
  }
  
  public void testParse_3_B() throws Exception {
    delegate.testParse_3_B();
  }
  
  public void testParse_3_B_A() throws Exception {
    delegate.testParse_3_B_A();
  }
  
  public void testParse_4() throws Exception {
    delegate.testParse_4();
  }
  
  public void testParse_4_A() throws Exception {
    delegate.testParse_4_A();
  }
  
  public void testParse_4_A_B() throws Exception {
    delegate.testParse_4_A_B();
  }
  
  public void testParse_4_B() throws Exception {
    delegate.testParse_4_B();
  }
  
  public void testParse_4_B_A() throws Exception {
    delegate.testParse_4_B_A();
  }
  
  public void testParse_5() throws Exception {
    delegate.testParse_5();
  }
  
  public void testParse_5_A() throws Exception {
    delegate.testParse_5_A();
  }
  
  public void testParse_5_A_B() throws Exception {
    delegate.testParse_5_A_B();
  }
  
  public void testParse_5_B() throws Exception {
    delegate.testParse_5_B();
  }
  
  public void testParse_5_B_A() throws Exception {
    delegate.testParse_5_B_A();
  }
  
  public void testParse_6() throws Exception {
    delegate.testParse_6();
  }
  
  public void testParse_6_A() throws Exception {
    delegate.testParse_6_A();
  }
  
  public void testParse_6_A_A() throws Exception {
    delegate.testParse_6_A_A();
  }
  
  public void testParse_6_A_A_B_B() throws Exception {
    delegate.testParse_6_A_A_B_B();
  }
  
  public void testParse_6_A_B() throws Exception {
    delegate.testParse_6_A_B();
  }
  
  public void testParse_6_B() throws Exception {
    delegate.testParse_6_B();
  }
  
  public void testParse_6_B_A() throws Exception {
    delegate.testParse_6_B_A();
  }
  
  public void testParse_6_B_B() throws Exception {
    delegate.testParse_6_B_B();
  }
  
  public void testParse_6_B_B_A_A() throws Exception {
    delegate.testParse_6_B_B_A_A();
  }
  
  public void testParse_7() throws Exception {
    delegate.testParse_7();
  }
  
  public void testParse_7_A() throws Exception {
    delegate.testParse_7_A();
  }
  
  public void testParse_7_A_A() throws Exception {
    delegate.testParse_7_A_A();
  }
  
  public void testParse_7_A_A_B_B() throws Exception {
    delegate.testParse_7_A_A_B_B();
  }
  
  public void testParse_7_A_B() throws Exception {
    delegate.testParse_7_A_B();
  }
  
  public void testParse_7_B() throws Exception {
    delegate.testParse_7_B();
  }
  
  public void testParse_7_B_A() throws Exception {
    delegate.testParse_7_B_A();
  }
  
  public void testParse_7_B_B() throws Exception {
    delegate.testParse_7_B_B();
  }
  
  public void testParse_7_B_B_A_A() throws Exception {
    delegate.testParse_7_B_B_A_A();
  }
  
  public void testParse_8_A_B_C_A_B_D() throws Exception {
    delegate.testParse_8_A_B_C_A_B_D();
  }
  
  public void testParse_8_A_B_D_A_B_C() throws Exception {
    delegate.testParse_8_A_B_D_A_B_C();
  }
  
  public void testParse_9() throws Exception {
    delegate.testParse_9();
  }
  
  public void testParse_9_A() throws Exception {
    delegate.testParse_9_A();
  }
  
  public void testParse_9_A_B() throws Exception {
    delegate.testParse_9_A_B();
  }
  
  public void testParse_9_A_B_A() throws Exception {
    delegate.testParse_9_A_B_A();
  }
  
  public void testParse_9_A_B_A_B() throws Exception {
    delegate.testParse_9_A_B_A_B();
  }
  
  public void testParse_9_A_B_B() throws Exception {
    delegate.testParse_9_A_B_B();
  }
  
  public void testParse_9_A_B_B_A() throws Exception {
    delegate.testParse_9_A_B_B_A();
  }
  
  public void testParse_9_B() throws Exception {
    delegate.testParse_9_B();
  }
  
  public void testParse_9_B_A() throws Exception {
    delegate.testParse_9_B_A();
  }
  
  public void testParse_9_B_A_A() throws Exception {
    delegate.testParse_9_B_A_A();
  }
  
  public void testParse_9_B_A_A_B() throws Exception {
    delegate.testParse_9_B_A_A_B();
  }
  
  public void testParse_9_B_A_B() throws Exception {
    delegate.testParse_9_B_A_B();
  }
  
  public void testParse_9_B_A_B_A() throws Exception {
    delegate.testParse_9_B_A_B_A();
  }
}
