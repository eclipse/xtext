package org.eclipse.xtext.core.parsetree;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;

public class ParseTreeConstructor {
	
	public void updateParseTree(EObject e, Grammar grammar) {
		NodeAdapter adapter = getNodeAdapter(e);
		CompositeNode node = null;
		ParserRule rule = null;
		if (adapter==null) {
			EObject container = e.eContainer();
			if (container!=null) {
				updateParseTree(container, grammar);
			} else {
				// create root node
				adapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(e, NodeAdapter.class);
				node = ParsetreeFactory.eINSTANCE.createCompositeNode();
				adapter.setParserNode(node);
				rule = grammar.getParserRules().get(0);
			}
		} else {
			node = adapter.getParserNode();
			rule = (ParserRule) node.getGrammarElement();
		}
		AbstractElement ele = rule.getAlternatives();
		update(e,node,ele);
	}
	
	private Object update(EObject e, CompositeNode node, Keyword ele) {
		
		return null;
	}
	
	private Object update(EObject e, CompositeNode node, RuleCall ele) {
		return null;
	}
	
	private Object update(EObject e, CompositeNode node, Group ele) {
		return null;
	}
	
	private Object update(EObject e, CompositeNode node, Alternatives ele) {
		return null;
	}
	
	private Object update(EObject e, CompositeNode node, Assignment ele) {
		return null;
	}
	
	private void update(EObject e, CompositeNode node, AbstractElement ele) {
		switch (ele.eClass().getClassifierID()) {
			case XtextPackage.KEYWORD :
				update(e, node, (Keyword) ele);
				break;
			case XtextPackage.RULE_CALL :
				update(e, node, (RuleCall) ele);
				break;
			case XtextPackage.ASSIGNMENT :
				update(e, node, (Assignment) ele);
				break;
			case XtextPackage.ALTERNATIVES :
				update(e, node, (Alternatives) ele);
				break;
			case XtextPackage.GROUP :
				update(e, node, (Group) ele);
				break;
			default :
				throw new IllegalArgumentException();
		}
	}

	public static NodeAdapter getNodeAdapter(EObject e) {
		EList<Adapter> adapters = e.eAdapters();
		for (Adapter adapter : adapters) {
			if (adapter instanceof NodeAdapter) {
				return (NodeAdapter) adapter;
			}
		}
		return null;
	}
}
