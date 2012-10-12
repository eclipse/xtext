package org.eclipse.xpect.parameters;

import org.eclipse.xpect.util.IntegerProvider;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class Offset {
	protected int offset;
	protected XtextResource resource;

	public static class OffsetProvider extends IntegerProvider {

		protected int offset;
		protected XtextResource resource;

		public OffsetProvider(XtextResource resource, int offset) {
			super(String.valueOf(offset));
			this.resource = resource;
			this.offset = offset;
		}

		@Override
		public <T> T get(Class<T> expectedType) {
			if (expectedType == Offset.class)
				return null;
			return super.get(expectedType);
		}

		@Override
		public boolean canProvide(Class<?> expectedType) {
			return expectedType == Offset.class || super.canProvide(expectedType);
		}
	}

	public Offset(XtextResource resource, int offset) {
		super();
		this.resource = resource;
		this.offset = offset;
	}

	// public EObject getEObject() {
	// EObject object =
	// NodeModelUtils.findActualSemanticObjectFor(getLeafNodeAtOffset());
	// Assert.assertNotNull("No EObject found at offset " + offset, object);
	// return object;
	// }
	//
	// public Pair<EObject, EStructuralFeature> getEStructuralFeatureByOffset()
	// {
	// return getEStructuralFeatureByOffset(Predicates.<EStructuralFeature>
	// alwaysTrue());
	// }
	//
	// public Pair<EObject, EStructuralFeature>
	// getEStructuralFeatureByOffset(Predicate<EStructuralFeature> matches) {
	// INode leaf = getLeafNodeAtOffset();
	// NodeIterator ni = null;
	// while (ni == null || ni.hasNext()) {
	// INode next = ni == null ? leaf : ni.next();
	// if (ni == null)
	// ni = new NodeIterator(leaf);
	// Assignment ass =
	// GrammarUtil.containingAssignment(next.getGrammarElement());
	// if (ass != null) {
	// EObject object = NodeModelUtils.findActualSemanticObjectFor(next);
	// EStructuralFeature feat =
	// object.eClass().getEStructuralFeature(ass.getFeature());
	// if (feat != null && matches.apply(feat))
	// return Tuples.create(object, feat);
	// }
	// }
	// Assert.fail("No EStructuralFeature found at offset " + offset);
	// return null;
	// }
	//
	// public Pair<EObject, EStructuralFeature> getEStructuralFeatureByParent()
	// {
	// INode leaf = getLeafNodeAtOffset();
	// EObject object = NodeModelUtils.findActualSemanticObjectFor(leaf);
	// Assert.assertNotNull("No EObject found at offset " + offset, object);
	// Assignment ass =
	// GrammarUtil.containingAssignment(leaf.getGrammarElement());
	// while (ass == null && leaf.getParent() != null) {
	// leaf = leaf.getParent();
	// ass = GrammarUtil.containingAssignment(leaf.getGrammarElement());
	// }
	// Assert.assertNotNull("No Assignment found at offset " + offset, ass);
	// @SuppressWarnings("null")
	// EStructuralFeature feature =
	// object.eClass().getEStructuralFeature(ass.getFeature());
	// return Tuples.create(object, feature);
	// }
	//
	// public ILeafNode getLeafNodeAtOffset() {
	// ILeafNode node =
	// NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(),
	// offset);
	// Assert.assertNotNull("No Leaf Node found at offset " + offset, node);
	// return node;
	// }

	@Override
	public int hashCode() {
		return offset * (resource != null ? resource.hashCode() : 1);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass())
			return false;
		Offset off = (Offset) obj;
		return resource == off.resource && offset == off.offset;
	}

	public int getOffset() {
		return offset;
	}

	public XtextResource getResource() {
		return resource;
	}

	@Override
	public String toString() {
		if (resource == null)
			return "(resource is null)";
		if (resource.getParseResult() == null || resource.getParseResult().getRootNode() == null)
			return "(resource hs no parse result)";
		String text = resource.getParseResult().getRootNode().getText();
		if (offset < 0 || offset > text.length())
			return "(offset out of range)";
		int from = Math.max(0, offset - 5);
		int to = Math.min(text.length(), offset + 5);
		return text.substring(from, offset) + "!" + text.substring(offset, to);
	}
}
