package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.service.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SimpleCrossReferenceSerializer extends
		DefaultCrossReferenceSerializer {

	@Inject
	private ILinkingService linkingService;

	public String serializeCrossRef(IInstanceDescription container,
			CrossReference grammarElement, EObject target) {
		final EObject context = container.getDelegate();
		final EReference ref = GrammarUtil.getReference(grammarElement, context
				.eClass());
		final String text = linkingService.getLinkText(target, ref, context);
		if (text == null)
			throw new XtextSerializationException(
					container,
					"Error serializing CrossRefs: "
							+ "Unable to create a string represenation for reference '"
							+ grammarElement.getType().getName() + "' using "
							+ linkingService.getClass().getName()
							+ " EReference: " + ref.getName() + " Context:"
							+ context + " Target:" + target);
		return text;
	}

}
