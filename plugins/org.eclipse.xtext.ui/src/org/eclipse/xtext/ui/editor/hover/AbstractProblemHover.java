/*******************************************************************************
 * Copyright (c) 2010 Christoph Kulla
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Christoph Kulla - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ILineDiffInfo;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Base class for all hovers showing annotations and problems.
 * 
 * @author Christoph Kulla - Initial contribution and API
 * @author Holger Schill
 */
public abstract class AbstractProblemHover extends AbstractHover {

	@Inject
	private DefaultMarkerAnnotationAccess markerAnnotationAccess;

	@Override
	public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
		int lineNumber;
		try {
			lineNumber = textViewer.getDocument().getLineOfOffset(offset);
			return getHoverRegionInternal(lineNumber, offset);
		} catch (BadLocationException e) {
		}
		return null;
	}

	protected abstract IRegion getHoverRegionInternal(int lineNumber, int offset);

	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		int lineNumber;
		try {
			lineNumber = getLineNumber(textViewer, hoverRegion);
			return getHoverInfoInternal(textViewer, lineNumber, hoverRegion.getOffset());
		} catch (final BadLocationException e) {
			return null;
		}
	}

	protected abstract Object getHoverInfoInternal(ITextViewer textViewer, int lineNumber, int offset);

	protected IAnnotationModel getAnnotationModel() {
		return sourceViewer.getAnnotationModel();
	}

	public List<Annotation> getAnnotations(final int lineNumber, final int offset) {
		if (getAnnotationModel() == null) {
			return null;
		}
		final Iterator<?> iterator = getAnnotationModel().getAnnotationIterator();
		List<Annotation> result = Lists.newArrayList();
		while (iterator.hasNext()) {
			final Annotation annotation = (Annotation) iterator.next();
			if (isHandled(annotation)) {
				Position position = getAnnotationModel().getPosition(annotation);
				if (position != null) {
					final int start = position.getOffset();
					final int end = start + position.getLength();

					if (offset > 0 && !(start <= offset && offset <= end)) {
						continue;
					}
					try {
						if (lineNumber != getDocument().getLineOfOffset(start)) {
							continue;
						}
					} catch (final Exception x) {
						continue;
					}
					if (!isLineDiffInfo(annotation)) {
						result.add(annotation);
					}
				}
			}
		}
		return result;
	}

	protected boolean isLineDiffInfo(Annotation annotation) {
		return annotation instanceof ILineDiffInfo;
	}

	/**
	 * @since 2.1
	 */
	protected boolean isHandled(Annotation annotation) {
		return null != annotation
				&& !annotation.isMarkedDeleted()
				&& (markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.error") 
						|| markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.warning")
						|| markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.info")
						|| markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.bookmark")
						|| markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.spelling"));
	}

}
