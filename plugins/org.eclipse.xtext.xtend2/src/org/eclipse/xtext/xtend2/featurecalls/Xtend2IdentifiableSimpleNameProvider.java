/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.featurecalls;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.featurecalls.IdentifiableSimpleNameProvider;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2IdentifiableSimpleNameProvider extends IdentifiableSimpleNameProvider {

	@Override
	public String getSimpleName(JvmIdentifiableElement element) {
		if (element instanceof XtendClass) {
			return "this";
		} else if (element instanceof XtendFunction) {
			return ((XtendFunction) element).getName();
		} else if (element instanceof XtendField) {
			return ((XtendField) element).getName();
		}
		return super.getSimpleName(element);
	}
}
