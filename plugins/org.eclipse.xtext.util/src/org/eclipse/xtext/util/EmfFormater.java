package org.eclipse.xtext.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
					// System.out.println(Msg.create("Path:").path(eobj));
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

	private static String refToStr(EObject obj, EReference ref) {
		Object o = obj.eGet(ref);
		if (o instanceof EObject) {
			EObject eo = (EObject) o;

			StringBuffer buf = new StringBuffer();
			if (eo instanceof ENamedElement)
				buf.append("'" + ((ENamedElement) eo).getName() + "' ");
			buf.append("ref:" + EcoreUtil.getURI(eo));
			return buf.toString();
		}
		return "?????";
	}
}
