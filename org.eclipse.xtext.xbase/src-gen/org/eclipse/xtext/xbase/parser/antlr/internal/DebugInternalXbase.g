/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
grammar DebugInternalXbase;

// Rule XExpression
ruleXExpression:
	ruleXAssignment
;

// Rule XAssignment
ruleXAssignment:
	(
		ruleFeatureCallID
		ruleOpSingleAssign
		ruleXAssignment
		    |
		ruleXOrExpression
		(
			(
				(ruleOpMultiAssign
				)=>
				ruleOpMultiAssign
			)
			ruleXAssignment
		)?
	)
;

// Rule OpSingleAssign
ruleOpSingleAssign:
	'='
;

// Rule OpMultiAssign
ruleOpMultiAssign:
	(
		'+='
		    |
		'-='
		    |
		'*='
		    |
		'/='
		    |
		'%='
		    |
		'<'
		'<'
		'='
		    |
		'>'
		'>'?
		'>='
	)
;

// Rule XOrExpression
ruleXOrExpression:
	ruleXAndExpression
	(
		(
			(ruleOpOr
			)=>
			ruleOpOr
		)
		ruleXAndExpression
	)*
;

// Rule OpOr
ruleOpOr:
	'||'
;

// Rule XAndExpression
ruleXAndExpression:
	ruleXEqualityExpression
	(
		(
			(ruleOpAnd
			)=>
			ruleOpAnd
		)
		ruleXEqualityExpression
	)*
;

// Rule OpAnd
ruleOpAnd:
	'&&'
;

// Rule XEqualityExpression
ruleXEqualityExpression:
	ruleXRelationalExpression
	(
		(
			(ruleOpEquality
			)=>
			ruleOpEquality
		)
		ruleXRelationalExpression
	)*
;

// Rule OpEquality
ruleOpEquality:
	(
		'=='
		    |
		'!='
		    |
		'==='
		    |
		'!=='
	)
;

// Rule XRelationalExpression
ruleXRelationalExpression:
	ruleXOtherOperatorExpression
	(
		(
			('instanceof'
			)=>
			'instanceof'
		)
		ruleJvmTypeReference
		    |
		(
			(ruleOpCompare
			)=>
			ruleOpCompare
		)
		ruleXOtherOperatorExpression
	)*
;

// Rule OpCompare
ruleOpCompare:
	(
		'>='
		    |
		'<'
		'='
		    |
		'>'
		    |
		'<'
	)
;

// Rule XOtherOperatorExpression
ruleXOtherOperatorExpression:
	ruleXAdditiveExpression
	(
		(
			(ruleOpOther
			)=>
			ruleOpOther
		)
		ruleXAdditiveExpression
	)*
;

// Rule OpOther
ruleOpOther:
	(
		'->'
		    |
		'..<'
		    |
		'>'
		'..'
		    |
		'..'
		    |
		'=>'
		    |
		'>'
		(
			(
				('>'
				'>'
				)=>
				'>'
				'>'
			)
			    |
			'>'
		)
		    |
		'<'
		(
			(
				('<'
				'<'
				)=>
				'<'
				'<'
			)
			    |
			'<'
			    |
			'=>'
		)
		    |
		'<>'
		    |
		'?:'
	)
;

// Rule XAdditiveExpression
ruleXAdditiveExpression:
	ruleXMultiplicativeExpression
	(
		(
			(ruleOpAdd
			)=>
			ruleOpAdd
		)
		ruleXMultiplicativeExpression
	)*
;

// Rule OpAdd
ruleOpAdd:
	(
		'+'
		    |
		'-'
	)
;

// Rule XMultiplicativeExpression
ruleXMultiplicativeExpression:
	ruleXUnaryOperation
	(
		(
			(ruleOpMulti
			)=>
			ruleOpMulti
		)
		ruleXUnaryOperation
	)*
;

