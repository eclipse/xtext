/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XbaseResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
	
	private static final Logger LOG = Logger.getLogger(XbaseResourceDescriptionStrategy.class);

	public static final String SIGNATURE_HASH_KEY = "sig";
	
	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (getQualifiedNameProvider() == null)
			return false;
		try {
			QualifiedName qualifiedName = getQualifiedNameProvider().getFullyQualifiedName(eObject);
			if (qualifiedName != null) {
				acceptor.accept(EObjectDescription.create(qualifiedName, eObject, createLazyUserData(eObject)));
			}
		} catch (Exception exc) {
			LOG.error(exc.getMessage());
		}
		return true;
	}
	
	protected Map<String, String> createLazyUserData(final EObject eObject) { 
		return new ForwardingMap<String, String>() {
			private Map<String,String> delegate; 
			
			@Override
			protected Map<String, String> delegate() {
				if(delegate == null) {
					Builder<String, String> userData = ImmutableMap.builder();
					createUserData(eObject, userData);
					delegate = userData.build();
				} 
				return delegate;
			}
		};
	}

	protected void createUserData(EObject eObject, ImmutableMap.Builder<String, String> userData) {
		if (eObject instanceof JvmOperation)
			addSignature(getSignature((JvmOperation) eObject), userData);
		else if (eObject instanceof JvmField)
			addSignature(getSignature((JvmField) eObject), userData);
		else if (eObject instanceof JvmConstructor)
			addSignature(getSignature((JvmConstructor) eObject), userData);
	}

	protected void addSignature(String rebuildSignature, ImmutableMap.Builder<String, String> userData) {
		userData.put(SIGNATURE_HASH_KEY, Integer.toString(rebuildSignature.hashCode()));
	}

	protected String getSignature(JvmOperation operation) {
		RebuildSignatureBuilder b = new RebuildSignatureBuilder();
		b.appendVisibility(operation.getVisibility()).append(" ")
			.appendType(operation.getReturnType()).append(" <");
		for(JvmTypeParameter tp: (operation).getTypeParameters()) {
			b.appendTypeParameter(tp);
			b.append(" ");
		}
		b.append("> (");
		for(JvmFormalParameter p: operation.getParameters()) {
			b.appendType(p.getParameterType());
			b.append(" ");
		}
		b.append(") ");
		for(JvmTypeReference ex: operation.getExceptions()) {
			b.appendType(ex);
			b.append(" ");
		}
		return b.toString();
	}
	
	protected String getSignature(JvmField field) {
		return new RebuildSignatureBuilder()
			.appendVisibility(field.getVisibility()).append(" ")
			.appendType(field.getType()).toString();
	}
	
	protected String getSignature(JvmConstructor operation) {
		RebuildSignatureBuilder b = new RebuildSignatureBuilder();
		b.appendVisibility(operation.getVisibility()).append(" <");
		for(JvmTypeParameter tp: (operation).getTypeParameters()) {
			b.appendTypeParameter(tp);
			b.append(" ");
		}
		b.append("> (");
		for(JvmFormalParameter p: operation.getParameters()) {
			b.appendType(p.getParameterType());
			b.append(" ");
		}
		b.append(") ");
		for(JvmTypeReference ex: operation.getExceptions()) {
			b.appendType(ex);
			b.append(" ");
		}
		return b.toString();
	}
	
	public static class RebuildSignatureBuilder {
		private StringBuilder builder = new StringBuilder();
		
		public RebuildSignatureBuilder appendVisibility(JvmVisibility v) {
			builder.append(v.getLiteral());
			return this;
		}

		public RebuildSignatureBuilder appendTypeParameter(JvmTypeParameter p) {
			if(p != null && p.getIdentifier() != null) {
				builder.append(p.getIdentifier());
			} else {
				builder.append("*unresolved*");
			}
			return this;
		}

		public RebuildSignatureBuilder appendType(JvmTypeReference ref) {
			if(ref != null && ref.getIdentifier() != null) {
				builder.append(ref.getIdentifier());
			} else {
				builder.append("*unresolved*");
			}
			return this;
		}
		
		public RebuildSignatureBuilder append(String s) {
			builder.append(s);
			return this;
		}
		
		@Override
		public String toString() {
			return builder.toString();
		}
	}
}
