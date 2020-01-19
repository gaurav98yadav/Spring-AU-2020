package com.accolite.triconsumer;
@FunctionalInterface
public interface TriConsumerInterface<T,U,V>
{
	void apply(T t, U u, V v);
}
