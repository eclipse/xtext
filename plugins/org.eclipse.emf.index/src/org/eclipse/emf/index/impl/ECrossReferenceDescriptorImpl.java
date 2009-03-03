/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ECrossReferenceDescriptorImpl implements ECrossReferenceDescriptor {

	private EObjectDescriptor source;
	private String referenceName;
	private EObjectDescriptor target;
	private int index;

	public ECrossReferenceDescriptorImpl(EObjectDescriptor source, String referenceName, EObjectDescriptor target) {
		this(source, referenceName, target, NO_INDEX);
	}

	public ECrossReferenceDescriptorImpl(EObjectDescriptor source, String referenceName, EObjectDescriptor target, int index) {
		super();
		this.source = source;
		this.referenceName = referenceName;
		this.target = target;
		this.index = index;
	}

	public EObjectDescriptor getSource() {
		return source;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public EObjectDescriptor getTarget() {
		return target;
	}
	
	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("(");
		b.append(source);
		b.append(" --");
		b.append(referenceName);
		b.append("--> ");
		b.append(target);
		b.append(")");
		return b.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ECrossReferenceDescriptor) {
			ECrossReferenceDescriptor crossRef = (ECrossReferenceDescriptor) obj;
			return crossRef.hashCode() == hashCode() && this.source.equals(crossRef.getSource())
					&& this.referenceName.equals(crossRef.getReferenceName())
					&& this.target.equals(crossRef.getTarget());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return referenceName.hashCode() + 31 * source.hashCode() + 67 * target.hashCode();
	}

}
