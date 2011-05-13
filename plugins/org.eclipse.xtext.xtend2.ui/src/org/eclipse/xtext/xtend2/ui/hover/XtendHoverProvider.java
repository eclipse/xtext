/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.ui.hover.XbaseHoverProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtendHoverProvider extends XbaseHoverProvider {

	@Override
	protected String getFirstLineLabel(EObject o) {
		String label = super.getFirstLineLabel(o);
		if (label != null) {
			int colon = label.indexOf(':');
			if (colon >= 0)
				label = label.substring(0, colon - 1);
		}
		return label;
	}

}
