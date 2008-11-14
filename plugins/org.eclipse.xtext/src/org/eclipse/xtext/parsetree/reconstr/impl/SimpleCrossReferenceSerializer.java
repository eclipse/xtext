package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.crossref.ILinkingNameService;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.service.Inject;

public class SimpleCrossReferenceSerializer extends
		DefaultCrossReferenceSerializer {

	@Inject
	private ILinkingNameService nameService;

	public String serializeCrossRef(IInstanceDescription container,
			CrossReference grammarElement, EObject target) {
		String r = nameService.getText(target, grammarElement);
		if (r == null)
			throw new XtextSerializationException(container,
					"Unable to create a string represenation for reference '"
							+ grammarElement.getType().getName() + "'.");
		return r;
	}
	
}
