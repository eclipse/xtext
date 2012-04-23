package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext

import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import static extension org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.*
import org.eclipse.emf.ecore.EClassifier
import java.util.Collection

class Ecore2XtextExtensions {
	/** 
	 * cached Collection[EClassifier] allConcreteRuleClassifiers(Ecore2XtextProjectInfo this) :
	 *  rootElementClass == null 
	 *	? EPackageInfos.EPackage.allReferencedClassifiers(false).flatten().toSet().select(c|c.needsConcreteRule())
	 *   : (let c = { rootElementClass } : rootElementClass.allAssignedClassifiers(c) -> c.select(c|c.needsConcreteRule()).toSet());
	 */
	def static Iterable<EClassifier> allConcreteRuleClassifiers(Ecore2XtextProjectInfo it) {
		if (rootElementClass == null) {
			EPackageInfos.map([allReferencedClassifiers(EPackage,false)]).flatten.toSet.filter([needsConcreteRule(it)])
		} else {
			val cls = allAssignedClassifiers(rootElementClass,newArrayList(rootElementClass))
			cls.filter([c|needsConcreteRule(c)]).toSet
		}
	}
	
/*	 
cached Collection[EClass] allDispatcherRuleClasses(Ecore2XtextProjectInfo this) :
	rootElementClass == null
		? EPackageInfos.EPackage.allReferencedClassifiers(false).flatten().toSet().select(c|c.needsDispatcherRule())
		: allConcreteRuleClassifiers().typeSelect(EClass).collect(c|c.EAllReferences.select(r|r.needsAssignment()).EType).flatten().toSet();
*/

	/**
	 * cached Collection[EPackage] allReferencedEPackages(Ecore2XtextProjectInfo this) :
	 *	EPackageInfos.EPackage.allReferencedEPackages(true).flatten().toSet();
 	 */
	def static Collection<EPackage> allReferencedEPackages(Ecore2XtextProjectInfo prjInfo) {
		prjInfo.EPackageInfos.map([allReferencedEPackages(EPackage,true)]).flatten.toSet
	}

	/**
	 * private cached Collection[EPackage] allReferencedEPackages(EPackage this, boolean includeCrossRefs) :	
	 *  allReferencedClassifiers(includeCrossRefs).EPackage.toSet();
	 */
	def static allReferencedEPackages(EPackage ePack, boolean includeCrossRefs) {
		allReferencedClassifiers(ePack,includeCrossRefs).map([EPackage]).toSet
	}

	// EClassifiers.union(EClassifiers.typeSelect(EClass).EAllStructuralFeatures.select(f|f.needsAssignment() && (includeCrossRefs || f.isContainment())).EType.flatten()).add(eString()).toSet();
	def static  allReferencedClassifiers(EPackage ePack, boolean includeCrossRefs) {
		val strFeatures = ePack.EClassifiers.filter(typeof(EClass)).map([
			it.EAllStructuralFeatures.filter([
				f | (needsAssignment(f) && (includeCrossRefs || isContainment(f)))
			])
		])
		val refTypes = strFeatures.flatten.map([EType]).toSet
		val retVal = (ePack.EClassifiers + refTypes).toSet
		retVal.add(eString)
		return retVal
	}
	
