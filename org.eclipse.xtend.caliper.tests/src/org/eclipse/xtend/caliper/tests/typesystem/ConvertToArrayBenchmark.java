/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.caliper.tests.typesystem;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;
import com.google.inject.Injector;

// Mind the time units! (us vs ns)

//0% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=OBJECT} 3547.51 ns; ?=61.60 ns @ 10 trials
//7% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=CLONEABLE} 3557.88 ns; ?=66.66 ns @ 10 trials
//14% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=INT} 7492.81 ns; ?=169.02 ns @ 10 trials
//21% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=BOOLEAN} 4665.04 ns; ?=99.55 ns @ 10 trials
//29% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=STRING} 4665.21 ns; ?=31.43 ns @ 3 trials
//36% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=RAW_COMPARABLE} 4637.73 ns; ?=14.88 ns @ 3 trials
//43% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=RAW_MAP} 4012.58 ns; ?=83.02 ns @ 10 trials
//50% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=RAW_ITERABLE} 2412.41 ns; ?=53.03 ns @ 10 trials
//57% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=RAW_ARRAYLIST} 7557.90 ns; ?=221.96 ns @ 10 trials
//64% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=ITERABLE} 3702.97 ns; ?=91.72 ns @ 10 trials
//71% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=ARRAYLIST} 19959.19 ns; ?=359.83 ns @ 10 trials
//79% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 5567.97 ns; ?=157.17 ns @ 10 trials
//86% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=RAW_ELIST_SUBTYPE} 7989.58 ns; ?=21.52 ns @ 3 trials
//93% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=CURRENT, type=ELIST_SUBTYPE} 30330.20 ns; ?=78.39 ns @ 3 trials
//
//                           type    us linear runtime
//                         OBJECT  3.55 ===
//                      CLONEABLE  3.56 ===
//                            INT  7.49 =======
//                        BOOLEAN  4.67 ====
//                         STRING  4.67 ====
//                 RAW_COMPARABLE  4.64 ====
//                        RAW_MAP  4.01 ===
//                   RAW_ITERABLE  2.41 ==
//                  RAW_ARRAYLIST  7.56 =======
//                       ITERABLE  3.70 ===
//                      ARRAYLIST 19.96 ===================
//XMEMBER_FEATURE_CALL_IMPL_CUSTOM  5.57 =====
//              RAW_ELIST_SUBTYPE  7.99 =======
//                  ELIST_SUBTYPE 30.33 ==============================

