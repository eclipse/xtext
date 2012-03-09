/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
public class XbaseDispatchingEObjectTextHover extends DispatchingEObjectTextHover {
	
	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
		Pair<EObject, IRegion> original = super.getXtextElementAt(resource, offset);
		EObject object = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);
		if (object != null && object instanceof XAbstractFeatureCall) {
			EObject feature = ((XAbstractFeatureCall) object).getFeature();
			if (feature instanceof JvmOperation)
				if (original != null)
					return Tuples.create(object, original.getSecond());
		}
		return original;
	}
}
