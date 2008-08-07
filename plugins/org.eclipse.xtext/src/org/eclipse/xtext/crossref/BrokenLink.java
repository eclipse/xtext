package org.eclipse.xtext.crossref;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.parsetree.LeafNode;

public class BrokenLink {
	private EObject from;
	private LeafNode linkInformation;
	private CrossReference grammarElement;
	private URI resolvedURI;

	public BrokenLink(EObject from, LeafNode linkInformation, CrossReference grammarElement, URI resolvedURI) {
		super();
		this.from = from;
		this.linkInformation = linkInformation;
		this.grammarElement = grammarElement;
		this.resolvedURI = resolvedURI;
	}

	public EObject getFrom() {
		return from;
	}

	public LeafNode getLinkInformation() {
		return linkInformation;
	}

	public CrossReference getGrammarElement() {
		return grammarElement;
	}

	public URI getResolvedURI() {
		return resolvedURI;
	}

}
