package org.eclipse.xtext.crossref;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public interface ILinker {
	public List<BrokenLink> ensureLinked(EObject obj);
}
