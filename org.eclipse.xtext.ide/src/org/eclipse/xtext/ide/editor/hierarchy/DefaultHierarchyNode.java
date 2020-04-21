/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Wrapper;

import com.google.common.base.Objects;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public class DefaultHierarchyNode implements IHierarchyNode {
	private IHierarchyNode parent;

	private boolean mayHaveChildren;

	private IEObjectDescription element;

	private final List<IHierarchyNodeReference> references = new ArrayList<>();

	private Wrapper<Boolean> recursive;

	@Override
	public Object getNavigationElement() {
		if (!references.isEmpty()) {
			return references.get(0);
		} else {
			return element;
		}
	}

	@Override
	public boolean isRecursive() {
		if (recursive == null) {
			recursive = Wrapper.wrap(internalIsRecursive());
		}
		return recursive.get().booleanValue();
	}

	protected boolean internalIsRecursive() {
		IHierarchyNode node = parent;
		while (node != null) {
			URI nodeElementUri = node.getElement().getEObjectURI();
			URI elementUri = this.element.getEObjectURI();
			if (Objects.equal(nodeElementUri, elementUri)) {
				return true;
			}
			node = node.getParent();
		}
		return false;
	}

	@Override
	public boolean mayHaveChildren() {
		return mayHaveChildren;
	}

	public IHierarchyNode getParent() {
		return parent;
	}

	public void setParent(IHierarchyNode parent) {
		this.parent = parent;
	}

	public void setMayHaveChildren(boolean mayHaveChildren) {
		this.mayHaveChildren = mayHaveChildren;
	}

	public IEObjectDescription getElement() {
		return element;
	}

	public void setElement(IEObjectDescription element) {
		this.element = element;
	}

	public List<IHierarchyNodeReference> getReferences() {
		return references;
	}
}
