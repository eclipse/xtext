package org.eclipse.xtext.parsetree.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.parsetree.AbstractParserNode;
import org.eclipse.xtext.parsetree.ParsetreePackage;

public class ParsetreeUtil {

	public static int length(CompositeNodeImpl compositeNodeImpl) {
		int length = 0;
		for (AbstractParserNode node : compositeNodeImpl.getChildren()) {
			length += node.length();
		}
		return length;
	}

	public static int length(LeafNodeImpl leafNodeImpl) {
		return leafNodeImpl.getText().length();
	}

	public static int length(AbstractParserNode abstractParserNode) {
		throw new IllegalArgumentException(
				"Illegal subtype of AbstarctParserNode "
						+ abstractParserNode.eClass().getName());
	}

	public static int offset(AbstractParserNode abstractParserNode) {
		int classifierID = abstractParserNode.eClass().getClassifierID();
		if(classifierID != ParsetreePackage.COMPOSITE_NODE
				&& classifierID != ParsetreePackage.LEAF_NODE) {
			throw new IllegalArgumentException(
					"Illegal subtype of AbstarctParserNode "
							+ abstractParserNode.eClass().getName());
		}
		int offset = 0;
		EList<AbstractParserNode> siblings = abstractParserNode.getParent()
				.getChildren();
		int indexOf = siblings.indexOf(abstractParserNode);
		for (int i = 0; i < indexOf; ++i) {
			offset += siblings.get(i).length();
		}
		return offset;
	}

	public static int line(CompositeNodeImpl leafNodeImpl) {
		// TODO implement as soon as whitespaces are in node model
		return 0;
	}

	public static int line(LeafNodeImpl leafNodeImpl) {
		// TODO implement as soon as whitespaces are in node model
		return 0;
	}

	public static int line(AbstractParserNode abstractParserNode) {
		throw new IllegalArgumentException(
				"Illegal subtype of AbstarctParserNode "
						+ abstractParserNode.eClass().getName());
	}

}
