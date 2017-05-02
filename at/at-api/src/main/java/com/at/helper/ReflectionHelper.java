package com.at.helper;


import java.lang.reflect.Field;
import java.util.List;


public interface ReflectionHelper
{

    /**
     * Get field class.
     *
     * @param field - {@link Field}
     * @return {@link Class<?>}
     */
    Class<?> getGenericType(
            Field field);

    /**
     * Get class generic argument.
     *
     * @param clazz - {@link Class<?>}
     * @param argumentPosition - position of argument
     * @return {@link Class<?>}
     */
    Class<?> getGenericArgumentType(
            Class<?> clazz, int argumentPosition);

    /**
     * Create instance.
     *
     * @param clazz - {@link Class<Field>}
     * @return {@link T}
     */
    <T> T createInstance(Class<T> clazz);

    /**
     * Get field class navigating from entityClass using fieldPath.
     *
     * @param entityClazz - {@link Class<?>}
     * @param fieldPath - {@link List<String>}
     * @return {@link Class<?>}
     */
    Class<?> getFieldClass(
            Class<?> entityClazz,
            final List<String> fieldPath);

}
