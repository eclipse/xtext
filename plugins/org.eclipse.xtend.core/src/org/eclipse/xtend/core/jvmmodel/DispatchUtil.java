/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel;

import static com.google.common.collect.Iterables.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchUtil {
	
	public static class DispatchSignature {
		private final String simpleName;
		private final int parameterCount;
		
		public DispatchSignature(String simpleName, int parameterCount) {
			if (!simpleName.startsWith("_")) {
				throw new IllegalArgumentException("Dispatch signature is expected to start with an underscore");
			}
			this.simpleName = simpleName;
			this.parameterCount = parameterCount;
		}
		
		public int getParameterCount() {
			return parameterCount;
		}
		
		public String getSimpleName() {
			return simpleName.substring(1);
		}
		
		public boolean matches(JvmOperation operation) {
			return parameterCount == operation.getParameters().size() && simpleName.equals(operation.getSimpleName());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + parameterCount;
			result = prime * result + ((simpleName == null) ? 0 : simpleName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DispatchSignature other = (DispatchSignature) obj;
			if (parameterCount != other.parameterCount)
				return false;
			if (simpleName == null) {
				if (other.simpleName != null)
					return false;
			} else if (!simpleName.equals(other.simpleName))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("DispatchSignature [simpleName=");
			builder.append(simpleName);
			builder.append(", parameterCount=");
			builder.append(parameterCount);
			builder.append("]");
			return builder.toString();
		}
		
	}
	
	@Inject
	private IJvmModelAssociations associations;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private TypeReferences typeRefs;

	public boolean isDispatcherFunction(JvmOperation inferredOperation) {
		final Iterator<XtendFunction> filter = filter(associations.getSourceElements(inferredOperation), XtendFunction.class).iterator();
		if (!filter.hasNext())
			return false;
		XtendFunction xtendFunction = filter.next();
		return xtendFunction.isDispatch() && inferredOperation.getSimpleName().equals(xtendFunction.getName());
	}
	
	public boolean isDispatchFunction(JvmOperation inferredOperation) {
		if (inferredOperation.getSimpleName().startsWith("_")) {
			EObject sourceElement = associations.getPrimarySourceElement(inferredOperation);
			if (sourceElement instanceof XtendFunction) {
				XtendFunction function = (XtendFunction) sourceElement;
				if (function.isDispatch() && inferredOperation.getSimpleName().equals("_" + function.getName()))
					return true;
				return false;
			}
		}
		return false;
	}
	
//	protected boolean isDispatchOperation(JvmOperation operation, JvmGenericType contextType) {
//		if (visibilityService.isVisible(operation, contextType)) {
//			List<XtendFunction> sourceElements = newArrayList(filter(associations.getSourceElements(operation),
//					XtendFunction.class));
//			if (sourceElements.size() == 1) {
//				final XtendFunction xtendFunction = sourceElements.get(0);
//				return xtendFunction.isDispatch() && operation.getSimpleName().equals("_" + xtendFunction.getName());
//			}
//			return !operation.getParameters().isEmpty() && !operation.isStatic()
//					&& operation.getSimpleName().startsWith("_");
//		} else {
//			return false;
//		}
//	}
	
	@Nullable
	public JvmOperation getDispatcherOperation(JvmOperation dispatchCase) {
		EObject sourceElement = associations.getPrimarySourceElement(dispatchCase);
		if (sourceElement instanceof XtendFunction) {
			XtendFunction function = (XtendFunction) sourceElement;
			if (function.isDispatch()) {
				Iterable<JvmOperation> operations = filter(associations.getJvmElements(sourceElement), JvmOperation.class);
				for(JvmOperation operation: operations) {
					if (Strings.equal(operation.getSimpleName(), function.getName())) {
						return operation;
					}
				}
			}
		}
		return null;
	}
	
	@Nullable
	public JvmOperation getDispatcherOperation(JvmDeclaredType type, DispatchSignature signature) {
		Iterable<JvmFeature> allByName = type.findAllFeaturesByName(signature.getSimpleName());
		for(JvmFeature feature: allByName) {
			if (feature instanceof JvmOperation && signature.getParameterCount() == ((JvmOperation) feature).getParameters().size()) {
				return (JvmOperation) feature;
			}
		}
		return null;
	}
	
	/**
	 * Return the local cases that are associated with the given dispatch operation.
	 */
	public List<JvmOperation> getDispatchCases(JvmOperation dispatcherOperation) {
		Set<EObject> sourceElements = associations.getSourceElements(dispatcherOperation);
		List<JvmOperation> result = Lists.newArrayList();
		for(EObject sourceElement: sourceElements) {
			if (sourceElement instanceof XtendFunction) {
				XtendFunction function = (XtendFunction) sourceElement;
				if (Strings.equal(function.getName(), dispatcherOperation.getSimpleName())) {
					Set<EObject> jvmElements = associations.getJvmElements(function);
					for(EObject jvmElement: jvmElements) {
						if (jvmElement != dispatcherOperation && jvmElement instanceof JvmOperation) {
							JvmOperation candidate = (JvmOperation) jvmElement;
							if (Strings.equal(candidate.getSimpleName(), '_' + function.getName())) {
								result.add(candidate);
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public ListMultimap<DispatchSignature, JvmOperation> getDeclaredDispatchMethods(JvmDeclaredType type) {
		ListMultimap<DispatchSignature, JvmOperation> result = ArrayListMultimap.create();
		Iterable<JvmOperation> operations = type.getDeclaredOperations();
		for(JvmOperation operation: operations) {
			if (isDispatchFunction(operation)) {
				DispatchSignature signature = new DispatchSignature(operation.getSimpleName(), operation.getParameters().size());
				if (!result.containsKey(signature)) {
					List<JvmOperation> allOperations = Lists.newArrayListWithExpectedSize(5);
					Iterable<JvmFeature> allFeatures = type.findAllFeaturesByName(operation.getSimpleName());
					for(JvmFeature feature: allFeatures) {
						if (feature instanceof JvmOperation) {
							JvmOperation operationByName = (JvmOperation) feature;
							if (signature.matches(operationByName)) {
								allOperations.add(operationByName);
							}
						}
					}
					sort(allOperations);
					result.putAll(signature, allOperations);
				}
			}
		}
		return result;
	}

	protected void sort(List<JvmOperation> operations) {
		Collections.sort(operations, new Comparator<JvmOperation>() {
			public int compare(JvmOperation o1, JvmOperation o2) {
				return DispatchUtil.this.compare(o1, o2);
			}
		});
	}

	protected int compare(JvmOperation o1, JvmOperation o2) {
		int params = o1.getParameters().size();
		for (int i = 0; i < params; i++) {
			final JvmTypeReference p1 = o1.getParameters().get(i).getParameterType();
			final JvmTypeReference p2 = o2.getParameters().get(i).getParameterType();
			int distance1 = p1 == null ? Integer.MAX_VALUE : getMaxDistanceToObject(p1);
			int distance2 = p2 == null ? Integer.MAX_VALUE : getMaxDistanceToObject(p2);
			if (distance1 != distance2) {
				return distance2 - distance1;
			}
		}
		String identifier1 = o1.getIdentifier();
		String parameterTypes1 = identifier1.substring(identifier1.indexOf('('));
		String identifier2 = o2.getIdentifier();
		String parameterTypes2 = identifier2.substring(identifier2.indexOf('('));
		return parameterTypes1.compareTo(parameterTypes2);
	}

	protected int getMaxDistanceToObject(JvmTypeReference type) {
		type = primitives.asWrapperTypeIfPrimitive(type);
		if (typeRefs.is(type, Object.class))
			return 0;
		JvmType jvmType = type.getType();
		int maxDistance = 1;
		if (jvmType instanceof JvmDeclaredType) {
			EList<JvmTypeReference> list = ((JvmDeclaredType) jvmType).getSuperTypes();
			for (JvmTypeReference jvmTypeReference : list) {
				int result = 1 + getMaxDistanceToObject(jvmTypeReference);
				if (result > maxDistance)
					maxDistance = result;
			}
		}
		return maxDistance;
	}
}