// Rule OpMulti
ruleOpMulti:
	(
		'*'
		    |
		'**'
		    |
		'/'
		    |
		'%'
	)
;

// Rule XUnaryOperation
ruleXUnaryOperation:
	(
		ruleOpUnary
		ruleXUnaryOperation
		    |
		ruleXCastedExpression
	)
;

// Rule OpUnary
ruleOpUnary:
	(
		'!'
		    |
		'-'
		    |
		'+'
	)
;

// Rule XCastedExpression
ruleXCastedExpression:
	ruleXPostfixOperation
	(
		(
			('as'
			)=>
			'as'
		)
		ruleJvmTypeReference
	)*
;

// Rule XPostfixOperation
ruleXPostfixOperation:
	ruleXMemberFeatureCall
	(
		(ruleOpPostfix
		)=>
		ruleOpPostfix
	)?
;

// Rule OpPostfix
ruleOpPostfix:
	(
		'++'
		    |
		'--'
	)
;

// Rule XMemberFeatureCall
ruleXMemberFeatureCall:
	ruleXPrimaryExpression
	(
		(
			((
				'.'
				    |
				'::'
			)
			ruleFeatureCallID
			ruleOpSingleAssign
			)=>
			(
				'.'
				    |
				'::'
			)
			ruleFeatureCallID
			ruleOpSingleAssign
		)
		ruleXAssignment
		    |
		(
			((
				'.'
				    |
				'?.'
				    |
				'::'
			)
			)=>
			(
				'.'
				    |
				'?.'
				    |
				'::'
			)
		)
		(
			'<'
			ruleJvmArgumentTypeReference
			(
				','
				ruleJvmArgumentTypeReference
			)*
			'>'
		)?
		ruleIdOrSuper
		(
			(
				('('
				)=>
				'('
			)
			(
				(
					((
						ruleJvmFormalParameter
						(
							','
							ruleJvmFormalParameter
						)*
					)?
					'|'
					)=>
					ruleXShortClosure
				)
				    |
				ruleXExpression
				(
					','
					ruleXExpression
				)*
			)?
			')'
		)?
		(
			('['
			)=>
			ruleXClosure
		)?
	)*
;

// Rule XPrimaryExpression
ruleXPrimaryExpression:
	(
		ruleXConstructorCall
		    |
		ruleXBlockExpression
		    |
		ruleXSwitchExpression
		    |
		(
			('synchronized'
			'('
			)=>
			ruleXSynchronizedExpression
		)
		    |
		ruleXFeatureCall
		    |
		ruleXLiteral
		    |
		ruleXIfExpression
		    |
		(
			('for'
			'('
			ruleJvmFormalParameter
			':'
			)=>
			ruleXForLoopExpression
		)
		    |
		ruleXBasicForLoopExpression
		    |
		ruleXWhileExpression
		    |
		ruleXDoWhileExpression
		    |
		ruleXThrowExpression
		    |
		ruleXReturnExpression
		    |
		ruleXTryCatchFinallyExpression
		    |
		ruleXParenthesizedExpression
	)
;

// Rule XLiteral
ruleXLiteral:
	(
		ruleXCollectionLiteral
		    |
		(
			('['
			)=>
			ruleXClosure
		)
		    |
		ruleXBooleanLiteral
		    |
		ruleXNumberLiteral
		    |
		ruleXNullLiteral
		    |
		ruleXStringLiteral
		    |
		ruleXTypeLiteral
	)
;

// Rule XCollectionLiteral
ruleXCollectionLiteral:
	(
		ruleXSetLiteral
		    |
		ruleXListLiteral
	)
;

// Rule XSetLiteral
ruleXSetLiteral:
	'#'
	'{'
	(
		ruleXExpression
		(
			','
			ruleXExpression
		)*
	)?
	'}'
;

// Rule XListLiteral
ruleXListLiteral:
	'#'
	'['
	(
		ruleXExpression
		(
			','
			ruleXExpression
		)*
	)?
	']'
