/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext2ecore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * 
 * @author koehnlein
 */
public class Xtext2EcoreExtensions {

	public static void setETypeEInt(EAttribute attribute) {
		attribute.setEType(EcorePackage.Literals.EINT);
	}

	public static void setETypeEString(EAttribute attribute) {
		attribute.setEType(EcorePackage.Literals.ESTRING);
	}

	public static void setETypeEBoolean(EAttribute attribute) {
		attribute.setEType(EcorePackage.Literals.EBOOLEAN);
	}

}
