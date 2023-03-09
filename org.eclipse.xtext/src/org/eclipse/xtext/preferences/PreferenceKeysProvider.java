/*******************************************************************************
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import static com.google.common.collect.Sets.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.26
 */
public class PreferenceKeysProvider {
	
	private final static Logger log = Logger.getLogger(PreferenceKeysProvider.class);

	public static Set<? extends PreferenceKey> allConstantKeys(Class<?>...constantsContainer) {
		Set<PreferenceKey> result = newLinkedHashSet();
		for (Class<?> container : constantsContainer) {
			Field[] fields = container.getFields();
			for (Field field : fields) {
				if (Modifier.isStatic(field.getModifiers())) {
					Object fieldValue;
					try {
						fieldValue = field.get(null);
						if (fieldValue instanceof PreferenceKey) {
							result.add((PreferenceKey) fieldValue);
						}
					} catch (IllegalArgumentException e) {
						log.error(e.getMessage(),e);
					} catch (IllegalAccessException e) {
						log.error(e.getMessage(),e);
					}
				}
			}
		}
		return result;
	}
}
