/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.junit.Assert;

/**
 * @author miklossy - Initial contribution and API
 * @since 2.16
 */
@SuppressWarnings("all")
public abstract class AbstractQuickfixTest extends AbstractEditorTest {
  private static class TestModificationContext implements IModificationContext {
    private IXtextDocument doc;
    
    @Override
    public IXtextDocument getXtextDocument() {
      return this.doc;
    }
    
    @Override
    public IXtextDocument getXtextDocument(final URI uri) {
      return this.doc;
    }
    
    public IXtextDocument setDocument(final IXtextDocument doc) {
      return this.doc = doc;
    }
  }
  
  @Data
  protected static class Quickfix {
    private final String label;
    
    private final String description;
    
    private final String result;
    
    public Quickfix(final String label, final String description, final String result) {
      super();
      this.label = label;
      this.description = description;
      this.result = result;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.label== null) ? 0 : this.label.hashCode());
      result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
      return prime * result + ((this.result== null) ? 0 : this.result.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      AbstractQuickfixTest.Quickfix other = (AbstractQuickfixTest.Quickfix) obj;
      if (this.label == null) {
        if (other.label != null)
          return false;
      } else if (!this.label.equals(other.label))
        return false;
      if (this.description == null) {
        if (other.description != null)
          return false;
      } else if (!this.description.equals(other.description))
        return false;
      if (this.result == null) {
        if (other.result != null)
          return false;
      } else if (!this.result.equals(other.result))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("label", this.label);
      b.add("description", this.description);
      b.add("result", this.result);
      return b.toString();
    }
    
    @Pure
    public String getLabel() {
      return this.label;
    }
    
    @Pure
    public String getDescription() {
      return this.description;
    }
    
