/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @deprecated use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition} instead
 */
@Deprecated
public class LightweightPosition extends org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition {

	/**
	 * @deprecated use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition.IntToStringArray} instead
	 */
	@Deprecated
	public static class IntToStringArray extends org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition.IntToStringArray {
		
		public IntToStringArray(int timestamp, String... ids) {
			super(timestamp, ids);
		}

	}
	
	public LightweightPosition(int offset, int length, int timestamp, String... ids) {
		this(offset, length, timestamp, new IntToStringArray[] { new IntToStringArray(timestamp, ids) });
	}
	
	public LightweightPosition(int offset, int length, int timestamp, IntToStringArray[] ids) {
		super(offset, length, timestamp, ids);
	}
	
	@Override
	public void merge(int timestamp, String... other) {
		merge(new IntToStringArray[] { new IntToStringArray(timestamp, other) });
	}

	public void merge(IntToStringArray[] other) {
		super.merge(other);
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	protected IntToStringArray[] createArray(int len) {
		return new IntToStringArray[len];
	}
}
