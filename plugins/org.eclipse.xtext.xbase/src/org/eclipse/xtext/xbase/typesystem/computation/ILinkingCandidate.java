/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * The supertype of {@link IFeatureLinkingCandidate} and {@link IConstructorLinkingCandidate}.
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public interface ILinkingCandidate {
	
	void apply();
	
	void resolveLinkingProxy();
	
	boolean isPreferredOver(ILinkingCandidate other);
	
	JvmIdentifiableElement getFeature();
	
	List<LightweightTypeReference> getTypeArguments();

}
