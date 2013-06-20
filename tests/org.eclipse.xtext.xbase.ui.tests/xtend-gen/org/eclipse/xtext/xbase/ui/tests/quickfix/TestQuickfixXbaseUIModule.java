package org.eclipse.xtext.xbase.ui.tests.quickfix;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.xbase.ui.XbaseUiModule;
import org.eclipse.xtext.xbase.ui.tests.quickfix.TestIssueModificationContext;

@SuppressWarnings("all")
public class TestQuickfixXbaseUIModule extends XbaseUiModule {
  public TestQuickfixXbaseUIModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
  
  public Class<? extends IssueModificationContext> bindIssueModificationContext() {
    return TestIssueModificationContext.class;
  }
}
