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
package org.eclipse.xtext.ui.editor.hover;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ILineDiffInfo;
import org.eclipse.jface.text.source.ISourceViewer;

import com.google.common.collect.Sets;

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
		if(model == null) {
			return null;
		}
		final Set<String> messages = Sets.newLinkedHashSet();
		final Iterator<?> iterator = model.getAnnotationIterator();
		while (iterator.hasNext()) {
			final Annotation annotation = (Annotation) iterator.next();
			if (!annotation.isMarkedDeleted()) {
				Position position = model.getPosition(annotation);
				if (position != null) {
					final int start = position.getOffset();
					final int end = start + position.getLength();
		
					if (offset > 0 && !(start <= offset && offset <= end)) {
						continue;
					}
					try {
						if (lineNumber != sourceViewer.getDocument().getLineOfOffset(start)) {
							continue;
						}
					} catch (final Exception x) {
						continue;
					}
					if (annotation.getText() != null && !isLineDiffInfo(annotation)) {
						messages.add(annotation.getText().trim());
					} 
				}
			}
		}
		return formatInfo(messages);
	}
	
	public boolean isLineDiffInfo(Annotation annotation) {
		return annotation instanceof ILineDiffInfo;
	}
}
