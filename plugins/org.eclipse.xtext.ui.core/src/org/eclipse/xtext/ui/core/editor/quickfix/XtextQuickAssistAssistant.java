package org.eclipse.xtext.ui.core.editor.quickfix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.edit.IDocumentEditor;
import org.eclipse.xtext.ui.core.editor.validation.XtextAnnotation;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueContext;
import org.eclipse.xtext.validation.IssueResolution;
import org.eclipse.xtext.validation.IssueResolutionProvider;
import org.eclipse.xtext.validation.Issue.Severity;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Heiko Behrens
 */
public class XtextQuickAssistAssistant extends QuickAssistAssistant {

	private static class XtextCompletionProposal implements ICompletionProposal, ICompletionProposalExtension3 {

		private Position pos;
		private IssueResolution resolution;

		public XtextCompletionProposal(Position pos, IssueResolution resolution) {
			this.pos = pos;
			this.resolution = resolution;
		}

		public void apply(IDocument document) {
			resolution.run();
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
			// TODO: implement
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
		private final IssueResolutionProvider issueResolutionProvider;
		private final IDocumentEditor documentEditor;

		public XtextQuickAssistProcessor(IssueResolutionProvider issueResolutionProvider, IDocumentEditor documentEditor) {
			this.issueResolutionProvider = issueResolutionProvider;
			this.documentEditor = documentEditor;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public boolean canFix(Annotation annotation) {
			if (annotation.isMarkedDeleted())
				return false;
			
			// non-persisted annotation
			if (annotation instanceof XtextAnnotation) {
				XtextAnnotation a = (XtextAnnotation) annotation;
				return issueResolutionProvider.hasResolutionFor(a.getIssueCode());
			}
			
			// persisted markerAnnotation
			if (annotation instanceof MarkerAnnotation) {
				MarkerAnnotation markerAnnotation = (MarkerAnnotation) annotation;
				if (markerAnnotation.isQuickFixableStateSet())
					return markerAnnotation.isQuickFixable();
				
				
//				// TODO: register helper at org.eclipse.ui.markerhelp and org.eclipse.ui.markerresolution
//				// that scans for IssueCode-Attribute, see MarkerHelpRegistry
				// BUT: has to produce proper Resolutions as well
//				final IMarker marker = markerAnnotation.getMarker();
//				boolean canFix = IDE.getMarkerHelpRegistry().hasResolutions(marker);
//				
//				if (canFix) {
//					final IMarkerResolution[] contributedResolutions = IDE.getMarkerHelpRegistry().getResolutions(marker);
//					canFix = contributedResolutions.length > 0;
//				}
				
				boolean canFix = issueResolutionProvider.hasResolutionFor(getCode(markerAnnotation));
				
				if (!markerAnnotation.isQuickFixableStateSet())
					markerAnnotation.setQuickFixable(canFix);
	
				return canFix;
			}
			
			return false;
		}

		private Integer getCode(MarkerAnnotation markerAnnotation) {
			IMarker marker = markerAnnotation.getMarker();
			try {
				return (Integer) marker.getAttribute(Issue.CODE_KEY);
			} catch (ClassCastException e) {
				return null;
			} catch (CoreException e) {
				return null;
			}
		}
		
		private URI getUriToProblem(MarkerAnnotation markerAnnotation) {
			String uri = markerAnnotation.getMarker().getAttribute(Issue.URI_KEY, null);
			return uri != null ? URI.createURI(uri) : null;
		}

		public boolean canAssist(IQuickAssistInvocationContext invocationContext) {
			return false;
		}

		public ICompletionProposal[] computeQuickAssistProposals(IQuickAssistInvocationContext invocationContext) {
			final IDocument d = invocationContext.getSourceViewer().getDocument();
			if(!(d instanceof IXtextDocument))
				return new ICompletionProposal[0];
			final IXtextDocument document = (IXtextDocument)d;
			
			final IAnnotationModel amodel = invocationContext.getSourceViewer().getAnnotationModel();
			
			List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
			final int offset = invocationContext.getOffset();
			for (Iterator<?> it = amodel.getAnnotationIterator(); it.hasNext();) {
				Object key = it.next();
				if(!(key instanceof Annotation))
					continue;
				
				Annotation annotation = (Annotation) key;
				if(!canFix(annotation))
					continue;
				
				final Issue issue = getIssueFromAnnotation(annotation, amodel, document);
				if(issue == null)
					continue;
		
				Iterable<IssueResolution> resolutions = getResolutions(issue, document);
				if(!resolutions.iterator().hasNext())
					continue;
				
				Position pos = amodel.getPosition(annotation);
				try {
					int line = document.getLineOfOffset(pos.getOffset());
					int start = pos.getOffset();
					String delim = document.getLineDelimiter(line);
					int delimLength = delim != null ? delim.length() : 0;
					int end = document.getLineLength(line) + start - delimLength;
					if (offset >= start && offset <= end) {
						for(IssueResolution resolution : resolutions)
							result.add(new XtextCompletionProposal(pos, resolution));
					}
				}
				catch (BadLocationException e) {
					errorMessage = e.getMessage();
				}
			}
			return result.toArray(new ICompletionProposal[result.size()]);
		}
		

		private Issue getIssueFromAnnotation(Annotation annotation, IAnnotationModel amodel, IXtextDocument document) {
			if (annotation instanceof XtextAnnotation) {
				XtextAnnotation xtextAnnotation = (XtextAnnotation) annotation;
				return xtextAnnotation.getIssue();
			} else if(annotation instanceof MarkerAnnotation) {
				MarkerAnnotation markerAnnotation = (MarkerAnnotation)annotation;
				Issue.IssueImpl issue = new Issue.IssueImpl();
				issue.setMessage(annotation.getText());
				Position pos = amodel.getPosition(annotation);
				try {
					issue.setLineNumber(document.getLineOfOffset(pos.getOffset()));
					issue.setOffset(pos.getOffset());
					issue.setLength(pos.getLength());
				} catch (BadLocationException e) {
				}

				issue.setCode(getCode(markerAnnotation));
				issue.setUriToProblem(getUriToProblem(markerAnnotation));
				issue.setSeverity(getSeverityFromMarker(markerAnnotation.getMarker()));
				
				// Note, isSyntaxError is unset, but currently the api does not allow fixing
				// syntax errors anyway.
				return issue;
			} else
				return null;
		}

		private Severity getSeverityFromMarker(IMarker marker) {
			switch (marker.getAttribute(IMarker.SEVERITY, 0)) {
				case IMarker.SEVERITY_ERROR:
					return Severity.ERROR;
				case IMarker.SEVERITY_WARNING:
					return Severity.WARNING;
				default:
					return Severity.INFO;
			}
		}

		private Iterable<IssueResolution> getResolutions(final Issue issue, IXtextDocument document) {
			final String content = document.get();
			
			IUnitOfWork<List<IssueResolution>, XtextResource> uow = new IUnitOfWork<List<IssueResolution>, XtextResource>() {

				public List<IssueResolution> exec(XtextResource state) throws Exception {
					EObject model = state.getContents().isEmpty() ? null : state.getContents().get(0);
					EObject contextObject = (model == null) ? null : model.eResource().getEObject(issue.getUriToProblem().fragment());
					IssueContext context = new IssueContext.IssueContextImpl(contextObject, issue, content);
					
					return issueResolutionProvider.getResolutions(context);
				}
			};
			
			Iterable<IssueResolution> result = document.readOnly(uow);
			return modifyResolutions(document, result);			
		}

		private Iterable<IssueResolution> modifyResolutions(final IXtextDocument document, Iterable<IssueResolution> resolutions) {
			return Iterables.transform(resolutions, new Function<IssueResolution, IssueResolution>() {

				public IssueResolution apply(final IssueResolution delegate) {
					return new IssueResolution() {
						
						public void run() {
							IUnitOfWork<Object, XtextResource> uow = new IUnitOfWork.Void<XtextResource>() {
								@Override
								public void process(XtextResource state) throws Exception {
									delegate.run();
								}
							};
							
							documentEditor.process(uow, document);
						}
						
						public String getLabel() {
							return delegate.getLabel();
						}
						
						public String getDescription() {
							return delegate.getDescription();
						}
					};
				}
			});
		}

	}
	
	@Inject
	public XtextQuickAssistAssistant(IssueResolutionProvider issueResolutionProvider, IDocumentEditor documentEditor) {
		setQuickAssistProcessor(new XtextQuickAssistProcessor(issueResolutionProvider, documentEditor));
		setInformationControlCreator(new AbstractReusableInformationControlCreator() {
			@Override
			public IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, (IInformationPresenter) null);
			}
		});
	}



}