	/**
	 * private cached allAssignedClassifiers(EClass this, Collection acceptor) :
	(let classifiers = (EAllStructuralFeatures.select(f|f.needsAssignment()).EType).union(subClasses()).removeAll(acceptor) :
		classifiers.isEmpty 
			? null
			: (acceptor.addAll(classifiers) -> 
			 classifiers.typeSelect(EClass).collect(c|c.allAssignedClassifiers(acceptor))));
	 */
	def private static Iterable<EClassifier> allAssignedClassifiers(EClass it, Collection acceptor) {
		val classifiers = EAllStructuralFeatures.filter([f|needsAssignment(f)]).map([EType]).toList
		classifiers += subClasses(it)
		classifiers.removeAll(acceptor)
		if (classifiers.isEmpty)
			return null
		else {
			acceptor += classifiers			
			return classifiers.filter(typeof(EClass)).map([c|allAssignedClassifiers(c,acceptor)]).flatten
		}
	}

	
	def static fqn(EClassifier it) {
		if (EPackage.uniqueName == null) 
			quoteIfNeccesary(name)
		else 
			EPackage.uniqueName + "::" + quoteIfNeccesary(name)
	}
	
/*
Void resetUniqueNames(EPackageInfo defaultPackageInfo):
	 JAVA org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.clearUniqueNames(org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageInfo);

String uniqueName(ENamedElement this):
	 JAVA org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.uniqueName(org.eclipse.emf.ecore.ENamedElement);

String uniqueImplName(ENamedElement this):
	 JAVA org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.uniqueImplName(org.eclipse.emf.ecore.ENamedElement);

cached prefixFeatures(EClass this) :
	EAllStructuralFeatures.select(f|f.needsAssignment() && f.isPrefixBooleanFeature());
	
cached inlinedFeatures(EClass this) :
	EAllStructuralFeatures.select(f|f.needsAssignment()).remove(idAttribute()).removeAll(prefixFeatures());

cached onlyOptionalFeatures(EClass this) :
	prefixFeatures().union(inlinedFeatures()).select(f|f.required).isEmpty;
		
assignedRuleCall(EAttribute this):
	(isPrefixBooleanFeature()) ? "'"+name+"'" : EType.uniqueName();

concreteRuleName(EClass this):
	needsDispatcherRule()? uniqueImplName() : uniqueName();
*/

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
		default: "'" + name + "' // TODO: implement this rule and an appropriate IValueConverter "
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
/*
assignmentKeyword(EStructuralFeature this) :
	isPrefixBooleanFeature() ? "" : "'" + name + "' ";  

*/
 /*quoteIfNeccesary(String this) :	
	isXtextKeyword() ? '^' + this : this;
	*/
def static quoteIfNeccesary(String str) {
	if (isXtextKeyword(str)) '^' + str else str;
}

def static isXtextKeyword(String str) {
	newArrayList( 'ML_COMMENT', 'ID', 'WS','INT', 'STRING', 'ANY_OTHER', 'SL_COMMENT', 
	  'returns', 'generate', 'terminal', 'with', 'hidden', 'enum', 'grammar', 
	  'import', 'as', 'current', 'fragment', 'EOF'
	).contains(str)	
}

	/*
idAttribute(EClass this) :
	idAttributeInternal() != null ? idAttributeInternal() : EAllAttributes.selectFirst(a|a.needsAssignment() && a.name == 'name' && a.EType.name=="EString" && !a.many);

private idAttributeInternal(EClass this) :
	EAllAttributes.selectFirst(a|a.needsAssignment() && a.ID);

isBoolean(EClassifier this) :	
	EDataType.isInstance(this) && {'EBoolean', 'EBooleanObject'}.contains(name) && isEcoreType();

isPrefixBooleanFeature(EStructuralFeature this) :
	EType.isBoolean() && !many && defaultValueLiteral != "true";
	
isString(EClassifier this) :	
	EDataType.isInstance(this) && name == 'EString' && isEcoreType();

isEcoreType(EClassifier this) :
	EPackage.nsURI == "http://www.eclipse.org/emf/2002/Ecore";

isID(EStructuralFeature this) :
	EAttribute.isInstance({this}) && ((EAttribute)this).ID;
*/	
	def static boolean needsAssignment(EStructuralFeature it) {
		//	!derived && !transient && !(EReference.isInstance(this) && ((EReference)this).container) && !(EDataType.isInstance(this.EType) && !((EDataType) this.EType).serializable);
		!derived && !transient && !((it instanceof EReference) && typeof(EReference).cast(it).container) && !((it.EType instanceof EDataType) && !typeof(EDataType).cast(it).serializable);
	}

	
	/**
	 *boolean needsConcreteRule(EClass this) :
	 *	!abstract && !interface;
	 */
	def static boolean needsConcreteRule(EClassifier it) {
		if(it instanceof EClass) {
			val eClazz = typeof(EClass).cast(it)
			!eClazz.abstract && !eClazz.interface;
		}
		true
	}
	
/*
boolean needsDispatcherRule(EClass this) :
	!subClasses().select(c|c.needsConcreteRule()).isEmpty;

boolean needsDispatcherRule(EClassifier this) :
	false;

*/

	/**isContainment(EStructuralFeature this) : false;
	 * isContainment(EAttribute this) : true;
	 * isContainment(EReference this) : containment;
	 */
	def static boolean isContainment(EStructuralFeature eStrFeat) {
		if (eStrFeat instanceof EAttribute) {
			return true
		} else if (eStrFeat instanceof EReference) {
			return typeof(EReference).cast(eStrFeat).containment
		} else {
			return false
		}
	}

	def static subClasses(EClass it) {
		EPackage.EClassifiers.filter(typeof(EClass)).filter(c|c.EAllSuperTypes.contains(it));
	}
/*	


	
allAttributes(EClass this) :
	inlinedFeatures().typeSelect(EAttribute);
	
allCrossReferences(EClass this) :
	inlinedFeatures().typeSelect(EReference).select(r|!r.isContainment());
	
allContainmentReferences(EClass this) :
	inlinedFeatures().typeSelect(EReference).select(r|r.isContainment());
	 * 
	 */
}