;

// Rule XClosure
ruleXClosure:
	(
		('['
		)=>
		'['
	)
	(
		((
			ruleJvmFormalParameter
			(
				','
				ruleJvmFormalParameter
			)*
		)?
		'|'
		)=>
		(
			ruleJvmFormalParameter
			(
				','
				ruleJvmFormalParameter
			)*
		)?
		'|'
	)?
	ruleXExpressionInClosure
	']'
;

// Rule XExpressionInClosure
ruleXExpressionInClosure:
	(
		ruleXExpressionOrVarDeclaration
		';'?
	)*
;

// Rule XShortClosure
ruleXShortClosure:
	(
		((
			ruleJvmFormalParameter
			(
				','
				ruleJvmFormalParameter
			)*
		)?
		'|'
		)=>
		(
			ruleJvmFormalParameter
			(
				','
				ruleJvmFormalParameter
			)*
		)?
		'|'
	)
	ruleXExpression
;

// Rule XParenthesizedExpression
ruleXParenthesizedExpression:
	'('
	ruleXExpression
	')'
;

// Rule XIfExpression
ruleXIfExpression:
	'if'
	'('
	ruleXExpression
	')'
	ruleXExpression
	(
		(
			('else')=>
			'else'
		)
		ruleXExpression
	)?
;

// Rule XSwitchExpression
ruleXSwitchExpression:
	'switch'
	(
		(
			('('
			ruleJvmFormalParameter
			':'
			)=>
			'('
			ruleJvmFormalParameter
			':'
		)
		ruleXExpression
		')'
		    |
		(
			(ruleJvmFormalParameter
			':'
			)=>
			ruleJvmFormalParameter
			':'
		)?
		ruleXExpression
	)
	'{'
	ruleXCasePart
	*
	(
		'default'
		':'
		ruleXExpression
	)?
	'}'
;

// Rule XCasePart
ruleXCasePart:
	ruleJvmTypeReference
	?
	(
		'case'
		ruleXExpression
	)?
	(
		':'
		ruleXExpression
		    |
		','
	)
;

// Rule XForLoopExpression
ruleXForLoopExpression:
	(
		('for'
		'('
		ruleJvmFormalParameter
		':'
		)=>
		'for'
		'('
		ruleJvmFormalParameter
		':'
	)
	ruleXExpression
	')'
	ruleXExpression
;

// Rule XBasicForLoopExpression
ruleXBasicForLoopExpression:
	'for'
	'('
	(
		ruleXExpressionOrVarDeclaration
		(
			','
			ruleXExpressionOrVarDeclaration
		)*
	)?
	';'
	ruleXExpression
	?
	';'
	(
		ruleXExpression
		(
			','
			ruleXExpression
		)*
	)?
	')'
	ruleXExpression
;

// Rule XWhileExpression
ruleXWhileExpression:
	'while'
	'('
	ruleXExpression
	')'
	ruleXExpression
;

// Rule XDoWhileExpression
ruleXDoWhileExpression:
	'do'
	ruleXExpression
	'while'
	'('
	ruleXExpression
	')'
;

// Rule XBlockExpression
ruleXBlockExpression:
	'{'
	(
		ruleXExpressionOrVarDeclaration
		';'?
	)*
	'}'
;

// Rule XExpressionOrVarDeclaration
ruleXExpressionOrVarDeclaration:
	(
		ruleXVariableDeclaration
		    |
		ruleXExpression
	)
;

// Rule XVariableDeclaration
ruleXVariableDeclaration:
	(
		'var'
		    |
		'val'
	)
	(
		(
			(ruleJvmTypeReference
			ruleValidID
			)=>
			ruleJvmTypeReference
			ruleValidID
		)
		    |
		ruleValidID
	)
	(
		'='
		ruleXExpression
	)?
;

