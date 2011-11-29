/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.embedded;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationRulerColumn;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.validation.AnnotationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.ui.editor.validation.ValidationJob;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmbeddedEditorFactory {

	// EmbeddedEditorBuilder.showAnnotations().showLineNumbers().processIssues(..).writable().withParent(Composite)

	@Inject
	private Provider<Builder> builderProvider;
	
	public static class Builder {
		/** The width of the vertical ruler. */
		protected static final int VERTICAL_RULER_WIDTH = 12;
		
		@Inject
		protected XtextSourceViewer.Factory sourceViewerFactory;

		@Inject
		protected Provider<XtextSourceViewerConfiguration> sourceViewerConfigurationProvider;

		@Inject
		protected Provider<XtextDocument> documentProvider;

		@Inject
		protected Provider<IDocumentPartitioner> documentPartitionerProvider;

		@Inject
		protected IResourceValidator resourceValidator;

		@Inject
		protected IPreferenceStoreAccess preferenceStoreAccess;
		
		@Inject
		protected IssueResolutionProvider issueResolutionProvider;
		
		@Inject
		protected ICharacterPairMatcher characterPairMatcher;
		
		protected IEditedResourceProvider resourceProvider;
		protected String[] annotationTypes;
//		protected Boolean lineNumbers;
//		protected Boolean folding;
		protected Boolean readonly;
		protected boolean editorBuild;
		protected IValidationIssueProcessor issueProcessor;
		
		public Builder showErrorAndWarningAnnotations() {
			return showAnnotations("org.eclipse.xtext.ui.editor.error", "org.eclipse.xtext.ui.editor.warning");
		}
		
		public Builder showAnnotations(String... annotationTypes) {
			if (this.annotationTypes != null)
				throw new IllegalStateException();
			if (annotationTypes == null)
				throw new IllegalArgumentException();
			this.annotationTypes = annotationTypes;
			return this;
		}
//		public Builder showLineNumbers() {
//			if (lineNumbers != null)
//				throw new IllegalStateException();
//			this.lineNumbers = true;
//			return this;
//		}
		public Builder processIssuesBy(IValidationIssueProcessor issueProcessor) {
			if (this.issueProcessor != null)
				throw new IllegalStateException();
			if (issueProcessor == null)
				throw new IllegalArgumentException();
			this.issueProcessor = issueProcessor;
			return this;
		}
//		public Builder enableFolding() {
//			if (folding != null)
//				throw new IllegalStateException();
//			this.folding = true;
//			return this;
//		}
		public Builder readOnly() {
			if (readonly != null)
				throw new IllegalStateException();
			this.readonly = true;
			return this;
		}
		public EmbeddedEditor withParent(Composite parent) {
			if (editorBuild)
				throw new IllegalStateException();
			editorBuild = true;
//			/*fProjectionSupport =*/installProjectionSupport(this.fSourceViewer);
			final CompositeRuler annotationRuler;
			if (annotationTypes != null && annotationTypes.length != 0) {
				annotationRuler = new CompositeRuler();
			} else {
				annotationRuler = null;
			}
			final XtextSourceViewer viewer = this.sourceViewerFactory.createSourceViewer(
					parent, 
					annotationRuler, 
					null, // overviewRuler
					false, // showAnnotationOverview 
					SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
			XtextSourceViewerConfiguration viewerConfiguration = this.sourceViewerConfigurationProvider.get();
			viewer.configure(viewerConfiguration);

			// squiggles for markers and other decorations
			final SourceViewerDecorationSupport viewerDecorationSupport = new SourceViewerDecorationSupport(
					viewer, 
					null, // overviewRuler 
					new DefaultMarkerAnnotationAccess() {
						@Override
						public int getLayer(Annotation annotation) {
							if (annotation.isMarkedDeleted()) {
								return IAnnotationAccessExtension.DEFAULT_LAYER;
							}
							return super.getLayer(annotation);
						}
					}, 
					getSharedColors());
			MarkerAnnotationPreferences annotationPreferences = new MarkerAnnotationPreferences();
			Iterator<AnnotationPreference> e = Iterators.filter(annotationPreferences.getAnnotationPreferences().iterator(), AnnotationPreference.class);
			while (e.hasNext()) {
				viewerDecorationSupport.setAnnotationPreference(e.next());
			}
			if (characterPairMatcher != null) {
				viewerDecorationSupport.setCharacterPairMatcher(characterPairMatcher);
				viewerDecorationSupport.setMatchingCharacterPainterPreferenceKeys(BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY,
						BracketMatchingPreferencesInitializer.COLOR_KEY);
			}
			viewerDecorationSupport.install(this.preferenceStoreAccess.getPreferenceStore());
			parent.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					viewerDecorationSupport.dispose();
				}
			});
			final XtextDocument document = this.documentProvider.get();
			IDocumentPartitioner partitioner = this.documentPartitionerProvider.get();
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
			final Map<String, TextViewerAction> actions = initializeActions(viewer);
			final EmbeddedEditor result = new EmbeddedEditor(
					document, viewer, viewerConfiguration, resourceProvider, new Runnable() {
						public void run() {
							afterCreatePartialEditor(viewer, document, annotationRuler, actions);
						}
					});
			viewer.setEditable(!Boolean.TRUE.equals(readonly));
			ValidationJob job = new ValidationJob(this.resourceValidator, document, new IValidationIssueProcessor() {
				private AnnotationIssueProcessor annotationIssueProcessor;

				public void processIssues(List<Issue> issues, IProgressMonitor monitor) {
					IValidationIssueProcessor issueProcessor = Builder.this.issueProcessor;
					if (issueProcessor != null) {
						issueProcessor.processIssues(issues, monitor);
					}
					if (this.annotationIssueProcessor == null) {
						this.annotationIssueProcessor = new AnnotationIssueProcessor(document, viewer.getAnnotationModel(), new IssueResolutionProvider() {

							public boolean hasResolutionFor(String issueCode) {
								return issueResolutionProvider.hasResolutionFor(issueCode);
							}

							public List<IssueResolution> getResolutions(Issue issue) {
								List<IssueResolution> resolutions = issueResolutionProvider.getResolutions(issue);
								List<IssueResolution> result = Lists.transform(resolutions, new Function<IssueResolution, IssueResolution>() {

									public IssueResolution apply(final IssueResolution input) {
										IssueResolution result = new IssueResolution(
												input.getLabel(), 
												input.getDescription(), 
												input.getImage(), 
												new IModificationContext() {
													public IXtextDocument getXtextDocument(URI uri) {
														if (uri.trimFragment().equals(document.getResourceURI()))
															return document;
														return input.getModificationContext().getXtextDocument(uri);
													}
													
													public IXtextDocument getXtextDocument() {
														IModificationContext original = input.getModificationContext();
														if (original instanceof IssueModificationContext) {
															URI uri = ((IssueModificationContext) original).getIssue().getUriToProblem();
															return getXtextDocument(uri);
														}
														return original.getXtextDocument();
													}
												}, 
												input.getModification());
										return result;
									}
								});
								return result;
							}
							
						});
					}
					if (this.annotationIssueProcessor != null) {
						this.annotationIssueProcessor.processIssues(issues, monitor);
					}
				}
			}, CheckMode.FAST_ONLY);
			document.setValidationJob(job);

			Control control = viewer.getControl();
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
			control.setLayoutData(data);

			return result;
		}
		
		protected void afterCreatePartialEditor(XtextSourceViewer viewer, XtextDocument document, CompositeRuler verticalRuler, final Map<String, TextViewerAction> actions) {
			if (verticalRuler != null && annotationTypes != null && annotationTypes.length > 0) {
				AnnotationRulerColumn annotationRulerColumn = new AnnotationRulerColumn(viewer.getAnnotationModel(), VERTICAL_RULER_WIDTH, new DefaultMarkerAnnotationAccess() {
					@Override
					public int getLayer(Annotation annotation) {
						if (annotation.isMarkedDeleted()) {
							return IAnnotationAccessExtension.DEFAULT_LAYER;
						}
						return super.getLayer(annotation);
					}
				});
				for(String annotationType: annotationTypes)
					annotationRulerColumn.addAnnotationType(annotationType);
				verticalRuler.addDecorator(1, annotationRulerColumn);
			}

			final OperationHistoryListener listener = installUndoRedoSupport(viewer, document, actions);
			viewer.getControl().addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					uninstallUndoRedoSupport(listener);
				}
			});
			viewer.addTextListener(new ITextListener() {
				public void textChanged(TextEvent event) {
					if (event.getDocumentEvent() != null) {
						updateUndoAction(actions);
					}
				}
			});
			viewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					updateSelectionDependentActions(actions);
				}
			});
			viewer.getUndoManager().reset();
		}

		protected void updateSelectionDependentActions(Map<String, TextViewerAction> actions) {
			updateAction(actions, ITextEditorActionConstants.CUT);
			updateAction(actions, ITextEditorActionConstants.COPY);
			updateAction(actions, ITextEditorActionConstants.PASTE);
		}

		protected void updateUndoAction(Map<String, TextViewerAction> actions) {
			updateAction(actions, ITextEditorActionConstants.UNDO);
		}

		protected void uninstallUndoRedoSupport(OperationHistoryListener listener) {
			IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
			operationHistory.removeOperationHistoryListener(listener);
		}

		protected OperationHistoryListener installUndoRedoSupport(SourceViewer viewer, IDocument document, final Map<String, TextViewerAction> actions) {
			IDocumentUndoManager undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
			final IUndoContext context = undoManager.getUndoContext();
			IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
			OperationHistoryListener operationHistoryListener = new OperationHistoryListener(context, new IUpdate() {
				public void update() {
					updateAction(actions, ITextEditorActionConstants.REDO);
					updateAction(actions, ITextEditorActionConstants.UNDO);
				}
			});
			operationHistory.addOperationHistoryListener(operationHistoryListener);
			return operationHistoryListener;
		}

		protected void updateAction(Map<String, TextViewerAction> actions, String actionId) {
			IAction action = actions.get(actionId);
			if (action instanceof IUpdate) {
				((IUpdate) action).update();
			}
		}
		
		protected void setResourceProvider(IEditedResourceProvider resourceProvider) {
			this.resourceProvider = resourceProvider;
		}
		
		protected ISharedTextColors getSharedColors() {
			return EditorsUI.getSharedTextColors();
		}

		protected void fillContextMenu(IMenuManager menu, Map<String, TextViewerAction> globalActions) {
			menu.add(new GroupMarker(ITextEditorActionConstants.GROUP_UNDO));
			menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, globalActions.get(ITextEditorActionConstants.UNDO));
			menu.appendToGroup(ITextEditorActionConstants.GROUP_UNDO, globalActions.get(ITextEditorActionConstants.REDO));

			menu.add(new Separator(ITextEditorActionConstants.GROUP_EDIT));
			menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, globalActions.get(ITextEditorActionConstants.CUT));
			menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, globalActions.get(ITextEditorActionConstants.COPY));
			menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, globalActions.get(ITextEditorActionConstants.PASTE));
			menu.appendToGroup(ITextEditorActionConstants.GROUP_EDIT, globalActions.get(ITextEditorActionConstants.SELECT_ALL));

			if (!Boolean.TRUE.equals(readonly)) {
				menu.add(new Separator(ITextEditorActionConstants.GROUP_GENERATE));
				menu.appendToGroup(ITextEditorActionConstants.GROUP_GENERATE, globalActions.get("ContentAssistProposal")); //$NON-NLS-1$
			}
		}

		protected Map<String, TextViewerAction> initializeActions(SourceViewer viewer) {
			final Map<String, TextViewerAction> globalActions = Maps.newHashMapWithExpectedSize(10);

			final List<IHandlerActivation> handlerActivations = Lists.newArrayListWithExpectedSize(3);
			final IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getAdapter(IHandlerService.class);
			Shell shell = viewer.getControl().getShell();
			final ActiveShellExpression expression = new ActiveShellExpression(shell);

			shell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					handlerService.deactivateHandlers(handlerActivations);
				}
			});

			viewer.getTextWidget().addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					handlerService.deactivateHandlers(handlerActivations);
				}

				public void focusGained(FocusEvent e) {
					IAction action = globalActions.get(ITextEditorActionConstants.REDO);
					handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_REDO, new ActionHandler(action), expression));
					action = globalActions.get(ITextEditorActionConstants.UNDO);
					handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_UNDO, new ActionHandler(action), expression));
					if (!Boolean.TRUE.equals(readonly)) {
						action = globalActions.get(ITextEditorActionConstants.CONTENT_ASSIST);
						handlerActivations.add(handlerService.activateHandler(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS, new ActionHandler(action), expression));
					}
				}
			});

			TextViewerAction action = new TextViewerAction(viewer, ITextOperationTarget.UNDO);
			action.setText(EmbeddedEditorMessages.EmbeddedEditor_undo);
			globalActions.put(ITextEditorActionConstants.UNDO, action);

			action = new TextViewerAction(viewer, ITextOperationTarget.REDO);
			action.setText(EmbeddedEditorMessages.EmbeddedEditor_redo);
			globalActions.put(ITextEditorActionConstants.REDO, action);

			action = new TextViewerAction(viewer, ITextOperationTarget.CUT);
			action.setText(EmbeddedEditorMessages.EmbeddedEditor_cut);
			globalActions.put(ITextEditorActionConstants.CUT, action);

			action = new TextViewerAction(viewer, ITextOperationTarget.COPY);
			action.setText(EmbeddedEditorMessages.EmbeddedEditor_copy);
			globalActions.put(ITextEditorActionConstants.COPY, action);

			action = new TextViewerAction(viewer, ITextOperationTarget.PASTE);
			action.setText(EmbeddedEditorMessages.EmbeddedEditor_paste);
			globalActions.put(ITextEditorActionConstants.PASTE, action);

			action = new TextViewerAction(viewer, ITextOperationTarget.SELECT_ALL);
			action.setText(EmbeddedEditorMessages.EmbeddedEditor_select_all);
			globalActions.put(ITextEditorActionConstants.SELECT_ALL, action);

			if (!Boolean.TRUE.equals(readonly)) {
				action = new TextViewerAction(viewer, ISourceViewer.CONTENTASSIST_PROPOSALS);
				action.setText(EmbeddedEditorMessages.EmbeddedEditor_content_assist);
				globalActions.put(ITextEditorActionConstants.CONTENT_ASSIST, action);
			}

			// create context menu
			MenuManager manager = new MenuManager(null, null);
			manager.setRemoveAllWhenShown(true);
			manager.addMenuListener(new IMenuListener() {
				public void menuAboutToShow(IMenuManager mgr) {
					fillContextMenu(mgr, globalActions);
				}
			});

			StyledText text = viewer.getTextWidget();
			Menu menu = manager.createContextMenu(text);
			text.setMenu(menu);
			return globalActions;
		}
	}
	
	public Builder newEditor(IEditedResourceProvider resourceProvider) {
		if (resourceProvider == null)
			throw new IllegalArgumentException("resourceProvider may not be null");
		Builder result = getBuilderProvider().get();
		result.setResourceProvider(resourceProvider);
		return result;
	}

	protected Provider<Builder> getBuilderProvider() {
		return builderProvider;
	}

	public void setBuilderProvider(Provider<Builder> builderProvider) {
		this.builderProvider = builderProvider;
	}

}
