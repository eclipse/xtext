/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class GenericFormatter<T extends EObject> extends AbstractFormatter2 {
	@SuppressWarnings("unchecked")
	@Override
	protected void _format(EObject obj, IFormattableDocument document) {
		format((T) obj, getRequest().getTextRegionAccess().getExtensions(), document);
	}

	protected abstract void format(T model, ITextRegionExtensions regionAccess, IFormattableDocument document);

	@Override
	public void format(Object obj, IFormattableDocument document) {
		if (obj instanceof XtextResource) {
			_format((XtextResource) obj, document);
			return;
		} else if (obj instanceof EObject) {
			_format((EObject) obj, document);
			return;
		} else if (obj == null) {
			_format((Void) null, document);
			return;
		} else if (obj != null) {
			_format(obj, document);
			return;
		}
	}
}
