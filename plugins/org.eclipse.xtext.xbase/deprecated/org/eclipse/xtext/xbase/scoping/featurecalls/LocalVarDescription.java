/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LocalVarDescription extends EObjectDescription implements IValidatedEObjectDescription {

	private String issueCode;

	public LocalVarDescription(QualifiedName qualifiedName, JvmIdentifiableElement element) {
		super(qualifiedName, element, Collections.<String, String>emptyMap());
	}

	@Override
	public JvmIdentifiableElement getEObjectOrProxy() {
		return (JvmIdentifiableElement) super.getEObjectOrProxy();
	}
	
	public boolean isValid() {
		return isEmpty(issueCode);
	}
	
	public boolean isVisible() {
		return true;
	}
	
	public boolean isValidStaticState() {
		return true;
	}
	
	public String getKey() {
		return getName().toString();
	}

	public void setIssueCode(String issueCode) {
		this.issueCode = issueCode;
	}

	public String getIssueCode() {
		return issueCode;
	}

	public boolean isSameValidationState(IValidatedEObjectDescription other) {
		return other.getClass().equals(LocalVarDescription.class) || other.isSameValidationState(this);
	}
}