// Rule JvmFormalParameter
ruleJvmFormalParameter:
	ruleJvmTypeReference
	?
	ruleValidID
;

// Rule FullJvmFormalParameter
ruleFullJvmFormalParameter:
	ruleJvmTypeReference
	ruleValidID
;

// Rule XFeatureCall
ruleXFeatureCall:
	(
		'<'
		ruleJvmArgumentTypeReference
		(
			','
			ruleJvmArgumentTypeReference
		)*
		'>'
	)?
	ruleIdOrSuper
	(
		(
			('('
			)=>
			'('
		)
		(
			(
				((
					ruleJvmFormalParameter
					(
						','
						ruleJvmFormalParameter
					)*
				)?
				'|'
				)=>
				ruleXShortClosure
			)
			    |
			ruleXExpression
			(
				','
				ruleXExpression
			)*
		)?
		')'
	)?
	(
		('['
		)=>
		ruleXClosure
	)?
;

// Rule FeatureCallID
ruleFeatureCallID:
	(
		ruleValidID
		    |
		'extends'
		    |
		'static'
		    |
		'import'
		    |
		'extension'
	)
;

// Rule IdOrSuper
ruleIdOrSuper:
	(
		ruleFeatureCallID
		    |
		'super'
	)
;

// Rule XConstructorCall
ruleXConstructorCall:
	'new'
	ruleQualifiedName
	(
		(
			('<')=>
			'<'
		)
		ruleJvmArgumentTypeReference
		(
			','
			ruleJvmArgumentTypeReference
		)*
		'>'
	)?
	(
		(
			('('
			)=>
			'('
		)
		(
			(
				((
					ruleJvmFormalParameter
					(
						','
						ruleJvmFormalParameter
					)*
				)?
				'|'
				)=>
				ruleXShortClosure
			)
			    |
			ruleXExpression
			(
				','
				ruleXExpression
			)*
		)?
		')'
	)?
	(
		('['
		)=>
		ruleXClosure
	)?
;

// Rule XBooleanLiteral
ruleXBooleanLiteral:
	(
		'false'
		    |
		'true'
	)
;

// Rule XNullLiteral
ruleXNullLiteral:
	'null'
;

// Rule XNumberLiteral
ruleXNumberLiteral:
	ruleNumber
;

// Rule XStringLiteral
ruleXStringLiteral:
	RULE_STRING
;

// Rule XTypeLiteral
ruleXTypeLiteral:
	'typeof'
	'('
	ruleQualifiedName
	ruleArrayBrackets
	*
	')'
;

// Rule XThrowExpression
ruleXThrowExpression:
	'throw'
	ruleXExpression
;

