/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * The supertype of {@link IFeatureLinkingCandidate} and {@link IConstructorLinkingCandidate}.
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public interface ILinkingCandidate {
	
	void apply();
	
	void resolveLinkingProxy();
	
	boolean isPreferredOver(ILinkingCandidate other);
	
	JvmIdentifiableElement getFeature();

}
