/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class PartialParserTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ContainerElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordContainer;
		private Assignment c0001AssignmentName;
		private RuleCall c00010LexerRuleCallID;
		private Keyword c001Keyword;
		private Alternatives c01Alternatives;
		private Assignment c010AssignmentNested;
		private RuleCall c0100ParserRuleCallNested;
		private Assignment c011AssignmentContent;
		private RuleCall c0110ParserRuleCallContent;
		private Keyword c1Keyword;
		
		// Container : 'container' name = ID '{' ( nested += Nested | content += Content ) * '}' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// 'container' name = ID '{' ( nested += Nested | content += Content ) * '}'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'container' name = ID '{' ( nested += Nested | content += Content ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'container' name = ID '{'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'container' name = ID
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'container'
		public Keyword ele0000KeywordContainer() {
			return (c0000KeywordContainer != null) ? c0000KeywordContainer : (c0000KeywordContainer = (Keyword)ele000Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0001AssignmentName() {
			return (c0001AssignmentName != null) ? c0001AssignmentName : (c0001AssignmentName = (Assignment)ele000Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele00010LexerRuleCallID() {
			return (c00010LexerRuleCallID != null) ? c00010LexerRuleCallID : (c00010LexerRuleCallID = (RuleCall)ele0001AssignmentName().eContents().get(0)); 
		}

		// '{'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// ( nested += Nested | content += Content ) *
		public Alternatives ele01Alternatives() {
			return (c01Alternatives != null) ? c01Alternatives : (c01Alternatives = (Alternatives)ele0Group().eContents().get(1)); 
		}

		// nested += Nested
		public Assignment ele010AssignmentNested() {
			return (c010AssignmentNested != null) ? c010AssignmentNested : (c010AssignmentNested = (Assignment)ele01Alternatives().eContents().get(0)); 
		}

		// Nested
		public RuleCall ele0100ParserRuleCallNested() {
			return (c0100ParserRuleCallNested != null) ? c0100ParserRuleCallNested : (c0100ParserRuleCallNested = (RuleCall)ele010AssignmentNested().eContents().get(0)); 
		}

		// content += Content
		public Assignment ele011AssignmentContent() {
			return (c011AssignmentContent != null) ? c011AssignmentContent : (c011AssignmentContent = (Assignment)ele01Alternatives().eContents().get(1)); 
		}

		// Content
		public RuleCall ele0110ParserRuleCallContent() {
			return (c0110ParserRuleCallContent != null) ? c0110ParserRuleCallContent : (c0110ParserRuleCallContent = (RuleCall)ele011AssignmentContent().eContents().get(0)); 
		}

		// '}'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class NestedElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordNested;
		private Keyword c001Keyword;
		private Assignment c01AssignmentNested;
		private RuleCall c010ParserRuleCallContainer;
		private Keyword c1Keyword;
		
		// Nested : 'nested' '{' ( nested += Container ) + '}' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// 'nested' '{' ( nested += Container ) + '}'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'nested' '{' ( nested += Container ) +
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'nested' '{'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'nested'
		public Keyword ele000KeywordNested() {
			return (c000KeywordNested != null) ? c000KeywordNested : (c000KeywordNested = (Keyword)ele00Group().eContents().get(0)); 
		}

		// '{'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// ( nested += Container ) +
		public Assignment ele01AssignmentNested() {
			return (c01AssignmentNested != null) ? c01AssignmentNested : (c01AssignmentNested = (Assignment)ele0Group().eContents().get(1)); 
		}

		// Container
		public RuleCall ele010ParserRuleCallContainer() {
			return (c010ParserRuleCallContainer != null) ? c010ParserRuleCallContainer : (c010ParserRuleCallContainer = (RuleCall)ele01AssignmentNested().eContents().get(0)); 
		}

		// '}'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class ContentElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallChildren;
		private RuleCall c1ParserRuleCallAbstractChildren;
		
		// Content : Children | AbstractChildren ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// Children | AbstractChildren
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(0)); 
		}

		// Children
		public RuleCall ele0ParserRuleCallChildren() {
			return (c0ParserRuleCallChildren != null) ? c0ParserRuleCallChildren : (c0ParserRuleCallChildren = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// AbstractChildren
		public RuleCall ele1ParserRuleCallAbstractChildren() {
			return (c1ParserRuleCallAbstractChildren != null) ? c1ParserRuleCallAbstractChildren : (c1ParserRuleCallAbstractChildren = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class ChildrenElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordChildren;
		private Keyword c0001Keyword;
		private Assignment c001AssignmentChildren;
		private RuleCall c0010ParserRuleCallChild;
		private Group c01Group;
		private Keyword c010Keyword;
		private Assignment c011AssignmentChildren;
		private RuleCall c0110ParserRuleCallChild;
		private Keyword c1Keyword;
		
		// Children : 'children' '{' children += Child ( ',' children += Child ) * '}' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// 'children' '{' children += Child ( ',' children += Child ) * '}'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'children' '{' children += Child ( ',' children += Child ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'children' '{' children += Child
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'children' '{'
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'children'
		public Keyword ele0000KeywordChildren() {
			return (c0000KeywordChildren != null) ? c0000KeywordChildren : (c0000KeywordChildren = (Keyword)ele000Group().eContents().get(0)); 
		}

		// '{'
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// children += Child
		public Assignment ele001AssignmentChildren() {
			return (c001AssignmentChildren != null) ? c001AssignmentChildren : (c001AssignmentChildren = (Assignment)ele00Group().eContents().get(1)); 
		}

		// Child
		public RuleCall ele0010ParserRuleCallChild() {
			return (c0010ParserRuleCallChild != null) ? c0010ParserRuleCallChild : (c0010ParserRuleCallChild = (RuleCall)ele001AssignmentChildren().eContents().get(0)); 
		}

		// ( ',' children += Child ) *
		public Group ele01Group() {
			return (c01Group != null) ? c01Group : (c01Group = (Group)ele0Group().eContents().get(1)); 
		}

		// ','
		public Keyword ele010Keyword() {
			return (c010Keyword != null) ? c010Keyword : (c010Keyword = (Keyword)ele01Group().eContents().get(0)); 
		}

		// children += Child
		public Assignment ele011AssignmentChildren() {
			return (c011AssignmentChildren != null) ? c011AssignmentChildren : (c011AssignmentChildren = (Assignment)ele01Group().eContents().get(1)); 
		}

		// Child
		public RuleCall ele0110ParserRuleCallChild() {
			return (c0110ParserRuleCallChild != null) ? c0110ParserRuleCallChild : (c0110ParserRuleCallChild = (RuleCall)ele011AssignmentChildren().eContents().get(0)); 
		}

		// '}'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class ChildElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000Keyword;
		private Keyword c0001KeywordC;
		private Keyword c001Keyword;
		private Assignment c01AssignmentValue;
		private RuleCall c010ParserRuleCallNamed;
		private Keyword c1Keyword;
		
		// Child : '->' 'C' '(' value = Named ')' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// '->' 'C' '(' value = Named ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '->' 'C' '(' value = Named
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '->' 'C' '('
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// '->' 'C'
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// '->'
		public Keyword ele0000Keyword() {
			return (c0000Keyword != null) ? c0000Keyword : (c0000Keyword = (Keyword)ele000Group().eContents().get(0)); 
		}

		// 'C'
		public Keyword ele0001KeywordC() {
			return (c0001KeywordC != null) ? c0001KeywordC : (c0001KeywordC = (Keyword)ele000Group().eContents().get(1)); 
		}

		// '('
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// value = Named
		public Assignment ele01AssignmentValue() {
			return (c01AssignmentValue != null) ? c01AssignmentValue : (c01AssignmentValue = (Assignment)ele0Group().eContents().get(1)); 
		}

		// Named
		public RuleCall ele010ParserRuleCallNamed() {
			return (c010ParserRuleCallNamed != null) ? c010ParserRuleCallNamed : (c010ParserRuleCallNamed = (RuleCall)ele01AssignmentValue().eContents().get(0)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class AbstractChildrenElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordAbstractChildren;
		private Keyword c001Keyword;
		private Assignment c01AssignmentAbstractChildren;
		private RuleCall c010ParserRuleCallAbstractChild;
		private Keyword c1Keyword;
		
		// AbstractChildren : 'abstract children' '{' ( abstractChildren += AbstractChild ) + '}' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(6)); 
		}

		// 'abstract children' '{' ( abstractChildren += AbstractChild ) + '}'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'abstract children' '{' ( abstractChildren += AbstractChild ) +
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'abstract children' '{'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'abstract children'
		public Keyword ele000KeywordAbstractChildren() {
			return (c000KeywordAbstractChildren != null) ? c000KeywordAbstractChildren : (c000KeywordAbstractChildren = (Keyword)ele00Group().eContents().get(0)); 
		}

		// '{'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// ( abstractChildren += AbstractChild ) +
		public Assignment ele01AssignmentAbstractChildren() {
			return (c01AssignmentAbstractChildren != null) ? c01AssignmentAbstractChildren : (c01AssignmentAbstractChildren = (Assignment)ele0Group().eContents().get(1)); 
		}

		// AbstractChild
		public RuleCall ele010ParserRuleCallAbstractChild() {
			return (c010ParserRuleCallAbstractChild != null) ? c010ParserRuleCallAbstractChild : (c010ParserRuleCallAbstractChild = (RuleCall)ele01AssignmentAbstractChildren().eContents().get(0)); 
		}

		// '}'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class AbstractChildElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallFirstConcrete;
		private RuleCall c1ParserRuleCallSecondConcrete;
		
		// AbstractChild : FirstConcrete | SecondConcrete ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(7)); 
		}

		// FirstConcrete | SecondConcrete
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(0)); 
		}

		// FirstConcrete
		public RuleCall ele0ParserRuleCallFirstConcrete() {
			return (c0ParserRuleCallFirstConcrete != null) ? c0ParserRuleCallFirstConcrete : (c0ParserRuleCallFirstConcrete = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// SecondConcrete
		public RuleCall ele1ParserRuleCallSecondConcrete() {
			return (c1ParserRuleCallSecondConcrete != null) ? c1ParserRuleCallSecondConcrete : (c1ParserRuleCallSecondConcrete = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class FirstConcreteElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Keyword c00000Keyword;
		private Keyword c00001KeywordF;
		private Keyword c0001Keyword;
		private Assignment c001AssignmentValue;
		private RuleCall c0010ParserRuleCallNamed;
		private Assignment c01AssignmentReferencedContainer;
		private CrossReference c010CrossReferenceContainer;
		private Keyword c1Keyword;
		
		// FirstConcrete : '->' 'F' '(' value = Named ( referencedContainer = [ Container ] ) ? ')' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(8)); 
		}

		// '->' 'F' '(' value = Named ( referencedContainer = [ Container ] ) ? ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '->' 'F' '(' value = Named ( referencedContainer = [ Container ] ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '->' 'F' '(' value = Named
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// '->' 'F' '('
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// '->' 'F'
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// '->'
		public Keyword ele00000Keyword() {
			return (c00000Keyword != null) ? c00000Keyword : (c00000Keyword = (Keyword)ele0000Group().eContents().get(0)); 
		}

		// 'F'
		public Keyword ele00001KeywordF() {
			return (c00001KeywordF != null) ? c00001KeywordF : (c00001KeywordF = (Keyword)ele0000Group().eContents().get(1)); 
		}

		// '('
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// value = Named
		public Assignment ele001AssignmentValue() {
			return (c001AssignmentValue != null) ? c001AssignmentValue : (c001AssignmentValue = (Assignment)ele00Group().eContents().get(1)); 
		}

		// Named
		public RuleCall ele0010ParserRuleCallNamed() {
			return (c0010ParserRuleCallNamed != null) ? c0010ParserRuleCallNamed : (c0010ParserRuleCallNamed = (RuleCall)ele001AssignmentValue().eContents().get(0)); 
		}

		// ( referencedContainer = [ Container ] ) ?
		public Assignment ele01AssignmentReferencedContainer() {
			return (c01AssignmentReferencedContainer != null) ? c01AssignmentReferencedContainer : (c01AssignmentReferencedContainer = (Assignment)ele0Group().eContents().get(1)); 
		}

		// [ Container ]
		public CrossReference ele010CrossReferenceContainer() {
			return (c010CrossReferenceContainer != null) ? c010CrossReferenceContainer : (c010CrossReferenceContainer = (CrossReference)ele01AssignmentReferencedContainer().eContents().get(0)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class SecondConcreteElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Group c00000Group;
		private Keyword c000000Keyword;
		private Keyword c000001KeywordF;
		private Keyword c00001KeywordS;
		private Keyword c0001Keyword;
		private Assignment c001AssignmentValue;
		private RuleCall c0010ParserRuleCallNamed;
		private Assignment c01AssignmentReferencedChildren;
		private CrossReference c010CrossReferenceChild;
		private Keyword c1Keyword;
		
		// SecondConcrete : '->' 'F' 'S' '(' value = Named ( referencedChildren += [ Child ] ) ? ')' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(9)); 
		}

		// '->' 'F' 'S' '(' value = Named ( referencedChildren += [ Child ] ) ? ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '->' 'F' 'S' '(' value = Named ( referencedChildren += [ Child ] ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '->' 'F' 'S' '(' value = Named
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// '->' 'F' 'S' '('
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// '->' 'F' 'S'
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// '->' 'F'
		public Group ele00000Group() {
			return (c00000Group != null) ? c00000Group : (c00000Group = (Group)ele0000Group().eContents().get(0)); 
		}

		// '->'
		public Keyword ele000000Keyword() {
			return (c000000Keyword != null) ? c000000Keyword : (c000000Keyword = (Keyword)ele00000Group().eContents().get(0)); 
		}

		// 'F'
		public Keyword ele000001KeywordF() {
			return (c000001KeywordF != null) ? c000001KeywordF : (c000001KeywordF = (Keyword)ele00000Group().eContents().get(1)); 
		}

		// 'S'
		public Keyword ele00001KeywordS() {
			return (c00001KeywordS != null) ? c00001KeywordS : (c00001KeywordS = (Keyword)ele0000Group().eContents().get(1)); 
		}

		// '('
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// value = Named
		public Assignment ele001AssignmentValue() {
			return (c001AssignmentValue != null) ? c001AssignmentValue : (c001AssignmentValue = (Assignment)ele00Group().eContents().get(1)); 
		}

		// Named
		public RuleCall ele0010ParserRuleCallNamed() {
			return (c0010ParserRuleCallNamed != null) ? c0010ParserRuleCallNamed : (c0010ParserRuleCallNamed = (RuleCall)ele001AssignmentValue().eContents().get(0)); 
		}

		// ( referencedChildren += [ Child ] ) ?
		public Assignment ele01AssignmentReferencedChildren() {
			return (c01AssignmentReferencedChildren != null) ? c01AssignmentReferencedChildren : (c01AssignmentReferencedChildren = (Assignment)ele0Group().eContents().get(1)); 
		}

		// [ Child ]
		public CrossReference ele010CrossReferenceChild() {
			return (c010CrossReferenceChild != null) ? c010CrossReferenceChild : (c010CrossReferenceChild = (CrossReference)ele01AssignmentReferencedChildren().eContents().get(0)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class NamedElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentName;
		private RuleCall c0LexerRuleCallID;
		
		// Named : name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(10)); 
		}

		// name = ID
		public Assignment eleAssignmentName() {
			return (cAssignmentName != null) ? cAssignmentName : (cAssignmentName = (Assignment)getRule().eContents().get(0)); 
		}

		// ID
		public RuleCall ele0LexerRuleCallID() {
			return (c0LexerRuleCallID != null) ? c0LexerRuleCallID : (c0LexerRuleCallID = (RuleCall)eleAssignmentName().eContents().get(0)); 
		}
	}
	
	public final static PartialParserTestLanguageGrammarAccess INSTANCE = new PartialParserTestLanguageGrammarAccess();

	private static final String PARTIALPARSERTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ContainerElements pContainer;
	private static NestedElements pNested;
	private static ContentElements pContent;
	private static ChildrenElements pChildren;
	private static ChildElements pChild;
	private static AbstractChildrenElements pAbstractChildren;
	private static AbstractChildElements pAbstractChild;
	private static FirstConcreteElements pFirstConcrete;
	private static SecondConcreteElements pSecondConcrete;
	private static NamedElements pNamed;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(PartialParserTestLanguageGrammarAccess.class.getClassLoader(),PARTIALPARSERTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Container : 'container' name = ID '{' ( nested += Nested | content += Content ) * '}' ;
	public ContainerElements prContainer() {
		return (pContainer != null) ? pContainer : (pContainer = new ContainerElements());
	} 

	// Nested : 'nested' '{' ( nested += Container ) + '}' ;
	public NestedElements prNested() {
		return (pNested != null) ? pNested : (pNested = new NestedElements());
	} 

	// Content : Children | AbstractChildren ;
	public ContentElements prContent() {
		return (pContent != null) ? pContent : (pContent = new ContentElements());
	} 

	// Children : 'children' '{' children += Child ( ',' children += Child ) * '}' ;
	public ChildrenElements prChildren() {
		return (pChildren != null) ? pChildren : (pChildren = new ChildrenElements());
	} 

	// Child : '->' 'C' '(' value = Named ')' ;
	public ChildElements prChild() {
		return (pChild != null) ? pChild : (pChild = new ChildElements());
	} 

	// AbstractChildren : 'abstract children' '{' ( abstractChildren += AbstractChild ) + '}' ;
	public AbstractChildrenElements prAbstractChildren() {
		return (pAbstractChildren != null) ? pAbstractChildren : (pAbstractChildren = new AbstractChildrenElements());
	} 

	// AbstractChild : FirstConcrete | SecondConcrete ;
	public AbstractChildElements prAbstractChild() {
		return (pAbstractChild != null) ? pAbstractChild : (pAbstractChild = new AbstractChildElements());
	} 

	// FirstConcrete : '->' 'F' '(' value = Named ( referencedContainer = [ Container ] ) ? ')' ;
	public FirstConcreteElements prFirstConcrete() {
		return (pFirstConcrete != null) ? pFirstConcrete : (pFirstConcrete = new FirstConcreteElements());
	} 

	// SecondConcrete : '->' 'F' 'S' '(' value = Named ( referencedChildren += [ Child ] ) ? ')' ;
	public SecondConcreteElements prSecondConcrete() {
		return (pSecondConcrete != null) ? pSecondConcrete : (pSecondConcrete = new SecondConcreteElements());
	} 

	// Named : name = ID ;
	public NamedElements prNamed() {
		return (pNamed != null) ? pNamed : (pNamed = new NamedElements());
	} 
}
