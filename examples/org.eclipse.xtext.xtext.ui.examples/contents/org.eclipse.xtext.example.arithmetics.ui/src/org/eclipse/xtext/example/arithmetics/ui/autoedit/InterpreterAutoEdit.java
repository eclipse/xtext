package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import java.math.BigDecimal;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.Statement;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class InterpreterAutoEdit implements IAutoEditStrategy {

	public void customizeDocumentCommand(IDocument document,
			DocumentCommand command) {
		if (command.text.equals("\n")) {
			int lineStart;
			try {
				lineStart = document.getLineOfOffset(command.offset);
				if (!document.get(lineStart, 3).equals("def")) {
					BigDecimal computedResult = computeResult(document, command);
					if (computedResult != null)
						command.text = "\n// = " + computedResult + "\n";
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}

	private BigDecimal computeResult(IDocument document,
			final DocumentCommand command) {
		return ((IXtextDocument) document)
				.readOnly(new IUnitOfWork<BigDecimal, XtextResource>() {
					public BigDecimal exec(XtextResource state) throws Exception {
						Evaluation stmt = findEvaluation(command, state);
						if (stmt == null)
							return null;
						return evaluate(stmt);
					}
				});
	}

	protected BigDecimal evaluate(Evaluation stmt) {
		return new Calculator().evaluate(stmt.getExpression());
	}

	protected Evaluation findEvaluation(final DocumentCommand command,
			XtextResource state) {
		Module m = (Module) state.getContents().get(0);
		for (Statement stmt : m.getStatements()) {
			if (stmt instanceof Evaluation) {
				CompositeNode node = NodeUtil.getNodeAdapter(stmt)
						.getParserNode();
				if (node.getOffset() <= command.offset
						&& (node.getOffset() + node.getLength()) >= command.offset) {
					return (Evaluation) stmt;
				}
			}
		}
		return null;
	}
}
