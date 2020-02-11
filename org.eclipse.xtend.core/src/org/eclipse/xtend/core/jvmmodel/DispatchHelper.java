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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.Multimaps2;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/*
 * TODO In case we deal with a Java class: should we check for an associated
 * dispatcher?
 */
/**
 * Helpers to deal with {@link XtendFunction#isDispatch() dispatch methods}.
 * Methods are considered to be dispatch methods, if they 
 * are derived from an {@link XtendFunction} that is marked as such
 * or if they are defined in a Java type and their name starts with an
 * underscore.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DispatchHelper {
	
	/**
	 * A dispatch signature is a pair of a simple name
	 * and an arity. In that sense it's different from a common understanding
	 * of a method signature, since the dispatch signature does not take
	 * the parameter types into account but only the number of parameters.
	 */
	public static class DispatchSignature {
		private final String simpleName;
		private final int arity;
		
		/**
		 * Creates a new {@link DispatchSignature} from a method name and parameter count.
		 * The method name may not include the synthesized underscore even though an explicit underscore is ok.
		 * @param simpleName the simple name of the associated dispatcher function.
		 * @param arity the number of parameters (zero or more)
		 */
		public DispatchSignature(String simpleName, int arity) {
			if (arity < 0) {
				throw new IllegalArgumentException("The number of parameters may not be smaller than zero, was: " + arity);
			}
			this.simpleName = "_" + simpleName;
			this.arity = arity;
		}
		
		/**
		 * Returns the number of parameters for this dispatch signature.
		 */
		public int getArity() {
			return arity;
		}
		
		/**
		 * Returns the name of the dispatcher method. That is, the name without a synthetic underscore.
		 */
		public String getSimpleName() {
			return simpleName.substring(1);
		}
		
		/**
		 * Returns the name of the dispatch cases as they would be compiled to Java. The name includes the
		 * synthetic underscore.
		 */
		public String getDispatchCaseName() {
			return simpleName;
		}
		
		/**
		 * Returns true, if the given operation matches this dispatch signature and is therefore a case
		 * for this dispatcher.
		 */
		public boolean isDispatchCase(JvmOperation operation) {
			return arity == operation.getParameters().size() && simpleName.equals(operation.getSimpleName());
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + arity;
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
			if (arity != other.arity)
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
			builder.append(", arity=");
			builder.append(arity);
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
	
	@Inject
	private IVisibilityHelper visibilityHelper;
	
	@Inject
	private CommonTypeComputationServices services;
	
	private static class DispatcherMarker extends AdapterImpl { }
	
	public void markAsDispatcherFunction(JvmOperation inferredOperation) {
		inferredOperation.eAdapters().add(new DispatcherMarker());
	}
	
	public boolean isDispatcherFunction(JvmOperation inferredOperation) {
		return Iterables.any(inferredOperation.eAdapters(), new Predicate<Object>() {
			@Override
			public boolean apply(Object input) {
				return input instanceof DispatcherMarker;
			}
		});
	}
	
	public boolean isDispatchFunction(JvmOperation inferredOperation) {
		if (inferredOperation.getSimpleName() != null && inferredOperation.getSimpleName().startsWith("_")) {
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
	
	/* @Nullable */
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
		} else {
			DispatchSignature signature = new DispatchSignature(dispatchCase.getSimpleName().substring(1), dispatchCase.getParameters().size());
			JvmOperation result = getDispatcherOperation(dispatchCase.getDeclaringType(), signature);
			return result;
		}
		return null;
	}
	
	/* @Nullable */
	public JvmOperation getDispatcherOperation(JvmDeclaredType type, DispatchSignature signature) {
		Iterable<JvmFeature> allByName = type.findAllFeaturesByName(signature.getSimpleName());
		for(JvmFeature feature: allByName) {
			if (feature instanceof JvmOperation && signature.getArity() == ((JvmOperation) feature).getParameters().size()) {
				return (JvmOperation) feature;
			}
		}
		return null;
	}
	
	/**
	 * Return the local cases that match the given signature (in no particular order, usually as defined in the file).
	 */
	public List<JvmOperation> getLocalDispatchCases(JvmDeclaredType type, DispatchSignature signature) {
		List<JvmOperation> result = Lists.newArrayListWithExpectedSize(5);
		for(JvmMember feature: type.getMembers()) {
			if (feature instanceof JvmOperation && signature.isDispatchCase((JvmOperation) feature)) {
				result.add((JvmOperation) feature);
			}
		}
		return result;
	}
	
	/**
	 * Return the local cases that contribute to the given dispatch operation (in no particular order, but usually as defined in the file).
	 */
	public List<JvmOperation> getLocalDispatchCases(JvmOperation dispatcherOperation) {
		DispatchSignature dispatchSignature = new DispatchSignature(dispatcherOperation.getSimpleName(), dispatcherOperation.getParameters().size());
		JvmDeclaredType type = dispatcherOperation.getDeclaringType();
		return getLocalDispatchCases(type, dispatchSignature);
	}
	
	/**
	 * Return all the cases that are associated with the given dispatch operation.
	 */
	public List<JvmOperation> getAllDispatchCases(JvmOperation dispatcherOperation) {
		DispatchSignature dispatchSignature = new DispatchSignature(dispatcherOperation.getSimpleName(), dispatcherOperation.getParameters().size());
		JvmDeclaredType type = dispatcherOperation.getDeclaringType();
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, type);
		ContextualVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(visibilityHelper, owner.newParameterizedTypeReference(type));
		return getAllDispatchMethods(dispatchSignature, type, contextualVisibilityHelper);
	}
	
	/**
	 * Computes all the dispatch methods that are declared in the given type or altered
	 * by additional cases in this type. The associated operations are sorted by according their parameter types
	 * from left to right where the most special types occur before more common types. Ambiguous
	 * ordering is resolved alphabetically.
	 * 
     * An exemplary order would look like this
	 * <pre>
	 *   method(String)
	 *   method(Serializable)
	 *   method(CharSequence)
	 *   method(Object)
	 * </pre>
	 * 
	 * @return a mapping from {@link DispatchSignature signature} to sorted operations.
	 */
	public ListMultimap<DispatchSignature, JvmOperation> getDeclaredOrEnhancedDispatchMethods(JvmDeclaredType type) {
		ListMultimap<DispatchSignature, JvmOperation> result = Multimaps2.newLinkedHashListMultimap(2,4);
		Iterable<JvmOperation> operations = type.getDeclaredOperations();
		ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, type);
		ContextualVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(visibilityHelper, owner.newParameterizedTypeReference(type));
		for(JvmOperation operation: operations) {
			if (isDispatchFunction(operation)) {
				DispatchSignature signature = new DispatchSignature(operation.getSimpleName().substring(1), operation.getParameters().size());
				if (!result.containsKey(signature)) {
					List<JvmOperation> allOperations = getAllDispatchMethods(signature, type,
							contextualVisibilityHelper);
					result.putAll(signature, allOperations);
				}
			}
		}
		return result;
	}

	protected List<JvmOperation> getAllDispatchMethods(DispatchSignature signature, JvmDeclaredType type,
			ContextualVisibilityHelper contextualVisibilityHelper) {
		List<JvmOperation> allOperations = Lists.newArrayListWithExpectedSize(5);
		Iterable<JvmFeature> allFeatures = type.findAllFeaturesByName(signature.getDispatchCaseName());
		for(JvmFeature feature: allFeatures) {
			if (feature instanceof JvmOperation) {
				JvmOperation operationByName = (JvmOperation) feature;
				if (signature.isDispatchCase(operationByName) && contextualVisibilityHelper.isVisible(operationByName)) {
					allOperations.add(operationByName);
				}
			}
		}
		sort(allOperations);
		return allOperations;
	}

	protected void sort(List<JvmOperation> operations) {
		Collections.sort(operations, new Comparator<JvmOperation>() {
			@Override
			public int compare(JvmOperation o1, JvmOperation o2) {
				return DispatchHelper.this.compare(o1, o2);
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
