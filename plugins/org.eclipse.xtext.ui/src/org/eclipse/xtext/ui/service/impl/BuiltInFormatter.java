package org.eclipse.xtext.ui.service.impl;

import java.util.ListIterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.utils.EditorModelUtil;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.service.IFormatter;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuiltInFormatter implements IFormatter {

	// TODO make stuff configurable
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final String TAB = "\t";
	public static final String SPACE = " ";
	public static final String EMPTY_STRING = new String();

	private AbstractNode rootNode;
	/*
	 * Field lastLeafNode indicates when first text was written, so indentation
	 * can starts and helps calculate (performance)
	 */
	private LeafNode lastLeafNode;
	private StringBuilder indentSB;
	private IRegion formattingRegion;

	public void format(IEditorModel editorModel, IDocument document, IRegion region) {
		indentSB = new StringBuilder();
		lastLeafNode = null;
		rootNode = editorModel.getParseTreeRootNode();
		formattingRegion = region;
		if (rootNode != null) {
			StringBuilder stringBuilder = new StringBuilder();
			formattingRegion = calculateFormattingRegion(region);
			append(rootNode, stringBuilder);
			try {
				String string = stringBuilder.toString();
				if (!document.get().equals(string))
					document.replace(formattingRegion.getOffset(), formattingRegion.getLength(), string);
			}
			catch (BadLocationException e) {
				CoreLog.logError(e);
			}
		}
	}

	private IRegion calculateFormattingRegion(IRegion region) {
		AbstractNode an = EditorModelUtil.findLeafNodeAtOffset(rootNode, region.getOffset());
		if (an != null) {
			while (!overFormattingRegion(an)) {
				CompositeNode parent = an.getParent();
				if (parent == null)
					throw new IllegalStateException("Could not allocate Node to region " + region + ". Last Node was "
							+ an + " (offset:" + an.getOffset() + " length:" + an.getLength() + ")");
				an = parent;
			}
			Region retVal = new Region(an.getOffset(), an.getLength());
			if (Activator.DEBUG_FORMATTER)
				System.out.println("BuildInFormatter.calculateFormattingRegion(): From: " + region + " to " + retVal
						+ ". Node:" + an);
			return retVal;
		}
		return region;
	}

	private boolean overFormattingRegion(AbstractNode an) {
		return an.getOffset() <= formattingRegion.getOffset()
				&& (an.getOffset() + an.getLength()) >= formattingRegion.getLength() + formattingRegion.getOffset();
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
		BuiltInTokenTypeDef bittd = new BuiltInTokenTypeDef();
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
		boolean shouldIndent = (lastLeafNode != null) && shouldIndent(parserNode);
		if (shouldIndent)
			addIndent();
		for (EObject an : parserNode.eContents()) {
			if (an instanceof LeafNode) {
				LeafNode ln = (LeafNode) an;
				if (!isWhiteSpace(ln)) {
					if (inFormattingRegion(ln)) {
						appendLeafNode(stringBuilder, ln);
					}
					lastLeafNode = ln;
				}
			}
			else if (an instanceof CompositeNode) {
				append((CompositeNode) an, stringBuilder);
			}
		}
		if (shouldIndent)
			removeIndent();
	}

	private boolean inFormattingRegion(AbstractNode an) {
		return an.getOffset() >= formattingRegion.getOffset()
				&& (an.getOffset() + an.getLength()) <= formattingRegion.getLength() + formattingRegion.getOffset();
	}

	private void appendLeafNode(StringBuilder stringBuilder, LeafNode ln) {
		// IDEE COLLECT INFORMATION about before and after and concat leafnodes
		// later
		StringBuilder toAppend = new StringBuilder(4);
		if (lastLeafNode == null) {
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
	 * @return previous formatted node
	 */
	protected final LeafNode previousNode() {
		return lastLeafNode;
	}

	/**
	 * @param leafNode
	 * @param includeComments
	 * @return
	 */
	protected final LeafNode nextNode(LeafNode leafNode) {
		EList<EObject> nodes = asList(getRootNode(leafNode).eAllContents());
		return next(nodes, leafNode, true);
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

}