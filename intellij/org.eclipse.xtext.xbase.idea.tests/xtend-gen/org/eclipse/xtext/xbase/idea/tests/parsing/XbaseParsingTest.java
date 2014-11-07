package org.eclipse.xtext.xbase.idea.tests.parsing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageASTFactory;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.ParsingTestCase;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import junit.framework.TestCase;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator;
import org.eclipse.xtext.idea.tests.TestDecorator;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;
import org.eclipse.xtext.xbase.idea.tests.parsing.NodeModelPrinter;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.parser.XbaseParserTest;

@TestDecorator
@SuppressWarnings("all")
public class XbaseParsingTest extends ParsingTestCase {
  private XbaseParserTest delegate = new XbaseParserTest() {
    protected XExpression expression(final CharSequence string) throws Exception {
      String _string = string.toString();
      return XbaseParsingTest.this.doExpression(_string, false);
    }
    
    protected XExpression expression(final CharSequence string, final boolean resolve) throws Exception {
      String _string = string.toString();
      return XbaseParsingTest.this.doExpression(_string, resolve);
    }
  };
  
  @Inject
  private InvariantChecker invariantChecker;
  
  @Inject
  private Provider<XtextResourceSet> xtextResourceSetProvider;
  
  @Inject
  private Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider;
  
  @Inject
  private ValidationTestHelper validationHelper;
  
  private NodeModelPrinter nodeModelPrinter = new NodeModelPrinter();
  
  public XbaseParsingTest() {
    super("", "___xbase", XbaseLanguage.INSTANCE.<ParserDefinition>getInstance(ParserDefinition.class));
    XbaseLanguage.INSTANCE.injectMembers(this);
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    ASTFactory _instance = XbaseLanguage.INSTANCE.<ASTFactory>getInstance(BaseXtextASTFactory.class);
    this.<ASTFactory>addExplicitExtension(LanguageASTFactory.INSTANCE, XbaseLanguage.INSTANCE, _instance);
  }
  
  @Override
  protected String getTestDataPath() {
    return "./testData/parsing";
  }
  
  @Override
  protected boolean skipSpaces() {
    return false;
  }
  
  @Override
  protected boolean includeRanges() {
    return true;
  }
  
  public XExpression doExpression(final String code, final boolean resolve) throws Exception {
    XExpression _xblockexpression = null;
    {
      super.doCodeTest(code);
      XtextResource expectedResource = this.getExpectedResource();
      IParseResult _parseResult = expectedResource.getParseResult();
      ICompositeNode expectedRootNode = _parseResult.getRootNode();
      XtextResource actualResource = this.getActualResource();
      IParseResult _parseResult_1 = actualResource.getParseResult();
      ICompositeNode actualRootNode = _parseResult_1.getRootNode();
      String _print = this.nodeModelPrinter.print(expectedRootNode);
      String _print_1 = this.nodeModelPrinter.print(actualRootNode);
      TestCase.assertEquals(_print, _print_1);
      EObject _semanticElement = expectedRootNode.getSemanticElement();
      String _objToStr = EmfFormatter.objToStr(_semanticElement);
      EObject _semanticElement_1 = actualRootNode.getSemanticElement();
      String _objToStr_1 = EmfFormatter.objToStr(_semanticElement_1);
      TestCase.assertEquals(_objToStr, _objToStr_1);
      this.invariantChecker.checkInvariant(actualRootNode);
      PsiToEcoreAdapter _get = PsiToEcoreAdapter.get(actualResource);
      Map<ASTNode, INode> nodesMapping = _get.getNodesMapping();
      Set<ASTNode> _keySet = nodesMapping.keySet();
      for (final ASTNode astNode : _keySet) {
        {
          INode node = nodesMapping.get(astNode);
          boolean belongsToTree = false;
          BidiTreeIterable<INode> _asTreeIterable = actualRootNode.getAsTreeIterable();
          for (final INode child : _asTreeIterable) {
            boolean _equals = Objects.equal(child, node);
            if (_equals) {
              belongsToTree = true;
            }
          }
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Node ");
          _builder.append(node, "");
          _builder.append(" is not a part of the tree");
          TestCase.assertTrue(_builder.toString(), belongsToTree);
        }
      }
      EList<EObject> _contents = actualResource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final XExpression expression = ((XExpression) _head);
      if (resolve) {
        this.validationHelper.assertNoErrors(expression);
      }
      _xblockexpression = expression;
    }
    return _xblockexpression;
  }
  
