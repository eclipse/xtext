package org.eclipse.xtext.crossref.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.resource.XtextResource.Diagnostic;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultDiagnosticProducer implements DiagnosticProducer {

	private final List<Diagnostic> brokenLinks;

	private AbstractNode node;

	/**
	 * @param brokenLinks
	 * @param node
	 */
	public DefaultDiagnosticProducer(List<Diagnostic> brokenLinks) {
		this.brokenLinks = brokenLinks;
	}

	public void addDiagnostic(String message) {
		brokenLinks.add(new XtextLinkingDiagnostic(node, message));
	}

	public void addDefaultDiagnostic() {
		brokenLinks.add(new XtextLinkingDiagnostic((LeafNode) node));
	}

	public void setNode(AbstractNode node) {
		this.node = node;
	}

	public AbstractNode getNode() {
		return node;
	}

	public void setTarget(EObject object, EStructuralFeature feature) {
		// nothing to do
	}

}