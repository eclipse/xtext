package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext

import java.util.Collection
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature

import static org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Ecore2XtextExtensions.*

import static extension org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil.*

/**
 * Originally written with M2T Xtend. (Ecore2Xtext.ext)<br>
 * Translated to Tools Xtend mostly 1:1.<br>
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class Ecore2XtextExtensions {
	/** 
	 * cached Collection[EClassifier] allConcreteRuleClassifiers(Ecore2XtextProjectInfo this) :
	 *  rootElementClass == null 
	 *	? EPackageInfos.EPackage.allReferencedClassifiers(false).flatten().toSet().select(c|c.needsConcreteRule())
	 *   : (let c = { rootElementClass } : rootElementClass.allAssignedClassifiers(c) -> c.select(c|c.needsConcreteRule()).toSet());
	 */
	def static  allConcreteRuleClassifiers(Ecore2XtextProjectInfo it) {
		if (rootElementClass == null) {
			EPackageInfos.map([allReferencedClassifiers(EPackage,false)]).flatten.toSet.filter([needsConcreteRule(it)])
		} else {
			val c = newArrayList(typeof(EClassifier).cast(rootElementClass))
			allAssignedClassifiers(rootElementClass,c)
			c.filter([cl|needsConcreteRule(cl)]).toSet
		}
	}
	
	/*	 
	cached Collection[EClass] allDispatcherRuleClasses(Ecore2XtextProjectInfo this) :
		rootElementClass == null
			? EPackageInfos.EPackage.allReferencedClassifiers(false).flatten().toSet().select(c|c.needsDispatcherRule())
			: allConcreteRuleClassifiers().typeSelect(EClass).collect(c|c.EAllReferences.select(r|r.needsAssignment()).EType).flatten().toSet();
	*/
	def static Collection<EClass> allDispatcherRuleClasses(Ecore2XtextProjectInfo it) {
		if(rootElementClass == null)
			EPackageInfos.map([allReferencedClassifiers(EPackage,false)]).flatten.toSet.filter([c|needsDispatcherRule(c)]).filter(typeof(EClass)).toSet
		else
			allConcreteRuleClassifiers(it).filter(typeof(EClass)).map([c|c.EAllReferences.filter([r|needsAssignment(r)]).map([EType])]).flatten.filter(typeof(EClass)).toSet
	}
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
	def private static allAssignedClassifiers(EClass eClazz, Collection acceptor) {
		val classifiers = eClazz.EAllStructuralFeatures.filter([f|needsAssignment(f)]).map([EType]).toList
		classifiers += subClasses(eClazz)
		classifiers.removeAll(acceptor)
		if (classifiers.isEmpty)
			return
		else {
			acceptor += classifiers
			classifiers.filter(typeof(EClass)).forEach([c|allAssignedClassifiers(c,acceptor)])
		}
	}

	
	def static fqn(EClassifier it) {
		if (EPackage.uniqueName == null) 
			quoteIfNeccesary(name)
		else 
			EPackage.uniqueName + "::" + quoteIfNeccesary(name)
	}
	

def static Iterable<EStructuralFeature> prefixFeatures(EClass it) {
	EAllStructuralFeatures.filter([f|needsAssignment(f) && isPrefixBooleanFeature(f)]);
}


/*cached inlinedFeatures(EClass this) :
	EAllStructuralFeatures.select(f|f.needsAssignment()).remove(idAttribute()).removeAll(prefixFeatures()); */
def static Iterable<EStructuralFeature> inlinedFeatures(EClass it) {
	val features = EAllStructuralFeatures.filter([f|needsAssignment(f)]).toList
	features.remove(idAttribute(it))
	features.removeAll(prefixFeatures(it).toList)
	return features
}

def static onlyOptionalFeatures(EClass it) {
	val features = prefixFeatures(it) + inlinedFeatures(it)
	features.filter([f|f.required]).isEmpty;
}

