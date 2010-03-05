package org.eclipse.xtext.ui.editor.quickfix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.MarkerUtil;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IssueUtil;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan Koehnlein
 */
public class XtextQuickAssistAssistant extends QuickAssistAssistant {

	public static class XtextCompletionProposalAdapter implements ICompletionProposal, ICompletionProposalExtension3 {

		private Position pos;
		private IssueResolution resolution;
		private Image image;

		public XtextCompletionProposalAdapter(Position pos, IssueResolution resolution, Image image) {
			this.pos = pos;
			this.resolution = resolution;
			this.image = image;
		}

		public void apply(IDocument document) {
			resolution.apply();
		}

		public Point getSelection(IDocument document) {
			return new Point(pos.offset, 0);
		}

		public String getAdditionalProposalInfo() {
			return resolution.getDescription();
		}

		public String getDisplayString() {
			return resolution.getLabel();
		}

		public Image getImage() {
			return image;
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

	public static class XtextQuickAssistProcessor extends AbstractIssueResolutionProviderAdapter implements
			IQuickAssistProcessor {

		private final IssueUtil issueUtil;

		private final MarkerUtil markerUtil;

		@Inject
		public XtextQuickAssistProcessor(IssueUtil issueUtil, MarkerUtil markerUtil) {
			this.issueUtil = issueUtil;
			this.markerUtil = markerUtil;
		}

		private String errorMessage;

		public String getErrorMessage() {
			return errorMessage;
		}

		public boolean canFix(Annotation annotation) {
			if (annotation.isMarkedDeleted())
				return false;

			// non-persisted annotation
			if (annotation instanceof XtextAnnotation) {
				XtextAnnotation a = (XtextAnnotation) annotation;
				return getResolutionProvider().hasResolutionFor(a.getIssueCode());
			}

			// persisted markerAnnotation
			if (annotation instanceof MarkerAnnotation) {
				MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
				if (!markerAnnotation.isQuickFixableStateSet())
					markerAnnotation.setQuickFixable(getResolutionProvider().hasResolutionFor(
							markerUtil.getCode(markerAnnotation)));

				return markerAnnotation.isQuickFixable();
			}

			return false;
		}

		public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
			return false;
		}

		public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
			final IDocument d = invocationContext.getSourceViewer().getDocument();
			if (!(d instanceof IXtextDocument))
				return new ICompletionProposal[0];
			final IXtextDocument document = (IXtextDocument) d;

			final IAnnotationModel amodel = invocationContext.getSourceViewer().getAnnotationModel();

			List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
			final int offset = invocationContext.getOffset();
			for (Iterator<?> it = amodel.getAnnotationIterator(); it.hasNext();) {
				Object key = it.next();
				if (!(key instanceof Annotation))
					continue;

				Annotation annotation = (Annotation) key;
				if (!canFix(annotation))
					continue;

				final Issue issue = issueUtil.getIssueFromAnnotation(annotation);
				if (issue == null)
					continue;

				Iterable<IssueResolution> resolutions = getResolutions(issue, document);
				if (!resolutions.iterator().hasNext())
					continue;

				Position pos = amodel.getPosition(annotation);
				if (pos != null) {
					try {
						int line = document.getLineOfOffset(pos.getOffset());
						int start = pos.getOffset();
						String delim = document.getLineDelimiter(line);
						int delimLength = delim != null ? delim.length() : 0;
						int end = document.getLineLength(line) + start - delimLength;
						if (offset >= start && offset <= end) {
							for (IssueResolution resolution : resolutions)
								result.add(new XtextCompletionProposalAdapter(pos, resolution, getImage(resolution)));
						}
					} catch (BadLocationException e) {
						errorMessage = e.getMessage();
					}
				}
			}
			return result.toArray(new ICompletionProposal[result.size()]);
		}

	}

	@Inject
	public XtextQuickAssistAssistant(XtextQuickAssistProcessor processor) {
		setQuickAssistProcessor(processor);
		setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			@Override
			public IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, (IInformationPresenter) null);
			}
		});
	}

}