    @Pure
    public String getResult() {
      return this.result;
    }
  }
  
  @Inject
  protected Injector injector;
  
  @Inject
  protected XtextEditorInfo editorInfo;
  
  @Inject
  protected IResourceSetProvider resourceSetProvider;
  
  @Inject
  @Extension
  protected SyncUtil _syncUtil;
  
  @Inject
  @Extension
  protected IResourceValidator _iResourceValidator;
  
  @Inject
  @Extension
  protected FileExtensionProvider _fileExtensionProvider;
  
  @Inject
  @Extension
  protected IssueResolutionProvider _issueResolutionProvider;
  
  protected IProject project;
  
  @Override
  protected String getEditorId() {
    return this.editorInfo.getEditorId();
  }
  
  /**
   * Test that the expected quickfixes are offered on a given validation issue in a given DSL text.
   * 
   * @param it The initial DSL text.
   * @param issueCode The code of the validation issue to that the offered quickfixes are to test.
   * @param quickfixes The quickfixes that are expected to be offered on the given <code>issueCode</code>.
   * Each expected quickfix should be described by the following triple:
   * <ol>
   * 	<li>the quickfix label</li>
   * 	<li>the quickfix description</li>
   * 	<li>the DSL text after the quickfix application</li>
   * </ol>
   */
  public void testQuickfixesOn(final CharSequence it, final String issueCode, final AbstractQuickfixTest.Quickfix... quickfixes) {
    this.quickfixesAreOffered(this.openInEditor(this.dslFile(it)), issueCode, quickfixes);
  }
  
  protected IFile dslFile(final CharSequence content) {
    try {
      IFile _xblockexpression = null;
      {
        final IFile file = IResourcesSetupUtil.createFile(this.getProjectName(), this.getFileName(), this.getFileExtension(), content.toString());
        this.project = file.getProject();
        boolean _hasNature = this.project.hasNature(XtextProjectHelper.NATURE_ID);
        boolean _not = (!_hasNature);
        if (_not) {
          IResourcesSetupUtil.addNature(this.project, XtextProjectHelper.NATURE_ID);
        }
        _xblockexpression = file;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String getProjectName() {
    return "QuickfixTestProject";
  }
  
  protected String getFileName() {
    return "quickfix";
  }
  
  protected String getFileExtension() {
    return this._fileExtensionProvider.getPrimaryFileExtension();
  }
  
  protected XtextEditor openInEditor(final IFile dslFile) {
    try {
      XtextEditor _xblockexpression = null;
      {
        this._syncUtil.waitForBuild(new NullProgressMonitor());
        _xblockexpression = this.openEditor(dslFile);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void quickfixesAreOffered(final XtextEditor editor, final String issueCode, final AbstractQuickfixTest.Quickfix... expected) {
    final IXtextDocument document = editor.getDocument();
    final String originalText = document.get();
    final Issue issue = this.getValidationIssue(document, issueCode);
    final List<IssueResolution> actualIssueResolutions = this._issueResolutionProvider.getResolutions(issue);
    Assert.assertEquals("The number of quickfixes does not match!", ((List<AbstractQuickfixTest.Quickfix>)Conversions.doWrapArray(expected)).size(), actualIssueResolutions.size());
    int _size = actualIssueResolutions.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final IssueResolution actualIssueResolution = actualIssueResolutions.get((i).intValue());
        final AbstractQuickfixTest.Quickfix expectedIssueResolution = expected[(i).intValue()];
        Assert.assertEquals(expectedIssueResolution.label, actualIssueResolution.getLabel());
        Assert.assertEquals(expectedIssueResolution.description, actualIssueResolution.getDescription());
        this.assertIssueResolutionResult(expectedIssueResolution.result, actualIssueResolution, originalText);
      }
    }
  }
  
  protected Issue getValidationIssue(final IXtextDocument document, final String issueCode) {
    Issue _xblockexpression = null;
    {
      final IUnitOfWork<List<Issue>, XtextResource> _function = (XtextResource it) -> {
        return this._iResourceValidator.validate(it, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
      };
      final List<Issue> issues = document.<List<Issue>>readOnly(_function);
      final Function1<Issue, Boolean> _function_1 = (Issue it) -> {
        String _code = it.getCode();
        return Boolean.valueOf(Objects.equal(_code, issueCode));
      };
      final Iterable<Issue> issueCandidates = IterableExtensions.<Issue>filter(issues, _function_1);
      Assert.assertEquals((("There should be one \'" + issueCode) + "\' validation issue!"), 1, IterableExtensions.size(issueCandidates));
      _xblockexpression = IterableExtensions.<Issue>head(issueCandidates);
    }
    return _xblockexpression;
  }
  
  protected void assertIssueResolutionResult(final String expectedResult, final IssueResolution actualIssueResolution, final String originalText) {
    final IXtextDocument document = this.getDocument(originalText);
    final AbstractQuickfixTest.TestModificationContext modificationContext = new AbstractQuickfixTest.TestModificationContext();
    modificationContext.setDocument(document);
    String _label = actualIssueResolution.getLabel();
    String _description = actualIssueResolution.getDescription();
    String _image = actualIssueResolution.getImage();
    IModification _modification = actualIssueResolution.getModification();
    int _relevance = actualIssueResolution.getRelevance();
    new IssueResolution(_label, _description, _image, modificationContext, _modification, _relevance).apply();
    final String actualResult = document.get();
    Assert.assertEquals(expectedResult, actualResult);
  }
  
  /**
   * The implementation of the following helper methods are taken from the
   * org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder class.
   */
  protected IXtextDocument getDocument(final String model) {
    XtextDocument _xblockexpression = null;
    {
      final XtextResource xtextResource = this.getXtextResource(model);
      final XtextDocument document = this.injector.<XtextDocument>getInstance(XtextDocument.class);
      document.set(model);
      document.setInput(xtextResource);
      _xblockexpression = document;
    }
    return _xblockexpression;
  }
  
  protected XtextResource getXtextResource(final String model) {
    try {
      XtextResource _xblockexpression = null;
      {
        String _emptyIfNull = Strings.emptyIfNull(model);
        final StringInputStream in = new StringInputStream(_emptyIfNull);
        final URI uri = URI.createURI("");
        final ResourceSet rs = this.resourceSetProvider.get(this.project);
        final Resource resource = this.injector.<IResourceFactory>getInstance(IResourceFactory.class).createResource(uri);
        EList<Resource> _resources = rs.getResources();
        _resources.add(resource);
        resource.load(in, null);
        if ((resource instanceof LazyLinkingResource)) {
          ((LazyLinkingResource)resource).resolveLazyCrossReferences(CancelIndicator.NullImpl);
        } else {
          EcoreUtil.resolveAll(resource);
        }
        _xblockexpression = ((XtextResource) resource);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
