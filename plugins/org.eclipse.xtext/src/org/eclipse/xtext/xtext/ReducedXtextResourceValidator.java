package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.XtextLinkingDiagnostic;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;

/**
 * This resource validator for xtext grammars only reports syntactic errors and broken references to rule calls and super grammars.
 * It's used in IDEA's Xtext editor until we fully support ecore linking and indexing.
 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=477683 
 * 
 * @noreference This class is not intended to be referenced by clients.
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class ReducedXtextResourceValidator extends ResourceValidatorImpl {

	@Override
	protected void validate(Resource resource, CheckMode mode, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		// do nothing
	}

	@Override
	protected void issueFromXtextResourceDiagnostic(Diagnostic diagnostic, Severity severity,
			IAcceptor<Issue> acceptor) {
		if (diagnostic instanceof XtextSyntaxDiagnostic) {
			super.issueFromXtextResourceDiagnostic(diagnostic, severity, acceptor);
		} else if (diagnostic instanceof XtextLinkingDiagnostic) {
			XtextLinkingDiagnostic linkingDiagnostic = (XtextLinkingDiagnostic) diagnostic;
			if (linkingDiagnostic.getCode().equals(XtextLinkingDiagnosticMessageProvider.UNRESOLVED_RULE)) {
				super.issueFromXtextResourceDiagnostic(diagnostic, severity, acceptor);
			} else if (linkingDiagnostic.getMessage().contains("reference to Grammar")) {
				super.issueFromXtextResourceDiagnostic(diagnostic, severity, acceptor);
			}
		}
	}
}