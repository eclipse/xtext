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
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
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
		IAnnotationModel anoModel = invocationContext.getSourceViewer().getAnnotationModel();
		Iterator<?> anotationIterator = anoModel.getAnnotationIterator();
		List<MarkerResolutionCompletionProposal> proposals = new ArrayList<MarkerResolutionCompletionProposal>();
		while (anotationIterator.hasNext()) {
			Object key = anotationIterator.next();
			if (key instanceof SimpleMarkerAnnotation) {
				SimpleMarkerAnnotation annotation = (SimpleMarkerAnnotation) key;
				IMarker marker = annotation.getMarker();
				IMarkerResolution[] markerResolutions = IDE.getMarkerHelpRegistry().getResolutions(marker);
				if (markerResolutions != null && markerResolutions.length > 0) {
					Position pos = anoModel.getPosition(annotation);
					if (pos.overlapsWith(invocationContext.getOffset(), invocationContext.getLength())) {
						for (int i = 0; i < markerResolutions.length; i++) {
							proposals.add(new MarkerResolutionCompletionProposal(markerResolutions[i], pos, marker));
						}
					}
				}
			}
		}
		return (ICompletionProposal[]) proposals.toArray(new ICompletionProposal[0]);
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
