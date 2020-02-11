/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;


import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.quickassist.QuickAssistAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

import com.google.inject.Inject;

/**
 * @author Knut Wannheden - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan Koehnlein
 */
public class XtextQuickAssistAssistant extends QuickAssistAssistant {

	protected ISourceViewer viewer;
	protected Position storedPosition;

	@Inject
	public XtextQuickAssistAssistant(XtextQuickAssistProcessor processor) {
		setQuickAssistProcessor(processor);
		setInformationControlCreator(createInformationControlCreator());
		setRestoreSelection();
	}

	protected void setRestoreSelection() {
		addCompletionListener(new ICompletionListener() {

			@Override
			public void assistSessionStarted(ContentAssistEvent event) {
				Point selectedRange = viewer.getSelectedRange();
				storePosition(selectedRange.x, selectedRange.y);
			}

			@Override
			public void assistSessionEnded(ContentAssistEvent event) {
				restorePosition();
			}

			@Override
			public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
			}
		});
	}

	protected AbstractReusableInformationControlCreator createInformationControlCreator() {
		return new AbstractReusableInformationControlCreator() {
			@Override
			public IInformationControl doCreateInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, (IInformationPresenter) null);
			}
		};
	}

	@Override
	public void install(ISourceViewer sourceViewer) {
		super.install(sourceViewer);
		viewer = sourceViewer;
	}
	
	@Override
	public void uninstall() {
		storedPosition = null;
		viewer = null;
		super.uninstall();
	}

	private void restorePosition() {
		if (storedPosition != null && !storedPosition.isDeleted() && viewer.getDocument() != null) {
			viewer.setSelectedRange(storedPosition.offset, storedPosition.length);
			viewer.revealRange(storedPosition.offset, storedPosition.length);
		}
		storedPosition = null;
	}

	private void storePosition(int currOffset, int currLength) {
		storedPosition = new Position(currOffset, currLength);
	}
}