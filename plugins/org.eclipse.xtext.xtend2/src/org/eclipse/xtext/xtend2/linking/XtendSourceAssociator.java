/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendSourceAssociator {

	public void associate(JvmGenericType jvmType, XtendClass xtendClass) {
		setAdapter(jvmType, xtendClass);
		xtendClass.setInferredJvmType(jvmType);
	}
	
	public void associate(JvmOperation jvmOperation, XtendFunction xtendFunction) {
		setAdapter(jvmOperation, xtendFunction);
		xtendFunction.setInferredJvmMember(jvmOperation);
	}
	
	public XtendClass getXtendSource(JvmGenericType inferredType) {
		return getAssociatedElement(inferredType);
	}
	
	public XtendFunction getXtendSource(JvmOperation inferredOperation) {
		return getAssociatedElement(inferredOperation);
	}
	
	public EObject getXtendSource(EObject element) {
		return getAssociatedElement(element);
	}
	
	protected void setAdapter(EObject jvmElement, EObject xtendElement) {
		jvmElement.eAdapters().add(new AssociationAdapter(xtendElement));
	}

	@SuppressWarnings("unchecked")
	protected <T> T getAssociatedElement(EObject element) {
		if(element == null)
			return null;
		AssociationAdapter associationAdapter = (AssociationAdapter) EcoreUtil.getAdapter(element.eAdapters(), AssociationAdapter.class);
		return (associationAdapter != null) ? (T) associationAdapter.getXtendSource() : null;
	}
	
	protected static class AssociationAdapter extends AdapterImpl {
		private EObject xtendSource;

		public AssociationAdapter(EObject xtendSource) {
			super();
			this.xtendSource = xtendSource;
		}
		
		public EObject getXtendSource() {
			return xtendSource;
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return AssociationAdapter.class.equals(type);
		}
	}

}
