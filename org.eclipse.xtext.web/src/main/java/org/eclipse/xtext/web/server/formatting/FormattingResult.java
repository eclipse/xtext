/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.formatting;

import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the formatting service.
 */
public class FormattingResult implements IServiceResult {
	private final String stateId;

	private final String formattedText;

	private final TextRegion replaceRegion;

	public FormattingResult(String stateId, String formattedText, TextRegion replaceRegion) {
		this.stateId = stateId;
		this.formattedText = formattedText;
		this.replaceRegion = replaceRegion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formattedText == null) ? 0 : formattedText.hashCode());
		result = prime * result + ((replaceRegion == null) ? 0 : replaceRegion.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormattingResult other = (FormattingResult) obj;
		if (formattedText == null) {
			if (other.formattedText != null)
				return false;
		} else if (!formattedText.equals(other.formattedText))
			return false;
		if (replaceRegion == null) {
			if (other.replaceRegion != null)
				return false;
		} else if (!replaceRegion.equals(other.replaceRegion))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.skipNulls();
		b.add("stateId", this.stateId);
		b.add("formattedText", this.formattedText);
		b.add("replaceRegion", this.replaceRegion);
		return b.toString();
	}

	public String getStateId() {
		return stateId;
	}

	public String getFormattedText() {
		return formattedText;
	}

	public TextRegion getReplaceRegion() {
		return replaceRegion;
	}
}
