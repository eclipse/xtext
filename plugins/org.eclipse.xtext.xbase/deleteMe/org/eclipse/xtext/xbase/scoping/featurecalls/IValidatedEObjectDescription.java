/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public interface IValidatedEObjectDescription extends IEObjectDescription {

	boolean isValid();
	
	boolean isVisible();
	
	boolean isValidStaticState();
	
	void setIssueCode(String issueCode);
	
	String getIssueCode();
	
	JvmIdentifiableElement getEObjectOrProxy();

	String getKey();
	
	boolean isSameValidationState(IValidatedEObjectDescription other);
	
}
