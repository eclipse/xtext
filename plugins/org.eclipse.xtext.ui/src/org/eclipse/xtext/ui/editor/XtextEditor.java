/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension2;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.SelectMarkerRulerAction;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer;
import org.eclipse.xtext.ui.editor.bracketmatching.CharacterPairMatcher;
import org.eclipse.xtext.ui.editor.folding.IFoldingStructureProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingHelper;
import org.eclipse.xtext.ui.editor.toggleComments.ToggleSLCommentAction;
import org.eclipse.xtext.ui.internal.Activator;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 * @author Michael Clay
 * @author Dan Stefanescu - Fix for bug 278279
 */
public class XtextEditor extends TextEditor {
	public static final String ERROR_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.error";
	public static final String WARNING_ANNOTATION_TYPE = "org.eclipse.xtext.ui.editor.warning";

	private static final Logger log = Logger.getLogger(XtextEditor.class);

	public static final String ID = "org.eclipse.xtext.baseEditor"; //$NON-NLS-1$

	@Inject
	private IFoldingStructureProvider foldingStructureProvider;

	@Inject(optional = true)
	private AnnotationPainter.IDrawingStrategy projectionAnnotationDrawingStrategy;

	@Inject
	private CompoundXtextEditorCallback callback;

	@Inject
	private XtextSourceViewerConfiguration sourceViewerConfiguration;

	private IContentOutlinePage outlinePage;

	@Inject(optional = true)
	private Provider<IContentOutlinePage> outlinePageProvider;

	@Inject
	private Provider<XtextDocumentProvider> documentProvider;

	@Inject
	private XtextSourceViewer.Factory sourceViewerFactory;

	@Inject
	private IHighlightingHelper highlightingHelper;

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	private ISelectionChangedListener selectionChangedListener;

	private String languageName;

	public XtextEditor() {
		if (log.isDebugEnabled())
			log.debug("Creating Xtext Editor. Instance: [" + this.toString() + "]");
	}

	public IXtextDocument getDocument() {
		return XtextDocumentUtil.get(getSourceViewer());
	}

	@Inject
	public void setLanguageName(@Named(Constants.LANGUAGE_NAME) String name) {
		this.languageName = name;
	}

	public String getLanguageName() {
		return languageName;
	}

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		if (log.isDebugEnabled()) {
			log.debug("doSetInput:" + input);
			log.debug("Editor instance is [" + this.toString() + "]");
		}
		callback.beforeSetInput(this);
		super.doSetInput(input);
		callback.afterSetInput(this);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (log.isDebugEnabled())
			log.debug("init:" + input);

		// do document provider setup
		setDocumentProvider(documentProvider.get());

		// source viewer setup
		setSourceViewerConfiguration(sourceViewerConfiguration);

		setPreferenceStore(preferenceStoreAccess.getContextPreferenceStore(input));

		// NOTE: Outline CANNOT be initialized here, since we do not have access
		// to the source viewer yet (it will be created later).

