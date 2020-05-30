package com.gorygon.mongo.api.controller;

public abstract class AbstractRestController<DTO, ENT> {
	protected abstract ENT toEntity( DTO dto);
	protected  abstract DTO toDTO(ENT entity);
}
