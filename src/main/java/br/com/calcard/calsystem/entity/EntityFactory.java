package br.com.calcard.calsystem.entity;

import java.util.List;

public interface EntityFactory<T> {

	public T create();

	public List<T> createList(int quantidade);

	public abstract T DTOToEntity(Object object);

}
