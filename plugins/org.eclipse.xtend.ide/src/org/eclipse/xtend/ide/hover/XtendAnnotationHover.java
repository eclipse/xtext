/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.hover;

import org.eclipse.jface.text.source.Annotation;
import org.eclipse.xtend.ide.editor.OverrideIndicatorAnnotation;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.3
 */
public class XtendAnnotationHover extends ProblemAnnotationHover {

	@Override
	protected boolean isHandled(Annotation annotation) {
		return super.isHandled(annotation) || annotation instanceof OverrideIndicatorAnnotation;
	}

}
