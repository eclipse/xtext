grammar InternalXpression_debugme;

options {
	backtrack=true;
	
}

entryRuleExpression :
	 ruleExpression 
	 EOF 
;



// Rule Expression
ruleExpression :
	ruleAssignment
;



// Rule Assignment
ruleAssignment :
(	ruleOrExpression(()(	
	'=' 

    |
	'+=' 
)(		ruleOrExpression))?)
;



// Rule OrExpression
ruleOrExpression :
(	ruleAndExpression(()(	
	'||' 
)(		ruleAndExpression))*)
;



// Rule AndExpression
ruleAndExpression :
(	ruleEqualityExpression(()(	
	'&&' 
)(		ruleEqualityExpression))*)
;



// Rule EqualityExpression
ruleEqualityExpression :
(	ruleRelationalExpression(()(	
	'==' 

    |
	'!=' 
)(		ruleRelationalExpression))*)
;



// Rule RelationalExpression
ruleRelationalExpression :
(	ruleAdditiveExpression((()
	'instanceof' 
(			ruleQualifiedName))
    |(()(	
	'>=' 

    |
	'<=' 

    |
	'>' 

    |
	'<' 
)(		ruleAdditiveExpression)))*)
;



// Rule AdditiveExpression
ruleAdditiveExpression :
(	ruleMultiplicativeExpression(()(	
	'+' 

    |
	'-' 
)(		ruleMultiplicativeExpression))*)
;



// Rule MultiplicativeExpression
ruleMultiplicativeExpression :
(	ruleOtherOperatorExpression(()(	
	'*' 

    |
	'/' 

    |
	'%' 
)(		ruleOtherOperatorExpression))*)
;



// Rule OtherOperatorExpression
ruleOtherOperatorExpression :
(	ruleUnaryOperation(()(	
	'+=' 

    |
	'..' 
)(		ruleUnaryOperation))*)
;



// Rule UnaryOperation
ruleUnaryOperation :
((()(	
	'!' 

    |
	'-' 

    |
	'+' 
)(		ruleFeatureCall))
    |(()
	'(' 
(		ruleTypeRef)
	')' 
(		ruleExpression))
    |	ruleFeatureCall)
;



// Rule FeatureCall
ruleFeatureCall :
(	rulePrimaryExpression(()
	'.' 
(		RULE_ID)(
	'(' 
((		ruleExpression)(
	',' 
(		ruleExpression))*)?
	')' 
)?)*)
;



// Rule PrimaryExpression
rulePrimaryExpression :
(	ruleClosure
    |	ruleBooleanLiteral
    |	ruleIntLiteral
    |	ruleNullLiteral
    |	ruleStringLiteral
    |	ruleTypeLiteral
    |	ruleConstructorCall
    |	ruleBlockExpression
    |	ruleRichString
    |	ruleIfExpression
    |	ruleSwitchExpression
    |	ruleWhileExpression
    |	ruleSimpleFeatureCall
    |	ruleParenthesizedExpression)
;



// Rule Closure
ruleClosure :
(()((		ruleDeclaredParameter)(
	',' 
(		ruleDeclaredParameter))*)?
	'|' 
(		ruleExpression))
;



// Rule ParenthesizedExpression
ruleParenthesizedExpression :
(
	'(' 
	ruleExpression
	')' 
)
;



// Rule IfExpression
ruleIfExpression :
(
	'if' 

	'(' 
(		ruleExpression)
	')' 
(		ruleExpression)(
	'else' 
(		ruleExpression))?)
;



// Rule SwitchExpression
ruleSwitchExpression :
(
	'switch' 
(		ruleExpression)?
	'{' 
(		ruleCasePart)+(
	'default' 

	':' 
(		ruleExpression))?
	'}' 
)
;



// Rule WhileExpression
ruleWhileExpression :
(
	'while' 
(		ruleParenthesizedExpression)(		ruleExpression))
;



// Rule CasePart
ruleCasePart :
(
	'case' 
(		ruleExpression)
	':' 
(		ruleExpression))
;



// Rule BlockExpression
ruleBlockExpression :
(
	'{' 
((		ruleExpressionInsideBlock)
	';' 
)+
	'}' 
)
;



// Rule ExpressionInsideBlock
ruleExpressionInsideBlock :
(	ruleVariableDeclaration
    |	ruleExpression)
;



// Rule VariableDeclaration
ruleVariableDeclaration :
((
	'def' 

    |(		ruleTypeRef))(		RULE_ID)
	':=' 
(		ruleExpression))
;



// Rule DeclaredParameter
ruleDeclaredParameter :
((		ruleTypeRef)?(		RULE_ID))
;



// Rule SimpleFeatureCall
ruleSimpleFeatureCall :
((		RULE_ID)(
	'(' 
((		ruleExpression)(
	',' 
(		ruleExpression))*)?
	')' 
)?)
;



// Rule ConstructorCall
ruleConstructorCall :
(
	'new' 
(		ruleTypeRef)(
	'(' 
((		ruleExpression)(
	',' 
(		ruleExpression))*)?
	')' 
)?(		ruleBlockExpression)?)
;



// Rule BooleanLiteral
ruleBooleanLiteral :
((()
	'false' 
)
    |(	
	'true' 
))
;



// Rule NullLiteral
ruleNullLiteral :
(()
	'null' 
)
;



// Rule IntLiteral
ruleIntLiteral :
(		RULE_INT)
;



// Rule StringLiteral
ruleStringLiteral :
(		RULE_STRING)
;



// Rule TypeLiteral
ruleTypeLiteral :
((			ruleQualifiedName)
	'.' 

	'class' 
)
;



// Rule RichString
ruleRichString :
((		ruleRichStringLiteral)((		ruleExpression)(		ruleRichStringLiteral))*)
;



// Rule RichStringLiteral
ruleRichStringLiteral :
(		RULE_RICH_STRING)
;



// Rule TypeRef
ruleTypeRef :
(	ruleSimpleTypeRef
    |	ruleFunctionTypeRef)
;



// Rule FunctionTypeRef
ruleFunctionTypeRef :
((
	'(' 
(		ruleTypeRef)(
	',' 
(		ruleTypeRef))*
	')' 
)?
	'=>' 
(		ruleTypeRef))
;



// Rule SimpleTypeRef
ruleSimpleTypeRef :
((			ruleQualifiedName)(
	'<' 
(		ruleTypeParam)(
	',' 
(		ruleTypeParam))*
	'>' 
)?)
;



// Rule TypeParam
ruleTypeParam :
(	ruleTypeRef
    |	ruleWildcardParam)
;



// Rule WildcardParam
ruleWildcardParam :
(()
	'?' 
((
	'extends' 
(		ruleTypeRef))
    |(
	'super' 
(		ruleTypeRef)))?)
;





// Rule QualifiedName
ruleQualifiedName :
(	RULE_ID(
	'.' 
	RULE_ID)*)
;




// Rule RICH_STRING
RULE_RICH_STRING : '\u00BB' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\u00AB')))* '\u00AB';

// Rule ID
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// Rule INT
RULE_INT : ('0'..'9')+;

// Rule STRING
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// Rule ML_COMMENT
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// Rule SL_COMMENT
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// Rule WS
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// Rule ANY_OTHER
RULE_ANY_OTHER : .;


