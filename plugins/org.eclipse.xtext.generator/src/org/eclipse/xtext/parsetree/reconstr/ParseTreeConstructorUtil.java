package org.eclipse.xtext.parsetree.reconstr;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parsetree.reconstr.impl.SimpleTokenSerializer;
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
			r = ((RuleCall) ele).getRule().getName();
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

	private static IParseTreeConstructor AST_SERIALIZER = ServiceRegistry
			.getService(XtextStandaloneSetup.getServiceScope(),
					IParseTreeConstructor.class);
	private static ITokenSerializer TOKEN_SERIALIZER = createTokenSerializer();

	private static ITokenSerializer createTokenSerializer() {
		ITokenSerializer ts = new SimpleTokenSerializer();
		ServiceRegistry.injectServices(XtextStandaloneSetup.getServiceScope(),
				ts);
		return ts;
	}

	public static String grammarFragmentToStr(EObject obj) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			 SerializerUtil
					.serialize(AST_SERIALIZER, TOKEN_SERIALIZER, obj, out);
			return out.toString();
		} catch (Throwable e) {
			return "(error)";
		}
	}

	public static List<AbstractElement> getNestedElementsFromAssignment(
			Assignment assignment) {
		AbstractElement t = assignment.getTerminal();
		ArrayList<AbstractElement> r = new ArrayList<AbstractElement>();
		if (t instanceof Keyword || t instanceof RuleCall
				|| t instanceof CrossReference)
			r.add(t);
		else {
			r.addAll(GrammarUtil.containedKeywords(t));
			r.addAll(GrammarUtil.containedRuleCalls(t));
			r.addAll(GrammarUtil.containedCrossReferences(t));
		}
		return r;
	}

}
