package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parsetree.reconstr.callbacks.SimpleSerializingCallback;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

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

	public static String grammarFragmentToStr(EObject obj) {
		IServiceScope ss = XtextStandaloneSetup.getServiceScope();
		IParseTreeConstructor ser = ServiceRegistry.getService(ss,
				IParseTreeConstructor.class);
		SimpleSerializingCallback cb = new SimpleSerializingCallback();
		ServiceRegistry.injectServices(ss, cb);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Map<String, Object> opt = new HashMap<String, Object>();
		opt.put(AbstractParseTreeConstructor.OPTION_SERIALIZER_STRATEGY, cb);
		ser.serialize(out, obj, opt);
		return out.toString();
	}

}
