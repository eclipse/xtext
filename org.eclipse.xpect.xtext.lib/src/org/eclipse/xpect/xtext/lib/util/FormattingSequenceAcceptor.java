package org.eclipse.xpect.xtext.lib.util;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.formatting.IFormatterExtension;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.TokenStreamSequenceAdapter;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;

@SuppressWarnings("restriction")
public class FormattingSequenceAcceptor implements ISequenceAcceptor {

	private static class Event {
		private final AbstractElement grammarElement;
		private final EObject sementicElement;
		private final String token;

		private Event(EObject sementicElement, AbstractElement grammarElement, String token) {
			super();
			this.sementicElement = sementicElement;
			this.grammarElement = grammarElement;
			this.token = token;
		}
	}

	public static interface IAcceptor {
		void accept(EObject semanticElement, EObject grammarElement, String token, boolean hidden);
	}

	private class Out implements ITokenStream {
		public void flush() throws IOException {
		}

		protected void write(EObject grammarElement, String value) {
			if (grammarElement instanceof AbstractElement) {
				Event first = queue.pollFirst();
				AbstractElement firstGrammarElement = first.grammarElement;
				CrossReference ref = GrammarUtil.containingCrossReference(firstGrammarElement);
				if (ref != null)
					firstGrammarElement = ref;
				if (firstGrammarElement == grammarElement && first.token.equals(value)) {
					// System.out.println("OK!");
				} else {
					GrammarElementTitleSwitch f = new GrammarElementTitleSwitch().showQualified().showAssignments();
					System.out.println(f.apply(firstGrammarElement) + "<>" + f.apply((AbstractElement) grammarElement) + "; " + first.token + "<>" + value);
				}
				delegate.accept(first.sementicElement, first.grammarElement, value, false);
			} else {
				delegate.accept(null, grammarElement, value, true);
			}
		}

		public void writeHidden(EObject grammarElement, String value) throws IOException {
			write(grammarElement, value);
		}

		public void writeSemantic(EObject grammarElement, String value) throws IOException {
			write(grammarElement, value);
		}
	}

	private final IAcceptor delegate;
	private final ISequenceAcceptor formatter;
	private final Deque<Event> queue = new LinkedList<Event>();
	private final Stack<EObject> semanticElements = new Stack<EObject>();
	private final ITokenStream formatterTokenStream;

	public FormattingSequenceAcceptor(EObject obj, IFormatter formatter, ISerializationDiagnostic.Acceptor errors, boolean preserveWhitespace, IAcceptor delegate) {
		this.delegate = delegate;
		this.semanticElements.push(obj);
		Out out = new Out();
		if (formatter instanceof IFormatterExtension)
			formatterTokenStream = ((IFormatterExtension) formatter).createFormatterStream(obj, null, out, preserveWhitespace);
		else
			formatterTokenStream = formatter.createFormatterStream(null, out, preserveWhitespace);
		this.formatter = new TokenStreamSequenceAdapter(formatterTokenStream, errors);
	}

	public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index, ICompositeNode node) {
		enqueue(datatypeRC, token);
		formatter.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		enqueue(enumRC, token);
		formatter.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		enqueue(kw, token);
		formatter.acceptAssignedCrossRefKeyword(kw, token, value, index, node);
	}

	public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index, ILeafNode node) {
		enqueue(terminalRC, token);
		formatter.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
	}

	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		enqueue(datatypeRC, token);
		formatter.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		enqueue(enumRC, token);
		formatter.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		enqueue(keyword, token);
		formatter.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		enqueue(terminalRC, token);
		formatter.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		formatter.acceptComment(rule, token, node);
	}

	public void acceptUnassignedAction(Action action) {
		formatter.acceptUnassignedAction(action);
	}

	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		enqueue(datatypeRC, token);
		formatter.acceptUnassignedDatatype(datatypeRC, token, node);
	}

	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		enqueue(enumRC, token);
		formatter.acceptUnassignedEnum(enumRC, token, node);
	}

	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		enqueue(keyword, token);
		formatter.acceptUnassignedKeyword(keyword, token, node);
	}

	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		enqueue(terminalRC, token);
		formatter.acceptUnassignedTerminal(terminalRC, token, node);
	}

	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		formatter.acceptWhitespace(rule, token, node);
	}

	protected void enqueue(AbstractElement ele, String token) {
		queue.addLast(new Event(semanticElements.peek(), ele, token));
	}

	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		semanticElements.push(semanticChild);
		return formatter.enterAssignedAction(action, semanticChild, node);
	}

	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		semanticElements.push(semanticChild);
		return formatter.enterAssignedParserRuleCall(rc, semanticChild, node);
	}

	public void enterUnassignedParserRuleCall(RuleCall rc) {
		formatter.enterUnassignedParserRuleCall(rc);
	}

	public void finish() {
		formatter.finish();
	}

	public void leaveAssignedAction(Action action, EObject semanticChild) {
		semanticElements.pop();
		formatter.leaveAssignedAction(action, semanticChild);
	}

	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		semanticElements.pop();
		formatter.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		formatter.leaveUnssignedParserRuleCall(rc);
	}

	public void flush() {
		try {
			formatterTokenStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
