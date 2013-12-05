/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ConstantOperators {
	
	def dispatch minus(Object operand) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '-' for operand "+operand);
	}
	def dispatch minus(Integer e) { -e } 
	def dispatch minus(Double e) { -e } 
	def dispatch minus(Long e) { -e } 
	def dispatch minus(Short e) { -e } 
	def dispatch minus(Float e) { -e } 
	def dispatch minus(Byte e) { -e } 
	
	def dispatch plus(String left, Object right) {
		left + right
	}
	
	def static void main(String[] args) {
		val types = #{'Integer','Short','Long','Float','Double','Byte'}
		val operators = #{
			'plus'->'+','minus'->'-','divide'->'/','multiply'->'*','modulo'->'%',
			'lessThan'->'<','greaterThan'->'>','lessEquals'->'<=','greaterEquals'->'>=',
			'same'->'==', 'notSame'->'!='				
		}
		for (op : operators.entrySet) {
			println('''
				
				def dispatch «op.key»(Object left, Object right) {
					throw new ConstantExpressionEvaluationException("Unsupported operator '«op.value»' for operands "+left+" and "+right);
				}
			''')
			for (left : types) {
				println("")			
				for (right : types) {
					println('def dispatch '+op.key+'('+left+' left, '+right+' right) { left '+op.value+' right }')
				}
			}
		}
	}
	// generated from output of main (see above)

	def dispatch plus(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '+' for operands "+left+" and "+right);
	}
	
	
	def dispatch plus(Byte left, Byte right) { left + right }
	def dispatch plus(Byte left, Double right) { left + right }
	def dispatch plus(Byte left, Float right) { left + right }
	def dispatch plus(Byte left, Long right) { left + right }
	def dispatch plus(Byte left, Short right) { left + right }
	def dispatch plus(Byte left, Integer right) { left + right }
	
	def dispatch plus(Double left, Byte right) { left + right }
	def dispatch plus(Double left, Double right) { left + right }
	def dispatch plus(Double left, Float right) { left + right }
	def dispatch plus(Double left, Long right) { left + right }
	def dispatch plus(Double left, Short right) { left + right }
	def dispatch plus(Double left, Integer right) { left + right }
	
	def dispatch plus(Float left, Byte right) { left + right }
	def dispatch plus(Float left, Double right) { left + right }
	def dispatch plus(Float left, Float right) { left + right }
	def dispatch plus(Float left, Long right) { left + right }
	def dispatch plus(Float left, Short right) { left + right }
	def dispatch plus(Float left, Integer right) { left + right }
	
	def dispatch plus(Long left, Byte right) { left + right }
	def dispatch plus(Long left, Double right) { left + right }
	def dispatch plus(Long left, Float right) { left + right }
	def dispatch plus(Long left, Long right) { left + right }
	def dispatch plus(Long left, Short right) { left + right }
	def dispatch plus(Long left, Integer right) { left + right }
	
	def dispatch plus(Short left, Byte right) { left + right }
	def dispatch plus(Short left, Double right) { left + right }
	def dispatch plus(Short left, Float right) { left + right }
	def dispatch plus(Short left, Long right) { left + right }
	def dispatch plus(Short left, Short right) { left + right }
	def dispatch plus(Short left, Integer right) { left + right }
	
	def dispatch plus(Integer left, Byte right) { left + right }
	def dispatch plus(Integer left, Double right) { left + right }
	def dispatch plus(Integer left, Float right) { left + right }
	def dispatch plus(Integer left, Long right) { left + right }
	def dispatch plus(Integer left, Short right) { left + right }
	def dispatch plus(Integer left, Integer right) { left + right }
	
	def dispatch lessThan(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '<' for operands "+left+" and "+right);
	}
	
	
	def dispatch lessThan(Byte left, Byte right) { left < right }
	def dispatch lessThan(Byte left, Double right) { left < right }
	def dispatch lessThan(Byte left, Float right) { left < right }
	def dispatch lessThan(Byte left, Long right) { left < right }
	def dispatch lessThan(Byte left, Short right) { left < right }
	def dispatch lessThan(Byte left, Integer right) { left < right }
	
	def dispatch lessThan(Double left, Byte right) { left < right }
	def dispatch lessThan(Double left, Double right) { left < right }
	def dispatch lessThan(Double left, Float right) { left < right }
	def dispatch lessThan(Double left, Long right) { left < right }
	def dispatch lessThan(Double left, Short right) { left < right }
	def dispatch lessThan(Double left, Integer right) { left < right }
	
	def dispatch lessThan(Float left, Byte right) { left < right }
	def dispatch lessThan(Float left, Double right) { left < right }
	def dispatch lessThan(Float left, Float right) { left < right }
	def dispatch lessThan(Float left, Long right) { left < right }
	def dispatch lessThan(Float left, Short right) { left < right }
	def dispatch lessThan(Float left, Integer right) { left < right }
	
	def dispatch lessThan(Long left, Byte right) { left < right }
	def dispatch lessThan(Long left, Double right) { left < right }
	def dispatch lessThan(Long left, Float right) { left < right }
	def dispatch lessThan(Long left, Long right) { left < right }
	def dispatch lessThan(Long left, Short right) { left < right }
	def dispatch lessThan(Long left, Integer right) { left < right }
	
	def dispatch lessThan(Short left, Byte right) { left < right }
	def dispatch lessThan(Short left, Double right) { left < right }
	def dispatch lessThan(Short left, Float right) { left < right }
	def dispatch lessThan(Short left, Long right) { left < right }
	def dispatch lessThan(Short left, Short right) { left < right }
	def dispatch lessThan(Short left, Integer right) { left < right }
	
	def dispatch lessThan(Integer left, Byte right) { left < right }
	def dispatch lessThan(Integer left, Double right) { left < right }
	def dispatch lessThan(Integer left, Float right) { left < right }
	def dispatch lessThan(Integer left, Long right) { left < right }
	def dispatch lessThan(Integer left, Short right) { left < right }
	def dispatch lessThan(Integer left, Integer right) { left < right }
	
	def dispatch minus(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '-' for operands "+left+" and "+right);
	}
	
	
	def dispatch minus(Byte left, Byte right) { left - right }
	def dispatch minus(Byte left, Double right) { left - right }
	def dispatch minus(Byte left, Float right) { left - right }
	def dispatch minus(Byte left, Long right) { left - right }
	def dispatch minus(Byte left, Short right) { left - right }
	def dispatch minus(Byte left, Integer right) { left - right }
	
	def dispatch minus(Double left, Byte right) { left - right }
	def dispatch minus(Double left, Double right) { left - right }
	def dispatch minus(Double left, Float right) { left - right }
	def dispatch minus(Double left, Long right) { left - right }
	def dispatch minus(Double left, Short right) { left - right }
	def dispatch minus(Double left, Integer right) { left - right }
	
	def dispatch minus(Float left, Byte right) { left - right }
	def dispatch minus(Float left, Double right) { left - right }
	def dispatch minus(Float left, Float right) { left - right }
	def dispatch minus(Float left, Long right) { left - right }
	def dispatch minus(Float left, Short right) { left - right }
	def dispatch minus(Float left, Integer right) { left - right }
	
	def dispatch minus(Long left, Byte right) { left - right }
	def dispatch minus(Long left, Double right) { left - right }
	def dispatch minus(Long left, Float right) { left - right }
	def dispatch minus(Long left, Long right) { left - right }
	def dispatch minus(Long left, Short right) { left - right }
	def dispatch minus(Long left, Integer right) { left - right }
	
	def dispatch minus(Short left, Byte right) { left - right }
	def dispatch minus(Short left, Double right) { left - right }
	def dispatch minus(Short left, Float right) { left - right }
	def dispatch minus(Short left, Long right) { left - right }
	def dispatch minus(Short left, Short right) { left - right }
	def dispatch minus(Short left, Integer right) { left - right }
	
	def dispatch minus(Integer left, Byte right) { left - right }
	def dispatch minus(Integer left, Double right) { left - right }
	def dispatch minus(Integer left, Float right) { left - right }
	def dispatch minus(Integer left, Long right) { left - right }
	def dispatch minus(Integer left, Short right) { left - right }
	def dispatch minus(Integer left, Integer right) { left - right }
	
	def dispatch greaterThan(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '>' for operands "+left+" and "+right);
	}
	
	
	def dispatch greaterThan(Byte left, Byte right) { left > right }
	def dispatch greaterThan(Byte left, Double right) { left > right }
	def dispatch greaterThan(Byte left, Float right) { left > right }
	def dispatch greaterThan(Byte left, Long right) { left > right }
	def dispatch greaterThan(Byte left, Short right) { left > right }
	def dispatch greaterThan(Byte left, Integer right) { left > right }
	
	def dispatch greaterThan(Double left, Byte right) { left > right }
	def dispatch greaterThan(Double left, Double right) { left > right }
	def dispatch greaterThan(Double left, Float right) { left > right }
	def dispatch greaterThan(Double left, Long right) { left > right }
	def dispatch greaterThan(Double left, Short right) { left > right }
	def dispatch greaterThan(Double left, Integer right) { left > right }
	
	def dispatch greaterThan(Float left, Byte right) { left > right }
	def dispatch greaterThan(Float left, Double right) { left > right }
	def dispatch greaterThan(Float left, Float right) { left > right }
	def dispatch greaterThan(Float left, Long right) { left > right }
	def dispatch greaterThan(Float left, Short right) { left > right }
	def dispatch greaterThan(Float left, Integer right) { left > right }
	
	def dispatch greaterThan(Long left, Byte right) { left > right }
	def dispatch greaterThan(Long left, Double right) { left > right }
	def dispatch greaterThan(Long left, Float right) { left > right }
	def dispatch greaterThan(Long left, Long right) { left > right }
	def dispatch greaterThan(Long left, Short right) { left > right }
	def dispatch greaterThan(Long left, Integer right) { left > right }
	
	def dispatch greaterThan(Short left, Byte right) { left > right }
	def dispatch greaterThan(Short left, Double right) { left > right }
	def dispatch greaterThan(Short left, Float right) { left > right }
	def dispatch greaterThan(Short left, Long right) { left > right }
	def dispatch greaterThan(Short left, Short right) { left > right }
	def dispatch greaterThan(Short left, Integer right) { left > right }
	
	def dispatch greaterThan(Integer left, Byte right) { left > right }
	def dispatch greaterThan(Integer left, Double right) { left > right }
	def dispatch greaterThan(Integer left, Float right) { left > right }
	def dispatch greaterThan(Integer left, Long right) { left > right }
	def dispatch greaterThan(Integer left, Short right) { left > right }
	def dispatch greaterThan(Integer left, Integer right) { left > right }
	
	def dispatch modulo(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '%' for operands "+left+" and "+right);
	}
	
	
	def dispatch modulo(Byte left, Byte right) { left % right }
	def dispatch modulo(Byte left, Double right) { left % right }
	def dispatch modulo(Byte left, Float right) { left % right }
	def dispatch modulo(Byte left, Long right) { left % right }
	def dispatch modulo(Byte left, Short right) { left % right }
	def dispatch modulo(Byte left, Integer right) { left % right }
	
	def dispatch modulo(Double left, Byte right) { left % right }
	def dispatch modulo(Double left, Double right) { left % right }
	def dispatch modulo(Double left, Float right) { left % right }
	def dispatch modulo(Double left, Long right) { left % right }
	def dispatch modulo(Double left, Short right) { left % right }
	def dispatch modulo(Double left, Integer right) { left % right }
	
	def dispatch modulo(Float left, Byte right) { left % right }
	def dispatch modulo(Float left, Double right) { left % right }
	def dispatch modulo(Float left, Float right) { left % right }
	def dispatch modulo(Float left, Long right) { left % right }
	def dispatch modulo(Float left, Short right) { left % right }
	def dispatch modulo(Float left, Integer right) { left % right }
	
	def dispatch modulo(Long left, Byte right) { left % right }
	def dispatch modulo(Long left, Double right) { left % right }
	def dispatch modulo(Long left, Float right) { left % right }
	def dispatch modulo(Long left, Long right) { left % right }
	def dispatch modulo(Long left, Short right) { left % right }
	def dispatch modulo(Long left, Integer right) { left % right }
	
	def dispatch modulo(Short left, Byte right) { left % right }
	def dispatch modulo(Short left, Double right) { left % right }
	def dispatch modulo(Short left, Float right) { left % right }
	def dispatch modulo(Short left, Long right) { left % right }
	def dispatch modulo(Short left, Short right) { left % right }
	def dispatch modulo(Short left, Integer right) { left % right }
	
	def dispatch modulo(Integer left, Byte right) { left % right }
	def dispatch modulo(Integer left, Double right) { left % right }
	def dispatch modulo(Integer left, Float right) { left % right }
	def dispatch modulo(Integer left, Long right) { left % right }
	def dispatch modulo(Integer left, Short right) { left % right }
	def dispatch modulo(Integer left, Integer right) { left % right }
	
	def dispatch multiply(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '*' for operands "+left+" and "+right);
	}
	
	
	def dispatch multiply(Byte left, Byte right) { left * right }
	def dispatch multiply(Byte left, Double right) { left * right }
	def dispatch multiply(Byte left, Float right) { left * right }
	def dispatch multiply(Byte left, Long right) { left * right }
	def dispatch multiply(Byte left, Short right) { left * right }
	def dispatch multiply(Byte left, Integer right) { left * right }
	
	def dispatch multiply(Double left, Byte right) { left * right }
	def dispatch multiply(Double left, Double right) { left * right }
	def dispatch multiply(Double left, Float right) { left * right }
	def dispatch multiply(Double left, Long right) { left * right }
	def dispatch multiply(Double left, Short right) { left * right }
	def dispatch multiply(Double left, Integer right) { left * right }
	
	def dispatch multiply(Float left, Byte right) { left * right }
	def dispatch multiply(Float left, Double right) { left * right }
	def dispatch multiply(Float left, Float right) { left * right }
	def dispatch multiply(Float left, Long right) { left * right }
	def dispatch multiply(Float left, Short right) { left * right }
	def dispatch multiply(Float left, Integer right) { left * right }
	
	def dispatch multiply(Long left, Byte right) { left * right }
	def dispatch multiply(Long left, Double right) { left * right }
	def dispatch multiply(Long left, Float right) { left * right }
	def dispatch multiply(Long left, Long right) { left * right }
	def dispatch multiply(Long left, Short right) { left * right }
	def dispatch multiply(Long left, Integer right) { left * right }
	
	def dispatch multiply(Short left, Byte right) { left * right }
	def dispatch multiply(Short left, Double right) { left * right }
	def dispatch multiply(Short left, Float right) { left * right }
	def dispatch multiply(Short left, Long right) { left * right }
	def dispatch multiply(Short left, Short right) { left * right }
	def dispatch multiply(Short left, Integer right) { left * right }
	
	def dispatch multiply(Integer left, Byte right) { left * right }
	def dispatch multiply(Integer left, Double right) { left * right }
	def dispatch multiply(Integer left, Float right) { left * right }
	def dispatch multiply(Integer left, Long right) { left * right }
	def dispatch multiply(Integer left, Short right) { left * right }
	def dispatch multiply(Integer left, Integer right) { left * right }
	
	def dispatch divide(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '/' for operands "+left+" and "+right);
	}
	
	
	def dispatch divide(Byte left, Byte right) { left / right }
	def dispatch divide(Byte left, Double right) { left / right }
	def dispatch divide(Byte left, Float right) { left / right }
	def dispatch divide(Byte left, Long right) { left / right }
	def dispatch divide(Byte left, Short right) { left / right }
	def dispatch divide(Byte left, Integer right) { left / right }
	
	def dispatch divide(Double left, Byte right) { left / right }
	def dispatch divide(Double left, Double right) { left / right }
	def dispatch divide(Double left, Float right) { left / right }
	def dispatch divide(Double left, Long right) { left / right }
	def dispatch divide(Double left, Short right) { left / right }
	def dispatch divide(Double left, Integer right) { left / right }
	
	def dispatch divide(Float left, Byte right) { left / right }
	def dispatch divide(Float left, Double right) { left / right }
	def dispatch divide(Float left, Float right) { left / right }
	def dispatch divide(Float left, Long right) { left / right }
	def dispatch divide(Float left, Short right) { left / right }
	def dispatch divide(Float left, Integer right) { left / right }
	
	def dispatch divide(Long left, Byte right) { left / right }
	def dispatch divide(Long left, Double right) { left / right }
	def dispatch divide(Long left, Float right) { left / right }
	def dispatch divide(Long left, Long right) { left / right }
	def dispatch divide(Long left, Short right) { left / right }
	def dispatch divide(Long left, Integer right) { left / right }
	
	def dispatch divide(Short left, Byte right) { left / right }
	def dispatch divide(Short left, Double right) { left / right }
	def dispatch divide(Short left, Float right) { left / right }
	def dispatch divide(Short left, Long right) { left / right }
	def dispatch divide(Short left, Short right) { left / right }
	def dispatch divide(Short left, Integer right) { left / right }
	
	def dispatch divide(Integer left, Byte right) { left / right }
	def dispatch divide(Integer left, Double right) { left / right }
	def dispatch divide(Integer left, Float right) { left / right }
	def dispatch divide(Integer left, Long right) { left / right }
	def dispatch divide(Integer left, Short right) { left / right }
	def dispatch divide(Integer left, Integer right) { left / right }
	
	def dispatch same(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '==' for operands "+left+" and "+right);
	}
	
	
	def dispatch same(Byte left, Byte right) { left == right }
	def dispatch same(Byte left, Double right) { left == right }
	def dispatch same(Byte left, Float right) { left == right }
	def dispatch same(Byte left, Long right) { left == right }
	def dispatch same(Byte left, Short right) { left == right }
	def dispatch same(Byte left, Integer right) { left == right }
	
	def dispatch same(Double left, Byte right) { left == right }
	def dispatch same(Double left, Double right) { left == right }
	def dispatch same(Double left, Float right) { left == right }
	def dispatch same(Double left, Long right) { left == right }
	def dispatch same(Double left, Short right) { left == right }
	def dispatch same(Double left, Integer right) { left == right }
	
	def dispatch same(Float left, Byte right) { left == right }
	def dispatch same(Float left, Double right) { left == right }
	def dispatch same(Float left, Float right) { left == right }
	def dispatch same(Float left, Long right) { left == right }
	def dispatch same(Float left, Short right) { left == right }
	def dispatch same(Float left, Integer right) { left == right }
	
	def dispatch same(Long left, Byte right) { left == right }
	def dispatch same(Long left, Double right) { left == right }
	def dispatch same(Long left, Float right) { left == right }
	def dispatch same(Long left, Long right) { left == right }
	def dispatch same(Long left, Short right) { left == right }
	def dispatch same(Long left, Integer right) { left == right }
	
	def dispatch same(Short left, Byte right) { left == right }
	def dispatch same(Short left, Double right) { left == right }
	def dispatch same(Short left, Float right) { left == right }
	def dispatch same(Short left, Long right) { left == right }
	def dispatch same(Short left, Short right) { left == right }
	def dispatch same(Short left, Integer right) { left == right }
	
	def dispatch same(Integer left, Byte right) { left == right }
	def dispatch same(Integer left, Double right) { left == right }
	def dispatch same(Integer left, Float right) { left == right }
	def dispatch same(Integer left, Long right) { left == right }
	def dispatch same(Integer left, Short right) { left == right }
	def dispatch same(Integer left, Integer right) { left == right }
	
	def dispatch lessEquals(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '<=' for operands "+left+" and "+right);
	}
	
	
	def dispatch lessEquals(Byte left, Byte right) { left <= right }
	def dispatch lessEquals(Byte left, Double right) { left <= right }
	def dispatch lessEquals(Byte left, Float right) { left <= right }
	def dispatch lessEquals(Byte left, Long right) { left <= right }
	def dispatch lessEquals(Byte left, Short right) { left <= right }
	def dispatch lessEquals(Byte left, Integer right) { left <= right }
	
	def dispatch lessEquals(Double left, Byte right) { left <= right }
	def dispatch lessEquals(Double left, Double right) { left <= right }
	def dispatch lessEquals(Double left, Float right) { left <= right }
	def dispatch lessEquals(Double left, Long right) { left <= right }
	def dispatch lessEquals(Double left, Short right) { left <= right }
	def dispatch lessEquals(Double left, Integer right) { left <= right }
	
	def dispatch lessEquals(Float left, Byte right) { left <= right }
	def dispatch lessEquals(Float left, Double right) { left <= right }
	def dispatch lessEquals(Float left, Float right) { left <= right }
	def dispatch lessEquals(Float left, Long right) { left <= right }
	def dispatch lessEquals(Float left, Short right) { left <= right }
	def dispatch lessEquals(Float left, Integer right) { left <= right }
	
	def dispatch lessEquals(Long left, Byte right) { left <= right }
	def dispatch lessEquals(Long left, Double right) { left <= right }
	def dispatch lessEquals(Long left, Float right) { left <= right }
	def dispatch lessEquals(Long left, Long right) { left <= right }
	def dispatch lessEquals(Long left, Short right) { left <= right }
	def dispatch lessEquals(Long left, Integer right) { left <= right }
	
	def dispatch lessEquals(Short left, Byte right) { left <= right }
	def dispatch lessEquals(Short left, Double right) { left <= right }
	def dispatch lessEquals(Short left, Float right) { left <= right }
	def dispatch lessEquals(Short left, Long right) { left <= right }
	def dispatch lessEquals(Short left, Short right) { left <= right }
	def dispatch lessEquals(Short left, Integer right) { left <= right }
	
	def dispatch lessEquals(Integer left, Byte right) { left <= right }
	def dispatch lessEquals(Integer left, Double right) { left <= right }
	def dispatch lessEquals(Integer left, Float right) { left <= right }
	def dispatch lessEquals(Integer left, Long right) { left <= right }
	def dispatch lessEquals(Integer left, Short right) { left <= right }
	def dispatch lessEquals(Integer left, Integer right) { left <= right }
	
	def dispatch greaterEquals(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '>=' for operands "+left+" and "+right);
	}
	
	
	def dispatch greaterEquals(Byte left, Byte right) { left >= right }
	def dispatch greaterEquals(Byte left, Double right) { left >= right }
	def dispatch greaterEquals(Byte left, Float right) { left >= right }
	def dispatch greaterEquals(Byte left, Long right) { left >= right }
	def dispatch greaterEquals(Byte left, Short right) { left >= right }
	def dispatch greaterEquals(Byte left, Integer right) { left >= right }
	
	def dispatch greaterEquals(Double left, Byte right) { left >= right }
	def dispatch greaterEquals(Double left, Double right) { left >= right }
	def dispatch greaterEquals(Double left, Float right) { left >= right }
	def dispatch greaterEquals(Double left, Long right) { left >= right }
	def dispatch greaterEquals(Double left, Short right) { left >= right }
	def dispatch greaterEquals(Double left, Integer right) { left >= right }
	
	def dispatch greaterEquals(Float left, Byte right) { left >= right }
	def dispatch greaterEquals(Float left, Double right) { left >= right }
	def dispatch greaterEquals(Float left, Float right) { left >= right }
	def dispatch greaterEquals(Float left, Long right) { left >= right }
	def dispatch greaterEquals(Float left, Short right) { left >= right }
	def dispatch greaterEquals(Float left, Integer right) { left >= right }
	
	def dispatch greaterEquals(Long left, Byte right) { left >= right }
	def dispatch greaterEquals(Long left, Double right) { left >= right }
	def dispatch greaterEquals(Long left, Float right) { left >= right }
	def dispatch greaterEquals(Long left, Long right) { left >= right }
	def dispatch greaterEquals(Long left, Short right) { left >= right }
	def dispatch greaterEquals(Long left, Integer right) { left >= right }
	
	def dispatch greaterEquals(Short left, Byte right) { left >= right }
	def dispatch greaterEquals(Short left, Double right) { left >= right }
	def dispatch greaterEquals(Short left, Float right) { left >= right }
	def dispatch greaterEquals(Short left, Long right) { left >= right }
	def dispatch greaterEquals(Short left, Short right) { left >= right }
	def dispatch greaterEquals(Short left, Integer right) { left >= right }
	
	def dispatch greaterEquals(Integer left, Byte right) { left >= right }
	def dispatch greaterEquals(Integer left, Double right) { left >= right }
	def dispatch greaterEquals(Integer left, Float right) { left >= right }
	def dispatch greaterEquals(Integer left, Long right) { left >= right }
	def dispatch greaterEquals(Integer left, Short right) { left >= right }
	def dispatch greaterEquals(Integer left, Integer right) { left >= right }
	
	def dispatch notSame(Object left, Object right) {
		throw new ConstantExpressionEvaluationException("Unsupported operator '!=' for operands "+left+" and "+right);
	}
	
	
	def dispatch notSame(Byte left, Byte right) { left != right }
	def dispatch notSame(Byte left, Double right) { left != right }
	def dispatch notSame(Byte left, Float right) { left != right }
	def dispatch notSame(Byte left, Long right) { left != right }
	def dispatch notSame(Byte left, Short right) { left != right }
	def dispatch notSame(Byte left, Integer right) { left != right }
	
	def dispatch notSame(Double left, Byte right) { left != right }
	def dispatch notSame(Double left, Double right) { left != right }
	def dispatch notSame(Double left, Float right) { left != right }
	def dispatch notSame(Double left, Long right) { left != right }
	def dispatch notSame(Double left, Short right) { left != right }
	def dispatch notSame(Double left, Integer right) { left != right }
	
	def dispatch notSame(Float left, Byte right) { left != right }
	def dispatch notSame(Float left, Double right) { left != right }
	def dispatch notSame(Float left, Float right) { left != right }
	def dispatch notSame(Float left, Long right) { left != right }
	def dispatch notSame(Float left, Short right) { left != right }
	def dispatch notSame(Float left, Integer right) { left != right }
	
	def dispatch notSame(Long left, Byte right) { left != right }
	def dispatch notSame(Long left, Double right) { left != right }
	def dispatch notSame(Long left, Float right) { left != right }
	def dispatch notSame(Long left, Long right) { left != right }
	def dispatch notSame(Long left, Short right) { left != right }
	def dispatch notSame(Long left, Integer right) { left != right }
	
	def dispatch notSame(Short left, Byte right) { left != right }
	def dispatch notSame(Short left, Double right) { left != right }
	def dispatch notSame(Short left, Float right) { left != right }
	def dispatch notSame(Short left, Long right) { left != right }
	def dispatch notSame(Short left, Short right) { left != right }
	def dispatch notSame(Short left, Integer right) { left != right }
	
	def dispatch notSame(Integer left, Byte right) { left != right }
	def dispatch notSame(Integer left, Double right) { left != right }
	def dispatch notSame(Integer left, Float right) { left != right }
	def dispatch notSame(Integer left, Long right) { left != right }
	def dispatch notSame(Integer left, Short right) { left != right }
def dispatch notSame(Integer left, Integer right) { left != right }

}