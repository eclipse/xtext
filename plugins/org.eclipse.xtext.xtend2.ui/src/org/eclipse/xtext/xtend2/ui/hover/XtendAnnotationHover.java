/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.hover;

import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.eclipse.xtext.xtend2.ui.editor.OverrideIndicatorAnnotation;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtendAnnotationHover extends ProblemAnnotationHover {

	@Override
	protected boolean isHandled(Annotation annotation) {
		return super.isHandled(annotation) || annotation instanceof OverrideIndicatorAnnotation;
	}

}
