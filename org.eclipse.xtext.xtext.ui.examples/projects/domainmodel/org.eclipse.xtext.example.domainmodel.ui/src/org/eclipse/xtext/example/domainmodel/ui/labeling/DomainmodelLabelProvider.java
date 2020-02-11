/**
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.ui.labeling;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity;
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Property;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.inject.Inject;

/**
 * Provides labels for EObjects. See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
public class DomainmodelLabelProvider extends XbaseLabelProvider {
	@Inject
	public DomainmodelLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	@Override
	protected Object doGetImage(Object element) {
		if (element instanceof JvmIdentifiableElement || element instanceof XImportSection || element instanceof XImportDeclaration) {
			return super.doGetImage(element);
		} else if (element instanceof EObject) {
			return ((EObject) element).eClass().getName() + ".gif";
		}
		return super.doGetImage(element);

	}

	public Object text(Entity entity) {
		StringBuilder builder = new StringBuilder();
		builder.append(Strings.notNull(entity.getName()));
		JvmParameterizedTypeReference superType = entity.getSuperType();
		if (superType != null) {
			builder.append(" extends ");
			builder.append(Strings.notNull(superType.getSimpleName()));
			return style(builder.toString());
		}
		return builder.toString();
	}

	public Object text(Property property) {
		StringBuilder builder = new StringBuilder();
		builder.append(Strings.notNull(property.getName()));
		builder.append(" : ");
		append(builder, property.getType());
		return style(builder.toString());
	}

	public Object text(Operation operation) {
		StringBuilder builder = new StringBuilder();
		builder.append(Strings.notNull(operation.getName()));
		builder.append("(");
		boolean isFirst = true;
		for (JvmFormalParameter param : operation.getParams()) {
			if (!isFirst) {
				builder.append(", ");
			}
			isFirst = false;
			append(builder, param.getParameterType());
		}
		builder.append(") : ");
		append(builder, operation.getType());
		return style(builder.toString());
	}

	protected void append(StringBuilder builder, JvmTypeReference typeRef) {
		if (typeRef instanceof JvmParameterizedTypeReference) {
			JvmType type = ((JvmParameterizedTypeReference) typeRef).getType();
			append(builder, type);
			EList<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) typeRef).getArguments();
			if (!arguments.isEmpty()) {
				builder.append("<");
				Iterator<JvmTypeReference> iterator = arguments.iterator();
				while (iterator.hasNext()) {
					JvmTypeReference jvmTypeReference = iterator.next();
					append(builder, jvmTypeReference);
					if (iterator.hasNext()) {
						builder.append(",");
					}
				}
				builder.append(">");
			}
		} else {
			if (typeRef instanceof JvmWildcardTypeReference) {
				builder.append("?");
				Iterator<JvmTypeConstraint> contraintsIterator = ((JvmWildcardTypeReference) typeRef).getConstraints().iterator();
				while (contraintsIterator.hasNext()) {
					JvmTypeConstraint constraint = contraintsIterator.next();
					if (constraint instanceof JvmUpperBound) {
						builder.append(" extends ");
					} else {
						builder.append(" super ");
					}
					append(builder, constraint.getTypeReference());
					if (contraintsIterator.hasNext()) {
						builder.append(" & ");
					}
				}
			} else {
				if (typeRef instanceof JvmGenericArrayTypeReference) {
					append(builder, ((JvmGenericArrayTypeReference) typeRef).getType());
				}
			}
		}
	}

	protected void append(StringBuilder builder, JvmType type) {
		if (type instanceof JvmArrayType) {
			append(builder, ((JvmArrayType) type).getComponentType());
			builder.append("[]");
		} else {
			builder.append(Strings.notNull(type.getSimpleName()));
		}
	}

	private StyledString style(String text) {
		StyledString styled = new StyledString(text);
		int offset = text.indexOf(":");
		if (offset == -1) {
			offset = text.indexOf("extends");
		}
		if (offset != -1) {
			int length = text.length();
			styled.setStyle(offset, length - offset, StyledString.DECORATIONS_STYLER);
		}
		return styled;
	}
}
