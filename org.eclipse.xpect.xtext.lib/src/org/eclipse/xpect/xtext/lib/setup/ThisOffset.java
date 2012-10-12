package org.eclipse.xpect.xtext.lib.setup;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.util.AbstractOffsetProvider;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER, ElementType.FIELD })
public @interface ThisOffset {

	public static class ThisOffsetProvider extends AbstractOffsetProvider {
		private final XpectInvocation invocation;
		private final XtextResource resource;

		public ThisOffsetProvider(XpectInvocation invocation, XtextResource resource) {
			this.invocation = invocation;
			this.resource = resource;
		}

		public XpectInvocation getInvocation() {
			return invocation;
		}

		@Override
		public int getOffset() {
			INode invNode = NodeModelUtils.getNode(invocation);
			int invEnd = invNode.getOffset() + invNode.getLength();
			INode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), invEnd);
			NodeIterator ni = new NodeIterator(node);
			while (ni.hasNext()) {
				INode next = ni.next();
				if (next instanceof ILeafNode && !((ILeafNode) next).isHidden())
					return next.getOffset();
			}
			return -1;
		}

		public XtextResource getResource() {
			return resource;
		}
	}
}
