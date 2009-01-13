/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITerminalConsumer {
	
	boolean consume(String feature, boolean isMany, boolean isBoolean, AbstractElement element, ISequenceMatcher notMatching);
	
	boolean consume(ISequenceMatcher notMatching);
	
	void setHidden(boolean hidden);
	
	boolean isHidden();

}