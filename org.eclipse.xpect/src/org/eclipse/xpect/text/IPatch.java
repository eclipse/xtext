package org.eclipse.xpect.text;

import java.util.Collection;

/**
 * 
 * @author Moritz Eysholdt
 */
public interface IPatch extends IChange {
	Collection<IChange> getChanges();
}
