/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class EmfFormater {
	@SuppressWarnings("unchecked")
	public static String objToStr(Object obj, String ident) {
		String innerIdent = "  " + ident;
		if (obj instanceof EObject) {
			StringBuffer buf = new StringBuffer();
			EObject eobj = (EObject) obj;
			buf.append(eobj.eClass().getName() + " {\n");
			for (EStructuralFeature f : eobj.eClass()
					.getEAllStructuralFeatures()) {
				if (!eobj.eIsSet(f))
					continue;
				String fType = "unknown";
				String val = "???";
				if (f instanceof EReference) {
					EReference r = (EReference) f;
					if (r.isContainment()) {
						val = objToStr(eobj.eGet(f), innerIdent);
						fType = "cref";
					} else {
						val = refToStr(eobj, r);
						fType = "ref";
					}
				} else if (f instanceof EAttribute) {
					fType = "attr";
					// logger.debug(Msg.create("Path:").path(eobj));
					Object at = eobj.eGet(f);
					if (eobj != at)
						val = objToStr(at, innerIdent);
					else
						val = "<same as container object>";
				}
				String vType = f.getEType().getName();
				String name = f.getName();
				buf.append(innerIdent + fType + " " + vType + " " + name + " "
						+ val + "\n");
			}
			buf.append(ident + "}");
			return buf.toString();
		}
		if (obj instanceof Collection) {
			StringBuffer buf = new StringBuffer();
			buf.append("[\n");
			for (Object o : (Collection) obj)
				buf.append(innerIdent + objToStr(o, innerIdent) + "\n");
			buf.append(ident + "]");
			return buf.toString();
		}
		if (obj != null)
			return "'" + obj + "'";
		return "null";
	}

	@SuppressWarnings("unchecked")
	private static String refToStr(EObject obj, EReference ref) {
		StringBuffer buf = new StringBuffer();
		Object o = obj.eGet(ref);
		if (o instanceof EObject) {
			EObject eo = (EObject) o;

			if (eo instanceof ENamedElement)
				buf.append("'" + ((ENamedElement) eo).getName() + "' ");
			buf.append("ref:" + getURI(obj, eo));
			return buf.toString();
		}
		if (o instanceof Collection) {
			buf.append("[");
			for (Iterator i = ((Collection) o).iterator(); i.hasNext();) {
				Object item = (Object) i.next();
				buf.append(getURI(obj, (EObject) item));
				if (i.hasNext())
					buf.append(", ");
			}
			buf.append("]");
			return buf.toString();
		}
		return "?????";
	}

	private static String getURI(EObject parent, EObject target) {
		Resource r = target.eResource();
		if (r == null)
			return "(resource null)";
		if (parent.eResource() == r)
			return r.getURIFragment(target);
		return r.getURI() + r.getURIFragment(target);
	}
}
