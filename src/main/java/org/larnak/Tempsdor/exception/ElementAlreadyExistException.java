package org.larnak.Tempsdor.exception;

public class ElementAlreadyExistException extends Exception{

    private final Object id;
    private final Class<?> clazz;

    public ElementAlreadyExistException(Object id, Class<?> clazz) {
        super("Element already exist" +
                "\n\t- class : " + clazz.getSimpleName() +
                "\n\t-id : " + id);
        this.id = id;
        this.clazz = clazz;
    }
}
