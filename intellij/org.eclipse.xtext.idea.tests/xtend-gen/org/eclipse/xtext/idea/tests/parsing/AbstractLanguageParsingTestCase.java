/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.tests.parsing;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lang.ASTFactory;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageASTFactory;
import com.intellij.lang.ParserDefinition;
import com.intellij.mock.MockApplicationEx;
import com.intellij.mock.MockEditorFactory;
import com.intellij.mock.MockFileDocumentManagerImpl;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.impl.DocumentImpl;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.impl.FileDocumentManagerImpl;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.testFramework.PlatformLiteFixture;
import com.intellij.util.Function;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.idea.lang.BaseXtextASTFactory;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.lang.LanguageSetup;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformator;
import org.eclipse.xtext.idea.tests.parsing.ModelChecker;
import org.eclipse.xtext.idea.tests.parsing.NodeModelPrinter;
import org.eclipse.xtext.idea.tests.parsing.XtextResourceAsserts;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.picocontainer.MutablePicoContainer;

@SuppressWarnings("all")
public abstract class AbstractLanguageParsingTestCase extends ParsingTestCase implements ModelChecker {
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
  
  @Inject
  @Accessors(AccessorType.PROTECTED_GETTER)
  @Extension
  private XtextResourceAsserts xtextResourceAsserts;
  
