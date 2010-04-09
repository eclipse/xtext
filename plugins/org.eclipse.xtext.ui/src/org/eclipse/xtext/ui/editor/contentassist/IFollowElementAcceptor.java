/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.xtext.AbstractElement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IFollowElementAcceptor {
	
	void accept(AbstractElement element);
	
	public static class NullSafeElementAcceptor implements IFollowElementAcceptor {

		private final IFollowElementAcceptor decorated;

		public NullSafeElementAcceptor(IFollowElementAcceptor decorated) {
			this.decorated = decorated;
		}

		public void accept(AbstractElement element) {
			if (element != null)
				decorated.accept(element);
		}

	}

}