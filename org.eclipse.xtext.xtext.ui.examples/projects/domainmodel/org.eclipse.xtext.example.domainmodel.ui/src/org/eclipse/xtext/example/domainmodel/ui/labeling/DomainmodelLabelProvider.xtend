/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.labeling

import com.google.inject.Inject
import java.util.Iterator
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.common.types.JvmArrayType
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeConstraint
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.JvmUpperBound
import org.eclipse.xtext.common.types.JvmWildcardTypeReference
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.example.domainmodel.domainmodel.Operation
import org.eclipse.xtext.example.domainmodel.domainmodel.Property
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider
import org.eclipse.xtext.xtype.XImportDeclaration
import org.eclipse.xtext.xtype.XImportSection

import static org.eclipse.xtext.util.Strings.*

/**
 * Provides labels for a EObjects.
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#label-provider
 */
class DomainmodelLabelProvider extends XbaseLabelProvider {
	@Inject new(AdapterFactoryLabelProvider delegate) {
		super(delegate)
	}

	override protected Object doGetImage(Object element) {
		if (element instanceof EObject) {
			switch element {
				JvmIdentifiableElement, XImportSection, XImportDeclaration: {
					return super.doGetImage(element)
				}
				default: {
					return '''«element.eClass.name».gif'''.toString
				}
			}
		}
		return super.doGetImage(element)
	}

	def Object text(Entity entity) {
		var StringBuilder builder = new StringBuilder()
		builder.append(notNull(entity.getName()))
		val superType = entity.superType
		if (superType !== null) {
			builder.append(" extends ")
			builder.append(notNull(superType.simpleName))
			return builder.toString.style
		}
		return builder.toString()
	}

	def Object text(Property property) {
		var StringBuilder builder = new StringBuilder()
		builder.append(notNull(property.getName()))
		builder.append(" : ")
		append(builder, property.getType())
		return builder.toString().style
	}

	def Object text(Operation operation) {
		var StringBuilder builder = new StringBuilder()
		builder.append(notNull(operation.getName()))
		builder.append("(")
		var boolean isFirst = true
		for (JvmFormalParameter param : operation.getParams()) {
			if(!isFirst) builder.append(", ")
			isFirst = false
			append(builder, param.getParameterType())
		}
		builder.append(") : ")
		append(builder, operation.getType())
		return builder.toString().style
	}

	def protected void append(StringBuilder builder, JvmTypeReference typeRef) {
		if (typeRef instanceof JvmParameterizedTypeReference) {
			val JvmType type = typeRef.getType()
			append(builder, type)
			var EList<JvmTypeReference> arguments = typeRef.getArguments()
			if (!arguments.isEmpty()) {
				builder.append("<")
				var Iterator<JvmTypeReference> iterator = arguments.iterator()
				while (iterator.hasNext()) {
					var JvmTypeReference jvmTypeReference = iterator.next()
					append(builder, jvmTypeReference)
					if(iterator.hasNext()) builder.append(",")
				}
				builder.append(">")
			}
		} else if (typeRef instanceof JvmWildcardTypeReference) {
			builder.append("?")
			var Iterator<JvmTypeConstraint> iterator = typeRef.getConstraints().
				iterator()
			while (iterator.hasNext()) {
				var JvmTypeConstraint constraint = iterator.next()
				if (constraint instanceof JvmUpperBound) {
					builder.append(" extends ")
				} else {
					builder.append(" super ")
				}
				append(builder, constraint.getTypeReference())
				if(iterator.hasNext()) builder.append(" & ")
			}
		} else if (typeRef instanceof JvmGenericArrayTypeReference) {
			append(builder, typeRef.getType())
		}
	}

	def protected void append(StringBuilder builder, JvmType type) {
		if (type instanceof JvmArrayType) {
			append(builder, type.getComponentType())
			builder.append("[]")
		} else {
			builder.append(notNull(type.getSimpleName()))
		}
	}

	private def style(String text) {
		val styled = new StyledString(text)
		var offset = text.indexOf(':')
		if (offset == -1) {
			offset = text.indexOf('extends')
		}
		if (offset != -1) {
			styled.setStyle(offset, text.length - offset, StyledString.DECORATIONS_STYLER)
		}
		styled
	}
}
