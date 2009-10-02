/*******************************************************************************
 * Copyright (c) 2007 Sven Efftinge (http://www.efftinge.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.hover;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ProblemHover extends AbstractHover {

	public ProblemHover(final ISourceViewer sourceViewer) {
		super(sourceViewer);
	}

	@Override
	protected String getHoverInfoInternal(final int lineNumber,
			final int offset) {
		final IAnnotationModel model = sourceViewer.getAnnotationModel();
		final List<String> messages = new ArrayList<String>();

		final Iterator<?> iterator = model.getAnnotationIterator();
		while (iterator.hasNext()) {
			final Annotation annotation = (Annotation) iterator.next();
			if (annotation.isMarkedDeleted()) {
				continue;
			}
			Position position = model.getPosition(annotation);
			final int start = position.getOffset();
			final int end = start + position.getLength();

			if (offset > 0 && !(start <= offset && offset <= end)) {
				continue;
			}
			try {
				if (lineNumber != sourceViewer.getDocument().getLineOfOffset(
						start)) {
					continue;
				}
			} catch (final Exception x) {
				continue;
			}
			messages.add(annotation.getText().trim());
		}
		return formatInfo(messages);
	}
}
