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
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xtext.ui.graph.figures.BypassSegment;
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
		return wrapCardinaltiySegments(keyword, nodeSegment);
	}

	public ISegmentFigure createNodeSegment(RuleCall ruleCall) {
		NodeSegment nodeSegment = new NodeSegment(ruleCall, NodeType.ROUNDED, ruleCall.getRule().getName(),
				primitiveFactory, getTextRegion(ruleCall));
		return wrapCardinaltiySegments(ruleCall, nodeSegment);
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
		SequenceSegment sequence = new SequenceSegment(group, children, primitiveFactory);
		return wrapCardinaltiySegments(group, sequence);
	}

	public ISegmentFigure createParallel(Alternatives alternatives, List<ISegmentFigure> children) {
		ParallelSegment multiSwitch = new ParallelSegment(alternatives, children, primitiveFactory);
		return wrapCardinaltiySegments(alternatives, multiSwitch);
	}

	public ISegmentFigure createParallel(UnorderedGroup unorderedGroup, List<ISegmentFigure> children) {
		ParallelSegment multiSwitch = new ParallelSegment(unorderedGroup, children, primitiveFactory);
		return wrapCardinaltiySegments(unorderedGroup, multiSwitch);
	}

	protected Region getTextRegion(EObject eObject) {
		ICompositeNode parseTreeNode = NodeModelUtils.getNode(eObject);
		if (parseTreeNode != null)
			return new Region(parseTreeNode.getOffset(), parseTreeNode.getLength());
		else
			return null;
	}

	protected ISegmentFigure wrapCardinaltiySegments(AbstractElement element, ISegmentFigure segment) {
		ISegmentFigure result = segment;
		EObject cardinalityElement = getParentWithCardinality(element);
		if (cardinalityElement instanceof AbstractElement) {
			if (GrammarUtil.isMultipleCardinality((AbstractElement) cardinalityElement)) {
				result = new LoopSegment(cardinalityElement, result, primitiveFactory);
			}
			if (GrammarUtil.isOptionalCardinality((AbstractElement) cardinalityElement)) {
				result = new BypassSegment(cardinalityElement, result, primitiveFactory);
			}
		}
		return result;
	}

	protected EObject getParentWithCardinality(AbstractElement element) {
		EObject cardinalityElement = element;
		String cardinality = element.getCardinality();
		while (cardinality == null && cardinalityElement != null) {
			cardinalityElement = cardinalityElement.eContainer();
			if (cardinalityElement instanceof AbstractElement)
				cardinality = ((AbstractElement) cardinalityElement).getCardinality();
		}
		return cardinalityElement;
	}

}
