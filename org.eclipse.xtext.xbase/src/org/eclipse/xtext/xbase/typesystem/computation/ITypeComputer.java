/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer;

import com.google.inject.ImplementedBy;

/**
 * The type computer is the central component when it comes to type inferrence for {@link XExpression expressions}.
 * 
 * Implementations will usually inherit from {@link XbaseTypeComputer} or {@link XbaseWithAnnotationsTypeComputer} and
 * add new expressions by means of overriding {@link #computeTypes(XExpression, ITypeComputationState)} and adding
 * respective cases.
 * 
 * Implementations are responsible for triggering type inference for all child expressions.
 * 
 * There are three base idioms when implementing type inference for a given expression.
 * <dl>
 * 		<dt>Expression type is independent from expectations.</dt>
 * 		<dd>
 * 			This is the simplest case. There is no need to take expectations into account. 
 * 			The computed type is directly propagated to the current {@link ITypeComputationState state}.
 * 
 * 			An example for this are boolean literals.
 * 
 * <pre>
 * void computeType(XBooleanLiteral literal, ITypeComputationState state) {
 * 	LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state);
 * 	state.acceptActualType(bool);
 * }
 * </pre>
 * 
 * 			The announced type is immediately propagated to all expectations. This is done by the 
 * 			inference framework.
 * 		</dd>
 * 		<dt>Expression type depends on the expectation.</dt>
 * 		<dd>
 * 			The expected type may steer the inferred type of an expression. Therefore the
 * 			state may be queried for the currently known expectations and the produced
 * 			type may be adjusted accordingly.
 * 
 * 			String literals are a good example for this mechanism. Literals with exactly one character
 * 			may be seen as character literals if the expected type suggests that. A simplified implementation
 * 			could look like this.
 * 
 * <pre>
 * void computeType(XStringLiteral literal, ITypeComputationState state) {
 *  if (literal.getValue().length() == 1) {
 *    for(ITypeExpectation expectation: state.getExpectations() {
 *      LightweightTypeReference expectedType = expectation.getExpectedType();
 *      if (expectedType.isType(Character.TYPE) || expectedType.isType(Character.class)) {
 *        expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED);
 *      } else {
 *        LightweightTypeReference string = getTypeForName(String.class, state);
 * 	      state.acceptActualType(string);
 *      }
 *    }
 *  } else {
 *    LightweightTypeReference string = getTypeForName(String.class, state);
 * 	  state.acceptActualType(string);
 *  }
 * }
 * </pre>
 * 		</dd>
 * 		<dt>The type of an expression depends on its children.</dt>
 * 		<dd>
 * 			Expression types may be inferred from the types of contained children. Therefore
 * 			the given computation state is directly used to compute their types. The framework
 * 			will automatically propagate the common type of all children to the parent.
 * 			If- or Switch expression fall into this category.
 * 
 * 			A simplified implementation would again look like this:
 * <pre>
 * void computeTypes(XIfExpression expression, ITypeComputationState state) {
 *  state.withExpectations(getTypeForName(Boolean.TYPE, state).computeTypes(expression.getIfExpression());
 *  state.computeTypes(expression.getThen());
 *  state.computeTypes(expression.getElse());
 * }
 * </pre>
 * 			The If expression adjusts the expectation for one of its children and computes its type.
 * 			Afterwards, it directly reuses the current expectations to compute the types of its
 * 			branch expressions. The common super type of those is assigned to the If expression by
 * 			the framework.
 * 		</dd>
 * </dl>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(XbaseTypeComputer.class)
public interface ITypeComputer {

	/**
	 * Compute the type for the given expression in the context of the given computation state.
	 * The state may be used to compute child types but implementations may not invoke this
	 * method recursively on their own. The framework handles the control flow.
	 * 
	 * @see ITypeComputationState#computeTypes(XExpression)
	 */
	void computeTypes(XExpression expression, ITypeComputationState state);

}
