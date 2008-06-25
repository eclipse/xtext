package org.eclipse.xtext.ui.service.impl;

import java.util.Collections;
import java.util.ListIterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.service.IFormatterService;
import org.eclipse.xtext.ui.tokentype.BuildInTokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuildInFormatterService implements IFormatterService {

	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final String TAB = "\t";
	public static final String SPACE = " ";
	public static final String EMPTY_STRING = new String();

	private AbstractNode rootNode;
	private StringBuilder indentSB;
	/* indicates when first text was written, so indentation can starts */
	private boolean firstLeafNodeFormatted;

	public void format(IEditorModel editorModel, IDocument document, IRegion region) {
		indentSB = new StringBuilder();
		firstLeafNodeFormatted = false;
		this.rootNode = editorModel.getParseTreeRootNode();
		if (rootNode != null) {
			StringBuilder stringBuilder = new StringBuilder();
			append(rootNode, stringBuilder);
			try {
				String string = stringBuilder.toString();
				if (!document.get().equals(string))
					document.replace(0, document.getLength(), string);
			}
			catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param node
	 * @return
	 */
	protected boolean shouldIndent(AbstractNode node) {
		// indentation make sense for non root composite nodes that has at least
		// 2 LeafNodes
		if (node.getParent() != null && node instanceof CompositeNode && hasGivenNumberOfDirectLeafNodes(2, node)) {
			return true;
		}
		return false;
	}

	/**
	 * @param leafNode
	 * @return
	 */
	protected String before(LeafNode leafNode) {
		BuildInTokenTypeDef bittd = new BuildInTokenTypeDef();
		if (bittd.mlCommentTokenType().match(leafNode)
				|| (bittd.keyWordTokenType().match(leafNode) && leafNode.getText().length() > 1)) {
			return NEW_LINE;
		}
		return SPACE;
	}

	/**
	 * @param leafNode
	 * @return
	 */
	protected String after(LeafNode leafNode) {
		return EMPTY_STRING;
	}

	private void append(AbstractNode parserNode, StringBuilder stringBuilder) {
		boolean shouldIndent = firstLeafNodeFormatted && shouldIndent(parserNode);
		if (shouldIndent)
			addIndent();
		for (EObject an : parserNode.eContents()) {
			if (an instanceof LeafNode) {
				LeafNode ln = (LeafNode) an;
				if (!isWhiteSpace(ln)) {
					appendLeafNode(stringBuilder, ln);
					firstLeafNodeFormatted = true;
				}
			}
			else if (an instanceof CompositeNode) {
				append((CompositeNode) an, stringBuilder);
			}
		}
		if (shouldIndent)
			removeIndent();
	}

	private void appendLeafNode(StringBuilder stringBuilder, LeafNode ln) {
		// IDEE COLLECT INFORMATION about bevore and after
		StringBuilder toAppend = new StringBuilder();
		if (previousNode(ln, true) == null) {
			toAppend.append(getIndentString());
		}
		else {
			toAppend.append(before(ln));
		}
		toAppend.append(ln.serialize().replaceAll(NEW_LINE + "\\s*", NEW_LINE));
		toAppend.append(after(ln));

		stringBuilder.append(toAppend.toString().replaceAll(NEW_LINE, NEW_LINE + getIndentString()));
	}

	/**
	 * @param leafNode
	 * @param includeComments
	 * @return
	 */
	protected final LeafNode nextNode(LeafNode leafNode, boolean includeComments) {
		EList<EObject> nodes = asList(getRootNode(leafNode).eAllContents());
		return next(nodes, leafNode, includeComments);
	}

	protected final LeafNode previousNode(LeafNode leafNode, boolean includeComments) {
		EList<EObject> nodes = new BasicEList<EObject>(asList(getRootNode(leafNode).eAllContents()));
		Collections.reverse(nodes);
		return next(nodes, leafNode, includeComments);
	}

	private EList<EObject> asList(TreeIterator<EObject> allContents) {
		EList<EObject> list = new BasicEList<EObject>();
		for (; allContents.hasNext();) {
			list.add(allContents.next());
		}
		return list;
	}

	private LeafNode next(EList<EObject> nodes, LeafNode ln, boolean withComment) {
		int index = nodes.indexOf(ln) + 1;
		if (nodes.size() > index) {
			for (ListIterator<EObject> lIter = nodes.listIterator(index); lIter.hasNext();) {
				EObject current = lIter.next();
				if (current instanceof LeafNode) {
					LeafNode currentLeafNode = (LeafNode) current;
					if ((withComment || !currentLeafNode.isHidden()) && !isWhiteSpace(currentLeafNode))
						return currentLeafNode;
				}
			}

		}
		return null;
	}

	private boolean hasGivenNumberOfDirectLeafNodes(int number, AbstractNode node) {
		int count = 0;
		for (EObject eO : node.eContents()) {
			if (eO instanceof LeafNode && !((LeafNode) eO).isHidden()) {
				count++;
				if (count == number)
					return true;
			}
		}
		return false;
	}

	protected final AbstractNode getRootNode(AbstractNode leafNode) {
		return rootNode;
	}

	private void addIndent() {
		indentSB.append(TAB);
	}

	private boolean removeIndent() {
		int newLength = indentSB.length() - TAB.length();
		if (newLength > -1) {
			indentSB.setLength(newLength);
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	private String getIndentString() {
		return indentSB.toString();
	}

	private boolean isWhiteSpace(LeafNode ln) {
		return ln.isHidden() && ln.getGrammarElement() instanceof LexerRule
				&& "WS".equals(((LexerRule) ln.getGrammarElement()).getName());
	}

	private boolean isFirstLeafNode(LeafNode ln) {
		for (EObject an : ln.getParent().eContents()) {
			if (an instanceof LeafNode && !((LeafNode) an).isHidden()) {
				if (an.equals(ln))
					return true;
				else
					return false;
			}
		}
		return false;
	}
}