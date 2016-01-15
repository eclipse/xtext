package org.eclipse.xpect.xtext.lib.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.eclipse.xpect.xtext.lib.setup.ThisResource;
import org.eclipse.xpect.xtext.lib.util.NextLine.NextLineProvider;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;
import org.xpect.XpectImport;
import org.xpect.XpectInvocation;
import org.xpect.parameter.IStatementRelatedRegion;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.state.XpectStateAnnotation;
import org.xpect.text.IRegion;
import org.xpect.text.Region;
import org.xpect.text.Text;

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
			IStatementRelatedRegion statementRegion = statement.getExtendedRegion();
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, statementRegion.getOffset() + statementRegion.getLength());
			NodeIterator it = new NodeIterator(leaf);
			while (it.hasNext()) {
				INode next = it.next();
				if (next instanceof ILeafNode && !((ILeafNode) next).isHidden())
					return (ILeafNode) next;
			}
			throw new IllegalStateException("No line with non-hidden tokens found after \n" + statementRegion.toString());
		}

		@Creates(NextLine.class)
		public IRegion getNextLine() {
			return nextLine;
		}

	}

}
