/*******************************************************************************
 * Copyright (c) 2007 Sven Efftinge (http://www.efftinge.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     committers of openArchitectureWare
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.XtextUIMessages;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Christoph Kulla - Adaptation to AbstractProblemHover
 */
public class ProblemAnnotationHover extends AbstractProblemHover implements IAnnotationHover {
	
	// IAnnotationHover
	
	@Override
	public String getHoverInfo(final ISourceViewer sourceViewer, final int lineNumber) {
		Object o = getHoverInfoInternal(sourceViewer, lineNumber, -1);
		if (o!=null)
			return o.toString();
		return null;
	}
	
		
	// AbstractProblemHover
	
	@Override
	protected Region getHoverRegionInternal(final int lineNumber, final int offset) {
		List<Annotation> annotations = getAnnotations(lineNumber, offset);
		for (Annotation annotation : sortBySeverity(annotations)) {
			Position position = sourceViewer.getAnnotationModel().getPosition(annotation);
			if (position != null) {
				final int start = position.getOffset();
				return new Region(start, position.getLength());	
			}
		}
		return null;
	}
		
	@Override
	protected Object getHoverInfoInternal(final ITextViewer textViewer, final int lineNumber, final int offset) {
		final Set<String> messages = Sets.newLinkedHashSet();
		List<Annotation> annotations = getAnnotations(lineNumber, offset);
		for (Annotation annotation : annotations) {
			String text = annotation.getText();
			if (text != null) {
				messages.add(text.trim());
			}
		}
		if (messages.size() > 0)
			return formatInfo(messages);
		return null;
	}
	
	protected String formatInfo(final Collection<String> messages) {
		final StringBuilder buffer = new StringBuilder();
		if (messages.size() > 1) {
			buffer.append(XtextUIMessages.AbstractHover_MultipleMarkers);
			final Iterator<String> e = messages.iterator();
			while (e.hasNext()) {
				splitInfo("- " + e.next() + "\n", buffer);
			}
			buffer.deleteCharAt(buffer.length()-1);
		}
		else if (messages.size() == 1) {
			splitInfo(messages.iterator().next(), buffer);
		}
		return buffer.toString();
	}
	
	private String splitInfo(final String message, final StringBuilder buffer) {
		String msg = message;
		String prefix = "";
		int pos;
		do {
			pos = msg.indexOf(" ", 60);
			if (pos > -1) {
				buffer.append(prefix + msg.substring(0, pos) + "\n");
				msg = msg.substring(pos);
				prefix = "  ";
			}
			else {
				buffer.append(prefix + msg);
			}
		} while (pos > -1);
		return buffer.toString();
	}

}
