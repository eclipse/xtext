/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ECrossReferenceDescriptorImpl implements ECrossReferenceDescriptor {

	private ResourceDescriptor sourceResourceDescriptor;
	private String sourceFragment;
	private String referenceName;
	private int index;
	private ResourceDescriptor targetResourceDescriptor;
	private String targetFragment;

	public ECrossReferenceDescriptorImpl(ResourceDescriptor sourceResourceDescriptor, String sourceFragment,
			String referenceName, ResourceDescriptor targetResourceDescriptor, String targetFragment) {
		this(sourceResourceDescriptor, sourceFragment, referenceName, NO_INDEX, targetResourceDescriptor, targetFragment);
	}

	public ECrossReferenceDescriptorImpl(ResourceDescriptor sourceResourceDescriptor, String sourceFragment,
			String referenceName, int index, ResourceDescriptor targetResourceDescriptor, String targetFragment) {
		super();
		this.sourceResourceDescriptor = sourceResourceDescriptor;
		this.sourceFragment = sourceFragment;
		this.referenceName = referenceName;
		this.targetResourceDescriptor = targetResourceDescriptor;
		this.targetFragment = targetFragment;
		this.index = index;
	}

	public ResourceDescriptor getSourceResourceDescriptor() {
		return sourceResourceDescriptor;
	}

	public String getSourceFragment() {
		return sourceFragment;
	}

	public ResourceDescriptor getTargetResourceDescriptor() {
		return targetResourceDescriptor;
	}

	public String getTargetFragment() {
		return targetFragment;
	}

	public URI getSourceURI() {
		return URI.createURI(sourceResourceDescriptor.getURI() + "#" + sourceFragment);
	}

	public String getReferenceName() {
		return referenceName;
	}

	public URI getTargetURI() {
		return URI.createURI(targetResourceDescriptor.getURI() + "#" + targetFragment);
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("(");
		b.append(sourceResourceDescriptor.getURI());
		b.append("#");
		b.append(sourceFragment);
		b.append(" --");
		b.append(referenceName);
		b.append("--> ");
		b.append(targetResourceDescriptor.getURI());
		b.append("#");
		b.append(targetFragment);
		b.append(")");
		return b.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ECrossReferenceDescriptor) {
			ECrossReferenceDescriptor crossRef = (ECrossReferenceDescriptor) obj;
			return crossRef.hashCode() == hashCode() 
				&& this.sourceFragment.equals(crossRef.getSourceFragment())
				&& this.targetFragment.equals(crossRef.getTargetFragment())
				&& this.sourceResourceDescriptor.equals(crossRef.getSourceResourceDescriptor())
				&& this.targetResourceDescriptor.equals(crossRef.getTargetResourceDescriptor())
				&& this.referenceName.equals(crossRef.getReferenceName())
				&& this.index == crossRef.getIndex();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return referenceName.hashCode() + 7 * sourceFragment.hashCode() + 31 * targetFragment.hashCode() +
			53 * sourceResourceDescriptor.hashCode() + 89 * targetResourceDescriptor.hashCode();
	}

}
