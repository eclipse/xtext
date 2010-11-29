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
package org.eclipse.xtext.ui.editor.hover.html;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;

import com.google.inject.Inject;

/**
 * Returns a html string as documentation. Delegates to another IEObjectDocumentationProvider and adds
 * the objects type and label at the beginning.
 * 
 * @author Christoph Kulla - Initial contribution and API
 * @author Sven Efftinge
 */
public class DefaultEObjectHoverProvider implements IEObjectHoverProvider {

	@Inject
	private ILabelProvider labelProvider;

	@Inject
	private IEObjectDocumentationProvider decoratedProvider;

	public String getHoverInfoAsHtml(EObject o) {
		StringBuffer buffer = new StringBuffer();
		buffer.append (getFirstLine(o));
		String documentation = getDocumentation(o);
		if (documentation!=null && documentation.length()>0) {
			buffer.append ("<p>");
			buffer.append (documentation);
			buffer.append("</p>");
		}
		return buffer.toString();
	}

	protected String getDocumentation(EObject o) {
		return decoratedProvider.getDocumentation(o);
	}

	protected String getFirstLine(EObject o) {
		return o.eClass().getName()+ " <b>"+getLabel(o)+"</b>";
	}
	
	protected String getLabel (EObject o) {
		return getLabelProvider().getText(o);
	}
	
	protected ILabelProvider getLabelProvider () {
		return labelProvider;
	}

}

