package org.eclipse.xtext.parsetree.reconstr.callbacks;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;

public class SimpleSerializingCallback extends DefaultParsetreeReconstructorCallback {
	private StringBuffer buff = new StringBuffer();
	private IValueConverterService converterService;
	
	public SimpleSerializingCallback(IValueConverterService converterService) {
		this.converterService = converterService;
	}
	
	public StringBuffer getBuff() {
		return buff;
	}
	
	@Override
	public void keywordCall(IInstanceDescription current, Keyword call) {
		prepend(call.getValue());
		before(current, call);
	}
	
	
	protected void before(IInstanceDescription current,AbstractElement element) {
		if (buff.length()>0)
			prepend(" ");
	}
	
	protected void prepend(String s) {
		buff.insert(0, s);
	}
	
	@Override
	public void lexerRuleCall(IInstanceDescription current, RuleCall call) {
		Assignment assignment = GrammarUtil.containingAssignment(call);
		Object value = null;
		if (assignment!=null) {
			value = current.get(assignment.getFeature());
		}
		prepend(converterService.toString(value, call.getName()));
		before(current, call);
	}
	
	@Override
	public String toString() {
		return buff.toString();
	}
}
