
package org.eclipse.xtext.xbase.ui.quickfix;

import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.inject.Inject;

public class XbaseQuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	private OrganizeImportsHandler organizeImportsHandler;

	@Fix(IssueCodes.IMPORT_DUPLICATE)
	public void fixDuplicateImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.IMPORT_UNUSED)
	public void fixUnusedImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	protected void organizeImports(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Organize Imports.",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				"fix_indent.gif", new IModification() {
					public void apply(IModificationContext context) throws Exception {
						organizeImportsHandler.doOrganizeImports(context.getXtextDocument());
					}
				});
	}

}
