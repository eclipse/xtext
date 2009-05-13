/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl;

import java.io.Serializable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.ResourceDescriptor;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EReferenceDescriptorImpl implements EReferenceDescriptor, Serializable {

	private static final long serialVersionUID = -9111865497767470045L;

	private ResourceDescriptor sourceResourceDescriptor;
	private String sourceFragment;
	private String referenceName;
	private int index;
	private ResourceDescriptor targetResourceDescriptor;
	private String targetFragment;

	public EReferenceDescriptorImpl(ResourceDescriptor sourceResourceDescriptor, String sourceFragment,
			String referenceName, ResourceDescriptor targetResourceDescriptor, String targetFragment) {
		this(sourceResourceDescriptor, sourceFragment, referenceName, NO_INDEX, targetResourceDescriptor, targetFragment);
	}

	public EReferenceDescriptorImpl(ResourceDescriptor sourceResourceDescriptor, String sourceFragment,
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
		if (obj instanceof EReferenceDescriptor) {
			EReferenceDescriptor eReferenceDescriptor = (EReferenceDescriptor) obj;
			return eReferenceDescriptor.hashCode() == hashCode() 
				&& this.sourceFragment.equals(eReferenceDescriptor.getSourceFragment())
				&& this.targetFragment.equals(eReferenceDescriptor.getTargetFragment())
				&& this.sourceResourceDescriptor.equals(eReferenceDescriptor.getSourceResourceDescriptor())
				&& this.targetResourceDescriptor.equals(eReferenceDescriptor.getTargetResourceDescriptor())
				&& this.referenceName.equals(eReferenceDescriptor.getReferenceName())
				&& this.index == eReferenceDescriptor.getIndex();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return referenceName.hashCode() + 7 * sourceFragment.hashCode() + 31 * targetFragment.hashCode() +
			53 * sourceResourceDescriptor.hashCode() + 89 * targetResourceDescriptor.hashCode();
	}

}
