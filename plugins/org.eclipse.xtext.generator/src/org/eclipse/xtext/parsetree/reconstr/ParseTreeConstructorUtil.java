package org.eclipse.xtext.parsetree.reconstr;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

public class ParseTreeConstructorUtil {

	private static String toIDString(String val) {
		if (val == null)
			return "";
		return val.replaceAll("[^a-zA-Z0-9_]", "");
	}

	public static String getUniqueElementName(AbstractElement ele) {
		if (ele == null)
			return "null";
		EObject obj = ele;
		// String r = ele.eClass().getName();
		String r = "";
		if (ele instanceof Keyword)
			r = ((Keyword) ele).getValue();
		else if (ele instanceof Assignment)
			r = ((Assignment) ele).getFeature();
		else if (ele instanceof RuleCall)
			r = ((RuleCall) ele).getName();
		else if (ele instanceof Action) {
			Action a = (Action) ele;
			r = a.getTypeName().getName() + "_" + a.getFeature();
		}
		r = toIDString(r);
		if (r.equals(""))
			r = ele.eClass().getName();
		else
			r = ele.eClass().getName() + "_" + r;

		while ((!(obj.eContainer() instanceof AbstractRule))
				&& obj.eContainer() != null) {
			EObject tmp = obj.eContainer();
			r = tmp.eContents().indexOf(obj) + "_" + r;
			obj = tmp;
		}
		if (obj.eContainer() instanceof AbstractRule)
			return ((AbstractRule) obj.eContainer()).getName() + "_" + r;
		return "UnknownRule_" + r;
	}

	// return the next sibling or the parent's next sibling
	public static AbstractElement getNextElementToCall(AbstractElement ele) {

		// we are probably done with the rule
		if (!(ele.eContainer() instanceof AbstractElement))
			return null;

		if (ele.eContainer() instanceof Group) {
			Group parent = (Group) ele.eContainer();
			List<AbstractElement> list = parent.getAbstractTokens();
			int i = list.indexOf(ele) - 1;
			if (i >= 0)
				return (AbstractElement) list.get(i);
			else
				return getNextElementToCall(parent);
		} else if (ele.eContainer() instanceof Alternatives) {
			return getNextElementToCall((Alternatives) ele.eContainer());
		} else
			return null;
	}
	

	public static AbstractElement getFirstChildToCall(AbstractElement ele) {
		List<EObject> list = ele.eContents();
		for (int i = list.size() - 1; i >= 0; i--)
			if (list.get(i) instanceof AbstractElement)
				return (AbstractElement) list.get(i);
		return null;
	}

}
