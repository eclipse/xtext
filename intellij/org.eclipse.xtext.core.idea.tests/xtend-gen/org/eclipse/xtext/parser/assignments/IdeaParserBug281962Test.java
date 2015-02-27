package org.eclipse.xtext.parser.assignments;

import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.idea.tests.parsing.AbstractLanguageParsingTestCase;
import org.eclipse.xtext.parser.assignments.IdeaParserBug281962TestDelegate;
import org.eclipse.xtext.parser.assignments.idea.lang.AssignmentsTestLanguageFileType;

@TestDecorator
@SuppressWarnings("all")
public class IdeaParserBug281962Test extends AbstractLanguageParsingTestCase {
  private IdeaParserBug281962TestDelegate delegate;
  
  public IdeaParserBug281962Test() {
    super(AssignmentsTestLanguageFileType.INSTANCE);
    IdeaParserBug281962TestDelegate _ideaParserBug281962TestDelegate = new IdeaParserBug281962TestDelegate(this);
    this.delegate = _ideaParserBug281962TestDelegate;
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
