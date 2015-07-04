package br.com.calcard.calsystem.entity;

public interface DTOFactory<T> {

	public Object toDTO(T entity);

}
