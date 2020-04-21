/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.occurrences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the occurrences service.
 */
public class OccurrencesResult implements IServiceResult {
	private final String stateId;

	private final List<TextRegion> writeRegions = new ArrayList<>();

	private final List<TextRegion> readRegions = new ArrayList<>();

	public OccurrencesResult(String stateId) {
		this.stateId = stateId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((readRegions == null) ? 0 : readRegions.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		result = prime * result + ((writeRegions == null) ? 0 : writeRegions.hashCode());
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
		OccurrencesResult other = (OccurrencesResult) obj;
		if (readRegions == null) {
			if (other.readRegions != null)
				return false;
		} else if (!readRegions.equals(other.readRegions))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		if (writeRegions == null) {
			if (other.writeRegions != null)
				return false;
		} else if (!writeRegions.equals(other.writeRegions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.skipNulls();
		b.add("stateId", this.stateId);
		b.add("writeRegions", this.writeRegions);
		b.add("readRegions", this.readRegions);
		return b.toString();
	}

	public String getStateId() {
		return stateId;
	}

	public List<TextRegion> getWriteRegions() {
		return writeRegions;
	}

	public List<TextRegion> getReadRegions() {
		return readRegions;
	}
}
