package org.eclipse.xtext.ui.common.editor.outline;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;

public abstract class AbstractSelectionChangedListener implements ISelectionChangedListener  {

	protected final XtextContentOutlinePage outlinePage;
	
	public AbstractSelectionChangedListener(XtextContentOutlinePage outlinePage) {
		this.outlinePage = outlinePage;
	}

	/**
	 * Installs this selection changed listener with the given selection provider. If
	 * the selection provider is a post selection provider, post selection changed
	 * events are the preferred choice, otherwise normal selection changed events
	 * are requested.
	 *
	 * @param selectionProvider
	 */
	public void install(ISelectionProvider selectionProvider) {
		if (selectionProvider == null)
			return;

		if (selectionProvider instanceof IPostSelectionProvider)  {
			IPostSelectionProvider provider= (IPostSelectionProvider) selectionProvider;
			provider.addPostSelectionChangedListener(this);
		} else  {
			selectionProvider.addSelectionChangedListener(this);
		}
	}

	/**
	 * Removes this selection changed listener from the given selection provider.
	 *
	 * @param selectionProvider the selection provider
	 */
	public void uninstall(ISelectionProvider selectionProvider) {
		if (selectionProvider == null)
			return;

		if (selectionProvider instanceof IPostSelectionProvider)  {
			IPostSelectionProvider provider= (IPostSelectionProvider) selectionProvider;
			provider.removePostSelectionChangedListener(this);
		} else  {
			selectionProvider.removeSelectionChangedListener(this);
		}
	}
	
	public IXtextDocument getDocument() {
		return XtextDocumentUtil.get(getSourceViewer());
	}

	protected ISourceViewer getSourceViewer() {
		Assert.isNotNull(outlinePage);
		return outlinePage.getSourceViewer();
	}
	
	public XtextContentOutlinePage getOutlinePage() {
		return outlinePage;
	}
	
}