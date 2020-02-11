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

import java.util.Collections;
import java.util.Comparator;
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

	@Override
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

	/**
	 * Find annotations that include the given offset. Only annotations for which {@link #isHandled(Annotation)}
	 * returns {@code true} and {@link #isLineDiffInfo(Annotation)} returns {@code false} are included.
	 * 
	 * <p>If there are multiple annotations, those that start on the given line number are put first in the list,
	 * then those that start one line before, etc.</p>
	 * 
	 * <p>The offset can be negative. In that case only annotations that start on the given line number
	 * are returned.</p>
	 */
	public List<Annotation> getAnnotations(final int lineNumber, final int offset) {
		if (getAnnotationModel() == null) {
			return Collections.emptyList();
		}
		final Iterator<?> iterator = getAnnotationModel().getAnnotationIterator();
		List<Annotation> result = Lists.newArrayList();
		List<Integer> lineDiffs = Lists.newArrayList();
		while (iterator.hasNext()) {
			final Annotation annotation = (Annotation) iterator.next();
			if (isHandled(annotation) && !isLineDiffInfo(annotation)) {
				Position position = getAnnotationModel().getPosition(annotation);
				if (position != null) {
					final int start = position.getOffset();
					final int end = start + position.getLength();

					if (offset < 0 || start <= offset && offset <= end) {
						try {
							int lineDiff = Math.abs(lineNumber - getDocument().getLineOfOffset(start));
							if (lineDiff == 0 || offset >= 0) {
								// Insert the annotation according to its line number difference
								int index = lineDiffs.size();
								while (index > 0 && lineDiffs.get(index - 1) > lineDiff) {
									index--;
								}
								result.add(index, annotation);
								lineDiffs.add(index, lineDiff);
							}
						} catch (Exception x) {
							// Skip this annotation
						}
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * Sort the given annotations such that the resulting list contains first errors, then warnings, and then the rest.
	 */
	protected List<Annotation> sortBySeverity(List<Annotation> annotations) {
		if (annotations == null)
			return Collections.emptyList();
		if (annotations.size() <= 1)
			return annotations;
		List<Annotation> sorted = Lists.newArrayList(annotations);
		Collections.sort(sorted, Comparator.comparing(this::isError).reversed()
				.thenComparing(Comparator.comparing(this::isWarning).reversed()));
		return sorted;
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
				&& (isError(annotation) || isWarning(annotation) || isInfo(annotation) || isBookmark(annotation) || isSpelling(annotation));
	}
	
	protected boolean isError(Annotation annotation) {
		return markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.error");
	}
	
	protected boolean isWarning(Annotation annotation) {
		return markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.warning");
	}
	
	protected boolean isInfo(Annotation annotation) {
		return markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.info");
	}
	
	protected boolean isBookmark(Annotation annotation) {
		return markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.bookmark");
	}
	
	protected boolean isSpelling(Annotation annotation) {
		return markerAnnotationAccess.isSubtype(annotation.getType(), "org.eclipse.ui.workbench.texteditor.spelling");
	}

}
