/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.reconciler;

import static com.google.common.collect.Lists.*;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.util.ReplaceRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class ReconcilerReplaceRegion extends ReplaceRegion implements IRegion {

	private long modificationStamp;
	private List<DocumentEvent> events;
	
	public ReconcilerReplaceRegion(int offset, int length, String text) {
		super(offset, length, text);
	}

	public long getModificationStamp() {
		return modificationStamp;
	}

	public void setModificationStamp(long docModificationStampAfter) {
		this.modificationStamp = docModificationStampAfter;
	}
	
	/**
	 * @since 2.4
	 */
	public void addDocumentEvent(DocumentEvent event) {
		if(events == null)
			events = newArrayList();
		events.add(event);
	}
	
	/**
	 * @since 2.4
	 */
	public List<DocumentEvent> getDocumentEvents() {
		return (events == null) ? Collections.<DocumentEvent>emptyList() : events;
	}
	
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		ReconcilerReplaceRegion other = (ReconcilerReplaceRegion) object;
		if (this.getOffset() != other.getOffset()) {
			return false;
		}
		if (this.getLength() != other.getLength()) {
			return false;
		}
		if (this.getText() == null) {
			if (other.getText() != null) {
				return false;
			}
		} else if (!this.getText().equals(other.getText())) {
			return false;
		}
		if (this.modificationStamp != other.modificationStamp) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOffset();
		result = prime * result + getLength();
		result = prime * result + ((getText() == null) ? 0 : getText().hashCode());
		result = prime * result + (int) (modificationStamp % Integer.MAX_VALUE);
		return result;
	}
	
	@Override
	public String toString() {
		return "ReconcilerReplaceRegion [" + getOffset() + ":" + getLength() + "] '" 
				+ getText() + "' modificationStamp:" + getModificationStamp();  
	}
	
	public static Builder builder(String text) {
		return new Builder(text);
	}
	
	public static class Builder {

		private StringBuilder text;

		private boolean isEmpty;
		
		private int currentOffset;
		private int currentLength;
		private int currentReplacementOffset;
		private int currentReplacementLength;
		
		protected Builder(String text) {
			this.text = new StringBuilder(text);
			isEmpty = true;
		}
		
		public Builder add(final int nextOffset, final int nextLength, final String nextReplacement) {
			if(isEmpty) {
				isEmpty = false;
				currentOffset = nextOffset;
				currentLength = nextLength;
				currentReplacementOffset = nextOffset;
				currentReplacementLength = nextReplacement.length();
				text.replace(nextOffset, nextOffset + nextLength, nextReplacement);
			} else {
				int currentEnd = currentOffset + currentReplacementLength;
				int nextEnd = nextOffset + nextLength;
				int newOffset = Math.min(currentOffset, nextOffset);
				int newLength = nextLength;
				int prefixSize = 0;
				int postfixSize = 0;
				if(nextOffset >= currentOffset) {
					prefixSize = nextOffset - currentOffset;
					if(nextEnd <= currentEnd) {
						newLength = currentLength;
						postfixSize = currentEnd - nextEnd; 
					} else if(nextOffset < currentEnd) {
						newLength = currentLength + nextLength - (currentEnd-nextOffset);
					} else {
						newLength = currentLength + (nextOffset - currentEnd) + nextLength;
					}
				} else {
					if(nextEnd <= currentOffset) {
						newLength = nextLength + (currentOffset-nextEnd) + currentLength;
						postfixSize = currentEnd - nextEnd;
					} else if(nextEnd <= currentEnd) {
						newLength = currentLength + nextLength - (nextEnd-currentOffset);
						postfixSize = currentEnd - nextEnd; 
					} else {
						newLength = nextLength + currentLength - currentReplacementLength;
					}
				}
				currentOffset = newOffset;
				currentLength = newLength;
				text.replace(nextOffset, nextOffset + nextLength, nextReplacement);
				currentReplacementOffset = nextOffset - prefixSize;
				currentReplacementLength = nextReplacement.length() + prefixSize + postfixSize;
			}
			return this;
		}
		
		public ReconcilerReplaceRegion create() {
			String currentReplacement = text.substring(currentReplacementOffset, currentReplacementOffset + currentReplacementLength);
			return new ReconcilerReplaceRegion(currentOffset, currentLength, currentReplacement);
		}
	}
	
}
