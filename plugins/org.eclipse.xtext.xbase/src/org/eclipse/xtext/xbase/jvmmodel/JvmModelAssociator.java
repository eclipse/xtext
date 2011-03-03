/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Sets.*;

import static java.util.Collections.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelAssociator implements IJvmModelAssociations, IJvmModelAssociator {

	public void associate(EObject sourceElement, EObject jvmElement) {
		associate(sourceElement, jvmElement, false);
	}

	public void associatePrimary(EObject sourceElement, EObject jvmElement) {
		associate(sourceElement, jvmElement, true);
	}

	protected void associate(EObject sourceElement, EObject jvmElement, boolean onlyPrimary) {
		setAdapter(sourceElement, jvmElement, onlyPrimary, false);
		setAdapter(jvmElement, sourceElement, onlyPrimary, true);
	}

	public void disassociate(EObject rootElement) {
		for (TreeIterator<EObject> content = EcoreUtil2.eAll(rootElement); content.hasNext();) {
			EObject element = content.next();
			AssociationAdapter associationAdapter = getAssociationAdapter(element);
			if (associationAdapter != null)
				element.eAdapters().remove(associationAdapter);
		}
	}

	public Set<EObject> getJvmElements(EObject sourceElement, boolean onlyPrimary) {
		AssociationAdapter adapter = getAssociationAdapter(sourceElement);
		if(adapter == null) 
			return emptySet();
		return (adapter.isJvmModel()) ? Collections.<EObject>emptySet() : getAssociatedElements(adapter, onlyPrimary);
	}

	public Set<EObject> getSourceElements(EObject jvmElement, boolean onlyPrimary) {
		AssociationAdapter adapter = getAssociationAdapter(jvmElement);
		if(adapter == null) 
			return emptySet();
		return (!adapter.isJvmModel()) ? Collections.<EObject>emptySet() : getAssociatedElements(adapter, onlyPrimary);
	}

	public Set<EObject> getAssociatedElements(EObject jvmOrSourceElement, boolean onlyPrimary) {
		AssociationAdapter adapter = getAssociationAdapter(jvmOrSourceElement);
		return getAssociatedElements(adapter, onlyPrimary);
	}

	protected Set<EObject> getAssociatedElements(AssociationAdapter adapter, boolean onlyPrimary) {
		return (adapter == null) ? Collections.<EObject> emptySet() : adapter.getAssociatedElements(onlyPrimary);
	}

	protected void setAdapter(EObject targetElement, EObject associatedElement, boolean isPrimary,
			boolean isTargetJvmModel) {
		AssociationAdapter adapter = getAssociationAdapter(targetElement);
		if (adapter == null) {
			adapter = new AssociationAdapter(isTargetJvmModel);
			targetElement.eAdapters().add(adapter);
		} else if (adapter.isJvmModel() != isTargetJvmModel) {
			throw new IllegalArgumentException("Element cannot be source and JvmModel at the same time.");
		}
		adapter.addAssociation(associatedElement, isPrimary);
	}

	protected AssociationAdapter getAssociationAdapter(EObject targetElement) {
		return (AssociationAdapter) EcoreUtil.getAdapter(targetElement.eAdapters(), AssociationAdapter.class);
	}

	protected static class AssociationAdapter extends AdapterImpl {
		private Set<EObject> associatedElements;
		private Set<EObject> primaryAssociatedElements;
		private boolean isJvmModel;

		public AssociationAdapter(boolean isJvmModel) {
			super();
			this.isJvmModel = isJvmModel;
		}

		public boolean isJvmModel() {
			return isJvmModel;
		}

		protected boolean addAssociation(EObject associatedElement, boolean isPrimary) {
			if (isPrimary) {
				if (primaryAssociatedElements == null)
					primaryAssociatedElements = newLinkedHashSet();
				return primaryAssociatedElements.add(associatedElement);
			} else {
				if (associatedElements == null)
					associatedElements = newLinkedHashSet();
			}
			return associatedElements.add(associatedElement);
		}

		public Set<EObject> getAssociatedElements(boolean onlyPrimary) {
			if (onlyPrimary)
				return (primaryAssociatedElements == null) ? Collections.<EObject> emptySet()
						: primaryAssociatedElements;
			else {
				if(primaryAssociatedElements != null) {
					if(associatedElements != null) {
						LinkedHashSet<EObject> allAssociatedElements = newLinkedHashSet(primaryAssociatedElements);
						allAssociatedElements.addAll(associatedElements);
						return allAssociatedElements;
					}
					return primaryAssociatedElements;
				} 
				return (associatedElements == null) ? Collections.<EObject> emptySet() : associatedElements;
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return AssociationAdapter.class.equals(type);
		}
	}

}
