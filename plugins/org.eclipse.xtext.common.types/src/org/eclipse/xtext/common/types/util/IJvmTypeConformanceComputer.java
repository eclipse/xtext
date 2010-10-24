/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.typing.ITypeConformanceComputer;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.internal.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IJvmTypeConformanceComputer.Impl.class)
public interface IJvmTypeConformanceComputer extends ITypeConformanceComputer<JvmTypeReference> {

	/**
	 * @return the common super type of the passed {@link JvmTypeReference}s
	 */
	public JvmTypeReference getCommonSuperType(final List<JvmTypeReference> types);
	
	public class Impl implements IJvmTypeConformanceComputer{

		private SuperTypeCollector superTypeCollector;

		@Inject
		public Impl(SuperTypeCollector superTypeCollector) {
			super();
			this.superTypeCollector = superTypeCollector;
		}

		public boolean isConformant(JvmTypeReference left, JvmTypeReference right) {
			JvmType typeA = left.getType();
			JvmType typeB = right.getType();
			if (typeA instanceof JvmArrayType) {
				if (typeB instanceof JvmArrayType) {
					JvmTypeReference componentTypeA = ((JvmArrayType) typeA).getComponentType();
					JvmTypeReference componentTypeB = ((JvmArrayType) typeB).getComponentType();
					return isConformant(componentTypeA, componentTypeB);
				}
				return false;
			} else if (right instanceof JvmParameterizedTypeReference) {
				JvmParameterizedTypeReference refA = (JvmParameterizedTypeReference) left;
				JvmParameterizedTypeReference refB = (JvmParameterizedTypeReference) right;
				if (typeA == typeB) {
					return areArgumentsAssignableFrom(refA, refB);
				}
				if (typeA instanceof JvmPrimitiveType) {
					return isUnBoxing(typeA, typeB);
				} else if (typeA instanceof JvmDeclaredType) {
					if (superTypeCollector.collectSuperTypesAsRawTypes(right).contains(typeA)) {
						return areArgumentsAssignableFrom(refA, refB);
					}
					return isBoxing(typeA, typeB);
				} else if (typeA instanceof JvmTypeParameter) {
					EList<JvmTypeConstraint> list = ((JvmTypeParameter) typeA).getConstraints();
					for (JvmTypeConstraint jvmTypeConstraint : list) {
						if (jvmTypeConstraint instanceof JvmUpperBound) {
							JvmTypeReference typeReference = jvmTypeConstraint.getTypeReference();
							if (isConformant(typeReference, right))
								return true;
						}
					}
					return list.isEmpty();
				}
			}
			return false;
		}

		protected boolean areArgumentsAssignableFrom(JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
			// raw type
			if (left.getArguments().size() == 0 || right.getArguments().size() == 0) {
				return true;
			}
			if (left.getArguments().size() != right.getArguments().size()) {
				return false;
			}

			if (left.getArguments().size() == right.getArguments().size()) {
				for (int i = 0; i < left.getArguments().size(); i++) {
					JvmTypeReference argumentA = left.getArguments().get(i);
					JvmTypeReference argumentB = right.getArguments().get(i);
					if (!isAssignable(argumentA, argumentB))
						return false;
				}
				return true;
			}
			return false;
		}

		protected boolean isAssignable(JvmTypeReference refA, JvmTypeReference refB) {
			JvmTypeReference upperA = getUpper(refA);
			JvmTypeReference upperB = getUpper(refB);
			JvmTypeReference lowerA = getLower(refA);
			JvmTypeReference lowerB = getLower(refB);
			if (isUnconstraintWildcard(refA)) {
				return true;
			}
			if (upperA != null) {
				if (upperB != null) {
					return isConformant(upperA, upperB);
				} else if (!(refB instanceof JvmWildcardTypeReference)) {
					return isConformant(upperA, refB);
				}
			} else if (!(refA instanceof JvmWildcardTypeReference)) {
				if (!(refB instanceof JvmWildcardTypeReference)) {
					return isConformant(refA, refB);
				}
			} else if (lowerA != null) {
				if (lowerB != null && isConformant(lowerB, lowerA)) {
					return true;
				}
			}
			return false;
		}

