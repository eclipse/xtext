/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import java.util.List;

import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.ISourceViewerAware;

/**
 * The CompositeHover is a hover which delegates calls to a list of hovers. It iterates through this list of hovers and
 * chooses the first one which provides a region in getHoverRegion(). Override the method createHovers() to configure
 * the list of hovers.
 * 
 * @author Christoph Kulla - Initial contribution and API
 * @author Holger Schill
 */
public abstract class AbstractCompositeHover implements ITextHover, ITextHoverExtension, ITextHoverExtension2,
		ISourceViewerAware {

	private List<ITextHover> hovers;
	private ITextHover currentHover;

	public AbstractCompositeHover() {
		super();
	}

	public List<ITextHover> getHovers() {
		if (hovers == null)
			hovers = createHovers();
		return hovers;
	}

	abstract protected List<ITextHover> createHovers();

	@Override
	public void setSourceViewer(ISourceViewer sourceViewer) {
		if (getHovers() != null) {
			for (ITextHover hover : getHovers()) {
				if (hover instanceof ISourceViewerAware)
					((ISourceViewerAware) hover).setSourceViewer(sourceViewer);
			}
		}
	}

	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		if (getHovers() != null) {
			for (ITextHover hover : getHovers()) {
				IRegion region = hover.getHoverRegion(textViewer, offset);
				if (region != null) {
					// We always take the first that answers with a region
					// In org.eclipse.xtext.ui.editor.hover.DefaultCompositeHover.createHovers() the AnnotationWithQuickFixesHover 
					// is always the first and answers with a region only when there is a problemmarker
					// In all other cases an instance of org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover is the next in the order.
					currentHover = hover;
					return region;
				}
			}
		}
		currentHover = null;
		return null;
	}

	@Override
	@Deprecated
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		// should never be called
		if (currentHover != null) {
			return currentHover.getHoverInfo(textViewer, hoverRegion);
		}
		return null;
	}

	@Override
	@SuppressWarnings("deprecation")
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		if (currentHover != null) {
			if (currentHover instanceof ITextHoverExtension2)
				return ((ITextHoverExtension2) currentHover).getHoverInfo2(textViewer, hoverRegion);
			else {
				return currentHover.getHoverInfo(textViewer, hoverRegion);
			}
		}
		return null;
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		if (currentHover instanceof ITextHoverExtension)
			return ((ITextHoverExtension) currentHover).getHoverControlCreator();
		return null;
	}

}