/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2;

/**
 * An {@link IHiddenRegionFormatter} is used to build a formatting setting for a hidden region.
 * 
 * @see IHiddenRegionFormatting
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.7
 */
public interface IHiddenRegionFormatter {
	final int HIGH_PRIORITY = 1;
	final int LOW_PRIORITY = -1;
	final int NORMAL_PRIORITY = 0;

	/**
	 * Configure autowrap. Same as {@link #autowrap(int) autowrap(0)}.
	 */
	void autowrap();

	/**
	 * Configure autowrap. The triggerLength allows to shift the wrapping point beyond its actual position in the file.
	 * If a line has multiple wrapping points it will scan backwards for the first autowrapped region. The triggerLength
	 * moves this region logically such it will be found earlier.
	 */
	void autowrap(int triggerLength);

	/**
	 * Suppresses auto wrap in this hidden region.
	 */
	void noAutowrap();

	/**
	 * Callback if autowrapping was applied.
	 */
	void setOnAutowrap(IAutowrapFormatter formatter);

	/**
	 * Returns teh current formatter request and allows to read configuration settings.
	 */
	FormatterRequest getRequest();

	/**
	 * When merging, treat this configuration with a high priority.
	 * 
	 * @see #lowPriority()
	 * @see #HIGH_PRIORITY
	 */
	void highPriority();

	/**
	 * When merging, treat this configuration with a low priority.
	 * 
	 * @see #highPriority()
	 * @see #LOW_PRIORITY
	 */
	void lowPriority();

	/**
	 * Sets the priority of this formatting configuration. Used when two configurations should be merged. The priority
	 * of this formatter; the default value is {@link #NORMAL_PRIORITY}.
	 */
	void setPriority(int priority);

	/**
	 * Resets the indentation level to zero.
	 */
	void noIndentation();

	void indent();

	/**
	 * Forces a line break in this hidden region. Same as {@link #setNewLines(int) setNewLines(1)}.
	 */
	void newLine();

	/**
	 * Forces the number of newlines in this hidden region. Same as {@link #setNewLines(int, int, int) setNewLines(nl,
	 * nl, nl)}
	 */
	void setNewLines(int newLines);

	/**
	 * Configures the given new lines for this hidden region. Keeps the current configuration if it is in the valid
	 * boundaries of {@code minNewLines} and {@code maxNewLines}. Applies {@code defaultNewLines} otherwise.
	 */
	void setNewLines(int minNewLines, int defaultNewLines, int maxNewLines);

	/**
	 * Format this hidden region with using no space (zero characters). Same as {@link #setSpace(String) setSpace("")}.
	 */
	void noSpace();

	/**
	 * One space is added at this hidden region. Same as {@link #setSpace(String) setSpace(" ")}.
	 */
	void oneSpace();

	/**
	 * The given space is used for this hidden region.
	 */
	void setSpace(String space);

}