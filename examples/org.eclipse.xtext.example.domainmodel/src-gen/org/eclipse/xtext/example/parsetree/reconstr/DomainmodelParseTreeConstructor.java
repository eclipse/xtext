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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;


public class DomainmodelParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("File") && (s = new File_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Import") && (s = new Import_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("NamedElement") && (s = new NamedElement_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Package") && (s = new Package_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Type") && (s = new Type_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("DataType") && (s = new DataType_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Entity") && (s = new Entity_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Feature") && (s = new Feature_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("StructuralFeature") && (s = new StructuralFeature_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Attribute") && (s = new Attribute_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Reference") && (s = new Reference_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Operation") && (s = new Operation_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Parameter") && (s = new Parameter_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TypedElement") && (s = new TypedElement_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("TypeRef") && (s = new TypeRef_Assignment_referenced(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule File ****************
 *
 * File : ( imports += Import ) * ( namedElements += NamedElement ) * ;
 *
 **/


// ( imports += Import ) * ( namedElements += NamedElement ) *
protected class File_Group extends GroupToken {
	
	public File_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prFile().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new File_1_Assignment_namedElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new File_0_Assignment_imports(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ( imports += Import ) *
protected class File_0_Assignment_imports extends AssignmentToken  {
	
	public File_0_Assignment_imports(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prFile().ele0AssignmentImports();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("imports",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("imports");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Import")) {
				Solution s = new Import_Group(param, this).firstSolution();
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

// ( namedElements += NamedElement ) *
protected class File_1_Assignment_namedElements extends AssignmentToken  {
	
	public File_1_Assignment_namedElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prFile().ele1AssignmentNamedElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("namedElements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("namedElements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedElement")) {
				Solution s = new NamedElement_Alternatives(param, this).firstSolution();
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


/************ end Rule File ****************/


/************ begin Rule Import ****************
 *
 * Import : 'import' importURI = STRING ;
 *
 **/


// 'import' importURI = STRING
protected class Import_Group extends GroupToken {
	
	public Import_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prImport().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Import_1_Assignment_importURI(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Import_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'import'
protected class Import_0_Keyword_import extends KeywordToken  {
	
	public Import_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prImport().ele0KeywordImport();
	}	
}

// importURI = STRING
protected class Import_1_Assignment_importURI extends AssignmentToken  {
	
	public Import_1_Assignment_importURI(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prImport().ele1AssignmentImportURI();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("importURI",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("importURI");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = DomainmodelGrammarAccess.INSTANCE.prImport().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule Import ****************/


/************ begin Rule NamedElement ****************
 *
 * NamedElement : Package | Type ;
 *
 **/


// Package | Type
protected class NamedElement_Alternatives extends AlternativesToken {

	public NamedElement_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prNamedElement().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new NamedElement_1_RuleCall_Type(current, this) : new NamedElement_0_RuleCall_Package(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Package
protected class NamedElement_0_RuleCall_Package extends RuleCallToken {
	
	public NamedElement_0_RuleCall_Package(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prNamedElement().ele0ParserRuleCallPackage();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Package_Group.class, current)) return null;
		if(!current.isInstanceOf("Package")) return null;
		return new Package_Group(current, this).firstSolution();
	}
}

// Type
protected class NamedElement_1_RuleCall_Type extends RuleCallToken {
	
	public NamedElement_1_RuleCall_Type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prNamedElement().ele1ParserRuleCallType();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Type_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("Type")) return null;
		return new Type_Alternatives(current, this).firstSolution();
	}
}


/************ end Rule NamedElement ****************/


/************ begin Rule Package ****************
 *
 * Package : 'package' name = QualifiedName '{' ( namedElements += NamedElement ) * '}' ;
 *
 **/


// 'package' name = QualifiedName '{' ( namedElements += NamedElement ) * '}'
protected class Package_Group extends GroupToken {
	
	public Package_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Package_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Package_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'package' name = QualifiedName '{' ( namedElements += NamedElement ) *
protected class Package_0_Group extends GroupToken {
	
	public Package_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Package_0_1_Assignment_namedElements(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Package_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'package' name = QualifiedName '{'
protected class Package_0_0_Group extends GroupToken {
	
	public Package_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Package_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Package_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'package' name = QualifiedName
protected class Package_0_0_0_Group extends GroupToken {
	
	public Package_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Package_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Package_0_0_0_0_Keyword_package(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'package'
protected class Package_0_0_0_0_Keyword_package extends KeywordToken  {
	
	public Package_0_0_0_0_Keyword_package(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele0000KeywordPackage();
	}	
}

// name = QualifiedName
protected class Package_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Package_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele0001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");

		if(true) { // xtext::RuleCall FIXME: check if value is valid for datatype rule
			type = AssignmentType.PRC;
			element = DomainmodelGrammarAccess.INSTANCE.prPackage().ele00010ParserRuleCallQualifiedName();
			return new Solution(obj);
		}

		return null;
	}
}


// '{'
protected class Package_0_0_1_Keyword extends KeywordToken  {
	
	public Package_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele001KeywordLeftCurlyBracket();
	}	
}


// ( namedElements += NamedElement ) *
protected class Package_0_1_Assignment_namedElements extends AssignmentToken  {
	
	public Package_0_1_Assignment_namedElements(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele01AssignmentNamedElements();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("namedElements",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("namedElements");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedElement")) {
				Solution s = new NamedElement_Alternatives(param, this).firstSolution();
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


// '}'
protected class Package_1_Keyword extends KeywordToken  {
	
	public Package_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule Package ****************/


/************ begin Rule Type ****************
 *
 * Type : Entity | DataType ;
 *
 **/


// Entity | DataType
protected class Type_Alternatives extends AlternativesToken {

	public Type_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prType().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Type_1_RuleCall_DataType(current, this) : new Type_0_RuleCall_Entity(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Entity
protected class Type_0_RuleCall_Entity extends RuleCallToken {
	
	public Type_0_RuleCall_Entity(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prType().ele0ParserRuleCallEntity();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Entity_Group.class, current)) return null;
		if(!current.isInstanceOf("Entity")) return null;
		return new Entity_Group(current, this).firstSolution();
	}
}

// DataType
protected class Type_1_RuleCall_DataType extends RuleCallToken {
	
	public Type_1_RuleCall_DataType(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prType().ele1ParserRuleCallDataType();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(DataType_Group.class, current)) return null;
		if(!current.isInstanceOf("DataType")) return null;
		return new DataType_Group(current, this).firstSolution();
	}
}


/************ end Rule Type ****************/


/************ begin Rule DataType ****************
 *
 * DataType : 'datatype' name = ID ;
 *
 **/


// 'datatype' name = ID
protected class DataType_Group extends GroupToken {
	
	public DataType_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prDataType().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new DataType_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new DataType_0_Keyword_datatype(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'datatype'
protected class DataType_0_Keyword_datatype extends KeywordToken  {
	
	public DataType_0_Keyword_datatype(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prDataType().ele0KeywordDatatype();
	}	
}

// name = ID
protected class DataType_1_Assignment_name extends AssignmentToken  {
	
	public DataType_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prDataType().ele1AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = DomainmodelGrammarAccess.INSTANCE.prDataType().ele10LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule DataType ****************/


/************ begin Rule Entity ****************
 *
 * Entity : 'entity' name = ID ( 'extends' superType = [ Entity ] ) ? '{' ( features += Feature ) * '}' ;
 *
 **/


// 'entity' name = ID ( 'extends' superType = [ Entity ] ) ? '{' ( features += Feature ) * '}'
protected class Entity_Group extends GroupToken {
	
	public Entity_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Entity_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Entity_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'entity' name = ID ( 'extends' superType = [ Entity ] ) ? '{' ( features += Feature ) *
protected class Entity_0_Group extends GroupToken {
	
	public Entity_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Entity_0_1_Assignment_features(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Entity_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'entity' name = ID ( 'extends' superType = [ Entity ] ) ? '{'
protected class Entity_0_0_Group extends GroupToken {
	
	public Entity_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Entity_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Entity_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'entity' name = ID ( 'extends' superType = [ Entity ] ) ?
protected class Entity_0_0_0_Group extends GroupToken {
	
	public Entity_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Entity_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Entity_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'entity' name = ID
protected class Entity_0_0_0_0_Group extends GroupToken {
	
	public Entity_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Entity_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Entity_0_0_0_0_0_Keyword_entity(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'entity'
protected class Entity_0_0_0_0_0_Keyword_entity extends KeywordToken  {
	
	public Entity_0_0_0_0_0_Keyword_entity(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele00000KeywordEntity();
	}	
}

// name = ID
protected class Entity_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Entity_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele00001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = DomainmodelGrammarAccess.INSTANCE.prEntity().ele000010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ( 'extends' superType = [ Entity ] ) ?
protected class Entity_0_0_0_1_Group extends GroupToken {
	
	public Entity_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Entity_0_0_0_1_1_Assignment_superType(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Entity_0_0_0_1_0_Keyword_extends(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'extends'
protected class Entity_0_0_0_1_0_Keyword_extends extends KeywordToken  {
	
	public Entity_0_0_0_1_0_Keyword_extends(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele00010KeywordExtends();
	}	
}

// superType = [ Entity ]
protected class Entity_0_0_0_1_1_Assignment_superType extends AssignmentToken  {
	
	public Entity_0_0_0_1_1_Assignment_superType(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele00011AssignmentSuperType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("superType",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("superType");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Entity")) {
				type = AssignmentType.CR;
				element = DomainmodelGrammarAccess.INSTANCE.prEntity().ele000110CrossReferenceEStringEntity(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



// '{'
protected class Entity_0_0_1_Keyword extends KeywordToken  {
	
	public Entity_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele001KeywordLeftCurlyBracket();
	}	
}


// ( features += Feature ) *
protected class Entity_0_1_Assignment_features extends AssignmentToken  {
	
	public Entity_0_1_Assignment_features(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele01AssignmentFeatures();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("features",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("features");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Feature")) {
				Solution s = new Feature_Alternatives(param, this).firstSolution();
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


// '}'
protected class Entity_1_Keyword extends KeywordToken  {
	
	public Entity_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule Entity ****************/


/************ begin Rule Feature ****************
 *
 * Feature : StructuralFeature | Operation ;
 *
 **/


// StructuralFeature | Operation
protected class Feature_Alternatives extends AlternativesToken {

	public Feature_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prFeature().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Feature_1_RuleCall_Operation(current, this) : new Feature_0_RuleCall_StructuralFeature(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// StructuralFeature
protected class Feature_0_RuleCall_StructuralFeature extends RuleCallToken {
	
	public Feature_0_RuleCall_StructuralFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prFeature().ele0ParserRuleCallStructuralFeature();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(StructuralFeature_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("StructuralFeature")) return null;
		return new StructuralFeature_Alternatives(current, this).firstSolution();
	}
}

// Operation
protected class Feature_1_RuleCall_Operation extends RuleCallToken {
	
	public Feature_1_RuleCall_Operation(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prFeature().ele1ParserRuleCallOperation();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Operation_Group.class, current)) return null;
		if(!current.isInstanceOf("Operation")) return null;
		return new Operation_Group(current, this).firstSolution();
	}
}


/************ end Rule Feature ****************/


/************ begin Rule StructuralFeature ****************
 *
 * StructuralFeature : Attribute | Reference ;
 *
 **/


// Attribute | Reference
protected class StructuralFeature_Alternatives extends AlternativesToken {

	public StructuralFeature_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prStructuralFeature().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new StructuralFeature_1_RuleCall_Reference(current, this) : new StructuralFeature_0_RuleCall_Attribute(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Attribute
protected class StructuralFeature_0_RuleCall_Attribute extends RuleCallToken {
	
	public StructuralFeature_0_RuleCall_Attribute(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prStructuralFeature().ele0ParserRuleCallAttribute();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Attribute_Group.class, current)) return null;
		if(!current.isInstanceOf("Attribute")) return null;
		return new Attribute_Group(current, this).firstSolution();
	}
}

// Reference
protected class StructuralFeature_1_RuleCall_Reference extends RuleCallToken {
	
	public StructuralFeature_1_RuleCall_Reference(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prStructuralFeature().ele1ParserRuleCallReference();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Reference_Group.class, current)) return null;
		if(!current.isInstanceOf("Reference")) return null;
		return new Reference_Group(current, this).firstSolution();
	}
}


/************ end Rule StructuralFeature ****************/


/************ begin Rule Attribute ****************
 *
 * Attribute : 'attr' name = ID ':' type = TypeRef ;
 *
 **/


// 'attr' name = ID ':' type = TypeRef
protected class Attribute_Group extends GroupToken {
	
	public Attribute_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prAttribute().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Attribute_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Attribute_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'attr' name = ID ':'
protected class Attribute_0_Group extends GroupToken {
	
	public Attribute_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prAttribute().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Attribute_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Attribute_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'attr' name = ID
protected class Attribute_0_0_Group extends GroupToken {
	
	public Attribute_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prAttribute().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Attribute_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Attribute_0_0_0_Keyword_attr(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'attr'
protected class Attribute_0_0_0_Keyword_attr extends KeywordToken  {
	
	public Attribute_0_0_0_Keyword_attr(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prAttribute().ele000KeywordAttr();
	}	
}

// name = ID
protected class Attribute_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Attribute_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prAttribute().ele001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = DomainmodelGrammarAccess.INSTANCE.prAttribute().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ':'
protected class Attribute_0_1_Keyword extends KeywordToken  {
	
	public Attribute_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prAttribute().ele01KeywordColon();
	}	
}


// type = TypeRef
protected class Attribute_1_Assignment_type extends AssignmentToken  {
	
	public Attribute_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prAttribute().ele1AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Assignment_referenced(param, this).firstSolution();
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


/************ end Rule Attribute ****************/


/************ begin Rule Reference ****************
 *
 * Reference : 'ref' name = ID ':' type = TypeRef ( 'opposite' opposite = [ Reference ] ) ? ;
 *
 **/


// 'ref' name = ID ':' type = TypeRef ( 'opposite' opposite = [ Reference ] ) ?
protected class Reference_Group extends GroupToken {
	
	public Reference_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Reference_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Reference_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'ref' name = ID ':' type = TypeRef
protected class Reference_0_Group extends GroupToken {
	
	public Reference_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Reference_0_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Reference_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'ref' name = ID ':'
protected class Reference_0_0_Group extends GroupToken {
	
	public Reference_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Reference_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Reference_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'ref' name = ID
protected class Reference_0_0_0_Group extends GroupToken {
	
	public Reference_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Reference_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Reference_0_0_0_0_Keyword_ref(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'ref'
protected class Reference_0_0_0_0_Keyword_ref extends KeywordToken  {
	
	public Reference_0_0_0_0_Keyword_ref(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele0000KeywordRef();
	}	
}

// name = ID
protected class Reference_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Reference_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele0001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = DomainmodelGrammarAccess.INSTANCE.prReference().ele00010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ':'
protected class Reference_0_0_1_Keyword extends KeywordToken  {
	
	public Reference_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele001KeywordColon();
	}	
}


// type = TypeRef
protected class Reference_0_1_Assignment_type extends AssignmentToken  {
	
	public Reference_0_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele01AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Assignment_referenced(param, this).firstSolution();
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


// ( 'opposite' opposite = [ Reference ] ) ?
protected class Reference_1_Group extends GroupToken {
	
	public Reference_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele1Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Reference_1_1_Assignment_opposite(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Reference_1_0_Keyword_opposite(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'opposite'
protected class Reference_1_0_Keyword_opposite extends KeywordToken  {
	
	public Reference_1_0_Keyword_opposite(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele10KeywordOpposite();
	}	
}

// opposite = [ Reference ]
protected class Reference_1_1_Assignment_opposite extends AssignmentToken  {
	
	public Reference_1_1_Assignment_opposite(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prReference().ele11AssignmentOpposite();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("opposite",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("opposite");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Reference")) {
				type = AssignmentType.CR;
				element = DomainmodelGrammarAccess.INSTANCE.prReference().ele110CrossReferenceEStringReference(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}



/************ end Rule Reference ****************/


/************ begin Rule Operation ****************
 *
 * Operation : 'op' name = ID '(' ( params += Parameter ( ',' params += Parameter ) * ) ? ')' ':' type = TypeRef ;
 *
 **/


// 'op' name = ID '(' ( params += Parameter ( ',' params += Parameter ) * ) ? ')' ':' type = TypeRef
protected class Operation_Group extends GroupToken {
	
	public Operation_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'op' name = ID '(' ( params += Parameter ( ',' params += Parameter ) * ) ? ')' ':'
protected class Operation_0_Group extends GroupToken {
	
	public Operation_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele0Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'op' name = ID '(' ( params += Parameter ( ',' params += Parameter ) * ) ? ')'
protected class Operation_0_0_Group extends GroupToken {
	
	public Operation_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele00Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'op' name = ID '(' ( params += Parameter ( ',' params += Parameter ) * ) ?
protected class Operation_0_0_0_Group extends GroupToken {
	
	public Operation_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'op' name = ID '('
protected class Operation_0_0_0_0_Group extends GroupToken {
	
	public Operation_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele0000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'op' name = ID
protected class Operation_0_0_0_0_0_Group extends GroupToken {
	
	public Operation_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele00000Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_0_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_0_0_0_0_0_Keyword_op(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// 'op'
protected class Operation_0_0_0_0_0_0_Keyword_op extends KeywordToken  {
	
	public Operation_0_0_0_0_0_0_Keyword_op(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele000000KeywordOp();
	}	
}

// name = ID
protected class Operation_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public Operation_0_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele000001AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = DomainmodelGrammarAccess.INSTANCE.prOperation().ele0000010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// '('
protected class Operation_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public Operation_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele00001KeywordLeftParenthesis();
	}	
}


// ( params += Parameter ( ',' params += Parameter ) * ) ?
protected class Operation_0_0_0_1_Group extends GroupToken {
	
	public Operation_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele0001Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_0_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_0_0_1_0_Assignment_params(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// params += Parameter
protected class Operation_0_0_0_1_0_Assignment_params extends AssignmentToken  {
	
	public Operation_0_0_0_1_0_Assignment_params(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele00010AssignmentParams();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("params",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("params");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Parameter")) {
				Solution s = new Parameter_Group(param, this).firstSolution();
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

// ( ',' params += Parameter ) *
protected class Operation_0_0_0_1_1_Group extends GroupToken {
	
	public Operation_0_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele00011Group();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Operation_0_0_0_1_1_1_Assignment_params(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Operation_0_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ','
protected class Operation_0_0_0_1_1_0_Keyword extends KeywordToken  {
	
	public Operation_0_0_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele000110KeywordComma();
	}	
}

// params += Parameter
protected class Operation_0_0_0_1_1_1_Assignment_params extends AssignmentToken  {
	
	public Operation_0_0_0_1_1_1_Assignment_params(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele000111AssignmentParams();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("params",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("params");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Parameter")) {
				Solution s = new Parameter_Group(param, this).firstSolution();
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




// ')'
protected class Operation_0_0_1_Keyword extends KeywordToken  {
	
	public Operation_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele001KeywordRightParenthesis();
	}	
}


// ':'
protected class Operation_0_1_Keyword extends KeywordToken  {
	
	public Operation_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele01KeywordColon();
	}	
}


// type = TypeRef
protected class Operation_1_Assignment_type extends AssignmentToken  {
	
	public Operation_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prOperation().ele1AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Assignment_referenced(param, this).firstSolution();
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


/************ end Rule Operation ****************/


/************ begin Rule Parameter ****************
 *
 * Parameter : name = ID type = TypeRef ;
 *
 **/


// name = ID type = TypeRef
protected class Parameter_Group extends GroupToken {
	
	public Parameter_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prParameter().eleGroup();
	}
		
	protected Solution createSolution() {	
		Solution s1 = new Parameter_1_Assignment_type(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Parameter_0_Assignment_name(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class Parameter_0_Assignment_name extends AssignmentToken  {
	
	public Parameter_0_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prParameter().ele0AssignmentName();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(true) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = DomainmodelGrammarAccess.INSTANCE.prParameter().ele00LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// type = TypeRef
protected class Parameter_1_Assignment_type extends AssignmentToken  {
	
	public Parameter_1_Assignment_type(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prParameter().ele1AssignmentType();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("type",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("type");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("TypeRef")) {
				Solution s = new TypeRef_Assignment_referenced(param, this).firstSolution();
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


/************ end Rule Parameter ****************/


/************ begin Rule TypedElement ****************
 *
 * TypedElement : Feature | Parameter ;
 *
 **/


// Feature | Parameter
protected class TypedElement_Alternatives extends AlternativesToken {

	public TypedElement_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prTypedElement().eleAlternatives();
	}
	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new TypedElement_1_RuleCall_Parameter(current, this) : new TypedElement_0_RuleCall_Feature(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// Feature
protected class TypedElement_0_RuleCall_Feature extends RuleCallToken {
	
	public TypedElement_0_RuleCall_Feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prTypedElement().ele0ParserRuleCallFeature();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Feature_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("Feature")) return null;
		return new Feature_Alternatives(current, this).firstSolution();
	}
}

// Parameter
protected class TypedElement_1_RuleCall_Parameter extends RuleCallToken {
	
	public TypedElement_1_RuleCall_Parameter(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prTypedElement().ele1ParserRuleCallParameter();
	}
	
	protected Solution createSolution() {
		if(checkForRecursion(Parameter_Group.class, current)) return null;
		if(!current.isInstanceOf("Parameter")) return null;
		return new Parameter_Group(current, this).firstSolution();
	}
}


/************ end Rule TypedElement ****************/


/************ begin Rule TypeRef ****************
 *
 * TypeRef : referenced = [ Type ] ;
 *
 **/


// referenced = [ Type ]
protected class TypeRef_Assignment_referenced extends AssignmentToken  {
	
	public TypeRef_Assignment_referenced(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return DomainmodelGrammarAccess.INSTANCE.prTypeRef().eleAssignmentReferenced();
	}
	
	protected Solution createSolution() {
		if((value = current.getConsumable("referenced",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("referenced");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Type")) {
				type = AssignmentType.CR;
				element = DomainmodelGrammarAccess.INSTANCE.prTypeRef().ele0CrossReferenceEStringType(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

/************ end Rule TypeRef ****************/


}
