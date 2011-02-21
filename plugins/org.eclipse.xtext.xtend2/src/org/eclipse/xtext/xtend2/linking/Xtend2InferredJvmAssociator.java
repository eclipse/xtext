/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Sets.*;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2InferredJvmAssociator implements IXtend2JvmAssociations {

	public void associate(EObject xtendElement, EObject inferredJvmElement) {
		setAdapter(xtendElement, inferredJvmElement);
		setAdapter(inferredJvmElement, xtendElement);
	}

	public void disassociate(EObject rootElement) {
		for (TreeIterator<EObject> content = EcoreUtil2.eAll(rootElement); content.hasNext();) {
			EObject element = content.next();
			AssociationAdapter associationAdapter = getAssociationAdapter(element);
			if (associationAdapter != null)
				element.eAdapters().remove(associationAdapter);
		}
	}

	public Set<EObject> getAssociatedElements(EObject inferredJvmOrXtendElement) {
		AssociationAdapter adapter = getAssociationAdapter(inferredJvmOrXtendElement);
		return (adapter == null) ? Collections.<EObject> emptySet() : adapter.getAssociatedElements();
	}

	@SuppressWarnings("unchecked")
	public <T> Set<T> getAssociatedElements(EObject inferredJvmOrXtendElement, Class<T> type) {
		return (Set<T>) Sets.filter(getAssociatedElements(inferredJvmOrXtendElement), Predicates.instanceOf(type));
	}

	public Set<EObject> getXtendElements(EObject inferredJvmElement) {
		return filter(getAssociatedElements(inferredJvmElement), new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input.eClass().getEPackage() == Xtend2Package.eINSTANCE;
			}
		});
	}

	public Set<EObject> getInferredJvmElements(EObject xtendElement) {
		return filter(getAssociatedElements(xtendElement), new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input.eClass().getEPackage() == TypesPackage.eINSTANCE;
			}
		});
	}

	public JvmGenericType getInferredType(XtendClass xtendClass) {
		return getFirstAssociatedElement(xtendClass, JvmGenericType.class);
	}

	public JvmConstructor getInferredConstructor(XtendClass xtendClass) {
		return getFirstAssociatedElement(xtendClass, JvmConstructor.class);
	}

	public JvmOperation getDirectlyInferredOperation(final XtendFunction xtendFunction) {
		for(EObject element: getAssociatedElements(xtendFunction)) {
			if(element instanceof JvmOperation
						&& getAssociatedElements(element).size() == 1) 
				return (JvmOperation) element;
		}
		return null;
	}
	
	public XtendClass getXtendClass(JvmGenericType inferredType) {
		return getFirstAssociatedElement(inferredType, XtendClass.class);
	}

	public XtendFunction getXtendFunction(final JvmOperation inferredOperation) {
		return (XtendFunction) find(getAssociatedElements(inferredOperation), new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof XtendFunction;
			}
		});
	}

	@SuppressWarnings("unchecked")
	private <T> T getFirstAssociatedElement(EObject element, Class<T> type) {
		return (T) find(getAssociatedElements(element), Predicates.instanceOf(type));
	}

	protected void setAdapter(EObject targetElement, EObject associatedElement) {
		AssociationAdapter adapter = getAssociationAdapter(targetElement);
		if (adapter == null) {
			adapter = new AssociationAdapter();
			targetElement.eAdapters().add(adapter);
		}
		adapter.addAssociation(associatedElement);
	}

	protected AssociationAdapter getAssociationAdapter(EObject targetElement) {
		return (AssociationAdapter) EcoreUtil.getAdapter(targetElement.eAdapters(), AssociationAdapter.class);
	}

	protected static class AssociationAdapter extends AdapterImpl {
		private Set<EObject> associatedElements;

		public AssociationAdapter() {
			super();
		}

		protected boolean addAssociation(EObject associatedElement) {
			if (associatedElements == null)
				associatedElements = newLinkedHashSet();
			return associatedElements.add(associatedElement);
		}

		public Set<EObject> getAssociatedElements() {
			return (associatedElements == null) ? Collections.<EObject> emptySet() : associatedElements;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return AssociationAdapter.class.equals(type);
		}
	}

}
