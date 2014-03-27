package org.eclipse.xtext.m2e;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class Languages implements Iterable<Language> {
	private List<Language> languages = Lists.<Language> newArrayList();

	public void addLanguage(Language lang) {
		this.languages.add(lang);
	}

	public Iterator<Language> iterator() {
		return languages.iterator();
	}
}