  protected XtextResource getActualResource() {
    PsiToEcoreTransformator psiToEcoreTransformator = this.psiToEcoreTransformatorProvider.get();
    psiToEcoreTransformator.setXtextFile(((BaseXtextFile) this.myFile));
    XtextResourceSet resourceSet = this.xtextResourceSetProvider.get();
    VirtualFile _virtualFile = this.myFile.getVirtualFile();
    String _url = _virtualFile.getUrl();
    URI _createURI = URI.createURI(_url);
    Resource _createResource = resourceSet.createResource(_createURI);
    XtextResource resource = ((XtextResource) _createResource);
    resource.setParser(psiToEcoreTransformator);
    try {
      byte[] _newByteArrayOfSize = new byte[0];
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_newByteArrayOfSize);
      resource.load(_byteArrayInputStream, null);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    PsiToEcoreAdapter _adapter = psiToEcoreTransformator.getAdapter();
    _adapter.install(resource);
    return resource;
  }
  
  protected XtextResource getExpectedResource() {
    XtextResourceSet resourceSet = this.xtextResourceSetProvider.get();
    VirtualFile _virtualFile = this.myFile.getVirtualFile();
    String _url = _virtualFile.getUrl();
    URI _createURI = URI.createURI(_url);
    Resource _createResource = resourceSet.createResource(_createURI);
    XtextResource resource = ((XtextResource) _createResource);
    try {
      String _text = this.myFile.getText();
      byte[] _bytes = _text.getBytes();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
      resource.load(_byteArrayInputStream, null);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        throw new RuntimeException(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return resource;
  }
  
  public void testAddition_1() throws Exception {
    delegate.testAddition_1();
  }
  
  public void testAddition_2() throws Exception {
    delegate.testAddition_2();
  }
  
  public void testAssignment_RightAssociativity() throws Exception {
    delegate.testAssignment_RightAssociativity();
  }
  
  public void testAssignments_00() throws Exception {
    delegate.testAssignments_00();
  }
  
  public void testBlockExpression_0() throws Exception {
    delegate.testBlockExpression_0();
  }
  
  public void testBlockExpression_1() throws Exception {
    delegate.testBlockExpression_1();
  }
  
  public void testBlockExpression_2() throws Exception {
    delegate.testBlockExpression_2();
  }
  
  public void testBlockExpression_3() throws Exception {
    delegate.testBlockExpression_3();
  }
  
  public void testBlockExpression_4() throws Exception {
    delegate.testBlockExpression_4();
  }
  
  public void testBlockExpression_5() throws Exception {
    delegate.testBlockExpression_5();
  }
  
  public void testBlockExpression_withVariableDeclaration_0() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_0();
  }
  
  public void testBlockExpression_withVariableDeclaration_1() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_1();
  }
  