		protected boolean isUnconstraintWildcard(JvmTypeReference argumentA) {
			return argumentA instanceof JvmWildcardTypeReference
					&& ((JvmWildcardTypeReference) argumentA).getConstraints().isEmpty();
		}

		protected JvmTypeReference getLower(JvmTypeReference argumentA) {
			if (argumentA instanceof JvmWildcardTypeReference) {
				EList<JvmTypeConstraint> list = ((JvmWildcardTypeReference) argumentA).getConstraints();
				for (JvmTypeConstraint constraint : list) {
					if (constraint instanceof JvmLowerBound) {
						return constraint.getTypeReference();
					}
				}
			}
			return null;
		}

		protected JvmTypeReference getUpper(JvmTypeReference argumentA) {
			if (argumentA instanceof JvmWildcardTypeReference) {
				EList<JvmTypeConstraint> list = ((JvmWildcardTypeReference) argumentA).getConstraints();
				for (JvmTypeConstraint constraint : list) {
					if (constraint instanceof JvmUpperBound) {
						return constraint.getTypeReference();
					}
				}
			}
			return null;
		}

		protected boolean isBoxing(JvmType typeA, JvmType typeB) {
			return is(typeA, Integer.class) && is(typeB, Integer.TYPE) || is(typeA, Boolean.class)
					&& is(typeB, Boolean.TYPE) || is(typeA, Long.class) && is(typeB, Long.TYPE) || is(typeA, Float.class)
					&& is(typeB, Float.TYPE) || is(typeA, Double.class) && is(typeB, Double.TYPE) || is(typeA, Byte.class)
					&& is(typeB, Byte.TYPE);
		}

		protected boolean isUnBoxing(JvmType typeA, JvmType typeB) {
			return is(typeB, Integer.class) && is(typeA, Integer.TYPE) || is(typeB, Boolean.class)
					&& is(typeA, Boolean.TYPE) || is(typeB, Long.class) && is(typeA, Long.TYPE) || is(typeB, Float.class)
					&& is(typeA, Float.TYPE) || is(typeB, Double.class) && is(typeA, Double.TYPE) || is(typeB, Byte.class)
					&& is(typeA, Byte.TYPE);
		}

		protected boolean is(JvmType typeA, Class<?> class1) {
			return typeA.getCanonicalName().equals(class1.getCanonicalName());
		}

		public String getName(JvmTypeReference actual) {
			return actual.getCanonicalName();
		}
		
		public JvmTypeReference getCommonSuperType(final List<JvmTypeReference> types) {
			if (types==null || types.isEmpty())
				throw new IllegalArgumentException("Types can't be null or empty "+types);
			
			JvmTypeReference firstType = types.get(0);
			if (conformsToAll(firstType, types))
				return firstType;
			
			List<JvmTypeReference> refs = Lists.newArrayList(this.superTypeCollector.collectSuperTypes(firstType));
			Collections.sort(refs,new Comparator<JvmTypeReference>() {
				public int compare(JvmTypeReference o1, JvmTypeReference o2) {
					if (isConformant(o1, o2))
						return -1;
					return o1.getCanonicalName().compareTo(o2.getCanonicalName());
				}
			});
			for (JvmTypeReference jvmTypeReference : refs) {
				if (conformsToAll(jvmTypeReference, types))
					return jvmTypeReference;
			}
			throw new IllegalStateException("There should always be one common super type (i.e. java.lang.Object)");
		}

		protected boolean conformsToAll(JvmTypeReference type, final List<JvmTypeReference> types) {
			boolean conform = true;
			for (int i = 1; conform && i < types.size(); i++) {
				conform = isConformant(type, types.get(i));
			}
			return conform;
		}

	}
}
