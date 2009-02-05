/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;


public class EcoreDslParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("EcoreDsl") && (s = new EcoreDsl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ImportStatementDecl") && (s = new ImportStatementDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EPackage") && (s = new EPackageDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EPackage") && (s = new SubEPackageDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EClassifier") && (s = new EClassifierDecl_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EDataType") && (s = new EDataTypeDecl_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EAnnotation") && (s = new EAnnotationDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EClass") && (s = new EClassDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EStructuralFeature") && (s = new EStructuralFeatureDecl_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EAttribute") && (s = new EAttributeDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EReference") && (s = new EReferenceDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EEnum") && (s = new EEnumDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EEnumLiteral") && (s = new EEnumLiteralDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ETypeParameter") && (s = new ETypeParameterDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EGenericType") && (s = new EGenericTypeReferenceDecl_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EGenericType") && (s = new EGenericTypeDecl_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EOperation") && (s = new EOperationDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EParameter") && (s = new EParameterDecl_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EObject") && (s = new MapEntrySuper_RuleCall_MapEntry(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("MapEntry") && (s = new MapEntry_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("MultiplicityExpr") && (s = new MultiplicityExpr_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule EcoreDsl ****************
 *
 * EcoreDsl : ( imports += ImportStatementDecl ) * package = EPackageDecl ;
 *
 **/


// ( imports += ImportStatementDecl ) * package = EPackageDecl
protected class EcoreDsl_Group extends GroupToken {
	
	public EcoreDsl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEcoreDsl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EcoreDsl_1_Assignment_package(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EcoreDsl_0_Assignment_imports(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( imports += ImportStatementDecl ) *
protected class EcoreDsl_0_Assignment_imports extends AssignmentToken  {
	
	public EcoreDsl_0_Assignment_imports(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEcoreDsl().ele0AssignmentImports();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("imports",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("imports");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ImportStatementDecl")) {
				Solution s = new ImportStatementDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// package = EPackageDecl
protected class EcoreDsl_1_Assignment_package extends AssignmentToken  {
	
	public EcoreDsl_1_Assignment_package(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEcoreDsl().ele1AssignmentPackage();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("package",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("package");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EPackage")) {
				Solution s = new EPackageDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


/************ end Rule EcoreDsl ****************/


/************ begin Rule ImportStatementDecl ****************
 *
 * ImportStatementDecl : "import" ( alias = ID "=" ) ? importURI = STRING ";" ;
 *
 **/


// "import" ( alias = ID "=" ) ? importURI = STRING ";"
protected class ImportStatementDecl_Group extends GroupToken {
	
	public ImportStatementDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ImportStatementDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ImportStatementDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "import" ( alias = ID "=" ) ? importURI = STRING
protected class ImportStatementDecl_0_Group extends GroupToken {
	
	public ImportStatementDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ImportStatementDecl_0_1_Assignment_importURI(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ImportStatementDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "import" ( alias = ID "=" ) ?
protected class ImportStatementDecl_0_0_Group extends GroupToken {
	
	public ImportStatementDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ImportStatementDecl_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ImportStatementDecl_0_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "import"
protected class ImportStatementDecl_0_0_0_Keyword_import extends KeywordToken  {
	
	public ImportStatementDecl_0_0_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele000KeywordImport();
	}	
}

// ( alias = ID "=" ) ?
protected class ImportStatementDecl_0_0_1_Group extends GroupToken {
	
	public ImportStatementDecl_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ImportStatementDecl_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ImportStatementDecl_0_0_1_0_Assignment_alias(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// alias = ID
protected class ImportStatementDecl_0_0_1_0_Assignment_alias extends AssignmentToken  {
	
	public ImportStatementDecl_0_0_1_0_Assignment_alias(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele0010AssignmentAlias();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("alias",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("alias");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele00100LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "="
protected class ImportStatementDecl_0_0_1_1_Keyword extends KeywordToken  {
	
	public ImportStatementDecl_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele0011KeywordEqualsSign();
	}	
}



// importURI = STRING
protected class ImportStatementDecl_0_1_Assignment_importURI extends AssignmentToken  {
	
	public ImportStatementDecl_0_1_Assignment_importURI(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele01AssignmentImportURI();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("importURI",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("importURI");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// ";"
protected class ImportStatementDecl_1_Keyword extends KeywordToken  {
	
	public ImportStatementDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prImportStatementDecl().ele1KeywordSemicolon();
	}	
}


/************ end Rule ImportStatementDecl ****************/


/************ begin Rule EPackageDecl ****************
 *
 * EPackageDecl returns EPackage : ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING "nsPrefix" "=" nsPrefix = QID "{" ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) * "}" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING "nsPrefix" "=" nsPrefix = QID "{" ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) * "}"
protected class EPackageDecl_Group extends GroupToken {
	
	public EPackageDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING "nsPrefix" "=" nsPrefix = QID "{" ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) *
protected class EPackageDecl_0_Group extends GroupToken {
	
	public EPackageDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING "nsPrefix" "=" nsPrefix = QID "{"
protected class EPackageDecl_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING "nsPrefix" "=" nsPrefix = QID
protected class EPackageDecl_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_1_Assignment_nsPrefix(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING "nsPrefix" "="
protected class EPackageDecl_0_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING "nsPrefix"
protected class EPackageDecl_0_0_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_0_0_1_Keyword_nsPrefix(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "=" nsURI = STRING
protected class EPackageDecl_0_0_0_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_0_0_0_1_Assignment_nsURI(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI" "="
protected class EPackageDecl_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele0000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID "nsURI"
protected class EPackageDecl_0_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_0_0_0_0_0_1_Keyword_nsURI(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = QID
protected class EPackageDecl_0_0_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele000000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_0_0_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package"
protected class EPackageDecl_0_0_0_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EPackageDecl_0_0_0_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele0000000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EPackageDecl_0_0_0_0_0_0_0_0_0_0_1_Keyword_package(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageDecl_0_0_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EPackageDecl_0_0_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EPackageDecl_0_0_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00000000000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// "package"
protected class EPackageDecl_0_0_0_0_0_0_0_0_0_0_1_Keyword_package extends KeywordToken  {
	
	public EPackageDecl_0_0_0_0_0_0_0_0_0_0_1_Keyword_package(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00000000001KeywordPackage();
	}	
}


// name = QID
protected class EPackageDecl_0_0_0_0_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EPackageDecl_0_0_0_0_0_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele0000000001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00000000010ParserRuleCallQID();
			return new Solution(obj);
		}

		return null;
	}
}


// "nsURI"
protected class EPackageDecl_0_0_0_0_0_0_0_0_1_Keyword_nsURI extends KeywordToken  {
	
	public EPackageDecl_0_0_0_0_0_0_0_0_1_Keyword_nsURI(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele000000001KeywordNsURI();
	}	
}


// "="
protected class EPackageDecl_0_0_0_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public EPackageDecl_0_0_0_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00000001KeywordEqualsSign();
	}	
}


// nsURI = STRING
protected class EPackageDecl_0_0_0_0_0_0_1_Assignment_nsURI extends AssignmentToken  {
	
	public EPackageDecl_0_0_0_0_0_0_1_Assignment_nsURI(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele0000001AssignmentNsURI();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nsURI",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nsURI");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00000010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// "nsPrefix"
protected class EPackageDecl_0_0_0_0_0_1_Keyword_nsPrefix extends KeywordToken  {
	
	public EPackageDecl_0_0_0_0_0_1_Keyword_nsPrefix(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele000001KeywordNsPrefix();
	}	
}


// "="
protected class EPackageDecl_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public EPackageDecl_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00001KeywordEqualsSign();
	}	
}


// nsPrefix = QID
protected class EPackageDecl_0_0_0_1_Assignment_nsPrefix extends AssignmentToken  {
	
	public EPackageDecl_0_0_0_1_Assignment_nsPrefix(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele0001AssignmentNsPrefix();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("nsPrefix",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nsPrefix");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele00010ParserRuleCallQID();
			return new Solution(obj);
		}

		return null;
	}
}


// "{"
protected class EPackageDecl_0_0_1_Keyword extends KeywordToken  {
	
	public EPackageDecl_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele001KeywordLeftCurlyBracket();
	}	
}


// ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) *
protected class EPackageDecl_0_1_Alternatives extends AlternativesToken {

	public EPackageDecl_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele01Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EPackageDecl_0_1_1_Assignment_eClassifiers(current, this) : new EPackageDecl_0_1_0_Assignment_eSubpackages(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// eSubpackages += SubEPackageDecl
protected class EPackageDecl_0_1_0_Assignment_eSubpackages extends AssignmentToken  {
	
	public EPackageDecl_0_1_0_Assignment_eSubpackages(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele010AssignmentESubpackages();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eSubpackages",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eSubpackages");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EPackage")) {
				Solution s = new SubEPackageDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// eClassifiers += EClassifierDecl
protected class EPackageDecl_0_1_1_Assignment_eClassifiers extends AssignmentToken  {
	
	public EPackageDecl_0_1_1_Assignment_eClassifiers(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele011AssignmentEClassifiers();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eClassifiers",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eClassifiers");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EClassifier")) {
				Solution s = new EClassifierDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// "}"
protected class EPackageDecl_1_Keyword extends KeywordToken  {
	
	public EPackageDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEPackageDecl().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule EPackageDecl ****************/


/************ begin Rule SubEPackageDecl ****************
 *
 * SubEPackageDecl returns EPackage : ( eAnnotations += EAnnotationDecl ) * "package" name = ID "{" ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) * "}" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * "package" name = ID "{" ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) * "}"
protected class SubEPackageDecl_Group extends GroupToken {
	
	public SubEPackageDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SubEPackageDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SubEPackageDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = ID "{" ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) *
protected class SubEPackageDecl_0_Group extends GroupToken {
	
	public SubEPackageDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SubEPackageDecl_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SubEPackageDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = ID "{"
protected class SubEPackageDecl_0_0_Group extends GroupToken {
	
	public SubEPackageDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SubEPackageDecl_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SubEPackageDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package" name = ID
protected class SubEPackageDecl_0_0_0_Group extends GroupToken {
	
	public SubEPackageDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SubEPackageDecl_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SubEPackageDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "package"
protected class SubEPackageDecl_0_0_0_0_Group extends GroupToken {
	
	public SubEPackageDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new SubEPackageDecl_0_0_0_0_1_Keyword_package(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SubEPackageDecl_0_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class SubEPackageDecl_0_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public SubEPackageDecl_0_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele00000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// "package"
protected class SubEPackageDecl_0_0_0_0_1_Keyword_package extends KeywordToken  {
	
	public SubEPackageDecl_0_0_0_0_1_Keyword_package(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele00001KeywordPackage();
	}	
}


// name = ID
protected class SubEPackageDecl_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public SubEPackageDecl_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele0001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele00010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "{"
protected class SubEPackageDecl_0_0_1_Keyword extends KeywordToken  {
	
	public SubEPackageDecl_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele001KeywordLeftCurlyBracket();
	}	
}


// ( eSubpackages += SubEPackageDecl | eClassifiers += EClassifierDecl ) *
protected class SubEPackageDecl_0_1_Alternatives extends AlternativesToken {

	public SubEPackageDecl_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele01Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new SubEPackageDecl_0_1_1_Assignment_eClassifiers(current, this) : new SubEPackageDecl_0_1_0_Assignment_eSubpackages(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// eSubpackages += SubEPackageDecl
protected class SubEPackageDecl_0_1_0_Assignment_eSubpackages extends AssignmentToken  {
	
	public SubEPackageDecl_0_1_0_Assignment_eSubpackages(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele010AssignmentESubpackages();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eSubpackages",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eSubpackages");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EPackage")) {
				Solution s = new SubEPackageDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// eClassifiers += EClassifierDecl
protected class SubEPackageDecl_0_1_1_Assignment_eClassifiers extends AssignmentToken  {
	
	public SubEPackageDecl_0_1_1_Assignment_eClassifiers(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele011AssignmentEClassifiers();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eClassifiers",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eClassifiers");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EClassifier")) {
				Solution s = new EClassifierDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// "}"
protected class SubEPackageDecl_1_Keyword extends KeywordToken  {
	
	public SubEPackageDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prSubEPackageDecl().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule SubEPackageDecl ****************/


/************ begin Rule EClassifierDecl ****************
 *
 * EClassifierDecl returns EClassifier : EClassDecl | EDataTypeDecl ;
 *
 **/


// EClassDecl | EDataTypeDecl
protected class EClassifierDecl_Alternatives extends AlternativesToken {

	public EClassifierDecl_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassifierDecl().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EClassifierDecl_1_RuleCall_EDataTypeDecl(current, this) : new EClassifierDecl_0_RuleCall_EClassDecl(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// EClassDecl
protected class EClassifierDecl_0_RuleCall_EClassDecl extends RuleCallToken {
	
	public EClassifierDecl_0_RuleCall_EClassDecl(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassifierDecl().ele0ParserRuleCallEClassDecl();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(EClassDecl_Group.class, current)) return null;
		if(!current.isInstanceOf("EClass")) return null;
		return new EClassDecl_Group(current, this).firstSolution();
	}
}

// EDataTypeDecl
protected class EClassifierDecl_1_RuleCall_EDataTypeDecl extends RuleCallToken {
	
	public EClassifierDecl_1_RuleCall_EDataTypeDecl(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassifierDecl().ele1ParserRuleCallEDataTypeDecl();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(EDataTypeDecl_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("EDataType")) return null;
		return new EDataTypeDecl_Alternatives(current, this).firstSolution();
	}
}


/************ end Rule EClassifierDecl ****************/


/************ begin Rule EDataTypeDecl ****************
 *
 * EDataTypeDecl returns EDataType : ( eAnnotations += EAnnotationDecl ) * ( serializable ?= "!serializable" ) ? ( "datatype" name = ID ":" instanceClassName = STRING_OR_QID ";" ) | EEnumDecl ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * ( serializable ?= "!serializable" ) ? ( "datatype" name = ID ":" instanceClassName = STRING_OR_QID ";" ) | EEnumDecl
protected class EDataTypeDecl_Alternatives extends AlternativesToken {

	public EDataTypeDecl_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EDataTypeDecl_1_RuleCall_EEnumDecl(current, this) : new EDataTypeDecl_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( serializable ?= "!serializable" ) ? ( "datatype" name = ID ":" instanceClassName = STRING_OR_QID ";" )
protected class EDataTypeDecl_0_Group extends GroupToken {
	
	public EDataTypeDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EDataTypeDecl_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EDataTypeDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( serializable ?= "!serializable" ) ?
protected class EDataTypeDecl_0_0_Group extends GroupToken {
	
	public EDataTypeDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EDataTypeDecl_0_0_1_Assignment_serializable(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EDataTypeDecl_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EDataTypeDecl_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EDataTypeDecl_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// ( serializable ?= "!serializable" ) ?
protected class EDataTypeDecl_0_0_1_Assignment_serializable extends AssignmentToken  {
	
	public EDataTypeDecl_0_0_1_Assignment_serializable(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele001AssignmentSerializable();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("serializable",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("serializable");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele0010KeywordSerializable();
			return new Solution(obj);
		}

		return null;
	}
}


// "datatype" name = ID ":" instanceClassName = STRING_OR_QID ";"
protected class EDataTypeDecl_0_1_Group extends GroupToken {
	
	public EDataTypeDecl_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EDataTypeDecl_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EDataTypeDecl_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "datatype" name = ID ":" instanceClassName = STRING_OR_QID
protected class EDataTypeDecl_0_1_0_Group extends GroupToken {
	
	public EDataTypeDecl_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EDataTypeDecl_0_1_0_1_Assignment_instanceClassName(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EDataTypeDecl_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "datatype" name = ID ":"
protected class EDataTypeDecl_0_1_0_0_Group extends GroupToken {
	
	public EDataTypeDecl_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele0100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EDataTypeDecl_0_1_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EDataTypeDecl_0_1_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "datatype" name = ID
protected class EDataTypeDecl_0_1_0_0_0_Group extends GroupToken {
	
	public EDataTypeDecl_0_1_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele01000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EDataTypeDecl_0_1_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EDataTypeDecl_0_1_0_0_0_0_Keyword_datatype(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "datatype"
protected class EDataTypeDecl_0_1_0_0_0_0_Keyword_datatype extends KeywordToken  {
	
	public EDataTypeDecl_0_1_0_0_0_0_Keyword_datatype(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele010000KeywordDatatype();
	}	
}

// name = ID
protected class EDataTypeDecl_0_1_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EDataTypeDecl_0_1_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele010001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele0100010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ":"
protected class EDataTypeDecl_0_1_0_0_1_Keyword extends KeywordToken  {
	
	public EDataTypeDecl_0_1_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele01001KeywordColon();
	}	
}


// instanceClassName = STRING_OR_QID
protected class EDataTypeDecl_0_1_0_1_Assignment_instanceClassName extends AssignmentToken  {
	
	public EDataTypeDecl_0_1_0_1_Assignment_instanceClassName(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele0101AssignmentInstanceClassName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("instanceClassName",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("instanceClassName");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele01010ParserRuleCallSTRING_OR_QID();
			return new Solution(obj);
		}

		return null;
	}
}


// ";"
protected class EDataTypeDecl_0_1_1_Keyword extends KeywordToken  {
	
	public EDataTypeDecl_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele011KeywordSemicolon();
	}	
}



// EEnumDecl
protected class EDataTypeDecl_1_RuleCall_EEnumDecl extends RuleCallToken {
	
	public EDataTypeDecl_1_RuleCall_EEnumDecl(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEDataTypeDecl().ele1ParserRuleCallEEnumDecl();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(EEnumDecl_Group.class, current)) return null;
		if(!current.isInstanceOf("EEnum")) return null;
		return new EEnumDecl_Group(current, this).firstSolution();
	}
}


/************ end Rule EDataTypeDecl ****************/


/************ begin Rule EAnnotationDecl ****************
 *
 * EAnnotationDecl returns EAnnotation : "@" source = STRING ( eModelElement = [ EModelElement ] ) ? "(" contents += MapEntrySuper ( "," contents += MapEntrySuper ) * ")" ;
 *
 **/


// "@" source = STRING ( eModelElement = [ EModelElement ] ) ? "(" contents += MapEntrySuper ( "," contents += MapEntrySuper ) * ")"
protected class EAnnotationDecl_Group extends GroupToken {
	
	public EAnnotationDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAnnotationDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAnnotationDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "@" source = STRING ( eModelElement = [ EModelElement ] ) ? "(" contents += MapEntrySuper ( "," contents += MapEntrySuper ) *
protected class EAnnotationDecl_0_Group extends GroupToken {
	
	public EAnnotationDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAnnotationDecl_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAnnotationDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "@" source = STRING ( eModelElement = [ EModelElement ] ) ? "(" contents += MapEntrySuper
protected class EAnnotationDecl_0_0_Group extends GroupToken {
	
	public EAnnotationDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAnnotationDecl_0_0_1_Assignment_contents(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAnnotationDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "@" source = STRING ( eModelElement = [ EModelElement ] ) ? "("
protected class EAnnotationDecl_0_0_0_Group extends GroupToken {
	
	public EAnnotationDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAnnotationDecl_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAnnotationDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "@" source = STRING ( eModelElement = [ EModelElement ] ) ?
protected class EAnnotationDecl_0_0_0_0_Group extends GroupToken {
	
	public EAnnotationDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAnnotationDecl_0_0_0_0_1_Assignment_eModelElement(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAnnotationDecl_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "@" source = STRING
protected class EAnnotationDecl_0_0_0_0_0_Group extends GroupToken {
	
	public EAnnotationDecl_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAnnotationDecl_0_0_0_0_0_1_Assignment_source(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAnnotationDecl_0_0_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "@"
protected class EAnnotationDecl_0_0_0_0_0_0_Keyword extends KeywordToken  {
	
	public EAnnotationDecl_0_0_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele000000KeywordCommercialAt();
	}	
}

// source = STRING
protected class EAnnotationDecl_0_0_0_0_0_1_Assignment_source extends AssignmentToken  {
	
	public EAnnotationDecl_0_0_0_0_0_1_Assignment_source(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele000001AssignmentSource();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("source",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("source");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele0000010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// ( eModelElement = [ EModelElement ] ) ?
protected class EAnnotationDecl_0_0_0_0_1_Assignment_eModelElement extends AssignmentToken  {
	
	public EAnnotationDecl_0_0_0_0_1_Assignment_eModelElement(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele00001AssignmentEModelElement();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eModelElement",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eModelElement");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EModelElement")) {
				type = AssignmentType.CR;
				element = EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele000010CrossReferenceEStringEModelElement(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// "("
protected class EAnnotationDecl_0_0_0_1_Keyword extends KeywordToken  {
	
	public EAnnotationDecl_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele0001KeywordLeftParenthesis();
	}	
}


// contents += MapEntrySuper
protected class EAnnotationDecl_0_0_1_Assignment_contents extends AssignmentToken  {
	
	public EAnnotationDecl_0_0_1_Assignment_contents(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele001AssignmentContents();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("contents",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contents");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EObject")) {
				Solution s = new MapEntrySuper_RuleCall_MapEntry(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "," contents += MapEntrySuper ) *
protected class EAnnotationDecl_0_1_Group extends GroupToken {
	
	public EAnnotationDecl_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAnnotationDecl_0_1_1_Assignment_contents(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAnnotationDecl_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EAnnotationDecl_0_1_0_Keyword extends KeywordToken  {
	
	public EAnnotationDecl_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele010KeywordComma();
	}	
}

// contents += MapEntrySuper
protected class EAnnotationDecl_0_1_1_Assignment_contents extends AssignmentToken  {
	
	public EAnnotationDecl_0_1_1_Assignment_contents(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele011AssignmentContents();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("contents",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("contents");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EObject")) {
				Solution s = new MapEntrySuper_RuleCall_MapEntry(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// ")"
protected class EAnnotationDecl_1_Keyword extends KeywordToken  {
	
	public EAnnotationDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAnnotationDecl().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule EAnnotationDecl ****************/


/************ begin Rule EClassDecl ****************
 *
 * EClassDecl returns EClass : ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? ( "extends" eGenericSuperTypes += EGenericTypeReferenceDecl ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) * ) ? ( ":" instanceClassName = STRING_OR_QID ) ? "{" ( eStructuralFeatures += EStructuralFeatureDecl | eOperations += EOperationDecl ) * "}" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? ( "extends" eGenericSuperTypes += EGenericTypeReferenceDecl ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) * ) ? ( ":" instanceClassName = STRING_OR_QID ) ? "{" ( eStructuralFeatures += EStructuralFeatureDecl | eOperations += EOperationDecl ) * "}"
protected class EClassDecl_Group extends GroupToken {
	
	public EClassDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? ( "extends" eGenericSuperTypes += EGenericTypeReferenceDecl ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) * ) ? ( ":" instanceClassName = STRING_OR_QID ) ? "{" ( eStructuralFeatures += EStructuralFeatureDecl | eOperations += EOperationDecl ) *
protected class EClassDecl_0_Group extends GroupToken {
	
	public EClassDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? ( "extends" eGenericSuperTypes += EGenericTypeReferenceDecl ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) * ) ? ( ":" instanceClassName = STRING_OR_QID ) ? "{"
protected class EClassDecl_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? ( "extends" eGenericSuperTypes += EGenericTypeReferenceDecl ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) * ) ? ( ":" instanceClassName = STRING_OR_QID ) ?
protected class EClassDecl_0_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? ( "extends" eGenericSuperTypes += EGenericTypeReferenceDecl ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) * ) ?
protected class EClassDecl_0_0_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ?
protected class EClassDecl_0_0_0_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" ) name = ID
protected class EClassDecl_0_0_0_0_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ? ( interface ?= "interface" | "class" )
protected class EClassDecl_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( abstract ?= "abstract" ) ?
protected class EClassDecl_0_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_0_0_0_1_Assignment_abstract(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EClassDecl_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000000000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// ( abstract ?= "abstract" ) ?
protected class EClassDecl_0_0_0_0_0_0_0_0_1_Assignment_abstract extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_0_0_0_0_1_Assignment_abstract(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000000001AssignmentAbstract();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("abstract",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("abstract");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000000010KeywordAbstract();
			return new Solution(obj);
		}

		return null;
	}
}


// interface ?= "interface" | "class"
protected class EClassDecl_0_0_0_0_0_0_0_1_Alternatives extends AlternativesToken {

	public EClassDecl_0_0_0_0_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00000001Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EClassDecl_0_0_0_0_0_0_0_1_1_Keyword_class(current, this) : new EClassDecl_0_0_0_0_0_0_0_1_0_Assignment_interface(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// interface ?= "interface"
protected class EClassDecl_0_0_0_0_0_0_0_1_0_Assignment_interface extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_0_0_0_1_0_Assignment_interface(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000000010AssignmentInterface();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("interface",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("interface");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000000100KeywordInterface();
			return new Solution(obj);
		}

		return null;
	}
}

// "class"
protected class EClassDecl_0_0_0_0_0_0_0_1_1_Keyword_class extends KeywordToken  {
	
	public EClassDecl_0_0_0_0_0_0_0_1_1_Keyword_class(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000000011KeywordClass();
	}	
}



// name = ID
protected class EClassDecl_0_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00000010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ?
protected class EClassDecl_0_0_0_0_0_1_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) *
protected class EClassDecl_0_0_0_0_0_1_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeParameters += ETypeParameterDecl
protected class EClassDecl_0_0_0_0_0_1_0_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00000100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_1_0_0_1_Assignment_eTypeParameters(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_1_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<"
protected class EClassDecl_0_0_0_0_0_1_0_0_0_Keyword extends KeywordToken  {
	
	public EClassDecl_0_0_0_0_0_1_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000001000KeywordLessThanSign();
	}	
}

// eTypeParameters += ETypeParameterDecl
protected class EClassDecl_0_0_0_0_0_1_0_0_1_Assignment_eTypeParameters extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_0_1_0_0_1_Assignment_eTypeParameters(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000001001AssignmentETypeParameters();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeParameters",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeParameters");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ETypeParameter")) {
				Solution s = new ETypeParameterDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "," eTypeParameters += ETypeParameterDecl ) *
protected class EClassDecl_0_0_0_0_0_1_0_1_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_0_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00000101Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_0_1_0_1_1_Assignment_eTypeParameters(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_0_1_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EClassDecl_0_0_0_0_0_1_0_1_0_Keyword extends KeywordToken  {
	
	public EClassDecl_0_0_0_0_0_1_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000001010KeywordComma();
	}	
}

// eTypeParameters += ETypeParameterDecl
protected class EClassDecl_0_0_0_0_0_1_0_1_1_Assignment_eTypeParameters extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_0_1_0_1_1_Assignment_eTypeParameters(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000001011AssignmentETypeParameters();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeParameters",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeParameters");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ETypeParameter")) {
				Solution s = new ETypeParameterDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// ">"
protected class EClassDecl_0_0_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public EClassDecl_0_0_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000011KeywordGreaterThanSign();
	}	
}



// ( "extends" eGenericSuperTypes += EGenericTypeReferenceDecl ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) * ) ?
protected class EClassDecl_0_0_0_0_1_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "extends" eGenericSuperTypes += EGenericTypeReferenceDecl
protected class EClassDecl_0_0_0_0_1_0_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_1_0_1_Assignment_eGenericSuperTypes(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_1_0_0_Keyword_extends(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "extends"
protected class EClassDecl_0_0_0_0_1_0_0_Keyword_extends extends KeywordToken  {
	
	public EClassDecl_0_0_0_0_1_0_0_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000100KeywordExtends();
	}	
}

// eGenericSuperTypes += EGenericTypeReferenceDecl
protected class EClassDecl_0_0_0_0_1_0_1_Assignment_eGenericSuperTypes extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_1_0_1_Assignment_eGenericSuperTypes(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000101AssignmentEGenericSuperTypes();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericSuperTypes",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericSuperTypes");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "," eGenericSuperTypes += EGenericTypeReferenceDecl ) *
protected class EClassDecl_0_0_0_0_1_1_Group extends GroupToken {
	
	public EClassDecl_0_0_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000011Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_0_1_1_1_Assignment_eGenericSuperTypes(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EClassDecl_0_0_0_0_1_1_0_Keyword extends KeywordToken  {
	
	public EClassDecl_0_0_0_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000110KeywordComma();
	}	
}

// eGenericSuperTypes += EGenericTypeReferenceDecl
protected class EClassDecl_0_0_0_0_1_1_1_Assignment_eGenericSuperTypes extends AssignmentToken  {
	
	public EClassDecl_0_0_0_0_1_1_1_Assignment_eGenericSuperTypes(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0000111AssignmentEGenericSuperTypes();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericSuperTypes",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericSuperTypes");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}




// ( ":" instanceClassName = STRING_OR_QID ) ?
protected class EClassDecl_0_0_0_1_Group extends GroupToken {
	
	public EClassDecl_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EClassDecl_0_0_0_1_1_Assignment_instanceClassName(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EClassDecl_0_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ":"
protected class EClassDecl_0_0_0_1_0_Keyword extends KeywordToken  {
	
	public EClassDecl_0_0_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00010KeywordColon();
	}	
}

// instanceClassName = STRING_OR_QID
protected class EClassDecl_0_0_0_1_1_Assignment_instanceClassName extends AssignmentToken  {
	
	public EClassDecl_0_0_0_1_1_Assignment_instanceClassName(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele00011AssignmentInstanceClassName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("instanceClassName",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("instanceClassName");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele000110ParserRuleCallSTRING_OR_QID();
			return new Solution(obj);
		}

		return null;
	}
}



// "{"
protected class EClassDecl_0_0_1_Keyword extends KeywordToken  {
	
	public EClassDecl_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele001KeywordLeftCurlyBracket();
	}	
}


// ( eStructuralFeatures += EStructuralFeatureDecl | eOperations += EOperationDecl ) *
protected class EClassDecl_0_1_Alternatives extends AlternativesToken {

	public EClassDecl_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele01Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EClassDecl_0_1_1_Assignment_eOperations(current, this) : new EClassDecl_0_1_0_Assignment_eStructuralFeatures(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// eStructuralFeatures += EStructuralFeatureDecl
protected class EClassDecl_0_1_0_Assignment_eStructuralFeatures extends AssignmentToken  {
	
	public EClassDecl_0_1_0_Assignment_eStructuralFeatures(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele010AssignmentEStructuralFeatures();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eStructuralFeatures",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eStructuralFeatures");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EStructuralFeature")) {
				Solution s = new EStructuralFeatureDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// eOperations += EOperationDecl
protected class EClassDecl_0_1_1_Assignment_eOperations extends AssignmentToken  {
	
	public EClassDecl_0_1_1_Assignment_eOperations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele011AssignmentEOperations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eOperations",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eOperations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EOperation")) {
				Solution s = new EOperationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// "}"
protected class EClassDecl_1_Keyword extends KeywordToken  {
	
	public EClassDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassDecl().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule EClassDecl ****************/


/************ begin Rule EStructuralFeatureDecl ****************
 *
 * EStructuralFeatureDecl returns EStructuralFeature : EAttributeDecl | EReferenceDecl ;
 *
 **/


// EAttributeDecl | EReferenceDecl
protected class EStructuralFeatureDecl_Alternatives extends AlternativesToken {

	public EStructuralFeatureDecl_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEStructuralFeatureDecl().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EStructuralFeatureDecl_1_RuleCall_EReferenceDecl(current, this) : new EStructuralFeatureDecl_0_RuleCall_EAttributeDecl(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// EAttributeDecl
protected class EStructuralFeatureDecl_0_RuleCall_EAttributeDecl extends RuleCallToken {
	
	public EStructuralFeatureDecl_0_RuleCall_EAttributeDecl(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEStructuralFeatureDecl().ele0ParserRuleCallEAttributeDecl();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(EAttributeDecl_Group.class, current)) return null;
		if(!current.isInstanceOf("EAttribute")) return null;
		return new EAttributeDecl_Group(current, this).firstSolution();
	}
}

// EReferenceDecl
protected class EStructuralFeatureDecl_1_RuleCall_EReferenceDecl extends RuleCallToken {
	
	public EStructuralFeatureDecl_1_RuleCall_EReferenceDecl(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEStructuralFeatureDecl().ele1ParserRuleCallEReferenceDecl();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(EReferenceDecl_Group.class, current)) return null;
		if(!current.isInstanceOf("EReference")) return null;
		return new EReferenceDecl_Group(current, this).firstSolution();
	}
}


/************ end Rule EStructuralFeatureDecl ****************/


/************ begin Rule EAttributeDecl ****************
 *
 * EAttributeDecl returns EAttribute : ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * "attr" eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? name = ID ( "=" defaultValueLiteral = STRING ) ? ";" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * "attr" eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? name = ID ( "=" defaultValueLiteral = STRING ) ? ";"
protected class EAttributeDecl_Group extends GroupToken {
	
	public EAttributeDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * "attr" eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? name = ID ( "=" defaultValueLiteral = STRING ) ?
protected class EAttributeDecl_0_Group extends GroupToken {
	
	public EAttributeDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * "attr" eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? name = ID
protected class EAttributeDecl_0_0_Group extends GroupToken {
	
	public EAttributeDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * "attr" eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ?
protected class EAttributeDecl_0_0_0_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * "attr" eGenericType = EGenericTypeReferenceDecl
protected class EAttributeDecl_0_0_0_0_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_0_1_Assignment_eGenericType(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * "attr"
protected class EAttributeDecl_0_0_0_0_0_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_0_0_1_Keyword_attr(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) *
protected class EAttributeDecl_0_0_0_0_0_0_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EAttributeDecl_0_0_0_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// ( iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) *
protected class EAttributeDecl_0_0_0_0_0_0_1_Alternatives extends AlternativesToken {

	public EAttributeDecl_0_0_0_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000001Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EAttributeDecl_0_0_0_0_0_0_1_1_Assignment_derived(current, this) : new EAttributeDecl_0_0_0_0_0_0_1_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_Alternatives extends AlternativesToken {

	public EAttributeDecl_0_0_0_0_0_0_1_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000010Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EAttributeDecl_0_0_0_0_0_0_1_0_1_Assignment_unsettable(current, this) : new EAttributeDecl_0_0_0_0_0_0_1_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_Alternatives extends AlternativesToken {

	public EAttributeDecl_0_0_0_0_0_0_1_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000100Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EAttributeDecl_0_0_0_0_0_0_1_0_0_1_Assignment_transient(current, this) : new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_Alternatives extends AlternativesToken {

	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000001000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_1_Assignment_volatile(current, this) : new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// iD ?= "ID" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_Alternatives extends AlternativesToken {

	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000010000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_1_Assignment_changeable(current, this) : new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// iD ?= "ID" | unique ?= "bag" | ordered ?= "random"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_Alternatives extends AlternativesToken {

	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000100000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_1_Assignment_ordered(current, this) : new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// iD ?= "ID" | unique ?= "bag"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_Alternatives extends AlternativesToken {

	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000001000000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_1_Assignment_unique(current, this) : new EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_0_Assignment_iD(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// iD ?= "ID"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_0_Assignment_iD extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_0_Assignment_iD(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000010000000AssignmentID();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("iD",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("iD");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000100000000KeywordID();
			return new Solution(obj);
		}

		return null;
	}
}

// unique ?= "bag"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_1_Assignment_unique extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_1_Assignment_unique(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000010000001AssignmentUnique();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("unique",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("unique");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000100000010KeywordBag();
			return new Solution(obj);
		}

		return null;
	}
}


// ordered ?= "random"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_1_Assignment_ordered extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_0_1_Assignment_ordered(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000001000001AssignmentOrdered();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ordered",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ordered");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000010000010KeywordRandom();
			return new Solution(obj);
		}

		return null;
	}
}


// changeable ?= "readonly"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_1_Assignment_changeable extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_0_1_Assignment_changeable(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000100001AssignmentChangeable();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("changeable",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("changeable");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000001000010KeywordReadonly();
			return new Solution(obj);
		}

		return null;
	}
}


// volatile ?= "volatile"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_0_1_Assignment_volatile extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_0_0_0_1_Assignment_volatile(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000010001AssignmentVolatile();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("volatile",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("volatile");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000100010KeywordVolatile();
			return new Solution(obj);
		}

		return null;
	}
}


// transient ?= "transient"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_0_1_Assignment_transient extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_0_0_1_Assignment_transient(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000001001AssignmentTransient();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("transient",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("transient");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000010010KeywordTransient();
			return new Solution(obj);
		}

		return null;
	}
}


// unsettable ?= "unsettable"
protected class EAttributeDecl_0_0_0_0_0_0_1_0_1_Assignment_unsettable extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_0_1_Assignment_unsettable(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000101AssignmentUnsettable();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("unsettable",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("unsettable");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0000001010KeywordUnsettable();
			return new Solution(obj);
		}

		return null;
	}
}


// derived ?= "derived"
protected class EAttributeDecl_0_0_0_0_0_0_1_1_Assignment_derived extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_0_0_1_1_Assignment_derived(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00000011AssignmentDerived();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("derived",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("derived");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000000110KeywordDerived();
			return new Solution(obj);
		}

		return null;
	}
}



// "attr"
protected class EAttributeDecl_0_0_0_0_0_1_Keyword_attr extends KeywordToken  {
	
	public EAttributeDecl_0_0_0_0_0_1_Keyword_attr(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000001KeywordAttr();
	}	
}


// eGenericType = EGenericTypeReferenceDecl
protected class EAttributeDecl_0_0_0_0_1_Assignment_eGenericType extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_0_1_Assignment_eGenericType(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00001AssignmentEGenericType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericType",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericType");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ?
protected class EAttributeDecl_0_0_0_1_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "[" lowerBound = INT ( ".." upperBound = SINT ) ?
protected class EAttributeDecl_0_0_0_1_0_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "[" lowerBound = INT
protected class EAttributeDecl_0_0_0_1_0_0_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_1_0_0_1_Assignment_lowerBound(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_1_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "["
protected class EAttributeDecl_0_0_0_1_0_0_0_Keyword extends KeywordToken  {
	
	public EAttributeDecl_0_0_0_1_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0001000KeywordLeftSquareBracket();
	}	
}

// lowerBound = INT
protected class EAttributeDecl_0_0_0_1_0_0_1_Assignment_lowerBound extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_1_0_0_1_Assignment_lowerBound(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0001001AssignmentLowerBound();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("lowerBound",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("lowerBound");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00010010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// ( ".." upperBound = SINT ) ?
protected class EAttributeDecl_0_0_0_1_0_1_Group extends GroupToken {
	
	public EAttributeDecl_0_0_0_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele000101Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_0_0_1_0_1_1_Assignment_upperBound(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_0_0_1_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ".."
protected class EAttributeDecl_0_0_0_1_0_1_0_Keyword extends KeywordToken  {
	
	public EAttributeDecl_0_0_0_1_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0001010KeywordFullStopFullStop();
	}	
}

// upperBound = SINT
protected class EAttributeDecl_0_0_0_1_0_1_1_Assignment_upperBound extends AssignmentToken  {
	
	public EAttributeDecl_0_0_0_1_0_1_1_Assignment_upperBound(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0001011AssignmentUpperBound();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("upperBound",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("upperBound");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00010110ParserRuleCallSINT();
			return new Solution(obj);
		}

		return null;
	}
}



// "]"
protected class EAttributeDecl_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public EAttributeDecl_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele00011KeywordRightSquareBracket();
	}	
}



// name = ID
protected class EAttributeDecl_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EAttributeDecl_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ( "=" defaultValueLiteral = STRING ) ?
protected class EAttributeDecl_0_1_Group extends GroupToken {
	
	public EAttributeDecl_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EAttributeDecl_0_1_1_Assignment_defaultValueLiteral(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EAttributeDecl_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "="
protected class EAttributeDecl_0_1_0_Keyword extends KeywordToken  {
	
	public EAttributeDecl_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele010KeywordEqualsSign();
	}	
}

// defaultValueLiteral = STRING
protected class EAttributeDecl_0_1_1_Assignment_defaultValueLiteral extends AssignmentToken  {
	
	public EAttributeDecl_0_1_1_Assignment_defaultValueLiteral(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele011AssignmentDefaultValueLiteral();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("defaultValueLiteral",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("defaultValueLiteral");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele0110LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}



// ";"
protected class EAttributeDecl_1_Keyword extends KeywordToken  {
	
	public EAttributeDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl().ele1KeywordSemicolon();
	}	
}


/************ end Rule EAttributeDecl ****************/


/************ begin Rule EReferenceDecl ****************
 *
 * EReferenceDecl returns EReference : ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * ( containment ?= "val" | "ref" ) eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? ( "#" eOpposite = [ EReference ] ) ? name = ID ";" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * ( containment ?= "val" | "ref" ) eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? ( "#" eOpposite = [ EReference ] ) ? name = ID ";"
protected class EReferenceDecl_Group extends GroupToken {
	
	public EReferenceDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * ( containment ?= "val" | "ref" ) eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? ( "#" eOpposite = [ EReference ] ) ? name = ID
protected class EReferenceDecl_0_Group extends GroupToken {
	
	public EReferenceDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * ( containment ?= "val" | "ref" ) eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ? ( "#" eOpposite = [ EReference ] ) ?
protected class EReferenceDecl_0_0_Group extends GroupToken {
	
	public EReferenceDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * ( containment ?= "val" | "ref" ) eGenericType = EGenericTypeReferenceDecl ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ?
protected class EReferenceDecl_0_0_0_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * ( containment ?= "val" | "ref" ) eGenericType = EGenericTypeReferenceDecl
protected class EReferenceDecl_0_0_0_0_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_0_1_Assignment_eGenericType(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) * ( containment ?= "val" | "ref" )
protected class EReferenceDecl_0_0_0_0_0_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) *
protected class EReferenceDecl_0_0_0_0_0_0_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EReferenceDecl_0_0_0_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// ( resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable" | derived ?= "derived" ) *
protected class EReferenceDecl_0_0_0_0_0_0_1_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000001Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_0_1_1_Assignment_derived(current, this) : new EReferenceDecl_0_0_0_0_0_0_1_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient" | unsettable ?= "unsettable"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_0_1_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000010Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_0_1_0_1_Assignment_unsettable(current, this) : new EReferenceDecl_0_0_0_0_0_0_1_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile" | transient ?= "transient"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_0_1_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000100Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_0_1_0_0_1_Assignment_transient(current, this) : new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly" | volatile ?= "volatile"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000001000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_1_Assignment_volatile(current, this) : new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random" | changeable ?= "readonly"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000010000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_1_Assignment_changeable(current, this) : new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// resolveProxies ?= "local" | unique ?= "bag" | ordered ?= "random"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000100000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_1_Assignment_ordered(current, this) : new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// resolveProxies ?= "local" | unique ?= "bag"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000001000000Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_1_Assignment_unique(current, this) : new EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_0_Assignment_resolveProxies(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// resolveProxies ?= "local"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_0_Assignment_resolveProxies extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_0_Assignment_resolveProxies(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000010000000AssignmentResolveProxies();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("resolveProxies",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("resolveProxies");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000100000000KeywordLocal();
			return new Solution(obj);
		}

		return null;
	}
}

// unique ?= "bag"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_1_Assignment_unique extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_0_1_Assignment_unique(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000010000001AssignmentUnique();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("unique",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("unique");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000100000010KeywordBag();
			return new Solution(obj);
		}

		return null;
	}
}


// ordered ?= "random"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_1_Assignment_ordered extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_0_1_Assignment_ordered(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000001000001AssignmentOrdered();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ordered",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ordered");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000010000010KeywordRandom();
			return new Solution(obj);
		}

		return null;
	}
}


// changeable ?= "readonly"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_1_Assignment_changeable extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_0_1_Assignment_changeable(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000100001AssignmentChangeable();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("changeable",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("changeable");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000001000010KeywordReadonly();
			return new Solution(obj);
		}

		return null;
	}
}


// volatile ?= "volatile"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_0_1_Assignment_volatile extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_0_0_0_1_Assignment_volatile(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000010001AssignmentVolatile();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("volatile",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("volatile");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000100010KeywordVolatile();
			return new Solution(obj);
		}

		return null;
	}
}


// transient ?= "transient"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_0_1_Assignment_transient extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_0_0_1_Assignment_transient(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000001001AssignmentTransient();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("transient",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("transient");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000010010KeywordTransient();
			return new Solution(obj);
		}

		return null;
	}
}


// unsettable ?= "unsettable"
protected class EReferenceDecl_0_0_0_0_0_0_1_0_1_Assignment_unsettable extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_0_1_Assignment_unsettable(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000101AssignmentUnsettable();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("unsettable",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("unsettable");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000001010KeywordUnsettable();
			return new Solution(obj);
		}

		return null;
	}
}


// derived ?= "derived"
protected class EReferenceDecl_0_0_0_0_0_0_1_1_Assignment_derived extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_0_1_1_Assignment_derived(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000011AssignmentDerived();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("derived",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("derived");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000000110KeywordDerived();
			return new Solution(obj);
		}

		return null;
	}
}



// containment ?= "val" | "ref"
protected class EReferenceDecl_0_0_0_0_0_1_Alternatives extends AlternativesToken {

	public EReferenceDecl_0_0_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000001Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EReferenceDecl_0_0_0_0_0_1_1_Keyword_ref(current, this) : new EReferenceDecl_0_0_0_0_0_1_0_Assignment_containment(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// containment ?= "val"
protected class EReferenceDecl_0_0_0_0_0_1_0_Assignment_containment extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_0_1_0_Assignment_containment(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000010AssignmentContainment();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("containment",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("containment");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00000100KeywordVal();
			return new Solution(obj);
		}

		return null;
	}
}

// "ref"
protected class EReferenceDecl_0_0_0_0_0_1_1_Keyword_ref extends KeywordToken  {
	
	public EReferenceDecl_0_0_0_0_0_1_1_Keyword_ref(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0000011KeywordRef();
	}	
}



// eGenericType = EGenericTypeReferenceDecl
protected class EReferenceDecl_0_0_0_0_1_Assignment_eGenericType extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_0_1_Assignment_eGenericType(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00001AssignmentEGenericType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericType",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericType");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "[" lowerBound = INT ( ".." upperBound = SINT ) ? "]" ) ?
protected class EReferenceDecl_0_0_0_1_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "[" lowerBound = INT ( ".." upperBound = SINT ) ?
protected class EReferenceDecl_0_0_0_1_0_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "[" lowerBound = INT
protected class EReferenceDecl_0_0_0_1_0_0_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_1_0_0_1_Assignment_lowerBound(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_1_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "["
protected class EReferenceDecl_0_0_0_1_0_0_0_Keyword extends KeywordToken  {
	
	public EReferenceDecl_0_0_0_1_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0001000KeywordLeftSquareBracket();
	}	
}

// lowerBound = INT
protected class EReferenceDecl_0_0_0_1_0_0_1_Assignment_lowerBound extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_1_0_0_1_Assignment_lowerBound(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0001001AssignmentLowerBound();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("lowerBound",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("lowerBound");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00010010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// ( ".." upperBound = SINT ) ?
protected class EReferenceDecl_0_0_0_1_0_1_Group extends GroupToken {
	
	public EReferenceDecl_0_0_0_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele000101Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_0_1_0_1_1_Assignment_upperBound(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_0_1_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ".."
protected class EReferenceDecl_0_0_0_1_0_1_0_Keyword extends KeywordToken  {
	
	public EReferenceDecl_0_0_0_1_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0001010KeywordFullStopFullStop();
	}	
}

// upperBound = SINT
protected class EReferenceDecl_0_0_0_1_0_1_1_Assignment_upperBound extends AssignmentToken  {
	
	public EReferenceDecl_0_0_0_1_0_1_1_Assignment_upperBound(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0001011AssignmentUpperBound();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("upperBound",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("upperBound");

		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00010110ParserRuleCallSINT();
			return new Solution(obj);
		}

		return null;
	}
}



// "]"
protected class EReferenceDecl_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public EReferenceDecl_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00011KeywordRightSquareBracket();
	}	
}



// ( "#" eOpposite = [ EReference ] ) ?
protected class EReferenceDecl_0_0_1_Group extends GroupToken {
	
	public EReferenceDecl_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EReferenceDecl_0_0_1_1_Assignment_eOpposite(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EReferenceDecl_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "#"
protected class EReferenceDecl_0_0_1_0_Keyword extends KeywordToken  {
	
	public EReferenceDecl_0_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0010KeywordNumberSign();
	}	
}

// eOpposite = [ EReference ]
protected class EReferenceDecl_0_0_1_1_Assignment_eOpposite extends AssignmentToken  {
	
	public EReferenceDecl_0_0_1_1_Assignment_eOpposite(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele0011AssignmentEOpposite();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eOpposite",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eOpposite");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EReference")) {
				type = AssignmentType.CR;
				element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele00110CrossReferenceEStringEReference(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



// name = ID
protected class EReferenceDecl_0_1_Assignment_name extends AssignmentToken  {
	
	public EReferenceDecl_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele01AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ";"
protected class EReferenceDecl_1_Keyword extends KeywordToken  {
	
	public EReferenceDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEReferenceDecl().ele1KeywordSemicolon();
	}	
}


/************ end Rule EReferenceDecl ****************/


/************ begin Rule EEnumDecl ****************
 *
 * EEnumDecl returns EEnum : ( eAnnotations += EAnnotationDecl ) * "enum" name = ID "{" ( eLiterals += EEnumLiteralDecl ) + "}" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * "enum" name = ID "{" ( eLiterals += EEnumLiteralDecl ) + "}"
protected class EEnumDecl_Group extends GroupToken {
	
	public EEnumDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "enum" name = ID "{" ( eLiterals += EEnumLiteralDecl ) +
protected class EEnumDecl_0_Group extends GroupToken {
	
	public EEnumDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumDecl_0_1_Assignment_eLiterals(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "enum" name = ID "{"
protected class EEnumDecl_0_0_Group extends GroupToken {
	
	public EEnumDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumDecl_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "enum" name = ID
protected class EEnumDecl_0_0_0_Group extends GroupToken {
	
	public EEnumDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumDecl_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * "enum"
protected class EEnumDecl_0_0_0_0_Group extends GroupToken {
	
	public EEnumDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumDecl_0_0_0_0_1_Keyword_enum(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumDecl_0_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EEnumDecl_0_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EEnumDecl_0_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele00000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// "enum"
protected class EEnumDecl_0_0_0_0_1_Keyword_enum extends KeywordToken  {
	
	public EEnumDecl_0_0_0_0_1_Keyword_enum(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele00001KeywordEnum();
	}	
}


// name = ID
protected class EEnumDecl_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EEnumDecl_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele0001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele00010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "{"
protected class EEnumDecl_0_0_1_Keyword extends KeywordToken  {
	
	public EEnumDecl_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele001KeywordLeftCurlyBracket();
	}	
}


// ( eLiterals += EEnumLiteralDecl ) +
protected class EEnumDecl_0_1_Assignment_eLiterals extends AssignmentToken  {
	
	public EEnumDecl_0_1_Assignment_eLiterals(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele01AssignmentELiterals();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eLiterals",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eLiterals");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EEnumLiteral")) {
				Solution s = new EEnumLiteralDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// "}"
protected class EEnumDecl_1_Keyword extends KeywordToken  {
	
	public EEnumDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumDecl().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule EEnumDecl ****************/


/************ begin Rule EEnumLiteralDecl ****************
 *
 * EEnumLiteralDecl returns EEnumLiteral : ( eAnnotations += EAnnotationDecl ) * name = ID ( "=" value = INT ) ? ( literal = STRING ) ? ";" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * name = ID ( "=" value = INT ) ? ( literal = STRING ) ? ";"
protected class EEnumLiteralDecl_Group extends GroupToken {
	
	public EEnumLiteralDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumLiteralDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumLiteralDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * name = ID ( "=" value = INT ) ? ( literal = STRING ) ?
protected class EEnumLiteralDecl_0_Group extends GroupToken {
	
	public EEnumLiteralDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumLiteralDecl_0_1_Assignment_literal(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumLiteralDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * name = ID ( "=" value = INT ) ?
protected class EEnumLiteralDecl_0_0_Group extends GroupToken {
	
	public EEnumLiteralDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumLiteralDecl_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumLiteralDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * name = ID
protected class EEnumLiteralDecl_0_0_0_Group extends GroupToken {
	
	public EEnumLiteralDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumLiteralDecl_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumLiteralDecl_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EEnumLiteralDecl_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EEnumLiteralDecl_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele0000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// name = ID
protected class EEnumLiteralDecl_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EEnumLiteralDecl_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele0001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele00010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ( "=" value = INT ) ?
protected class EEnumLiteralDecl_0_0_1_Group extends GroupToken {
	
	public EEnumLiteralDecl_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EEnumLiteralDecl_0_0_1_1_Assignment_value(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EEnumLiteralDecl_0_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "="
protected class EEnumLiteralDecl_0_0_1_0_Keyword extends KeywordToken  {
	
	public EEnumLiteralDecl_0_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele0010KeywordEqualsSign();
	}	
}

// value = INT
protected class EEnumLiteralDecl_0_0_1_1_Assignment_value extends AssignmentToken  {
	
	public EEnumLiteralDecl_0_0_1_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele0011AssignmentValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("value",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele00110LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}



// ( literal = STRING ) ?
protected class EEnumLiteralDecl_0_1_Assignment_literal extends AssignmentToken  {
	
	public EEnumLiteralDecl_0_1_Assignment_literal(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele01AssignmentLiteral();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("literal",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("literal");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// ";"
protected class EEnumLiteralDecl_1_Keyword extends KeywordToken  {
	
	public EEnumLiteralDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEEnumLiteralDecl().ele1KeywordSemicolon();
	}	
}


/************ end Rule EEnumLiteralDecl ****************/


/************ begin Rule ETypeParameterDecl ****************
 *
 * ETypeParameterDecl returns ETypeParameter : name = ID ( "extends" eBounds += EGenericTypeDecl ) ? ;
 *
 **/


// name = ID ( "extends" eBounds += EGenericTypeDecl ) ?
protected class ETypeParameterDecl_Group extends GroupToken {
	
	public ETypeParameterDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prETypeParameterDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ETypeParameterDecl_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ETypeParameterDecl_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// name = ID
protected class ETypeParameterDecl_0_Assignment_name extends AssignmentToken  {
	
	public ETypeParameterDecl_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prETypeParameterDecl().ele0AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prETypeParameterDecl().ele00LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// ( "extends" eBounds += EGenericTypeDecl ) ?
protected class ETypeParameterDecl_1_Group extends GroupToken {
	
	public ETypeParameterDecl_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prETypeParameterDecl().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new ETypeParameterDecl_1_1_Assignment_eBounds(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ETypeParameterDecl_1_0_Keyword_extends(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "extends"
protected class ETypeParameterDecl_1_0_Keyword_extends extends KeywordToken  {
	
	public ETypeParameterDecl_1_0_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prETypeParameterDecl().ele10KeywordExtends();
	}	
}

// eBounds += EGenericTypeDecl
protected class ETypeParameterDecl_1_1_Assignment_eBounds extends AssignmentToken  {
	
	public ETypeParameterDecl_1_1_Assignment_eBounds(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prETypeParameterDecl().ele11AssignmentEBounds();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eBounds",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eBounds");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



/************ end Rule ETypeParameterDecl ****************/


/************ begin Rule EGenericTypeReferenceDecl ****************
 *
 * EGenericTypeReferenceDecl returns EGenericType : eClassifier = [ EClassifier ] ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ? | "#" eTypeParameter = [ ETypeParameter ] ;
 *
 **/


// eClassifier = [ EClassifier ] ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ? | "#" eTypeParameter = [ ETypeParameter ]
protected class EGenericTypeReferenceDecl_Alternatives extends AlternativesToken {

	public EGenericTypeReferenceDecl_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EGenericTypeReferenceDecl_1_Group(current, this) : new EGenericTypeReferenceDecl_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// eClassifier = [ EClassifier ] ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ?
protected class EGenericTypeReferenceDecl_0_Group extends GroupToken {
	
	public EGenericTypeReferenceDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeReferenceDecl_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeReferenceDecl_0_0_Assignment_eClassifier(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// eClassifier = [ EClassifier ]
protected class EGenericTypeReferenceDecl_0_0_Assignment_eClassifier extends AssignmentToken  {
	
	public EGenericTypeReferenceDecl_0_0_Assignment_eClassifier(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele00AssignmentEClassifier();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eClassifier",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eClassifier");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EClassifier")) {
				type = AssignmentType.CR;
				element = EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele000CrossReferenceEStringEClassifier(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ?
protected class EGenericTypeReferenceDecl_0_1_Group extends GroupToken {
	
	public EGenericTypeReferenceDecl_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeReferenceDecl_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeReferenceDecl_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) *
protected class EGenericTypeReferenceDecl_0_1_0_Group extends GroupToken {
	
	public EGenericTypeReferenceDecl_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeReferenceDecl_0_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeReferenceDecl_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeArguments += EGenericTypeDecl
protected class EGenericTypeReferenceDecl_0_1_0_0_Group extends GroupToken {
	
	public EGenericTypeReferenceDecl_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele0100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeReferenceDecl_0_1_0_0_1_Assignment_eTypeArguments(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeReferenceDecl_0_1_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<"
protected class EGenericTypeReferenceDecl_0_1_0_0_0_Keyword extends KeywordToken  {
	
	public EGenericTypeReferenceDecl_0_1_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele01000KeywordLessThanSign();
	}	
}

// eTypeArguments += EGenericTypeDecl
protected class EGenericTypeReferenceDecl_0_1_0_0_1_Assignment_eTypeArguments extends AssignmentToken  {
	
	public EGenericTypeReferenceDecl_0_1_0_0_1_Assignment_eTypeArguments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele01001AssignmentETypeArguments();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeArguments",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeArguments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "," eTypeArguments += EGenericTypeDecl ) *
protected class EGenericTypeReferenceDecl_0_1_0_1_Group extends GroupToken {
	
	public EGenericTypeReferenceDecl_0_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele0101Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeReferenceDecl_0_1_0_1_1_Assignment_eTypeArguments(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeReferenceDecl_0_1_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EGenericTypeReferenceDecl_0_1_0_1_0_Keyword extends KeywordToken  {
	
	public EGenericTypeReferenceDecl_0_1_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele01010KeywordComma();
	}	
}

// eTypeArguments += EGenericTypeDecl
protected class EGenericTypeReferenceDecl_0_1_0_1_1_Assignment_eTypeArguments extends AssignmentToken  {
	
	public EGenericTypeReferenceDecl_0_1_0_1_1_Assignment_eTypeArguments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele01011AssignmentETypeArguments();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeArguments",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeArguments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// ">"
protected class EGenericTypeReferenceDecl_0_1_1_Keyword extends KeywordToken  {
	
	public EGenericTypeReferenceDecl_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele011KeywordGreaterThanSign();
	}	
}



// "#" eTypeParameter = [ ETypeParameter ]
protected class EGenericTypeReferenceDecl_1_Group extends GroupToken {
	
	public EGenericTypeReferenceDecl_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeReferenceDecl_1_1_Assignment_eTypeParameter(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeReferenceDecl_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "#"
protected class EGenericTypeReferenceDecl_1_0_Keyword extends KeywordToken  {
	
	public EGenericTypeReferenceDecl_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele10KeywordNumberSign();
	}	
}

// eTypeParameter = [ ETypeParameter ]
protected class EGenericTypeReferenceDecl_1_1_Assignment_eTypeParameter extends AssignmentToken  {
	
	public EGenericTypeReferenceDecl_1_1_Assignment_eTypeParameter(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele11AssignmentETypeParameter();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeParameter",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeParameter");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ETypeParameter")) {
				type = AssignmentType.CR;
				element = EcoreDslGrammarAccess.INSTANCE.prEGenericTypeReferenceDecl().ele110CrossReferenceEStringETypeParameter(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



/************ end Rule EGenericTypeReferenceDecl ****************/


/************ begin Rule EGenericTypeDecl ****************
 *
 * EGenericTypeDecl returns EGenericType : eClassifier = [ EClassifier ] ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ? | "#" eTypeParameter = [ ETypeParameter ] | "?" ( "extends" eUpperBound = EGenericTypeDecl | "super" eLowerBound = EGenericTypeDecl ) ;
 *
 **/


// eClassifier = [ EClassifier ] ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ? | "#" eTypeParameter = [ ETypeParameter ] | "?" ( "extends" eUpperBound = EGenericTypeDecl | "super" eLowerBound = EGenericTypeDecl )
protected class EGenericTypeDecl_Alternatives extends AlternativesToken {

	public EGenericTypeDecl_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EGenericTypeDecl_1_Group(current, this) : new EGenericTypeDecl_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// eClassifier = [ EClassifier ] ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ? | "#" eTypeParameter = [ ETypeParameter ]
protected class EGenericTypeDecl_0_Alternatives extends AlternativesToken {

	public EGenericTypeDecl_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele0Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EGenericTypeDecl_0_1_Group(current, this) : new EGenericTypeDecl_0_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// eClassifier = [ EClassifier ] ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ?
protected class EGenericTypeDecl_0_0_Group extends GroupToken {
	
	public EGenericTypeDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_0_0_0_Assignment_eClassifier(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// eClassifier = [ EClassifier ]
protected class EGenericTypeDecl_0_0_0_Assignment_eClassifier extends AssignmentToken  {
	
	public EGenericTypeDecl_0_0_0_Assignment_eClassifier(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele000AssignmentEClassifier();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eClassifier",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eClassifier");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EClassifier")) {
				type = AssignmentType.CR;
				element = EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele0000CrossReferenceEStringEClassifier(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// ( "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) * ">" ) ?
protected class EGenericTypeDecl_0_0_1_Group extends GroupToken {
	
	public EGenericTypeDecl_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeArguments += EGenericTypeDecl ( "," eTypeArguments += EGenericTypeDecl ) *
protected class EGenericTypeDecl_0_0_1_0_Group extends GroupToken {
	
	public EGenericTypeDecl_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele0010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_0_0_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeArguments += EGenericTypeDecl
protected class EGenericTypeDecl_0_0_1_0_0_Group extends GroupToken {
	
	public EGenericTypeDecl_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele00100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_0_0_1_0_0_1_Assignment_eTypeArguments(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_0_0_1_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<"
protected class EGenericTypeDecl_0_0_1_0_0_0_Keyword extends KeywordToken  {
	
	public EGenericTypeDecl_0_0_1_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele001000KeywordLessThanSign();
	}	
}

// eTypeArguments += EGenericTypeDecl
protected class EGenericTypeDecl_0_0_1_0_0_1_Assignment_eTypeArguments extends AssignmentToken  {
	
	public EGenericTypeDecl_0_0_1_0_0_1_Assignment_eTypeArguments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele001001AssignmentETypeArguments();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeArguments",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeArguments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "," eTypeArguments += EGenericTypeDecl ) *
protected class EGenericTypeDecl_0_0_1_0_1_Group extends GroupToken {
	
	public EGenericTypeDecl_0_0_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele00101Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_0_0_1_0_1_1_Assignment_eTypeArguments(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_0_0_1_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EGenericTypeDecl_0_0_1_0_1_0_Keyword extends KeywordToken  {
	
	public EGenericTypeDecl_0_0_1_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele001010KeywordComma();
	}	
}

// eTypeArguments += EGenericTypeDecl
protected class EGenericTypeDecl_0_0_1_0_1_1_Assignment_eTypeArguments extends AssignmentToken  {
	
	public EGenericTypeDecl_0_0_1_0_1_1_Assignment_eTypeArguments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele001011AssignmentETypeArguments();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeArguments",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeArguments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// ">"
protected class EGenericTypeDecl_0_0_1_1_Keyword extends KeywordToken  {
	
	public EGenericTypeDecl_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele0011KeywordGreaterThanSign();
	}	
}



// "#" eTypeParameter = [ ETypeParameter ]
protected class EGenericTypeDecl_0_1_Group extends GroupToken {
	
	public EGenericTypeDecl_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_0_1_1_Assignment_eTypeParameter(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "#"
protected class EGenericTypeDecl_0_1_0_Keyword extends KeywordToken  {
	
	public EGenericTypeDecl_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele010KeywordNumberSign();
	}	
}

// eTypeParameter = [ ETypeParameter ]
protected class EGenericTypeDecl_0_1_1_Assignment_eTypeParameter extends AssignmentToken  {
	
	public EGenericTypeDecl_0_1_1_Assignment_eTypeParameter(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele011AssignmentETypeParameter();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeParameter",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeParameter");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ETypeParameter")) {
				type = AssignmentType.CR;
				element = EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele0110CrossReferenceEStringETypeParameter(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



// "?" ( "extends" eUpperBound = EGenericTypeDecl | "super" eLowerBound = EGenericTypeDecl )
protected class EGenericTypeDecl_1_Group extends GroupToken {
	
	public EGenericTypeDecl_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_1_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "?"
protected class EGenericTypeDecl_1_0_Keyword extends KeywordToken  {
	
	public EGenericTypeDecl_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele10KeywordQuestionMark();
	}	
}

// "extends" eUpperBound = EGenericTypeDecl | "super" eLowerBound = EGenericTypeDecl
protected class EGenericTypeDecl_1_1_Alternatives extends AlternativesToken {

	public EGenericTypeDecl_1_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele11Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EGenericTypeDecl_1_1_1_Group(current, this) : new EGenericTypeDecl_1_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "extends" eUpperBound = EGenericTypeDecl
protected class EGenericTypeDecl_1_1_0_Group extends GroupToken {
	
	public EGenericTypeDecl_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele110Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_1_1_0_1_Assignment_eUpperBound(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_1_1_0_0_Keyword_extends(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "extends"
protected class EGenericTypeDecl_1_1_0_0_Keyword_extends extends KeywordToken  {
	
	public EGenericTypeDecl_1_1_0_0_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele1100KeywordExtends();
	}	
}

// eUpperBound = EGenericTypeDecl
protected class EGenericTypeDecl_1_1_0_1_Assignment_eUpperBound extends AssignmentToken  {
	
	public EGenericTypeDecl_1_1_0_1_Assignment_eUpperBound(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele1101AssignmentEUpperBound();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eUpperBound",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eUpperBound");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// "super" eLowerBound = EGenericTypeDecl
protected class EGenericTypeDecl_1_1_1_Group extends GroupToken {
	
	public EGenericTypeDecl_1_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele111Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EGenericTypeDecl_1_1_1_1_Assignment_eLowerBound(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EGenericTypeDecl_1_1_1_0_Keyword_super(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "super"
protected class EGenericTypeDecl_1_1_1_0_Keyword_super extends KeywordToken  {
	
	public EGenericTypeDecl_1_1_1_0_Keyword_super(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele1110KeywordSuper();
	}	
}

// eLowerBound = EGenericTypeDecl
protected class EGenericTypeDecl_1_1_1_1_Assignment_eLowerBound extends AssignmentToken  {
	
	public EGenericTypeDecl_1_1_1_1_Assignment_eLowerBound(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEGenericTypeDecl().ele1111AssignmentELowerBound();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eLowerBound",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eLowerBound");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}





/************ end Rule EGenericTypeDecl ****************/


/************ begin Rule EOperationDecl ****************
 *
 * EOperationDecl returns EOperation : ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? "(" ( eParameters += EParameterDecl ( "," eParameters += EParameterDecl ) * ) ? ")" ( "throws" eGenericExceptions += EGenericTypeReferenceDecl ( "," eGenericExceptions += EGenericTypeReferenceDecl ) * ) ? ";" ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? "(" ( eParameters += EParameterDecl ( "," eParameters += EParameterDecl ) * ) ? ")" ( "throws" eGenericExceptions += EGenericTypeReferenceDecl ( "," eGenericExceptions += EGenericTypeReferenceDecl ) * ) ? ";"
protected class EOperationDecl_Group extends GroupToken {
	
	public EOperationDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? "(" ( eParameters += EParameterDecl ( "," eParameters += EParameterDecl ) * ) ? ")" ( "throws" eGenericExceptions += EGenericTypeReferenceDecl ( "," eGenericExceptions += EGenericTypeReferenceDecl ) * ) ?
protected class EOperationDecl_0_Group extends GroupToken {
	
	public EOperationDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? "(" ( eParameters += EParameterDecl ( "," eParameters += EParameterDecl ) * ) ? ")"
protected class EOperationDecl_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? "(" ( eParameters += EParameterDecl ( "," eParameters += EParameterDecl ) * ) ?
protected class EOperationDecl_0_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ? "("
protected class EOperationDecl_0_0_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ?
protected class EOperationDecl_0_0_0_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" ) name = ID
protected class EOperationDecl_0_0_0_0_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op" ( eGenericType = EGenericTypeReferenceDecl | "void" )
protected class EOperationDecl_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) * "op"
protected class EOperationDecl_0_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_0_0_0_1_Keyword_op(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * ( unique ?= "bag" | ordered ?= "random" ) *
protected class EOperationDecl_0_0_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000000000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_0_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EOperationDecl_0_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_0_0_0_0_0_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0000000000AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// ( unique ?= "bag" | ordered ?= "random" ) *
protected class EOperationDecl_0_0_0_0_0_0_0_0_0_1_Alternatives extends AlternativesToken {

	public EOperationDecl_0_0_0_0_0_0_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0000000001Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EOperationDecl_0_0_0_0_0_0_0_0_0_1_1_Assignment_ordered(current, this) : new EOperationDecl_0_0_0_0_0_0_0_0_0_1_0_Assignment_unique(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// unique ?= "bag"
protected class EOperationDecl_0_0_0_0_0_0_0_0_0_1_0_Assignment_unique extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_0_0_0_0_0_0_1_0_Assignment_unique(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000000010AssignmentUnique();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("unique",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("unique");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000000000100KeywordBag();
			return new Solution(obj);
		}

		return null;
	}
}

// ordered ?= "random"
protected class EOperationDecl_0_0_0_0_0_0_0_0_0_1_1_Assignment_ordered extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_0_0_0_0_0_0_1_1_Assignment_ordered(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000000011AssignmentOrdered();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("ordered",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("ordered");

		if(Boolean.TRUE.equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000000000110KeywordRandom();
			return new Solution(obj);
		}

		return null;
	}
}



// "op"
protected class EOperationDecl_0_0_0_0_0_0_0_0_1_Keyword_op extends KeywordToken  {
	
	public EOperationDecl_0_0_0_0_0_0_0_0_1_Keyword_op(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000000001KeywordOp();
	}	
}


// eGenericType = EGenericTypeReferenceDecl | "void"
protected class EOperationDecl_0_0_0_0_0_0_0_1_Alternatives extends AlternativesToken {

	public EOperationDecl_0_0_0_0_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000001Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new EOperationDecl_0_0_0_0_0_0_0_1_1_Keyword_void(current, this) : new EOperationDecl_0_0_0_0_0_0_0_1_0_Assignment_eGenericType(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// eGenericType = EGenericTypeReferenceDecl
protected class EOperationDecl_0_0_0_0_0_0_0_1_0_Assignment_eGenericType extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_0_0_0_0_1_0_Assignment_eGenericType(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000000010AssignmentEGenericType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericType",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericType");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// "void"
protected class EOperationDecl_0_0_0_0_0_0_0_1_1_Keyword_void extends KeywordToken  {
	
	public EOperationDecl_0_0_0_0_0_0_0_1_1_Keyword_void(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000000011KeywordVoid();
	}	
}



// name = ID
protected class EOperationDecl_0_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0000001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ( "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) * ">" ) ?
protected class EOperationDecl_0_0_0_0_0_1_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeParameters += ETypeParameterDecl ( "," eTypeParameters += ETypeParameterDecl ) *
protected class EOperationDecl_0_0_0_0_0_1_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0000010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<" eTypeParameters += ETypeParameterDecl
protected class EOperationDecl_0_0_0_0_0_1_0_0_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000100Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_1_0_0_1_Assignment_eTypeParameters(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_1_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "<"
protected class EOperationDecl_0_0_0_0_0_1_0_0_0_Keyword extends KeywordToken  {
	
	public EOperationDecl_0_0_0_0_0_1_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000001000KeywordLessThanSign();
	}	
}

// eTypeParameters += ETypeParameterDecl
protected class EOperationDecl_0_0_0_0_0_1_0_0_1_Assignment_eTypeParameters extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_0_0_1_0_0_1_Assignment_eTypeParameters(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000001001AssignmentETypeParameters();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeParameters",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeParameters");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ETypeParameter")) {
				Solution s = new ETypeParameterDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "," eTypeParameters += ETypeParameterDecl ) *
protected class EOperationDecl_0_0_0_0_0_1_0_1_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_0_0_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00000101Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_0_0_1_0_1_1_Assignment_eTypeParameters(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_0_0_1_0_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EOperationDecl_0_0_0_0_0_1_0_1_0_Keyword extends KeywordToken  {
	
	public EOperationDecl_0_0_0_0_0_1_0_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000001010KeywordComma();
	}	
}

// eTypeParameters += ETypeParameterDecl
protected class EOperationDecl_0_0_0_0_0_1_0_1_1_Assignment_eTypeParameters extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_0_0_1_0_1_1_Assignment_eTypeParameters(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000001011AssignmentETypeParameters();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eTypeParameters",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eTypeParameters");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ETypeParameter")) {
				Solution s = new ETypeParameterDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}



// ">"
protected class EOperationDecl_0_0_0_0_0_1_1_Keyword extends KeywordToken  {
	
	public EOperationDecl_0_0_0_0_0_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0000011KeywordGreaterThanSign();
	}	
}



// "("
protected class EOperationDecl_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public EOperationDecl_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00001KeywordLeftParenthesis();
	}	
}


// ( eParameters += EParameterDecl ( "," eParameters += EParameterDecl ) * ) ?
protected class EOperationDecl_0_0_0_1_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_1_0_Assignment_eParameters(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// eParameters += EParameterDecl
protected class EOperationDecl_0_0_0_1_0_Assignment_eParameters extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_1_0_Assignment_eParameters(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00010AssignmentEParameters();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eParameters",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eParameters");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EParameter")) {
				Solution s = new EParameterDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// ( "," eParameters += EParameterDecl ) *
protected class EOperationDecl_0_0_0_1_1_Group extends GroupToken {
	
	public EOperationDecl_0_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele00011Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_0_0_1_1_1_Assignment_eParameters(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EOperationDecl_0_0_0_1_1_0_Keyword extends KeywordToken  {
	
	public EOperationDecl_0_0_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000110KeywordComma();
	}	
}

// eParameters += EParameterDecl
protected class EOperationDecl_0_0_0_1_1_1_Assignment_eParameters extends AssignmentToken  {
	
	public EOperationDecl_0_0_0_1_1_1_Assignment_eParameters(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele000111AssignmentEParameters();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eParameters",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eParameters");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EParameter")) {
				Solution s = new EParameterDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}




// ")"
protected class EOperationDecl_0_0_1_Keyword extends KeywordToken  {
	
	public EOperationDecl_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele001KeywordRightParenthesis();
	}	
}


// ( "throws" eGenericExceptions += EGenericTypeReferenceDecl ( "," eGenericExceptions += EGenericTypeReferenceDecl ) * ) ?
protected class EOperationDecl_0_1_Group extends GroupToken {
	
	public EOperationDecl_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele01Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "throws" eGenericExceptions += EGenericTypeReferenceDecl
protected class EOperationDecl_0_1_0_Group extends GroupToken {
	
	public EOperationDecl_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele010Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_1_0_1_Assignment_eGenericExceptions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_1_0_0_Keyword_throws(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// "throws"
protected class EOperationDecl_0_1_0_0_Keyword_throws extends KeywordToken  {
	
	public EOperationDecl_0_1_0_0_Keyword_throws(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0100KeywordThrows();
	}	
}

// eGenericExceptions += EGenericTypeReferenceDecl
protected class EOperationDecl_0_1_0_1_Assignment_eGenericExceptions extends AssignmentToken  {
	
	public EOperationDecl_0_1_0_1_Assignment_eGenericExceptions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0101AssignmentEGenericExceptions();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericExceptions",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericExceptions");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// ( "," eGenericExceptions += EGenericTypeReferenceDecl ) *
protected class EOperationDecl_0_1_1_Group extends GroupToken {
	
	public EOperationDecl_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele011Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EOperationDecl_0_1_1_1_Assignment_eGenericExceptions(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EOperationDecl_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ","
protected class EOperationDecl_0_1_1_0_Keyword extends KeywordToken  {
	
	public EOperationDecl_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0110KeywordComma();
	}	
}

// eGenericExceptions += EGenericTypeReferenceDecl
protected class EOperationDecl_0_1_1_1_Assignment_eGenericExceptions extends AssignmentToken  {
	
	public EOperationDecl_0_1_1_1_Assignment_eGenericExceptions(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele0111AssignmentEGenericExceptions();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericExceptions",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericExceptions");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}




// ";"
protected class EOperationDecl_1_Keyword extends KeywordToken  {
	
	public EOperationDecl_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEOperationDecl().ele1KeywordSemicolon();
	}	
}


/************ end Rule EOperationDecl ****************/


/************ begin Rule EParameterDecl ****************
 *
 * EParameterDecl returns EParameter : ( eAnnotations += EAnnotationDecl ) * eGenericType = EGenericTypeReferenceDecl name = ID ;
 *
 **/


// ( eAnnotations += EAnnotationDecl ) * eGenericType = EGenericTypeReferenceDecl name = ID
protected class EParameterDecl_Group extends GroupToken {
	
	public EParameterDecl_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEParameterDecl().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EParameterDecl_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EParameterDecl_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) * eGenericType = EGenericTypeReferenceDecl
protected class EParameterDecl_0_Group extends GroupToken {
	
	public EParameterDecl_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEParameterDecl().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new EParameterDecl_0_1_Assignment_eGenericType(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EParameterDecl_0_0_Assignment_eAnnotations(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// ( eAnnotations += EAnnotationDecl ) *
protected class EParameterDecl_0_0_Assignment_eAnnotations extends AssignmentToken  {
	
	public EParameterDecl_0_0_Assignment_eAnnotations(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEParameterDecl().ele00AssignmentEAnnotations();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eAnnotations",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eAnnotations");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EAnnotation")) {
				Solution s = new EAnnotationDecl_Group(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}

// eGenericType = EGenericTypeReferenceDecl
protected class EParameterDecl_0_1_Assignment_eGenericType extends AssignmentToken  {
	
	public EParameterDecl_0_1_Assignment_eGenericType(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEParameterDecl().ele01AssignmentEGenericType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("eGenericType",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eGenericType");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("EGenericType")) {
				Solution s = new EGenericTypeReferenceDecl_Alternatives(param, this).firstSolution();
				while(s != null && !isConsumed(s,this)) s = s.getPredecessor().nextSolution(this,s);
				if(s != null) {
					type = AssignmentType.PRC; 
					return new Solution(obj,s.getPredecessor());
				} 
			}
		}

		return null;
	}
}


// name = ID
protected class EParameterDecl_1_Assignment_name extends AssignmentToken  {
	
	public EParameterDecl_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prEParameterDecl().ele1AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prEParameterDecl().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule EParameterDecl ****************/


/************ begin Rule MapEntrySuper ****************
 *
 * MapEntrySuper returns EObject : MapEntry ;
 *
 **/


// MapEntry
protected class MapEntrySuper_RuleCall_MapEntry extends RuleCallToken {
	
	public MapEntrySuper_RuleCall_MapEntry(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMapEntrySuper().eleParserRuleCallMapEntry();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(MapEntry_Group.class, current)) return null;
		if(!current.isInstanceOf("MapEntry")) return null;
		return new MapEntry_Group(current, this).firstSolution();
	}
}

/************ end Rule MapEntrySuper ****************/


/************ begin Rule MapEntry ****************
 *
 * MapEntry : detailKey = ID "=" detailValue = STRING ;
 *
 **/


// detailKey = ID "=" detailValue = STRING
protected class MapEntry_Group extends GroupToken {
	
	public MapEntry_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMapEntry().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new MapEntry_1_Assignment_detailValue(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MapEntry_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// detailKey = ID "="
protected class MapEntry_0_Group extends GroupToken {
	
	public MapEntry_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMapEntry().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new MapEntry_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MapEntry_0_0_Assignment_detailKey(s1.getCurrent(), s1.getPredecessor()).firstSolution();
			if(s2 == null) {
				s1 = s1.getPredecessor().nextSolution(this,s1);
				if(s1 == null) return null;
			} else {
				last = s2.getPredecessor();
				return s2;
			}
		}
		return null;
		
	}
}

// detailKey = ID
protected class MapEntry_0_0_Assignment_detailKey extends AssignmentToken  {
	
	public MapEntry_0_0_Assignment_detailKey(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMapEntry().ele00AssignmentDetailKey();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("detailKey",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("detailKey");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prMapEntry().ele000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "="
protected class MapEntry_0_1_Keyword extends KeywordToken  {
	
	public MapEntry_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMapEntry().ele01KeywordEqualsSign();
	}	
}


// detailValue = STRING
protected class MapEntry_1_Assignment_detailValue extends AssignmentToken  {
	
	public MapEntry_1_Assignment_detailValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMapEntry().ele1AssignmentDetailValue();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("detailValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("detailValue");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EcoreDslGrammarAccess.INSTANCE.prMapEntry().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule MapEntry ****************/


/************ begin Rule MultiplicityExpr ****************
 *
 * MultiplicityExpr : "+" | "?" | "*" ;
 *
 **/


// "+" | "?" | "*"
protected class MultiplicityExpr_Alternatives extends AlternativesToken {

	public MultiplicityExpr_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMultiplicityExpr().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new MultiplicityExpr_1_Keyword(current, this) : new MultiplicityExpr_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "+" | "?"
protected class MultiplicityExpr_0_Alternatives extends AlternativesToken {

	public MultiplicityExpr_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMultiplicityExpr().ele0Alternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new MultiplicityExpr_0_1_Keyword(current, this) : new MultiplicityExpr_0_0_Keyword(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "+"
protected class MultiplicityExpr_0_0_Keyword extends KeywordToken  {
	
	public MultiplicityExpr_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMultiplicityExpr().ele00KeywordPlusSign();
	}	
}

// "?"
protected class MultiplicityExpr_0_1_Keyword extends KeywordToken  {
	
	public MultiplicityExpr_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMultiplicityExpr().ele01KeywordQuestionMark();
	}	
}


// "*"
protected class MultiplicityExpr_1_Keyword extends KeywordToken  {
	
	public MultiplicityExpr_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EcoreDslGrammarAccess.INSTANCE.prMultiplicityExpr().ele1KeywordAsterisk();
	}	
}


/************ end Rule MultiplicityExpr ****************/




}
