package org.eclipse.xtext.ui.core.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext;
import org.eclipse.jface.text.quickassist.IQuickAssistProcessor;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.MarkerAnnotation;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class XtextQuickAssistAssistant extends QuickAssistAssistant {

	private static class XtextCompletionProposal implements ICompletionProposal, ICompletionProposalExtension3 {

		private Position pos;
		private IMarker marker;
		private IMarkerResolution resolution;

		public XtextCompletionProposal(Position pos, IMarker marker, IMarkerResolution resolution) {
			this.pos = pos;
			this.marker = marker;
			this.resolution = resolution;
		}

		public void apply(IDocument document) {
			resolution.run(marker);
		}

		public Point getSelection(IDocument document) {
			return new Point(pos.offset, 0);
		}

		public String getAdditionalProposalInfo() {
			if (resolution instanceof IMarkerResolution2)
				return ((IMarkerResolution2) resolution).getDescription();
			return null;
		}

		public String getDisplayString() {
			return resolution.getLabel();
		}

		public Image getImage() {
			if (resolution instanceof IMarkerResolution2) {
				return ((IMarkerResolution2) resolution).getImage();
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

	private static class XtextQuickAssistProcessor implements IQuickAssistProcessor {

		private String errorMessage;

		public String getErrorMessage() {
			return errorMessage;
		}

		public boolean canFix(Annotation annotation) {
			if (annotation.isMarkedDeleted() || !(annotation instanceof MarkerAnnotation))
				return false;

			final MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
			if (markerAnnotation.isQuickFixableStateSet())
				return markerAnnotation.isQuickFixable();

			final IMarker marker = markerAnnotation.getMarker();
			boolean canFix = IDE.getMarkerHelpRegistry().hasResolutions(marker);

			if (canFix) {
				final IMarkerResolution[] contributedResolutions = IDE.getMarkerHelpRegistry().getResolutions(marker);
				canFix = contributedResolutions.length > 0;
			}

			if (!markerAnnotation.isQuickFixableStateSet())
				markerAnnotation.setQuickFixable(canFix);

			return canFix;
		}

		public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
			return false;
		}

		public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
			final IAnnotationModel amodel = invocationContext.getSourceViewer().getAnnotationModel();
			final IDocument doc = invocationContext.getSourceViewer().getDocument();

			final int offset = invocationContext.getOffset();
			final List<ICompletionProposal> list = new ArrayList<ICompletionProposal>();

			for (Iterator<?> it = amodel.getAnnotationIterator(); it.hasNext();) {
				Object key = it.next();
				if (!(key instanceof MarkerAnnotation) || !((MarkerAnnotation) key).isQuickFixable())
					continue;

				MarkerAnnotation annotation = (MarkerAnnotation) key;
				IMarker marker = annotation.getMarker();

				IMarkerResolution[] resolutions = IDE.getMarkerHelpRegistry().getResolutions(marker);
				if (resolutions != null) {
					Position pos = amodel.getPosition(annotation);
					try {
						int line = doc.getLineOfOffset(pos.getOffset());
						int start = pos.getOffset();
						String delim = doc.getLineDelimiter(line);
						int delimLength = delim != null ? delim.length() : 0;
						int end = doc.getLineLength(line) + start - delimLength;
						if (offset >= start && offset <= end) {
							for (int i = 0; i < resolutions.length; i++) {
								list.add(new XtextCompletionProposal(pos, marker, resolutions[i]));
							}
						}
					}
					catch (BadLocationException e) {
						errorMessage = e.getMessage();
					}

				}
			}
			return list.toArray(new ICompletionProposal[list.size()]);
		}
	}

	public XtextQuickAssistAssistant() {
		setQuickAssistProcessor(new XtextQuickAssistProcessor());
		setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			@Override
			public IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, (IInformationPresenter) null);
			}
		});
	}

}