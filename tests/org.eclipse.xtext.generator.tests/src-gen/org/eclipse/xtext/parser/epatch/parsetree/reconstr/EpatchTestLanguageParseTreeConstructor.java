/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parsetree.reconstr;

//import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.impl.*;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;


public class EpatchTestLanguageParseTreeConstructor extends AbstractParseTreeConstructor {
		
	protected Solution internalSerialize(EObject obj) {
		IInstanceDescription inst = getDescr(obj);
		Solution s;
		if(inst.isInstanceOf("EPatch") && (s = new EPatch_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Import") && (s = new Import_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ModelImport") && (s = new ModelImport_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ResourceImport") && (s = new ResourceImport_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("EPackageImport") && (s = new EPackageImport_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("JavaImport") && (s = new JavaImport_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ExtensionImport") && (s = new ExtensionImport_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("NamedResource") && (s = new NamedResource_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("NamedObject") && (s = new NamedObject_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ObjectRef") && (s = new ObjectRef_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Assignment") && (s = new Assignment_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("SingleAssignment") && (s = new BiSingleAssignment_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ListAssignment") && (s = new BiListAssignment_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("SingleAssignment") && (s = new MonoSingleAssignment_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ListAssignment") && (s = new MonoListAssignment_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AssignmentValue") && (s = new AssignmentValue_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AssignmentValue") && (s = new ListAssignmentValue_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("AssignmentValue") && (s = new SingleAssignmentValue_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("CreatedObject") && (s = new CreatedObject_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ObjectNew") && (s = new ObjectNew_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ObjectCopy") && (s = new ObjectCopy_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Migration") && (s = new Migration_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("Executable") && (s = new Executable_Alternatives(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("JavaExecutable") && (s = new JavaExecutable_Group(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		if(inst.isInstanceOf("ExpressionExecutable") && (s = new ExpressionExecutable_Assignment_exprstr(inst, null).firstSolution()) != null && isConsumed(s,null)) return s;
		return null;
	}
	

/************ begin Rule EPatch ****************
 *
 * EPatch:   "epatch" name=ID "{" (imports+=Import)* (resources+=NamedResource)* (objects+=ObjectRef)* "}";
 *
 **/


// "epatch" name=ID "{" (imports+=Import)* (resources+=NamedResource)* (objects+=ObjectRef)* "}"
protected class EPatch_Group extends GroupToken {
	
	public EPatch_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPatch_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPatch_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "epatch" name=ID "{" (imports+=Import)* (resources+=NamedResource)* (objects+=ObjectRef)*
protected class EPatch_0_Group extends GroupToken {
	
	public EPatch_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPatch_0_1_Assignment_objects(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPatch_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "epatch" name=ID "{" (imports+=Import)* (resources+=NamedResource)*
protected class EPatch_0_0_Group extends GroupToken {
	
	public EPatch_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPatch_0_0_1_Assignment_resources(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPatch_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "epatch" name=ID "{" (imports+=Import)*
protected class EPatch_0_0_0_Group extends GroupToken {
	
	public EPatch_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPatch_0_0_0_1_Assignment_imports(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPatch_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "epatch" name=ID "{"
protected class EPatch_0_0_0_0_Group extends GroupToken {
	
	public EPatch_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPatch_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPatch_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "epatch" name=ID
protected class EPatch_0_0_0_0_0_Group extends GroupToken {
	
	public EPatch_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele00000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPatch_0_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPatch_0_0_0_0_0_0_Keyword_epatch(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "epatch"
protected class EPatch_0_0_0_0_0_0_Keyword_epatch extends KeywordToken  {
	
	public EPatch_0_0_0_0_0_0_Keyword_epatch(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele000000KeywordEpatch();
	}	
}

// name=ID
protected class EPatch_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EPatch_0_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele000001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele0000010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "{"
protected class EPatch_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public EPatch_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele00001KeywordLeftCurlyBracket();
	}	
}


// (imports+=Import)*
protected class EPatch_0_0_0_1_Assignment_imports extends AssignmentToken  {
	
	public EPatch_0_0_0_1_Assignment_imports(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele0001AssignmentImports();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("imports",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("imports");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Import")) {
				Solution s = new Import_Alternatives(param, this).firstSolution();
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


// (resources+=NamedResource)*
protected class EPatch_0_0_1_Assignment_resources extends AssignmentToken  {
	
	public EPatch_0_0_1_Assignment_resources(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele001AssignmentResources();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("resources",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("resources");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedResource")) {
				Solution s = new NamedResource_Group(param, this).firstSolution();
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


// (objects+=ObjectRef)*
protected class EPatch_0_1_Assignment_objects extends AssignmentToken  {
	
	public EPatch_0_1_Assignment_objects(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele01AssignmentObjects();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("objects",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("objects");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ObjectRef")) {
				Solution s = new ObjectRef_Group(param, this).firstSolution();
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
protected class EPatch_1_Keyword extends KeywordToken  {
	
	public EPatch_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPatch().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule EPatch ****************/


/************ begin Rule Import ****************
 *
 * Import:   ModelImport|JavaImport|ExtensionImport;
 *
 **/


// ModelImport|JavaImport|ExtensionImport
protected class Import_Alternatives extends AlternativesToken {

	public Import_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prImport().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Import_1_RuleCall_ExtensionImport(current, this) : new Import_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ModelImport|JavaImport
protected class Import_0_Alternatives extends AlternativesToken {

	public Import_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prImport().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Import_0_1_RuleCall_JavaImport(current, this) : new Import_0_0_RuleCall_ModelImport(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ModelImport
protected class Import_0_0_RuleCall_ModelImport extends RuleCallToken {
	
	public Import_0_0_RuleCall_ModelImport(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prImport().ele00ParserRuleCallModelImport();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ModelImport_Alternatives.class, current)) return null;
		if(!current.isInstanceOf("ModelImport")) return null;
		return new ModelImport_Alternatives(current, this).firstSolution();
	}
}

// JavaImport
protected class Import_0_1_RuleCall_JavaImport extends RuleCallToken {
	
	public Import_0_1_RuleCall_JavaImport(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prImport().ele01ParserRuleCallJavaImport();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(JavaImport_Group.class, current)) return null;
		if(!current.isInstanceOf("JavaImport")) return null;
		return new JavaImport_Group(current, this).firstSolution();
	}
}


// ExtensionImport
protected class Import_1_RuleCall_ExtensionImport extends RuleCallToken {
	
	public Import_1_RuleCall_ExtensionImport(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prImport().ele1ParserRuleCallExtensionImport();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ExtensionImport_Group.class, current)) return null;
		if(!current.isInstanceOf("ExtensionImport")) return null;
		return new ExtensionImport_Group(current, this).firstSolution();
	}
}


/************ end Rule Import ****************/


/************ begin Rule ModelImport ****************
 *
 * ModelImport:   ResourceImport|EPackageImport;
 *
 **/


// ResourceImport|EPackageImport
protected class ModelImport_Alternatives extends AlternativesToken {

	public ModelImport_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prModelImport().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ModelImport_1_RuleCall_EPackageImport(current, this) : new ModelImport_0_RuleCall_ResourceImport(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ResourceImport
protected class ModelImport_0_RuleCall_ResourceImport extends RuleCallToken {
	
	public ModelImport_0_RuleCall_ResourceImport(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prModelImport().ele0ParserRuleCallResourceImport();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ResourceImport_Group.class, current)) return null;
		if(!current.isInstanceOf("ResourceImport")) return null;
		return new ResourceImport_Group(current, this).firstSolution();
	}
}

// EPackageImport
protected class ModelImport_1_RuleCall_EPackageImport extends RuleCallToken {
	
	public ModelImport_1_RuleCall_EPackageImport(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prModelImport().ele1ParserRuleCallEPackageImport();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(EPackageImport_Group.class, current)) return null;
		if(!current.isInstanceOf("EPackageImport")) return null;
		return new EPackageImport_Group(current, this).firstSolution();
	}
}


/************ end Rule ModelImport ****************/


/************ begin Rule ResourceImport ****************
 *
 * ResourceImport:   "import" name=ID "uri" uri=STRING;
 *
 **/


// "import" name=ID "uri" uri=STRING
protected class ResourceImport_Group extends GroupToken {
	
	public ResourceImport_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ResourceImport_1_Assignment_uri(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ResourceImport_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" name=ID "uri"
protected class ResourceImport_0_Group extends GroupToken {
	
	public ResourceImport_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ResourceImport_0_1_Keyword_uri(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ResourceImport_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" name=ID
protected class ResourceImport_0_0_Group extends GroupToken {
	
	public ResourceImport_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ResourceImport_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ResourceImport_0_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class ResourceImport_0_0_0_Keyword_import extends KeywordToken  {
	
	public ResourceImport_0_0_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele000KeywordImport();
	}	
}

// name=ID
protected class ResourceImport_0_0_1_Assignment_name extends AssignmentToken  {
	
	public ResourceImport_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "uri"
protected class ResourceImport_0_1_Keyword_uri extends KeywordToken  {
	
	public ResourceImport_0_1_Keyword_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele01KeywordUri();
	}	
}


// uri=STRING
protected class ResourceImport_1_Assignment_uri extends AssignmentToken  {
	
	public ResourceImport_1_Assignment_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele1AssignmentUri();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("uri",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("uri");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prResourceImport().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule ResourceImport ****************/


/************ begin Rule EPackageImport ****************
 *
 * EPackageImport:   "import" name=ID "ns" nsURI=STRING;
 *
 **/


// "import" name=ID "ns" nsURI=STRING
protected class EPackageImport_Group extends GroupToken {
	
	public EPackageImport_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPackageImport_1_Assignment_nsURI(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageImport_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" name=ID "ns"
protected class EPackageImport_0_Group extends GroupToken {
	
	public EPackageImport_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPackageImport_0_1_Keyword_ns(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageImport_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" name=ID
protected class EPackageImport_0_0_Group extends GroupToken {
	
	public EPackageImport_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new EPackageImport_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new EPackageImport_0_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class EPackageImport_0_0_0_Keyword_import extends KeywordToken  {
	
	public EPackageImport_0_0_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele000KeywordImport();
	}	
}

// name=ID
protected class EPackageImport_0_0_1_Assignment_name extends AssignmentToken  {
	
	public EPackageImport_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "ns"
protected class EPackageImport_0_1_Keyword_ns extends KeywordToken  {
	
	public EPackageImport_0_1_Keyword_ns(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele01KeywordNs();
	}	
}


// nsURI=STRING
protected class EPackageImport_1_Assignment_nsURI extends AssignmentToken  {
	
	public EPackageImport_1_Assignment_nsURI(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele1AssignmentNsURI();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("nsURI",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("nsURI");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prEPackageImport().ele10LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule EPackageImport ****************/


/************ begin Rule JavaImport ****************
 *
 * JavaImport:   "import" "java" path+=ID ("." path+=ID)*;
 *
 **/


// "import" "java" path+=ID ("." path+=ID)*
protected class JavaImport_Group extends GroupToken {
	
	public JavaImport_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new JavaImport_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new JavaImport_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" "java" path+=ID
protected class JavaImport_0_Group extends GroupToken {
	
	public JavaImport_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new JavaImport_0_1_Assignment_path(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new JavaImport_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" "java"
protected class JavaImport_0_0_Group extends GroupToken {
	
	public JavaImport_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new JavaImport_0_0_1_Keyword_java(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new JavaImport_0_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class JavaImport_0_0_0_Keyword_import extends KeywordToken  {
	
	public JavaImport_0_0_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele000KeywordImport();
	}	
}

// "java"
protected class JavaImport_0_0_1_Keyword_java extends KeywordToken  {
	
	public JavaImport_0_0_1_Keyword_java(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele001KeywordJava();
	}	
}


// path+=ID
protected class JavaImport_0_1_Assignment_path extends AssignmentToken  {
	
	public JavaImport_0_1_Assignment_path(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele01AssignmentPath();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("path",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("path");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("." path+=ID)*
protected class JavaImport_1_Group extends GroupToken {
	
	public JavaImport_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new JavaImport_1_1_Assignment_path(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new JavaImport_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "."
protected class JavaImport_1_0_Keyword extends KeywordToken  {
	
	public JavaImport_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele10KeywordFullStop();
	}	
}

// path+=ID
protected class JavaImport_1_1_Assignment_path extends AssignmentToken  {
	
	public JavaImport_1_1_Assignment_path(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele11AssignmentPath();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("path",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("path");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prJavaImport().ele110LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule JavaImport ****************/


/************ begin Rule ExtensionImport ****************
 *
 * ExtensionImport:   "import" "extension" path+=ID ("::" path+=ID)*;
 *
 **/


// "import" "extension" path+=ID ("::" path+=ID)*
protected class ExtensionImport_Group extends GroupToken {
	
	public ExtensionImport_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ExtensionImport_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ExtensionImport_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" "extension" path+=ID
protected class ExtensionImport_0_Group extends GroupToken {
	
	public ExtensionImport_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ExtensionImport_0_1_Assignment_path(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ExtensionImport_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "import" "extension"
protected class ExtensionImport_0_0_Group extends GroupToken {
	
	public ExtensionImport_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ExtensionImport_0_0_1_Keyword_extension(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ExtensionImport_0_0_0_Keyword_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class ExtensionImport_0_0_0_Keyword_import extends KeywordToken  {
	
	public ExtensionImport_0_0_0_Keyword_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele000KeywordImport();
	}	
}

// "extension"
protected class ExtensionImport_0_0_1_Keyword_extension extends KeywordToken  {
	
	public ExtensionImport_0_0_1_Keyword_extension(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele001KeywordExtension();
	}	
}


// path+=ID
protected class ExtensionImport_0_1_Assignment_path extends AssignmentToken  {
	
	public ExtensionImport_0_1_Assignment_path(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele01AssignmentPath();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("path",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("path");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("::" path+=ID)*
protected class ExtensionImport_1_Group extends GroupToken {
	
	public ExtensionImport_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ExtensionImport_1_1_Assignment_path(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ExtensionImport_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "::"
protected class ExtensionImport_1_0_Keyword extends KeywordToken  {
	
	public ExtensionImport_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele10KeywordColonColon();
	}	
}

// path+=ID
protected class ExtensionImport_1_1_Assignment_path extends AssignmentToken  {
	
	public ExtensionImport_1_1_Assignment_path(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele11AssignmentPath();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("path",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("path");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prExtensionImport().ele110LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule ExtensionImport ****************/


/************ begin Rule NamedResource ****************
 *
 * NamedResource:   "resource" name=ID "{" "left" ("uri" leftUri=STRING|leftRoot=CreatedObject) ";" "right" ("uri" rightUri=STRING|rightRoot=CreatedObject) ";" "}";
 *
 **/


// "resource" name=ID "{" "left" ("uri" leftUri=STRING|leftRoot=CreatedObject) ";" "right" ("uri" rightUri=STRING|rightRoot=CreatedObject) ";" "}"
protected class NamedResource_Group extends GroupToken {
	
	public NamedResource_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID "{" "left" ("uri" leftUri=STRING|leftRoot=CreatedObject) ";" "right" ("uri" rightUri=STRING|rightRoot=CreatedObject) ";"
protected class NamedResource_0_Group extends GroupToken {
	
	public NamedResource_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID "{" "left" ("uri" leftUri=STRING|leftRoot=CreatedObject) ";" "right" ("uri" rightUri=STRING|rightRoot=CreatedObject)
protected class NamedResource_0_0_Group extends GroupToken {
	
	public NamedResource_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID "{" "left" ("uri" leftUri=STRING|leftRoot=CreatedObject) ";" "right"
protected class NamedResource_0_0_0_Group extends GroupToken {
	
	public NamedResource_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_0_1_Keyword_right(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID "{" "left" ("uri" leftUri=STRING|leftRoot=CreatedObject) ";"
protected class NamedResource_0_0_0_0_Group extends GroupToken {
	
	public NamedResource_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID "{" "left" ("uri" leftUri=STRING|leftRoot=CreatedObject)
protected class NamedResource_0_0_0_0_0_Group extends GroupToken {
	
	public NamedResource_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID "{" "left"
protected class NamedResource_0_0_0_0_0_0_Group extends GroupToken {
	
	public NamedResource_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele000000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_0_0_0_0_1_Keyword_left(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID "{"
protected class NamedResource_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public NamedResource_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0000000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_0_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource" name=ID
protected class NamedResource_0_0_0_0_0_0_0_0_Group extends GroupToken {
	
	public NamedResource_0_0_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00000000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_0_0_0_0_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_0_0_0_0_0_0_Keyword_resource(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "resource"
protected class NamedResource_0_0_0_0_0_0_0_0_0_Keyword_resource extends KeywordToken  {
	
	public NamedResource_0_0_0_0_0_0_0_0_0_Keyword_resource(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele000000000KeywordResource();
	}	
}

// name=ID
protected class NamedResource_0_0_0_0_0_0_0_0_1_Assignment_name extends AssignmentToken  {
	
	public NamedResource_0_0_0_0_0_0_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele000000001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0000000010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "{"
protected class NamedResource_0_0_0_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public NamedResource_0_0_0_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00000001KeywordLeftCurlyBracket();
	}	
}


// "left"
protected class NamedResource_0_0_0_0_0_0_1_Keyword_left extends KeywordToken  {
	
	public NamedResource_0_0_0_0_0_0_1_Keyword_left(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0000001KeywordLeft();
	}	
}


// "uri" leftUri=STRING|leftRoot=CreatedObject
protected class NamedResource_0_0_0_0_0_1_Alternatives extends AlternativesToken {

	public NamedResource_0_0_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele000001Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new NamedResource_0_0_0_0_0_1_1_Assignment_leftRoot(current, this) : new NamedResource_0_0_0_0_0_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "uri" leftUri=STRING
protected class NamedResource_0_0_0_0_0_1_0_Group extends GroupToken {
	
	public NamedResource_0_0_0_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0000010Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_0_0_0_1_0_1_Assignment_leftUri(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_0_0_0_1_0_0_Keyword_uri(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "uri"
protected class NamedResource_0_0_0_0_0_1_0_0_Keyword_uri extends KeywordToken  {
	
	public NamedResource_0_0_0_0_0_1_0_0_Keyword_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00000100KeywordUri();
	}	
}

// leftUri=STRING
protected class NamedResource_0_0_0_0_0_1_0_1_Assignment_leftUri extends AssignmentToken  {
	
	public NamedResource_0_0_0_0_0_1_0_1_Assignment_leftUri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00000101AssignmentLeftUri();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftUri",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftUri");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele000001010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// leftRoot=CreatedObject
protected class NamedResource_0_0_0_0_0_1_1_Assignment_leftRoot extends AssignmentToken  {
	
	public NamedResource_0_0_0_0_0_1_1_Assignment_leftRoot(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0000011AssignmentLeftRoot();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftRoot",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftRoot");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("CreatedObject")) {
				Solution s = new CreatedObject_Group(param, this).firstSolution();
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
protected class NamedResource_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public NamedResource_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00001KeywordSemicolon();
	}	
}


// "right"
protected class NamedResource_0_0_0_1_Keyword_right extends KeywordToken  {
	
	public NamedResource_0_0_0_1_Keyword_right(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0001KeywordRight();
	}	
}


// "uri" rightUri=STRING|rightRoot=CreatedObject
protected class NamedResource_0_0_1_Alternatives extends AlternativesToken {

	public NamedResource_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele001Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new NamedResource_0_0_1_1_Assignment_rightRoot(current, this) : new NamedResource_0_0_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "uri" rightUri=STRING
protected class NamedResource_0_0_1_0_Group extends GroupToken {
	
	public NamedResource_0_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0010Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new NamedResource_0_0_1_0_1_Assignment_rightUri(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new NamedResource_0_0_1_0_0_Keyword_uri(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "uri"
protected class NamedResource_0_0_1_0_0_Keyword_uri extends KeywordToken  {
	
	public NamedResource_0_0_1_0_0_Keyword_uri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00100KeywordUri();
	}	
}

// rightUri=STRING
protected class NamedResource_0_0_1_0_1_Assignment_rightUri extends AssignmentToken  {
	
	public NamedResource_0_0_1_0_1_Assignment_rightUri(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele00101AssignmentRightUri();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightUri",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightUri");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele001010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// rightRoot=CreatedObject
protected class NamedResource_0_0_1_1_Assignment_rightRoot extends AssignmentToken  {
	
	public NamedResource_0_0_1_1_Assignment_rightRoot(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele0011AssignmentRightRoot();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightRoot",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightRoot");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("CreatedObject")) {
				Solution s = new CreatedObject_Group(param, this).firstSolution();
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
protected class NamedResource_0_1_Keyword extends KeywordToken  {
	
	public NamedResource_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele01KeywordSemicolon();
	}	
}


// "}"
protected class NamedResource_1_Keyword extends KeywordToken  {
	
	public NamedResource_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedResource().ele1KeywordRightCurlyBracket();
	}	
}


/************ end Rule NamedResource ****************/


/************ begin Rule NamedObject ****************
 *
 * NamedObject:   ObjectRef|CreatedObject;
 *
 **/


// ObjectRef|CreatedObject
protected class NamedObject_Alternatives extends AlternativesToken {

	public NamedObject_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedObject().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new NamedObject_1_RuleCall_CreatedObject(current, this) : new NamedObject_0_RuleCall_ObjectRef(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ObjectRef
protected class NamedObject_0_RuleCall_ObjectRef extends RuleCallToken {
	
	public NamedObject_0_RuleCall_ObjectRef(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedObject().ele0ParserRuleCallObjectRef();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ObjectRef_Group.class, current)) return null;
		if(!current.isInstanceOf("ObjectRef")) return null;
		return new ObjectRef_Group(current, this).firstSolution();
	}
}

// CreatedObject
protected class NamedObject_1_RuleCall_CreatedObject extends RuleCallToken {
	
	public NamedObject_1_RuleCall_CreatedObject(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prNamedObject().ele1ParserRuleCallCreatedObject();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(CreatedObject_Group.class, current)) return null;
		if(!current.isInstanceOf("CreatedObject")) return null;
		return new CreatedObject_Group(current, this).firstSolution();
	}
}


/************ end Rule NamedObject ****************/


/************ begin Rule ObjectRef ****************
 *
 * ObjectRef:   "object" (name=ID)? (leftRes=[NamedResource] leftFrag=FRAGMENT|"left" leftRes=[NamedResource] leftFrag=FRAGMENT "right" rightRes=[NamedResource] rightFrag=FRAGMENT) ("{" (assignments+=BiSingleAssignment|assignments+=BiListAssignment)+ ("left" leftMig=Migration)? ("right" rightMig=Migration)? "}")?;
 *
 **/


// "object" (name=ID)? (leftRes=[NamedResource] leftFrag=FRAGMENT|"left" leftRes=[NamedResource] leftFrag=FRAGMENT "right" rightRes=[NamedResource] rightFrag=FRAGMENT) ("{" (assignments+=BiSingleAssignment|assignments+=BiListAssignment)+ ("left" leftMig=Migration)? ("right" rightMig=Migration)? "}")?
protected class ObjectRef_Group extends GroupToken {
	
	public ObjectRef_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "object" (name=ID)? (leftRes=[NamedResource] leftFrag=FRAGMENT|"left" leftRes=[NamedResource] leftFrag=FRAGMENT "right" rightRes=[NamedResource] rightFrag=FRAGMENT)
protected class ObjectRef_0_Group extends GroupToken {
	
	public ObjectRef_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "object" (name=ID)?
protected class ObjectRef_0_0_Group extends GroupToken {
	
	public ObjectRef_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_0_0_Keyword_object(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "object"
protected class ObjectRef_0_0_0_Keyword_object extends KeywordToken  {
	
	public ObjectRef_0_0_0_Keyword_object(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele000KeywordObject();
	}	
}

// (name=ID)?
protected class ObjectRef_0_0_1_Assignment_name extends AssignmentToken  {
	
	public ObjectRef_0_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele001AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// leftRes=[NamedResource] leftFrag=FRAGMENT|"left" leftRes=[NamedResource] leftFrag=FRAGMENT "right" rightRes=[NamedResource] rightFrag=FRAGMENT
protected class ObjectRef_0_1_Alternatives extends AlternativesToken {

	public ObjectRef_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ObjectRef_0_1_1_Group(current, this) : new ObjectRef_0_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// leftRes=[NamedResource] leftFrag=FRAGMENT
protected class ObjectRef_0_1_0_Group extends GroupToken {
	
	public ObjectRef_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele010Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_1_0_1_Assignment_leftFrag(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_1_0_0_Assignment_leftRes(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// leftRes=[NamedResource]
protected class ObjectRef_0_1_0_0_Assignment_leftRes extends AssignmentToken  {
	
	public ObjectRef_0_1_0_0_Assignment_leftRes(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0100AssignmentLeftRes();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftRes",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftRes");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedResource")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01000CrossReferenceEStringNamedResource(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// leftFrag=FRAGMENT
protected class ObjectRef_0_1_0_1_Assignment_leftFrag extends AssignmentToken  {
	
	public ObjectRef_0_1_0_1_Assignment_leftFrag(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0101AssignmentLeftFrag();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftFrag",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftFrag");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01010LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}


// "left" leftRes=[NamedResource] leftFrag=FRAGMENT "right" rightRes=[NamedResource] rightFrag=FRAGMENT
protected class ObjectRef_0_1_1_Group extends GroupToken {
	
	public ObjectRef_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_1_1_1_Assignment_rightFrag(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "left" leftRes=[NamedResource] leftFrag=FRAGMENT "right" rightRes=[NamedResource]
protected class ObjectRef_0_1_1_0_Group extends GroupToken {
	
	public ObjectRef_0_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0110Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_1_1_0_1_Assignment_rightRes(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_1_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "left" leftRes=[NamedResource] leftFrag=FRAGMENT "right"
protected class ObjectRef_0_1_1_0_0_Group extends GroupToken {
	
	public ObjectRef_0_1_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01100Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_1_1_0_0_1_Keyword_right(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_1_1_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "left" leftRes=[NamedResource] leftFrag=FRAGMENT
protected class ObjectRef_0_1_1_0_0_0_Group extends GroupToken {
	
	public ObjectRef_0_1_1_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele011000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_1_1_0_0_0_1_Assignment_leftFrag(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_1_1_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "left" leftRes=[NamedResource]
protected class ObjectRef_0_1_1_0_0_0_0_Group extends GroupToken {
	
	public ObjectRef_0_1_1_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0110000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_0_1_1_0_0_0_0_1_Assignment_leftRes(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_0_1_1_0_0_0_0_0_Keyword_left(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "left"
protected class ObjectRef_0_1_1_0_0_0_0_0_Keyword_left extends KeywordToken  {
	
	public ObjectRef_0_1_1_0_0_0_0_0_Keyword_left(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01100000KeywordLeft();
	}	
}

// leftRes=[NamedResource]
protected class ObjectRef_0_1_1_0_0_0_0_1_Assignment_leftRes extends AssignmentToken  {
	
	public ObjectRef_0_1_1_0_0_0_0_1_Assignment_leftRes(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01100001AssignmentLeftRes();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftRes",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftRes");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedResource")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele011000010CrossReferenceEStringNamedResource(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// leftFrag=FRAGMENT
protected class ObjectRef_0_1_1_0_0_0_1_Assignment_leftFrag extends AssignmentToken  {
	
	public ObjectRef_0_1_1_0_0_0_1_Assignment_leftFrag(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0110001AssignmentLeftFrag();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftFrag",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftFrag");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01100010LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}


// "right"
protected class ObjectRef_0_1_1_0_0_1_Keyword_right extends KeywordToken  {
	
	public ObjectRef_0_1_1_0_0_1_Keyword_right(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele011001KeywordRight();
	}	
}


// rightRes=[NamedResource]
protected class ObjectRef_0_1_1_0_1_Assignment_rightRes extends AssignmentToken  {
	
	public ObjectRef_0_1_1_0_1_Assignment_rightRes(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01101AssignmentRightRes();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightRes",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightRes");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedResource")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele011010CrossReferenceEStringNamedResource(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// rightFrag=FRAGMENT
protected class ObjectRef_0_1_1_1_Assignment_rightFrag extends AssignmentToken  {
	
	public ObjectRef_0_1_1_1_Assignment_rightFrag(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele0111AssignmentRightFrag();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightFrag",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightFrag");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele01110LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}




// ("{" (assignments+=BiSingleAssignment|assignments+=BiListAssignment)+ ("left" leftMig=Migration)? ("right" rightMig=Migration)? "}")?
protected class ObjectRef_1_Group extends GroupToken {
	
	public ObjectRef_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "{" (assignments+=BiSingleAssignment|assignments+=BiListAssignment)+ ("left" leftMig=Migration)? ("right" rightMig=Migration)?
protected class ObjectRef_1_0_Group extends GroupToken {
	
	public ObjectRef_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele10Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_1_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "{" (assignments+=BiSingleAssignment|assignments+=BiListAssignment)+ ("left" leftMig=Migration)?
protected class ObjectRef_1_0_0_Group extends GroupToken {
	
	public ObjectRef_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele100Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_1_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_1_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "{" (assignments+=BiSingleAssignment|assignments+=BiListAssignment)+
protected class ObjectRef_1_0_0_0_Group extends GroupToken {
	
	public ObjectRef_1_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele1000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_1_0_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_1_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "{"
protected class ObjectRef_1_0_0_0_0_Keyword extends KeywordToken  {
	
	public ObjectRef_1_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele10000KeywordLeftCurlyBracket();
	}	
}

// (assignments+=BiSingleAssignment|assignments+=BiListAssignment)+
protected class ObjectRef_1_0_0_0_1_Alternatives extends AlternativesToken {

	public ObjectRef_1_0_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele10001Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ObjectRef_1_0_0_0_1_1_Assignment_assignments(current, this) : new ObjectRef_1_0_0_0_1_0_Assignment_assignments(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// assignments+=BiSingleAssignment
protected class ObjectRef_1_0_0_0_1_0_Assignment_assignments extends AssignmentToken  {
	
	public ObjectRef_1_0_0_0_1_0_Assignment_assignments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele100010AssignmentAssignments();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("assignments",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("assignments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("SingleAssignment")) {
				Solution s = new BiSingleAssignment_Group(param, this).firstSolution();
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

// assignments+=BiListAssignment
protected class ObjectRef_1_0_0_0_1_1_Assignment_assignments extends AssignmentToken  {
	
	public ObjectRef_1_0_0_0_1_1_Assignment_assignments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele100011AssignmentAssignments();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("assignments",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("assignments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ListAssignment")) {
				Solution s = new BiListAssignment_Group(param, this).firstSolution();
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



// ("left" leftMig=Migration)?
protected class ObjectRef_1_0_0_1_Group extends GroupToken {
	
	public ObjectRef_1_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele1001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_1_0_0_1_1_Assignment_leftMig(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_1_0_0_1_0_Keyword_left(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "left"
protected class ObjectRef_1_0_0_1_0_Keyword_left extends KeywordToken  {
	
	public ObjectRef_1_0_0_1_0_Keyword_left(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele10010KeywordLeft();
	}	
}

// leftMig=Migration
protected class ObjectRef_1_0_0_1_1_Assignment_leftMig extends AssignmentToken  {
	
	public ObjectRef_1_0_0_1_1_Assignment_leftMig(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele10011AssignmentLeftMig();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftMig",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftMig");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Migration")) {
				Solution s = new Migration_Group(param, this).firstSolution();
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



// ("right" rightMig=Migration)?
protected class ObjectRef_1_0_1_Group extends GroupToken {
	
	public ObjectRef_1_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele101Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectRef_1_0_1_1_Assignment_rightMig(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectRef_1_0_1_0_Keyword_right(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "right"
protected class ObjectRef_1_0_1_0_Keyword_right extends KeywordToken  {
	
	public ObjectRef_1_0_1_0_Keyword_right(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele1010KeywordRight();
	}	
}

// rightMig=Migration
protected class ObjectRef_1_0_1_1_Assignment_rightMig extends AssignmentToken  {
	
	public ObjectRef_1_0_1_1_Assignment_rightMig(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele1011AssignmentRightMig();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightMig",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightMig");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Migration")) {
				Solution s = new Migration_Group(param, this).firstSolution();
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
protected class ObjectRef_1_1_Keyword extends KeywordToken  {
	
	public ObjectRef_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef().ele11KeywordRightCurlyBracket();
	}	
}



/************ end Rule ObjectRef ****************/


/************ begin Rule Assignment ****************
 *
 * Assignment:   BiSingleAssignment|BiListAssignment|MonoSingleAssignment|MonoListAssignment;
 *
 **/


// BiSingleAssignment|BiListAssignment|MonoSingleAssignment|MonoListAssignment
protected class Assignment_Alternatives extends AlternativesToken {

	public Assignment_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Assignment_1_RuleCall_MonoListAssignment(current, this) : new Assignment_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// BiSingleAssignment|BiListAssignment|MonoSingleAssignment
protected class Assignment_0_Alternatives extends AlternativesToken {

	public Assignment_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Assignment_0_1_RuleCall_MonoSingleAssignment(current, this) : new Assignment_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// BiSingleAssignment|BiListAssignment
protected class Assignment_0_0_Alternatives extends AlternativesToken {

	public Assignment_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment().ele00Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Assignment_0_0_1_RuleCall_BiListAssignment(current, this) : new Assignment_0_0_0_RuleCall_BiSingleAssignment(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// BiSingleAssignment
protected class Assignment_0_0_0_RuleCall_BiSingleAssignment extends RuleCallToken {
	
	public Assignment_0_0_0_RuleCall_BiSingleAssignment(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment().ele000ParserRuleCallBiSingleAssignment();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(BiSingleAssignment_Group.class, current)) return null;
		if(!current.isInstanceOf("SingleAssignment")) return null;
		return new BiSingleAssignment_Group(current, this).firstSolution();
	}
}

// BiListAssignment
protected class Assignment_0_0_1_RuleCall_BiListAssignment extends RuleCallToken {
	
	public Assignment_0_0_1_RuleCall_BiListAssignment(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment().ele001ParserRuleCallBiListAssignment();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(BiListAssignment_Group.class, current)) return null;
		if(!current.isInstanceOf("ListAssignment")) return null;
		return new BiListAssignment_Group(current, this).firstSolution();
	}
}


// MonoSingleAssignment
protected class Assignment_0_1_RuleCall_MonoSingleAssignment extends RuleCallToken {
	
	public Assignment_0_1_RuleCall_MonoSingleAssignment(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment().ele01ParserRuleCallMonoSingleAssignment();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(MonoSingleAssignment_Group.class, current)) return null;
		if(!current.isInstanceOf("SingleAssignment")) return null;
		return new MonoSingleAssignment_Group(current, this).firstSolution();
	}
}


// MonoListAssignment
protected class Assignment_1_RuleCall_MonoListAssignment extends RuleCallToken {
	
	public Assignment_1_RuleCall_MonoListAssignment(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignment().ele1ParserRuleCallMonoListAssignment();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(MonoListAssignment_Group.class, current)) return null;
		if(!current.isInstanceOf("ListAssignment")) return null;
		return new MonoListAssignment_Group(current, this).firstSolution();
	}
}


/************ end Rule Assignment ****************/


/************ begin Rule BiSingleAssignment ****************
 *
 * BiSingleAssignment returns SingleAssignment:   feature=ID "=" leftValue=SingleAssignmentValue "|" rightValue=SingleAssignmentValue ";";
 *
 **/


// feature=ID "=" leftValue=SingleAssignmentValue "|" rightValue=SingleAssignmentValue ";"
protected class BiSingleAssignment_Group extends GroupToken {
	
	public BiSingleAssignment_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiSingleAssignment_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiSingleAssignment_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" leftValue=SingleAssignmentValue "|" rightValue=SingleAssignmentValue
protected class BiSingleAssignment_0_Group extends GroupToken {
	
	public BiSingleAssignment_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiSingleAssignment_0_1_Assignment_rightValue(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiSingleAssignment_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" leftValue=SingleAssignmentValue "|"
protected class BiSingleAssignment_0_0_Group extends GroupToken {
	
	public BiSingleAssignment_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiSingleAssignment_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiSingleAssignment_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" leftValue=SingleAssignmentValue
protected class BiSingleAssignment_0_0_0_Group extends GroupToken {
	
	public BiSingleAssignment_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiSingleAssignment_0_0_0_1_Assignment_leftValue(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiSingleAssignment_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "="
protected class BiSingleAssignment_0_0_0_0_Group extends GroupToken {
	
	public BiSingleAssignment_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiSingleAssignment_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiSingleAssignment_0_0_0_0_0_Assignment_feature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID
protected class BiSingleAssignment_0_0_0_0_0_Assignment_feature extends AssignmentToken  {
	
	public BiSingleAssignment_0_0_0_0_0_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele00000AssignmentFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele000000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "="
protected class BiSingleAssignment_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public BiSingleAssignment_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele00001KeywordEqualsSign();
	}	
}


// leftValue=SingleAssignmentValue
protected class BiSingleAssignment_0_0_0_1_Assignment_leftValue extends AssignmentToken  {
	
	public BiSingleAssignment_0_0_0_1_Assignment_leftValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele0001AssignmentLeftValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftValue");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new SingleAssignmentValue_Alternatives(param, this).firstSolution();
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


// "|"
protected class BiSingleAssignment_0_0_1_Keyword extends KeywordToken  {
	
	public BiSingleAssignment_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele001KeywordVerticalLine();
	}	
}


// rightValue=SingleAssignmentValue
protected class BiSingleAssignment_0_1_Assignment_rightValue extends AssignmentToken  {
	
	public BiSingleAssignment_0_1_Assignment_rightValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele01AssignmentRightValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightValue");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new SingleAssignmentValue_Alternatives(param, this).firstSolution();
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
protected class BiSingleAssignment_1_Keyword extends KeywordToken  {
	
	public BiSingleAssignment_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiSingleAssignment().ele1KeywordSemicolon();
	}	
}


/************ end Rule BiSingleAssignment ****************/


/************ begin Rule BiListAssignment ****************
 *
 * BiListAssignment returns ListAssignment:   feature=ID "=" "[" (leftValues+=ListAssignmentValue ("," leftValues+=ListAssignmentValue)*)? "|" (rightValues+=ListAssignmentValue ("," rightValues+=ListAssignmentValue)*)? "]" ";";
 *
 **/


// feature=ID "=" "[" (leftValues+=ListAssignmentValue ("," leftValues+=ListAssignmentValue)*)? "|" (rightValues+=ListAssignmentValue ("," rightValues+=ListAssignmentValue)*)? "]" ";"
protected class BiListAssignment_Group extends GroupToken {
	
	public BiListAssignment_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "[" (leftValues+=ListAssignmentValue ("," leftValues+=ListAssignmentValue)*)? "|" (rightValues+=ListAssignmentValue ("," rightValues+=ListAssignmentValue)*)? "]"
protected class BiListAssignment_0_Group extends GroupToken {
	
	public BiListAssignment_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "[" (leftValues+=ListAssignmentValue ("," leftValues+=ListAssignmentValue)*)? "|" (rightValues+=ListAssignmentValue ("," rightValues+=ListAssignmentValue)*)?
protected class BiListAssignment_0_0_Group extends GroupToken {
	
	public BiListAssignment_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "[" (leftValues+=ListAssignmentValue ("," leftValues+=ListAssignmentValue)*)? "|"
protected class BiListAssignment_0_0_0_Group extends GroupToken {
	
	public BiListAssignment_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "[" (leftValues+=ListAssignmentValue ("," leftValues+=ListAssignmentValue)*)?
protected class BiListAssignment_0_0_0_0_Group extends GroupToken {
	
	public BiListAssignment_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "["
protected class BiListAssignment_0_0_0_0_0_Group extends GroupToken {
	
	public BiListAssignment_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele00000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "="
protected class BiListAssignment_0_0_0_0_0_0_Group extends GroupToken {
	
	public BiListAssignment_0_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele000000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_0_0_0_0_0_Assignment_feature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID
protected class BiListAssignment_0_0_0_0_0_0_0_Assignment_feature extends AssignmentToken  {
	
	public BiListAssignment_0_0_0_0_0_0_0_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0000000AssignmentFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele00000000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "="
protected class BiListAssignment_0_0_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public BiListAssignment_0_0_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0000001KeywordEqualsSign();
	}	
}


// "["
protected class BiListAssignment_0_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public BiListAssignment_0_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele000001KeywordLeftSquareBracket();
	}	
}


// (leftValues+=ListAssignmentValue ("," leftValues+=ListAssignmentValue)*)?
protected class BiListAssignment_0_0_0_0_1_Group extends GroupToken {
	
	public BiListAssignment_0_0_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele00001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_0_0_1_0_Assignment_leftValues(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// leftValues+=ListAssignmentValue
protected class BiListAssignment_0_0_0_0_1_0_Assignment_leftValues extends AssignmentToken  {
	
	public BiListAssignment_0_0_0_0_1_0_Assignment_leftValues(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele000010AssignmentLeftValues();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftValues",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftValues");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new ListAssignmentValue_Group(param, this).firstSolution();
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

// ("," leftValues+=ListAssignmentValue)*
protected class BiListAssignment_0_0_0_0_1_1_Group extends GroupToken {
	
	public BiListAssignment_0_0_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele000011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_0_0_1_1_1_Assignment_leftValues(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class BiListAssignment_0_0_0_0_1_1_0_Keyword extends KeywordToken  {
	
	public BiListAssignment_0_0_0_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0000110KeywordComma();
	}	
}

// leftValues+=ListAssignmentValue
protected class BiListAssignment_0_0_0_0_1_1_1_Assignment_leftValues extends AssignmentToken  {
	
	public BiListAssignment_0_0_0_0_1_1_1_Assignment_leftValues(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0000111AssignmentLeftValues();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftValues",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftValues");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new ListAssignmentValue_Group(param, this).firstSolution();
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




// "|"
protected class BiListAssignment_0_0_0_1_Keyword extends KeywordToken  {
	
	public BiListAssignment_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0001KeywordVerticalLine();
	}	
}


// (rightValues+=ListAssignmentValue ("," rightValues+=ListAssignmentValue)*)?
protected class BiListAssignment_0_0_1_Group extends GroupToken {
	
	public BiListAssignment_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_1_0_Assignment_rightValues(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// rightValues+=ListAssignmentValue
protected class BiListAssignment_0_0_1_0_Assignment_rightValues extends AssignmentToken  {
	
	public BiListAssignment_0_0_1_0_Assignment_rightValues(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0010AssignmentRightValues();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightValues",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightValues");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new ListAssignmentValue_Group(param, this).firstSolution();
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

// ("," rightValues+=ListAssignmentValue)*
protected class BiListAssignment_0_0_1_1_Group extends GroupToken {
	
	public BiListAssignment_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele0011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new BiListAssignment_0_0_1_1_1_Assignment_rightValues(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new BiListAssignment_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class BiListAssignment_0_0_1_1_0_Keyword extends KeywordToken  {
	
	public BiListAssignment_0_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele00110KeywordComma();
	}	
}

// rightValues+=ListAssignmentValue
protected class BiListAssignment_0_0_1_1_1_Assignment_rightValues extends AssignmentToken  {
	
	public BiListAssignment_0_0_1_1_1_Assignment_rightValues(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele00111AssignmentRightValues();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("rightValues",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("rightValues");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new ListAssignmentValue_Group(param, this).firstSolution();
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




// "]"
protected class BiListAssignment_0_1_Keyword extends KeywordToken  {
	
	public BiListAssignment_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele01KeywordRightSquareBracket();
	}	
}


// ";"
protected class BiListAssignment_1_Keyword extends KeywordToken  {
	
	public BiListAssignment_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment().ele1KeywordSemicolon();
	}	
}


/************ end Rule BiListAssignment ****************/


/************ begin Rule MonoSingleAssignment ****************
 *
 * MonoSingleAssignment returns SingleAssignment:   feature=ID "=" leftValue=SingleAssignmentValue ";";
 *
 **/


// feature=ID "=" leftValue=SingleAssignmentValue ";"
protected class MonoSingleAssignment_Group extends GroupToken {
	
	public MonoSingleAssignment_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoSingleAssignment_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoSingleAssignment_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" leftValue=SingleAssignmentValue
protected class MonoSingleAssignment_0_Group extends GroupToken {
	
	public MonoSingleAssignment_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoSingleAssignment_0_1_Assignment_leftValue(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoSingleAssignment_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "="
protected class MonoSingleAssignment_0_0_Group extends GroupToken {
	
	public MonoSingleAssignment_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoSingleAssignment_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoSingleAssignment_0_0_0_Assignment_feature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID
protected class MonoSingleAssignment_0_0_0_Assignment_feature extends AssignmentToken  {
	
	public MonoSingleAssignment_0_0_0_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().ele000AssignmentFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().ele0000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "="
protected class MonoSingleAssignment_0_0_1_Keyword extends KeywordToken  {
	
	public MonoSingleAssignment_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().ele001KeywordEqualsSign();
	}	
}


// leftValue=SingleAssignmentValue
protected class MonoSingleAssignment_0_1_Assignment_leftValue extends AssignmentToken  {
	
	public MonoSingleAssignment_0_1_Assignment_leftValue(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().ele01AssignmentLeftValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftValue",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftValue");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new SingleAssignmentValue_Alternatives(param, this).firstSolution();
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
protected class MonoSingleAssignment_1_Keyword extends KeywordToken  {
	
	public MonoSingleAssignment_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoSingleAssignment().ele1KeywordSemicolon();
	}	
}


/************ end Rule MonoSingleAssignment ****************/


/************ begin Rule MonoListAssignment ****************
 *
 * MonoListAssignment returns ListAssignment:   feature=ID "=" "[" (leftValues+=AssignmentValue ("," leftValues+=AssignmentValue)*)? "]" ";";
 *
 **/


// feature=ID "=" "[" (leftValues+=AssignmentValue ("," leftValues+=AssignmentValue)*)? "]" ";"
protected class MonoListAssignment_Group extends GroupToken {
	
	public MonoListAssignment_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoListAssignment_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoListAssignment_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "[" (leftValues+=AssignmentValue ("," leftValues+=AssignmentValue)*)? "]"
protected class MonoListAssignment_0_Group extends GroupToken {
	
	public MonoListAssignment_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoListAssignment_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoListAssignment_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "[" (leftValues+=AssignmentValue ("," leftValues+=AssignmentValue)*)?
protected class MonoListAssignment_0_0_Group extends GroupToken {
	
	public MonoListAssignment_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoListAssignment_0_0_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoListAssignment_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "=" "["
protected class MonoListAssignment_0_0_0_Group extends GroupToken {
	
	public MonoListAssignment_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoListAssignment_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoListAssignment_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID "="
protected class MonoListAssignment_0_0_0_0_Group extends GroupToken {
	
	public MonoListAssignment_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele0000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoListAssignment_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoListAssignment_0_0_0_0_0_Assignment_feature(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// feature=ID
protected class MonoListAssignment_0_0_0_0_0_Assignment_feature extends AssignmentToken  {
	
	public MonoListAssignment_0_0_0_0_0_Assignment_feature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele00000AssignmentFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("feature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("feature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele000000LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}

// "="
protected class MonoListAssignment_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public MonoListAssignment_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele00001KeywordEqualsSign();
	}	
}


// "["
protected class MonoListAssignment_0_0_0_1_Keyword extends KeywordToken  {
	
	public MonoListAssignment_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele0001KeywordLeftSquareBracket();
	}	
}


// (leftValues+=AssignmentValue ("," leftValues+=AssignmentValue)*)?
protected class MonoListAssignment_0_0_1_Group extends GroupToken {
	
	public MonoListAssignment_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoListAssignment_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoListAssignment_0_0_1_0_Assignment_leftValues(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// leftValues+=AssignmentValue
protected class MonoListAssignment_0_0_1_0_Assignment_leftValues extends AssignmentToken  {
	
	public MonoListAssignment_0_0_1_0_Assignment_leftValues(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele0010AssignmentLeftValues();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftValues",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftValues");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new AssignmentValue_Alternatives(param, this).firstSolution();
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

// ("," leftValues+=AssignmentValue)*
protected class MonoListAssignment_0_0_1_1_Group extends GroupToken {
	
	public MonoListAssignment_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele0011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new MonoListAssignment_0_0_1_1_1_Assignment_leftValues(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new MonoListAssignment_0_0_1_1_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class MonoListAssignment_0_0_1_1_0_Keyword extends KeywordToken  {
	
	public MonoListAssignment_0_0_1_1_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele00110KeywordComma();
	}	
}

// leftValues+=AssignmentValue
protected class MonoListAssignment_0_0_1_1_1_Assignment_leftValues extends AssignmentToken  {
	
	public MonoListAssignment_0_0_1_1_1_Assignment_leftValues(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele00111AssignmentLeftValues();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftValues",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftValues");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("AssignmentValue")) {
				Solution s = new AssignmentValue_Alternatives(param, this).firstSolution();
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




// "]"
protected class MonoListAssignment_0_1_Keyword extends KeywordToken  {
	
	public MonoListAssignment_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele01KeywordRightSquareBracket();
	}	
}


// ";"
protected class MonoListAssignment_1_Keyword extends KeywordToken  {
	
	public MonoListAssignment_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMonoListAssignment().ele1KeywordSemicolon();
	}	
}


/************ end Rule MonoListAssignment ****************/


/************ begin Rule AssignmentValue ****************
 *
 * AssignmentValue:   value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject|^import=[Import] impFrag=FRAGMENT;
 *
 **/


// value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject|^import=[Import] impFrag=FRAGMENT
protected class AssignmentValue_Alternatives extends AlternativesToken {

	public AssignmentValue_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AssignmentValue_1_Group(current, this) : new AssignmentValue_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject
protected class AssignmentValue_0_Alternatives extends AlternativesToken {

	public AssignmentValue_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AssignmentValue_0_1_Assignment_newObject(current, this) : new AssignmentValue_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class AssignmentValue_0_0_Alternatives extends AlternativesToken {

	public AssignmentValue_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele00Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new AssignmentValue_0_0_1_Group(current, this) : new AssignmentValue_0_0_0_Assignment_value(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// value=STRING
protected class AssignmentValue_0_0_0_Assignment_value extends AssignmentToken  {
	
	public AssignmentValue_0_0_0_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele000AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele0000LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}

// refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class AssignmentValue_0_0_1_Group extends GroupToken {
	
	public AssignmentValue_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AssignmentValue_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AssignmentValue_0_0_1_0_Assignment_refObject(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// refObject=[NamedObject]
protected class AssignmentValue_0_0_1_0_Assignment_refObject extends AssignmentToken  {
	
	public AssignmentValue_0_0_1_0_Assignment_refObject(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele0010AssignmentRefObject();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refObject",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refObject");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedObject")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele00100CrossReferenceEStringNamedObject(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class AssignmentValue_0_0_1_1_Group extends GroupToken {
	
	public AssignmentValue_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele0011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AssignmentValue_0_0_1_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AssignmentValue_0_0_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "." refFeature=ID
protected class AssignmentValue_0_0_1_1_0_Group extends GroupToken {
	
	public AssignmentValue_0_0_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele00110Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AssignmentValue_0_0_1_1_0_1_Assignment_refFeature(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AssignmentValue_0_0_1_1_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "."
protected class AssignmentValue_0_0_1_1_0_0_Keyword extends KeywordToken  {
	
	public AssignmentValue_0_0_1_1_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele001100KeywordFullStop();
	}	
}

// refFeature=ID
protected class AssignmentValue_0_0_1_1_0_1_Assignment_refFeature extends AssignmentToken  {
	
	public AssignmentValue_0_0_1_1_0_1_Assignment_refFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele001101AssignmentRefFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refFeature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refFeature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele0011010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("[" refIndex=INT "]")?
protected class AssignmentValue_0_0_1_1_1_Group extends GroupToken {
	
	public AssignmentValue_0_0_1_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele00111Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AssignmentValue_0_0_1_1_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AssignmentValue_0_0_1_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "[" refIndex=INT
protected class AssignmentValue_0_0_1_1_1_0_Group extends GroupToken {
	
	public AssignmentValue_0_0_1_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele001110Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AssignmentValue_0_0_1_1_1_0_1_Assignment_refIndex(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AssignmentValue_0_0_1_1_1_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class AssignmentValue_0_0_1_1_1_0_0_Keyword extends KeywordToken  {
	
	public AssignmentValue_0_0_1_1_1_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele0011100KeywordLeftSquareBracket();
	}	
}

// refIndex=INT
protected class AssignmentValue_0_0_1_1_1_0_1_Assignment_refIndex extends AssignmentToken  {
	
	public AssignmentValue_0_0_1_1_1_0_1_Assignment_refIndex(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele0011101AssignmentRefIndex();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refIndex",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refIndex");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele00111010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// "]"
protected class AssignmentValue_0_0_1_1_1_1_Keyword extends KeywordToken  {
	
	public AssignmentValue_0_0_1_1_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele001111KeywordRightSquareBracket();
	}	
}





// newObject=CreatedObject
protected class AssignmentValue_0_1_Assignment_newObject extends AssignmentToken  {
	
	public AssignmentValue_0_1_Assignment_newObject(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele01AssignmentNewObject();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("newObject",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("newObject");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("CreatedObject")) {
				Solution s = new CreatedObject_Group(param, this).firstSolution();
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


// ^import=[Import] impFrag=FRAGMENT
protected class AssignmentValue_1_Group extends GroupToken {
	
	public AssignmentValue_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new AssignmentValue_1_1_Assignment_impFrag(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new AssignmentValue_1_0_Assignment_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ^import=[Import]
protected class AssignmentValue_1_0_Assignment_import extends AssignmentToken  {
	
	public AssignmentValue_1_0_Assignment_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele10AssignmentImport();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("import",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("import");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Import")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele100CrossReferenceEStringImport(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// impFrag=FRAGMENT
protected class AssignmentValue_1_1_Assignment_impFrag extends AssignmentToken  {
	
	public AssignmentValue_1_1_Assignment_impFrag(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele11AssignmentImpFrag();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("impFrag",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("impFrag");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prAssignmentValue().ele110LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule AssignmentValue ****************/


/************ begin Rule ListAssignmentValue ****************
 *
 * ListAssignmentValue returns AssignmentValue:   index=INT ":" ("[" refIndex=INT "]"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject|^import=[Import] impFrag=FRAGMENT);
 *
 **/


// index=INT ":" ("[" refIndex=INT "]"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject|^import=[Import] impFrag=FRAGMENT)
protected class ListAssignmentValue_Group extends GroupToken {
	
	public ListAssignmentValue_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// index=INT ":"
protected class ListAssignmentValue_0_Group extends GroupToken {
	
	public ListAssignmentValue_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_0_0_Assignment_index(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// index=INT
protected class ListAssignmentValue_0_0_Assignment_index extends AssignmentToken  {
	
	public ListAssignmentValue_0_0_Assignment_index(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele00AssignmentIndex();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("index",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("index");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele000LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}

// ":"
protected class ListAssignmentValue_0_1_Keyword extends KeywordToken  {
	
	public ListAssignmentValue_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele01KeywordColon();
	}	
}


// "[" refIndex=INT "]"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject|^import=[Import] impFrag=FRAGMENT
protected class ListAssignmentValue_1_Alternatives extends AlternativesToken {

	public ListAssignmentValue_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ListAssignmentValue_1_1_Group(current, this) : new ListAssignmentValue_1_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "[" refIndex=INT "]"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject
protected class ListAssignmentValue_1_0_Alternatives extends AlternativesToken {

	public ListAssignmentValue_1_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ListAssignmentValue_1_0_1_Assignment_newObject(current, this) : new ListAssignmentValue_1_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "[" refIndex=INT "]"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class ListAssignmentValue_1_0_0_Alternatives extends AlternativesToken {

	public ListAssignmentValue_1_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ListAssignmentValue_1_0_0_1_Group(current, this) : new ListAssignmentValue_1_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "[" refIndex=INT "]"|value=STRING
protected class ListAssignmentValue_1_0_0_0_Alternatives extends AlternativesToken {

	public ListAssignmentValue_1_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1000Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new ListAssignmentValue_1_0_0_0_1_Assignment_value(current, this) : new ListAssignmentValue_1_0_0_0_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "[" refIndex=INT "]"
protected class ListAssignmentValue_1_0_0_0_0_Group extends GroupToken {
	
	public ListAssignmentValue_1_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_0_0_0_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_0_0_0_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "[" refIndex=INT
protected class ListAssignmentValue_1_0_0_0_0_0_Group extends GroupToken {
	
	public ListAssignmentValue_1_0_0_0_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100000Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_0_0_0_0_0_1_Assignment_refIndex(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_0_0_0_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class ListAssignmentValue_1_0_0_0_0_0_0_Keyword extends KeywordToken  {
	
	public ListAssignmentValue_1_0_0_0_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1000000KeywordLeftSquareBracket();
	}	
}

// refIndex=INT
protected class ListAssignmentValue_1_0_0_0_0_0_1_Assignment_refIndex extends AssignmentToken  {
	
	public ListAssignmentValue_1_0_0_0_0_0_1_Assignment_refIndex(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1000001AssignmentRefIndex();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refIndex",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refIndex");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10000010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// "]"
protected class ListAssignmentValue_1_0_0_0_0_1_Keyword extends KeywordToken  {
	
	public ListAssignmentValue_1_0_0_0_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100001KeywordRightSquareBracket();
	}	
}


// value=STRING
protected class ListAssignmentValue_1_0_0_0_1_Assignment_value extends AssignmentToken  {
	
	public ListAssignmentValue_1_0_0_0_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10001AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class ListAssignmentValue_1_0_0_1_Group extends GroupToken {
	
	public ListAssignmentValue_1_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_0_0_1_0_Assignment_refObject(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// refObject=[NamedObject]
protected class ListAssignmentValue_1_0_0_1_0_Assignment_refObject extends AssignmentToken  {
	
	public ListAssignmentValue_1_0_0_1_0_Assignment_refObject(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10010AssignmentRefObject();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refObject",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refObject");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedObject")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100100CrossReferenceEStringNamedObject(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class ListAssignmentValue_1_0_0_1_1_Group extends GroupToken {
	
	public ListAssignmentValue_1_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_0_0_1_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_0_0_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "." refFeature=ID
protected class ListAssignmentValue_1_0_0_1_1_0_Group extends GroupToken {
	
	public ListAssignmentValue_1_0_0_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100110Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_0_0_1_1_0_1_Assignment_refFeature(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_0_0_1_1_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "."
protected class ListAssignmentValue_1_0_0_1_1_0_0_Keyword extends KeywordToken  {
	
	public ListAssignmentValue_1_0_0_1_1_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1001100KeywordFullStop();
	}	
}

// refFeature=ID
protected class ListAssignmentValue_1_0_0_1_1_0_1_Assignment_refFeature extends AssignmentToken  {
	
	public ListAssignmentValue_1_0_0_1_1_0_1_Assignment_refFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1001101AssignmentRefFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refFeature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refFeature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10011010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("[" refIndex=INT "]")?
protected class ListAssignmentValue_1_0_0_1_1_1_Group extends GroupToken {
	
	public ListAssignmentValue_1_0_0_1_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100111Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_0_0_1_1_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_0_0_1_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "[" refIndex=INT
protected class ListAssignmentValue_1_0_0_1_1_1_0_Group extends GroupToken {
	
	public ListAssignmentValue_1_0_0_1_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1001110Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_0_0_1_1_1_0_1_Assignment_refIndex(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_0_0_1_1_1_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class ListAssignmentValue_1_0_0_1_1_1_0_0_Keyword extends KeywordToken  {
	
	public ListAssignmentValue_1_0_0_1_1_1_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10011100KeywordLeftSquareBracket();
	}	
}

// refIndex=INT
protected class ListAssignmentValue_1_0_0_1_1_1_0_1_Assignment_refIndex extends AssignmentToken  {
	
	public ListAssignmentValue_1_0_0_1_1_1_0_1_Assignment_refIndex(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele10011101AssignmentRefIndex();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refIndex",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refIndex");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele100111010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// "]"
protected class ListAssignmentValue_1_0_0_1_1_1_1_Keyword extends KeywordToken  {
	
	public ListAssignmentValue_1_0_0_1_1_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1001111KeywordRightSquareBracket();
	}	
}





// newObject=CreatedObject
protected class ListAssignmentValue_1_0_1_Assignment_newObject extends AssignmentToken  {
	
	public ListAssignmentValue_1_0_1_Assignment_newObject(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele101AssignmentNewObject();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("newObject",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("newObject");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("CreatedObject")) {
				Solution s = new CreatedObject_Group(param, this).firstSolution();
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


// ^import=[Import] impFrag=FRAGMENT
protected class ListAssignmentValue_1_1_Group extends GroupToken {
	
	public ListAssignmentValue_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele11Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ListAssignmentValue_1_1_1_Assignment_impFrag(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ListAssignmentValue_1_1_0_Assignment_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ^import=[Import]
protected class ListAssignmentValue_1_1_0_Assignment_import extends AssignmentToken  {
	
	public ListAssignmentValue_1_1_0_Assignment_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele110AssignmentImport();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("import",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("import");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Import")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1100CrossReferenceEStringImport(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// impFrag=FRAGMENT
protected class ListAssignmentValue_1_1_1_Assignment_impFrag extends AssignmentToken  {
	
	public ListAssignmentValue_1_1_1_Assignment_impFrag(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele111AssignmentImpFrag();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("impFrag",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("impFrag");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue().ele1110LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}




/************ end Rule ListAssignmentValue ****************/


/************ begin Rule SingleAssignmentValue ****************
 *
 * SingleAssignmentValue returns AssignmentValue:   keyword="null"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject|^import=[Import] impFrag=FRAGMENT;
 *
 **/


// keyword="null"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject|^import=[Import] impFrag=FRAGMENT
protected class SingleAssignmentValue_Alternatives extends AlternativesToken {

	public SingleAssignmentValue_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new SingleAssignmentValue_1_Group(current, this) : new SingleAssignmentValue_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// keyword="null"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?|newObject=CreatedObject
protected class SingleAssignmentValue_0_Alternatives extends AlternativesToken {

	public SingleAssignmentValue_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new SingleAssignmentValue_0_1_Assignment_newObject(current, this) : new SingleAssignmentValue_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// keyword="null"|value=STRING|refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class SingleAssignmentValue_0_0_Alternatives extends AlternativesToken {

	public SingleAssignmentValue_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele00Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new SingleAssignmentValue_0_0_1_Group(current, this) : new SingleAssignmentValue_0_0_0_Alternatives(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// keyword="null"|value=STRING
protected class SingleAssignmentValue_0_0_0_Alternatives extends AlternativesToken {

	public SingleAssignmentValue_0_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele000Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new SingleAssignmentValue_0_0_0_1_Assignment_value(current, this) : new SingleAssignmentValue_0_0_0_0_Assignment_keyword(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// keyword="null"
protected class SingleAssignmentValue_0_0_0_0_Assignment_keyword extends AssignmentToken  {
	
	public SingleAssignmentValue_0_0_0_0_Assignment_keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0000AssignmentKeyword();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("keyword",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("keyword");

		if("null".equals(value)) { // xtext::Keyword
			type = AssignmentType.KW;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele00000KeywordNull();
			return new Solution(obj);
		}

		return null;
	}
}

// value=STRING
protected class SingleAssignmentValue_0_0_0_1_Assignment_value extends AssignmentToken  {
	
	public SingleAssignmentValue_0_0_0_1_Assignment_value(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0001AssignmentValue();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("value",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("value");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele00010LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}


// refObject=[NamedObject] ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class SingleAssignmentValue_0_0_1_Group extends GroupToken {
	
	public SingleAssignmentValue_0_0_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele001Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SingleAssignmentValue_0_0_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SingleAssignmentValue_0_0_1_0_Assignment_refObject(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// refObject=[NamedObject]
protected class SingleAssignmentValue_0_0_1_0_Assignment_refObject extends AssignmentToken  {
	
	public SingleAssignmentValue_0_0_1_0_Assignment_refObject(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0010AssignmentRefObject();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refObject",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refObject");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedObject")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele00100CrossReferenceEStringNamedObject(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// ("." refFeature=ID ("[" refIndex=INT "]")?)?
protected class SingleAssignmentValue_0_0_1_1_Group extends GroupToken {
	
	public SingleAssignmentValue_0_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SingleAssignmentValue_0_0_1_1_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SingleAssignmentValue_0_0_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "." refFeature=ID
protected class SingleAssignmentValue_0_0_1_1_0_Group extends GroupToken {
	
	public SingleAssignmentValue_0_0_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele00110Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SingleAssignmentValue_0_0_1_1_0_1_Assignment_refFeature(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SingleAssignmentValue_0_0_1_1_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "."
protected class SingleAssignmentValue_0_0_1_1_0_0_Keyword extends KeywordToken  {
	
	public SingleAssignmentValue_0_0_1_1_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele001100KeywordFullStop();
	}	
}

// refFeature=ID
protected class SingleAssignmentValue_0_0_1_1_0_1_Assignment_refFeature extends AssignmentToken  {
	
	public SingleAssignmentValue_0_0_1_1_0_1_Assignment_refFeature(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele001101AssignmentRefFeature();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refFeature",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refFeature");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0011010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("[" refIndex=INT "]")?
protected class SingleAssignmentValue_0_0_1_1_1_Group extends GroupToken {
	
	public SingleAssignmentValue_0_0_1_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele00111Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SingleAssignmentValue_0_0_1_1_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SingleAssignmentValue_0_0_1_1_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "[" refIndex=INT
protected class SingleAssignmentValue_0_0_1_1_1_0_Group extends GroupToken {
	
	public SingleAssignmentValue_0_0_1_1_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele001110Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SingleAssignmentValue_0_0_1_1_1_0_1_Assignment_refIndex(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SingleAssignmentValue_0_0_1_1_1_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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
protected class SingleAssignmentValue_0_0_1_1_1_0_0_Keyword extends KeywordToken  {
	
	public SingleAssignmentValue_0_0_1_1_1_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0011100KeywordLeftSquareBracket();
	}	
}

// refIndex=INT
protected class SingleAssignmentValue_0_0_1_1_1_0_1_Assignment_refIndex extends AssignmentToken  {
	
	public SingleAssignmentValue_0_0_1_1_1_0_1_Assignment_refIndex(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele0011101AssignmentRefIndex();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("refIndex",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("refIndex");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele00111010LexerRuleCallINT();
			return new Solution(obj);
		}
		return null;
	}
}


// "]"
protected class SingleAssignmentValue_0_0_1_1_1_1_Keyword extends KeywordToken  {
	
	public SingleAssignmentValue_0_0_1_1_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele001111KeywordRightSquareBracket();
	}	
}





// newObject=CreatedObject
protected class SingleAssignmentValue_0_1_Assignment_newObject extends AssignmentToken  {
	
	public SingleAssignmentValue_0_1_Assignment_newObject(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele01AssignmentNewObject();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("newObject",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("newObject");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("CreatedObject")) {
				Solution s = new CreatedObject_Group(param, this).firstSolution();
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


// ^import=[Import] impFrag=FRAGMENT
protected class SingleAssignmentValue_1_Group extends GroupToken {
	
	public SingleAssignmentValue_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new SingleAssignmentValue_1_1_Assignment_impFrag(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new SingleAssignmentValue_1_0_Assignment_import(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ^import=[Import]
protected class SingleAssignmentValue_1_0_Assignment_import extends AssignmentToken  {
	
	public SingleAssignmentValue_1_0_Assignment_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele10AssignmentImport();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("import",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("import");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Import")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele100CrossReferenceEStringImport(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}

// impFrag=FRAGMENT
protected class SingleAssignmentValue_1_1_Assignment_impFrag extends AssignmentToken  {
	
	public SingleAssignmentValue_1_1_Assignment_impFrag(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele11AssignmentImpFrag();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("impFrag",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("impFrag");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue().ele110LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}



/************ end Rule SingleAssignmentValue ****************/


/************ begin Rule CreatedObject ****************
 *
 * CreatedObject:   (ObjectNew|ObjectCopy) (name=ID)? ("{" (assignments+=MonoSingleAssignment|assignments+=MonoListAssignment)+ (leftMig=Migration)? "}")?;
 *
 **/


// (ObjectNew|ObjectCopy) (name=ID)? ("{" (assignments+=MonoSingleAssignment|assignments+=MonoListAssignment)+ (leftMig=Migration)? "}")?
protected class CreatedObject_Group extends GroupToken {
	
	public CreatedObject_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new CreatedObject_1_Group(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CreatedObject_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// (ObjectNew|ObjectCopy) (name=ID)?
protected class CreatedObject_0_Group extends GroupToken {
	
	public CreatedObject_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new CreatedObject_0_1_Assignment_name(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CreatedObject_0_0_Alternatives(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// ObjectNew|ObjectCopy
protected class CreatedObject_0_0_Alternatives extends AlternativesToken {

	public CreatedObject_0_0_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele00Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new CreatedObject_0_0_1_RuleCall_ObjectCopy(current, this) : new CreatedObject_0_0_0_RuleCall_ObjectNew(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// ObjectNew
protected class CreatedObject_0_0_0_RuleCall_ObjectNew extends RuleCallToken {
	
	public CreatedObject_0_0_0_RuleCall_ObjectNew(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele000ParserRuleCallObjectNew();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ObjectNew_Group.class, current)) return null;
		if(!current.isInstanceOf("ObjectNew")) return null;
		return new ObjectNew_Group(current, this).firstSolution();
	}
}

// ObjectCopy
protected class CreatedObject_0_0_1_RuleCall_ObjectCopy extends RuleCallToken {
	
	public CreatedObject_0_0_1_RuleCall_ObjectCopy(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele001ParserRuleCallObjectCopy();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ObjectCopy_Group.class, current)) return null;
		if(!current.isInstanceOf("ObjectCopy")) return null;
		return new ObjectCopy_Group(current, this).firstSolution();
	}
}


// (name=ID)?
protected class CreatedObject_0_1_Assignment_name extends AssignmentToken  {
	
	public CreatedObject_0_1_Assignment_name(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele01AssignmentName();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("name",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("name");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// ("{" (assignments+=MonoSingleAssignment|assignments+=MonoListAssignment)+ (leftMig=Migration)? "}")?
protected class CreatedObject_1_Group extends GroupToken {
	
	public CreatedObject_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele1Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new CreatedObject_1_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CreatedObject_1_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "{" (assignments+=MonoSingleAssignment|assignments+=MonoListAssignment)+ (leftMig=Migration)?
protected class CreatedObject_1_0_Group extends GroupToken {
	
	public CreatedObject_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele10Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new CreatedObject_1_0_1_Assignment_leftMig(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CreatedObject_1_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "{" (assignments+=MonoSingleAssignment|assignments+=MonoListAssignment)+
protected class CreatedObject_1_0_0_Group extends GroupToken {
	
	public CreatedObject_1_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele100Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new CreatedObject_1_0_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new CreatedObject_1_0_0_0_Keyword(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "{"
protected class CreatedObject_1_0_0_0_Keyword extends KeywordToken  {
	
	public CreatedObject_1_0_0_0_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele1000KeywordLeftCurlyBracket();
	}	
}

// (assignments+=MonoSingleAssignment|assignments+=MonoListAssignment)+
protected class CreatedObject_1_0_0_1_Alternatives extends AlternativesToken {

	public CreatedObject_1_0_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele1001Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new CreatedObject_1_0_0_1_1_Assignment_assignments(current, this) : new CreatedObject_1_0_0_1_0_Assignment_assignments(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// assignments+=MonoSingleAssignment
protected class CreatedObject_1_0_0_1_0_Assignment_assignments extends AssignmentToken  {
	
	public CreatedObject_1_0_0_1_0_Assignment_assignments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele10010AssignmentAssignments();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("assignments",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("assignments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("SingleAssignment")) {
				Solution s = new MonoSingleAssignment_Group(param, this).firstSolution();
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

// assignments+=MonoListAssignment
protected class CreatedObject_1_0_0_1_1_Assignment_assignments extends AssignmentToken  {
	
	public CreatedObject_1_0_0_1_1_Assignment_assignments(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele10011AssignmentAssignments();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("assignments",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("assignments");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("ListAssignment")) {
				Solution s = new MonoListAssignment_Group(param, this).firstSolution();
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



// (leftMig=Migration)?
protected class CreatedObject_1_0_1_Assignment_leftMig extends AssignmentToken  {
	
	public CreatedObject_1_0_1_Assignment_leftMig(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele101AssignmentLeftMig();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("leftMig",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("leftMig");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Migration")) {
				Solution s = new Migration_Group(param, this).firstSolution();
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
protected class CreatedObject_1_1_Keyword extends KeywordToken  {
	
	public CreatedObject_1_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject().ele11KeywordRightCurlyBracket();
	}	
}



/************ end Rule CreatedObject ****************/


/************ begin Rule ObjectNew ****************
 *
 * ObjectNew:   "new" ^import=[Import] impFrag=FRAGMENT;
 *
 **/


// "new" ^import=[Import] impFrag=FRAGMENT
protected class ObjectNew_Group extends GroupToken {
	
	public ObjectNew_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectNew().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectNew_1_Assignment_impFrag(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectNew_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "new" ^import=[Import]
protected class ObjectNew_0_Group extends GroupToken {
	
	public ObjectNew_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectNew().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectNew_0_1_Assignment_import(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectNew_0_0_Keyword_new(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "new"
protected class ObjectNew_0_0_Keyword_new extends KeywordToken  {
	
	public ObjectNew_0_0_Keyword_new(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectNew().ele00KeywordNew();
	}	
}

// ^import=[Import]
protected class ObjectNew_0_1_Assignment_import extends AssignmentToken  {
	
	public ObjectNew_0_1_Assignment_import(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectNew().ele01AssignmentImport();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("import",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("import");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Import")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectNew().ele010CrossReferenceEStringImport(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// impFrag=FRAGMENT
protected class ObjectNew_1_Assignment_impFrag extends AssignmentToken  {
	
	public ObjectNew_1_Assignment_impFrag(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectNew().ele1AssignmentImpFrag();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("impFrag",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("impFrag");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectNew().ele10LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule ObjectNew ****************/


/************ begin Rule ObjectCopy ****************
 *
 * ObjectCopy:   "copy" resource=[NamedResource] fragment=FRAGMENT;
 *
 **/


// "copy" resource=[NamedResource] fragment=FRAGMENT
protected class ObjectCopy_Group extends GroupToken {
	
	public ObjectCopy_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectCopy_1_Assignment_fragment(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectCopy_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "copy" resource=[NamedResource]
protected class ObjectCopy_0_Group extends GroupToken {
	
	public ObjectCopy_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new ObjectCopy_0_1_Assignment_resource(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new ObjectCopy_0_0_Keyword_copy(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "copy"
protected class ObjectCopy_0_0_Keyword_copy extends KeywordToken  {
	
	public ObjectCopy_0_0_Keyword_copy(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy().ele00KeywordCopy();
	}	
}

// resource=[NamedResource]
protected class ObjectCopy_0_1_Assignment_resource extends AssignmentToken  {
	
	public ObjectCopy_0_1_Assignment_resource(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy().ele01AssignmentResource();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("resource",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("resource");
		if(value instanceof EObject) { // xtext::CrossReference
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("NamedResource")) {
				type = AssignmentType.CR;
				element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy().ele010CrossReferenceEStringNamedResource(); 
				return new Solution(obj);
			}
		}
		return null;
	}
}


// fragment=FRAGMENT
protected class ObjectCopy_1_Assignment_fragment extends AssignmentToken  {
	
	public ObjectCopy_1_Assignment_fragment(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy().ele1AssignmentFragment();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("fragment",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("fragment");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy().ele10LexerRuleCallFRAGMENT();
			return new Solution(obj);
		}
		return null;
	}
}


/************ end Rule ObjectCopy ****************/


/************ begin Rule Migration ****************
 *
 * Migration:   "migrate" (first=Executable)? ("as" asOp=Executable|"each" eachOp=Executable)? ";";
 *
 **/


// "migrate" (first=Executable)? ("as" asOp=Executable|"each" eachOp=Executable)? ";"
protected class Migration_Group extends GroupToken {
	
	public Migration_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Migration_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Migration_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "migrate" (first=Executable)? ("as" asOp=Executable|"each" eachOp=Executable)?
protected class Migration_0_Group extends GroupToken {
	
	public Migration_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Migration_0_1_Alternatives(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Migration_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "migrate" (first=Executable)?
protected class Migration_0_0_Group extends GroupToken {
	
	public Migration_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Migration_0_0_1_Assignment_first(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Migration_0_0_0_Keyword_migrate(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "migrate"
protected class Migration_0_0_0_Keyword_migrate extends KeywordToken  {
	
	public Migration_0_0_0_Keyword_migrate(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele000KeywordMigrate();
	}	
}

// (first=Executable)?
protected class Migration_0_0_1_Assignment_first extends AssignmentToken  {
	
	public Migration_0_0_1_Assignment_first(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele001AssignmentFirst();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("first",!IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("first");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Executable")) {
				Solution s = new Executable_Alternatives(param, this).firstSolution();
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


// ("as" asOp=Executable|"each" eachOp=Executable)?
protected class Migration_0_1_Alternatives extends AlternativesToken {

	public Migration_0_1_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, !IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele01Alternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Migration_0_1_1_Group(current, this) : new Migration_0_1_0_Group(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// "as" asOp=Executable
protected class Migration_0_1_0_Group extends GroupToken {
	
	public Migration_0_1_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele010Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Migration_0_1_0_1_Assignment_asOp(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Migration_0_1_0_0_Keyword_as(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "as"
protected class Migration_0_1_0_0_Keyword_as extends KeywordToken  {
	
	public Migration_0_1_0_0_Keyword_as(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele0100KeywordAs();
	}	
}

// asOp=Executable
protected class Migration_0_1_0_1_Assignment_asOp extends AssignmentToken  {
	
	public Migration_0_1_0_1_Assignment_asOp(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele0101AssignmentAsOp();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("asOp",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("asOp");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Executable")) {
				Solution s = new Executable_Alternatives(param, this).firstSolution();
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


// "each" eachOp=Executable
protected class Migration_0_1_1_Group extends GroupToken {
	
	public Migration_0_1_1_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele011Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new Migration_0_1_1_1_Assignment_eachOp(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new Migration_0_1_1_0_Keyword_each(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "each"
protected class Migration_0_1_1_0_Keyword_each extends KeywordToken  {
	
	public Migration_0_1_1_0_Keyword_each(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele0110KeywordEach();
	}	
}

// eachOp=Executable
protected class Migration_0_1_1_1_Assignment_eachOp extends AssignmentToken  {
	
	public Migration_0_1_1_1_Assignment_eachOp(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele0111AssignmentEachOp();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("eachOp",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("eachOp");

		if(value instanceof EObject) { // xtext::RuleCall
			IInstanceDescription param = getDescr((EObject)value);
			if(param.isInstanceOf("Executable")) {
				Solution s = new Executable_Alternatives(param, this).firstSolution();
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
protected class Migration_1_Keyword extends KeywordToken  {
	
	public Migration_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prMigration().ele1KeywordSemicolon();
	}	
}


/************ end Rule Migration ****************/


/************ begin Rule Executable ****************
 *
 * Executable:   JavaExecutable|ExpressionExecutable;
 *
 **/


// JavaExecutable|ExpressionExecutable
protected class Executable_Alternatives extends AlternativesToken {

	public Executable_Alternatives(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Alternatives getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExecutable().eleAlternatives();
	}

	@Override	
	protected Solution createSolution() {
		AbstractToken t = (first) ? new Executable_1_RuleCall_ExpressionExecutable(current, this) : new Executable_0_RuleCall_JavaExecutable(current, this);
		Solution s = t.firstSolution();
		if(s == null && activateNextSolution()) s = createSolution();
		if(s == null) return null;
		last = s.getPredecessor();
		return s; 
	}
}

// JavaExecutable
protected class Executable_0_RuleCall_JavaExecutable extends RuleCallToken {
	
	public Executable_0_RuleCall_JavaExecutable(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExecutable().ele0ParserRuleCallJavaExecutable();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(JavaExecutable_Group.class, current)) return null;
		if(!current.isInstanceOf("JavaExecutable")) return null;
		return new JavaExecutable_Group(current, this).firstSolution();
	}
}

// ExpressionExecutable
protected class Executable_1_RuleCall_ExpressionExecutable extends RuleCallToken {
	
	public Executable_1_RuleCall_ExpressionExecutable(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public RuleCall getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExecutable().ele1ParserRuleCallExpressionExecutable();
	}
	
	@Override
	protected Solution createSolution() {
		if(checkForRecursion(ExpressionExecutable_Assignment_exprstr.class, current)) return null;
		if(!current.isInstanceOf("ExpressionExecutable")) return null;
		return new ExpressionExecutable_Assignment_exprstr(current, this).firstSolution();
	}
}


/************ end Rule Executable ****************/


/************ begin Rule JavaExecutable ****************
 *
 * JavaExecutable:   "java" method=ID "(" ")";
 *
 **/


// "java" method=ID "(" ")"
protected class JavaExecutable_Group extends GroupToken {
	
	public JavaExecutable_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().eleGroup();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new JavaExecutable_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new JavaExecutable_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "java" method=ID "("
protected class JavaExecutable_0_Group extends GroupToken {
	
	public JavaExecutable_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().ele0Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new JavaExecutable_0_1_Keyword(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new JavaExecutable_0_0_Group(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "java" method=ID
protected class JavaExecutable_0_0_Group extends GroupToken {
	
	public JavaExecutable_0_0_Group(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Group getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().ele00Group();
	}
		
	@Override
	protected Solution createSolution() {	
		Solution s1 = new JavaExecutable_0_0_1_Assignment_method(current, this).firstSolution();
		while(s1 != null) {
			Solution s2 = new JavaExecutable_0_0_0_Keyword_java(s1.getCurrent(), s1.getPredecessor()).firstSolution();
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

// "java"
protected class JavaExecutable_0_0_0_Keyword_java extends KeywordToken  {
	
	public JavaExecutable_0_0_0_Keyword_java(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().ele000KeywordJava();
	}	
}

// method=ID
protected class JavaExecutable_0_0_1_Assignment_method extends AssignmentToken  {
	
	public JavaExecutable_0_0_1_Assignment_method(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().ele001AssignmentMethod();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("method",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("method");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().ele0010LexerRuleCallID();
			return new Solution(obj);
		}
		return null;
	}
}


// "("
protected class JavaExecutable_0_1_Keyword extends KeywordToken  {
	
	public JavaExecutable_0_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().ele01KeywordLeftParenthesis();
	}	
}


// ")"
protected class JavaExecutable_1_Keyword extends KeywordToken  {
	
	public JavaExecutable_1_Keyword(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Keyword getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prJavaExecutable().ele1KeywordRightParenthesis();
	}	
}


/************ end Rule JavaExecutable ****************/


/************ begin Rule ExpressionExecutable ****************
 *
 * ExpressionExecutable:   exprstr=STRING;
 *
 **/


// exprstr=STRING
protected class ExpressionExecutable_Assignment_exprstr extends AssignmentToken  {
	
	public ExpressionExecutable_Assignment_exprstr(IInstanceDescription curr, AbstractToken pred) {
		super(curr, pred, !IS_MANY, IS_REQUIRED);
	}
	
	public Assignment getGrammarElement() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prExpressionExecutable().eleAssignmentExprstr();
	}
	
	@Override
	protected Solution createSolution() {
		if((value = current.getConsumable("exprstr",IS_REQUIRED)) == null) return null;
		IInstanceDescription obj = current.cloneAndConsume("exprstr");
		if(Boolean.TRUE.booleanValue()) { // xtext::RuleCall FIXME: check if value is valid for lexer rule
			type = AssignmentType.LRC;
			element = EpatchTestLanguageGrammarAccess.INSTANCE.prExpressionExecutable().ele0LexerRuleCallSTRING();
			return new Solution(obj);
		}
		return null;
	}
}

/************ end Rule ExpressionExecutable ****************/

}
