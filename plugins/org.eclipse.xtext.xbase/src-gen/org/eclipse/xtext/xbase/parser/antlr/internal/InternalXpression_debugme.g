grammar InternalXpression_debugme;

options {
	backtrack=true;
	
}

entryRuleXExpression :
	 ruleXExpression 
	 EOF 
;



// Rule XExpression
ruleXExpression :
	ruleXAssignment
;



// Rule XAssignment
ruleXAssignment :
(	ruleXOrExpression(()(	
	'=' 

    |
	'+=' 
)(		ruleXOrExpression))?)
;



// Rule XOrExpression
ruleXOrExpression :
(	ruleXAndExpression(()(	
	'||' 
)(		ruleXAndExpression))*)
;



// Rule XAndExpression
ruleXAndExpression :
(	ruleXEqualityExpression(()(	
	'&&' 
)(		ruleXEqualityExpression))*)
;



// Rule XEqualityExpression
ruleXEqualityExpression :
(	ruleXRelationalExpression(()(	
	'==' 

    |
	'!=' 
)(		ruleXRelationalExpression))*)
;



// Rule XRelationalExpression
ruleXRelationalExpression :
(	ruleXAdditiveExpression((()
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
)(		ruleXAdditiveExpression)))*)
;



// Rule XAdditiveExpression
ruleXAdditiveExpression :
(	ruleXMultiplicativeExpression(()(	
	'+' 

    |
	'-' 
)(		ruleXMultiplicativeExpression))*)
;



// Rule XMultiplicativeExpression
ruleXMultiplicativeExpression :
(	ruleXOtherOperatorExpression(()(	
	'*' 

    |
	'/' 

    |
	'%' 
)(		ruleXOtherOperatorExpression))*)
;



// Rule XOtherOperatorExpression
ruleXOtherOperatorExpression :
(	ruleXUnaryOperation(()(	
	'->' 

    |
	'..' 
)(		ruleXUnaryOperation))*)
;



// Rule XUnaryOperation
ruleXUnaryOperation :
((()(	
	'!' 

    |
	'-' 

    |
	'+' 
)(		ruleXFeatureCall))
    |(()
	'(' 
(		ruleXTypeRef)
	')' 
(		ruleXExpression))
    |	ruleXFeatureCall)
;



// Rule XFeatureCall
ruleXFeatureCall :
(	ruleXPrimaryExpression(()
	'.' 
(		RULE_ID)(
	'(' 
((		ruleXExpression)(
	',' 
(		ruleXExpression))*)?
	')' 
)?)*)
;



// Rule XPrimaryExpression
ruleXPrimaryExpression :
(	ruleXClosure
    |	ruleXBooleanLiteral
    |	ruleXIntLiteral
    |	ruleXNullLiteral
    |	ruleXStringLiteral
    |	ruleXTypeLiteral
    |	ruleXConstructorCall
    |	ruleXBlockExpression
    |	ruleXRichString
    |	ruleXIfExpression
    |	ruleXSwitchExpression
    |	ruleXWhileExpression
    |	ruleXSimpleFeatureCall
    |	ruleXParenthesizedExpression)
;



// Rule XClosure
ruleXClosure :
(()((		ruleXDeclaredParameter)(
	',' 
(		ruleXDeclaredParameter))*)?
	'|' 
(		ruleXExpression))
;



// Rule XParenthesizedExpression
ruleXParenthesizedExpression :
(
	'(' 
	ruleXExpression
	')' 
)
;



// Rule XIfExpression
ruleXIfExpression :
(
	'if' 

	'(' 
(		ruleXExpression)
	')' 
(		ruleXExpression)(
	'else' 
(		ruleXExpression))?)
;



// Rule XSwitchExpression
ruleXSwitchExpression :
(
	'switch' 
(		ruleXExpression)?
	'{' 
(		ruleXCasePart)+(
	'default' 

	':' 
(		ruleXExpression))?
	'}' 
)
;



// Rule XWhileExpression
ruleXWhileExpression :
(
	'while' 
(		ruleXParenthesizedExpression)(		ruleXExpression))
;



// Rule XCasePart
ruleXCasePart :
(
	'case' 
(		ruleXExpression)
	':' 
(		ruleXExpression))
;



// Rule XBlockExpression
ruleXBlockExpression :
(
	'{' 
((		ruleXExpressionInsideBlock)
	';' 
)+
	'}' 
)
;



// Rule XExpressionInsideBlock
ruleXExpressionInsideBlock :
(	ruleXVariableDeclaration
    |	ruleXExpression)
;



// Rule XVariableDeclaration
ruleXVariableDeclaration :
((
	'def' 

    |(		ruleXTypeRef))(		RULE_ID)
	'=' 
(		ruleXExpression))
;



// Rule XDeclaredParameter
ruleXDeclaredParameter :
((		ruleXTypeRef)?(		RULE_ID))
;



// Rule XSimpleFeatureCall
ruleXSimpleFeatureCall :
((		RULE_ID)(
	'(' 
((		ruleXExpression)(
	',' 
(		ruleXExpression))*)?
	')' 
)?)
;



// Rule XConstructorCall
ruleXConstructorCall :
(
	'new' 
(		ruleXTypeRef)(
	'(' 
((		ruleXExpression)(
	',' 
(		ruleXExpression))*)?
	')' 
)?(		ruleXBlockExpression)?)
;



// Rule XBooleanLiteral
ruleXBooleanLiteral :
((()
	'false' 
)
    |(	
	'true' 
))
;



// Rule XNullLiteral
ruleXNullLiteral :
(()
	'null' 
)
;



// Rule XIntLiteral
ruleXIntLiteral :
(		RULE_INT)
;



// Rule XStringLiteral
ruleXStringLiteral :
(		RULE_STRING)
;



// Rule XTypeLiteral
ruleXTypeLiteral :
((			ruleQualifiedName)
	'.' 

	'class' 
)
;



// Rule XRichString
ruleXRichString :
((		ruleXRichStringLiteral)((		ruleXExpression)(		ruleXRichStringLiteral))*)
;



// Rule XRichStringLiteral
ruleXRichStringLiteral :
(		RULE_RICH_STRING)
;



// Rule XTypeRef
ruleXTypeRef :
(	ruleXSimpleTypeRef
    |	ruleXFunctionTypeRef)
;



// Rule XFunctionTypeRef
ruleXFunctionTypeRef :
((
	'(' 
(		ruleXTypeRef)(
	',' 
(		ruleXTypeRef))*
	')' 
)?
	'=>' 
(		ruleXTypeRef))
;



// Rule XSimpleTypeRef
ruleXSimpleTypeRef :
((			ruleQualifiedName)(
	'<' 
(		ruleXTypeParam)(
	',' 
(		ruleXTypeParam))*
	'>' 
)?)
;



// Rule XTypeParam
ruleXTypeParam :
(	ruleXTypeRef
    |	ruleXWildcardParam)
;



// Rule XWildcardParam
ruleXWildcardParam :
(()
	'?' 
((
	'extends' 
(		ruleXTypeRef))
    |(
	'super' 
(		ruleXTypeRef)))?)
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


