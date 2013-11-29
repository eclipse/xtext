
package org.eclipse.xtext.xbase.ui.quickfix;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.quickfix.ReplaceModification;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler;
import org.eclipse.xtext.xbase.validation.IssueCodes;

import com.google.inject.Inject;

public class XbaseQuickfixProvider extends DefaultQuickfixProvider {

	@Inject
	private OrganizeImportsHandler organizeImportsHandler;

	@Inject
	protected JavaTypeQuickfixes javaTypeQuickfixes;
	
	@Inject
	private CreateJavaTypeQuickfixes createJavaTypeQuickfixes;
	
	@Fix(IssueCodes.IMPORT_DUPLICATE)
	public void fixDuplicateImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.IMPORT_UNUSED)
	public void fixUnusedImport(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.IMPORT_WILDCARD_DEPRECATED)
	public void fixDuplicateWildcardUse(final Issue issue, IssueResolutionAcceptor acceptor) {
		organizeImports(issue, acceptor);
	}

	@Fix(IssueCodes.AMBIGUOUS_FEATURE_CALL)
	public void fixAmbiguousMethodCall(final Issue issue, IssueResolutionAcceptor acceptor) {
		String[] data = issue.getData();
		if (data == null || data.length == 0) {
			return;
		}
		for (String replacement : data) {
			String replaceLabel = "Change to '" + replacement + "'";
			acceptor.accept(issue, replaceLabel, replaceLabel, null, new ReplaceModification(issue, replacement));
		}
	}

	protected void organizeImports(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Organize imports",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				getOrganizeImportsImage(), new IModification() {
					public void apply(IModificationContext context) throws Exception {
						organizeImportsHandler.doOrganizeImports(context.getXtextDocument());
					}
				});
	}

	protected String getOrganizeImportsImage() {
		return "impc_obj.gif";
	}

	/**
	 * Filter quickfixes for types and constructors.
	 */
	@Override
	public void createLinkingIssueResolutions(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		final IModificationContext modificationContext = getModificationContextFactory().createModificationContext(
				issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if (xtextDocument != null) {
			xtextDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					try {
						EObject target = state.getEObject(issue.getUriToProblem().fragment());
						EReference reference = getUnresolvedEReference(issue, target);
						if(reference != null && reference.getEReferenceType() != null) 
							createLinkingIssueQuickfixes(
									issue,
									issueResolutionAcceptor,
									xtextDocument,
									state,
									target,
									reference);
					} catch(WrappedException e) {
						// issue information seems to be out of sync, e.g. there is no
						// EObject with the given fragment
						return;
					}
				}
			});
		}
	}

	protected void createLinkingIssueQuickfixes(Issue issue, IssueResolutionAcceptor issueResolutionAcceptor, 
			IXtextDocument xtextDocument,
			XtextResource state, EObject target, EReference reference) throws Exception {
		javaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, state, target, reference);
		createJavaTypeQuickfixes.addQuickfixes(issue, issueResolutionAcceptor, xtextDocument, state, target, reference);
	}
	
	@Override
	protected EReference getUnresolvedEReference(Issue issue, EObject target) {
		EReference unresolvedEReference = super.getUnresolvedEReference(issue, target);
		if(unresolvedEReference == null && target instanceof XConstructorCall)
			return XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
		else 
			return unresolvedEReference;
	}
}
