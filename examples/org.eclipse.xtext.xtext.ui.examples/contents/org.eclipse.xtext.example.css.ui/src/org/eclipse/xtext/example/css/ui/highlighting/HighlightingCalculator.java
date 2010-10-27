package org.eclipse.xtext.example.css.ui.highlighting;

import static org.eclipse.xtext.example.css.ui.highlighting.HighlightingConfiguration.ATTRIBUTE_ID;
import static org.eclipse.xtext.example.css.ui.highlighting.HighlightingConfiguration.CLASS_SELECTOR;
import static org.eclipse.xtext.example.css.ui.highlighting.HighlightingConfiguration.ID_SELECTOR;
import static org.eclipse.xtext.example.css.ui.highlighting.HighlightingConfiguration.RGB_LITERAL;
import static org.eclipse.xtext.example.css.ui.highlighting.HighlightingConfiguration.COLOR_CONSTANT;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.css.xcss.ColorConstant;
import org.eclipse.xtext.example.css.xcss.ColorLiteral;
import org.eclipse.xtext.example.css.xcss.Gradient;
import org.eclipse.xtext.example.css.xcss.IdSelector;
import org.eclipse.xtext.example.css.xcss.RGB;
import org.eclipse.xtext.example.css.xcss.Selector;
import org.eclipse.xtext.example.css.xcss.StyleRule;
import org.eclipse.xtext.example.css.xcss.StyleSheet;
import org.eclipse.xtext.example.css.xcss.TypeSelector;
import org.eclipse.xtext.example.css.xcss.util.XcssSwitch;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.util.XbaseSwitch;

public class HighlightingCalculator implements ISemanticHighlightingCalculator {

	class HighlightingXbaseSwitch extends XbaseSwitch<Boolean> {
		
		private final IHighlightedPositionAcceptor acceptor;
		private final XcssSwitch<Boolean> delegate;

		public HighlightingXbaseSwitch(XcssSwitch<Boolean> delegate, IHighlightedPositionAcceptor acceptor) {
			this.delegate = delegate;
			this.acceptor = acceptor;
		}
		
		@Override
		public Boolean caseXAssignment(XAssignment object) {
			if (object.eContainer() instanceof StyleRule) {
				highlightNode(NodeUtil.getNode(object.getAssignable()), ATTRIBUTE_ID, acceptor);
			}
			delegate.doSwitch(object.getValue());
			return true;
		}
		
		@Override
		public Boolean defaultCase(EObject object) {
			return true;
		}
		
		@Override
		public Boolean doSwitch(EObject theEObject) {
			if (theEObject == null)
				return true;
			return super.doSwitch(theEObject);
		}
	}
	
	class HighlightingSwitch extends XcssSwitch<Boolean> {
		

		private final IHighlightedPositionAcceptor acceptor;
		private final XbaseSwitch<Boolean> xbase;
		
		public HighlightingSwitch(IHighlightedPositionAcceptor acceptor) {
			this.acceptor = acceptor;
			this.xbase = new HighlightingXbaseSwitch(this, acceptor);
		}
		
		@Override
		public Boolean defaultCase(EObject object) {
			xbase.doSwitch(object);
			return true;
		}

		@Override
		public Boolean caseRGB(RGB object) {
			highlightNode(NodeUtil.getNode(object), RGB_LITERAL, acceptor);
			return true;
		}
		
		@Override
		public Boolean caseColorConstant(ColorConstant object) {
			highlightNode(NodeUtil.getNode(object), COLOR_CONSTANT, acceptor);
			return true;
		}
		
		@Override
		public Boolean caseGradient(Gradient object) {
			for(ColorLiteral color: object.getColors()) {
				doSwitch(color);
			}
			return true;
		}
		
		@Override
		public Boolean caseTypeSelector(TypeSelector object) {
			highlightNode(NodeUtil.getNode(object), CLASS_SELECTOR, acceptor);
			return true;
		}
		
		@Override
		public Boolean caseIdSelector(IdSelector object) {
			highlightNode(NodeUtil.getNode(object), ID_SELECTOR, acceptor);
			return true;
		}
		
		@Override
		public Boolean caseStyleRule(StyleRule object) {
			for(Selector selector: object.getSelectors())
				doSwitch(selector);
			for(XExpression setting: object.getSettings())
				doSwitch(setting);
			return true;
		}
		
		@Override
		public Boolean caseStyleSheet(StyleSheet object) {
			for(StyleRule rule: object.getRules())
				doSwitch(rule);
			return true;
		}
		
		@Override
		public Boolean doSwitch(EObject theEObject) {
			if (theEObject == null)
				return true;
			return super.doSwitch(theEObject);
		}
	}
	
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getContents().isEmpty())
			return;
		StyleSheet styleSheet = (StyleSheet) resource.getContents().get(0);
		new HighlightingSwitch(acceptor).doSwitch(styleSheet);
	}
	
	protected void highlightNode(AbstractNode node, String id, IHighlightedPositionAcceptor acceptor) {
		if (node == null)
			return;
		if (node instanceof LeafNode) {
			acceptor.addPosition(node.getOffset(), node.getLength(), id);
		} else {
			for (LeafNode leaf : node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					acceptor.addPosition(leaf.getOffset(), leaf.getLength(), id);
				}
			}
		}
	}

}
