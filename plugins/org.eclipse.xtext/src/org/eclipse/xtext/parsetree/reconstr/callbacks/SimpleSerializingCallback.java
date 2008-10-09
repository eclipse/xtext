package org.eclipse.xtext.parsetree.reconstr.callbacks;

import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.service.Inject;

public class SimpleSerializingCallback extends
		DefaultParsetreeReconstructorCallback {

	@Inject
	protected IValueConverterService converterService;

	protected OutputStream out;

	protected boolean outputHasStarted;

	protected void append(String str) {
		try {
			if (str == null)
				out.write("null".getBytes());
			else
				out.write(str.getBytes());
			outputHasStarted = true;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void before(IInstanceDescription current, AbstractElement element) {
		if (outputHasStarted)
			append(" ");
	}

	public void beginSerialize(OutputStream output) {
		super.beginSerialize(output);
		outputHasStarted = false;
		out = output;
	}

	public void crossRefCall(IInstanceDescription current, CrossReference call) {
		System.out.println("crossRefCall(" + call + ")");
		Assignment ass = GrammarUtil.containingAssignment(call);
		if (ass == null)
			throw new IllegalStateException("Unassigned cross reference "
					+ call);
		Object object = current.get(ass.getFeature());
		if (object instanceof EObject) {
			EObject obj = (EObject) object;
			// prepend(obj.eResource().getURIFragment(obj));
			before(current, call);
			append(obj.eResource().getURIFragment(obj));
		}
		throw new IllegalStateException("Can't serialize cross reference to "
				+ object);
	}

	public IValueConverterService getConverterService() {
		return converterService;
	}

	public void keywordCall(IInstanceDescription current, Keyword call) {
		before(current, call);
		append(call.getValue());
	}

	public void lexerRuleCall(IInstanceDescription current, RuleCall call,
			Object value) {
		before(current, call);
		append(converterService.toString(value, call.getName()));
	}

	public void setConverterService(IValueConverterService converterService) {
		this.converterService = converterService;
	}
}
