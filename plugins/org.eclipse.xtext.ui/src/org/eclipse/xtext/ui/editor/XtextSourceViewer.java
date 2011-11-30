/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.SlaveDocumentEvent;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextSourceViewer extends ProjectionViewer {
	
	private static final Logger log = Logger.getLogger(XtextSourceViewer.class);

	@ImplementedBy(DefaultFactory.class)
	public interface Factory {
		XtextSourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles);
	}
	
	public static class DefaultFactory implements Factory {

		public XtextSourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler,
				IOverviewRuler overviewRuler, boolean showsAnnotationOverview, int styles) {
			return new XtextSourceViewer(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
		}
		
	}
	
	public XtextSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean showsAnnotationOverview, int styles) {
		super(parent, ruler, overviewRuler, showsAnnotationOverview, styles);
	}
	
	/**
	 * copied from org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer.prependTextPresentationListener(ITextPresentationListener)
	 */
	@SuppressWarnings("unchecked")
	public void prependTextPresentationListener(ITextPresentationListener listener) {
		Assert.isNotNull(listener);

		if (fTextPresentationListeners == null)
			fTextPresentationListeners= new ArrayList<ITextPresentationListener>();

		fTextPresentationListeners.remove(listener);
		fTextPresentationListeners.add(0, listener);
	}
	
	private int lengthDiff = Integer.MIN_VALUE;
	
	/**
	 * Informs all registered text listeners about the change specified by the
	 * widget command. This method does not use a robust iterator.
	 *
	 * @param cmd the widget command translated into a text event sent to all text listeners
	 */
	@Override
	protected void updateTextListeners(WidgetCommand cmd) {
		@SuppressWarnings("unchecked")
		List<ITextListener> textListeners= fTextListeners;
		if (textListeners != null) {
			textListeners= new ArrayList<ITextListener>(textListeners);
			DocumentEvent event= cmd.event;
			if (event instanceof SlaveDocumentEvent)
				event= ((SlaveDocumentEvent) event).getMasterEvent();
			int usedDiff = 0;
			if (event == null) {
				if (lengthDiff > 0)
					usedDiff = lengthDiff;
				lengthDiff = Integer.MIN_VALUE; 
			} else {
				lengthDiff = event.fText.length() - event.fLength;
			}
			int length = cmd.length + usedDiff;
			String text = cmd.text;
			if (usedDiff != 0) {
				try {
					text = getDocument().get(cmd.start, length);
				} catch(BadLocationException e) {
					length = cmd.length;
					log.debug("Ignored BadLocationException when fixing document events", e);
				}
			}
			TextEvent e= new TextEvent(cmd.start, length, text, cmd.preservedText, event, redraws()) {};
			for (int i= 0; i < textListeners.size(); i++) {
				ITextListener l= textListeners.get(i);
				l.textChanged(e);
			}
		}
	}
	
	public IContentAssistant getContentAssistant() {
		return fContentAssistant;
	}
}
