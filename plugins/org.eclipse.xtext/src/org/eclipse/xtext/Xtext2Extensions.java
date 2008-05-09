/*******************************************************************************
 * Copyright (c) 2008 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/

package org.eclipse.xtext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xtextutil.BuiltinType;
import org.eclipse.xtext.xtextutil.XtextutilFactory;

/**
 * @author Jan Köhnlein
 * 
 */
public class Xtext2Extensions {

	private static Log log = LogFactory.getLog(Xtext2Extensions.class);;

	private static final BuiltinType BUILTIN_EBOOLEAN;
	private static final BuiltinType BUILTIN_EINT;
	private static final BuiltinType BUILTIN_EDOUBLE;
	private static final BuiltinType BUILTIN_ESTRING;

	static {
		BUILTIN_EBOOLEAN = XtextutilFactory.eINSTANCE.createBuiltinType();
		BUILTIN_EBOOLEAN.setName("EBoolean");
		BUILTIN_EBOOLEAN.setEClassifier(EcorePackage.Literals.EBOOLEAN);
		BUILTIN_EINT = XtextutilFactory.eINSTANCE.createBuiltinType();
		BUILTIN_EINT.setName("EInt");
		BUILTIN_EINT.setEClassifier(EcorePackage.Literals.EINT);
		BUILTIN_EDOUBLE = XtextutilFactory.eINSTANCE.createBuiltinType();
		BUILTIN_EDOUBLE.setName("EDouble");
		BUILTIN_EDOUBLE.setEClassifier(EcorePackage.Literals.EDOUBLE);
		BUILTIN_ESTRING = XtextutilFactory.eINSTANCE.createBuiltinType();
		BUILTIN_ESTRING.setName("EString");
		BUILTIN_ESTRING.setEClassifier(EcorePackage.Literals.ESTRING);
	};

	public static BuiltinType BuiltinEBoolean() {
		return BUILTIN_EBOOLEAN;
	}

	public static BuiltinType BuiltinEInt() {
		return BUILTIN_EINT;
	}

	public static BuiltinType BuiltinEDouble() {
		return BUILTIN_EDOUBLE;
	}

	public static BuiltinType BuiltinEString() {
		return BUILTIN_ESTRING;
	}

	public static final EPackage loadEPackage(String uriAsString) {
		URI uri = URI.createURI(uriAsString);
		Resource resource = new ResourceSetImpl().getResource(uri, true);
		for (TreeIterator<EObject> allContents = resource.getAllContents(); allContents
				.hasNext();) {
			EObject next = allContents.next();
			if (next instanceof EPackage) {
				EPackage ePackage = (EPackage) next;
				if (ePackage.getNsURI() != null
						&& ePackage.getNsURI().equals(uriAsString)) {
					return ePackage;
				}
			}
		}
		log.error("Could not load EPackage with nsURI" + uriAsString);
		return null;
	}

}
