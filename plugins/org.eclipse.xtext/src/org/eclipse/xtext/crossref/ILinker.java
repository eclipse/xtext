package org.eclipse.xtext.crossref;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.ILanguageService;

public interface ILinker extends ILanguageService{
	public List<XtextResource.Diagnostic> ensureLinked(EObject obj);
}
