/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.IResourceProvider;
import org.eclipse.compare.ISharedDocumentAdapter;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.contentmergeviewer.IMergeViewerContentProvider;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.compare.structuremergeviewer.ICompareInput;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.PartEventAction;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Maps;
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultMergeViewer extends TextMergeViewer {
	private final static IUnitOfWork<Boolean, XtextResource> TEST_EXISTING_XTEXT_RESOURCE = new IUnitOfWork<Boolean, XtextResource>() {
		@Override
		public Boolean exec(XtextResource xtextResource) throws Exception {
			return xtextResource != null;
		}
	};
	private static final IResourceProvider NULL_RESOURCE_PROVIDER = new IResourceProvider() {
		@Override
		public IResource getResource() {
			return null;
		}
	};

	protected IDocumentProvider documentProvider;
	protected Map<ISourceViewer, DefaultMergeEditor> sourceViewerEditorMap;
	protected Provider<XtextSourceViewerConfiguration> sourceViewerConfigurationProvider;
	/**
	 * @since 2.19
	 */
	protected XtextDocumentUtil xtextDocumentUtil;

	private Map<Object, IStreamContentAccessor> inputObjectStreamContentAccessorMap = Maps.newHashMap();

	public DefaultMergeViewer(Composite parent, int styles, CompareConfiguration compareConfiguration,
			IDocumentProvider documentProvider) {
		super(parent, styles | SWT.LEFT_TO_RIGHT, compareConfiguration);
		this.documentProvider = documentProvider;
	}

	public DefaultMergeViewer(Composite parent, int styles, CompareConfiguration compareConfiguration,
			StreamContentDocumentProvider documentProvider,
			Provider<XtextSourceViewerConfiguration> sourceViewerConfigurationProvider) {
		super(parent, styles | SWT.LEFT_TO_RIGHT, compareConfiguration);
		this.documentProvider = documentProvider;
		this.sourceViewerConfigurationProvider = sourceViewerConfigurationProvider;
	}

	@Override
	protected void updateContent(Object ancestor, Object left, Object right) {
		ancestor = updateAsDocument(ancestor);
		left = updateAsDocument(left);
		right = updateAsDocument(right);
		super.updateContent(ancestor, left, right);
	}

	protected Object updateAsDocument(Object object) {
		if (object instanceof IResourceProvider && supportsSharedDocuments(object)) {
			return object;
		}
		if (object instanceof IStreamContentAccessor) {
			try {
				StreamContentAccessorDelegate streamContentAccessorDelegate = new StreamContentAccessorDelegate(
						(IStreamContentAccessor) object, createResourceProvider(object));
				documentProvider.connect(streamContentAccessorDelegate);
				inputObjectStreamContentAccessorMap.put(object, streamContentAccessorDelegate);
				return documentProvider.getDocument(streamContentAccessorDelegate);
			} catch (CoreException coreException) {
				throw new WrappedException(coreException);
			}
		}
		return object;
	}

	protected IResourceProvider createResourceProvider(Object object) {
		if (getInput() instanceof ICompareInput && object instanceof ITypedElement) {
			return new CompareInputResourceProvider(((ICompareInput) getInput()), (ITypedElement) object);
		}
		return NULL_RESOURCE_PROVIDER;
	}

	private boolean supportsSharedDocuments(Object object) {
		return Adapters.adapt(object, ISharedDocumentAdapter.class) != null;
	}

	@Override
	protected void handleDispose(DisposeEvent event) {
		disposeEditors();
		disconnectDocuments();
		super.handleDispose(event);
	}

	protected void disposeEditors() {
		if (sourceViewerEditorMap != null) {
			for (Iterator<DefaultMergeEditor> iterator = sourceViewerEditorMap.values().iterator(); iterator.hasNext();) {
				DefaultMergeEditor mergeEditor = iterator.next();
				mergeEditor.dispose();
			}
			sourceViewerEditorMap = null;
		}
	}

	protected void disconnectDocuments() {
		IMergeViewerContentProvider contentProvider = (IMergeViewerContentProvider) getContentProvider();
		Object ancestorContent = contentProvider.getAncestorContent(getInput());
		Object leftContent = contentProvider.getLeftContent(getInput());
		Object rightContent = contentProvider.getRightContent(getInput());
		documentProvider.disconnect(inputObjectStreamContentAccessorMap.get(ancestorContent));
		documentProvider.disconnect(inputObjectStreamContentAccessorMap.get(leftContent));
		documentProvider.disconnect(inputObjectStreamContentAccessorMap.get(rightContent));
	}

	@Override
	protected void configureTextViewer(TextViewer textViewer) {
		if (textViewer instanceof SourceViewer) {
			configureSourceViewer(((SourceViewer) textViewer));
		}
	}

	protected void configureSourceViewer(SourceViewer sourceViewer) {
		IEditorInput editorInput = getEditorInput(sourceViewer);
		SourceViewerConfiguration sourceViewerConfiguration = createSourceViewerConfiguration(sourceViewer, editorInput);
		sourceViewer.unconfigure();
		sourceViewer.configure(sourceViewerConfiguration);
		IXtextDocument xtextDocument = xtextDocumentUtil.getXtextDocument(sourceViewer);
		if (xtextDocument != null) {
			if (!xtextDocument.readOnly(TEST_EXISTING_XTEXT_RESOURCE)) {
				String[] configuredContentTypes = sourceViewerConfiguration.getConfiguredContentTypes(sourceViewer);
				for (String contentType : configuredContentTypes) {
					sourceViewer.removeTextHovers(contentType);
				}
				sourceViewer.setHyperlinkDetectors(null, sourceViewerConfiguration.getHyperlinkStateMask(sourceViewer));
			}
		}
	}

	protected SourceViewerConfiguration createSourceViewerConfiguration(SourceViewer sourceViewer,
			IEditorInput editorInput) {
		SourceViewerConfiguration sourceViewerConfiguration = null;
		if (editorInput != null && getEditor(sourceViewer) != null) {
			DefaultMergeEditor mergeEditor = getEditor(sourceViewer);
			sourceViewerConfiguration = mergeEditor.getXtextSourceViewerConfiguration();
			try {
				mergeEditor.init((IEditorSite) mergeEditor.getSite(), editorInput);
				mergeEditor.createActions();
			} catch (PartInitException partInitException) {
				throw new WrappedException(partInitException);
			}
		} else {
			sourceViewerConfiguration = sourceViewerConfigurationProvider.get();
		}
		return sourceViewerConfiguration;
	}

	@Override
	protected void setEditable(ISourceViewer sourceViewer, boolean state) {
		super.setEditable(sourceViewer, state);
		DefaultMergeEditor mergeEditor = getEditor(sourceViewer);
		if (mergeEditor != null) {
			mergeEditor.setEditable(state);
		}
	}

	@Override
	protected void setActionsActivated(SourceViewer sourceViewer, boolean state) {
		DefaultMergeEditor mergeEditor = getEditor(sourceViewer);
		if (mergeEditor != null) {
			mergeEditor.setActionsActivated(state);
			IAction saveAction = mergeEditor.getAction(ITextEditorActionConstants.SAVE);
			if (saveAction instanceof IPageListener) {
				PartEventAction partEventAction = (PartEventAction) saveAction;
				IWorkbenchPart compareEditorPart = getCompareConfiguration().getContainer().getWorkbenchPart();
				if (state) {
					partEventAction.partActivated(compareEditorPart);
				} else {
					partEventAction.partDeactivated(compareEditorPart);
				}
			}
		}
	}

	@Override
	protected IEditorInput getEditorInput(ISourceViewer sourceViewer) {
		IEditorInput editorInput = super.getEditorInput(sourceViewer);
		if (editorInput == null) {
			return null;
		}
		if (getSite() == null) {
			return null;
		}
		if (!(editorInput instanceof IStorageEditorInput)) {
			return null;
		}
		return editorInput;
	}

	@Override
	protected SourceViewer createSourceViewer(Composite parent, int textOrientation) {
		if (getSite() != null) {
			if (sourceViewerEditorMap == null) {
				sourceViewerEditorMap = Maps.newHashMapWithExpectedSize(3);
			}
			DefaultMergeEditor mergeEditor = createMergeEditor();
			mergeEditor.setXtextEditorCallback(new CompoundXtextEditorCallback(null));
			mergeEditor.setTextOrientation(textOrientation);
			mergeEditor.setInternalSite(getSite());
			mergeEditor.createPartControl(parent);
			SourceViewer internalSourceViewer = (SourceViewer) mergeEditor.getInternalSourceViewer();
			sourceViewerEditorMap.put(internalSourceViewer, mergeEditor);
			return internalSourceViewer;
		}

		return super.createSourceViewer(parent, textOrientation);
	}

	protected DefaultMergeEditor createMergeEditor() {
		@SuppressWarnings("unchecked")
		Provider<DefaultMergeEditor> mergeEditorProvider = (Provider<DefaultMergeEditor>) getCompareConfiguration()
				.getProperty(DefaultMergeEditor.PROVIDER);
		DefaultMergeEditor mergeEditor = mergeEditorProvider.get();
		return mergeEditor;
	}

	protected IWorkbenchPartSite getSite() {
		IWorkbenchPart workbenchPart = getCompareConfiguration().getContainer().getWorkbenchPart();
		return workbenchPart != null ? workbenchPart.getSite() : null;
	}

	@Override
	protected boolean isEditorBacked(ITextViewer textViewer) {
		return getSite() != null;
	}

	protected DefaultMergeEditor getEditor(ISourceViewer sourceViewer) {
		DefaultMergeEditor mergeEditor = null;
		if (sourceViewerEditorMap != null) {
			mergeEditor = sourceViewerEditorMap.get(sourceViewer);
		}
		return mergeEditor;
	}

	/**
	 * @since 2.19
	 */
	protected void setXtextDocumentUtil(XtextDocumentUtil xtextDocumentUtil) {
		this.xtextDocumentUtil = xtextDocumentUtil;
	}

}
