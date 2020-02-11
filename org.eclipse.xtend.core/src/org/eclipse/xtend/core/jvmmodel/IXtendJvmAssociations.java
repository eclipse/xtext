/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IXtendJvmAssociations.Impl.class)
public interface IXtendJvmAssociations extends IJvmModelAssociations {

	JvmDeclaredType getInferredType(XtendTypeDeclaration xtendClass);
	
	JvmGenericType getInferredType(AnonymousClass anonymousClass);
	
	JvmGenericType getInferredType(XtendClass xtendClass);

	JvmGenericType getInferredType(XtendInterface xtendInterfaceClass);

	JvmAnnotationType getInferredAnnotationType(XtendAnnotationType xtendAnnotation);
	
	JvmEnumerationType getInferredEnumerationType(XtendEnum xtendInterfaceClass);
	
	JvmConstructor getInferredConstructor(XtendClass xtendClass);

	JvmConstructor getInferredConstructor(XtendConstructor xtendConstructor);
	
	/**
	 * Returns the directly inferred operation for the given function. If possible, this method returns
	 * an operation with exactly the same name as the {@code xtendFunction}, otherwise the first
	 * associated JVM operation. {@code null} is returned if there is no associated operation.
	 * 
	 * <p>If the function is a dispatch function, the dispatch case is returned and not the dispatcher.</p>
	 * 
	 * <p>If the function is a create function, the public visible function is returned and not
	 * the synthetic initializer function.</p>
	 * 
	 * @see #getDispatchOperation(XtendFunction)
	 */
	JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction);
	
	JvmOperation getDispatchOperation(XtendFunction dispatchFunction);
	
	JvmField getJvmField(XtendField field);
	
	JvmField getJvmField(XtendEnumLiteral field);
	
	JvmFormalParameter getJvmParameter(XtendParameter parameter);
	
	XtendClass getXtendClass(JvmGenericType jvmType);
	
	XtendInterface getXtendInterface(JvmGenericType jvmType);
	
	XtendFunction getXtendFunction(JvmOperation jvmOperation);

	XtendConstructor getXtendConstructor(JvmConstructor jvmConstructor);
	
	XtendField getXtendField(JvmField jvmField);
	
	AnonymousClass getAnonymousClass(JvmDeclaredType type);
	
	@Singleton
	static class Impl extends JvmModelAssociator implements IXtendJvmAssociations {

		@Override
		public JvmDeclaredType getInferredType(XtendTypeDeclaration xtendType) {
			final JvmDeclaredType firstOrNull = getFirstOrNull(getJvmElements(xtendType), JvmDeclaredType.class);
			return firstOrNull;
		}
		
		@Override
		public JvmGenericType getInferredType(AnonymousClass anonymousClass) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(anonymousClass), JvmGenericType.class);
			return firstOrNull;
		}
		
		@Override
		public JvmGenericType getInferredType(XtendClass xtendClass) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmGenericType.class);
			return firstOrNull;
		}

		@Override
		public JvmGenericType getInferredType(XtendInterface xtendInterface) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(xtendInterface), JvmGenericType.class);
			return firstOrNull;
		}

		@Override
		public JvmAnnotationType getInferredAnnotationType(XtendAnnotationType xtendAnnotation) {
			final JvmAnnotationType firstOrNull = getFirstOrNull(getJvmElements(xtendAnnotation), JvmAnnotationType.class);
			return firstOrNull;
		}

		@Override
		public JvmEnumerationType getInferredEnumerationType(XtendEnum xtendEnum) {
			final JvmEnumerationType firstOrNull = getFirstOrNull(getJvmElements(xtendEnum), JvmEnumerationType.class);
			return firstOrNull;
		}

		@Override
		public JvmConstructor getInferredConstructor(XtendClass xtendClass) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmConstructor.class);
			return firstOrNull;
		}

		@Override
		public JvmConstructor getInferredConstructor(XtendConstructor xtendConstructor) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendConstructor), JvmConstructor.class);
			return firstOrNull;
		}

		@Override
		public JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction) {
			final Iterable<JvmOperation> jvmElements = filter(getJvmElements(xtendFunction), JvmOperation.class);
			String expectedName = xtendFunction.getName();
			if (xtendFunction.isDispatch()) {
				expectedName = "_"+expectedName;
			}
			for (JvmOperation jvmOperation : jvmElements) {
				if (jvmOperation.getSimpleName().equals(expectedName)) {
					return jvmOperation;
				}
			}
			// The operation might have been renamed by an active annotation - return the primary JVM element
			Iterator<JvmOperation> iterator = jvmElements.iterator();
			if (iterator.hasNext())
				return iterator.next();
			return null;
		}
		
		@Override
		public JvmOperation getDispatchOperation(XtendFunction dispatchFunction) {
			if (!dispatchFunction.isDispatch())
				throw new IllegalArgumentException("Function " + dispatchFunction.getName() + " is not a dispatch function");
			Set<EObject> jvmElements = getJvmElements(dispatchFunction);
			for(EObject candidate: jvmElements) {
				if (candidate instanceof JvmOperation) {
					// other operation has '_' prefix
					if (dispatchFunction.getName().equals(((JvmOperation) candidate).getSimpleName())) {
						return (JvmOperation) candidate;
					}
				}
			}
			return null;
		}

		@Override
		public XtendClass getXtendClass(JvmGenericType jvmType) {
			final EObject primarySourceElement = getPrimarySourceElement(jvmType);
			if (primarySourceElement instanceof XtendClass) 
				return (XtendClass) primarySourceElement;
			return null;
		}
		
		@Override
		public AnonymousClass getAnonymousClass(JvmDeclaredType type) {
			final EObject primarySourceElement = getPrimarySourceElement(type);
			if (primarySourceElement instanceof AnonymousClass) 
				return (AnonymousClass) primarySourceElement;
			return null;
		}

		@Override
		public XtendInterface getXtendInterface(JvmGenericType jvmType) {
			final EObject primarySourceElement = getPrimarySourceElement(jvmType);
			if (primarySourceElement instanceof XtendInterface) 
				return (XtendInterface) primarySourceElement;
			return null;
		}

		@Override
		public XtendFunction getXtendFunction(JvmOperation jvmOperation) {
			return (XtendFunction) getPrimarySourceElement(jvmOperation);
		}

		@Override
		public XtendConstructor getXtendConstructor(JvmConstructor jvmConstructor) {
			EObject primarySourceElement = getPrimarySourceElement(jvmConstructor);
			return primarySourceElement instanceof XtendConstructor ? (XtendConstructor) primarySourceElement : null;
		}

		protected <T> T getFirstOrNull(Iterable<EObject> elements, Class<T> type) {
			Iterator<T> iterator = filter(elements, type).iterator();
			return iterator.hasNext() ? iterator.next() : null;
		}

		@Override
		public JvmField getJvmField(XtendField field) {
			return getFirstOrNull(getJvmElements(field), JvmField.class);
		}
		
		@Override
		public JvmField getJvmField(XtendEnumLiteral field) {
			return getFirstOrNull(getJvmElements(field), JvmField.class);
		}
		
		@Override
		public JvmFormalParameter getJvmParameter(XtendParameter parameter) {
			return getFirstOrNull(getJvmElements(parameter), JvmFormalParameter.class);
		}

		@Override
		public XtendField getXtendField(JvmField jvmField) {
			EObject primarySourceElement = getPrimarySourceElement(jvmField);
			if (primarySourceElement instanceof XtendField)
				return (XtendField) primarySourceElement;
			return null;
		}
		
		@Override
		protected JvmIdentifiableElement getLogicalContainer(EObject object, boolean considerContainer) {
			if (object == null) {
				return null;
			}
			final Map<EObject, JvmIdentifiableElement> mapping = getLogicalContainerMapping(object.eResource());
			do {
				if (mapping.containsKey(object)) {
					return mapping.get(object);
				}
				EObject container = object.eContainer();
				if (container == null) {
					return null;
				}
				if (object instanceof XtendMember) {
					if (container instanceof XtendMember) {
						XtendMember member = (XtendMember) container;
						if (member.getAnnotationInfo() != object) {
							return null;
						}
					} else if (!(object instanceof AnonymousClass)) {
						return null;
					}
				}
				if (!mapping.containsKey(container)) {
					Set<EObject> elements = getJvmElements(container);
					if (!elements.isEmpty()) {
						for (EObject eObject : elements) {
							if (eObject instanceof JvmIdentifiableElement) {
								return (JvmIdentifiableElement) eObject;
							}
						}
					}
				}
				object = container;
			} while (considerContainer);
			return null;
		}

	}
	
}
