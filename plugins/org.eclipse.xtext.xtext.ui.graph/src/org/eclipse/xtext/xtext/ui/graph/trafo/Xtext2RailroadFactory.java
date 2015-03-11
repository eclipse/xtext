/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.trafo;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xtext.ui.graph.figures.BypassSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.CompartmentSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.ISegmentFigure;
import org.eclipse.xtext.xtext.ui.graph.figures.LoopSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.NodeSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.ParallelSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.RailroadDiagram;
import org.eclipse.xtext.xtext.ui.graph.figures.RailroadTrack;
import org.eclipse.xtext.xtext.ui.graph.figures.SequenceSegment;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.NodeType;
import org.eclipse.xtext.xtext.ui.graph.figures.primitives.PrimitiveFigureFactory;

import com.google.inject.Inject;

/**
 * Creates railrowad {@link ISegmentFigure}s and {@link ISegmentFigure}s for Xtext artifacts.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtext2RailroadFactory {

	@Inject
	private PrimitiveFigureFactory primitiveFactory;

	public ISegmentFigure createNodeSegment(Keyword keyword) {
		NodeSegment nodeSegment = new NodeSegment(keyword, NodeType.RECTANGLE, keyword.getValue(), primitiveFactory,
				getTextRegion(keyword));
		Assignment containingAssignment = GrammarUtil.containingAssignment(keyword);
		return wrapCardinalitySegments(containingAssignment != null ? containingAssignment :keyword, nodeSegment);
	}

	public ISegmentFigure createNodeSegment(RuleCall ruleCall) {
		NodeSegment nodeSegment = new NodeSegment(ruleCall, NodeType.ROUNDED, ruleCall.getRule().getName(),
				primitiveFactory, getTextRegion(ruleCall));
		Assignment containingAssignment = GrammarUtil.containingAssignment(ruleCall);
		return wrapCardinalitySegments(containingAssignment != null ? containingAssignment :ruleCall, nodeSegment);
	}
	
	public ISegmentFigure createNodeSegment(EnumLiteralDeclaration enumLiteralDeclaration) {
		String literalName = (enumLiteralDeclaration.getLiteral() != null) ?
				enumLiteralDeclaration.getLiteral().getValue() : enumLiteralDeclaration.getEnumLiteral().getName();
		NodeSegment nodeSegment = new NodeSegment(enumLiteralDeclaration, NodeType.RECTANGLE, literalName, primitiveFactory,
				getTextRegion(enumLiteralDeclaration));
		return nodeSegment;
	}

	public ISegmentFigure createNodeSegment(EObject grammarElement, Throwable throwable) {
		return new NodeSegment(grammarElement, NodeType.ERROR, "ERROR", primitiveFactory, getTextRegion(grammarElement));
	}

	public ISegmentFigure createTrack(AbstractRule rule, ISegmentFigure body) {
		return new RailroadTrack(rule, rule.getName(), body, primitiveFactory, getTextRegion(rule));
	}

	public ISegmentFigure createDiagram(Grammar grammar, List<ISegmentFigure> children) {
		return new RailroadDiagram(grammar, children);
	}

	public ISegmentFigure createSequence(Group group, List<ISegmentFigure> children) {
		ISegmentFigure sequence = children.size() == 1 ? children.get(0) : new SequenceSegment(group, children, primitiveFactory);
		return wrapCardinalitySegments(group, sequence);
	}

	public ISegmentFigure createParallel(Alternatives alternatives, List<ISegmentFigure> children) {
		ParallelSegment multiSwitch = new ParallelSegment(alternatives, children, primitiveFactory);
		return wrapCardinalitySegments(alternatives, multiSwitch);
	}

	public ISegmentFigure createCompartment(UnorderedGroup unorderedGroup, List<ISegmentFigure> children) {
		ParallelSegment multiSwitch = new ParallelSegment(unorderedGroup, children, primitiveFactory);
		CompartmentSegment compartmentSegment = new CompartmentSegment(unorderedGroup, multiSwitch, primitiveFactory);
		return wrapCardinalitySegments(unorderedGroup, compartmentSegment);
	}

	protected Region getTextRegion(EObject eObject) {
		ICompositeNode parseTreeNode = NodeModelUtils.getNode(eObject);
		if (parseTreeNode != null) {
			ITextRegion parseTreeRegion = parseTreeNode.getTextRegion();
			return new Region(parseTreeRegion.getOffset(), parseTreeRegion.getLength());
		}
		else
			return null;
	}

	protected ISegmentFigure wrapCardinalitySegments(AbstractElement element, ISegmentFigure segment) {
		ISegmentFigure result = segment;
		if (GrammarUtil.isMultipleCardinality(element)) {
			result = new LoopSegment(element, result, primitiveFactory);
		}
		if (GrammarUtil.isOptionalCardinality(element)) {
			result = new BypassSegment(element, result, primitiveFactory);
		}
		return result;
	}

}
