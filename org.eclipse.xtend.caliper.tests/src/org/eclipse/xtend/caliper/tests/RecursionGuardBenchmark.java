package org.eclipse.xtend.caliper.tests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;

import com.google.caliper.Param;
import com.google.caliper.Runner;
import com.google.caliper.SimpleBenchmark;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RecursionGuardBenchmark extends SimpleBenchmark {
	
	interface Guard {
		boolean tryNext(JvmTypeParameter typeParameter);
		void done(JvmTypeParameter typeParameter);
		void clear();
	}
	
	enum Impl {
		HashSet {
			@Override
			Guard createGuard(int size) {
				final Set<JvmTypeParameter> set = new HashSet<JvmTypeParameter>(size);
				return new Guard() {
					@Override
					public boolean tryNext(JvmTypeParameter typeParameter) {
						return set.add(typeParameter);
					}
					@Override
					public void done(JvmTypeParameter typeParameter) {
						set.remove(typeParameter);
					}
					@Override
					public void clear() {
						set.clear();
					}
				};
			}
		},
		RecursionGuard {
			@Override
			Guard createGuard(int size) {
				final RecursionGuard<JvmTypeParameter> implementation = new RecursionGuard<JvmTypeParameter>();
				return new Guard() {

					@Override
					public boolean tryNext(JvmTypeParameter typeParameter) {
						return implementation.tryNext(typeParameter);
					}

					@Override
					public void done(JvmTypeParameter typeParameter) {
						implementation.done(typeParameter);
					}
					
					@Override
					public void clear() {
						implementation.clear();
					}
				};
			}
		},
		ArrayList {
			@Override
			Guard createGuard(int size) {
				List<JvmTypeParameter> list = new ArrayList<JvmTypeParameter>(size);
				return createListGuard(list);
			}
		},
		BasicEList {
			@Override
			Guard createGuard(int size) {
				List<JvmTypeParameter> list = new BasicEList<JvmTypeParameter>(size);
				return createListGuard(list);
			}
		},
		BasicEListFastCompare {
			@Override
			Guard createGuard(int size) {
				List<JvmTypeParameter> list = new BasicEList.FastCompare<JvmTypeParameter>(size);
				return createListGuard(list);
			}
		},
		LinkedList {
			@Override
			Guard createGuard(int size) {
				final LinkedList<JvmTypeParameter> list = new LinkedList<JvmTypeParameter>();
				return new Guard() {

					@Override
					public boolean tryNext(JvmTypeParameter typeParameter) {
						if (list.contains(typeParameter)) {
							return false;
						}
						list.addFirst(typeParameter);
						return true;
					}

					@Override
					public void done(JvmTypeParameter typeParameter) {
						list.remove(typeParameter);
					}
					
					@Override
					public void clear() {
						list.clear();
					}
				};
			}
		},
		;
		abstract Guard createGuard(int size);
		Guard createListGuard(final List<JvmTypeParameter> list) {
			return new Guard() {

				@Override
				public boolean tryNext(JvmTypeParameter typeParameter) {
					if (list.contains(typeParameter)) {
						return false;
					}
					list.add(typeParameter);
					return true;
				}

				@Override
				public void done(JvmTypeParameter typeParameter) {
					int idx = list.lastIndexOf(typeParameter);
					list.remove(idx);
				}
				
				@Override
				public void clear() {
					list.clear();
				}
				
			};
		}
	}
	
	@Param({ "1", "2", "3", "5", "10", "15", "20" })
	int size;
	
	@Param
	Impl implementation;
	
	private Guard populatedGuard;
	
	private ArrayList<JvmTypeParameter> parameters;

	@Override
	protected void setUp() throws Exception {
		parameters = new ArrayList<JvmTypeParameter>();
		for (int i = 0; i < size; i++) {
			parameters.add(TypesFactory.eINSTANCE.createJvmTypeParameter());
		}
		populatedGuard = createGuard();
	}
	
	public int timePopulateGuard(int reps) {
		int result = 0;
		Guard guard = implementation.createGuard(size);
		for(int i = 0; i < reps; i++) {
			for(int j = size -1; j >= 0; j--) {
				if (guard.tryNext(parameters.get(j))) {
					result++;
				}
			}
			guard.clear();
		}
		return result;
	}
	
	public void timeGuardAsStack(int reps) {
		Guard guard = implementation.createGuard(size);
		for(int j = 0; j < reps; j++) {
			for(int i = 0; i < size; i++) {
				guard.tryNext(parameters.get(i));
			}
			for(int i = size - 1; i >= 0; i--) {
				guard.done(parameters.get(i));
			}
		}
	}
	
	public int timeTryNextFailsAvg(int reps) {
		JvmTypeParameter candidate = parameters.get(size / 2);
		int result = 0;
		for(int i = 0; i < reps; i++) {
			if (populatedGuard.tryNext(candidate)) {
				result++;
			}
		}
		return result;
	}

	public int timeTryNextFailsLast(int reps) {
		JvmTypeParameter candidate = parameters.get(size - 1);
		int result = 0;
		for(int i = 0; i < reps; i++) {
			if (populatedGuard.tryNext(candidate)) {
				result++;
			}
		}
		return result;
	}
	
	public int timeTryNextFailsFast(int reps) {
		JvmTypeParameter candidate = parameters.get(0);
		int result = 0;
		for(int i = 0; i < reps; i++) {
			if (populatedGuard.tryNext(candidate)) {
				result++;
			}
		}
		return result;
	}
	
	protected Guard createGuard() {
		Guard guard = implementation.createGuard(size);
		for(int i = size -1; i >= 0; i--) {
			guard.tryNext(parameters.get(i));
		}
		return guard;
	}
	
	public static void main(String[] args) {
		Runner.main(RecursionGuardBenchmark.class, args);
	}
	
}
