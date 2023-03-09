/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.occurrences;

import java.util.Map;

import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultOccurrenceComputer.class)
public interface IOccurrenceComputer {

	Map<Annotation, Position> createAnnotationMap(XtextEditor editor, ITextSelection selection,
			SubMonitor monitor);

	boolean hasAnnotationType(String annotationType);
}
