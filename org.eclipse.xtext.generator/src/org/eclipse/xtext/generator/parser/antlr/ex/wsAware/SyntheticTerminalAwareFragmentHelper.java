/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr.ex.wsAware;

import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.generator.parser.antlr.ex.common.AntlrFragmentHelper;
import org.eclipse.xtext.generator.serializer.SerializerFragment;
import org.eclipse.xtext.generator.terminals.SyntheticTerminalDetector;

/**
 * This fragment helper can be used to implement whitespace aware grammars.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class SyntheticTerminalAwareFragmentHelper extends AntlrFragmentHelper {

	private SyntheticTerminalDetector detector;
	
	public SyntheticTerminalAwareFragmentHelper(Naming naming) {
		super(naming);
		this.detector = createDetector();
	}

	/**
	 * @since 2.8
	 */
	public SyntheticTerminalAwareFragmentHelper() {
		super();
		this.detector = createDetector();
	}

	/**
	 * Creates a new {@link SyntheticTerminalDetector}. Clients may override.
	 * 
	 * @since 2.8
	 * @see SerializerFragment#setSyntheticTerminalDetector(SyntheticTerminalDetector)
	 */
	protected SyntheticTerminalDetector createDetector() {
		return new SyntheticTerminalDetector();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This implementation answers <code>true</code> for any terminal rule that has a body in the form
	 * <code>terminal MY_TERMINAL: 'synthetic:MY_TERMINAL';</code>.
	 * </p>
	 * 
	 * @see SyntheticTerminalDetector
	 * @see SyntheticTerminalAwareFragmentHelper#createDetector()
	 */
	@Override
	public boolean isSyntheticTerminalRule(TerminalRule rule) {
		return detector.isSyntheticTerminalRule(rule);
	}

}
