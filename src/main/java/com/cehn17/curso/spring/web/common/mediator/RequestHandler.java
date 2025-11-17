package com.cehn17.curso.spring.web.common.mediator;

public interface RequestHandler<T extends Request<R>,R> {

    R handle(T request);

    Class<T> getRequestType();
}
