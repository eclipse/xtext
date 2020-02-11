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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextHover;

import com.google.inject.Inject;

/**
 * The default implementation of a composite hover. Configured with the 
 * AnnotationWithQuickFixesHover and XtextHtmlHover.
 * 
 * @author Christoph Kulla - Initial contribution and API
 */
public class DefaultCompositeHover extends AbstractCompositeHover  {

	@Inject 
	protected AnnotationWithQuickFixesHover annotationHover;

	/**
	 * @noreference This field is not intended to be referenced by clients.
	 */
	@Inject
	protected IEObjectHover htmlHover;
	
	@Override
	protected List<ITextHover> createHovers() {
		List<ITextHover> list = new ArrayList<ITextHover>();
		list.add (annotationHover);
		if(htmlHover instanceof ITextHover)
			list.add ((ITextHover) htmlHover);
		return list;
	}

}
