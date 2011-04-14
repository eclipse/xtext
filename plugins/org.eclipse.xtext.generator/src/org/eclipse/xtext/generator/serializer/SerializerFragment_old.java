/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import static org.eclipse.xtext.generator.parseTreeConstructor.ParseTreeConstructorUtil.*;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.ConstraintElementType;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.impl.GrammarConstraintProvider;

/**
 * @author Moritz Eysholdt
 */
public class SerializerFragment_old extends AbstractGeneratorFragment {

	//	private static final Logger log = Logger.getLogger(SerializerFragment.class);

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[] { getPackage(grammar, getNaming()) };
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		BindFactory bf = new BindFactory();
		bf.addTypeToType(ISemanticSequencer.class.getName(), getSemanticSequencerName(grammar, "", getNaming()));
		bf.addTypeToType(ISyntacticSequencer.class.getName(), getSyntacticSequencerName(grammar, "", getNaming()));
		return bf.getBindings();
	}

	public static String getSemanticSequencerName(Grammar g, String prefix, Naming n) {
		return n.basePackageRuntime(g) + ".serializer." + prefix + GrammarUtil.getName(g) + "SemanticSequencer";
	}

	public static String getSyntacticSequencerName(Grammar g, String prefix, Naming n) {
		return n.basePackageRuntime(g) + ".serializer." + prefix + GrammarUtil.getName(g) + "SyntacticSequencer";
	}

	public static List<IConstraintContext> getGrammarConstraints(Grammar grammar) {
		return new GrammarConstraintProvider().getConstraints(grammar);
	}

	public static boolean canGenerate(Object constraintObj) {
		IConstraint constraint = (IConstraint) constraintObj;
		if (constraint.getAssignments().length != constraint.getFeatures().length)
			return false;
		IConstraintElement body = constraint.getBody();
		if (body.getFeatureInfo() != null && !body.isOptional() && !body.isMany())
			return true;
		if (body.getType() == ConstraintElementType.GROUP) {
			for (IConstraintElement child : body.getChildren())
				if (child.getFeatureInfo() == null || child.isOptional() || child.isMany())
					return false;
			return true;
		}
		return false;
	}
}