  public void testBlockExpression_withVariableDeclaration_2() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_2();
  }
  
  public void testBlockExpression_withVariableDeclaration_3() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_3();
  }
  
  public void testBlockExpression_withVariableDeclaration_4() throws Exception {
    delegate.testBlockExpression_withVariableDeclaration_4();
  }
  
  public void testBooleanLiteral() throws Exception {
    delegate.testBooleanLiteral();
  }
  
  public void testCastedExpression() throws Exception {
    delegate.testCastedExpression();
  }
  
  public void testCastedExpression_1() throws Exception {
    delegate.testCastedExpression_1();
  }
  
  public void testCastedExpression_2() throws Exception {
    delegate.testCastedExpression_2();
  }
  
  public void testClosure_1() throws Exception {
    delegate.testClosure_1();
  }
  
  public void testClosure_2() throws Exception {
    delegate.testClosure_2();
  }
  
  public void testClosure_3() throws Exception {
    delegate.testClosure_3();
  }
  
  public void testClosure_4() throws Exception {
    delegate.testClosure_4();
  }
  
  public void testClosure_5() throws Exception {
    delegate.testClosure_5();
  }
  
  public void testClosure_6() throws Exception {
    delegate.testClosure_6();
  }
  
  public void testConstructorCall_0() throws Exception {
    delegate.testConstructorCall_0();
  }
  
  public void testConstructorCall_1() throws Exception {
    delegate.testConstructorCall_1();
  }
  
  public void testConstructorCall_2() throws Exception {
    delegate.testConstructorCall_2();
  }
  
  public void testDoWhileExpression() throws Exception {
    delegate.testDoWhileExpression();
  }
  
  public void testExclusiveRange() throws Exception {
    delegate.testExclusiveRange();
  }
  
  public void testFeatureCall_0() throws Exception {
    delegate.testFeatureCall_0();
  }
  
  public void testFeatureCall_1() throws Exception {
    delegate.testFeatureCall_1();
  }
  
  public void testFeatureCall_2() throws Exception {
    delegate.testFeatureCall_2();
  }
  
  public void testFeatureCall_3() throws Exception {
    delegate.testFeatureCall_3();
  }
  
  public void testFeatureCall_4() throws Exception {
    delegate.testFeatureCall_4();
  }
  
  public void testFeatureCall_5() throws Exception {
    delegate.testFeatureCall_5();
  }
  
  public void testForLoopExpression() throws Exception {
    delegate.testForLoopExpression();
  }
  
  public void testForLoopExpression_1() throws Exception {
    delegate.testForLoopExpression_1();
  }
  
  public void testIfWithAdd() throws Exception {
    delegate.testIfWithAdd();
  }
  
  public void testIfWithAdd_2() throws Exception {
    delegate.testIfWithAdd_2();
  }
  
  public void testIfWithClosure() throws Exception {
    delegate.testIfWithClosure();
  }
  
  public void testIf_0() throws Exception {
    delegate.testIf_0();
  }
  
  public void testIf_1() throws Exception {
    delegate.testIf_1();
  }
  
  public void testIf_2() throws Exception {
    delegate.testIf_2();
  }
  
  public void testIf_3() throws Exception {
    delegate.testIf_3();
  }
  
  public void testInstanceOf() throws Exception {
    delegate.testInstanceOf();
  }
  
  public void testInstanceOf_1() throws Exception {
    delegate.testInstanceOf_1();
  }
  
  public void testMemberFeatureCall_00() throws Exception {
    delegate.testMemberFeatureCall_00();
  }
  
  public void testMemberFeatureCall_01() throws Exception {
    delegate.testMemberFeatureCall_01();
  }
  
  public void testOrAndAndPrecedence() throws Exception {
    delegate.testOrAndAndPrecedence();
  }
  
  public void testReturnExpressionInBlock_1() throws Exception {
    delegate.testReturnExpressionInBlock_1();
  }
  
  public void testReturnExpressionInBlock_2() throws Exception {
    delegate.testReturnExpressionInBlock_2();
  }
  
  public void testReturnExpressionInBlock_3() throws Exception {
    delegate.testReturnExpressionInBlock_3();
  }
  
  public void testShortClosure_1() throws Exception {
    delegate.testShortClosure_1();
  }
  
  public void testShortClosure_2() throws Exception {
    delegate.testShortClosure_2();
  }
  
  public void testShortClosure_3() throws Exception {
    delegate.testShortClosure_3();
  }
  
  public void testStaticFeatureCall_0() throws Exception {
    delegate.testStaticFeatureCall_0();
  }
  
  public void testStaticFeatureCall_1() throws Exception {
    delegate.testStaticFeatureCall_1();
  }
  
  public void testStaticFeatureCall_2() throws Exception {
    delegate.testStaticFeatureCall_2();
  }
  
  public void testStaticFeatureCall_3() throws Exception {
    delegate.testStaticFeatureCall_3();
  }
  
  public void testStaticFeatureCall_4() throws Exception {
    delegate.testStaticFeatureCall_4();
  }
  
  public void testStaticFeatureCall_5() throws Exception {
    delegate.testStaticFeatureCall_5();
  }
  
  public void testStringLiteral() throws Exception {
    delegate.testStringLiteral();
  }
  
  public void testSwitch_0() throws Exception {
    delegate.testSwitch_0();
  }
  
  public void testSwitch_1() throws Exception {
    delegate.testSwitch_1();
  }
  
  public void testSwitch_2() throws Exception {
    delegate.testSwitch_2();
  }
  
  public void testThrowExpression() throws Exception {
    delegate.testThrowExpression();
  }
  
  public void testTryCatchExpression() throws Exception {
    delegate.testTryCatchExpression();
  }
  
  public void testTryCatchExpression_1() throws Exception {
    delegate.testTryCatchExpression_1();
  }
  
  public void testTryCatchExpression_2() throws Exception {
    delegate.testTryCatchExpression_2();
  }
  
  public void testTryCatchExpression_3() throws Exception {
    delegate.testTryCatchExpression_3();
  }
  
  public void testTypeLiteral() throws Exception {
    delegate.testTypeLiteral();
  }
  
  public void testUnaryOperation() throws Exception {
    delegate.testUnaryOperation();
  }
  
  public void testUnaryOperation_2() throws Exception {
    delegate.testUnaryOperation_2();
  }
  
  public void testUnaryOperation_3() throws Exception {
    delegate.testUnaryOperation_3();
  }
  
  public void testWhileExpression() throws Exception {
    delegate.testWhileExpression();
  }
}
