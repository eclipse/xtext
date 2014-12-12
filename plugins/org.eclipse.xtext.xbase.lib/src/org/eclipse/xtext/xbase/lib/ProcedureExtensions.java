/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure3;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure4;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure5;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure6;

import com.google.common.annotations.GwtCompatible;

/**
 * This is an extension library for {@link Procedures procedures}, e.g. side-effect only-closures.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @see Procedures
 */
@GwtCompatible public class ProcedureExtensions {

	/**
	 * Curries a procedure that takes one argument.
	 * 
	 * @param procedure
	 *            the original procedure. May not be <code>null</code>.
	 * @param argument
	 *            the fixed argument.
	 * @return a procedure that takes no arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1> Procedure0 curry(final Procedure1<? super P1> procedure, final P1 argument) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		return new Procedure0() {
			@Override
			public void apply() {
				procedure.apply(argument);
			}
		};
	}

	/**
	 * Curries a procedure that takes two arguments.
	 * 
	 * @param procedure
	 *            the original procedure. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code procedure}.
	 * @return a procedure that takes one argument. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2> Procedure1<P2> curry(final Procedure2<? super P1, ? super P2> procedure, final P1 argument) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		return new Procedure1<P2>() {
			@Override
			public void apply(P2 p) {
				procedure.apply(argument, p);
			}
		};
	}

	/**
	 * Curries a procedure that takes three arguments.
	 * 
	 * @param procedure
	 *            the original procedure. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code procedure}.
	 * @return a procedure that takes two arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3> Procedure2<P2, P3> curry(final Procedure3<? super P1, ? super P2, ? super P3> procedure, final P1 argument) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		return new Procedure2<P2, P3>() {
			@Override
			public void apply(P2 p2, P3 p3) {
				procedure.apply(argument, p2, p3);
			}
		};
	}

	/**
	 * Curries a procedure that takes four arguments.
	 * 
	 * @param procedure
	 *            the original procedure. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code procedure}.
	 * @return a procedure that takes three arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3, P4> Procedure3<P2, P3, P4> curry(final Procedure4<? super P1, ? super P2, ? super P3, ? super P4> procedure,
			final P1 argument) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		return new Procedure3<P2, P3, P4>() {
			@Override
			public void apply(P2 p2, P3 p3, P4 p4) {
				procedure.apply(argument, p2, p3, p4);
			}
		};
	}

	/**
	 * Curries a procedure that takes five arguments.
	 * 
	 * @param procedure
	 *            the original procedure. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code procedure}.
	 * @return a procedure that takes four arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3, P4, P5> Procedure4<P2, P3, P4, P5> curry(final Procedure5<? super P1, ? super P2, ? super P3, ? super P4, ? super P5> procedure,
			final P1 argument) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		return new Procedure4<P2, P3, P4, P5>() {
			@Override
			public void apply(P2 p2, P3 p3, P4 p4, P5 p5) {
				procedure.apply(argument, p2, p3, p4, p5);
			}
		};
	}

	/**
	 * Curries a procedure that takes six arguments.
	 * 
	 * @param procedure
	 *            the original procedure. May not be <code>null</code>.
	 * @param argument
	 *            the fixed first argument of {@code procedure}.
	 * @return a procedure that takes five arguments. Never <code>null</code>.
	 */
	@Pure
	public static <P1, P2, P3, P4, P5, P6> Procedure5<P2, P3, P4, P5, P6> curry(
			final Procedure6<? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6> procedure, final P1 argument) {
		if (procedure == null)
			throw new NullPointerException("procedure");
		return new Procedure5<P2, P3, P4, P5, P6>() {
			@Override
			public void apply(P2 p2, P3 p3, P4 p4, P5 p5, P6 p6) {
				procedure.apply(argument, p2, p3, p4, p5, p6);
			}
		};
	}
}
