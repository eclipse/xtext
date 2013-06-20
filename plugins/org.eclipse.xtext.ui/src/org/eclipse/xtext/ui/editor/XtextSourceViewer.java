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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.SlaveDocumentEvent;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextSourceViewer extends ProjectionViewer implements IAdaptable {
	
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
		if (cmd.event == null && cmd.length == 0 && cmd.start == 0 && cmd.text == null) {
			// handle plain redraw changes
			super.updateTextListeners(cmd);
		} else {
			@SuppressWarnings("unchecked")
			List<ITextListener> textListeners= fTextListeners;
			if (textListeners != null) {
				textListeners= new ArrayList<ITextListener>(textListeners);
				DocumentEvent event= cmd.event;
				if (event instanceof SlaveDocumentEvent)
					event= ((SlaveDocumentEvent) event).getMasterEvent();
				int usedDiff = 0;
				if (event == null) {
					if (lengthDiff > 0) {
						usedDiff = lengthDiff;
					}
					lengthDiff = Integer.MIN_VALUE;
				} else {
					lengthDiff = event.fText.length() - event.fLength;
				}
				int length = cmd.length + usedDiff;
				String text = cmd.text;
				if (usedDiff != 0) {
					try {
						IRegion model = getModelCoverage();
						length = Math.min(cmd.start + length, model.getLength()) - cmd.start;
						text = getDocument().get(cmd.start + model.getOffset(), length);
					} catch(BadLocationException e) {
						length = cmd.length;
						log.debug("Ignored BadLocationException when fixing document events", e);
					}
				}
				TextEvent e= new TextEvent(cmd.start, length, text, cmd.preservedText, event, redraws()) {};
				for (int i= 0; i < textListeners.size(); i++) {
					ITextListener l= textListeners.get(i);
					try {
						l.textChanged(e);
					} catch (NullPointerException exception) {
						// in 3.8 this throws NPEs (see https://bugs.eclipse.org/bugs/show_bug.cgi?id=369244)
						log.info(e);
					}
				}
			}
		}
	}
	
	public IContentAssistant getContentAssistant() {
		return fContentAssistant;
	}

	/**
	 * @since 2.3
	 */
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (IReconciler.class.isAssignableFrom(adapter)) {
			return fReconciler;
		}
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}
}
