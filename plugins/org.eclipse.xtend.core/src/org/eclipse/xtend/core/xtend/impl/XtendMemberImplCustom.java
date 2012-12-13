/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.xtend.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendMemberImplCustom extends XtendMemberImpl {

	@Override
	public EList<XAnnotation> getAnnotations() {
		if (getAnnotationInfo()!=null) {
			return getAnnotationInfo().getAnnotations();
		}
		return super.getAnnotations();
	}
	
}
