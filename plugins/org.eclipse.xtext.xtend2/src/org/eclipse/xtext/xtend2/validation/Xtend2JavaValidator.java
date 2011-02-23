/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.validation;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;
import static org.eclipse.xtext.util.Strings.*;
import static org.eclipse.xtext.xtend2.validation.IssueCodes.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.FeatureOverridesService;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typing.ITypeProvider;
import org.eclipse.xtext.xbase.validation.XbaseJavaValidator;
import org.eclipse.xtext.xtend2.dispatch.DispatchingSupport;
import org.eclipse.xtext.xtend2.linking.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.richstring.RichStringProcessor;
import org.eclipse.xtext.xtend2.xtend2.RichString;
import org.eclipse.xtext.xtend2.xtend2.RichStringElseIf;
import org.eclipse.xtext.xtend2.xtend2.RichStringForLoop;
import org.eclipse.xtext.xtend2.xtend2.RichStringIf;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.common.base.Predicate;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 */
@ComposedChecks(validators = { ClasspathBasedChecks.class })
public class Xtend2JavaValidator extends XbaseJavaValidator {

	@Inject
	private FeatureOverridesService featureOverridesService;

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private TypesFactory typesFactory;

	@Inject
	private TypeReferences typeRefs;

	@Inject
	private ITypeProvider typeProvider;

	@Inject
	private RichStringProcessor richStringProcessor;

	@Inject
	private TypeConformanceComputer conformanceComputer;

	@Inject
	private IXtend2JvmAssociations xtend2jvmAssociations;

	@Override
	protected List<EPackage> getEPackages() {
		return newArrayList(Xtend2Package.eINSTANCE, XbasePackage.eINSTANCE);
	}