// Rule XReturnExpression
ruleXReturnExpression:
	'return'
	(
		('extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING)=>
		ruleXExpression
	)?
;

// Rule XTryCatchFinallyExpression
ruleXTryCatchFinallyExpression:
	'try'
	ruleXExpression
	(
		(
			('catch')=>
			ruleXCatchClause
		)+
		(
			(
				('finally')=>
				'finally'
			)
			ruleXExpression
		)?
		    |
		'finally'
		ruleXExpression
	)
;

// Rule XSynchronizedExpression
ruleXSynchronizedExpression:
	(
		('synchronized'
		'('
		)=>
		'synchronized'
		'('
	)
	ruleXExpression
	')'
	ruleXExpression
;

// Rule XCatchClause
ruleXCatchClause:
	(
		('catch')=>
		'catch'
	)
	'('
	ruleFullJvmFormalParameter
	')'
	ruleXExpression
;

// Rule QualifiedName
ruleQualifiedName:
	ruleValidID
	(
		(
			('.')=>
			'.'
		)
		ruleValidID
	)*
;

// Rule Number
ruleNumber:
	(
		RULE_HEX
		    |
		(
			RULE_INT
			    |
			RULE_DECIMAL
		)
		(
			'.'
			(
				RULE_INT
				    |
				RULE_DECIMAL
			)
		)?
	)
;

// Rule JvmTypeReference
ruleJvmTypeReference:
	(
		ruleJvmParameterizedTypeReference
		(
			(ruleArrayBrackets
			)=>
			ruleArrayBrackets
		)*
		    |
		ruleXFunctionTypeRef
	)
;

// Rule ArrayBrackets
ruleArrayBrackets:
	'['
	']'
;

// Rule XFunctionTypeRef
ruleXFunctionTypeRef:
	(
		'('
		(
			ruleJvmTypeReference
			(
				','
				ruleJvmTypeReference
			)*
		)?
		')'
	)?
	'=>'
	ruleJvmTypeReference
;

// Rule JvmParameterizedTypeReference
ruleJvmParameterizedTypeReference:
	ruleQualifiedName
	(
		(
			('<')=>
			'<'
		)
		ruleJvmArgumentTypeReference
		(
			','
			ruleJvmArgumentTypeReference
		)*
		'>'
		(
			(
				('.'
				)=>
				'.'
			)
			ruleValidID
			(
				(
					('<')=>
					'<'
				)
				ruleJvmArgumentTypeReference
				(
					','
					ruleJvmArgumentTypeReference
				)*
				'>'
			)?
		)*
	)?
;

// Rule JvmArgumentTypeReference
ruleJvmArgumentTypeReference:
	(
		ruleJvmTypeReference
		    |
		ruleJvmWildcardTypeReference
	)
;

// Rule JvmWildcardTypeReference
ruleJvmWildcardTypeReference:
	'?'
	(
		ruleJvmUpperBound
		ruleJvmUpperBoundAnded
		*
		    |
		ruleJvmLowerBound
		ruleJvmLowerBoundAnded
		*
	)?
;

// Rule JvmUpperBound
ruleJvmUpperBound:
	'extends'
	ruleJvmTypeReference
;

// Rule JvmUpperBoundAnded
ruleJvmUpperBoundAnded:
	'&'
	ruleJvmTypeReference
;

// Rule JvmLowerBound
ruleJvmLowerBound:
	'super'
	ruleJvmTypeReference
;

// Rule JvmLowerBoundAnded
ruleJvmLowerBoundAnded:
	'&'
	ruleJvmTypeReference
;

// Rule QualifiedNameWithWildcard
ruleQualifiedNameWithWildcard:
	ruleQualifiedName
	'.'
	'*'
;

// Rule ValidID
ruleValidID:
	RULE_ID
;

// Rule XImportDeclaration
ruleXImportDeclaration:
	'import'
	(
		'static'
		'extension'
		?
		ruleQualifiedNameInStaticImport
		(
			'*'
			    |
			ruleValidID
		)
		    |
		ruleQualifiedName
		    |
		ruleQualifiedNameWithWildcard
	)
	';'?
;

// Rule QualifiedNameInStaticImport
ruleQualifiedNameInStaticImport:
	(
		ruleValidID
		'.'
	)+
;

RULE_HEX : ('0x'|'0X') ('0'..'9'|'a'..'f'|'A'..'F'|'_')+ ('#' (('b'|'B') ('i'|'I')|('l'|'L')))?;

RULE_INT : '0'..'9' ('0'..'9'|'_')*;

RULE_DECIMAL : RULE_INT (('e'|'E') ('+'|'-')? RULE_INT)? (('b'|'B') ('i'|'I'|'d'|'D')|('l'|'L'|'d'|'D'|'f'|'F'))?;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'$'|'_') ('a'..'z'|'A'..'Z'|'$'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'?|'\'' ('\\' .|~(('\\'|'\'')))* '\''?);

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/' {skip();};

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')? {skip();};

RULE_WS : (' '|'\t'|'\r'|'\n')+ {skip();};

RULE_ANY_OTHER : .;
