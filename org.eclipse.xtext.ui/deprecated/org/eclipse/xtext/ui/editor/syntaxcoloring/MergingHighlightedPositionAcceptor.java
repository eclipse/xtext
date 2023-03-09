/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.List;

import org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * Accepts a bunch of positions and creates a list
 * of positions from them that do not overlap.
 * 
 * @deprecated use {@link org.eclipse.xtext.ide.editor.syntaxcoloring.MergingHighlightedPositionAcceptor} instead.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class MergingHighlightedPositionAcceptor extends org.eclipse.xtext.ide.editor.syntaxcoloring.MergingHighlightedPositionAcceptor implements IHighlightedPositionAcceptor, ISemanticHighlightingCalculator {

	/**
	 * @since 2.9
	 */
	static class Adapter implements org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator {

		private ISemanticHighlightingCalculator delegate;
		
		public Adapter(ISemanticHighlightingCalculator delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public void provideHighlightingFor(XtextResource resource,
				org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
			delegate.provideHighlightingFor(resource, cast(acceptor));
		}
		
		private IHighlightedPositionAcceptor cast(org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
			return (IHighlightedPositionAcceptor) acceptor;
		}
		
	}
	
	/**
	 * @since 2.9
	 */
	public MergingHighlightedPositionAcceptor(org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator delegate) {
		super(delegate);
	}
	
	/**
	 * @deprecated use MergingHighlightedPositionAcceptor(org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator) instead
	 */
	@Deprecated
	public MergingHighlightedPositionAcceptor(ISemanticHighlightingCalculator delegate) {
		super(new Adapter(delegate));
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	public void provideHighlightingFor(XtextResource resource,
			org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		provideHighlightingFor(resource, cast(acceptor));
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.provideHighlightingFor(resource, IHighlightedPositionAcceptor.DeprecationHelper.upcast(acceptor), CancelIndicator.NullImpl);
	}
	
	private IHighlightedPositionAcceptor cast(org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor acceptor) {
		return IHighlightedPositionAcceptor.DeprecationHelper.cast(acceptor);
	}
	
	/*
	 * Overridden to befriend the API tooling.
	 */
	@Override
	public void mergePositions() {
		super.mergePositions();
	}
	
	/*
	 * Overridden to befriend the API tooling.
	 */
	@Override
	public List<LightweightPosition> getPositions() {
		return super.getPositions();
	}
	
	/*
	 * Overridden to befriend the API tooling.
	 */
	@Override
	public void addPosition(int offset, int length, String... ids) {
		super.addPosition(offset, length, ids);
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	protected LightweightPosition newPosition(int offset, int length, int timestamp, org.eclipse.xtext.ide.editor.syntaxcoloring.LightweightPosition.IntToStringArray[] ids) {
		return new org.eclipse.xtext.ui.editor.syntaxcoloring.LightweightPosition(offset, length, timestamp, 
				(org.eclipse.xtext.ui.editor.syntaxcoloring.LightweightPosition.IntToStringArray[])ids);
	}
	
	/**
	 * @since 2.9
	 */
	@Override
	protected LightweightPosition newPosition(int offset, int length, int timestamp, String... ids) {
		return new org.eclipse.xtext.ui.editor.syntaxcoloring.LightweightPosition(offset, length, timestamp, ids);
	}
	
}
