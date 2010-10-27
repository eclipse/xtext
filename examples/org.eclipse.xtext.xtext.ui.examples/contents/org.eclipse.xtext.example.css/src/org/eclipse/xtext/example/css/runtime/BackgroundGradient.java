package org.eclipse.xtext.example.css.runtime;

import java.util.List;

import com.google.inject.internal.Lists;

public class BackgroundGradient {
	private final List<Object> colors = Lists.newArrayList();
	private final List<Integer> percents = Lists.newArrayList();

	public void addColor(Object color) {
		colors.add(color);
	}

	public void addPercent(Integer percent) {
		percents.add(percent);
	}

	public List<Object> getColors() {
		return colors;
	}

	public List<Integer> getPercents() {
		return percents;
	}
}
