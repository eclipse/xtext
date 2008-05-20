/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.core.parsetree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.core.parser.AbstractEcoreElementFactory;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public abstract class AbstractParseTreeConstructor implements IParseTreeConstructor {

	public void update(EObject object) {
		NodeAdapter adapter = getAdapter(object);
		CompositeNode rootNode = null;
		String ruleToCall = getGrammar().getParserRules().get(0).getName();
		if (adapter == null) {
			rootNode = ParsetreeFactory.eINSTANCE.createCompositeNode();
			object = EcoreUtil.getRootContainer(object);
			// TODO set synthetic rulecall
		} else {
			rootNode = adapter.getParserNode();
			rootNode.getChildren().clear();
			if (rootNode.getGrammarElement() instanceof RuleCall) {
				ruleToCall = ((RuleCall) rootNode.getGrammarElement()).getName();
			}
			object = rootNode.getElement();
		}
		internalDoUpdate(object, ruleToCall);
	}

	protected Grammar getGrammar() {
		return getFacade().getGrammar();
	}

	protected abstract void internalDoUpdate(EObject obj, String ruleToCall);

	private NodeAdapter getAdapter(EObject object) {
		NodeAdapter adapter = (NodeAdapter) EcoreUtil.getAdapter(object.eAdapters(), AbstractNode.class);
		if ((adapter == null || !(adapter.getParserNode().getGrammarElement() instanceof RuleCall))
				&& object.eContainer() != null) {
			return getAdapter(object.eContainer());
		}
		return adapter;
	}

	protected abstract ILanguageFacade getFacade();
	
	protected AbstractEcoreElementFactory getFactory() {
		return (AbstractEcoreElementFactory) getFacade().getElementFactory();
	}

	protected final InstanceDescription getDescr(InstanceDescription obj) {
		return obj;
	}

	protected final InstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(obj, false);
	}

	protected final InstanceDescription getDescr(EObject obj, boolean lookahead) {
		return new InstanceDescription(obj, lookahead);
	}

	public final class InstanceDescription {

		public boolean isInstanceOf(String string) {
			EClass class1 = getFactory().getEClass(string);
			return class1 != null && class1.isSuperTypeOf(getDelegate().eClass());
		}

		public boolean isOfType(String string) {
			EClass class1 = getFactory().getEClass(string);
			return class1 != null && class1.equals(getDelegate().eClass());
		}

		public EObject getDelegate() {
			return described;
		}

		private boolean isLookahead = false;

		private EObject described;
		private Map<String, Integer> featureConsumedCounter = new HashMap<String, Integer>();

		public InstanceDescription(EObject described, boolean lookahead) {
			super();
			if (described == null)
				throw new NullPointerException("described");
			this.described = described;
			this.isLookahead = lookahead;
			EList<EStructuralFeature> features = described.eClass().getEAllStructuralFeatures();
			for (EStructuralFeature f : features) {
				Integer integer = 0;
				if (described.eIsSet(f)) {
					if (f.isMany()) {
						integer = ((List<?>) described.eGet(f)).size();
					} else {
						integer = 1;
					}
				}
				featureConsumedCounter.put(f.getName(), integer);
			}
		}

		private InstanceDescription(EObject described, Map<String, Integer> featureConsumedCounter) {
			super();
			this.isLookahead = true;
			this.described = described;
			this.featureConsumedCounter = featureConsumedCounter;
		}

		public boolean isLookahead() {
			return isLookahead;
		}

		@Override
		public String toString() {
			return hashCode() + "/" + described.hashCode();
		}

		public Object consume(String feature) {
			if (!isConsumable(feature))
				throw new IllegalStateException(feature + " is not consumable");
			Integer counter = lazyGet(feature);
			EStructuralFeature f = getFeature(feature);
			Object get = described.eGet(f);
			if (f.isMany()) {
				List<?> list = (List<?>) get;
				get = list.get(counter - 1);
			}
			featureConsumedCounter.put(feature, counter - 1);
			return get;
		}

		public boolean checkConsume(String feature) {
			if (!isConsumable(feature))
				return false;
			Integer counter = lazyGet(feature);
			EStructuralFeature f = getFeature(feature);
			Object get = described.eGet(f);
			if (f.isMany()) {
				List<?> list = (List<?>) get;
				get = list.get(counter - 1);
			}
			featureConsumedCounter.put(feature, counter - 1);
			return true;
		}

		private Integer lazyGet(String feature) {
			Integer integer = featureConsumedCounter.get(feature);
			if (integer == null) {
				return 0;
			}
			return integer;
		}

		private EStructuralFeature getFeature(String feature) {
			return described.eClass().getEStructuralFeature(feature);
		}

		public boolean isConsumable(String feature) {
			return lazyGet(feature) > 0;
		}

		public boolean isConsumed() {
			for (Integer i : featureConsumedCounter.values()) {
				if (i > 0)
					return false;
			}
			return true;
		}

		public InstanceDescription newLookaheadDescription() {
			return new InstanceDescription(described, new HashMap<String, Integer>(featureConsumedCounter));
		}

	}

	public String getText() {
		return current.serialize();
	}

	private CompositeNode current = ParsetreeFactory.eINSTANCE.createCompositeNode();
	private LexerRule wsRule;

	protected void ruleCallStart(InstanceDescription val, boolean isAssigned, RuleCall ruleCall) {
		CompositeNode node = ParsetreeFactory.eINSTANCE.createCompositeNode();
		node.setGrammarElement(ruleCall);
		prependToCurrentsChildren(node);
		current = node;
	}

	protected void ruleCallEnd(InstanceDescription val, boolean b, RuleCall ruleCall) {
		current = current.getParent();
	}

	private void prependToCurrentsChildren(AbstractNode node) {
		current.getChildren().add(0, node);
	}

	protected void lexerRuleCall(RuleCall ruleCall) {
		throw new UnsupportedOperationException("coudn't generate text for lexer rule " + ruleCall.getName());
	}

	protected void lexerRuleCall(Object value, RuleCall ruleCall) {
		checkWhitespace();
		LeafNode ln = ParsetreeFactory.eINSTANCE.createLeafNode();
		ln.setGrammarElement(ruleCall);
		ln.setText(value.toString()); // TODO converters?
		prependToCurrentsChildren(ln);
	}

	private void checkWhitespace() {
		EList<LeafNode> leafNodes = ((CompositeNode) EcoreUtil.getRootContainer(current)).getLeafNodes();
		if (!leafNodes.isEmpty()) {
			LeafNode next = leafNodes.get(0);
			if (!next.isHidden()) {
				LeafNode ws = ParsetreeFactory.eINSTANCE.createLeafNode();
				ws.setText(" ");
				ws.setGrammarElement(getWhitespaceRule());
				prependToCurrentsChildren(ws);
			}
		}
	}

	private LexerRule getWhitespaceRule() {
		if (wsRule == null) {
			// TODO
		}
		return wsRule;
	}

	protected void action(InstanceDescription parent, InstanceDescription child, Action action) {
		objectCreation(parent);
	}

	protected void keyword(Keyword kw) {
		checkWhitespace();
		String value = kw.getValue().substring(1, kw.getValue().length() - 1);
		LeafNode ln = ParsetreeFactory.eINSTANCE.createLeafNode();
		ln.setGrammarElement(kw);
		ln.setText(value);
		prependToCurrentsChildren(ln);
	}

	protected void objectCreation(InstanceDescription obj) {
		current.setElement(obj.getDelegate());
		NodeAdapter newOne = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(obj.getDelegate(), AbstractNode.class);
		newOne.setParserNode(current);
	}

}
