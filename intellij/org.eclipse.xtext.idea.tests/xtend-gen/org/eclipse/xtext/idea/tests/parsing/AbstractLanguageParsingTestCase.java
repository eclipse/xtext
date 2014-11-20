package org.eclipse.xtext.idea.tests.parsing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageASTFactory;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.fileTypes.LanguageFileType;
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
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.idea.tests.parsing.NodeModelPrinter;
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
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractLanguageParsingTestCase extends ParsingTestCase implements ModelChecker {
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Extension
  private NodeModelPrinter nodeModelPrinter;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Extension
  private InvariantChecker invariantChecker;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private Provider<XtextResourceSet> xtextResourceSetProvider;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private Provider<PsiToEcoreTransformator> psiToEcoreTransformatorProvider;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private XtextResource actualResource;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private XtextResource expectedResource;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private BaseXtextASTFactory astFactory;
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  private ValidationTestHelper validationHelper;
  
  protected void setUp() throws Exception {
    super.setUp();
    this.<ASTFactory>addExplicitExtension(LanguageASTFactory.INSTANCE, this.myLanguage, this.astFactory);
  }
  
  protected void tearDown() throws Exception {
    super.tearDown();
    this.actualResource = null;
    this.expectedResource = null;
  }
  
  public AbstractLanguageParsingTestCase(final LanguageFileType fileType) {
    this("", fileType);
  }
  
  public AbstractLanguageParsingTestCase(final String dataPath, final LanguageFileType fileType) {
    this(dataPath, fileType.getDefaultExtension(), ((IXtextLanguage) fileType.getLanguage()));
  }
  
  public AbstractLanguageParsingTestCase(final String fileExt, final IXtextLanguage language) {
    this("", fileExt, language.<ParserDefinition>getInstance(ParserDefinition.class));
  }
  
  public AbstractLanguageParsingTestCase(final String dataPath, final String fileExt, final IXtextLanguage language) {
    super(dataPath, fileExt, language.<ParserDefinition>getInstance(ParserDefinition.class));
    language.injectMembers(this);
  }
  
  public AbstractLanguageParsingTestCase(final String dataPath, final String fileExt, final ParserDefinition... definitions) {
    super(dataPath, fileExt, definitions);
  }
  
  public AbstractLanguageParsingTestCase(final String dataPath, final String fileExt, final boolean lowercaseFirstLetter, final ParserDefinition... definitions) {
    super(dataPath, fileExt, lowercaseFirstLetter, definitions);
  }
  
  public <T extends EObject> T checkModel(final String code, final boolean validate) {
    try {
      T _xblockexpression = null;
      {
        this.doCodeTest(code);
        EList<EObject> _contents = this.actualResource.getContents();
        EObject _head = IterableExtensions.<EObject>head(_contents);
        final T model = ((T) _head);
        if (validate) {
          this.validationHelper.assertNoErrors(model);
        }
        _xblockexpression = model;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean includeRanges() {
    return true;
  }
  
  protected void doTest(final boolean checkResult) {
    super.doTest(checkResult);
    if (checkResult) {
      this.assertResource();
    }
  }
  
  protected void doCodeTest(final String code) throws IOException {
    super.doCodeTest(code);
    this.assertResource();
  }
  
  protected void assertResource() {
    XtextResource _createActualResource = this.createActualResource();
    this.actualResource = _createActualResource;
    XtextResource _createExpectedResource = this.createExpectedResource();
    this.expectedResource = _createExpectedResource;
    IParseResult _parseResult = this.expectedResource.getParseResult();
    final ICompositeNode expectedRootNode = _parseResult.getRootNode();
    IParseResult _parseResult_1 = this.actualResource.getParseResult();
    final ICompositeNode actualRootNode = _parseResult_1.getRootNode();
    String _print = this.nodeModelPrinter.print(expectedRootNode);
    String _print_1 = this.nodeModelPrinter.print(actualRootNode);
    TestCase.assertEquals(_print, _print_1);
    EObject _semanticElement = expectedRootNode.getSemanticElement();
    String _objToStr = EmfFormatter.objToStr(_semanticElement);
    EObject _semanticElement_1 = actualRootNode.getSemanticElement();
    String _objToStr_1 = EmfFormatter.objToStr(_semanticElement_1);
    TestCase.assertEquals(_objToStr, _objToStr_1);
    this.invariantChecker.checkInvariant(actualRootNode);
    PsiToEcoreAdapter _get = PsiToEcoreAdapter.get(this.actualResource);
    final Map<ASTNode, INode> nodesMapping = _get.getNodesMapping();
    Set<ASTNode> _keySet = nodesMapping.keySet();
    for (final ASTNode astNode : _keySet) {
      {
        final INode node = nodesMapping.get(astNode);
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
  }
  
  protected XtextResource createActualResource() {
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
  
  protected XtextResource createExpectedResource() {
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
  
  @Pure
  protected NodeModelPrinter getNodeModelPrinter() {
    return this.nodeModelPrinter;
  }
  
  @Pure
  protected InvariantChecker getInvariantChecker() {
    return this.invariantChecker;
  }
  
  @Pure
  protected Provider<XtextResourceSet> getXtextResourceSetProvider() {
    return this.xtextResourceSetProvider;
  }
  
  @Pure
  protected Provider<PsiToEcoreTransformator> getPsiToEcoreTransformatorProvider() {
    return this.psiToEcoreTransformatorProvider;
  }
  
  @Pure
  protected XtextResource getActualResource() {
    return this.actualResource;
  }
  
  @Pure
  protected XtextResource getExpectedResource() {
    return this.expectedResource;
  }
  
  @Pure
  protected BaseXtextASTFactory getAstFactory() {
    return this.astFactory;
  }
  
  @Pure
  protected ValidationTestHelper getValidationHelper() {
    return this.validationHelper;
  }
}
