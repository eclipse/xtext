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
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextQuickAssistProcessor implements IQuickAssistProcessor {
	class CompletionProposal implements ICompletionProposal, ICompletionProposalExtension3 {

		Position position;
		IMarkerResolution markerResolution;
		IMarker marker;

		public CompletionProposal(IMarkerResolution markerResolution, Position position, IMarker marker) {
			this.position = position;
			this.markerResolution = markerResolution;
			this.marker = marker;
		}

		public void apply(IDocument document) {
			markerResolution.run(marker);
		}

		public Point getSelection(IDocument document) {
			return new Point(position.offset, 0);
		}

		public String getAdditionalProposalInfo() {
			if (markerResolution instanceof IMarkerResolution2)
				return ((IMarkerResolution2) markerResolution).getDescription();
			return null;
		}

		public String getDisplayString() {
			return markerResolution.getLabel();
		}

		public Image getImage() {
			if (markerResolution instanceof IMarkerResolution2) {
				IMarkerResolution2 resolution = (IMarkerResolution2) markerResolution;
				return resolution.getImage();
			}
			return null;
		}

		public IContextInformation getContextInformation() {
			return null;
		}

		public IInformationControlCreator getInformationControlCreator() {
			return null;
		}

		public int getPrefixCompletionStart(IDocument document, int completionOffset) {
			return 0;
		}

		public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
			return null;
		}

	}

	private final XtextMarkerResolutionGenerator quickFixGenerator;

	public XtextQuickAssistProcessor() {
		this.quickFixGenerator = new XtextMarkerResolutionGenerator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.text.quickassist.IQuickAssistProcessor#canAssist(org
	 * .eclipse.jface.text.quickassist.IQuickAssistInvocationContext)
	 */
	public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
		// TODO Auto-generated method stub
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
		if (!(annotation instanceof SimpleMarkerAnnotation))
			return false;
		IMarker marker = ((SimpleMarkerAnnotation) annotation).getMarker();
		return this.quickFixGenerator.hasResolutions(marker);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.jface.text.quickassist.IQuickAssistProcessor#
	 * computeQuickAssistProposals
	 * (org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext)
	 */
	public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
		IAnnotationModel amodel = invocationContext.getSourceViewer().getAnnotationModel();
		IDocument doc = invocationContext.getSourceViewer().getDocument();

		int offset = invocationContext.getOffset();
		Iterator<?> it = amodel.getAnnotationIterator();
		List<CompletionProposal> list = new ArrayList<CompletionProposal>();
		while (it.hasNext()) {
			Object key = it.next();
			if (!(key instanceof SimpleMarkerAnnotation))
				continue;

			SimpleMarkerAnnotation annotation = (SimpleMarkerAnnotation) key;
			IMarker marker = annotation.getMarker();

			IMarkerResolution[] mapping = quickFixGenerator.getResolutions(marker);
			if (mapping != null) {
				Position pos = amodel.getPosition(annotation);
				try {
					int line = doc.getLineOfOffset(pos.getOffset());
					int start = pos.getOffset();
					String delim = doc.getLineDelimiter(line);
					int delimLength = delim != null ? delim.length() : 0;
					int end = doc.getLineLength(line) + start - delimLength;
					if (offset >= start && offset <= end) {
						for (int i = 0; i < mapping.length; i++) {
							list.add(new CompletionProposal(mapping[i], pos, marker));
						}
					}
				}
				catch (BadLocationException e) {
				}

			}
		}
		return (ICompletionProposal[]) list.toArray(new ICompletionProposal[0]);
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