//0% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=OBJECT} 1731.87 ns; ?=4.57 ns @ 3 trials
//7% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=CLONEABLE} 1653.16 ns; ?=30.01 ns @ 10 trials
//14% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=INT} 6.44 ns; ?=0.02 ns @ 3 trials
//21% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=BOOLEAN} 2253.28 ns; ?=16.15 ns @ 3 trials
//29% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=STRING} 2054.01 ns; ?=4.68 ns @ 3 trials
//36% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=RAW_COMPARABLE} 1521.44 ns; ?=19.46 ns @ 10 trials
//43% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=RAW_MAP} 1788.30 ns; ?=13.56 ns @ 3 trials
//50% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=RAW_ITERABLE} 550.47 ns; ?=5.37 ns @ 9 trials
//57% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=RAW_ARRAYLIST} 5377.83 ns; ?=36.58 ns @ 3 trials
//64% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=ITERABLE} 47.24 ns; ?=0.74 ns @ 10 trials
//71% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=ARRAYLIST} 9547.47 ns; ?=91.66 ns @ 3 trials
//79% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=XMEMBER_FEATURE_CALL_IMPL_CUSTOM} 3604.56 ns; ?=71.85 ns @ 10 trials
//86% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=RAW_ELIST_SUBTYPE} 6246.89 ns; ?=144.59 ns @ 10 trials
//93% Scenario{vm=java7, trial=0, benchmark=TryConvertToArray, implementation=REWRITTEN, type=ELIST_SUBTYPE} 17517.62 ns; ?=321.90 ns @ 10 trials
//
//                           type       ns linear runtime
//                         OBJECT  1731.87 ==
//                      CLONEABLE  1653.16 ==
//                            INT     6.44 =
//                        BOOLEAN  2253.28 ===
//                         STRING  2054.01 ===
//                 RAW_COMPARABLE  1521.44 ==
//                        RAW_MAP  1788.30 ===
//                   RAW_ITERABLE   550.47 =
//                  RAW_ARRAYLIST  5377.83 =========
//                       ITERABLE    47.24 =
//                      ARRAYLIST  9547.47 ================
//XMEMBER_FEATURE_CALL_IMPL_CUSTOM  3604.56 ======
//              RAW_ELIST_SUBTYPE  6246.89 ==========
//                  ELIST_SUBTYPE 17517.62 ==============================

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConvertToArrayBenchmark extends SimpleBenchmark {

	private IndexedJvmTypeAccess indexedAccess = new IndexedJvmTypeAccess() {
		@Override
		public EObject getIndexedJvmType(QualifiedName qualifiedName, String fragment, ResourceSet resourceSet) {
			return null;
		}

		@Override
		public EObject getIndexedJvmType(URI javaObjectURI, ResourceSet resourceSet) {
			return null;
		}
	};

	public enum Impl {
		CURRENT {
			@Override
			LightweightTypeReference tryConvertToArray(ParameterizedTypeReference typeReference) {
				if (typeReference.isSubtypeOf(Iterable.class)) {
					DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
					Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> parameterMapping = collector.getTypeParameterMapping(typeReference);
					JvmType iterableType = typeReference.getOwner().getServices().getTypeReferences().findDeclaredType(Iterable.class, typeReference.getOwner().getContextResourceSet());
					if (iterableType instanceof JvmTypeParameterDeclarator) {
						JvmTypeParameter typeParameter = ((JvmTypeParameterDeclarator) iterableType).getTypeParameters().get(0);
						UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(parameterMapping, typeReference.getOwner());
						ParameterizedTypeReference unboundTypeParameter = typeReference.getOwner().newParameterizedTypeReference(typeParameter);
						LightweightTypeReference componentType = substitutor.substitute(unboundTypeParameter).getUpperBoundSubstitute();
						if (componentType.isAny())
							return null;
						ArrayTypeReference array = typeReference.getOwner().newArrayTypeReference(componentType);
						return array;
					}
				}
				return null;
			}
		},
		REWRITTEN {
			@Override
			LightweightTypeReference tryConvertToArray(ParameterizedTypeReference typeReference) {
				return typeReference.tryConvertToArray();
			}
		},
		;
		abstract LightweightTypeReference tryConvertToArray(ParameterizedTypeReference typeReference);
	}

	public enum Type {
		OBJECT {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Object");
				return owner.newParameterizedTypeReference(type);
			}
		},
		CLONEABLE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Cloneable");
				return owner.newParameterizedTypeReference(type);
			}
		},
		INT {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("int");
				return owner.newParameterizedTypeReference(type);
			}
		},
		BOOLEAN {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Boolean");
				return owner.newParameterizedTypeReference(type);
			}
		},
		STRING {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.String");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_COMPARABLE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Comparable");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_MAP {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.util.Map");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_ITERABLE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Iterable");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_ARRAYLIST {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.util.ArrayList");
				return owner.newParameterizedTypeReference(type);
			}
		},
		ITERABLE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.lang.Iterable");
				ParameterizedTypeReference result = owner.newParameterizedTypeReference(type);
				result.addTypeArgument(STRING.getReference(typeProvider, owner));
				return result;
			}
		},
		ARRAYLIST {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("java.util.ArrayList");
				ParameterizedTypeReference result = owner.newParameterizedTypeReference(type);
				result.addTypeArgument(STRING.getReference(typeProvider, owner));
				return result;
			}
		},
		XMEMBER_FEATURE_CALL_IMPL_CUSTOM {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("org.eclipse.xtext.xbase.impl.XMemberFeatureCallImplCustom");
				return owner.newParameterizedTypeReference(type);
			}
		},
		RAW_ELIST_SUBTYPE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("org.eclipse.emf.ecore.util.EcoreEMap$Unsettable$UnsettableDelegateEObjectContainmentWithInverseEList");
				return owner.newParameterizedTypeReference(type);
			}
		},
		ELIST_SUBTYPE {
			@Override
			ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner) {
				JvmType type = typeProvider.findTypeByName("org.eclipse.emf.ecore.util.EcoreEMap$Unsettable$UnsettableDelegateEObjectContainmentWithInverseEList");
				ParameterizedTypeReference result = owner.newParameterizedTypeReference(type);
				result.addTypeArgument(STRING.getReference(typeProvider, owner));
				return result;
			}
		},
		;
		abstract ParameterizedTypeReference getReference(IJvmTypeProvider typeProvider, ITypeReferenceOwner owner);
	}

	@Param
	private Impl implementation;

	@Param
	private Type type;

	private ParameterizedTypeReference typeReference;

	@Override
	protected void setUp() throws Exception {
		Injector injector = new XbaseStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = new XtextResourceSet();
		ClassLoader loader = getClass().getClassLoader();
		resourceSet.setClasspathURIContext(loader);
		ClasspathTypeProvider typeProvider = new ClasspathTypeProvider(loader, resourceSet, indexedAccess, null);
		CommonTypeComputationServices services = injector.getInstance(CommonTypeComputationServices.class);
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resourceSet);
		typeReference = type.getReference(typeProvider, owner);
		EcoreUtil.resolveAll(resourceSet);
	}

	public int timeTryConvertToArray(int reps) {
		int result = 0;
		for (int i = 0; i < reps; i++) {
			if (implementation.tryConvertToArray(typeReference) != null) {
				result += i;
			} else {
				result -= i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Runner.main(ConvertToArrayBenchmark.class, args);
	}

}