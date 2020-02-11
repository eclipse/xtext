/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Collections;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LoggingGeneratorFragment extends DefaultGeneratorFragment {

	private static final Logger log = Logger.getLogger(LoggingGeneratorFragment.class);

	private String message;

	private Level level = Level.INFO;

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		if (message != null)
			log.log(level, message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	/**
	 * @since 2.1
	 */
	public void setLevelName(String level) {
		this.level = Level.toLevel(level);
	}

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
	}

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
	}

	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return Collections.emptySet();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return Collections.emptySet();
	}

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return Strings.EMPTY_ARRAY;
	}

}
