package br.com.todo.utils;

public interface Service<T> {
	public T save(T element);
	public T update(T element);
	public Iterable<T> listAll();
	public void remove(Long id);
}
