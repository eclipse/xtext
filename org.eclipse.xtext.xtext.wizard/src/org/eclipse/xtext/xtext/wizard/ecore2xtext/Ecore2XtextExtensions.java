/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard.ecore2xtext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Ecore2XtextExtensions {
	public static Iterable<EClassifier> allConcreteRuleClassifiers(Ecore2XtextConfiguration it) {
		if (it.getRootElementClass() == null) {
			return Iterables.filter(
					IterableExtensions.toSet(Iterables.concat(Iterables.transform(it.getEPackageInfos(),
							(EPackageInfo p) -> allReferencedClassifiers(p.getEPackage(), false)))),
					(EClassifier c) -> needsConcreteRule(c));
		} else {
			ArrayList<EClassifier> c = Lists.newArrayList(EClassifier.class.cast(it.getRootElementClass()));
			allAssignedClassifiers(it.getRootElementClass(), c);
			return IterableExtensions.toSet(Iterables.filter(c, (EClassifier cl) -> needsConcreteRule(cl)));
		}
	}

	public static Collection<EClass> allDispatcherRuleClasses(Ecore2XtextConfiguration it) {
		if (it.getRootElementClass() == null) {
			return IterableExtensions.toSet(Iterables.filter(Iterables.filter(
					IterableExtensions.toSet(Iterables.concat(Iterables.transform(it.getEPackageInfos(),
							(EPackageInfo p) -> allReferencedClassifiers(p.getEPackage(), false)))),
					(EClassifier c) -> needsDispatcherRule(c)), EClass.class));
		} else {
			Function<EClass, ? extends Iterable<EClassifier>> toTypes = (EClass c) -> Iterables.transform(
					Iterables.filter(c.getEAllReferences(), (EReference r) -> needsAssignment(r)),
					EReference::getEType);
			return IterableExtensions
					.toSet(Iterables.filter(
							Iterables.concat(Iterables.transform(
									Iterables.filter(allConcreteRuleClassifiers(it), EClass.class), toTypes)),
							EClass.class));
		}
	}

	public static Collection<EPackage> allReferencedEPackages(Ecore2XtextConfiguration prjInfo) {
		return IterableExtensions.toSet(Iterables.concat(Iterables.transform(prjInfo.getEPackageInfos(),
				(EPackageInfo it) -> allReferencedEPackages(it.getEPackage(), true))));
	}

	public static Set<EPackage> allReferencedEPackages(EPackage ePack, boolean includeCrossRefs) {
		return IterableExtensions.toSet(IterableExtensions.filterNull(
				Iterables.transform(allReferencedClassifiers(ePack, includeCrossRefs), EClassifier::getEPackage)));
	}

	public static Set<EClassifier> allReferencedClassifiers(EPackage ePack, boolean includeCrossRefs) {
		Iterable<Iterable<EStructuralFeature>> strFeatures = Iterables
				.transform(Iterables.filter(ePack.getEClassifiers(), EClass.class), (EClass it) -> {
					return Iterables.filter(it.getEAllStructuralFeatures(),
							(EStructuralFeature f) -> needsAssignment(f) && (includeCrossRefs || isContainment(f)));
				});
		Set<EClassifier> refTypes = IterableExtensions
				.toSet(Iterables.transform(Iterables.concat(strFeatures), (EStructuralFeature it) -> it.getEType()));
		Set<EClassifier> retVal = IterableExtensions.toSet(Iterables.concat(ePack.getEClassifiers(), refTypes));
		retVal.add(UniqueNameUtil.eString());
		return retVal;
	}

	private static void allAssignedClassifiers(EClass eClazz, Collection<EClassifier> acceptor) {
		List<EClassifier> classifiers = IterableExtensions.toList(Iterables.transform(
				Iterables.filter(eClazz.getEAllStructuralFeatures(), (EStructuralFeature f) -> needsAssignment(f)),
				(EStructuralFeature it) -> it.getEType()));
		Iterables.addAll(classifiers, subClasses(eClazz));
		classifiers.removeAll(acceptor);
		if (classifiers.isEmpty()) {
			return;
		} else {
			Iterables.addAll(acceptor, classifiers);
			Iterables.filter(classifiers, EClass.class).forEach((EClass c) -> allAssignedClassifiers(c, acceptor));
		}
	}

	public static String fqn(EClassifier it) {
		EPackage ePackage = it.getEPackage();
		String uniqueName = null;
		if (ePackage != null) {
			uniqueName = UniqueNameUtil.uniqueName(ePackage);
		}
		if (uniqueName == null) {
			return quoteIfNeccesary(it.getName());
		} else {
			return UniqueNameUtil.uniqueName(it.getEPackage()) + "::" + quoteIfNeccesary(it.getName());
		}
	}

	public static Iterable<EStructuralFeature> prefixFeatures(EClass it) {
		return Iterables.filter(it.getEAllStructuralFeatures(),
				(EStructuralFeature f) -> needsAssignment(f) && isPrefixBooleanFeature(f));
	}

	public static Iterable<EStructuralFeature> inlinedFeatures(EClass it) {
		List<EStructuralFeature> features = IterableExtensions
				.toList(Iterables.filter(it.getEAllStructuralFeatures(), (EStructuralFeature f) -> needsAssignment(f)));
		features.remove(idAttribute(it));
		features.removeAll(IterableExtensions.toList(prefixFeatures(it)));
		return features;
	}

	public static boolean onlyOptionalFeatures(EClass it) {
		Iterable<EStructuralFeature> features = Iterables.concat(prefixFeatures(it), inlinedFeatures(it));
		return Iterables.isEmpty(Iterables.filter(features, (EStructuralFeature f) -> f.isRequired()));
	}

	public static String assignedRuleCall(EAttribute it) {
		if (isPrefixBooleanFeature(it)) {
			return "'" + it.getName() + "'";
		} else {
			return UniqueNameUtil.uniqueName(it.getEType());
		}
	}

	public static String concreteRuleName(EClass it) {
		if (needsDispatcherRule(it)) {
			return UniqueNameUtil.uniqueImplName(it);
		} else {
			return UniqueNameUtil.uniqueName(it);
		}
	}

	public static String dataTypeRuleBody(EDataType it) {
		String name = it.getName();
		if (name != null) {
			switch (name) {
			case "EBigDecimal":
				return "INT? '.' INT";
			case "EBigInteger":
				return intRuleBody();
			case "EBoolean":
				return booleanRuleBody();
			case "EBooleanObject":
				return booleanRuleBody();
			case "EByte":
				return intRuleBody();
			case "EByteObject":
				return intRuleBody();
			case "EChar":
				return intRuleBody();
			case "ECharObject":
				return intRuleBody();
			case "EDouble":
				return decimalRuleBody();
			case "EDoubleObject":
				return decimalRuleBody();
			case "EFloat":
				return decimalRuleBody();
			case "EFloatObject":
				return decimalRuleBody();
			case "EInt":
				return intRuleBody();
			case "EIntegerObject":
				return intRuleBody();
			case "ELong":
				return intRuleBody();
			case "ELongObject":
				return intRuleBody();
			case "EShort":
				return intRuleBody();
			case "EShortObject":
				return intRuleBody();
			case "EString":
				return "STRING | ID";
			default:
				return "'" + it.getName() + "' /* TODO: implement this rule and an appropriate IValueConverter */";
			}
		} else {
			return "'" + it.getName() + "' /* TODO: implement this rule and an appropriate IValueConverter */";
		}
	}

	public static String intRuleBody() {
		return "'-'? INT";
	}

	public static String decimalRuleBody() {
		return "'-'? INT? '.' INT (('E'|'e') '-'? INT)?";
	}

	public static String booleanRuleBody() {
		return "'true' | 'false'";
	}

	public static String assignmentKeyword(EStructuralFeature it) {
		if (isPrefixBooleanFeature(it)) {
			return "";
		} else {
			return "'" + it.getName() + "' ";
		}
	}

	public static String quoteIfNeccesary(String str) {
		if (isXtextKeyword(str)) {
			return "^" + str;
		} else {
			return str;
		}
	}

	public static boolean isXtextKeyword(String str) {
		return Lists.newArrayList("returns", "generate", "terminal", "with", "hidden", "enum", "grammar", "import",
				"as", "current", "fragment", "EOF").contains(str);
	}

	public static EAttribute idAttribute(EClass it) {
		EAttribute idAttr = idAttributeInternal(it);
		if (idAttr != null) {
			return idAttr;
		} else {
			return IterableExtensions.findFirst(it.getEAllAttributes(), (EAttribute a) -> needsAssignment(a)
					&& "name".equals(a.getName()) && "EString".equals(a.getEType().getName()) && !a.isMany());
		}
	}

	private static EAttribute idAttributeInternal(EClass it) {
		return IterableExtensions.findFirst(it.getEAllAttributes(), (EAttribute a) -> needsAssignment(a) && a.isID());
	}

	public static boolean isBoolean(EClassifier it) {
		return it instanceof EDataType && Lists.newArrayList("EBoolean", "EBooleanObject").contains(it.getName())
				&& isEcoreType(it);
	}

	public static boolean isPrefixBooleanFeature(EStructuralFeature it) {
		return isBoolean(it.getEType()) && !it.isMany() && !Objects.equal(it.getDefaultValueLiteral(), "true");
	}

	public static boolean isString(EClassifier it) {
		return it instanceof EDataType && Objects.equal(it.getName(), "EString") && isEcoreType(it);
	}

	public static boolean isEcoreType(EClassifier it) {
		EPackage ePackage = it.getEPackage();
		String nsURI = null;
		if (ePackage != null) {
			nsURI = ePackage.getNsURI();
		}
		return "http://www.eclipse.org/emf/2002/Ecore".equals(nsURI);
	}

	public static boolean isID(EStructuralFeature it) {
		return it instanceof EAttribute && EAttribute.class.cast(it).isID();
	}

	public static boolean needsAssignment(EStructuralFeature it) {
		return it.isChangeable() && !it.isDerived() && !it.isTransient()
				&& !(it instanceof EReference && EReference.class.cast(it).isContainer())
				&& !(it.getEType() instanceof EDataType && !EDataType.class.cast(it.getEType()).isSerializable());
	}

	public static boolean needsConcreteRule(EClassifier eClassifier) {
		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			return !eClass.isAbstract() && !eClass.isInterface();
		} else {
			return true;
		}
	}

	public static boolean needsDispatcherRule(EClassifier eClassifier) {
		if (eClassifier instanceof EClass) {
			return !Iterables
					.isEmpty(Iterables.filter(subClasses((EClass) eClassifier), (EClass c) -> needsConcreteRule(c)));
		} else {
			return false;
		}
	}

	public static boolean isContainment(EStructuralFeature eStrFeat) {
		if (eStrFeat instanceof EAttribute) {
			return true;
		} else if (eStrFeat instanceof EReference) {
			return ((EReference) eStrFeat).isContainment();
		} else {
			return false;
		}
	}

	public static Iterable<EClass> subClasses(EClass it) {
		if (it.getEPackage() == null) {
			return Collections.emptyList();
		} else {
			return Iterables.filter(Iterables.filter(it.getEPackage().getEClassifiers(), EClass.class),
					(EClass c) -> c.getEAllSuperTypes().contains(it));
		}
	}

	public static Iterable<EAttribute> allAttributes(EClass it) {
		return Iterables.filter(inlinedFeatures(it), EAttribute.class);
	}

	public static Iterable<EReference> allCrossReferences(EClass it) {
		return Iterables.filter(Iterables.filter(inlinedFeatures(it), EReference.class),
				(EReference f) -> !f.isContainment());
	}

	public static Iterable<EReference> allContainmentReferences(EClass it) {
		return Iterables.filter(Iterables.filter(inlinedFeatures(it), EReference.class),
				(EReference f) -> f.isContainment());
	}
}
