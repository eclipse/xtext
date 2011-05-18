/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.EcoreUtil2;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelAssociator implements IJvmModelAssociations, IJvmModelAssociator {

	@Inject@Named(Constants.LANGUAGE_NAME)
	private String languageID;
	
	public void associate(EObject sourceElement, EObject jvmElement) {
		associate(sourceElement, jvmElement, false);
	}

	public void associatePrimary(EObject sourceElement, EObject jvmElement) {
		associate(sourceElement, jvmElement, true);
	}

	public void disassociate(EObject rootElement) {
		for (TreeIterator<EObject> content = EcoreUtil2.eAll(rootElement); content.hasNext();) {
			EObject element = content.next();
			AbstractAssociationAdapter associationAdapter = getAssociationAdapter(element);
			if (associationAdapter != null)
				element.eAdapters().remove(associationAdapter);
		}
	}

	protected void associate(EObject sourceElement, EObject jvmElement, boolean isPrimary) {
		setSourceAdapter(sourceElement, jvmElement);
		setJvmAdapter(jvmElement, sourceElement, isPrimary);
	}

	protected void setSourceAdapter(EObject targetElement, EObject associatedElement) {
		AbstractAssociationAdapter adapter = getAssociationAdapter(targetElement);
		if (adapter == null) {
			adapter = new SourceAssociationAdapter(languageID);
			targetElement.eAdapters().add(adapter);
		} else
			checkAdapter(adapter, false);
		adapter.addAssociation(associatedElement);
	}

	protected void setJvmAdapter(EObject targetElement, EObject associatedElement, boolean isPrimary) {
		AbstractAssociationAdapter adapter = getAssociationAdapter(targetElement);
		if (adapter == null) {
			adapter = new JvmAssociationAdapter(languageID);
			targetElement.eAdapters().add(adapter);
		} else
			checkAdapter(adapter, true);
		if (isPrimary)
			((JvmAssociationAdapter) adapter).setPrimaryAssociatedElement(associatedElement);
		else
			adapter.addAssociation(associatedElement);
	}

	public Set<EObject> getJvmElements(EObject sourceElement) {
		return getAssociatedElements(getSourceAdapter(sourceElement));
	}

	public Set<EObject> getSourceElements(EObject jvmElement) {
		return getAssociatedElements(getJvmAdapter(jvmElement));
	}

	public EObject getPrimarySourceElement(EObject jvmElement) {
		JvmAssociationAdapter jvmAdapter = getJvmAdapter(jvmElement);
		return (jvmAdapter) != null ? jvmAdapter.getPrimaryAssociatedElement() : null;
	}

	public Set<EObject> getAssociatedElements(EObject jvmOrSourceElement) {
		return getAssociatedElements(getAssociationAdapter(jvmOrSourceElement));
	}

	protected Set<EObject> getAssociatedElements(AbstractAssociationAdapter adapter) {
		return (adapter == null) ? Collections.<EObject> emptySet() : adapter.getAssociatedElements();
	}

	protected SourceAssociationAdapter getSourceAdapter(EObject sourceElement) {
		AbstractAssociationAdapter adapter = getAssociationAdapter(sourceElement);
		return (adapter instanceof SourceAssociationAdapter) ? (SourceAssociationAdapter) adapter : null;
	}

	protected JvmAssociationAdapter getJvmAdapter(EObject jvmElement) {
		AbstractAssociationAdapter adapter = getAssociationAdapter(jvmElement);
		return (adapter instanceof JvmAssociationAdapter) ? (JvmAssociationAdapter) adapter : null;
	}

	protected void checkAdapter(AbstractAssociationAdapter adapter, boolean isJvm) {
		if (adapter != null && (adapter instanceof JvmAssociationAdapter ^ isJvm))
			throw new IllegalArgumentException(
					"Wrong association adapter type. It's likely you confused source and jvm element");
	}

	protected AbstractAssociationAdapter getAssociationAdapter(EObject jvmOrSourceElement) {
		AbstractAssociationAdapter adapter = (AbstractAssociationAdapter) EcoreUtil.getAdapter(jvmOrSourceElement.eAdapters(),
				AbstractAssociationAdapter.class);
		return (adapter != null && equal(adapter.getLanguageID(), languageID)) ? adapter : null;
	}

	protected static abstract class AbstractAssociationAdapter extends AdapterImpl {
		private Set<EObject> associatedElements;
		
		private String languageID;

		public AbstractAssociationAdapter(String languageID) {
			super();
			this.languageID = languageID;
		}

		public String getLanguageID() {
			return languageID;
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
			return AbstractAssociationAdapter.class.equals(type);
		}
	}

	protected static class SourceAssociationAdapter extends AbstractAssociationAdapter {
		public SourceAssociationAdapter(String languageID) {
			super(languageID);
		}
	}

	protected static class JvmAssociationAdapter extends AbstractAssociationAdapter {
		private EObject primaryAssociatedElement;

		public JvmAssociationAdapter(String languageID) {
			super(languageID);
		}

		public EObject getPrimaryAssociatedElement() {
			return primaryAssociatedElement;
		}

		public void setPrimaryAssociatedElement(EObject primaryAssociatedElement) {
			this.primaryAssociatedElement = primaryAssociatedElement;
			addAssociation(primaryAssociatedElement);
		}
	}
}
