package org.eclipse.xtext.xbase.ui.tests.quickfix;

import com.google.inject.Singleton;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;

@Singleton
@SuppressWarnings("all")
public class TestIssueModificationContext extends IssueModificationContext {
  private IXtextDocument doc;
  
  public IXtextDocument getXtextDocument() {
    return this.doc;
  }
  
  public IXtextDocument setDocument(final IXtextDocument doc) {
    return this.doc = doc;
  }
}
