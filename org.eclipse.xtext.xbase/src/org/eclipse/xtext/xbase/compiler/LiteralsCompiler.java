/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler;

import static org.eclipse.xtext.util.JavaVersion.*;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class LiteralsCompiler extends TypeConvertingCompiler {

	@Inject
	private NumberLiterals numberLiterals;
	
	@Override
	protected void internalToConvertedExpression(XExpression obj, ITreeAppendable appendable) {
		if (obj instanceof XStringLiteral) {
			_toJavaExpression((XStringLiteral) obj, appendable);
		} else if (obj instanceof XNumberLiteral) {
			_toJavaExpression((XNumberLiteral) obj, appendable);
		} else if (obj instanceof XNullLiteral) {
			_toJavaExpression((XNullLiteral) obj, appendable);
		} else if (obj instanceof XBooleanLiteral) {
			_toJavaExpression((XBooleanLiteral) obj, appendable);
		} else if (obj instanceof XTypeLiteral) {
			_toJavaExpression((XTypeLiteral) obj, appendable);
		} else {
			super.internalToConvertedExpression(obj, appendable);
		}
	}
	
	@Override
	protected void doInternalToJavaStatement(XExpression obj, ITreeAppendable appendable, boolean isReferenced) {
		if (obj instanceof XStringLiteral) {
			_toJavaStatement((XStringLiteral) obj, appendable, isReferenced);
		} else if (obj instanceof XNumberLiteral) {
			_toJavaStatement((XNumberLiteral) obj, appendable, isReferenced);
		} else if (obj instanceof XNullLiteral) {
			_toJavaStatement((XNullLiteral) obj, appendable, isReferenced);
		} else if (obj instanceof XBooleanLiteral) {
			_toJavaStatement((XBooleanLiteral) obj, appendable, isReferenced);
		} else if (obj instanceof XTypeLiteral) {
			_toJavaStatement((XTypeLiteral) obj, appendable, isReferenced);
		} else {
			super.doInternalToJavaStatement(obj, appendable, isReferenced);
		}
	}
	
	public void _toJavaExpression(XStringLiteral expr, ITreeAppendable b) {
		toJavaExpression(expr, b, true);
	}

	/**
	 * @since 2.4
	 */
	protected void toJavaExpression(XStringLiteral literal, ITreeAppendable appendable, boolean useUnicodeEscapes) {
		LightweightTypeReference type = getLightweightType(literal);
		if (type.isType(Character.TYPE)) {
			String javaString = Strings.convertToJavaString(literal.getValue(), useUnicodeEscapes);
			appendable.append("'").append(javaString).append("'");
		} else if (type.isType(Character.class)) {
			String javaString = Strings.convertToJavaString(literal.getValue(), useUnicodeEscapes);
			appendable.append("Character.valueOf('").append(javaString).append("')");
		} else {
			String javaString = Strings.convertToJavaString(literal.getValue(), useUnicodeEscapes);
			appendable.append("\"").append(javaString).append("\"");
		}
	}
	
	public void _toJavaStatement(final XStringLiteral expr, ITreeAppendable b, boolean isReferenced) {
		toJavaStatement(expr, b, isReferenced, true);
	}

	/**
	 * @since 2.4
	 */
	protected void toJavaStatement(final XStringLiteral expr, ITreeAppendable b, boolean isReferenced, final boolean useUnicodeEscapes) {
		generateComment(new Later() {
			@Override
			public void exec(ITreeAppendable appendable) {
				// we have to escape closing comments in string literals
				String escapedClosingComments = expr.getValue().replace("*/", "* /");
				String javaString = Strings.convertToJavaString(escapedClosingComments, useUnicodeEscapes);
				appendable.append("\"").append(javaString).append("\"");
			}
		}, b, isReferenced);
	}

	protected void generateComment(final XExpression expr, ITreeAppendable b, boolean isReferenced) {
		generateComment(new Later() {
			@Override
			public void exec(ITreeAppendable appendable) {
				internalToJavaExpression(expr, appendable);
			}
		}, b, isReferenced);
	}
	
	protected void generateComment(Later expr, ITreeAppendable b, boolean isReferenced) {
		if (!isReferenced) {
			b.newLine().append("/* ");
			try {
				expr.exec(b);
			} finally {
				b.append(" */");
			}
		}
	}

	public void _toJavaExpression(XNumberLiteral expr, ITreeAppendable b) {
		LightweightTypeReference type = getLightweightType(expr);
		if(type.isType(BigInteger.class)) {
			BigInteger value = numberLiterals.toBigInteger(expr);
			if (BigInteger.ZERO.equals(value)) {
				b.append(type.getType()).append(".ZERO");
			} else if (BigInteger.ONE.equals(value)) {
				b.append(type.getType()).append(".ONE");
			} else if (BigInteger.TEN.equals(value)) {
				b.append(type.getType()).append(".TEN");
			} else {
				long longValue = value.longValue();
				int base = numberLiterals.getBase(expr); 
				if (base == 10 && BigInteger.valueOf(longValue).equals(value)) {
					b.append(type.getType()).append(".valueOf(").append(Long.toString(longValue)).append("L)");
				} else {
					String digits = numberLiterals.getDigits(expr);
					String exponent = numberLiterals.getExponent(expr, digits);
					if (exponent != null) {
						if (exponent.length() == 1) {
							exponent = null;
							digits = value.toString(base);
						} else {
							int e = digits.indexOf('e');
							if (e == -1) {
								e = digits.indexOf('E');
							}
							digits = digits.substring(0, e);
						}
					}
					final boolean fracturedDigits = digits.contains(".");
					if (fracturedDigits) {
						b.append("new ").append(BigDecimal.class).append("(\"")
						.append(digits).append("\"");
						if (base != 10) {
							b.append(", ").append(Integer.toString(base));
						}
					} else {
						b.append("new ").append(type.getType()).append("(\"")
						.append(digits).append("\"");
						if (base != 10) {
							b.append(", ").append(Integer.toString(base));
						}
					}
					b.append(")");
					if (exponent != null) {
						int exponentAsInt = Integer.parseInt(exponent, base);
						String exponentAsString = null;
						if (base == 16) {
							exponentAsString = "0x" + Integer.toString(exponentAsInt, base);
						} else {
							exponentAsString = Integer.toString(exponentAsInt);
						}
						if (fracturedDigits) {
							b.append(".multiply(").append(BigDecimal.class).append(".TEN.pow(").append(exponentAsString).append(")).toBigInteger()");
						} else {
							b.append(".multiply(").append(type.getType()).append(".TEN.pow(").append(exponentAsString).append("))");
						}
					}
				}
			}
		} else if(type.isType(BigDecimal.class)) {
			BigDecimal value = numberLiterals.toBigDecimal(expr);
			if (BigDecimal.ZERO.equals(value)) {
				b.append(type.getType()).append(".ZERO");
			} else if (BigDecimal.ONE.equals(value)) {
				b.append(type.getType()).append(".ONE");
			} else if (BigDecimal.TEN.equals(value)) {
				b.append(type.getType()).append(".TEN");
			} else {
				long longValue = value.longValue();
				if (numberLiterals.getBase(expr) == 10 && BigDecimal.valueOf(longValue).equals(value)) {
					b.append(type.getType()).append(".valueOf(").append(Long.toString(longValue)).append("L)");
				} else {
					b.append("new ").append(type.getType()).append("(\"")
						.append(numberLiterals.getDigits(expr)).append("\")");
				}
			}
		} else {
			GeneratorConfig config = b.getGeneratorConfig();
			if (config != null && config.getJavaSourceVersion().isAtLeast(JAVA7)) {
				b.append(numberLiterals.toJavaLiteral(expr, false));
			} else {
				b.append(numberLiterals.toJavaLiteral(expr, true));
			}
		}
	}
	
	public void _toJavaStatement(XNumberLiteral expr, ITreeAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}

	/**
	 * @param expr the expression. Used by the dispatch strategy.
	 */
	public void _toJavaExpression(XNullLiteral expr, ITreeAppendable b) {
		b.append("null");
	}
	
	public void _toJavaStatement(XNullLiteral expr, ITreeAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}

	public void _toJavaExpression(XBooleanLiteral expr, ITreeAppendable b) {
		b.append(Boolean.toString(expr.isIsTrue()));
	}
	
	public void _toJavaStatement(XBooleanLiteral expr, ITreeAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}

	public void _toJavaExpression(XTypeLiteral expr, ITreeAppendable b) {
		b.append(expr.getType()).append(Joiner.on("").join(expr.getArrayDimensions())).append(".class");
	}
	
	public void _toJavaStatement(XTypeLiteral expr, ITreeAppendable b, boolean isReferenced) {
		generateComment(expr, b, isReferenced);
	}
	
	@Override
	protected boolean isVariableDeclarationRequired(XExpression expr, ITreeAppendable b, boolean recursive) {
		if (expr instanceof XBooleanLiteral
			|| expr instanceof XStringLiteral
			|| expr instanceof XNumberLiteral
			|| expr instanceof XTypeLiteral
			|| expr instanceof XClosure
			|| expr instanceof XNullLiteral)
			return false;
		return super.isVariableDeclarationRequired(expr,b, recursive);
	}
	
}