		super.init(site, input);
	}

	public XtextSourceViewerConfiguration getXtextSourceViewerConfiguration() {
		return sourceViewerConfiguration;
	}

	@Override
	public void doSaveAs() {
		super.doSaveAs();
		callback.afterSave(this);
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		super.doSave(progressMonitor);
		callback.afterSave(this);
	}

	@Override
	public void doRevertToSaved() {
		super.doRevertToSaved();
		callback.afterSave(this);
	}

	/**
	 * Set key binding scope. Needed to make F3 work properly.
	 */
	@Override
	protected void initializeKeyBindingScopes() {
		setKeyBindingScopes(new String[] { "org.eclipse.xtext.ui.XtextEditorScope" }); //$NON-NLS-1$
	}

	public IResource getResource() {
		Object adapter = getEditorInput().getAdapter(IResource.class);
		if (adapter != null) {
			return (IResource) adapter;
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IContentOutlinePage.class)) {
			return getContentOutlinePage();
		}
		return super.getAdapter(adapter);
	}

	private IContentOutlinePage getContentOutlinePage() {
		if (outlinePage == null) {
			outlinePage = createOutlinePage();
		}
		return outlinePage;
	}

	private IContentOutlinePage createOutlinePage() {
		IContentOutlinePage page = null;
		if (outlinePageProvider != null) {
			// can be null, optional injection
			page = outlinePageProvider.get();

			if (page != null) {
				if (page instanceof ISourceViewerAware) {
					((ISourceViewerAware) page).setSourceViewer(getSourceViewer());
				}
				if (page instanceof IXtextEditorAware) {
					((IXtextEditorAware) page).setEditor(this);
				}
			}
		}
		return page;
	}

	/**
	 * Informs the editor that its outline has been closed.
	 */
	public void outlinePageClosed() {
		if (outlinePage != null) {
			outlinePage = null;
			resetHighlightRange();
		}
	}

	@Inject
	private IActionContributor.CompositeImpl actioncontributor;

	@Override
	protected void createActions() {
		super.createActions();
		if (getSourceViewerConfiguration().getContentFormatter(getSourceViewer()) != null) {
			Action action = new TextOperationAction(XtextUIMessages.getResourceBundle(),
					"Format.", this, ISourceViewer.FORMAT); //$NON-NLS-1$
			action.setActionDefinitionId(Activator.PLUGIN_ID + ".FormatAction");
			setAction("Format", action); //$NON-NLS-1$
			markAsStateDependentAction("Format", true); //$NON-NLS-1$
			markAsSelectionDependentAction("Format", true); //$NON-NLS-1$
		}

		ToggleSLCommentAction action = new ToggleSLCommentAction(XtextUIMessages.getResourceBundle(),
				"ToggleComment.", this); //$NON-NLS-1$
		action.setActionDefinitionId(Activator.PLUGIN_ID + ".ToggleCommentAction");
		setAction("ToggleComment", action); //$NON-NLS-1$
		markAsStateDependentAction("ToggleComment", true); //$NON-NLS-1$
		markAsSelectionDependentAction("ToggleComment", true);
		configureToggleCommentAction(action);

		// Creates an build-in "click an ruler annotation, marks corresponding
		// text" - action
		SelectMarkerRulerAction markerAction = new XtextMarkerRulerAction(XtextUIMessages.getResourceBundle(),
				"XtextSelectAnnotationRulerAction.", this, getVerticalRuler()); //$NON-NLS-1$
		setAction(ITextEditorActionConstants.RULER_CLICK, markerAction);

		actioncontributor.contributeActions(this);
	}

	private void configureToggleCommentAction(ToggleSLCommentAction action) {
		ISourceViewer sourceViewer = getSourceViewer();
		SourceViewerConfiguration configuration = getSourceViewerConfiguration();
		action.configure(sourceViewer, configuration);
	}

	/**
	 * @return true if content assist is available
	 * 
	 */
	public boolean isContentAssistAvailable() {
		return getSourceViewerConfiguration().getContentAssistant(getSourceViewer()) != null;
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		if (log.isDebugEnabled())
			log.debug("Creating Xtext source viewer.");

		// overwrite superclass implementation to allow folding
		fAnnotationAccess = createAnnotationAccess();
		fOverviewRuler = createOverviewRuler(getSharedColors());
		ISourceViewer projectionViewer = sourceViewerFactory.createSourceViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles);
		getSourceViewerDecorationSupport(projectionViewer);
		return projectionViewer;
	}

	@Inject
	private CharacterPairMatcher characterPairMatcher;

	@Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		super.configureSourceViewerDecorationSupport(support);
		if (characterPairMatcher != null) {
			support.setCharacterPairMatcher(characterPairMatcher);
			support.setMatchingCharacterPainterPreferenceKeys(BracketMatchingPreferencesInitializer.IS_ACTIVE_KEY,
					BracketMatchingPreferencesInitializer.COLOR_KEY);
		}
	}

	private ProjectionSupport projectionSupport;

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = installProjectionSupport(projectionViewer);
		installFoldingSupport(projectionViewer);
		installHighlightingHelper();
		installSelectionChangedListener();
		callback.afterCreatePartControl(this);
	}

	protected ProjectionSupport installProjectionSupport(ProjectionViewer projectionViewer) {
		ProjectionSupport projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(),
				getSharedColors());
		projectionSupport.addSummarizableAnnotationType(WARNING_ANNOTATION_TYPE); //$NON-NLS-1$
		projectionSupport.addSummarizableAnnotationType(ERROR_ANNOTATION_TYPE); //$NON-NLS-1$
		projectionSupport.setAnnotationPainterDrawingStrategy(projectionAnnotationDrawingStrategy);
		projectionSupport.install();
		return projectionSupport;
	}

	protected void installFoldingSupport(ProjectionViewer projectionViewer) {
		foldingStructureProvider.install(this, projectionViewer);
		projectionViewer.doOperation(ProjectionViewer.TOGGLE);
	}

	private void installSelectionChangedListener() {
		selectionChangedListener = new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				updateStatusLine();
			}
		};
		final ISelectionProvider selectionProvider = getSelectionProvider();
		if (selectionProvider instanceof IPostSelectionProvider) {
			final IPostSelectionProvider postSelectionProvider = (IPostSelectionProvider) selectionProvider;
			postSelectionProvider.addPostSelectionChangedListener(selectionChangedListener);
		} else {
			getSelectionProvider().addSelectionChangedListener(selectionChangedListener);
		}
	}

	private void installHighlightingHelper() {
		if (highlightingHelper != null)
			highlightingHelper.install(this, (XtextSourceViewer) getSourceViewer());
	}

	private void uninstallHighlightingHelper() {
		if (highlightingHelper != null)
			highlightingHelper.uninstall();
	}

	@Override
	public void dispose() {
		callback.beforeDispose(this);
		super.dispose();
		if (projectionSupport != null) {
			projectionSupport.dispose();
		}
		if (outlinePage != null) {
			outlinePage = null;
		}
		uninstallFoldingSupport();
		uninstallHighlightingHelper();
		uninstallSelectionChangedListener();
	}

	protected void uninstallFoldingSupport() {
		if (foldingStructureProvider != null) {
			foldingStructureProvider.uninstall();
			foldingStructureProvider = null;
		}
	}

	private void uninstallSelectionChangedListener() {
		ISelectionProvider selectionProvider = getSelectionProvider();
		if (selectionProvider != null) {
			if (selectionProvider instanceof IPostSelectionProvider) {
				final IPostSelectionProvider postSelectionProvider = (IPostSelectionProvider) selectionProvider;
				postSelectionProvider.removePostSelectionChangedListener(selectionChangedListener);
			} else {
				selectionProvider.removeSelectionChangedListener(selectionChangedListener);
			}
		}
	}

	/**
	 * TODO: get rid of this method. It is only here to support
	 * org.eclipse.xtext.ui.editor.hyperlinking.OpenDeclarationHandler, which needs access to the sourceviewer.
	 */
	public ISourceViewer getInternalSourceViewer() {
		return getSourceViewer();
	}

	@Override
	protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
		super.handlePreferenceStoreChanged(event);
		if (getSourceViewer() == null)
			return;
		// TODO (dennis) move preference store constants to ui.core or create a
		// handlePrefStoreChanged service
		boolean tokenStyleChanged = event.getProperty().contains(".syntaxColorer.tokenStyles");
		if (tokenStyleChanged) {
			initializeViewerColors(getSourceViewer());
			getSourceViewer().invalidateTextPresentation();
		}
	}

	@Override
	protected String[] collectContextMenuPreferencePages() {
		String[] ids = super.collectContextMenuPreferencePages();
		String[] more = new String[ids.length + 4];
		// NOTE: preference page at index 0 will be opened, see
		// PreferencesUtil.createPreferenceDialogOn
		more[0] = getLanguageName() + ".editor"; //$NON-NLS-1$
		more[1] = getLanguageName();
		more[2] = getLanguageName() + ".templates"; //$NON-NLS-1$
		more[3] = getLanguageName() + ".coloring"; //$NON-NLS-1$
		System.arraycopy(ids, 0, more, 4, ids.length);
		return more;
	}

	@Override
	protected IAnnotationAccess createAnnotationAccess() {
		return new DefaultMarkerAnnotationAccess() {
			@Override
			public int getLayer(Annotation annotation) {
				if (annotation.isMarkedDeleted()) {
					return IAnnotationAccessExtension.DEFAULT_LAYER;
				}
				return super.getLayer(annotation);
			}
		};
	}

	protected void updateStatusLine() {
		final ITextSelection selection = (ITextSelection) getSelectionProvider().getSelection();
		final Annotation annotation = getAnnotation(selection.getOffset(), selection.getLength());
		String message = null;
		if (annotation != null) {
			updateMarkerViews(annotation);
			if (isProblemMarkerAnnotation(annotation)) {
				message = annotation.getText();
			}
		}
		setStatusLineMessage(message);
	}

	@Override
	public boolean validateEditorInputState() {
		return callback.onValidateEditorInputState(this) && super.validateEditorInputState();
	}

	public void updatedTitleImage(Image image) {
		setTitleImage(image);
	}

	@Override
	public Image getDefaultImage() {
		IEditorRegistry editorRegistry = PlatformUI.getWorkbench().getEditorRegistry();
		IEditorDescriptor editorDesc = editorRegistry.findEditor(getSite().getId());
		ImageDescriptor imageDesc = editorDesc != null ? editorDesc.getImageDescriptor() : null;
		return imageDesc != null ? imageDesc.createImage() : super.getDefaultImage();
	}

	/*
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#rulerContextMenuAboutToShow(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	protected void rulerContextMenuAboutToShow(IMenuManager menu) {
		super.rulerContextMenuAboutToShow(menu);
		IMenuManager foldingMenu = new MenuManager(XtextUIMessages.Editor_FoldingMenu_name, "projection"); //$NON-NLS-1$
		menu.appendToGroup(ITextEditorActionConstants.GROUP_RULERS, foldingMenu);
		IAction action = getAction("FoldingToggle"); //$NON-NLS-1$
		foldingMenu.add(action);
		action = getAction("FoldingExpandAll"); //$NON-NLS-1$
		foldingMenu.add(action);
		action = getAction("FoldingCollapseAll"); //$NON-NLS-1$
		foldingMenu.add(action);
		action = getAction("FoldingRestore"); //$NON-NLS-1$
		foldingMenu.add(action);
	}

	/**
	 * Resets the foldings structure according to the folding preferences.
	 */
	public void resetProjection() {
		if (foldingStructureProvider != null) {
			foldingStructureProvider.initialize();
		}
	}

	@SuppressWarnings("rawtypes")
	private Annotation getAnnotation(final int offset, final int length) {
		final IAnnotationModel model = getDocumentProvider().getAnnotationModel(getEditorInput());
		if (model == null)
			return null;

		Iterator iterator;
		if (model instanceof IAnnotationModelExtension2) {
			iterator = ((IAnnotationModelExtension2) model).getAnnotationIterator(offset, length, true, true);
		} else {
			iterator = model.getAnnotationIterator();
		}

		while (iterator.hasNext()) {
			final Annotation a = (Annotation) iterator.next();
			final Position p = model.getPosition(a);
			if (p != null && p.overlapsWith(offset, length))
				return a;
		}
		return null;
	}

	private boolean isProblemMarkerAnnotation(final Annotation annotation) {
		if (!(annotation instanceof MarkerAnnotation))
			return false;
		try {
			return (((MarkerAnnotation) annotation).getMarker().isSubtypeOf(IMarker.PROBLEM));
		} catch (final CoreException e) {
			return false;
		}
	}

	/**
	 * Externally set the editor callback, e.g. to disable dirty state support for a specific instance.
	 */
	public void setXtextEditorCallback(CompoundXtextEditorCallback callback) {
		this.callback = callback;
	}

}
