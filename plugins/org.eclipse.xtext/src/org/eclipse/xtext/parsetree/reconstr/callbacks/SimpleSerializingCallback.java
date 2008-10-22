package org.eclipse.xtext.parsetree.reconstr.callbacks;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.service.Inject;

public class SimpleSerializingCallback extends
		DefaultParsetreeReconstructorCallback {

	static final Logger logger = Logger
			.getLogger(SimpleSerializingCallback.class);

	@Inject
	protected IValueConverterService converterService;

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

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

	public void crossRefCall(IInstanceDescription current, CrossReference call,
			EObject value) {
		before(current, call);
		append(crossRefSerializer.serializeCrossRef(current, call, value));
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
}