  @Inject
  private ParserDefinition parserDefinition;
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    ISetup _setup = this.getSetup();
    this.<ISetup>addExplicitExtension(LanguageSetup.INSTANCE, this.myLanguage, _setup);
    IXtextLanguage _xtextLanguage = this.getXtextLanguage();
    _xtextLanguage.injectMembers(this);
    this.configureFromParserDefinition(this.parserDefinition, this.myFileExt);
    this.<ASTFactory>addExplicitExtension(LanguageASTFactory.INSTANCE, this.myLanguage, this.astFactory);
    MockApplicationEx _application = PlatformLiteFixture.getApplication();
    final MutablePicoContainer appContainer = _application.getPicoContainer();
    appContainer.unregisterComponent(EditorFactory.class);
    appContainer.unregisterComponent(FileDocumentManager.class);
    final MockEditorFactory editorFactory = new MockEditorFactory() {
      @Override
      public Document createDocument(final CharSequence text) {
        return new DocumentImpl(text, true, false);
      }
    };
    appContainer.registerComponentInstance(EditorFactory.class, editorFactory);
    final Function<CharSequence, Document> _function = new Function<CharSequence, Document>() {
      @Override
      public Document fun(final CharSequence charSequence) {
        return editorFactory.createDocument(charSequence);
      }
    };
    MockFileDocumentManagerImpl _mockFileDocumentManagerImpl = new MockFileDocumentManagerImpl(_function, FileDocumentManagerImpl.HARD_REF_TO_DOCUMENT_KEY);
    appContainer.registerComponentInstance(FileDocumentManager.class, _mockFileDocumentManagerImpl);
    NodeModelPrinter _nodeModelPrinter = this.xtextResourceAsserts.getNodeModelPrinter();
    _nodeModelPrinter.setIgnoreSyntaxErrors(false);
  }
  
  @Override
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
    this("", fileExt, language);
  }
  
  public AbstractLanguageParsingTestCase(final String dataPath, final String fileExt, final IXtextLanguage language) {
    super(dataPath, fileExt);
    this.myLanguage = ((Language) language);
  }
  
  protected IXtextLanguage getXtextLanguage() {
    return ((IXtextLanguage) this.myLanguage);
  }
  
  protected abstract ISetup getSetup();
  
  @Override
  public XtextResource checkResource(final String code, final boolean validate) {
    try {
      XtextResource _xblockexpression = null;
      {
        this.doCodeTest(code);
        if (validate) {
          this.validationHelper.assertNoErrors(this.actualResource);
        }
        _xblockexpression = this.actualResource;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
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
  
  @Override
  public <T extends EObject> T checkModel(final String path, final String code, final boolean validate) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  protected boolean includeRanges() {
    return true;
  }
  
  @Override
  protected void doTest(final boolean checkResult) {
    super.doTest(checkResult);
    if (checkResult) {
      this.assertResource();
    }
  }
  
  @Override
  protected void doCodeTest(final String code) throws IOException {
    super.doCodeTest(code);
    this.assertResource();
  }
  
  protected void assertResource() {
    XtextResource _createActualResource = this.createActualResource();
    this.actualResource = _createActualResource;
    XtextResource _createExpectedResource = this.createExpectedResource();
    this.expectedResource = _createExpectedResource;
    this.xtextResourceAsserts.assertResource(this.expectedResource, this.actualResource, false);
  }
  
  protected XtextResource createActualResource() {
    XtextResource _xblockexpression = null;
    {
      PsiToEcoreTransformator _get = this.psiToEcoreTransformatorProvider.get();
      final Procedure1<PsiToEcoreTransformator> _function = new Procedure1<PsiToEcoreTransformator>() {
        @Override
        public void apply(final PsiToEcoreTransformator it) {
          it.setXtextFile(((BaseXtextFile) AbstractLanguageParsingTestCase.this.myFile));
        }
      };
      final PsiToEcoreTransformator psiToEcoreTransformator = ObjectExtensions.<PsiToEcoreTransformator>operator_doubleArrow(_get, _function);
      VirtualFile _virtualFile = this.myFile.getVirtualFile();
      String _url = _virtualFile.getUrl();
      final URI uri = URI.createURI(_url);
      XtextResourceSet _createFreshResourceSet = this.createFreshResourceSet();
      Resource _createResource = _createFreshResourceSet.createResource(uri);
      final Procedure1<XtextResource> _function_1 = new Procedure1<XtextResource>() {
        @Override
        public void apply(final XtextResource it) {
          try {
            it.setParser(psiToEcoreTransformator);
            byte[] _newByteArrayOfSize = new byte[0];
            ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_newByteArrayOfSize);
            it.load(_byteArrayInputStream, null);
            PsiToEcoreAdapter _adapter = psiToEcoreTransformator.getAdapter();
            _adapter.attachToEmfObject(it);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      _xblockexpression = ObjectExtensions.<XtextResource>operator_doubleArrow(
        ((XtextResource) _createResource), _function_1);
    }
    return _xblockexpression;
  }
  
  public XtextResourceSet createFreshResourceSet() {
    XtextResourceSet resourceSet = this.xtextResourceSetProvider.get();
    Map<String, ResourceDescriptionsData> _emptyMap = CollectionLiterals.<String, ResourceDescriptionsData>emptyMap();
    new ChunkedResourceDescriptions(_emptyMap, resourceSet);
    ProjectDescription _projectDescription = new ProjectDescription();
    final Procedure1<ProjectDescription> _function = new Procedure1<ProjectDescription>() {
      @Override
      public void apply(final ProjectDescription it) {
        it.setName("parsing-test-project");
      }
    };
    final ProjectDescription project = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
    project.attachToEmfObject(resourceSet);
    return resourceSet;
  }
  
  protected XtextResource createExpectedResource() {
    XtextResource _xblockexpression = null;
    {
      XtextResourceSet resourceSet = this.createFreshResourceSet();
      VirtualFile _virtualFile = this.myFile.getVirtualFile();
      String _url = _virtualFile.getUrl();
      final URI uri = URI.createURI(_url);
      Resource _createResource = resourceSet.createResource(uri);
      final Procedure1<XtextResource> _function = new Procedure1<XtextResource>() {
        @Override
        public void apply(final XtextResource it) {
          try {
            String _text = AbstractLanguageParsingTestCase.this.myFile.getText();
            byte[] _bytes = _text.getBytes();
            ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
            it.load(_byteArrayInputStream, null);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      _xblockexpression = ObjectExtensions.<XtextResource>operator_doubleArrow(
        ((XtextResource) _createResource), _function);
    }
    return _xblockexpression;
  }
  
  @Override
  protected String loadFile(final String name) throws IOException {
    File _file = new File(this.myFullDataPath, name);
    return FileUtil.loadFile(_file, CharsetToolkit.UTF8, true);
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
  
  @Pure
  protected XtextResourceAsserts getXtextResourceAsserts() {
    return this.xtextResourceAsserts;
  }
}
