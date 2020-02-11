/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.ImmutableList;

/**
 * A validation diagnostic that is associated with a range.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RangeBasedDiagnostic extends AbstractValidationDiagnostic {

	private final int offset;
	private final int length;

	protected RangeBasedDiagnostic(int severity, String message, EObject source, int offset, int length, CheckType checkType, String issueCode,
			String[] issueData) {
		super(severity, message, source, checkType, issueCode, issueData);
		this.offset = offset;
		this.length = length;
	}

	@Override
	public List<?> getData() {
		if (getIssueData() == null)
			return ImmutableList.of(getSourceEObject(), offset, length);
		else
			return ImmutableList.of(getSourceEObject(), offset, length, getIssueData());
	}
	
	public int getOffset() {
		return offset;
	}
	
	public int getLength() {
		return length;
	}

	@Override
	public String getSource() {
		return super.getSource() + "@[" + offset + ":" + length + "]";
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(super.toString());
		result.append("@[").append(offset).append(":").append(length).append("]");
		return result.toString();
	}
}
