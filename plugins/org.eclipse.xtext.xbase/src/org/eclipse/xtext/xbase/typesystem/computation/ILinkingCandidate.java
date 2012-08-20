/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;

/**
 * The supertype of {@link IFeatureLinkingCandidate} and {@link IConstructorLinkingCandidate}.
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public interface ILinkingCandidate<Candidate extends ILinkingCandidate<Candidate>> {
	
	void apply();
	
	void resolveLinkingProxy();
	
	boolean isPreferredOver(Candidate other);
	
	JvmIdentifiableElement getFeature();

	List<XExpression> getArguments();
	
	List<JvmFormalParameter> getDeclaredParameters();
	
	List<JvmTypeParameter> getDeclaredTypeParameters();
	
	/**
	 * two cases
	 *  - vararsgs: number of arguments is greater/equals to number of declared parameters
	 *  - default: number of arguments is equal to number of declared parameters
	 */
	int getArityMismatch();
	
	/**
	 * two cases
	 *  - explicit type arguments: number of arguments is greater/equals to number of declared parameters
	 *  - else: 0
	 */
	int getTypeArityMismatch();
	
}
