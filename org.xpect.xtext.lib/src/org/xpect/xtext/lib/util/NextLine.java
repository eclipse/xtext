package org.xpect.xtext.lib.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;
import org.xpect.XpectImport;
import org.xpect.XpectInvocation;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.state.XpectStateAnnotation;
import org.xpect.text.IRegion;
import org.xpect.text.Region;
import org.xpect.text.Text;
import org.xpect.xtext.lib.setup.ThisResource;
import org.xpect.xtext.lib.util.NextLine.NextLineProvider;

@Retention(RetentionPolicy.RUNTIME)
@XpectStateAnnotation
@XpectImport(NextLineProvider.class)
public @interface NextLine {

	@XpectSetupFactory
	public static class NextLineProvider {

		private final IRegion nextLine;

		public NextLineProvider(@ThisResource XtextResource resource, XpectInvocation statement) {
			ICompositeNode rootNode = resource.getParseResult().getRootNode();
			ILeafNode leaf = findNextNonHiddenLeaf(rootNode, statement);
			String document = rootNode.getText();
			Text text = new Text(document);
			int offset = leaf.getOffset();
			int start = text.currentLineStart(offset);
			int end = text.currentLineEnd(offset);
			this.nextLine = new Region(document, start, end - start);
		}

		private ILeafNode findNextNonHiddenLeaf(ICompositeNode rootNode, XpectInvocation statement) {
			ICompositeNode statementNode = NodeModelUtils.getNode(statement);
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, statementNode.getOffset() + statementNode.getLength());
			NodeIterator it = new NodeIterator(leaf);
			while (it.hasNext()) {
				INode next = it.next();
				if (next instanceof ILeafNode && !((ILeafNode) next).isHidden())
					return (ILeafNode) next;
			}
			throw new IllegalStateException();
		}

		@Creates(NextLine.class)
		public IRegion getNextLine() {
			return nextLine;
		}

	}

}
