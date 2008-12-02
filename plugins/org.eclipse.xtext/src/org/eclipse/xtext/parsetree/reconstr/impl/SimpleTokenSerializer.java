package org.eclipse.xtext.parsetree.reconstr.impl;

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
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAbstractToken;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IAssignmentToken;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor.IKeywordToken;
import org.eclipse.xtext.parsetree.reconstr.callbacks.SimpleSerializingCallback;
import org.eclipse.xtext.service.Inject;

public class SimpleTokenSerializer extends DefaultTokenSerializer {
	static final Logger logger = Logger
			.getLogger(SimpleSerializingCallback.class);

	@Inject
	protected IValueConverterService converterService;

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

	protected boolean outputHasStarted;

	protected OutputStream out;

	protected void afterElement(IInstanceDescription curr, AbstractElement ele)
			throws IOException {
	}

	protected void afterToken(IAbstractToken token) throws IOException {
	}

	protected void append(String str) throws IOException {
		if (str == null)
			out.write("null".getBytes());
		else
			out.write(str.getBytes());
		outputHasStarted = true;
	}

	protected void beforeElement(IInstanceDescription curr, AbstractElement ele)
			throws IOException {
		if (outputHasStarted)
			append(" ");
	}

	protected void beforeToken(IAbstractToken token) throws IOException {
	}

	protected void elementCrossRef(IInstanceDescription current,
			CrossReference call, EObject value) throws IOException {
		beforeElement(current, call);
		append(crossRefSerializer.serializeCrossRef(current, call, value));
		afterElement(current, call);
	}

	protected void elementKeyword(IInstanceDescription current, Keyword call)
			throws IOException {
		beforeElement(current, call);
		append(call.getValue());
		afterElement(current, call);
	}

	protected void elementLexerRuleCall(IInstanceDescription current,
			RuleCall call, Object value) throws IOException {
		beforeElement(current, call);
		append(converterService.toString(value, call.getRule().getName()));
		afterElement(current, call);
	}

	public void serialize(IAbstractToken firstToken, OutputStream out)
			throws IOException {
		outputHasStarted = false;
		this.out = out;
		for (IAbstractToken t = firstToken; t != null; t = t.getNext()) {
			beforeToken(t);
			token(t);
			afterToken(t);
		}
	}

	protected void token(IAbstractToken t) throws IOException {
		if (t instanceof IKeywordToken)
			tokenKeyword((IKeywordToken) t);
		else if (t instanceof IAssignmentToken)
			tokenAssignment((IAssignmentToken) t);
	}

	protected void tokenAssignment(IAssignmentToken ass) throws IOException {
		if (ass == null || ass.getType() == null)
			return;
		switch (ass.getType()) {
		case CR:
			elementCrossRef(ass.getCurrent(), (CrossReference) ass
					.getAssignmentElement(), (EObject) ass.getValue());
			break;
		case KW:
			elementKeyword(ass.getCurrent(), (Keyword) ass
					.getAssignmentElement());
			break;
		case LRC:
			elementLexerRuleCall(ass.getCurrent(), (RuleCall) ass
					.getAssignmentElement(), ass.getValue());
			break;
		case PRC: // nothing to do for Parser Rule Calls
			break;
		default:
			break;
		}

	}

	protected void tokenKeyword(IKeywordToken kw) throws IOException {
		elementKeyword(kw.getCurrent(), kw.getGrammarElement());
	}
}