/*
assignedRuleCall(EAttribute this):
	(isPrefixBooleanFeature()) ? "'"+name+"'" : EType.uniqueName();
*/
def static assignedRuleCall(EAttribute it) {
	if(isPrefixBooleanFeature(it)) "'"+name+"'" else EType.uniqueName(); 
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

/*
assignmentKeyword(EStructuralFeature this) :
	isPrefixBooleanFeature() ? "" : "'" + name + "' ";  
*/
def static assignmentKeyword(EStructuralFeature it) {
	if(isPrefixBooleanFeature(it))
		 "" 
	else
		 "'" + name + "' "
}

 /*quoteIfNeccesary(String this) :	
	isXtextKeyword() ? '^' + this : this;
	*/
def static quoteIfNeccesary(String str) {
	if (isXtextKeyword(str)) '^' + str else str;
}

def static isXtextKeyword(String str) {
	newArrayList('returns', 'generate', 'terminal', 'with', 'hidden', 'enum', 'grammar', 
	  'import', 'as', 'current', 'fragment', 'EOF'
	).contains(str)	
}


def static idAttribute(EClass it) {
	val idAttr = idAttributeInternal(it)
	if (idAttr != null)
		idAttr
	else 
		 EAllAttributes.findFirst([a|needsAssignment(a) && a.name == 'name' && a.EType.name=="EString" && !a.many]);
}

def private static  idAttributeInternal(EClass it) {
	EAllAttributes.findFirst([a|needsAssignment(a) && a.ID]);
}
def static boolean isBoolean(EClassifier it) {
	 (it instanceof EDataType) && newArrayList('EBoolean', 'EBooleanObject').contains(name) && isEcoreType(it);
}


def static boolean isPrefixBooleanFeature(EStructuralFeature it) {
	isBoolean(it.EType) && !many && defaultValueLiteral != "true";
}


def static isString(EClassifier it) {
	 it instanceof EDataType  && name == 'EString' && isEcoreType(it);
}

def static isEcoreType(EClassifier it) {
	EPackage.nsURI == "http://www.eclipse.org/emf/2002/Ecore";
}

def static boolean isID(EStructuralFeature it) {
	 it instanceof EAttribute && typeof(EAttribute).cast(it).ID;
}
	def static boolean needsAssignment(EStructuralFeature it) {
		//	!derived && !transient && !(EReference.isInstance(this) && ((EReference)this).container) && !(EDataType.isInstance(this.EType) && !((EDataType) this.EType).serializable);
		!derived && !transient && !((it instanceof EReference) && typeof(EReference).cast(it).container) && !((it.EType instanceof EDataType) && !typeof(EDataType).cast(it.EType).serializable);
	}

	
	/**
	 *boolean needsConcreteRule(EClass this) :
	 *	!abstract && !interface;
	 */
	def static boolean needsConcreteRule(EClassifier eClassifier) {
		switch(eClassifier) {
			EClass: 
				!eClassifier.^abstract && !eClassifier.isInterface
			EClassifier:
				true
			default:
				true
		}
	}
	

	def static boolean needsDispatcherRule(EClassifier eClassifier)  {
		switch(eClassifier) {
			EClass:
				!subClasses(eClassifier).filter([c|needsConcreteRule(c)]).isEmpty
			EClassifier:
				false
		}
	}



	/**isContainment(EStructuralFeature this) : false;
	 * isContainment(EAttribute this) : true;
	 * isContainment(EReference this) : containment;
	 */
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

	/*cached subClasses(EClass this):
		EPackage.EClassifiers.typeSelect(EClass).select(c|c.EAllSuperTypes.contains(this));	
 	*/
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
	 */
	 def static allAttributes(EClass it) {
	 	inlinedFeatures(it).filter(typeof(EAttribute))
	 }
	 def static allCrossReferences(EClass it) {
	 	inlinedFeatures(it).filter(typeof(EReference)).filter([f|!f.containment])
	 }
	 def static allContainmentReferences(EClass it) {
	 	inlinedFeatures(it).filter(typeof(EReference)).filter([f|f.containment])
	 }
	
}