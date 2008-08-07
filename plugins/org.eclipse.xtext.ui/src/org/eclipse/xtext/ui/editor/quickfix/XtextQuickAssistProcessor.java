/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextQuickAssistProcessor implements IQuickAssistProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.quickassist.IQuickAssistProcessor#canAssist(org
	 * .eclipse.jface.text.quickassist.IQuickAssistInvocationContext)
	 */
	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		// TODO QuickAssist
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.quickassist.IQuickAssistProcessor#canFix(org.eclipse
	 * .jface.text.source.Annotation)
	 */
	public boolean canFix(Annotation annotation) {
		if (annotation instanceof SimpleMarkerAnnotation) {
			IMarker marker = ((SimpleMarkerAnnotation) annotation).getMarker();
			return IDE.getMarkerHelpRegistry().hasResolutions(marker);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.quickassist.IQuickAssistProcessor#
	 * computeQuickAssistProposals
	 * (org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext)
	 */
	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
		if (invocationContext.getSourceViewer().getAnnotationModel() instanceof AnnotationModel) {
			AnnotationModel anoModel = (AnnotationModel) invocationContext.getSourceViewer().getAnnotationModel();
			// using 3.4 performance iterator, move offset to left so can
			// search both sides of cursor for annotations
			Iterator<?> anotationIterator = anoModel.getAnnotationIterator(invocationContext.getOffset() - 1, 2, true,
					true);
			List<MarkerResolutionCompletionProposal> proposals = new ArrayList<MarkerResolutionCompletionProposal>();
			while (anotationIterator.hasNext()) {
				Object key = anotationIterator.next();
				if (key instanceof SimpleMarkerAnnotation) {
					SimpleMarkerAnnotation annotation = (SimpleMarkerAnnotation) key;
					IMarker marker = annotation.getMarker();
					if (IDE.getMarkerHelpRegistry().hasResolutions(marker)) {
						IMarkerResolution[] markerResolutions = IDE.getMarkerHelpRegistry().getResolutions(marker);
						for (IMarkerResolution markerResolution : markerResolutions) {
							proposals.add(new MarkerResolutionCompletionProposal(markerResolution, anoModel
									.getPosition(annotation), marker));
						}
						return (ICompletionProposal[]) proposals.toArray(new ICompletionProposal[0]);
					}
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.quickassist.IQuickAssistProcessor#getErrorMessage
	 * ()
	 */
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
