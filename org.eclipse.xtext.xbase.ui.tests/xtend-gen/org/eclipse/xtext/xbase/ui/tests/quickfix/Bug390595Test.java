package org.eclipse.xtext.xbase.ui.tests.quickfix;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.tests.quickfix.AbstractXbaseQuickfixTest;
import org.eclipse.xtext.xbase.ui.tests.quickfix.TestIssueModificationContext;
import org.junit.Test;

@SuppressWarnings("all")
public class Bug390595Test extends AbstractXbaseQuickfixTest {
  @Inject
  private IResourceValidator resourceValidator;
  
  @Inject
  private DefaultQuickfixProvider quickfixProvider;
  
  @Inject
  private TestIssueModificationContext modificationContext;
  
  @Inject
  private XtextDocument document;
  
  @Test
  public void testNoExceptionDuringResolutionCreation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val n = newHashSet ( )");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("val m = newHashSet ( )");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if ( n < m ) { }");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    final String code = _builder.toString();
    StringInputStream _stringInputStream = new StringInputStream(code);
    final XtextResource resource = this.getResourceFor(_stringInputStream);
    this.modificationContext.setDocument(this.getDocument(resource, code));
    final Issue issue = IterableExtensions.<Issue>head(this.resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl));
    IterableExtensions.<IssueResolution>head(this.quickfixProvider.getResolutionsForLinkingIssue(issue));
  }
  
  public XtextDocument getDocument(final XtextResource xtextResource, final String code) {
    XtextDocument _xblockexpression = null;
    {
      this.document.setInput(xtextResource);
      this.document.set(code);
      ResourceSet _resourceSet = xtextResource.getResourceSet();
      ((XtextResourceSet) _resourceSet).markSynced();
      _xblockexpression = this.document;
    }
    return _xblockexpression;
  }
}