	@Check
	public void checkWhitespaceInRichStrings(RichString richString) {
		// don't check the indentation of nested rich strings in 
		// IF and FOR individually
		if (richString.eContainer() instanceof RichStringIf) {
			RichStringIf container = (RichStringIf) richString.eContainer();
			if (container.getThen() == richString || container.getElse() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringElseIf) {
			RichStringElseIf container = (RichStringElseIf) richString.eContainer();
			if (container.getThen() == richString)
				return;
		}
		if (richString.eContainer() instanceof RichStringForLoop) {
			RichStringForLoop container = (RichStringForLoop) richString.eContainer();
			if (container.getEachExpression() == richString)
				return;
		}
		doCheckWhitespaceIn(richString);
	}

	protected void doCheckWhitespaceIn(RichString richString) {
		ValidatingRichStringAcceptor helper = new ValidatingRichStringAcceptor(this);
		richStringProcessor.process(richString, helper, helper);
	}

	@Check
	public void checkSuperTypes(XtendClass xtendClass) {
		JvmTypeReference superClass = xtendClass.getExtends();
		if (superClass != null && superClass.getType() != null) {
			if (!(superClass.getType() instanceof JvmGenericType)
					|| ((JvmGenericType) superClass.getType()).isInterface()) {
				error("Superclass must be a class", Xtend2Package.Literals.XTEND_CLASS__EXTENDS, CLASS_EXPECTED);
			}
		}
		for (int i = 0; i < xtendClass.getImplements().size(); ++i) {
			JvmTypeReference implementedType = xtendClass.getImplements().get(i);
			if (!(implementedType.getType() instanceof JvmGenericType)
					|| !((JvmGenericType) implementedType.getType()).isInterface()) {
				error("Implemented interface must be an interface", Xtend2Package.Literals.XTEND_CLASS__IMPLEMENTS, i,
						INTERFACE_EXPECTED);
			}
		}
	}

	@Check
	public void checkDuplicateAndOverridenFunctions(XtendClass xtendClass) {
		JvmParameterizedTypeReference typeReference = typesFactory.createJvmParameterizedTypeReference();
		final JvmGenericType inferredType = xtend2jvmAssociations.getInferredType(xtendClass);
		typeReference.setType(inferredType);
		TypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getReceiverContext(typeReference);
		Set<JvmOperation> checked = newHashSet();
		for (JvmOperation operation : inferredType.getDeclaredOperations()) {
			checked.add(operation);
			for (JvmOperation operation2 : inferredType.getDeclaredOperations()) {
				if (!checked.contains(operation2)) {
					if (featureOverridesService.isOverridden(operation, operation2, typeArgumentContext, false)) {
						XtendFunction func1 = xtend2jvmAssociations.getXtendFunction(operation);
						XtendFunction func2 = xtend2jvmAssociations.getXtendFunction(operation2);
						error("Duplicate method " + canonicalName(func1), func1,
								Xtend2Package.Literals.XTEND_MEMBER__NAME, DUPLICATE_METHOD);
						error("Duplicate method " + canonicalName(func2), func2,
								Xtend2Package.Literals.XTEND_MEMBER__NAME, DUPLICATE_METHOD);
					}
				}
			}
		}
	}

	@Check
	protected void checkFunctionOverride(XtendFunction function) {
		TypeArgumentContext typeArgumentContext = typeArgumentContextProvider.getReceiverContext(typeRefs
				.createTypeRef(associations.getDirectlyInferredOperation(function).getDeclaringType()));
		JvmOperation inferredJvmOperation = xtend2jvmAssociations.getDirectlyInferredOperation(function);
		boolean overriddenOperationFound = false;
		if (function.getDeclaringType().getExtends() != null) {
			JvmTypeReference returnType = typeProvider.getTypeForIdentifiable(inferredJvmOperation);
			JvmTypeReference returnTypeUpperBound = typeArgumentContext.getUpperBound(returnType, function);
			for (JvmFeature superFeature : featureOverridesService.getAllJvmFeatures(function.getDeclaringType()
					.getExtends())) {
				if (superFeature.getVisibility() != JvmVisibility.PRIVATE && superFeature instanceof JvmOperation) {
					JvmOperation superOperation = (JvmOperation) superFeature;
					if (featureOverridesService.isOverridden(inferredJvmOperation, superOperation, typeArgumentContext,
							false)) {
						overriddenOperationFound = true;
						if (!function.isOverride())
							error("Missing 'override'. Function overrides " + canonicalName(superOperation), function,
									Xtend2Package.Literals.XTEND_MEMBER__NAME, MISSING_OVERRIDE);
						JvmTypeReference superReturnTypeUpperBound = typeArgumentContext.getUpperBound(
								superOperation.getReturnType(), function);
						if (!conformanceComputer.isConformant(superReturnTypeUpperBound, returnTypeUpperBound)) {
							error("The return type is incompatible with "
									+ canonicalName(superOperation.getReturnType()) + " "
									+ canonicalName(superOperation), function,
									Xtend2Package.Literals.XTEND_FUNCTION__RETURN_TYPE, INCOMPATIBLE_RETURN_TYPE);
						}
					}
				}
			}
		}
		if (!overriddenOperationFound && function.isOverride()) {
			error("Function does not override any function", function, Xtend2Package.Literals.XTEND_FUNCTION__OVERRIDE,
					OBSOLETE_OVERRIDE);
		}
	}

	protected String canonicalName(JvmIdentifiableElement element) {
		return (element != null) ? notNull(element.getIdentifier()) : null;
	}

	@Check
	public void caseFuncWithoutParams(XtendFunction func) {
		if (func.isDispatch()) {
			if (func.getParameters().isEmpty()) {
				error("A dispatch function mus at least have one parameter declared.", func,
						Xtend2Package.Literals.XTEND_FUNCTION__DISPATCH, IssueCodes.CASE_FUNC_WITHOUT_PARAMS);
			}
		}
	}

	@Check
	public void caseFuncWithTypeParams(XtendFunction func) {
		if (func.isDispatch()) {
			if (!func.getTypeParameters().isEmpty()) {
				error("A dispatch function must not declare any type parameters.", func,
						Xtend2Package.Literals.XTEND_FUNCTION__DISPATCH, IssueCodes.CASE_FUNC_WITH_TYPE_PARAMS);
			}
		}
	}

	@Inject
	private DispatchingSupport dispatchingSupport;

	@Inject
	private IXtend2JvmAssociations associations;

	@Inject
	private Primitives primitives;

	@Check
	public void checkCaseFunctions(XtendClass clazz) {
		JvmGenericType type = associations.getInferredType(clazz);
		Multimap<Pair<String, Integer>, JvmOperation> dispatchMethods = dispatchingSupport.getDispatchMethods(type);
		for (Pair<String, Integer> key : dispatchMethods.keySet()) {
			Collection<JvmOperation> collection = dispatchMethods.get(key);
			if (collection.size() == 1) {
				JvmOperation singleOp = collection.iterator().next();
				XtendFunction function = associations.getXtendFunction(singleOp);
				warning("Single dispatch function.", function, Xtend2Package.Literals.XTEND_FUNCTION__DISPATCH,
						IssueCodes.SINGLE_CASE_FUNCTION);
			} else {
				Multimap<List<JvmType>, JvmOperation> signatures = HashMultimap.create();
				for (JvmOperation jvmOperation : collection) {
					signatures.put(getParamTypes(jvmOperation, true), jvmOperation);
				}
				for (final List<JvmType> paramTypes : signatures.keySet()) {
					Collection<JvmOperation> ops = signatures.get(paramTypes);
					if (ops.size() > 1) {
						if (Iterables.any(ops, new Predicate<JvmOperation>() {
							public boolean apply(JvmOperation input) {
								return !getParamTypes(input, false).equals(paramTypes);
							}
						})) {
							for (JvmOperation jvmOperation : ops) {
								XtendFunction function = associations.getXtendFunction(jvmOperation);
								error("Duplicate dispatch function. Primitives cannot overload their wrapper types in dispatch functions.",
										function, null, DUPLICATE_METHOD);
							}
						}
					}
				}
			}
		}
	}

	protected List<JvmType> getParamTypes(JvmOperation jvmOperation, boolean wrapPrimitives) {
		List<JvmType> types = newArrayList();
		for (JvmFormalParameter p : jvmOperation.getParameters()) {
			JvmTypeReference reference = wrapPrimitives ? primitives.asWrapperTypeIfPrimitive(p.getParameterType()) : p
					.getParameterType();
			types.add(reference.getType());
		}
		return types;
	}

}
