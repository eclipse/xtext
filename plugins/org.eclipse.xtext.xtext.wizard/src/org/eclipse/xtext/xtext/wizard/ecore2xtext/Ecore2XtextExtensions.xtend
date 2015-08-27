package org.eclipse.xtext.xtext.wizard.ecore2xtext

import java.util.Collection
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature

import static extension org.eclipse.xtext.xtext.wizard.ecore2xtext.UniqueNameUtil.*
import org.eclipse.xtext.xtext.wizard.Ecore2XtextConfiguration

class Ecore2XtextExtensions {
	def static allConcreteRuleClassifiers(Ecore2XtextConfiguration it) {
		if (rootElementClass == null) {
			getEPackageInfos.map([allReferencedClassifiers(getEPackage, false)]).flatten.toSet.filter([
				needsConcreteRule(it)
			])
		} else {
			val c = newArrayList(EClassifier.cast(rootElementClass))
			allAssignedClassifiers(rootElementClass, c)
			c.filter([cl|needsConcreteRule(cl)]).toSet
		}
	}

	def static Collection<EClass> allDispatcherRuleClasses(Ecore2XtextConfiguration it) {
		if (rootElementClass == null)
			getEPackageInfos.map([allReferencedClassifiers(getEPackage, false)]).flatten.toSet.filter([c|
				needsDispatcherRule(c)
			]).filter(EClass).toSet
		else
			allConcreteRuleClassifiers(it).filter(EClass).map([c|
				c.getEAllReferences.filter([r|needsAssignment(r)]).map([getEType])
			]).flatten.filter(EClass).toSet
	}

	def static Collection<EPackage> allReferencedEPackages(Ecore2XtextConfiguration prjInfo) {
		prjInfo.getEPackageInfos.map([allReferencedEPackages(getEPackage, true)]).flatten.toSet
	}

	def static allReferencedEPackages(EPackage ePack, boolean includeCrossRefs) {
		allReferencedClassifiers(ePack, includeCrossRefs).map[getEPackage].filterNull.toSet
	}

	def static allReferencedClassifiers(EPackage ePack, boolean includeCrossRefs) {
		val strFeatures = ePack.getEClassifiers.filter(EClass).map([
			it.getEAllStructuralFeatures.filter([ f |
				(needsAssignment(f) && (includeCrossRefs || isContainment(f)))
			])
		])
		val refTypes = strFeatures.flatten.map([getEType]).toSet
		val retVal = (ePack.getEClassifiers + refTypes).toSet
		retVal.add(eString)
		return retVal
	}

	def private static void allAssignedClassifiers(EClass eClazz, Collection<EClassifier> acceptor) {
		val classifiers = eClazz.getEAllStructuralFeatures.filter([f|needsAssignment(f)]).map([getEType]).toList
		classifiers += subClasses(eClazz)
		classifiers.removeAll(acceptor)
		if (classifiers.isEmpty)
			return
		else {
			acceptor += classifiers
			classifiers.filter(EClass).forEach([c|allAssignedClassifiers(c, acceptor)])
		}
	}

	def static fqn(EClassifier it) {
		if (getEPackage?.uniqueName == null)
			quoteIfNeccesary(name)
		else
			getEPackage.uniqueName + "::" + quoteIfNeccesary(name)
	}

	def static Iterable<EStructuralFeature> prefixFeatures(EClass it) {
		getEAllStructuralFeatures.filter([f|needsAssignment(f) && isPrefixBooleanFeature(f)]);
	}

	def static Iterable<EStructuralFeature> inlinedFeatures(EClass it) {
		val features = getEAllStructuralFeatures.filter([f|needsAssignment(f)]).toList
		features.remove(idAttribute(it))
		features.removeAll(prefixFeatures(it).toList)
		return features
	}

	def static onlyOptionalFeatures(EClass it) {
		val features = prefixFeatures(it) + inlinedFeatures(it)
		features.filter([f|f.required]).isEmpty;
	}

	def static assignedRuleCall(EAttribute it) {
		if(isPrefixBooleanFeature(it)) "'" + name + "'" else getEType.uniqueName();
	}

	def static concreteRuleName(EClass it) {
		if (needsDispatcherRule(it))
			it.uniqueImplName
		else
			it.uniqueName;
	}

