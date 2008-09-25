/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.TextOperationAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.ServiceScopeFactory;
import org.eclipse.xtext.ui.core.XtextUIMessages;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.core.internal.Activator;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Peter Friese - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtextEditor extends TextEditor implements IExecutableExtension {

	public XtextEditor() {
		System.out.println("constructing editor");
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) {
		super.setInitializationData(config, propertyName, data);
		String id = config.getAttribute("id");
		IServiceScope scope = ServiceScopeFactory.get(id);
		if (scope == null)
			throw new IllegalStateException("scope " + data + " has not been registered.");
		ServiceRegistry.injectServices(scope, this);
	}

	private abstract class AbstractSelectionChangedListener implements ISelectionChangedListener {

		public void install(ISelectionProvider selectionProvider) {
			if (selectionProvider != null) {
				if (selectionProvider instanceof IPostSelectionProvider) {
					IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
					provider.addPostSelectionChangedListener(this);
				} else {
					selectionProvider.addSelectionChangedListener(this);
				}
			}
		}

		public void uninstall(ISelectionProvider selectionProvider) {
			if (selectionProvider != null) {
				if (selectionProvider instanceof IPostSelectionProvider) {
					IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
					provider.removePostSelectionChangedListener(this);
				} else {
					selectionProvider.removeSelectionChangedListener(this);
				}
			}
		}

	}

	/**
	 * This listener listens to selections in the outline and will update the
	 * editor selection accordingly.
	 */
	private final class OutlineSelectionChangedListener extends AbstractSelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			updateSelection(event);
		}

		public void updateSelection(SelectionChangedEvent event) {
			ISelection sel = event.getSelection();
			if (sel instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) sel;
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof EObject) {
					EObject astNode = (EObject) firstElement;
					NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(astNode);
					CompositeNode parserNode = nodeAdapter.getParserNode();

					int offset = parserNode.getOffset();
					int length = parserNode.getLength();

					getSourceViewer().revealRange(offset, length);
					getSourceViewer().setSelectedRange(offset, length);
				}
			}
		}

	}

	public IXtextDocument getDocument() {
		return XtextDocumentUtil.get(getSourceViewer());
	}

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(XtextEditor.class);

	public static final String ID = "org.eclipse.xtext.baseEditor"; //$NON-NLS-1$

	@Inject
	private XtextSourceViewerConfiguration sourceViewerConfiguration;

	@Inject(optional = true)
	private IContentOutlinePage outlinePage;

	// TODO private IFoldingUpdater foldingSupport;

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		System.out.println("doSetInput:"+input);
		super.doSetInput(input);
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		System.out.println("init:"+input);
		if (!(input instanceof IURIEditorInput))
			throw new IllegalArgumentException("Can only handle IURIEditorInputs");

		// do document provider setup
		setDocumentProvider(new XtextDocumentProvider());
		// source viewer setup
		setSourceViewerConfiguration(sourceViewerConfiguration);

		if (outlinePage != null) {
			if (outlinePage instanceof ISourceViewerAware)
				((ISourceViewerAware) outlinePage).setSourceViewer(getSourceViewer());
			outlinePage.addSelectionChangedListener(new OutlineSelectionChangedListener());
		}
		super.init(site, input);
	}

	public IResource getResource() {
		Object adapter = getEditorInput().getAdapter(IResource.class);
		if (adapter != null)
			return (IResource) adapter;
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IContentOutlinePage.class)) {
			return outlinePage;
		}
		return super.getAdapter(adapter);
	}

	@Override
	protected void createActions() {
		super.createActions();
		Action action = null;
		if (getSourceViewerConfiguration().getContentAssistant(getSourceViewer()) != null) {
			action = new ContentAssistAction(XtextUIMessages.getResourceBundle(), "ContentAssistProposal.", this);//$NON-NLS-1$
			action.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
			setAction("ContentAssistProposal", action);//$NON-NLS-1$
			markAsStateDependentAction("ContentAssistProposal", true); //$NON-NLS-1$
		}

		if (getSourceViewerConfiguration().getContentFormatter(getSourceViewer()) != null) {
			action = new TextOperationAction(XtextUIMessages.getResourceBundle(), "Format.", this, ISourceViewer.FORMAT); //$NON-NLS-1$
			action.setActionDefinitionId(Activator.PLUGIN_ID + ".FormatAction");
			setAction("Format", action); //$NON-NLS-1$
			markAsStateDependentAction("Format", true); //$NON-NLS-1$
			markAsSelectionDependentAction("Format", true); //$NON-NLS-1$
		}

		// TODO What's that?
//		SelectMarkerRulerAction markerAction = new XtextMarkerRulerAction(XtextUIMessages.getResourceBundle(),
//				"XtextSelectAnnotationRulerAction.", this, getVerticalRuler()); //$NON-NLS-1$
//		setAction(ITextEditorActionConstants.RULER_CLICK, markerAction);
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		// overwrite superclass implementation to allow folding
		fAnnotationAccess = createAnnotationAccess();
		fOverviewRuler = createOverviewRuler(getSharedColors());
		ISourceViewer projectionViewer = new ProjectionViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles);
		getSourceViewerDecorationSupport(projectionViewer);
		return projectionViewer;
	}

	private ProjectionSupport projectionSupport;

	@Override
	public void createPartControl(Composite parent) {

		super.createPartControl(parent);
		// We need ProjectionViewer to support Folding
		ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
		projectionSupport = new ProjectionSupport(projectionViewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning"); //$NON-NLS-1$
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error"); //$NON-NLS-1$
		projectionSupport.install();
		// TODO Folding stuff
	}

	@Override
	public void dispose() {
		super.dispose();
		if (projectionSupport != null)
			projectionSupport.dispose();
	}

	// @Override
	// protected String[] collectContextMenuPreferencePages() {
	// String[] ids = super.collectContextMenuPreferencePages();
	// String[] more = new String[ids.length + 4];
	// // NOTE: preference page at index 0 will be opened, see
	// // PreferencesUtil.createPreferenceDialogOn
	// String languageId = languageDescriptor.getId();
	//		more[0] = languageId + ".editor"; //$NON-NLS-1$
	// more[1] = languageId;
	//		more[2] = languageId + ".editor.templates"; //$NON-NLS-1$
	//		more[3] = languageId + ".editor.syntaxcoloring"; //$NON-NLS-1$
	// System.arraycopy(ids, 0, more, 4, ids.length);
	// return more;
	// }
}
