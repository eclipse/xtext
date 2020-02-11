/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugUtil {

	private static String getKey(String suffix) {
		return DebugUtil.class.getPackage().getName()+ "." + suffix;
	}

	public static boolean readDebugConfig(String key) {
		return Boolean.getBoolean(getKey(key)) || Boolean.getBoolean(getKey("All"));
	}

	public static final String INPUT_DEBUG_KEY = "Input";
	public static final String MARKER_FACTORY_DEBUG_KEY = "MarkerFactory";
	public static final String TOKEN_ACCEPTOR_DEBUG_KEY = "TokenAcceptor";
	public static final String HIDDEN_TOKEN_HANDLER_DEBUG_KEY = "HiddenTokenHandler";
	public static final String CONSUMER_UTIL_DEBUG_KEY = "ConsumerUtil";
	public static final String PARSE_RESULT_FACTORY_DEBUG_KEY = "ParseResultFactory";
	public static final String BACKTRACKER_DEBUG_KEY = "Backtracker";

	public static boolean INPUT_DEBUG = DebugUtil.readDebugConfig(INPUT_DEBUG_KEY);
	public static boolean MARKER_FACTORY_DEBUG = DebugUtil.readDebugConfig(MARKER_FACTORY_DEBUG_KEY);
	public static boolean TOKEN_ACCEPTOR_DEBUG = DebugUtil.readDebugConfig(TOKEN_ACCEPTOR_DEBUG_KEY);
	public static boolean HIDDEN_TOKEN_HANDLER_DEBUG = DebugUtil.readDebugConfig(HIDDEN_TOKEN_HANDLER_DEBUG_KEY);
	public static boolean CONSUMER_UTIL_DEBUG = DebugUtil.readDebugConfig(CONSUMER_UTIL_DEBUG_KEY);
	public static boolean PARSE_RESULT_FACTORY_DEBUG = DebugUtil.readDebugConfig(PARSE_RESULT_FACTORY_DEBUG_KEY);
	public static boolean BACKTRACKER_DEBUG = DebugUtil.readDebugConfig(BACKTRACKER_DEBUG_KEY);

}