	def static String dataTypeRuleBody(EDataType it) {
		switch (name) {
			case 'EBigDecimal': "INT? '.' INT"
			case 'EBigInteger': intRuleBody()
			case 'EBoolean': booleanRuleBody()
			case 'EBooleanObject': booleanRuleBody()
			case 'EByte': intRuleBody()
			// case 'EByteArray': ??
			case 'EByteObject': intRuleBody()
			case 'EChar': intRuleBody()
			case 'ECharObject': intRuleBody()
			case 'EDouble': decimalRuleBody()
			case 'EDoubleObject': decimalRuleBody()
			case 'EFloat': decimalRuleBody()
			case 'EFloatObject': decimalRuleBody()
			case 'EInt': intRuleBody()
			case 'EIntegerObject': intRuleBody()
			case 'ELong': intRuleBody()
			case 'ELongObject': intRuleBody()
			case 'EShort': intRuleBody()
			case 'EShortObject': intRuleBody()
			case 'EString': 'STRING | ID'
			default: "'" + name + "' /* TODO: implement this rule and an appropriate IValueConverter */"
		};
	}

	def static intRuleBody() {
		"'-'? INT";
	}

	def static decimalRuleBody() {
		"'-'? INT? '.' INT (('E'|'e') '-'? INT)?";
	}

	def static booleanRuleBody() {
		"'true' | 'false'";
	}

	def static assignmentKeyword(EStructuralFeature it) {
		if (isPrefixBooleanFeature(it))
			""
		else
			"'" + name + "' "
	}

	def static quoteIfNeccesary(String str) {
		if(isXtextKeyword(str)) '^' + str else str;
	}

	def static isXtextKeyword(String str) {
		newArrayList(
			'returns',
			'generate',
			'terminal',
			'with',
			'hidden',
			'enum',
			'grammar',
			'import',
			'as',
			'current',
			'fragment',
			'EOF'
		).contains(str)
	}

	def static idAttribute(EClass it) {
		val idAttr = idAttributeInternal(it)
		if (idAttr != null)
			idAttr
		else
			getEAllAttributes.findFirst([a|
				needsAssignment(a) && a.name == 'name' && a.getEType.name == "EString" && !a.many
			]);
	}

	def private static idAttributeInternal(EClass it) {
		getEAllAttributes.findFirst([a|needsAssignment(a) && a.isID]);
	}

	def static boolean isBoolean(EClassifier it) {
		(it instanceof EDataType) && newArrayList('EBoolean', 'EBooleanObject').contains(name) && isEcoreType(it);
	}

	def static boolean isPrefixBooleanFeature(EStructuralFeature it) {
		isBoolean(it.getEType) && !many && defaultValueLiteral != "true";
	}

	def static isString(EClassifier it) {
		it instanceof EDataType && name == 'EString' && isEcoreType(it);
	}

	def static isEcoreType(EClassifier it) {
		getEPackage?.nsURI == "http://www.eclipse.org/emf/2002/Ecore";
	}

	def static boolean isID(EStructuralFeature it) {
		it instanceof EAttribute && EAttribute.cast(it).isID;
	}

	def static boolean needsAssignment(EStructuralFeature it) {
		!derived && !transient && !((it instanceof EReference) && EReference.cast(it).container) &&
			!((it.getEType instanceof EDataType) && !EDataType.cast(it.getEType).serializable);
	}

	def static boolean needsConcreteRule(EClassifier eClassifier) {
		switch (eClassifier) {
			EClass:
				!eClassifier.^abstract && !eClassifier.isInterface
			default:
				true
		}
	}

	def static boolean needsDispatcherRule(EClassifier eClassifier) {
		switch (eClassifier) {
			EClass:
				!subClasses(eClassifier).filter([c|needsConcreteRule(c)]).isEmpty
			default:
				false
		}
	}

	def static boolean isContainment(EStructuralFeature eStrFeat) {
		switch (eStrFeat) {
			EAttribute:
				true
			EReference:
				eStrFeat.containment
			default:
				false
		}
	}

	def static subClasses(EClass it) {
		if (getEPackage == null)
			emptyList
		else
			getEPackage.getEClassifiers.filter(EClass).filter(c|c.getEAllSuperTypes.contains(it));
	}

	def static allAttributes(EClass it) {
		inlinedFeatures(it).filter(EAttribute)
	}

	def static allCrossReferences(EClass it) {
		inlinedFeatures(it).filter(EReference).filter([f|!f.containment])
	}

	def static allContainmentReferences(EClass it) {
		inlinedFeatures(it).filter(EReference).filter([f|f.containment])
	}

}
										